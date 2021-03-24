package com.xiaomi.push;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
/* loaded from: classes7.dex */
public class ff {

    /* renamed from: a  reason: collision with root package name */
    public XmlPullParser f40500a;

    public ff() {
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            this.f40500a = newPullParser;
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        } catch (XmlPullParserException unused) {
        }
    }

    public gc a(byte[] bArr, fl flVar) {
        this.f40500a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
        this.f40500a.next();
        int eventType = this.f40500a.getEventType();
        String name = this.f40500a.getName();
        if (eventType == 2) {
            if (name.equals("message")) {
                return gk.a(this.f40500a);
            }
            if (name.equals("iq")) {
                return gk.a(this.f40500a, flVar);
            }
            if (name.equals("presence")) {
                return gk.m333a(this.f40500a);
            }
            if (this.f40500a.getName().equals("stream")) {
                return null;
            }
            if (this.f40500a.getName().equals("error")) {
                throw new fw(gk.m334a(this.f40500a));
            }
            if (!this.f40500a.getName().equals("warning")) {
                this.f40500a.getName().equals("bind");
                return null;
            }
            this.f40500a.next();
            this.f40500a.getName().equals("multi-login");
            return null;
        }
        return null;
    }
}
