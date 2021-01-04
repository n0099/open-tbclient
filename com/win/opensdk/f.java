package com.win.opensdk;

import android.content.Context;
/* loaded from: classes4.dex */
public class f {
    private static f qbQ;
    bp<q> qbR = bp.eKk();
    private q qbS;

    private f() {
    }

    public static f eJK() {
        synchronized (f.class) {
            if (qbQ == null) {
                qbQ = new f();
            }
        }
        return qbQ;
    }

    public final void a(Context context, String str, af afVar, String str2, bq bqVar) {
        try {
            this.qbS = this.qbR.abR(str);
            if (this.qbS == null) {
                this.qbS = new q(context, afVar);
            }
            this.qbS.a(str2, null);
            this.qbS.qco = bqVar;
            this.qbR.a(str, this.qbS);
        } catch (Exception e) {
        }
    }
}
