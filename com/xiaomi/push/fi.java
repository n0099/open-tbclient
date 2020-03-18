package com.xiaomi.push;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
/* loaded from: classes8.dex */
public class fi {
    private XmlPullParser a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fi() {
        try {
            this.a = XmlPullParserFactory.newInstance().newPullParser();
            this.a.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        } catch (XmlPullParserException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public gd a(byte[] bArr, fm fmVar) {
        this.a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
        this.a.next();
        int eventType = this.a.getEventType();
        String name = this.a.getName();
        if (eventType == 2) {
            if (name.equals("message")) {
                return gl.a(this.a);
            }
            if (name.equals("iq")) {
                return gl.a(this.a, fmVar);
            }
            if (name.equals("presence")) {
                return gl.m310a(this.a);
            }
            if (!this.a.getName().equals("stream")) {
                if (this.a.getName().equals(BdStatsConstant.StatsType.ERROR)) {
                    throw new fx(gl.m311a(this.a));
                }
                if (this.a.getName().equals("warning")) {
                    this.a.next();
                    if (this.a.getName().equals("multi-login")) {
                    }
                } else if (this.a.getName().equals("bind")) {
                }
            }
        }
        return null;
    }
}
