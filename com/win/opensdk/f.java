package com.win.opensdk;

import android.content.Context;
/* loaded from: classes4.dex */
public class f {
    private static f qdy;
    private q qdA;
    bp<q> qdz = bp.eKO();

    private f() {
    }

    public static f eKo() {
        synchronized (f.class) {
            if (qdy == null) {
                qdy = new f();
            }
        }
        return qdy;
    }

    public final void a(Context context, String str, af afVar, String str2, bq bqVar) {
        try {
            this.qdA = this.qdz.abS(str);
            if (this.qdA == null) {
                this.qdA = new q(context, afVar);
            }
            this.qdA.a(str2, null);
            this.qdA.qdW = bqVar;
            this.qdz.a(str, this.qdA);
        } catch (Exception e) {
        }
    }
}
