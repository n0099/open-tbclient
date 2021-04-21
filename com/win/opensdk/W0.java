package com.win.opensdk;

import android.content.Context;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class W0 {

    /* renamed from: d  reason: collision with root package name */
    public static W0 f40209d;

    /* renamed from: a  reason: collision with root package name */
    public WeakReference f40210a;

    /* renamed from: b  reason: collision with root package name */
    public PBInterstitial f40211b;

    /* renamed from: c  reason: collision with root package name */
    public String f40212c = "Poseidon";

    public W0(Context context) {
        this.f40210a = new WeakReference(context);
    }

    public static W0 a(Context context) {
        if (f40209d == null) {
            synchronized (W0.class) {
                if (f40209d == null) {
                    f40209d = new W0(context);
                }
            }
        }
        return f40209d;
    }

    public final Context a() {
        Object obj;
        WeakReference weakReference = this.f40210a;
        if (weakReference == null || (obj = weakReference.get()) == null || !(obj instanceof Context)) {
            return null;
        }
        return (Context) obj;
    }
}
