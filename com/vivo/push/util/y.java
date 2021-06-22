package com.vivo.push.util;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes7.dex */
public final class y implements c {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, Integer> f40521a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap<String, Long> f40522b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<String, String> f40523c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public static y f40524d;

    /* renamed from: e  reason: collision with root package name */
    public Context f40525e;

    /* renamed from: f  reason: collision with root package name */
    public c f40526f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f40527g;

    public y(Context context) {
        this.f40527g = false;
        this.f40525e = context;
        this.f40527g = a(context);
        p.d("SystemCache", "init status is " + this.f40527g + ";  curCache is " + this.f40526f);
    }

    public static synchronized y b(Context context) {
        y yVar;
        synchronized (y.class) {
            if (f40524d == null) {
                f40524d = new y(context.getApplicationContext());
            }
            yVar = f40524d;
        }
        return yVar;
    }

    public final void a() {
        x xVar = new x();
        if (xVar.a(this.f40525e)) {
            xVar.a();
            p.d("SystemCache", "sp cache is cleared");
        }
    }

    @Override // com.vivo.push.util.c
    public final void b(String str, String str2) {
        c cVar;
        f40523c.put(str, str2);
        if (!this.f40527g || (cVar = this.f40526f) == null) {
            return;
        }
        cVar.b(str, str2);
    }

    @Override // com.vivo.push.util.c
    public final boolean a(Context context) {
        v vVar = new v();
        this.f40526f = vVar;
        boolean a2 = vVar.a(context);
        if (!a2) {
            u uVar = new u();
            this.f40526f = uVar;
            a2 = uVar.a(context);
        }
        if (!a2) {
            x xVar = new x();
            this.f40526f = xVar;
            a2 = xVar.a(context);
        }
        if (!a2) {
            this.f40526f = null;
        }
        return a2;
    }

    @Override // com.vivo.push.util.c
    public final String a(String str, String str2) {
        c cVar;
        String str3 = f40523c.get(str);
        return (str3 != null || (cVar = this.f40526f) == null) ? str3 : cVar.a(str, str2);
    }
}
