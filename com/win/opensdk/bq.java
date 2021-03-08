package com.win.opensdk;

import android.content.Context;
import java.lang.ref.WeakReference;
/* loaded from: classes14.dex */
public class bq {
    public static bq qlg;

    /* renamed from: a  reason: collision with root package name */
    public WeakReference f8121a;
    public String c = "Poseidon";
    public PBInterstitial qlh;

    public bq(Context context) {
        this.f8121a = new WeakReference(context);
    }

    public static bq iS(Context context) {
        if (qlg == null) {
            synchronized (bq.class) {
                if (qlg == null) {
                    qlg = new bq(context);
                }
            }
        }
        return qlg;
    }

    public final Context a() {
        Object obj;
        WeakReference weakReference = this.f8121a;
        if (weakReference == null || (obj = weakReference.get()) == null || !(obj instanceof Context)) {
            return null;
        }
        return (Context) obj;
    }
}
