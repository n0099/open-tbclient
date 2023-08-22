package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.hl;
/* loaded from: classes10.dex */
public class aa implements Runnable {
    public final /* synthetic */ MiTinyDataClient.a.C0786a a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ hl f49a;

    public aa(MiTinyDataClient.a.C0786a c0786a, hl hlVar) {
        this.a = c0786a;
        this.f49a = hlVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.f44a.add(this.f49a);
        this.a.a();
    }
}
