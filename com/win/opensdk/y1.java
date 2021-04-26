package com.win.opensdk;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import org.json.JSONException;
/* loaded from: classes6.dex */
public class y1 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ A1 f38011a;

    public y1(A1 a1) {
        this.f38011a = a1;
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
                    context = this.f38011a.f37608a;
                }
            }
            str = (String) message.obj;
            w0 a2 = x0.a(this.f38011a.f37608a);
            try {
                a2.f37984b = x0.a("ps", new y0(this.f38011a.f37609b));
                a2.a("co", 2002);
                a2.a("msg", str);
            } catch (JSONException unused) {
            }
            a2.a();
            context = this.f38011a.f37608a;
            x1.a(context, Uri.parse(str));
        } catch (Exception unused2) {
        }
    }
}
