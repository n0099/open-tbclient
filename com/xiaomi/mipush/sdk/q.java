package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.dp;
import com.xiaomi.push.hm;
import com.xiaomi.push.hz;
import com.xiaomi.push.il;
/* loaded from: classes8.dex */
public class q implements dp {
    private Context a;

    public q(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.dp
    public String a() {
        return b.m92a(this.a).d();
    }

    @Override // com.xiaomi.push.dp
    public void a(il ilVar, hm hmVar, hz hzVar) {
        aq.a(this.a).a((aq) ilVar, hmVar, hzVar);
    }
}
