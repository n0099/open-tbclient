package com.tencent.mm.sdk.platformtools;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
/* loaded from: classes.dex */
public class KVConfig {
    private static boolean aa = false;

    private static void a(Map map) {
        if (map == null || map.size() <= 0) {
            Log.v("MicroMsg.SDK.KVConfig", "empty values");
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            Log.v("MicroMsg.SDK.KVConfig", "key=" + ((String) entry.getKey()) + " value=" + ((String) entry.getValue()));
        }
    }

    private static void a(Map map, String str, Node node, int i) {
        Node item;
        if (node.getNodeName().equals("#text")) {
            map.put(str, node.getNodeValue());
        } else if (node.getNodeName().equals("#cdata-section")) {
            map.put(str, node.getNodeValue());
        } else {
            String str2 = str + "." + node.getNodeName() + (i > 0 ? Integer.valueOf(i) : "");
            map.put(str2, node.getNodeValue());
            NamedNodeMap attributes = node.getAttributes();
            if (attributes != null) {
                for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                    map.put(str2 + ".$" + item.getNodeName(), attributes.item(i2).getNodeValue());
                }
            }
            HashMap hashMap = new HashMap();
            NodeList childNodes = node.getChildNodes();
            for (int i3 = 0; i3 < childNodes.getLength(); i3++) {
                Node item2 = childNodes.item(i3);
                int nullAsNil = Util.nullAsNil((Integer) hashMap.get(item2.getNodeName()));
                a(map, str2, item2, nullAsNil);
                hashMap.put(item2.getNodeName(), Integer.valueOf(nullAsNil + 1));
            }
        }
    }

    public static Map parseIni(String str) {
        String[] split;
        String[] split2;
        if (str == null || str.length() <= 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str2 : str.split("\n")) {
            if (str2 != null && str2.length() > 0 && (split2 = str2.trim().split("=", 2)) != null && split2.length >= 2) {
                String str3 = split2[0];
                String str4 = split2[1];
                if (str3 != null && str3.length() > 0 && str3.matches("^[a-zA-Z0-9_]*")) {
                    hashMap.put(str3, str4);
                }
            }
        }
        if (aa) {
            a(hashMap);
            return hashMap;
        }
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Map parseXml(String str, String str2, String str3) {
        Document document;
        int indexOf = str.indexOf(60);
        if (indexOf < 0) {
            Log.e("MicroMsg.SDK.KVConfig", "text not in xml format");
            return null;
        }
        if (indexOf > 0) {
            Log.w("MicroMsg.SDK.KVConfig", "fix xml header from + %d", Integer.valueOf(indexOf));
            str = str.substring(indexOf);
        }
        if (str == null || str.length() <= 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        try {
            DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            if (newDocumentBuilder == null) {
                Log.e("MicroMsg.SDK.KVConfig", "new Document Builder failed");
                return null;
            }
            try {
                try {
                    InputSource inputSource = new InputSource(new ByteArrayInputStream(str.getBytes()));
                    if (str3 != null) {
                        inputSource.setEncoding(str3);
                    }
                    document = newDocumentBuilder.parse(inputSource);
                    try {
                        document.normalize();
                    } catch (DOMException e) {
                        e = e;
                        e.printStackTrace();
                        if (document != null) {
                        }
                    }
                } catch (DOMException e2) {
                    e = e2;
                    document = null;
                }
                if (document != null) {
                    Log.e("MicroMsg.SDK.KVConfig", "new Document failed");
                    return null;
                }
                Element documentElement = document.getDocumentElement();
                if (documentElement == null) {
                    Log.e("MicroMsg.SDK.KVConfig", "getDocumentElement failed");
                    return null;
                }
                if (str2 == null || !str2.equals(documentElement.getNodeName())) {
                    NodeList elementsByTagName = documentElement.getElementsByTagName(str2);
                    if (elementsByTagName.getLength() <= 0) {
                        Log.e("MicroMsg.SDK.KVConfig", "parse item null");
                        return null;
                    }
                    if (elementsByTagName.getLength() > 1) {
                        Log.w("MicroMsg.SDK.KVConfig", "parse items more than one");
                    }
                    a(hashMap, "", elementsByTagName.item(0), 0);
                } else {
                    a(hashMap, "", documentElement, 0);
                }
                if (aa) {
                    a(hashMap);
                }
                return hashMap;
            } catch (IOException e3) {
                e3.printStackTrace();
                return null;
            } catch (SAXException e4) {
                e4.printStackTrace();
                return null;
            } catch (Exception e5) {
                e5.printStackTrace();
                return null;
            }
        } catch (ParserConfigurationException e6) {
            e6.printStackTrace();
            return null;
        }
    }
}
