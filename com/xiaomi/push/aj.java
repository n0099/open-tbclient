package com.xiaomi.push;

import android.content.SharedPreferences;
import com.xiaomi.push.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class aj extends ai.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ai f4791a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f99a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(ai aiVar, ai.a aVar, String str) {
        super(aVar);
        this.f4791a = aiVar;
        this.f99a = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.xiaomi.push.ai.b
    public void a() {
        super.a();
    }

    @Override // com.xiaomi.push.ai.b
    void b() {
        SharedPreferences sharedPreferences;
        sharedPreferences = this.f4791a.f95a;
        sharedPreferences.edit().putLong(this.f99a, System.currentTimeMillis()).commit();
    }
}
