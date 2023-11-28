package com.xiaomi.push;

import android.content.SharedPreferences;
import com.xiaomi.push.aj;
/* loaded from: classes10.dex */
public class ak extends aj.b {
    public final /* synthetic */ aj a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f97a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f98a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak(aj ajVar, aj.a aVar, boolean z, String str) {
        super(aVar);
        this.a = ajVar;
        this.f98a = z;
        this.f97a = str;
    }

    @Override // com.xiaomi.push.aj.b
    public void a() {
        super.a();
    }

    @Override // com.xiaomi.push.aj.b
    public void b() {
        SharedPreferences sharedPreferences;
        if (this.f98a) {
            return;
        }
        sharedPreferences = this.a.f93a;
        sharedPreferences.edit().putLong(this.f97a, System.currentTimeMillis()).commit();
    }
}
