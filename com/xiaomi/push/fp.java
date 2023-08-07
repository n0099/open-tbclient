package com.xiaomi.push;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
/* loaded from: classes10.dex */
public class fp {
    public XmlPullParser a;

    public fp() {
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            this.a = newPullParser;
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        } catch (XmlPullParserException unused) {
        }
    }

    public gm a(byte[] bArr, fv fvVar) {
        this.a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
        this.a.next();
        int eventType = this.a.getEventType();
        String name = this.a.getName();
        if (eventType == 2) {
            if (name.equals("message")) {
                return gu.a(this.a);
            }
            if (name.equals("iq")) {
                return gu.a(this.a, fvVar);
            }
            if (name.equals("presence")) {
                return gu.m536a(this.a);
            }
            if (this.a.getName().equals("stream")) {
                return null;
            }
            if (this.a.getName().equals("error")) {
                throw new gg(gu.m537a(this.a));
            }
            if (!this.a.getName().equals("warning")) {
                this.a.getName().equals("bind");
                return null;
            }
            this.a.next();
            this.a.getName().equals("multi-login");
            return null;
        }
        return null;
    }
}
