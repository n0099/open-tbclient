package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.di;
import com.xiaomi.push.hf;
import com.xiaomi.push.hs;
import com.xiaomi.push.ie;
/* loaded from: classes7.dex */
public class r implements di {

    /* renamed from: a  reason: collision with root package name */
    public Context f38105a;

    public r(Context context) {
        this.f38105a = context;
    }

    @Override // com.xiaomi.push.di
    public String a() {
        return b.m99a(this.f38105a).d();
    }

    @Override // com.xiaomi.push.di
    public void a(ie ieVar, hf hfVar, hs hsVar) {
        an.a(this.f38105a).a((an) ieVar, hfVar, hsVar);
    }
}
