package com.xiaomi.push;

import android.content.SharedPreferences;
import com.xiaomi.push.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class aj extends ai.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ai f4789a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f96a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(ai aiVar, ai.a aVar, String str) {
        super(aVar);
        this.f4789a = aiVar;
        this.f96a = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.xiaomi.push.ai.b
    public void a() {
        super.a();
    }

    @Override // com.xiaomi.push.ai.b
    void b() {
        SharedPreferences sharedPreferences;
        sharedPreferences = this.f4789a.f92a;
        sharedPreferences.edit().putLong(this.f96a, System.currentTimeMillis()).commit();
    }
}
