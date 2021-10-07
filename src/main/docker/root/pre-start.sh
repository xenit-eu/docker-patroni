#!/usr/bin/env bash

set -e

echo
echo "Running pre-start scripts"
echo

for f in /pre-start/*; do
    case "$f" in
        *.sh)     echo "$0: running $f"; . "$f" ;;
        *)        echo "$0: ignoring $f" ;;
    esac
    echo
done

echo
echo "Done running pre-start scripts"
echo
