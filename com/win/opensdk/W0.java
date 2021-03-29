package com.win.opensdk;

import android.content.Context;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class W0 {

    /* renamed from: d  reason: collision with root package name */
    public static W0 f39825d;

    /* renamed from: a  reason: collision with root package name */
    public WeakReference f39826a;

    /* renamed from: b  reason: collision with root package name */
    public PBInterstitial f39827b;

    /* renamed from: c  reason: collision with root package name */
    public String f39828c = "Poseidon";

    public W0(Context context) {
        this.f39826a = new WeakReference(context);
    }

    public static W0 a(Context context) {
        if (f39825d == null) {
            synchronized (W0.class) {
                if (f39825d == null) {
                    f39825d = new W0(context);
                }
            }
        }
        return f39825d;
    }

    public final Context a() {
        Object obj;
        WeakReference weakReference = this.f39826a;
        if (weakReference == null || (obj = weakReference.get()) == null || !(obj instanceof Context)) {
            return null;
        }
        return (Context) obj;
    }
}
