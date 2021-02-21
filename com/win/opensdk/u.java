package com.win.opensdk;

import android.content.Context;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class u {
    private static u qkg = null;
    private String java = "Poseidon";
    public PBInterstitial qjt;
    private WeakReference qkh;

    private u(Context context) {
        this.qkh = new WeakReference(context);
    }

    public static u iK(Context context) {
        if (qkg == null) {
            synchronized (u.class) {
                if (qkg == null) {
                    qkg = new u(context);
                }
            }
        }
        return qkg;
    }

    public final Context eJc() {
        Object obj;
        if (this.qkh == null || (obj = this.qkh.get()) == null || !(obj instanceof Context)) {
            return null;
        }
        return (Context) obj;
    }
}
