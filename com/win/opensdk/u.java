package com.win.opensdk;

import android.content.Context;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class u {
    private static u qec = null;
    private String java = "Poseidon";
    public PBInterstitial qdp;
    private WeakReference qed;

    private u(Context context) {
        this.qed = new WeakReference(context);
    }

    public static u iJ(Context context) {
        if (qec == null) {
            synchronized (u.class) {
                if (qec == null) {
                    qec = new u(context);
                }
            }
        }
        return qec;
    }

    public final Context eKu() {
        Object obj;
        if (this.qed == null || (obj = this.qed.get()) == null || !(obj instanceof Context)) {
            return null;
        }
        return (Context) obj;
    }
}
