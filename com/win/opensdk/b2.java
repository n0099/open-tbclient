package com.win.opensdk;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class b2 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d2 f39889a;

    public b2(d2 d2Var) {
        this.f39889a = d2Var;
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
                    context = this.f39889a.f39918a;
                }
            }
            str = (String) message.obj;
            Z0 a2 = a1.a(this.f39889a.f39918a);
            try {
                a2.f39850b = a1.a("ps", new b1(this.f39889a.f39919b));
                a2.a("co", 2002);
                a2.a("msg", str);
            } catch (JSONException unused) {
            }
            a2.a();
            context = this.f39889a.f39918a;
            a2.a(context, Uri.parse(str));
        } catch (Exception unused2) {
        }
    }
}
