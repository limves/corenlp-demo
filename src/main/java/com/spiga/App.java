package com.spiga;

import java.io.IOException;
import java.util.Properties;

import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.AnnotationPipeline;
import edu.stanford.nlp.pipeline.CoNLLOutputter;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

/**
 * Simple Sepparse
 * @author by Lim
 * @version 20170610
 */
public class App {

	public static Properties props() {

		Properties props = new Properties();

		props.put("annotators", "tokenize, ssplit, pos, lemma, ner, depparse");
		props.setProperty("tokenize.language", "es");
		props.setProperty("pos.model", "edu/stanford/nlp/models/pos-tagger/spanish/spanish-distsim.tagger");
		props.setProperty("ner.model", "edu/stanford/nlp/models/ner/spanish.ancora.distsim.s512.crf.ser.gz");
		props.setProperty("parse.model", "edu/stanford/nlp/models/lexparser/spanishPCFG.ser.gz");

		props.setProperty("parse.model", "edu/stanford/nlp/models/lexparser/spanishPCFG.ser.gz");
		props.setProperty("depparse.model", "edu/stanford/nlp/models/parser/nndep/UD_Spanish.gz");
		props.setProperty("depparse.language", "spanish");
		props.setProperty("regexner.mapping", "edu/stanford/nlp/models/kbp/kbp_regexner_mapping_sp.tag");

		return props;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String text;
		text = "Los contribuyentes que expidan y reciban CFDI, deberán almacenarlos en medios magnéticos, ópticos o de cualquier otra tecnología, en su formato electrónico XML.";

		Annotation ann = new Annotation(text);

		AnnotationPipeline pipeline = new StanfordCoreNLP(props());
		pipeline.annotate(ann);

		String conll = new CoNLLOutputter().print(ann).toString();
		// String result = ConllStringToJson(conll);
		System.out.println(conll);

	}
}
