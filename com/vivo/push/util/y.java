package com.vivo.push.util;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes6.dex */
public final class y implements c {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, Integer> f37565a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap<String, Long> f37566b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<String, String> f37567c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public static y f37568d;

    /* renamed from: e  reason: collision with root package name */
    public Context f37569e;

    /* renamed from: f  reason: collision with root package name */
    public c f37570f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f37571g;

    public y(Context context) {
        this.f37571g = false;
        this.f37569e = context;
        this.f37571g = a(context);
        p.d("SystemCache", "init status is " + this.f37571g + ";  curCache is " + this.f37570f);
    }

    public static synchronized y b(Context context) {
        y yVar;
        synchronized (y.class) {
            if (f37568d == null) {
                f37568d = new y(context.getApplicationContext());
            }
            yVar = f37568d;
        }
        return yVar;
    }

    public final void a() {
        x xVar = new x();
        if (xVar.a(this.f37569e)) {
            xVar.a();
            p.d("SystemCache", "sp cache is cleared");
        }
    }

    @Override // com.vivo.push.util.c
    public final void b(String str, String str2) {
        c cVar;
        f37567c.put(str, str2);
        if (!this.f37571g || (cVar = this.f37570f) == null) {
            return;
        }
        cVar.b(str, str2);
    }

    @Override // com.vivo.push.util.c
    public final boolean a(Context context) {
        v vVar = new v();
        this.f37570f = vVar;
        boolean a2 = vVar.a(context);
        if (!a2) {
            u uVar = new u();
            this.f37570f = uVar;
            a2 = uVar.a(context);
        }
        if (!a2) {
            x xVar = new x();
            this.f37570f = xVar;
            a2 = xVar.a(context);
        }
        if (!a2) {
            this.f37570f = null;
        }
        return a2;
    }

    @Override // com.vivo.push.util.c
    public final String a(String str, String str2) {
        c cVar;
        String str3 = f37567c.get(str);
        return (str3 != null || (cVar = this.f37570f) == null) ? str3 : cVar.a(str, str2);
    }
}
