GWTWebApp
=========

The default GWT web application with an `ant` build file and
continuous integration with Travis CI.

My goal in this project is to understand how to set up a GWT application
(like, say, [WMT](https://github.com/csdms/wmt)) with Travis CI.
I've chosen to:

- include JUnit in the project (in **lib/**), though this feels like cheating;
- allow Travis CI to download GWT 2.5.1 (it's 106 MB) and unpack it in `$PWD`.
