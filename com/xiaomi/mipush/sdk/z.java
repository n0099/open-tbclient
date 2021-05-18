package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.hj;
/* loaded from: classes7.dex */
public class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MiTinyDataClient.a.C0469a f37357a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ hj f97a;

    public z(MiTinyDataClient.a.C0469a c0469a, hj hjVar) {
        this.f37357a = c0469a;
        this.f97a = hjVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f37357a.f51a.add(this.f97a);
        this.f37357a.a();
    }
}
