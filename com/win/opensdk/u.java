package com.win.opensdk;

import android.content.Context;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class u {
    private static u pZB = null;
    private String java = "Poseidon";
    public PBInterstitial pYO;
    private WeakReference pZC;

    private u(Context context) {
        this.pZC = new WeakReference(context);
    }

    public static u iH(Context context) {
        if (pZB == null) {
            synchronized (u.class) {
                if (pZB == null) {
                    pZB = new u(context);
                }
            }
        }
        return pZB;
    }

    public final Context eGE() {
        Object obj;
        if (this.pZC == null || (obj = this.pZC.get()) == null || !(obj instanceof Context)) {
            return null;
        }
        return (Context) obj;
    }
}
