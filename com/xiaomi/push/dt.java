package com.xiaomi.push;

import android.content.Context;
/* loaded from: classes8.dex */
public class dt extends ds {
    public dt(Context context, int i) {
        super(context, i);
    }

    /* JADX DEBUG: Possible override for method com.xiaomi.push.aj.a.a()Ljava/lang/String; */
    @Override // com.xiaomi.push.ds
    public hj a() {
        return hj.Storage;
    }

    /* JADX DEBUG: Possible override for method com.xiaomi.push.ds.a()Lcom/xiaomi/push/hj; */
    /* JADX DEBUG: Possible override for method com.xiaomi.push.ds.a()Z */
    @Override // com.xiaomi.push.aj.a
    /* renamed from: a */
    public String mo221a() {
        return "23";
    }

    @Override // com.xiaomi.push.ds
    public String b() {
        return "ram:" + i.m527a() + ",rom:" + i.m530b() + "|ramOriginal:" + i.c() + ",romOriginal:" + i.d();
    }
}
