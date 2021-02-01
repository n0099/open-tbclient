package com.win.opensdk;

import android.content.Context;
/* loaded from: classes3.dex */
public class f {
    private static f qjc;
    bp<q> qjd = bp.eJo();
    private q qje;

    private f() {
    }

    public static f eIO() {
        synchronized (f.class) {
            if (qjc == null) {
                qjc = new f();
            }
        }
        return qjc;
    }

    public final void a(Context context, String str, af afVar, String str2, bq bqVar) {
        try {
            this.qje = this.qjd.abM(str);
            if (this.qje == null) {
                this.qje = new q(context, afVar);
            }
            this.qje.a(str2, null);
            this.qje.qjA = bqVar;
            this.qjd.a(str, this.qje);
        } catch (Exception e) {
        }
    }
}
