package com.xiaomi.push;

import android.text.TextUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.xiaomi.push.gb;
import com.xiaomi.push.gf;
import com.xiaomi.push.gh;
import com.xiaomi.push.service.al;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
/* loaded from: classes5.dex */
public class gl {
    private static XmlPullParser a = null;

    public static ga a(String str, String str2, XmlPullParser xmlPullParser) {
        Object m296a = gk.a().m296a(SchemeCollecter.CLASSIFY_ALL, "xm:chat");
        if (m296a == null || !(m296a instanceof com.xiaomi.push.service.e)) {
            return null;
        }
        return ((com.xiaomi.push.service.e) m296a).b(xmlPullParser);
    }

    public static gb a(XmlPullParser xmlPullParser, fm fmVar) {
        String attributeValue = xmlPullParser.getAttributeValue("", "id");
        String attributeValue2 = xmlPullParser.getAttributeValue("", "to");
        String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
        String attributeValue4 = xmlPullParser.getAttributeValue("", "chid");
        gb.a a2 = gb.a.a(xmlPullParser.getAttributeValue("", "type"));
        HashMap hashMap = new HashMap();
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            hashMap.put(attributeName, xmlPullParser.getAttributeValue("", attributeName));
        }
        boolean z = false;
        gh ghVar = null;
        gb gbVar = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals(BdStatsConstant.StatsType.ERROR)) {
                    ghVar = m300a(xmlPullParser);
                } else {
                    gbVar = new gb();
                    gbVar.a(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("iq")) {
                z = true;
            }
            ghVar = ghVar;
            gbVar = gbVar;
            z = z;
        }
        if (gbVar == null) {
            if (gb.a.a == a2 || gb.a.b == a2) {
                gm gmVar = new gm();
                gmVar.k(attributeValue);
                gmVar.m(attributeValue3);
                gmVar.n(attributeValue2);
                gmVar.a(gb.a.d);
                gmVar.l(attributeValue4);
                gmVar.a(new gh(gh.a.e));
                fmVar.a(gmVar);
                com.xiaomi.channel.commonutils.logger.b.d("iq usage error. send packet in packet parser.");
                return null;
            }
            gbVar = new gn();
        }
        gbVar.k(attributeValue);
        gbVar.m(attributeValue2);
        gbVar.l(attributeValue4);
        gbVar.n(attributeValue3);
        gbVar.a(a2);
        gbVar.a(ghVar);
        gbVar.a(hashMap);
        return gbVar;
    }

    public static gd a(XmlPullParser xmlPullParser) {
        String str;
        if ("1".equals(xmlPullParser.getAttributeValue("", "s"))) {
            String attributeValue = xmlPullParser.getAttributeValue("", "chid");
            String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
            String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
            String attributeValue4 = xmlPullParser.getAttributeValue("", "to");
            String attributeValue5 = xmlPullParser.getAttributeValue("", "type");
            al.b a2 = com.xiaomi.push.service.al.a().a(attributeValue, attributeValue4);
            al.b a3 = a2 == null ? com.xiaomi.push.service.al.a().a(attributeValue, attributeValue3) : a2;
            if (a3 == null) {
                throw new fx("the channel id is wrong while receiving a encrypted message");
            }
            boolean z = false;
            gd gdVar = null;
            while (!z) {
                int next = xmlPullParser.next();
                if (next == 2) {
                    if (!"s".equals(xmlPullParser.getName())) {
                        throw new fx("error while receiving a encrypted message with wrong format");
                    }
                    if (xmlPullParser.next() != 4) {
                        throw new fx("error while receiving a encrypted message with wrong format");
                    }
                    String text = xmlPullParser.getText();
                    if ("5".equals(attributeValue) || "6".equals(attributeValue)) {
                        gc gcVar = new gc();
                        gcVar.l(attributeValue);
                        gcVar.b(true);
                        gcVar.n(attributeValue3);
                        gcVar.m(attributeValue4);
                        gcVar.k(attributeValue2);
                        gcVar.f(attributeValue5);
                        ga gaVar = new ga("s", null, null, null);
                        gaVar.m288a(text);
                        gcVar.a(gaVar);
                        return gcVar;
                    }
                    a(com.xiaomi.push.service.au.a(com.xiaomi.push.service.au.a(a3.h, attributeValue2), text));
                    a.next();
                    gdVar = a(a);
                } else if (next == 3 && xmlPullParser.getName().equals("message")) {
                    z = true;
                }
            }
            if (gdVar == null) {
                throw new fx("error while receiving a encrypted message with wrong format");
            }
            return gdVar;
        }
        gc gcVar2 = new gc();
        String attributeValue6 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue6 == null) {
            attributeValue6 = "ID_NOT_AVAILABLE";
        }
        gcVar2.k(attributeValue6);
        gcVar2.m(xmlPullParser.getAttributeValue("", "to"));
        gcVar2.n(xmlPullParser.getAttributeValue("", "from"));
        gcVar2.l(xmlPullParser.getAttributeValue("", "chid"));
        gcVar2.a(xmlPullParser.getAttributeValue("", "appid"));
        try {
            str = xmlPullParser.getAttributeValue("", "transient");
        } catch (Exception e) {
            str = null;
        }
        try {
            String attributeValue7 = xmlPullParser.getAttributeValue("", "seq");
            if (!TextUtils.isEmpty(attributeValue7)) {
                gcVar2.b(attributeValue7);
            }
        } catch (Exception e2) {
        }
        try {
            String attributeValue8 = xmlPullParser.getAttributeValue("", "mseq");
            if (!TextUtils.isEmpty(attributeValue8)) {
                gcVar2.c(attributeValue8);
            }
        } catch (Exception e3) {
        }
        try {
            String attributeValue9 = xmlPullParser.getAttributeValue("", "fseq");
            if (!TextUtils.isEmpty(attributeValue9)) {
                gcVar2.d(attributeValue9);
            }
        } catch (Exception e4) {
        }
        try {
            String attributeValue10 = xmlPullParser.getAttributeValue("", "status");
            if (!TextUtils.isEmpty(attributeValue10)) {
                gcVar2.e(attributeValue10);
            }
        } catch (Exception e5) {
        }
        gcVar2.a(!TextUtils.isEmpty(str) && str.equalsIgnoreCase("true"));
        gcVar2.f(xmlPullParser.getAttributeValue("", "type"));
        String b = b(xmlPullParser);
        if (b == null || "".equals(b.trim())) {
            gd.q();
        } else {
            gcVar2.j(b);
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
                    gcVar2.g(m301a(xmlPullParser));
                } else if (name.equals("body")) {
                    String attributeValue11 = xmlPullParser.getAttributeValue("", "encode");
                    String m301a = m301a(xmlPullParser);
                    if (TextUtils.isEmpty(attributeValue11)) {
                        gcVar2.h(m301a);
                    } else {
                        gcVar2.a(m301a, attributeValue11);
                    }
                } else if (name.equals("thread")) {
                    if (str2 == null) {
                        str2 = xmlPullParser.nextText();
                    }
                } else if (name.equals(BdStatsConstant.StatsType.ERROR)) {
                    gcVar2.a(m300a(xmlPullParser));
                } else {
                    gcVar2.a(a(name, namespace, xmlPullParser));
                }
            } else if (next2 == 3 && xmlPullParser.getName().equals("message")) {
                z2 = true;
            }
        }
        gcVar2.i(str2);
        return gcVar2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static gf m298a(XmlPullParser xmlPullParser) {
        gf.b bVar = gf.b.available;
        String attributeValue = xmlPullParser.getAttributeValue("", "type");
        if (attributeValue != null && !attributeValue.equals("")) {
            try {
                bVar = gf.b.valueOf(attributeValue);
            } catch (IllegalArgumentException e) {
                System.err.println("Found invalid presence type " + attributeValue);
            }
        }
        gf gfVar = new gf(bVar);
        gfVar.m(xmlPullParser.getAttributeValue("", "to"));
        gfVar.n(xmlPullParser.getAttributeValue("", "from"));
        gfVar.l(xmlPullParser.getAttributeValue("", "chid"));
        String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue2 == null) {
            attributeValue2 = "ID_NOT_AVAILABLE";
        }
        gfVar.k(attributeValue2);
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals("status")) {
                    gfVar.a(xmlPullParser.nextText());
                } else if (name.equals("priority")) {
                    try {
                        gfVar.a(Integer.parseInt(xmlPullParser.nextText()));
                    } catch (NumberFormatException e2) {
                    } catch (IllegalArgumentException e3) {
                        gfVar.a(0);
                    }
                } else if (name.equals("show")) {
                    String nextText = xmlPullParser.nextText();
                    try {
                        gfVar.a(gf.a.valueOf(nextText));
                    } catch (IllegalArgumentException e4) {
                        System.err.println("Found invalid presence mode " + nextText);
                    }
                } else if (name.equals(BdStatsConstant.StatsType.ERROR)) {
                    gfVar.a(m300a(xmlPullParser));
                } else {
                    gfVar.a(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("presence")) {
                z = true;
            }
        }
        return gfVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static gg m299a(XmlPullParser xmlPullParser) {
        gg ggVar = null;
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                ggVar = new gg(xmlPullParser.getName());
            } else if (next == 3 && xmlPullParser.getName().equals(BdStatsConstant.StatsType.ERROR)) {
                z = true;
            }
        }
        return ggVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static gh m300a(XmlPullParser xmlPullParser) {
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
        return new gh(Integer.parseInt(str3), str2 == null ? UgcUBCUtils.UGC_TIME_CANCEL : str2, str, str4, str5, arrayList);
    }

    /* renamed from: a  reason: collision with other method in class */
    private static String m301a(XmlPullParser xmlPullParser) {
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
