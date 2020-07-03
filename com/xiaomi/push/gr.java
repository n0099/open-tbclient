package com.xiaomi.push;

import android.text.TextUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.xiaomi.push.gh;
import com.xiaomi.push.gl;
import com.xiaomi.push.gn;
import com.xiaomi.push.service.ap;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
/* loaded from: classes8.dex */
public class gr {
    private static XmlPullParser a = null;

    public static gg a(String str, String str2, XmlPullParser xmlPullParser) {
        Object m315a = gq.a().m315a(SchemeCollecter.CLASSIFY_ALL, "xm:chat");
        if (m315a == null || !(m315a instanceof com.xiaomi.push.service.e)) {
            return null;
        }
        return ((com.xiaomi.push.service.e) m315a).b(xmlPullParser);
    }

    public static gh a(XmlPullParser xmlPullParser, fs fsVar) {
        String attributeValue = xmlPullParser.getAttributeValue("", "id");
        String attributeValue2 = xmlPullParser.getAttributeValue("", "to");
        String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
        String attributeValue4 = xmlPullParser.getAttributeValue("", "chid");
        gh.a a2 = gh.a.a(xmlPullParser.getAttributeValue("", "type"));
        HashMap hashMap = new HashMap();
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            hashMap.put(attributeName, xmlPullParser.getAttributeValue("", attributeName));
        }
        boolean z = false;
        gn gnVar = null;
        gh ghVar = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals(BdStatsConstant.StatsType.ERROR)) {
                    gnVar = m319a(xmlPullParser);
                } else {
                    ghVar = new gh();
                    ghVar.a(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("iq")) {
                z = true;
            }
            gnVar = gnVar;
            ghVar = ghVar;
            z = z;
        }
        if (ghVar == null) {
            if (gh.a.a == a2 || gh.a.b == a2) {
                gs gsVar = new gs();
                gsVar.k(attributeValue);
                gsVar.m(attributeValue3);
                gsVar.n(attributeValue2);
                gsVar.a(gh.a.d);
                gsVar.l(attributeValue4);
                gsVar.a(new gn(gn.a.e));
                fsVar.a(gsVar);
                com.xiaomi.channel.commonutils.logger.b.d("iq usage error. send packet in packet parser.");
                return null;
            }
            ghVar = new gt();
        }
        ghVar.k(attributeValue);
        ghVar.m(attributeValue2);
        ghVar.l(attributeValue4);
        ghVar.n(attributeValue3);
        ghVar.a(a2);
        ghVar.a(gnVar);
        ghVar.a(hashMap);
        return ghVar;
    }

    public static gj a(XmlPullParser xmlPullParser) {
        String str;
        if ("1".equals(xmlPullParser.getAttributeValue("", "s"))) {
            String attributeValue = xmlPullParser.getAttributeValue("", "chid");
            String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
            String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
            String attributeValue4 = xmlPullParser.getAttributeValue("", "to");
            String attributeValue5 = xmlPullParser.getAttributeValue("", "type");
            ap.b a2 = com.xiaomi.push.service.ap.a().a(attributeValue, attributeValue4);
            ap.b a3 = a2 == null ? com.xiaomi.push.service.ap.a().a(attributeValue, attributeValue3) : a2;
            if (a3 == null) {
                throw new gd("the channel id is wrong while receiving a encrypted message");
            }
            boolean z = false;
            gj gjVar = null;
            while (!z) {
                int next = xmlPullParser.next();
                if (next == 2) {
                    if (!"s".equals(xmlPullParser.getName())) {
                        throw new gd("error while receiving a encrypted message with wrong format");
                    }
                    if (xmlPullParser.next() != 4) {
                        throw new gd("error while receiving a encrypted message with wrong format");
                    }
                    String text = xmlPullParser.getText();
                    if ("5".equals(attributeValue) || "6".equals(attributeValue)) {
                        gi giVar = new gi();
                        giVar.l(attributeValue);
                        giVar.b(true);
                        giVar.n(attributeValue3);
                        giVar.m(attributeValue4);
                        giVar.k(attributeValue2);
                        giVar.f(attributeValue5);
                        gg ggVar = new gg("s", null, null, null);
                        ggVar.m307a(text);
                        giVar.a(ggVar);
                        return giVar;
                    }
                    a(com.xiaomi.push.service.ay.a(com.xiaomi.push.service.ay.a(a3.h, attributeValue2), text));
                    a.next();
                    gjVar = a(a);
                } else if (next == 3 && xmlPullParser.getName().equals("message")) {
                    z = true;
                }
            }
            if (gjVar == null) {
                throw new gd("error while receiving a encrypted message with wrong format");
            }
            return gjVar;
        }
        gi giVar2 = new gi();
        String attributeValue6 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue6 == null) {
            attributeValue6 = "ID_NOT_AVAILABLE";
        }
        giVar2.k(attributeValue6);
        giVar2.m(xmlPullParser.getAttributeValue("", "to"));
        giVar2.n(xmlPullParser.getAttributeValue("", "from"));
        giVar2.l(xmlPullParser.getAttributeValue("", "chid"));
        giVar2.a(xmlPullParser.getAttributeValue("", "appid"));
        try {
            str = xmlPullParser.getAttributeValue("", "transient");
        } catch (Exception e) {
            str = null;
        }
        try {
            String attributeValue7 = xmlPullParser.getAttributeValue("", "seq");
            if (!TextUtils.isEmpty(attributeValue7)) {
                giVar2.b(attributeValue7);
            }
        } catch (Exception e2) {
        }
        try {
            String attributeValue8 = xmlPullParser.getAttributeValue("", "mseq");
            if (!TextUtils.isEmpty(attributeValue8)) {
                giVar2.c(attributeValue8);
            }
        } catch (Exception e3) {
        }
        try {
            String attributeValue9 = xmlPullParser.getAttributeValue("", "fseq");
            if (!TextUtils.isEmpty(attributeValue9)) {
                giVar2.d(attributeValue9);
            }
        } catch (Exception e4) {
        }
        try {
            String attributeValue10 = xmlPullParser.getAttributeValue("", "status");
            if (!TextUtils.isEmpty(attributeValue10)) {
                giVar2.e(attributeValue10);
            }
        } catch (Exception e5) {
        }
        giVar2.a(!TextUtils.isEmpty(str) && str.equalsIgnoreCase("true"));
        giVar2.f(xmlPullParser.getAttributeValue("", "type"));
        String b = b(xmlPullParser);
        if (b == null || "".equals(b.trim())) {
            gj.q();
        } else {
            giVar2.j(b);
        }
        String str2 = null;
        boolean z2 = false;
        while (!z2) {
            int next2 = xmlPullParser.next();
            if (next2 == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (TextUtils.isEmpty(namespace)) {
                    namespace = "xm";
                }
                if (name.equals("subject")) {
                    if (b(xmlPullParser) == null) {
                    }
                    giVar2.g(m320a(xmlPullParser));
                } else if (name.equals("body")) {
                    String attributeValue11 = xmlPullParser.getAttributeValue("", "encode");
                    String m320a = m320a(xmlPullParser);
                    if (TextUtils.isEmpty(attributeValue11)) {
                        giVar2.h(m320a);
                    } else {
                        giVar2.a(m320a, attributeValue11);
                    }
                } else if (name.equals("thread")) {
                    if (str2 == null) {
                        str2 = xmlPullParser.nextText();
                    }
                } else if (name.equals(BdStatsConstant.StatsType.ERROR)) {
                    giVar2.a(m319a(xmlPullParser));
                } else {
                    giVar2.a(a(name, namespace, xmlPullParser));
                }
            } else if (next2 == 3 && xmlPullParser.getName().equals("message")) {
                z2 = true;
            }
        }
        giVar2.i(str2);
        return giVar2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static gl m317a(XmlPullParser xmlPullParser) {
        gl.b bVar = gl.b.available;
        String attributeValue = xmlPullParser.getAttributeValue("", "type");
        if (attributeValue != null && !attributeValue.equals("")) {
            try {
                bVar = gl.b.valueOf(attributeValue);
            } catch (IllegalArgumentException e) {
                System.err.println("Found invalid presence type " + attributeValue);
            }
        }
        gl glVar = new gl(bVar);
        glVar.m(xmlPullParser.getAttributeValue("", "to"));
        glVar.n(xmlPullParser.getAttributeValue("", "from"));
        glVar.l(xmlPullParser.getAttributeValue("", "chid"));
        String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue2 == null) {
            attributeValue2 = "ID_NOT_AVAILABLE";
        }
        glVar.k(attributeValue2);
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals("status")) {
                    glVar.a(xmlPullParser.nextText());
                } else if (name.equals("priority")) {
                    try {
                        glVar.a(Integer.parseInt(xmlPullParser.nextText()));
                    } catch (NumberFormatException e2) {
                    } catch (IllegalArgumentException e3) {
                        glVar.a(0);
                    }
                } else if (name.equals("show")) {
                    String nextText = xmlPullParser.nextText();
                    try {
                        glVar.a(gl.a.valueOf(nextText));
                    } catch (IllegalArgumentException e4) {
                        System.err.println("Found invalid presence mode " + nextText);
                    }
                } else if (name.equals(BdStatsConstant.StatsType.ERROR)) {
                    glVar.a(m319a(xmlPullParser));
                } else {
                    glVar.a(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("presence")) {
                z = true;
            }
        }
        return glVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static gm m318a(XmlPullParser xmlPullParser) {
        gm gmVar = null;
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                gmVar = new gm(xmlPullParser.getName());
            } else if (next == 3 && xmlPullParser.getName().equals(BdStatsConstant.StatsType.ERROR)) {
                z = true;
            }
        }
        return gmVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static gn m319a(XmlPullParser xmlPullParser) {
        ArrayList arrayList = new ArrayList();
        String str = null;
        String str2 = null;
        String str3 = "-1";
        int i = 0;
        while (i < xmlPullParser.getAttributeCount()) {
            String attributeValue = xmlPullParser.getAttributeName(i).equals("code") ? xmlPullParser.getAttributeValue("", "code") : str3;
            String attributeValue2 = xmlPullParser.getAttributeName(i).equals("type") ? xmlPullParser.getAttributeValue("", "type") : str2;
            if (xmlPullParser.getAttributeName(i).equals(TiebaInitialize.LogFields.REASON)) {
                str = xmlPullParser.getAttributeValue("", TiebaInitialize.LogFields.REASON);
            }
            i++;
            str2 = attributeValue2;
            str3 = attributeValue;
        }
        boolean z = false;
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
                if (xmlPullParser.getName().equals(BdStatsConstant.StatsType.ERROR)) {
                    z = true;
                }
            } else if (next == 4) {
                str5 = xmlPullParser.getText();
            }
        }
        return new gn(Integer.parseInt(str3), str2 == null ? "cancel" : str2, str, str4, str5, arrayList);
    }

    /* renamed from: a  reason: collision with other method in class */
    private static String m320a(XmlPullParser xmlPullParser) {
        String str = "";
        int depth = xmlPullParser.getDepth();
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getDepth() == depth) {
                return str;
            }
            str = str + xmlPullParser.getText();
        }
    }

    private static void a(byte[] bArr) {
        if (a == null) {
            try {
                a = XmlPullParserFactory.newInstance().newPullParser();
                a.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }
        }
        a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
    }

    private static String b(XmlPullParser xmlPullParser) {
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            if ("xml:lang".equals(attributeName) || ("lang".equals(attributeName) && "xml".equals(xmlPullParser.getAttributePrefix(i)))) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }
}
