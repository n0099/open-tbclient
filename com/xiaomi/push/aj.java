package com.xiaomi.push;

import android.content.SharedPreferences;
import com.xiaomi.push.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class aj extends ai.b {
    final /* synthetic */ ai a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f123a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(ai aiVar, ai.a aVar, String str) {
        super(aVar);
        this.a = aiVar;
        this.f123a = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.xiaomi.push.ai.b
    public void a() {
        super.a();
    }

    @Override // com.xiaomi.push.ai.b
    void b() {
        SharedPreferences sharedPreferences;
        sharedPreferences = this.a.f119a;
        sharedPreferences.edit().putLong(this.f123a, System.currentTimeMillis()).commit();
    }
}
