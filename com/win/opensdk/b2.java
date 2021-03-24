package com.win.opensdk;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class b2 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d2 f39888a;

    public b2(d2 d2Var) {
        this.f39888a = d2Var;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String str;
        Context context;
        int i = message.what;
        try {
            if (i != 11) {
                if (i == 12) {
                    str = (String) message.obj;
                    context = this.f39888a.f39917a;
                }
            }
            str = (String) message.obj;
            Z0 a2 = a1.a(this.f39888a.f39917a);
            try {
                a2.f39849b = a1.a("ps", new b1(this.f39888a.f39918b));
                a2.a("co", 2002);
                a2.a("msg", str);
            } catch (JSONException unused) {
            }
            a2.a();
            context = this.f39888a.f39917a;
            a2.a(context, Uri.parse(str));
        } catch (Exception unused2) {
        }
    }
}
