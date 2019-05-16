package com.xiaomi.mipush.sdk;

import android.content.Context;
/* loaded from: classes3.dex */
public class x {
    private final int a = -1;
    private final double b = 0.0d;
    private com.xiaomi.metoknlp.geofencing.a c;
    private Context d;

    public x(Context context) {
        this.d = context;
        a();
    }

    private void a() {
        this.c = new com.xiaomi.metoknlp.geofencing.a(this.d);
    }

    public void a(String str) {
        this.c.a(this.d, "com.xiaomi.xmsf", str);
    }

    public boolean a(com.xiaomi.xmpush.thrift.m mVar) {
        if (mVar == null) {
            return false;
        }
        if (mVar.m() != null && mVar.o() > 0.0d) {
            com.xiaomi.xmpush.thrift.o m = mVar.m();
            this.c.a(this.d, m.c(), m.a(), (float) mVar.o(), -1L, "com.xiaomi.xmsf", mVar.a(), mVar.s().name());
        }
        return true;
    }
}
