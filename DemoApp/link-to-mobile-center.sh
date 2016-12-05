#!/bin/bash
echo 'Installing our npm packages...'
npm install mobile-center-analytics --save
npm install mobile-center-crashes --save
echo 'Linking...'
echo 'Android app secret should be: 13502f6c-53bc-496e-9517-f2454b4e03a5'
echo 'iOS app secret should be: 96638174-9d13-4b2b-a110-1866d6bfa7dc'
react-native link mobile-center-analytics
react-native link mobile-center-crashes
