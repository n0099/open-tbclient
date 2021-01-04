package com.win.opensdk;

import android.content.Context;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class u {
    private static u qcu = null;
    private String java = "Poseidon";
    public PBInterstitial qbH;
    private WeakReference qcv;

    private u(Context context) {
        this.qcv = new WeakReference(context);
    }

    public static u iJ(Context context) {
        if (qcu == null) {
            synchronized (u.class) {
                if (qcu == null) {
                    qcu = new u(context);
                }
            }
        }
        return qcu;
    }

    public final Context eJQ() {
        Object obj;
        if (this.qcv == null || (obj = this.qcv.get()) == null || !(obj instanceof Context)) {
            return null;
        }
        return (Context) obj;
    }
}
