package com.xiaomi.push;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
/* loaded from: classes18.dex */
public class fo {

    /* renamed from: a  reason: collision with root package name */
    private XmlPullParser f4678a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fo() {
        try {
            this.f4678a = XmlPullParserFactory.newInstance().newPullParser();
            this.f4678a.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        } catch (XmlPullParserException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public gj a(byte[] bArr, fs fsVar) {
        this.f4678a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
        this.f4678a.next();
        int eventType = this.f4678a.getEventType();
        String name = this.f4678a.getName();
        if (eventType == 2) {
            if (name.equals("message")) {
                return gr.a(this.f4678a);
            }
            if (name.equals("iq")) {
                return gr.a(this.f4678a, fsVar);
            }
            if (name.equals("presence")) {
                return gr.m316a(this.f4678a);
            }
            if (!this.f4678a.getName().equals("stream")) {
                if (this.f4678a.getName().equals(BdStatsConstant.StatsType.ERROR)) {
                    throw new gd(gr.m317a(this.f4678a));
                }
                if (this.f4678a.getName().equals("warning")) {
                    this.f4678a.next();
                    if (this.f4678a.getName().equals("multi-login")) {
                    }
                } else if (this.f4678a.getName().equals("bind")) {
                }
            }
        }
        return null;
    }
}
