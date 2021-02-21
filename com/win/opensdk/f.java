package com.win.opensdk;

import android.content.Context;
/* loaded from: classes3.dex */
public class f {
    private static f qjC;
    bp<q> qjD = bp.eJw();
    private q qjE;

    private f() {
    }

    public static f eIW() {
        synchronized (f.class) {
            if (qjC == null) {
                qjC = new f();
            }
        }
        return qjC;
    }

    public final void a(Context context, String str, af afVar, String str2, bq bqVar) {
        try {
            this.qjE = this.qjD.abY(str);
            if (this.qjE == null) {
                this.qjE = new q(context, afVar);
            }
            this.qjE.a(str2, null);
            this.qjE.qka = bqVar;
            this.qjD.a(str, this.qjE);
        } catch (Exception e) {
        }
    }
}
