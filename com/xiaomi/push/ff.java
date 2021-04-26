package com.xiaomi.push;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
/* loaded from: classes7.dex */
public class ff {

    /* renamed from: a  reason: collision with root package name */
    public XmlPullParser f38407a;

    public ff() {
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            this.f38407a = newPullParser;
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        } catch (XmlPullParserException unused) {
        }
    }

    public gc a(byte[] bArr, fl flVar) {
        this.f38407a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
        this.f38407a.next();
        int eventType = this.f38407a.getEventType();
        String name = this.f38407a.getName();
        if (eventType == 2) {
            if (name.equals("message")) {
                return gk.a(this.f38407a);
            }
            if (name.equals("iq")) {
                return gk.a(this.f38407a, flVar);
            }
            if (name.equals("presence")) {
                return gk.m340a(this.f38407a);
            }
            if (this.f38407a.getName().equals("stream")) {
                return null;
            }
            if (this.f38407a.getName().equals("error")) {
                throw new fw(gk.m341a(this.f38407a));
            }
            if (!this.f38407a.getName().equals("warning")) {
                this.f38407a.getName().equals("bind");
                return null;
            }
            this.f38407a.next();
            this.f38407a.getName().equals("multi-login");
            return null;
        }
        return null;
    }
}
