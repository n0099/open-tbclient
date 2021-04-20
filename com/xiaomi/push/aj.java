package com.xiaomi.push;

import android.content.SharedPreferences;
import com.xiaomi.push.ai;
/* loaded from: classes7.dex */
public class aj extends ai.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ai f40515a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f107a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f108a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(ai aiVar, ai.a aVar, boolean z, String str) {
        super(aVar);
        this.f40515a = aiVar;
        this.f108a = z;
        this.f107a = str;
    }

    @Override // com.xiaomi.push.ai.b
    public void a() {
        super.a();
    }

    @Override // com.xiaomi.push.ai.b
    public void b() {
        SharedPreferences sharedPreferences;
        if (this.f108a) {
            return;
        }
        sharedPreferences = this.f40515a.f103a;
        sharedPreferences.edit().putLong(this.f107a, System.currentTimeMillis()).commit();
    }
}
