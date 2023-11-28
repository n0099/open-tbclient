package com.xiaomi.push;

import android.content.Context;
import android.os.IBinder;
import com.xiaomi.push.ba;
/* loaded from: classes10.dex */
public class bc implements Runnable {
    public final /* synthetic */ IBinder a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ba.b f135a;

    public bc(ba.b bVar, IBinder iBinder) {
        this.f135a = bVar;
        this.a = iBinder;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Context context;
        String b;
        Object obj5;
        Object obj6;
        try {
            context = ba.this.f130a;
            String packageName = context.getPackageName();
            b = ba.this.b();
            ba.a aVar = new ba.a();
            aVar.b = ba.c.a(this.a, packageName, b, "OUID");
            ba.this.f132a = aVar;
            ba.this.m296b();
            ba.this.f129a = 2;
            obj5 = ba.this.f133a;
            synchronized (obj5) {
                try {
                    obj6 = ba.this.f133a;
                    obj6.notifyAll();
                } catch (Exception unused) {
                }
            }
        } catch (Exception unused2) {
            ba.this.m296b();
            ba.this.f129a = 2;
            obj3 = ba.this.f133a;
            synchronized (obj3) {
                try {
                    obj4 = ba.this.f133a;
                    obj4.notifyAll();
                } catch (Exception unused3) {
                }
            }
        } catch (Throwable th) {
            ba.this.m296b();
            ba.this.f129a = 2;
            obj = ba.this.f133a;
            synchronized (obj) {
                try {
                    obj2 = ba.this.f133a;
                    obj2.notifyAll();
                } catch (Exception unused4) {
                }
                throw th;
            }
        }
    }
}
