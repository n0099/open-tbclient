package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.dl;
import com.xiaomi.push.hh;
import com.xiaomi.push.hu;
import com.xiaomi.push.ig;
/* loaded from: classes8.dex */
public class r implements dl {
    public Context a;

    public r(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.dl
    public String a() {
        return b.m143a(this.a).d();
    }

    @Override // com.xiaomi.push.dl
    public void a(ig igVar, hh hhVar, hu huVar) {
        ao.a(this.a).a((ao) igVar, hhVar, huVar);
    }
}
