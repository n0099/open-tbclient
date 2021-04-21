package com.win.opensdk;

import android.content.Context;
/* loaded from: classes7.dex */
public class E0 {

    /* renamed from: c  reason: collision with root package name */
    public static E0 f40043c;

    /* renamed from: a  reason: collision with root package name */
    public B2 f40044a = B2.a();

    /* renamed from: b  reason: collision with root package name */
    public R0 f40045b;

    public static E0 a() {
        synchronized (E0.class) {
            if (f40043c == null) {
                f40043c = new E0();
            }
        }
        return f40043c;
    }

    public void a(Context context, String str, K0 k0, String str2, C2 c2) {
        try {
            R0 r0 = (R0) this.f40044a.a(str);
            this.f40045b = r0;
            if (r0 == null) {
                this.f40045b = new R0(context, k0);
            }
            this.f40045b.a(str2, null);
            this.f40045b.f40168c = c2;
            this.f40044a.a(str, this.f40045b);
        } catch (Exception unused) {
        }
    }
}
