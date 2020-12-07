package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.dp;
import com.xiaomi.push.hm;
import com.xiaomi.push.hz;
import com.xiaomi.push.il;
/* loaded from: classes18.dex */
public class q implements dp {

    /* renamed from: a  reason: collision with root package name */
    private Context f4547a;

    public q(Context context) {
        this.f4547a = context;
    }

    @Override // com.xiaomi.push.dp
    public String a() {
        return b.m87a(this.f4547a).d();
    }

    @Override // com.xiaomi.push.dp
    public void a(il ilVar, hm hmVar, hz hzVar) {
        aq.a(this.f4547a).a((aq) ilVar, hmVar, hzVar);
    }
}
