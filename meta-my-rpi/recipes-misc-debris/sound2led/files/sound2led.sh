#!/bin/sh

LED_ON_CMD="mdio-tool w eth0 0x15 0x155"
LED_OFF_CMD="mdio-tool w eth0 0x15 0x044"

${LED_OFF_CMD}
trap "${LED_OFF_CMD} ; exit" EXIT INT TERM QUIT HUP

while true
do
    if grep -i running /proc/asound/card*/pcm*/sub*/status > /dev/null
    then

        ${LED_ON_CMD}
        sleep 10
        ${LED_OFF_CMD}

    fi

    sleep 0.25
done

