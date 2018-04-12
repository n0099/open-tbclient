package com.xiaomi.channel.commonutils.misc;

import android.content.SharedPreferences;
import com.xiaomi.channel.commonutils.misc.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class g extends f.b {
    final /* synthetic */ String a;
    final /* synthetic */ f b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar, f.a aVar, String str) {
        super(aVar);
        this.b = fVar;
        this.a = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.xiaomi.channel.commonutils.misc.f.b
    public void a() {
        super.a();
    }

    @Override // com.xiaomi.channel.commonutils.misc.f.b
    void b() {
        SharedPreferences sharedPreferences;
        sharedPreferences = this.b.e;
        sharedPreferences.edit().putLong(this.a, System.currentTimeMillis()).commit();
    }
}
