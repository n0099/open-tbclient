package com.vivo.push.util;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes7.dex */
public final class y implements c {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, Integer> f39865a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap<String, Long> f39866b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<String, String> f39867c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public static y f39868d;

    /* renamed from: e  reason: collision with root package name */
    public Context f39869e;

    /* renamed from: f  reason: collision with root package name */
    public c f39870f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f39871g;

    public y(Context context) {
        this.f39871g = false;
        this.f39869e = context;
        this.f39871g = a(context);
        p.d("SystemCache", "init status is " + this.f39871g + ";  curCache is " + this.f39870f);
    }

    public static synchronized y b(Context context) {
        y yVar;
        synchronized (y.class) {
            if (f39868d == null) {
                f39868d = new y(context.getApplicationContext());
            }
            yVar = f39868d;
        }
        return yVar;
    }

    public final void a() {
        x xVar = new x();
        if (xVar.a(this.f39869e)) {
            xVar.a();
            p.d("SystemCache", "sp cache is cleared");
        }
    }

    @Override // com.vivo.push.util.c
    public final void b(String str, String str2) {
        c cVar;
        f39867c.put(str, str2);
        if (!this.f39871g || (cVar = this.f39870f) == null) {
            return;
        }
        cVar.b(str, str2);
    }

    @Override // com.vivo.push.util.c
    public final boolean a(Context context) {
        v vVar = new v();
        this.f39870f = vVar;
        boolean a2 = vVar.a(context);
        if (!a2) {
            u uVar = new u();
            this.f39870f = uVar;
            a2 = uVar.a(context);
        }
        if (!a2) {
            x xVar = new x();
            this.f39870f = xVar;
            a2 = xVar.a(context);
        }
        if (!a2) {
            this.f39870f = null;
        }
        return a2;
    }

    @Override // com.vivo.push.util.c
    public final String a(String str, String str2) {
        c cVar;
        String str3 = f39867c.get(str);
        return (str3 != null || (cVar = this.f39870f) == null) ? str3 : cVar.a(str, str2);
    }
}
