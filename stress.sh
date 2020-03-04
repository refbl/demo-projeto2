#!/bin/bash

for i in {1..10000}; do
 curl http://192.168.64.2:30116/cliente/ > teste.txt
 sleep $1

 done