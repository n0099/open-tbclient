package com.vivo.push.util;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes3.dex */
public final class v implements c {
    private static final HashMap<String, Integer> a = new HashMap<>();
    private static final HashMap<String, Long> b = new HashMap<>();
    private static final HashMap<String, String> c = new HashMap<>();
    private static v d;
    private Context e;
    private c f;
    private boolean g;

    private v(Context context) {
        this.g = false;
        this.e = context;
        this.g = a(context);
        m.d("SystemCache", "init status is " + this.g + ";  curCache is " + this.f);
    }

    public static synchronized v b(Context context) {
        v vVar;
        synchronized (v.class) {
            if (d == null) {
                d = new v(context.getApplicationContext());
            }
            vVar = d;
        }
        return vVar;
    }

    public final void a() {
        u uVar = new u();
        if (uVar.a(this.e)) {
            uVar.a();
            m.d("SystemCache", "sp cache is cleared");
        }
    }

    @Override // com.vivo.push.util.c
    public final boolean a(Context context) {
        this.f = new s();
        boolean a2 = this.f.a(context);
        if (!a2) {
            this.f = new r();
            a2 = this.f.a(context);
        }
        if (!a2) {
            this.f = new u();
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
