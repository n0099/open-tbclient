package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.hj;
/* loaded from: classes7.dex */
public class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MiTinyDataClient.a.C0524a f41068a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ hj f97a;

    public z(MiTinyDataClient.a.C0524a c0524a, hj hjVar) {
        this.f41068a = c0524a;
        this.f97a = hjVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f41068a.f51a.add(this.f97a);
        this.f41068a.a();
    }
}
