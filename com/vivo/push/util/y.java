package com.vivo.push.util;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes7.dex */
public final class y implements c {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, Integer> f39575a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap<String, Long> f39576b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<String, String> f39577c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public static y f39578d;

    /* renamed from: e  reason: collision with root package name */
    public Context f39579e;

    /* renamed from: f  reason: collision with root package name */
    public c f39580f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f39581g;

    public y(Context context) {
        this.f39581g = false;
        this.f39579e = context;
        this.f39581g = a(context);
        p.d("SystemCache", "init status is " + this.f39581g + ";  curCache is " + this.f39580f);
    }

    public static synchronized y b(Context context) {
        y yVar;
        synchronized (y.class) {
            if (f39578d == null) {
                f39578d = new y(context.getApplicationContext());
            }
            yVar = f39578d;
        }
        return yVar;
    }

    public final void a() {
        x xVar = new x();
        if (xVar.a(this.f39579e)) {
            xVar.a();
            p.d("SystemCache", "sp cache is cleared");
        }
    }

    @Override // com.vivo.push.util.c
    public final void b(String str, String str2) {
        c cVar;
        f39577c.put(str, str2);
        if (!this.f39581g || (cVar = this.f39580f) == null) {
            return;
        }
        cVar.b(str, str2);
    }

    @Override // com.vivo.push.util.c
    public final boolean a(Context context) {
        v vVar = new v();
        this.f39580f = vVar;
        boolean a2 = vVar.a(context);
        if (!a2) {
            u uVar = new u();
            this.f39580f = uVar;
            a2 = uVar.a(context);
        }
        if (!a2) {
            x xVar = new x();
            this.f39580f = xVar;
            a2 = xVar.a(context);
        }
        if (!a2) {
            this.f39580f = null;
        }
        return a2;
    }

    @Override // com.vivo.push.util.c
    public final String a(String str, String str2) {
        c cVar;
        String str3 = f39577c.get(str);
        return (str3 != null || (cVar = this.f39580f) == null) ? str3 : cVar.a(str, str2);
    }
}
