package com.xiaomi.push;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
/* loaded from: classes5.dex */
public class fo {

    /* renamed from: a  reason: collision with root package name */
    private XmlPullParser f8371a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fo() {
        try {
            this.f8371a = XmlPullParserFactory.newInstance().newPullParser();
            this.f8371a.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        } catch (XmlPullParserException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public gj a(byte[] bArr, fs fsVar) {
        this.f8371a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
        this.f8371a.next();
        int eventType = this.f8371a.getEventType();
        String name = this.f8371a.getName();
        if (eventType == 2) {
            if (name.equals("message")) {
                return gr.a(this.f8371a);
            }
            if (name.equals("iq")) {
                return gr.a(this.f8371a, fsVar);
            }
            if (name.equals("presence")) {
                return gr.m327a(this.f8371a);
            }
            if (!this.f8371a.getName().equals("stream")) {
                if (this.f8371a.getName().equals(BdStatsConstant.StatsType.ERROR)) {
                    throw new gd(gr.m328a(this.f8371a));
                }
                if (this.f8371a.getName().equals("warning")) {
                    this.f8371a.next();
                    if (this.f8371a.getName().equals("multi-login")) {
                    }
                } else if (this.f8371a.getName().equals("bind")) {
                }
            }
        }
        return null;
    }
}
