package com.xiaomi.push;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
/* loaded from: classes7.dex */
public class ff {

    /* renamed from: a  reason: collision with root package name */
    public XmlPullParser f40885a;

    public ff() {
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            this.f40885a = newPullParser;
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        } catch (XmlPullParserException unused) {
        }
    }

    public gc a(byte[] bArr, fl flVar) {
        this.f40885a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
        this.f40885a.next();
        int eventType = this.f40885a.getEventType();
        String name = this.f40885a.getName();
        if (eventType == 2) {
            if (name.equals("message")) {
                return gk.a(this.f40885a);
            }
            if (name.equals("iq")) {
                return gk.a(this.f40885a, flVar);
            }
            if (name.equals("presence")) {
                return gk.m337a(this.f40885a);
            }
            if (this.f40885a.getName().equals("stream")) {
                return null;
            }
            if (this.f40885a.getName().equals("error")) {
                throw new fw(gk.m338a(this.f40885a));
            }
            if (!this.f40885a.getName().equals("warning")) {
                this.f40885a.getName().equals("bind");
                return null;
            }
            this.f40885a.next();
            this.f40885a.getName().equals("multi-login");
            return null;
        }
        return null;
    }
}
