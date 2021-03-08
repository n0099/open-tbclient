package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.dp;
import com.xiaomi.push.hm;
import com.xiaomi.push.hz;
import com.xiaomi.push.il;
/* loaded from: classes5.dex */
public class q implements dp {

    /* renamed from: a  reason: collision with root package name */
    private Context f8240a;

    public q(Context context) {
        this.f8240a = context;
    }

    @Override // com.xiaomi.push.dp
    public String a() {
        return b.m98a(this.f8240a).d();
    }

    @Override // com.xiaomi.push.dp
    public void a(il ilVar, hm hmVar, hz hzVar) {
        aq.a(this.f8240a).a((aq) ilVar, hmVar, hzVar);
    }
}
