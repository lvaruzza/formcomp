#!/usr/bin/env groovy

@Grapes(
  @Grab(group='org.apache.jena', module='jena-core', version='2.13.0')
)

import java.io.*
import com.hp.hpl.jena.rdf.model.ModelFactory
import com.hp.hpl.jena.util.FileManager

// create an empty model
def model = ModelFactory.createDefaultModel();

 // use the FileManager to find the input file
 InputStream inf = FileManager.get().open( "test.rdf" );
if (inf == null) {
    throw new IllegalArgumentException(
                                 "File: " + inputFileName + " not found");
}

// read the RDF/XML file
model.read(inf, null);

// write it to standard out
model.write(System.out);
      