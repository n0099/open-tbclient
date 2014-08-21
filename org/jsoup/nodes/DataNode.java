package org.jsoup.nodes;

import org.jsoup.nodes.Document;
/* loaded from: classes.dex */
public class DataNode extends Node {
    private static final String DATA_KEY = "data";

    public DataNode(String str, String str2) {
        super(str2);
        this.attributes.put(DATA_KEY, str);
    }

    @Override // org.jsoup.nodes.Node
    public String nodeName() {
        return "#data";
    }

    public String getWholeData() {
        return this.attributes.get(DATA_KEY);
    }

    public DataNode setWholeData(String str) {
        this.attributes.put(DATA_KEY, str);
        return this;
    }

    @Override // org.jsoup.nodes.Node
    void outerHtmlHead(StringBuilder sb, int i, Document.OutputSettings outputSettings) {
        sb.append(getWholeData());
    }

    @Override // org.jsoup.nodes.Node
    void outerHtmlTail(StringBuilder sb, int i, Document.OutputSettings outputSettings) {
    }

    @Override // org.jsoup.nodes.Node
    public String toString() {
        return outerHtml();
    }

    public static DataNode createFromEncoded(String str, String str2) {
        return new DataNode(Entities.unescape(str), str2);
    }
}
