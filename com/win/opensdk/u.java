package com.win.opensdk;

import android.content.Context;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class u {
    private static u pZC = null;
    private String java = "Poseidon";
    public PBInterstitial pYP;
    private WeakReference pZD;

    private u(Context context) {
        this.pZD = new WeakReference(context);
    }

    public static u iH(Context context) {
        if (pZC == null) {
            synchronized (u.class) {
                if (pZC == null) {
                    pZC = new u(context);
                }
            }
        }
        return pZC;
    }

    public final Context eGE() {
        Object obj;
        if (this.pZD == null || (obj = this.pZD.get()) == null || !(obj instanceof Context)) {
            return null;
        }
        return (Context) obj;
    }
}
