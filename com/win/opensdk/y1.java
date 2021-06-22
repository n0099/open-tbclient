package com.win.opensdk;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class y1 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ A1 f40967a;

    public y1(A1 a1) {
        this.f40967a = a1;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String str;
        Context context;
        int i2 = message.what;
        try {
            if (i2 != 11) {
                if (i2 == 12) {
                    str = (String) message.obj;
                    context = this.f40967a.f40564a;
                }
            }
            str = (String) message.obj;
            w0 a2 = x0.a(this.f40967a.f40564a);
            try {
                a2.f40940b = x0.a("ps", new y0(this.f40967a.f40565b));
                a2.a("co", 2002);
                a2.a("msg", str);
            } catch (JSONException unused) {
            }
            a2.a();
            context = this.f40967a.f40564a;
            x1.a(context, Uri.parse(str));
        } catch (Exception unused2) {
        }
    }
}
