package org.jsoup.nodes;

import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
/* loaded from: classes.dex */
public class DocumentType extends Node {
    public DocumentType(String str, String str2, String str3, String str4) {
        super(str4);
        Validate.notEmpty(str);
        attr("name", str);
        attr("publicId", str2);
        attr("systemId", str3);
    }

    @Override // org.jsoup.nodes.Node
    public String nodeName() {
        return "#doctype";
    }

    @Override // org.jsoup.nodes.Node
    void outerHtmlHead(StringBuilder sb, int i, Document.OutputSettings outputSettings) {
        sb.append("<!DOCTYPE ").append(attr("name"));
        if (!StringUtil.isBlank(attr("publicId"))) {
            sb.append(" PUBLIC \"").append(attr("publicId")).append("\"");
        }
        if (!StringUtil.isBlank(attr("systemId"))) {
            sb.append(" \"").append(attr("systemId")).append("\"");
        }
        sb.append('>');
    }

    @Override // org.jsoup.nodes.Node
    void outerHtmlTail(StringBuilder sb, int i, Document.OutputSettings outputSettings) {
    }
}
