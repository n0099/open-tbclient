package com.xiaomi.push;

import android.content.SharedPreferences;
import com.xiaomi.push.aj;
/* loaded from: classes10.dex */
public class ak extends aj.b {
    public final /* synthetic */ aj a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f102a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f103a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak(aj ajVar, aj.a aVar, boolean z, String str) {
        super(aVar);
        this.a = ajVar;
        this.f103a = z;
        this.f102a = str;
    }

    @Override // com.xiaomi.push.aj.b
    public void a() {
        super.a();
    }

    @Override // com.xiaomi.push.aj.b
    public void b() {
        SharedPreferences sharedPreferences;
        if (this.f103a) {
            return;
        }
        sharedPreferences = this.a.f98a;
        sharedPreferences.edit().putLong(this.f102a, System.currentTimeMillis()).commit();
    }
}
