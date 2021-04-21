package com.win.opensdk;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class b2 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d2 f40273a;

    public b2(d2 d2Var) {
        this.f40273a = d2Var;
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
                    context = this.f40273a.f40302a;
                }
            }
            str = (String) message.obj;
            Z0 a2 = a1.a(this.f40273a.f40302a);
            try {
                a2.f40234b = a1.a("ps", new b1(this.f40273a.f40303b));
                a2.a("co", 2002);
                a2.a("msg", str);
            } catch (JSONException unused) {
            }
            a2.a();
            context = this.f40273a.f40302a;
            a2.a(context, Uri.parse(str));
        } catch (Exception unused2) {
        }
    }
}
