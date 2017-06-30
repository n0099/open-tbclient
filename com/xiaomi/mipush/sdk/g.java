package com.xiaomi.mipush.sdk;

import android.content.Context;
/* loaded from: classes2.dex */
public class g {
    private final int a = -1;
    private final double b = 0.0d;
    private com.xiaomi.metok.geofencing.a c;
    private Context d;

    public g(Context context) {
        this.d = context;
        a();
    }

    private void a() {
        this.c = new com.xiaomi.metok.geofencing.a(this.d);
    }

    public void a(String str) {
        this.c.a(this.d, "com.xiaomi.xmsf", str);
    }

    public boolean a(com.xiaomi.xmpush.thrift.j jVar) {
        if (jVar == null) {
            return false;
        }
        if (jVar.m() != null && jVar.o() > 0.0d) {
            com.xiaomi.xmpush.thrift.l m = jVar.m();
            this.c.a(this.d, m.c(), m.a(), (float) jVar.o(), -1L, "com.xiaomi.xmsf", jVar.a(), jVar.s().name());
        }
        return true;
    }
}
