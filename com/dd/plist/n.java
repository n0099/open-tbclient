package com.dd.plist;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
/* loaded from: classes7.dex */
public class n {
    private static DocumentBuilderFactory lGW = null;

    private static synchronized void djE() {
        synchronized (n.class) {
            lGW = DocumentBuilderFactory.newInstance();
            lGW.setIgnoringComments(true);
            lGW.setCoalescing(true);
        }
    }

    private static synchronized DocumentBuilder djF() throws ParserConfigurationException {
        DocumentBuilder newDocumentBuilder;
        synchronized (n.class) {
            if (lGW == null) {
                djE();
            }
            newDocumentBuilder = lGW.newDocumentBuilder();
            newDocumentBuilder.setEntityResolver(new EntityResolver() { // from class: com.dd.plist.n.1
                @Override // org.xml.sax.EntityResolver
                public InputSource resolveEntity(String str, String str2) {
                    if ("-//Apple Computer//DTD PLIST 1.0//EN".equals(str) || "-//Apple//DTD PLIST 1.0//EN".equals(str)) {
                        return new InputSource(new ByteArrayInputStream(new byte[0]));
                    }
                    return null;
                }
            });
        }
        return newDocumentBuilder;
    }

    public static i ad(byte[] bArr) throws ParserConfigurationException, ParseException, SAXException, PropertyListFormatException, IOException {
        return q(new ByteArrayInputStream(bArr));
    }

    public static i q(InputStream inputStream) throws ParserConfigurationException, IOException, SAXException, PropertyListFormatException, ParseException {
        return a(djF().parse(inputStream));
    }

    private static i a(Document document) throws PropertyListFormatException, IOException, ParseException {
        Node documentElement;
        DocumentType doctype = document.getDoctype();
        if (doctype == null) {
            if (!document.getDocumentElement().getNodeName().equals("plist")) {
                throw new UnsupportedOperationException("The given XML document is not a property list.");
            }
        } else if (!doctype.getName().equals("plist")) {
            throw new UnsupportedOperationException("The given XML document is not a property list.");
        }
        if (document.getDocumentElement().getNodeName().equals("plist")) {
            List<Node> a = a(document.getDocumentElement().getChildNodes());
            if (a.isEmpty()) {
                throw new PropertyListFormatException("The given XML property list has no root element!");
            }
            if (a.size() == 1) {
                documentElement = a.get(0);
            } else {
                throw new PropertyListFormatException("The given XML property list has more than one root element!");
            }
        } else {
            documentElement = document.getDocumentElement();
        }
        return a(documentElement);
    }

    private static i a(Node node) throws ParseException, IOException {
        int i = 0;
        String nodeName = node.getNodeName();
        if (nodeName.equals("dict")) {
            g gVar = new g();
            List<Node> a = a(node.getChildNodes());
            while (true) {
                int i2 = i;
                if (i2 >= a.size()) {
                    return gVar;
                }
                gVar.put(b(a.get(i2)), a(a.get(i2 + 1)));
                i = i2 + 2;
            }
        } else if (nodeName.equals("array")) {
            List<Node> a2 = a(node.getChildNodes());
            d dVar = new d(a2.size());
            while (true) {
                int i3 = i;
                if (i3 >= a2.size()) {
                    return dVar;
                }
                dVar.j(i3, a(a2.get(i3)));
                i = i3 + 1;
            }
        } else if (nodeName.equals("true")) {
            return new h(true);
        } else {
            if (nodeName.equals("false")) {
                return new h(false);
            }
            if (nodeName.equals("integer")) {
                return new h(b(node));
            }
            if (nodeName.equals("real")) {
                return new h(b(node));
            }
            if (nodeName.equals("string")) {
                return new k(b(node));
            }
            if (nodeName.equals("data")) {
                return new e(b(node));
            }
            if (nodeName.equals("date")) {
                return new f(b(node));
            }
            return null;
        }
    }

    private static List<Node> a(NodeList nodeList) {
        ArrayList arrayList = new ArrayList(nodeList.getLength());
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeType() == 1) {
                arrayList.add(nodeList.item(i));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003c, code lost:
        r0 = ((org.w3c.dom.Text) r0).getWholeText();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
        if (r0 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
        return "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:?, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String b(Node node) {
        if (node.getNodeType() == 3 || node.getNodeType() == 4) {
            String wholeText = ((Text) node).getWholeText();
            if (wholeText == null) {
                return "";
            }
            return wholeText;
        } else if (node.hasChildNodes()) {
            NodeList childNodes = node.getChildNodes();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < childNodes.getLength()) {
                    Node item = childNodes.item(i2);
                    if (item.getNodeType() == 3 || item.getNodeType() == 4) {
                        break;
                    }
                    i = i2 + 1;
                } else {
                    return "";
                }
            }
        } else {
            return "";
        }
    }
}
