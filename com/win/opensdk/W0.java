package com.win.opensdk;

import android.content.Context;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class W0 {

    /* renamed from: d  reason: collision with root package name */
    public static W0 f39824d;

    /* renamed from: a  reason: collision with root package name */
    public WeakReference f39825a;

    /* renamed from: b  reason: collision with root package name */
    public PBInterstitial f39826b;

    /* renamed from: c  reason: collision with root package name */
    public String f39827c = "Poseidon";

    public W0(Context context) {
        this.f39825a = new WeakReference(context);
    }

    public static W0 a(Context context) {
        if (f39824d == null) {
            synchronized (W0.class) {
                if (f39824d == null) {
                    f39824d = new W0(context);
                }
            }
        }
        return f39824d;
    }

    public final Context a() {
        Object obj;
        WeakReference weakReference = this.f39825a;
        if (weakReference == null || (obj = weakReference.get()) == null || !(obj instanceof Context)) {
            return null;
        }
        return (Context) obj;
    }
}
