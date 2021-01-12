package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.dp;
import com.xiaomi.push.hm;
import com.xiaomi.push.hz;
import com.xiaomi.push.il;
/* loaded from: classes6.dex */
public class q implements dp {

    /* renamed from: a  reason: collision with root package name */
    private Context f13837a;

    public q(Context context) {
        this.f13837a = context;
    }

    @Override // com.xiaomi.push.dp
    public String a() {
        return b.m120a(this.f13837a).d();
    }

    @Override // com.xiaomi.push.dp
    public void a(il ilVar, hm hmVar, hz hzVar) {
        aq.a(this.f13837a).a((aq) ilVar, hmVar, hzVar);
    }
}
