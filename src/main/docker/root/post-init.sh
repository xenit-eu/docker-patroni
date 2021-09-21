#!/usr/bin/env bash

set -e

echo
echo "Running post-init scripts"
echo "$@"
echo

for f in /post-init/*; do
    case "$f" in
        *.sh)     echo "$0: running $f"; . "$f" "$@" ;;
        *)        echo "$0: ignoring $f" ;;
    esac
    echo
done

echo
echo "Done running post-init scripts"
echo
