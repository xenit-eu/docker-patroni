# Patroni Docker Image

- [X] Update components
- [X] Add license
- [ ] Update README
- [X] Extend with High Availability setup
- [ ] Add tests for the features to be used in production

## Configuration

### patroni

#### Config directory

This image uses a config directory (/config/patroni) instead of patroni.yaml. All YAML files in this directory are loaded one by one in sorted order.  In case a key is defined in multiple files, the occurrence in the last  file takes precedence. The image contains a basic configuration 00_patroni.yaml. 

Following configuration parameters should be set by the user of this image via environment variables or an additional config file:

- PATRONI_NAME
- PATRONI_SCOPE
- PATRONI_POSTGRESQL_CONNECT_ADDRESS
- PATRONI_RESTAPI_CONNECT_ADDRESS

#### Config file

This image can also be configured with the complete configuration in a config file /config/patroni.yml. If this file exists directory /config/patroni is not used.

### patronictl

This image expects a patronictl.yaml in /config

## Customisation

Scripts can be run after bootstrapping by adding them to /post_init. When the image is configured with a config file instead of a config directory, the config file should contain option "post_init: /post-init.sh" in thte bootstrap section.

---

