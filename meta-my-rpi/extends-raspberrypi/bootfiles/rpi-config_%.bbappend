do_deploy_append() {

    sed -i 's,#dtparam=audio=off,dtparam=audio=on,g' ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt

    cat >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt << EOF
dtparam=eth_led0=4
dtparam=eth_led1=4
EOF

}
