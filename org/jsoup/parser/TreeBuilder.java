package org.jsoup.parser;

import org.jsoup.helper.DescendableLinkedList;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Token;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class TreeBuilder {
    protected String baseUri;
    protected Token currentToken;
    protected Document doc;
    protected ParseErrorList errors;
    CharacterReader reader;
    protected DescendableLinkedList<Element> stack;
    Tokeniser tokeniser;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean process(Token token);

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialiseParse(String str, String str2, ParseErrorList parseErrorList) {
        Validate.notNull(str, "String input must not be null");
        Validate.notNull(str2, "BaseURI must not be null");
        this.doc = new Document(str2);
        this.reader = new CharacterReader(str);
        this.errors = parseErrorList;
        this.tokeniser = new Tokeniser(this.reader, parseErrorList);
        this.stack = new DescendableLinkedList<>();
        this.baseUri = str2;
    }

    Document parse(String str, String str2) {
        return parse(str, str2, ParseErrorList.noTracking());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Document parse(String str, String str2, ParseErrorList parseErrorList) {
        initialiseParse(str, str2, parseErrorList);
        runParser();
        return this.doc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void runParser() {
        Token read;
        do {
            read = this.tokeniser.read();
            process(read);
        } while (read.type != Token.TokenType.EOF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Element currentElement() {
        return this.stack.getLast();
    }
}
