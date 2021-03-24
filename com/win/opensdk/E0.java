package com.win.opensdk;

import android.content.Context;
/* loaded from: classes7.dex */
public class E0 {

    /* renamed from: c  reason: collision with root package name */
    public static E0 f39658c;

    /* renamed from: a  reason: collision with root package name */
    public B2 f39659a = B2.a();

    /* renamed from: b  reason: collision with root package name */
    public R0 f39660b;

    public static E0 a() {
        synchronized (E0.class) {
            if (f39658c == null) {
                f39658c = new E0();
            }
        }
        return f39658c;
    }

    public void a(Context context, String str, K0 k0, String str2, C2 c2) {
        try {
            R0 r0 = (R0) this.f39659a.a(str);
            this.f39660b = r0;
            if (r0 == null) {
                this.f39660b = new R0(context, k0);
            }
            this.f39660b.a(str2, null);
            this.f39660b.f39783c = c2;
            this.f39659a.a(str, this.f39660b);
        } catch (Exception unused) {
        }
    }
}
