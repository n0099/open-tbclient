package com.xiaomi.push;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
/* loaded from: classes7.dex */
public class ff {

    /* renamed from: a  reason: collision with root package name */
    public XmlPullParser f41260a;

    public ff() {
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            this.f41260a = newPullParser;
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        } catch (XmlPullParserException unused) {
        }
    }

    public gc a(byte[] bArr, fl flVar) {
        this.f41260a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
        this.f41260a.next();
        int eventType = this.f41260a.getEventType();
        String name = this.f41260a.getName();
        if (eventType == 2) {
            if (name.equals("message")) {
                return gk.a(this.f41260a);
            }
            if (name.equals("iq")) {
                return gk.a(this.f41260a, flVar);
            }
            if (name.equals("presence")) {
                return gk.m338a(this.f41260a);
            }
            if (this.f41260a.getName().equals("stream")) {
                return null;
            }
            if (this.f41260a.getName().equals("error")) {
                throw new fw(gk.m339a(this.f41260a));
            }
            if (!this.f41260a.getName().equals("warning")) {
                this.f41260a.getName().equals("bind");
                return null;
            }
            this.f41260a.next();
            this.f41260a.getName().equals("multi-login");
            return null;
        }
        return null;
    }
}
