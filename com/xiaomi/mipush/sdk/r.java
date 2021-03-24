package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.di;
import com.xiaomi.push.hf;
import com.xiaomi.push.hs;
import com.xiaomi.push.ie;
/* loaded from: classes7.dex */
public class r implements di {

    /* renamed from: a  reason: collision with root package name */
    public Context f40205a;

    public r(Context context) {
        this.f40205a = context;
    }

    @Override // com.xiaomi.push.di
    public String a() {
        return b.m92a(this.f40205a).d();
    }

    @Override // com.xiaomi.push.di
    public void a(ie ieVar, hf hfVar, hs hsVar) {
        an.a(this.f40205a).a((an) ieVar, hfVar, hsVar);
    }
}
