package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.hl;
/* loaded from: classes10.dex */
public class aa implements Runnable {
    public final /* synthetic */ MiTinyDataClient.a.C0782a a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ hl f48a;

    public aa(MiTinyDataClient.a.C0782a c0782a, hl hlVar) {
        this.a = c0782a;
        this.f48a = hlVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.f43a.add(this.f48a);
        this.a.a();
    }
}
