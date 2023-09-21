package com.xiaomi.push;

import android.text.TextUtils;
import androidx.core.net.MailTo;
import com.baidu.pass.biometrics.base.http.HttpClientWrap;
import com.baidu.searchbox.player.model.YYOption;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.xiaomi.push.gk;
import com.xiaomi.push.go;
import com.xiaomi.push.gq;
import com.xiaomi.push.service.bg;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
/* loaded from: classes10.dex */
public class gu {
    public static XmlPullParser a;

    public static gj a(String str, String str2, XmlPullParser xmlPullParser) {
        Object m539a = gt.a().m539a("all", "xm:chat");
        if (m539a == null || !(m539a instanceof com.xiaomi.push.service.k)) {
            return null;
        }
        return ((com.xiaomi.push.service.k) m539a).b(xmlPullParser);
    }

    public static gk a(XmlPullParser xmlPullParser, fv fvVar) {
        String attributeValue = xmlPullParser.getAttributeValue("", "id");
        String attributeValue2 = xmlPullParser.getAttributeValue("", "to");
        String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
        String attributeValue4 = xmlPullParser.getAttributeValue("", "chid");
        gk.a a2 = gk.a.a(xmlPullParser.getAttributeValue("", "type"));
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            hashMap.put(attributeName, xmlPullParser.getAttributeValue("", attributeName));
        }
        gk gkVar = null;
        gq gqVar = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals("error")) {
                    gqVar = m543a(xmlPullParser);
                } else {
                    gkVar = new gk();
                    gkVar.a(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("iq")) {
                z = true;
            }
        }
        if (gkVar == null) {
            if (gk.a.a == a2 || gk.a.b == a2) {
                gv gvVar = new gv();
                gvVar.k(attributeValue);
                gvVar.m(attributeValue3);
                gvVar.n(attributeValue2);
                gvVar.a(gk.a.d);
                gvVar.l(attributeValue4);
                gvVar.a(new gq(gq.a.e));
                fvVar.a(gvVar);
                com.xiaomi.channel.commonutils.logger.b.d("iq usage error. send packet in packet parser.");
                return null;
            }
            gkVar = new gw();
        }
        gkVar.k(attributeValue);
        gkVar.m(attributeValue2);
        gkVar.l(attributeValue4);
        gkVar.n(attributeValue3);
        gkVar.a(a2);
        gkVar.a(gqVar);
        gkVar.a(hashMap);
        return gkVar;
    }

    public static gm a(XmlPullParser xmlPullParser) {
        String str;
        boolean z = false;
        String str2 = null;
        if ("1".equals(xmlPullParser.getAttributeValue("", "s"))) {
            String attributeValue = xmlPullParser.getAttributeValue("", "chid");
            String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
            String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
            String attributeValue4 = xmlPullParser.getAttributeValue("", "to");
            String attributeValue5 = xmlPullParser.getAttributeValue("", "type");
            bg.b a2 = com.xiaomi.push.service.bg.a().a(attributeValue, attributeValue4);
            if (a2 == null) {
                a2 = com.xiaomi.push.service.bg.a().a(attributeValue, attributeValue3);
            }
            if (a2 != null) {
                gm gmVar = null;
                while (!z) {
                    int next = xmlPullParser.next();
                    if (next == 2) {
                        if (!"s".equals(xmlPullParser.getName())) {
                            throw new gg("error while receiving a encrypted message with wrong format");
                        }
                        if (xmlPullParser.next() != 4) {
                            throw new gg("error while receiving a encrypted message with wrong format");
                        }
                        String text = xmlPullParser.getText();
                        if ("5".equals(attributeValue) || "6".equals(attributeValue)) {
                            gl glVar = new gl();
                            glVar.l(attributeValue);
                            glVar.b(true);
                            glVar.n(attributeValue3);
                            glVar.m(attributeValue4);
                            glVar.k(attributeValue2);
                            glVar.f(attributeValue5);
                            gj gjVar = new gj("s", null, null, null);
                            gjVar.m530a(text);
                            glVar.a(gjVar);
                            return glVar;
                        }
                        a(com.xiaomi.push.service.bp.a(com.xiaomi.push.service.bp.a(a2.h, attributeValue2), text));
                        a.next();
                        gmVar = a(a);
                    } else if (next == 3 && xmlPullParser.getName().equals("message")) {
                        z = true;
                    }
                }
                if (gmVar != null) {
                    return gmVar;
                }
                throw new gg("error while receiving a encrypted message with wrong format");
            }
            throw new gg("the channel id is wrong while receiving a encrypted message");
        }
        gl glVar2 = new gl();
        String attributeValue6 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue6 == null) {
            attributeValue6 = "ID_NOT_AVAILABLE";
        }
        glVar2.k(attributeValue6);
        glVar2.m(xmlPullParser.getAttributeValue("", "to"));
        glVar2.n(xmlPullParser.getAttributeValue("", "from"));
        glVar2.l(xmlPullParser.getAttributeValue("", "chid"));
        glVar2.a(xmlPullParser.getAttributeValue("", "appid"));
        try {
            str = xmlPullParser.getAttributeValue("", "transient");
        } catch (Exception unused) {
            str = null;
        }
        try {
            String attributeValue7 = xmlPullParser.getAttributeValue("", "seq");
            if (!TextUtils.isEmpty(attributeValue7)) {
                glVar2.b(attributeValue7);
            }
        } catch (Exception unused2) {
        }
        try {
            String attributeValue8 = xmlPullParser.getAttributeValue("", "mseq");
            if (!TextUtils.isEmpty(attributeValue8)) {
                glVar2.c(attributeValue8);
            }
        } catch (Exception unused3) {
        }
        try {
            String attributeValue9 = xmlPullParser.getAttributeValue("", "fseq");
            if (!TextUtils.isEmpty(attributeValue9)) {
                glVar2.d(attributeValue9);
            }
        } catch (Exception unused4) {
        }
        try {
            String attributeValue10 = xmlPullParser.getAttributeValue("", "status");
            if (!TextUtils.isEmpty(attributeValue10)) {
                glVar2.e(attributeValue10);
            }
        } catch (Exception unused5) {
        }
        glVar2.a(!TextUtils.isEmpty(str) && str.equalsIgnoreCase(YYOption.IsLive.VALUE_TRUE));
        glVar2.f(xmlPullParser.getAttributeValue("", "type"));
        String b = b(xmlPullParser);
        if (b == null || "".equals(b.trim())) {
            gm.q();
        } else {
            glVar2.j(b);
        }
        while (!z) {
            int next2 = xmlPullParser.next();
            if (next2 == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (TextUtils.isEmpty(namespace)) {
                    namespace = "xm";
                }
                if (name.equals(MailTo.SUBJECT)) {
                    b(xmlPullParser);
                    glVar2.g(m544a(xmlPullParser));
                } else if (name.equals("body")) {
                    String attributeValue11 = xmlPullParser.getAttributeValue("", HttpClientWrap.c);
                    String m544a = m544a(xmlPullParser);
                    if (TextUtils.isEmpty(attributeValue11)) {
                        glVar2.h(m544a);
                    } else {
                        glVar2.a(m544a, attributeValue11);
                    }
                } else if (name.equals("thread")) {
                    if (str2 == null) {
                        str2 = xmlPullParser.nextText();
                    }
                } else if (name.equals("error")) {
                    glVar2.a(m543a(xmlPullParser));
                } else {
                    glVar2.a(a(name, namespace, xmlPullParser));
                }
            } else if (next2 == 3 && xmlPullParser.getName().equals("message")) {
                z = true;
            }
        }
        glVar2.i(str2);
        return glVar2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static go m541a(XmlPullParser xmlPullParser) {
        go.b bVar = go.b.available;
        String attributeValue = xmlPullParser.getAttributeValue("", "type");
        if (attributeValue != null && !attributeValue.equals("")) {
            try {
                bVar = go.b.valueOf(attributeValue);
            } catch (IllegalArgumentException unused) {
                PrintStream printStream = System.err;
                printStream.println("Found invalid presence type " + attributeValue);
            }
        }
        go goVar = new go(bVar);
        goVar.m(xmlPullParser.getAttributeValue("", "to"));
        goVar.n(xmlPullParser.getAttributeValue("", "from"));
        goVar.l(xmlPullParser.getAttributeValue("", "chid"));
        String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue2 == null) {
            attributeValue2 = "ID_NOT_AVAILABLE";
        }
        goVar.k(attributeValue2);
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals("status")) {
                    goVar.a(xmlPullParser.nextText());
                } else if (name.equals("priority")) {
                    try {
                        goVar.a(Integer.parseInt(xmlPullParser.nextText()));
                    } catch (NumberFormatException unused2) {
                    } catch (IllegalArgumentException unused3) {
                        goVar.a(0);
                    }
                } else if (name.equals("show")) {
                    String nextText = xmlPullParser.nextText();
                    try {
                        goVar.a(go.a.valueOf(nextText));
                    } catch (IllegalArgumentException unused4) {
                        PrintStream printStream2 = System.err;
                        printStream2.println("Found invalid presence mode " + nextText);
                    }
                } else if (name.equals("error")) {
                    goVar.a(m543a(xmlPullParser));
                } else {
                    goVar.a(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("presence")) {
                z = true;
            }
        }
        return goVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static gp m542a(XmlPullParser xmlPullParser) {
        gp gpVar = null;
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                gpVar = new gp(xmlPullParser.getName());
            } else if (next == 3 && xmlPullParser.getName().equals("error")) {
                z = true;
            }
        }
        return gpVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static gq m543a(XmlPullParser xmlPullParser) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        String str = "-1";
        String str2 = null;
        String str3 = null;
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            if (xmlPullParser.getAttributeName(i).equals("code")) {
                str = xmlPullParser.getAttributeValue("", "code");
            }
            if (xmlPullParser.getAttributeName(i).equals("type")) {
                str3 = xmlPullParser.getAttributeValue("", "type");
            }
            if (xmlPullParser.getAttributeName(i).equals("reason")) {
                str2 = xmlPullParser.getAttributeValue("", "reason");
            }
        }
        String str4 = null;
        String str5 = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals("text")) {
                    str5 = xmlPullParser.nextText();
                } else {
                    String name = xmlPullParser.getName();
                    String namespace = xmlPullParser.getNamespace();
                    if ("urn:ietf:params:xml:ns:xmpp-stanzas".equals(namespace)) {
                        str4 = name;
                    } else {
                        arrayList.add(a(name, namespace, xmlPullParser));
                    }
                }
            } else if (next == 3) {
                if (xmlPullParser.getName().equals("error")) {
                    z = true;
                }
            } else if (next == 4) {
                str5 = xmlPullParser.getText();
            }
        }
        return new gq(Integer.parseInt(str), str3 == null ? "cancel" : str3, str2, str4, str5, arrayList);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m544a(XmlPullParser xmlPullParser) {
        int depth = xmlPullParser.getDepth();
        String str = "";
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getDepth() == depth) {
                return str;
            }
            str = str + xmlPullParser.getText();
        }
    }

    public static void a(byte[] bArr) {
        if (a == null) {
            try {
                XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                a = newPullParser;
                newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }
        }
        a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
    }

    public static String b(XmlPullParser xmlPullParser) {
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            if ("xml:lang".equals(attributeName) || (WebvttCueParser.TAG_LANG.equals(attributeName) && "xml".equals(xmlPullParser.getAttributePrefix(i)))) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }
}
