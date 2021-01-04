package com.xiaomi.push;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
/* loaded from: classes6.dex */
public class fo {

    /* renamed from: a  reason: collision with root package name */
    private XmlPullParser f14323a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fo() {
        try {
            this.f14323a = XmlPullParserFactory.newInstance().newPullParser();
            this.f14323a.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        } catch (XmlPullParserException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public gj a(byte[] bArr, fs fsVar) {
        this.f14323a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
        this.f14323a.next();
        int eventType = this.f14323a.getEventType();
        String name = this.f14323a.getName();
        if (eventType == 2) {
            if (name.equals("message")) {
                return gr.a(this.f14323a);
            }
            if (name.equals("iq")) {
                return gr.a(this.f14323a, fsVar);
            }
            if (name.equals("presence")) {
                return gr.m342a(this.f14323a);
            }
            if (!this.f14323a.getName().equals("stream")) {
                if (this.f14323a.getName().equals(BdStatsConstant.StatsType.ERROR)) {
                    throw new gd(gr.m343a(this.f14323a));
                }
                if (this.f14323a.getName().equals("warning")) {
                    this.f14323a.next();
                    if (this.f14323a.getName().equals("multi-login")) {
                    }
                } else if (this.f14323a.getName().equals("bind")) {
                }
            }
        }
        return null;
    }
}
