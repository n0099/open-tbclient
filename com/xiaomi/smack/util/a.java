package com.xiaomi.smack.util;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.tencent.connect.common.Constants;
import com.xiaomi.push.service.ak;
import com.xiaomi.push.service.aq;
import com.xiaomi.smack.l;
import com.xiaomi.smack.packet.b;
import com.xiaomi.smack.packet.f;
import com.xiaomi.smack.packet.h;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.logging.LogFactory;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
/* loaded from: classes3.dex */
public class a {
    private static XmlPullParser a = null;

    public static com.xiaomi.smack.packet.a a(String str, String str2, XmlPullParser xmlPullParser) {
        Object a2 = com.xiaomi.smack.provider.c.a().a("all", "xm:chat");
        if (a2 == null || !(a2 instanceof com.xiaomi.push.service.c)) {
            return null;
        }
        return ((com.xiaomi.push.service.c) a2).b(xmlPullParser);
    }

    public static com.xiaomi.smack.packet.b a(XmlPullParser xmlPullParser, com.xiaomi.smack.a aVar) {
        String attributeValue = xmlPullParser.getAttributeValue("", "id");
        String attributeValue2 = xmlPullParser.getAttributeValue("", "to");
        String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
        String attributeValue4 = xmlPullParser.getAttributeValue("", "chid");
        b.a a2 = b.a.a(xmlPullParser.getAttributeValue("", "type"));
        HashMap hashMap = new HashMap();
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            hashMap.put(attributeName, xmlPullParser.getAttributeValue("", attributeName));
        }
        boolean z = false;
        com.xiaomi.smack.packet.h hVar = null;
        com.xiaomi.smack.packet.b bVar = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals("error")) {
                    hVar = d(xmlPullParser);
                } else {
                    bVar = new com.xiaomi.smack.packet.b();
                    bVar.a(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("iq")) {
                z = true;
            }
            hVar = hVar;
            bVar = bVar;
            z = z;
        }
        if (bVar == null) {
            if (b.a.a == a2 || b.a.b == a2) {
                b bVar2 = new b();
                bVar2.k(attributeValue);
                bVar2.m(attributeValue3);
                bVar2.n(attributeValue2);
                bVar2.a(b.a.d);
                bVar2.l(attributeValue4);
                bVar2.a(new com.xiaomi.smack.packet.h(h.a.e));
                aVar.a(bVar2);
                com.xiaomi.channel.commonutils.logger.b.d("iq usage error. send packet in packet parser.");
                return null;
            }
            bVar = new c();
        }
        bVar.k(attributeValue);
        bVar.m(attributeValue2);
        bVar.l(attributeValue4);
        bVar.n(attributeValue3);
        bVar.a(a2);
        bVar.a(hVar);
        bVar.a(hashMap);
        return bVar;
    }

    public static com.xiaomi.smack.packet.d a(XmlPullParser xmlPullParser) {
        String str;
        if ("1".equals(xmlPullParser.getAttributeValue("", NotifyType.SOUND))) {
            String attributeValue = xmlPullParser.getAttributeValue("", "chid");
            String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
            String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
            String attributeValue4 = xmlPullParser.getAttributeValue("", "to");
            String attributeValue5 = xmlPullParser.getAttributeValue("", "type");
            ak.b b = ak.a().b(attributeValue, attributeValue4);
            ak.b b2 = b == null ? ak.a().b(attributeValue, attributeValue3) : b;
            if (b2 == null) {
                throw new l("the channel id is wrong while receiving a encrypted message");
            }
            boolean z = false;
            com.xiaomi.smack.packet.d dVar = null;
            while (!z) {
                int next = xmlPullParser.next();
                if (next == 2) {
                    if (!NotifyType.SOUND.equals(xmlPullParser.getName())) {
                        throw new l("error while receiving a encrypted message with wrong format");
                    }
                    if (xmlPullParser.next() != 4) {
                        throw new l("error while receiving a encrypted message with wrong format");
                    }
                    String text = xmlPullParser.getText();
                    if ("5".equals(attributeValue) || Constants.VIA_SHARE_TYPE_INFO.equals(attributeValue)) {
                        com.xiaomi.smack.packet.c cVar = new com.xiaomi.smack.packet.c();
                        cVar.l(attributeValue);
                        cVar.b(true);
                        cVar.n(attributeValue3);
                        cVar.m(attributeValue4);
                        cVar.k(attributeValue2);
                        cVar.f(attributeValue5);
                        com.xiaomi.smack.packet.a aVar = new com.xiaomi.smack.packet.a(NotifyType.SOUND, null, null, null);
                        aVar.b(text);
                        cVar.a(aVar);
                        return cVar;
                    }
                    a(aq.b(aq.a(b2.i, attributeValue2), text));
                    a.next();
                    dVar = a(a);
                } else if (next == 3 && xmlPullParser.getName().equals("message")) {
                    z = true;
                }
            }
            if (dVar == null) {
                throw new l("error while receiving a encrypted message with wrong format");
            }
            return dVar;
        }
        com.xiaomi.smack.packet.c cVar2 = new com.xiaomi.smack.packet.c();
        String attributeValue6 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue6 == null) {
            attributeValue6 = "ID_NOT_AVAILABLE";
        }
        cVar2.k(attributeValue6);
        cVar2.m(xmlPullParser.getAttributeValue("", "to"));
        cVar2.n(xmlPullParser.getAttributeValue("", "from"));
        cVar2.l(xmlPullParser.getAttributeValue("", "chid"));
        cVar2.a(xmlPullParser.getAttributeValue("", "appid"));
        try {
            str = xmlPullParser.getAttributeValue("", "transient");
        } catch (Exception e) {
            str = null;
        }
        try {
            String attributeValue7 = xmlPullParser.getAttributeValue("", "seq");
            if (!TextUtils.isEmpty(attributeValue7)) {
                cVar2.b(attributeValue7);
            }
        } catch (Exception e2) {
        }
        try {
            String attributeValue8 = xmlPullParser.getAttributeValue("", "mseq");
            if (!TextUtils.isEmpty(attributeValue8)) {
                cVar2.c(attributeValue8);
            }
        } catch (Exception e3) {
        }
        try {
            String attributeValue9 = xmlPullParser.getAttributeValue("", "fseq");
            if (!TextUtils.isEmpty(attributeValue9)) {
                cVar2.d(attributeValue9);
            }
        } catch (Exception e4) {
        }
        try {
            String attributeValue10 = xmlPullParser.getAttributeValue("", NotificationCompat.CATEGORY_STATUS);
            if (!TextUtils.isEmpty(attributeValue10)) {
                cVar2.e(attributeValue10);
            }
        } catch (Exception e5) {
        }
        cVar2.a(!TextUtils.isEmpty(str) && str.equalsIgnoreCase("true"));
        cVar2.f(xmlPullParser.getAttributeValue("", "type"));
        String f = f(xmlPullParser);
        if (f == null || "".equals(f.trim())) {
            com.xiaomi.smack.packet.d.u();
        } else {
            cVar2.j(f);
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
                    if (f(xmlPullParser) == null) {
                    }
                    cVar2.g(e(xmlPullParser));
                } else if (name.equals("body")) {
                    String attributeValue11 = xmlPullParser.getAttributeValue("", "encode");
                    String e6 = e(xmlPullParser);
                    if (TextUtils.isEmpty(attributeValue11)) {
                        cVar2.h(e6);
                    } else {
                        cVar2.a(e6, attributeValue11);
                    }
                } else if (name.equals("thread")) {
                    if (str2 == null) {
                        str2 = xmlPullParser.nextText();
                    }
                } else if (name.equals("error")) {
                    cVar2.a(d(xmlPullParser));
                } else {
                    cVar2.a(a(name, namespace, xmlPullParser));
                }
            } else if (next2 == 3 && xmlPullParser.getName().equals("message")) {
                z2 = true;
            }
        }
        cVar2.i(str2);
        return cVar2;
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

    public static com.xiaomi.smack.packet.f b(XmlPullParser xmlPullParser) {
        f.b bVar = f.b.available;
        String attributeValue = xmlPullParser.getAttributeValue("", "type");
        if (attributeValue != null && !attributeValue.equals("")) {
            try {
                bVar = f.b.valueOf(attributeValue);
            } catch (IllegalArgumentException e) {
                System.err.println("Found invalid presence type " + attributeValue);
            }
        }
        com.xiaomi.smack.packet.f fVar = new com.xiaomi.smack.packet.f(bVar);
        fVar.m(xmlPullParser.getAttributeValue("", "to"));
        fVar.n(xmlPullParser.getAttributeValue("", "from"));
        fVar.l(xmlPullParser.getAttributeValue("", "chid"));
        String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue2 == null) {
            attributeValue2 = "ID_NOT_AVAILABLE";
        }
        fVar.k(attributeValue2);
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals(NotificationCompat.CATEGORY_STATUS)) {
                    fVar.a(xmlPullParser.nextText());
                } else if (name.equals(LogFactory.PRIORITY_KEY)) {
                    try {
                        fVar.a(Integer.parseInt(xmlPullParser.nextText()));
                    } catch (NumberFormatException e2) {
                    } catch (IllegalArgumentException e3) {
                        fVar.a(0);
                    }
                } else if (name.equals("show")) {
                    String nextText = xmlPullParser.nextText();
                    try {
                        fVar.a(f.a.valueOf(nextText));
                    } catch (IllegalArgumentException e4) {
                        System.err.println("Found invalid presence mode " + nextText);
                    }
                } else if (name.equals("error")) {
                    fVar.a(d(xmlPullParser));
                } else {
                    fVar.a(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("presence")) {
                z = true;
            }
        }
        return fVar;
    }

    public static com.xiaomi.smack.packet.g c(XmlPullParser xmlPullParser) {
        com.xiaomi.smack.packet.g gVar = null;
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                gVar = new com.xiaomi.smack.packet.g(xmlPullParser.getName());
            } else if (next == 3 && xmlPullParser.getName().equals("error")) {
                z = true;
            }
        }
        return gVar;
    }

    public static com.xiaomi.smack.packet.h d(XmlPullParser xmlPullParser) {
        ArrayList arrayList = new ArrayList();
        String str = null;
        String str2 = null;
        String str3 = WeiboAuthException.DEFAULT_AUTH_ERROR_CODE;
        int i = 0;
        while (i < xmlPullParser.getAttributeCount()) {
            String attributeValue = xmlPullParser.getAttributeName(i).equals("code") ? xmlPullParser.getAttributeValue("", "code") : str3;
            String attributeValue2 = xmlPullParser.getAttributeName(i).equals("type") ? xmlPullParser.getAttributeValue("", "type") : str2;
            if (xmlPullParser.getAttributeName(i).equals("reason")) {
                str = xmlPullParser.getAttributeValue("", "reason");
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
                if (xmlPullParser.getName().equals("error")) {
                    z = true;
                }
            } else if (next == 4) {
                str5 = xmlPullParser.getText();
            }
        }
        return new com.xiaomi.smack.packet.h(Integer.parseInt(str3), str2 == null ? "cancel" : str2, str, str4, str5, arrayList);
    }

    private static String e(XmlPullParser xmlPullParser) {
        String str = "";
        int depth = xmlPullParser.getDepth();
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getDepth() == depth) {
                return str;
            }
            str = str + xmlPullParser.getText();
        }
    }

    private static String f(XmlPullParser xmlPullParser) {
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            if ("xml:lang".equals(attributeName) || ("lang".equals(attributeName) && "xml".equals(xmlPullParser.getAttributePrefix(i)))) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }
}
