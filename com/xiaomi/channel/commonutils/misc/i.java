package com.xiaomi.channel.commonutils.misc;

import android.content.SharedPreferences;
import com.xiaomi.channel.commonutils.misc.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class i extends h.b {
    final /* synthetic */ String a;
    final /* synthetic */ h b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(h hVar, h.a aVar, String str) {
        super(aVar);
        this.b = hVar;
        this.a = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.xiaomi.channel.commonutils.misc.h.b
    public void a() {
        super.a();
    }

    @Override // com.xiaomi.channel.commonutils.misc.h.b
    void b() {
        SharedPreferences sharedPreferences;
        sharedPreferences = this.b.e;
        sharedPreferences.edit().putLong(this.a, System.currentTimeMillis()).commit();
    }
}
