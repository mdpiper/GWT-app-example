[![Build Status](https://travis-ci.org/mdpiper/GWTWebApp.svg?branch=master)](https://travis-ci.org/mdpiper/GWTWebApp)

GWTWebApp
=========

The default [GWT](http://www.gwtproject.org/) web application
with an [Ant](http://ant.apache.org/) build file,
[JUnit](http://junit.org/) testing,
and continuous integration with [Travis CI](https://travis-ci.com/).

My goal in this project is to understand how to set up a GWT application
(like, say, [WMT](https://github.com/csdms/wmt)) with Travis CI.
I've chosen to:

- include JUnit in the project (in **lib/**), though this feels like cheating;
- allow Travis CI to download GWT 2.5.1 (it's 106 MB) and unpack it in `$PWD`.

