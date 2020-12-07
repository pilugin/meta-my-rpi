DESCRIPTION = "My nice image for Astrophotography"
IMAGE_FEATURES += " package-management x11-base x11 ssh-server-dropbear hwcodecs"
LICENSE = "MIT"

inherit core-image

TOOLCHAIN_HOST_TASK_append = " nativesdk-intltool nativesdk-glib-2.0"
TOOLCHAIN_HOST_TASK_remove_task-populate-sdk-ext = " nativesdk-intltool nativesdk-glib-2.0"

# Installs
NETWORK_INSTALL = "hostapd dhcp-server"

XORG_INSTALL = "fontconfig fontconfig-utils xterm xf86-video-armsoc x11vnc"

DEBUG_INSTALL = "strace nmap"

ASTRO_INSTALL = "phd2 astrodmx"

IMAGE_INSTALL += " ${NETWORK_INSTALL} ${XORG_INSTALL} ${DEBUG_INSTALL} ${ASTRO_INSTALL} \
    custom-configs sound2led"
