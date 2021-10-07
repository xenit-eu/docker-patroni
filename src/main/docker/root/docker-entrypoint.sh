#!/bin/bash

/pre-start.sh

if [[ ! -d "$PGDATA" ]]
then
  mkdir -p "$PGDATA"
fi

if [[ $(stat -c %U "$PGDATA") != 'postgres' ]]
then
  chown -R postgres:postgres "$PGDATA"
fi

if [[ $(stat -c %a "$PGDATA") != '700' ]]
then
  chmod 700 "$PGDATA"
fi

mkdir --parents /root/.config/patroni
ln -s /config/patronictl.yaml /root/.config/patroni/patronictl.yaml


if [[ -f "/config/patroni.yml" ]]; then
  exec gosu postgres /patroni.py /config/patroni.yml
elif [[ -d "/config/patroni" ]]; then
  exec gosu postgres /patroni.py /config/patroni
else
  echo "ERROR - either config directory /config/patroni or config file /config/patroni.yml should exist"
  exit 1
fi

