#!/bin/sh

LED_ON_CMD="mdio-tool w eth0 0x15 0x155"
LED_OFF_CMD="mdio-tool w eth0 0x15 0x044"

function blink() {
    COUNT=${1}
    ON_DURATION=${2}
    OFF_DURATION=${3:-${ON_DURATION}}

    for i in $(seq ${COUNT})
    do
        ${LED_ON_CMD}
        sleep ${ON_DURATION}

        ${LED_OFF_CMD}
        sleep ${OFF_DURATION}
    done
}

trap "${LED_OFF_CMD} ; exit" EXIT INT TERM QUIT HUP

blink 20 0.05 0.05

while true
do
    if grep -i running /proc/asound/card*/pcm*/sub*/status > /dev/null
    then
        blink 20 0.25 0.25
    fi

    sleep 0.25
done

