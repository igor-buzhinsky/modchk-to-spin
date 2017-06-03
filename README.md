## Introduction

This tool converts block networks represented in the [NuSMV](http://nusmv.fbk.eu/) format to Promela ([SPIN](http://spinroot.com/)). Block network models need to be represented in a specific format which can be understood by examining the example described below.

## Prerequisites

To build the tool, you need JDK 1.8 (or greater) and [ant](https://ant.apache.org/). Alternatively, you can use the precompiled version ([jars/translator.jar](/jars/translator.jar)). The tool is intended to work on Linux and Windows.

## Building and running

To build the tool, move to the root of the project and run:

> ant

The JAR executable will be generated under the name [jars/translator.jar](/jars/translator.jar). As a single argument, it accepts the path to the directory which contains the model to be translated.
  
Let's examine how the tool works on the "PlusMinus" block network example:

> java -jar jars/translator.jar ./example/

In the subdirectory [example/basic/](/example/basic/), Promela versions of basic block models must be provided in .pml files. In other words: the tool can't help with converting NuSMV basic blocks to Promela. The format of aforementioned .pml files must be Promela except specific headers and footers, see e.g. [example/basic/BINARY_SWITCH.pml](/example/basic/BINARY_SWITCH.pml). Nondeterminism in the code as well as the use of processed is not allowed. In the example, corresponding NuSMV files are also provided for reference.

In the subdirectory [example/composite/](/example/composite/), composite NuSMV models (the ones to be translated to Promela) must be provided. Examine the file [example/composite/plus_minus.smv](/example/composite/plus_minus.smv) to understand the required format. After the tool is executed, it will put corresponding Promela files into this directory.

## Troubleshooting, questions, research collaboration, etc.

You may contact Igor Buzhinsky (igor.buzhinskii@aalto.fi).