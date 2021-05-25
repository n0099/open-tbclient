package com.vivo.push.util;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes7.dex */
public final class y implements c {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, Integer> f36739a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap<String, Long> f36740b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<String, String> f36741c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public static y f36742d;

    /* renamed from: e  reason: collision with root package name */
    public Context f36743e;

    /* renamed from: f  reason: collision with root package name */
    public c f36744f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36745g;

    public y(Context context) {
        this.f36745g = false;
        this.f36743e = context;
        this.f36745g = a(context);
        p.d("SystemCache", "init status is " + this.f36745g + ";  curCache is " + this.f36744f);
    }

    public static synchronized y b(Context context) {
        y yVar;
        synchronized (y.class) {
            if (f36742d == null) {
                f36742d = new y(context.getApplicationContext());
            }
            yVar = f36742d;
        }
        return yVar;
    }

    public final void a() {
        x xVar = new x();
        if (xVar.a(this.f36743e)) {
            xVar.a();
            p.d("SystemCache", "sp cache is cleared");
        }
    }

    @Override // com.vivo.push.util.c
    public final void b(String str, String str2) {
        c cVar;
        f36741c.put(str, str2);
        if (!this.f36745g || (cVar = this.f36744f) == null) {
            return;
        }
        cVar.b(str, str2);
    }

    @Override // com.vivo.push.util.c
    public final boolean a(Context context) {
        v vVar = new v();
        this.f36744f = vVar;
        boolean a2 = vVar.a(context);
        if (!a2) {
            u uVar = new u();
            this.f36744f = uVar;
            a2 = uVar.a(context);
        }
        if (!a2) {
            x xVar = new x();
            this.f36744f = xVar;
            a2 = xVar.a(context);
        }
        if (!a2) {
            this.f36744f = null;
        }
        return a2;
    }

    @Override // com.vivo.push.util.c
    public final String a(String str, String str2) {
        c cVar;
        String str3 = f36741c.get(str);
        return (str3 != null || (cVar = this.f36744f) == null) ? str3 : cVar.a(str, str2);
    }
}
