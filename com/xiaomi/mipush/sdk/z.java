package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.hj;
/* loaded from: classes7.dex */
public class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MiTinyDataClient.a.C0482a f38112a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ hj f97a;

    public z(MiTinyDataClient.a.C0482a c0482a, hj hjVar) {
        this.f38112a = c0482a;
        this.f97a = hjVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f38112a.f51a.add(this.f97a);
        this.f38112a.a();
    }
}
