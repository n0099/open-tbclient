package com.win.opensdk;

import android.content.Context;
/* loaded from: classes7.dex */
public class E0 {

    /* renamed from: c  reason: collision with root package name */
    public static E0 f39948c;

    /* renamed from: a  reason: collision with root package name */
    public B2 f39949a = B2.a();

    /* renamed from: b  reason: collision with root package name */
    public R0 f39950b;

    public static E0 a() {
        synchronized (E0.class) {
            if (f39948c == null) {
                f39948c = new E0();
            }
        }
        return f39948c;
    }

    public void a(Context context, String str, K0 k0, String str2, C2 c2) {
        try {
            R0 r0 = (R0) this.f39949a.a(str);
            this.f39950b = r0;
            if (r0 == null) {
                this.f39950b = new R0(context, k0);
            }
            this.f39950b.a(str2, null);
            this.f39950b.f40073c = c2;
            this.f39949a.a(str, this.f39950b);
        } catch (Exception unused) {
        }
    }
}
