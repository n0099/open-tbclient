package com.vivo.push.util;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes11.dex */
public final class y implements c {

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap<String, Integer> f4482a = new HashMap<>();
    private static final HashMap<String, Long> b = new HashMap<>();
    private static final HashMap<String, String> c = new HashMap<>();
    private static y d;
    private Context e;
    private c f;
    private boolean g;

    private y(Context context) {
        this.g = false;
        this.e = context;
        this.g = a(context);
        p.d("SystemCache", "init status is " + this.g + ";  curCache is " + this.f);
    }

    public static synchronized y b(Context context) {
        y yVar;
        synchronized (y.class) {
            if (d == null) {
                d = new y(context.getApplicationContext());
            }
            yVar = d;
        }
        return yVar;
    }

    public final void a() {
        x xVar = new x();
        if (xVar.a(this.e)) {
            xVar.a();
            p.d("SystemCache", "sp cache is cleared");
        }
    }

    @Override // com.vivo.push.util.c
    public final boolean a(Context context) {
        this.f = new v();
        boolean a2 = this.f.a(context);
        if (!a2) {
            this.f = new u();
            a2 = this.f.a(context);
        }
        if (!a2) {
            this.f = new x();
            a2 = this.f.a(context);
        }
        if (!a2) {
            this.f = null;
        }
        return a2;
    }

    @Override // com.vivo.push.util.c
    public final String a(String str, String str2) {
        String str3 = c.get(str);
        return (str3 != null || this.f == null) ? str3 : this.f.a(str, str2);
    }

    @Override // com.vivo.push.util.c
    public final void b(String str, String str2) {
        c.put(str, str2);
        if (this.g && this.f != null) {
            this.f.b(str, str2);
        }
    }
}
