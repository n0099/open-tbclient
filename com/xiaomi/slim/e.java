package com.xiaomi.slim;

import com.baidu.android.pushservice.PushConstants;
import com.xiaomi.smack.l;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
/* loaded from: classes2.dex */
public class e {
    private XmlPullParser a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e() {
        try {
            this.a = XmlPullParserFactory.newInstance().newPullParser();
            this.a.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        } catch (XmlPullParserException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.xiaomi.smack.packet.d a(byte[] bArr, com.xiaomi.smack.a aVar) {
        this.a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
        this.a.next();
        int eventType = this.a.getEventType();
        String name = this.a.getName();
        if (eventType == 2) {
            if (name.equals(PushConstants.EXTRA_PUSH_MESSAGE)) {
                return com.xiaomi.smack.util.a.a(this.a);
            }
            if (name.equals("iq")) {
                return com.xiaomi.smack.util.a.a(this.a, aVar);
            }
            if (name.equals("presence")) {
                return com.xiaomi.smack.util.a.b(this.a);
            }
            if (!this.a.getName().equals("stream")) {
                if (this.a.getName().equals("error")) {
                    throw new l(com.xiaomi.smack.util.a.c(this.a));
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
