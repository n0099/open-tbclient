package com.win.opensdk;

import android.content.Context;
/* loaded from: classes3.dex */
public class f {
    private static f pYY;
    bp<q> pYZ = bp.eGY();
    private q pZa;

    private f() {
    }

    public static f eGy() {
        synchronized (f.class) {
            if (pYY == null) {
                pYY = new f();
            }
        }
        return pYY;
    }

    public final void a(Context context, String str, af afVar, String str2, bq bqVar) {
        try {
            this.pZa = this.pYZ.aaL(str);
            if (this.pZa == null) {
                this.pZa = new q(context, afVar);
            }
            this.pZa.a(str2, null);
            this.pZa.pZw = bqVar;
            this.pYZ.a(str, this.pZa);
        } catch (Exception e) {
        }
    }
}
