package org.jsoup.nodes;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Entities;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;
/* loaded from: classes.dex */
public class Document extends Element {
    private String location;
    private OutputSettings outputSettings;
    private QuirksMode quirksMode;

    /* loaded from: classes.dex */
    public enum QuirksMode {
        noQuirks,
        quirks,
        limitedQuirks
    }

    public Document(String str) {
        super(Tag.valueOf("#root"), str);
        this.outputSettings = new OutputSettings();
        this.quirksMode = QuirksMode.noQuirks;
        this.location = str;
    }

    public static Document createShell(String str) {
        Validate.notNull(str);
        Document document = new Document(str);
        Element appendElement = document.appendElement("html");
        appendElement.appendElement("head");
        appendElement.appendElement("body");
        return document;
    }

    public String location() {
        return this.location;
    }

    public Element head() {
        return findFirstElementByTagName("head", this);
    }

    public Element body() {
        return findFirstElementByTagName("body", this);
    }

    public String title() {
        Element first = getElementsByTag("title").first();
        return first != null ? StringUtil.normaliseWhitespace(first.text()).trim() : "";
    }

    public void title(String str) {
        Validate.notNull(str);
        Element first = getElementsByTag("title").first();
        if (first == null) {
            head().appendElement("title").text(str);
        } else {
            first.text(str);
        }
    }

    public Element createElement(String str) {
        return new Element(Tag.valueOf(str), baseUri());
    }

    public Document normalise() {
        Element findFirstElementByTagName = findFirstElementByTagName("html", this);
        if (findFirstElementByTagName == null) {
            findFirstElementByTagName = appendElement("html");
        }
        if (head() == null) {
            findFirstElementByTagName.prependElement("head");
        }
        if (body() == null) {
            findFirstElementByTagName.appendElement("body");
        }
        normaliseTextNodes(head());
        normaliseTextNodes(findFirstElementByTagName);
        normaliseTextNodes(this);
        normaliseStructure("head", findFirstElementByTagName);
        normaliseStructure("body", findFirstElementByTagName);
        return this;
    }

    private void normaliseTextNodes(Element element) {
        ArrayList arrayList = new ArrayList();
        for (Node node : element.childNodes) {
            if (node instanceof TextNode) {
                TextNode textNode = (TextNode) node;
                if (!textNode.isBlank()) {
                    arrayList.add(textNode);
                }
            }
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Node node2 = (Node) arrayList.get(size);
            element.removeChild(node2);
            body().prependChild(new TextNode(" ", ""));
            body().prependChild(node2);
        }
    }

    private void normaliseStructure(String str, Element element) {
        int i = 1;
        Elements elementsByTag = getElementsByTag(str);
        Element first = elementsByTag.first();
        if (elementsByTag.size() > 1) {
            ArrayList<Node> arrayList = new ArrayList();
            while (true) {
                int i2 = i;
                if (i2 >= elementsByTag.size()) {
                    break;
                }
                Element element2 = elementsByTag.get(i2);
                for (Node node : element2.childNodes) {
                    arrayList.add(node);
                }
                element2.remove();
                i = i2 + 1;
            }
            for (Node node2 : arrayList) {
                first.appendChild(node2);
            }
        }
        if (!first.parent().equals(element)) {
            element.appendChild(first);
        }
    }

    private Element findFirstElementByTagName(String str, Node node) {
        if (node.nodeName().equals(str)) {
            return (Element) node;
        }
        for (Node node2 : node.childNodes) {
            Element findFirstElementByTagName = findFirstElementByTagName(str, node2);
            if (findFirstElementByTagName != null) {
                return findFirstElementByTagName;
            }
        }
        return null;
    }

    @Override // org.jsoup.nodes.Node
    public String outerHtml() {
        return super.html();
    }

    @Override // org.jsoup.nodes.Element
    public Element text(String str) {
        body().text(str);
        return this;
    }

    @Override // org.jsoup.nodes.Element, org.jsoup.nodes.Node
    public String nodeName() {
        return "#document";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.jsoup.nodes.Element, org.jsoup.nodes.Node
    public Document clone() {
        Document document = (Document) super.clone();
        document.outputSettings = this.outputSettings.clone();
        return document;
    }

    /* loaded from: classes.dex */
    public class OutputSettings implements Cloneable {
        private Entities.EscapeMode escapeMode = Entities.EscapeMode.base;
        private Charset charset = Charset.forName("UTF-8");
        private CharsetEncoder charsetEncoder = this.charset.newEncoder();
        private boolean prettyPrint = true;
        private boolean outline = false;
        private int indentAmount = 1;

        public Entities.EscapeMode escapeMode() {
            return this.escapeMode;
        }

        public OutputSettings escapeMode(Entities.EscapeMode escapeMode) {
            this.escapeMode = escapeMode;
            return this;
        }

        public Charset charset() {
            return this.charset;
        }

        public OutputSettings charset(Charset charset) {
            this.charset = charset;
            this.charsetEncoder = charset.newEncoder();
            return this;
        }

        public OutputSettings charset(String str) {
            charset(Charset.forName(str));
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public CharsetEncoder encoder() {
            return this.charsetEncoder;
        }

        public boolean prettyPrint() {
            return this.prettyPrint;
        }

        public OutputSettings prettyPrint(boolean z) {
            this.prettyPrint = z;
            return this;
        }

        public boolean outline() {
            return this.outline;
        }

        public OutputSettings outline(boolean z) {
            this.outline = z;
            return this;
        }

        public int indentAmount() {
            return this.indentAmount;
        }

        public OutputSettings indentAmount(int i) {
            Validate.isTrue(i >= 0);
            this.indentAmount = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        public OutputSettings clone() {
            try {
                OutputSettings outputSettings = (OutputSettings) super.clone();
                outputSettings.charset(this.charset.name());
                outputSettings.escapeMode = Entities.EscapeMode.valueOf(this.escapeMode.name());
                return outputSettings;
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public OutputSettings outputSettings() {
        return this.outputSettings;
    }

    public Document outputSettings(OutputSettings outputSettings) {
        Validate.notNull(outputSettings);
        this.outputSettings = outputSettings;
        return this;
    }

    public QuirksMode quirksMode() {
        return this.quirksMode;
    }

    public Document quirksMode(QuirksMode quirksMode) {
        this.quirksMode = quirksMode;
        return this;
    }

    @Override // org.jsoup.nodes.Element, org.jsoup.nodes.Node
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
