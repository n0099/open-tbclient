package com.win.opensdk;

import android.content.Context;
/* loaded from: classes3.dex */
public class f {
    private static f pYX;
    bp<q> pYY = bp.eGY();
    private q pYZ;

    private f() {
    }

    public static f eGy() {
        synchronized (f.class) {
            if (pYX == null) {
                pYX = new f();
            }
        }
        return pYX;
    }

    public final void a(Context context, String str, af afVar, String str2, bq bqVar) {
        try {
            this.pYZ = this.pYY.aaK(str);
            if (this.pYZ == null) {
                this.pYZ = new q(context, afVar);
            }
            this.pYZ.a(str2, null);
            this.pYZ.pZv = bqVar;
            this.pYY.a(str, this.pYZ);
        } catch (Exception e) {
        }
    }
}
