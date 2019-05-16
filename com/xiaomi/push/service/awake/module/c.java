package com.xiaomi.push.service.awake.module;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes3.dex */
public final class c {
    private static volatile c a;
    private Context b;
    private HashMap<e, f> c = new HashMap<>();
    private String d;
    private String e;
    private int f;
    private g g;

    private c(Context context) {
        this.b = context;
        this.c.put(e.SERVICE_ACTION, new i());
        this.c.put(e.SERVICE_COMPONENT, new j());
        this.c.put(e.ACTIVITY, new a());
        this.c.put(e.PROVIDER, new h());
    }

    public static c a(Context context) {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c(context);
                }
            }
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, Context context, b bVar) {
        this.c.get(eVar).a(context, bVar);
    }

    public g a() {
        return this.g;
    }

    public void a(int i) {
        this.f = i;
    }

    public void a(Context context, String str, int i, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            com.xiaomi.push.service.awake.b.a(context, "" + str, PointerIconCompat.TYPE_TEXT, "A receive a incorrect message");
            return;
        }
        a(i);
        com.xiaomi.channel.commonutils.misc.h.a(this.b).a(new d(this, str, context, str2, str3));
    }

    public void a(e eVar, Context context, Intent intent, String str) {
        if (eVar != null) {
            this.c.get(eVar).a(context, intent, str);
        } else {
            com.xiaomi.push.service.awake.b.a(context, "null", PointerIconCompat.TYPE_TEXT, "A receive a incorrect message with empty type");
        }
    }

    public void a(g gVar) {
        this.g = gVar;
    }

    public void a(String str) {
        this.d = str;
    }

    public void a(String str, String str2, int i, g gVar) {
        a(str);
        b(str2);
        a(i);
        a(gVar);
    }

    public String b() {
        return this.d;
    }

    public void b(String str) {
        this.e = str;
    }

    public String c() {
        return this.e;
    }

    public int d() {
        return this.f;
    }
}
