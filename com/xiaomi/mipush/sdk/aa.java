package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.hl;
/* loaded from: classes10.dex */
public class aa implements Runnable {
    public final /* synthetic */ MiTinyDataClient.a.C0756a a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ hl f44a;

    public aa(MiTinyDataClient.a.C0756a c0756a, hl hlVar) {
        this.a = c0756a;
        this.f44a = hlVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.f39a.add(this.f44a);
        this.a.a();
    }
}
