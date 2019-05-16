package com.xiaomi.mipush.sdk;

import android.content.Context;
/* loaded from: classes3.dex */
public class q implements com.xiaomi.push.mpcd.b {
    private Context a;

    public q(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.mpcd.b
    public String a() {
        return d.a(this.a).f();
    }

    @Override // com.xiaomi.push.mpcd.b
    public void a(com.xiaomi.xmpush.thrift.ai aiVar, com.xiaomi.xmpush.thrift.a aVar, com.xiaomi.xmpush.thrift.u uVar) {
        az.a(this.a).a((az) aiVar, aVar, uVar);
    }
}
