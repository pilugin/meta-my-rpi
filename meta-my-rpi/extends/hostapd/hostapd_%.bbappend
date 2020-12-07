FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append_rpi = "\
    file://hostapd.conf \
    file://hostapd.service \
"

do_install_append_rpi() {
    install -m 0644 ${WORKDIR}/hostapd.conf ${D}/etc/hostapd.conf
    install -m 0644 ${WORKDIR}/hostapd.service ${D}/lib/systemd/system/hostapd.service

    install -d ${D}/etc/systemd/system/multi-user.target.wants/
    ln -s /lib/systemd/system/hostapd.service ${D}/etc/systemd/system/multi-user.target.wants/hostapd.service
}