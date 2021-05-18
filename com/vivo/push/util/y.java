package com.vivo.push.util;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes7.dex */
public final class y implements c {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, Integer> f36810a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap<String, Long> f36811b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<String, String> f36812c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public static y f36813d;

    /* renamed from: e  reason: collision with root package name */
    public Context f36814e;

    /* renamed from: f  reason: collision with root package name */
    public c f36815f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36816g;

    public y(Context context) {
        this.f36816g = false;
        this.f36814e = context;
        this.f36816g = a(context);
        p.d("SystemCache", "init status is " + this.f36816g + ";  curCache is " + this.f36815f);
    }

    public static synchronized y b(Context context) {
        y yVar;
        synchronized (y.class) {
            if (f36813d == null) {
                f36813d = new y(context.getApplicationContext());
            }
            yVar = f36813d;
        }
        return yVar;
    }

    public final void a() {
        x xVar = new x();
        if (xVar.a(this.f36814e)) {
            xVar.a();
            p.d("SystemCache", "sp cache is cleared");
        }
    }

    @Override // com.vivo.push.util.c
    public final void b(String str, String str2) {
        c cVar;
        f36812c.put(str, str2);
        if (!this.f36816g || (cVar = this.f36815f) == null) {
            return;
        }
        cVar.b(str, str2);
    }

    @Override // com.vivo.push.util.c
    public final boolean a(Context context) {
        v vVar = new v();
        this.f36815f = vVar;
        boolean a2 = vVar.a(context);
        if (!a2) {
            u uVar = new u();
            this.f36815f = uVar;
            a2 = uVar.a(context);
        }
        if (!a2) {
            x xVar = new x();
            this.f36815f = xVar;
            a2 = xVar.a(context);
        }
        if (!a2) {
            this.f36815f = null;
        }
        return a2;
    }

    @Override // com.vivo.push.util.c
    public final String a(String str, String str2) {
        c cVar;
        String str3 = f36812c.get(str);
        return (str3 != null || (cVar = this.f36815f) == null) ? str3 : cVar.a(str, str2);
    }
}
