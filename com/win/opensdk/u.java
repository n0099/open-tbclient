package com.win.opensdk;

import android.content.Context;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class u {
    private static u qjG = null;
    private String java = "Poseidon";
    public PBInterstitial qiT;
    private WeakReference qjH;

    private u(Context context) {
        this.qjH = new WeakReference(context);
    }

    public static u iK(Context context) {
        if (qjG == null) {
            synchronized (u.class) {
                if (qjG == null) {
                    qjG = new u(context);
                }
            }
        }
        return qjG;
    }

    public final Context eIU() {
        Object obj;
        if (this.qjH == null || (obj = this.qjH.get()) == null || !(obj instanceof Context)) {
            return null;
        }
        return (Context) obj;
    }
}
