# Patroni Docker Image

- [X] Update components
- [X] Add license
- [ ] Update README
- [X] Extend with High Availability setup
- [ ] Add tests for the features to be used in production

## Configuration

This image uses a config directory (/config/patroni) instead of patroni.yaml. All YAML files in this directory are loaded one by one in sorted order.  In case a key is defined in multiple files, the occurrence in the last  file takes precedence. The image contains a basic configuration 00_patroni.yaml. 

Following configuration parameters should be set by the user of this image via environment variables or an additional config file:

- PATRONI_NAME
- PATRONI_SCOPE
- PATRONI_POSTGRESQL_CONNECT_ADDRESS
- PATRONI_RESTAPI_CONNECT_ADDRESS

## Customisation

Scripts can be run after bootstrapping by adding them to /post_init

---

*Old Readme*

example can be found in docker-compose.yml

This image expects a patroni.yml and patronictl.yaml in /config