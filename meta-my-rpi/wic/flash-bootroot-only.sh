#!/bin/bash

set -ue

FILE=${1}
OUTPUT=${2:-/dev/sda}
NUM_SECTORS=${3:-2211840}
SECTOR_SIZE=${4:-512}

bzcat ${FILE} |
  dd bs=${SECTOR_SIZE} count=${NUM_SECTORS} |
  sudo dd of=${OUTPUT} bs=10M conv=fsync
