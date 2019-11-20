package com.xiaomi.push.service;

import com.xiaomi.push.ga;
import com.xiaomi.push.gj;
import com.xiaomi.push.gk;
import com.xiaomi.push.go;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes3.dex */
public class e implements gj {
    public static ga a(XmlPullParser xmlPullParser) {
        String str;
        String[] strArr;
        String[] strArr2;
        ArrayList arrayList = null;
        if (xmlPullParser.getEventType() != 2) {
            return null;
        }
        String name = xmlPullParser.getName();
        String namespace = xmlPullParser.getNamespace();
        if (xmlPullParser.getAttributeCount() > 0) {
            strArr2 = new String[xmlPullParser.getAttributeCount()];
            strArr = new String[xmlPullParser.getAttributeCount()];
            for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
                strArr2[i] = xmlPullParser.getAttributeName(i);
                strArr[i] = go.b(xmlPullParser.getAttributeValue(i));
            }
            str = null;
        } else {
            str = null;
            strArr = null;
            strArr2 = null;
        }
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3) {
                return new ga(name, namespace, strArr2, strArr, str, arrayList);
            }
            if (next == 4) {
                str = xmlPullParser.getText().trim();
            } else if (next == 2) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                ga a = a(xmlPullParser);
                if (a != null) {
                    arrayList.add(a);
                }
            }
        }
    }

    public void a() {
        gk.a().a("all", "xm:chat", this);
    }

    public ga b(XmlPullParser xmlPullParser) {
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1 && eventType != 2) {
            eventType = xmlPullParser.next();
        }
        if (eventType == 2) {
            return a(xmlPullParser);
        }
        return null;
    }
}
