package com.vivo.push.util;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes7.dex */
public final class y implements c {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, Integer> f39960a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap<String, Long> f39961b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<String, String> f39962c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public static y f39963d;

    /* renamed from: e  reason: collision with root package name */
    public Context f39964e;

    /* renamed from: f  reason: collision with root package name */
    public c f39965f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f39966g;

    public y(Context context) {
        this.f39966g = false;
        this.f39964e = context;
        this.f39966g = a(context);
        p.d("SystemCache", "init status is " + this.f39966g + ";  curCache is " + this.f39965f);
    }

    public static synchronized y b(Context context) {
        y yVar;
        synchronized (y.class) {
            if (f39963d == null) {
                f39963d = new y(context.getApplicationContext());
            }
            yVar = f39963d;
        }
        return yVar;
    }

    public final void a() {
        x xVar = new x();
        if (xVar.a(this.f39964e)) {
            xVar.a();
            p.d("SystemCache", "sp cache is cleared");
        }
    }

    @Override // com.vivo.push.util.c
    public final void b(String str, String str2) {
        c cVar;
        f39962c.put(str, str2);
        if (!this.f39966g || (cVar = this.f39965f) == null) {
            return;
        }
        cVar.b(str, str2);
    }

    @Override // com.vivo.push.util.c
    public final boolean a(Context context) {
        v vVar = new v();
        this.f39965f = vVar;
        boolean a2 = vVar.a(context);
        if (!a2) {
            u uVar = new u();
            this.f39965f = uVar;
            a2 = uVar.a(context);
        }
        if (!a2) {
            x xVar = new x();
            this.f39965f = xVar;
            a2 = xVar.a(context);
        }
        if (!a2) {
            this.f39965f = null;
        }
        return a2;
    }

    @Override // com.vivo.push.util.c
    public final String a(String str, String str2) {
        c cVar;
        String str3 = f39962c.get(str);
        return (str3 != null || (cVar = this.f39965f) == null) ? str3 : cVar.a(str, str2);
    }
}
