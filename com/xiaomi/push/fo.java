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
    private XmlPullParser f4908a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fo() {
        try {
            this.f4908a = XmlPullParserFactory.newInstance().newPullParser();
            this.f4908a.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        } catch (XmlPullParserException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public gj a(byte[] bArr, fs fsVar) {
        this.f4908a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
        this.f4908a.next();
        int eventType = this.f4908a.getEventType();
        String name = this.f4908a.getName();
        if (eventType == 2) {
            if (name.equals("message")) {
                return gr.a(this.f4908a);
            }
            if (name.equals("iq")) {
                return gr.a(this.f4908a, fsVar);
            }
            if (name.equals("presence")) {
                return gr.m326a(this.f4908a);
            }
            if (!this.f4908a.getName().equals("stream")) {
                if (this.f4908a.getName().equals(BdStatsConstant.StatsType.ERROR)) {
                    throw new gd(gr.m327a(this.f4908a));
                }
                if (this.f4908a.getName().equals("warning")) {
                    this.f4908a.next();
                    if (this.f4908a.getName().equals("multi-login")) {
                    }
                } else if (this.f4908a.getName().equals("bind")) {
                }
            }
        }
        return null;
    }
}
