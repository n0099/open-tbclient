package com.tencent.turingfd.sdk.ams.au;

import java.util.Stack;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
/* loaded from: classes15.dex */
public class aw {

    /* renamed from: b  reason: collision with root package name */
    public Document f13499b;
    public final DocumentBuilder c = DocumentBuilderFactory.newInstance().newDocumentBuilder();

    /* renamed from: a  reason: collision with root package name */
    public Stack<Node> f13498a = new Stack<>();

    public void a() {
    }

    public void a(String str, String str2) {
    }

    public void a(String str, String str2, String str3, av[] avVarArr) {
        Element createElement = str == null || "".equals(str) ? this.f13499b.createElement(str2) : this.f13499b.createElementNS(str, str3);
        for (av avVar : avVarArr) {
            String str4 = avVar.c;
            if (str4 == null || "".equals(str4)) {
                createElement.setAttribute(avVar.f13496a, avVar.d);
            } else {
                createElement.setAttributeNS(avVar.c, avVar.f13497b + ':' + avVar.f13496a, avVar.d);
            }
        }
        this.f13498a.peek().appendChild(createElement);
        this.f13498a.push(createElement);
    }

    public void b(String str, String str2) {
    }
}
