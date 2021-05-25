package com.xiaomi.push;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
/* loaded from: classes7.dex */
public class ff {

    /* renamed from: a  reason: collision with root package name */
    public XmlPullParser f37581a;

    public ff() {
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            this.f37581a = newPullParser;
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        } catch (XmlPullParserException unused) {
        }
    }

    public gc a(byte[] bArr, fl flVar) {
        this.f37581a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
        this.f37581a.next();
        int eventType = this.f37581a.getEventType();
        String name = this.f37581a.getName();
        if (eventType == 2) {
            if (name.equals("message")) {
                return gk.a(this.f37581a);
            }
            if (name.equals("iq")) {
                return gk.a(this.f37581a, flVar);
            }
            if (name.equals("presence")) {
                return gk.m339a(this.f37581a);
            }
            if (this.f37581a.getName().equals("stream")) {
                return null;
            }
            if (this.f37581a.getName().equals("error")) {
                throw new fw(gk.m340a(this.f37581a));
            }
            if (!this.f37581a.getName().equals("warning")) {
                this.f37581a.getName().equals("bind");
                return null;
            }
            this.f37581a.next();
            this.f37581a.getName().equals("multi-login");
            return null;
        }
        return null;
    }
}
