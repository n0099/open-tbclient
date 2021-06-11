package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.di;
import com.xiaomi.push.hf;
import com.xiaomi.push.hs;
import com.xiaomi.push.ie;
/* loaded from: classes7.dex */
public class r implements di {

    /* renamed from: a  reason: collision with root package name */
    public Context f40958a;

    public r(Context context) {
        this.f40958a = context;
    }

    @Override // com.xiaomi.push.di
    public String a() {
        return b.m97a(this.f40958a).d();
    }

    @Override // com.xiaomi.push.di
    public void a(ie ieVar, hf hfVar, hs hsVar) {
        an.a(this.f40958a).a((an) ieVar, hfVar, hsVar);
    }
}
