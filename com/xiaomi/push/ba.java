package com.xiaomi.push;

import android.content.Context;
import android.os.IBinder;
import com.xiaomi.push.ay;
/* loaded from: classes7.dex */
public class ba implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IBinder f40268a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ay.b f144a;

    public ba(ay.b bVar, IBinder iBinder) {
        this.f144a = bVar;
        this.f40268a = iBinder;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Context context;
        String e2;
        Object obj5;
        Object obj6;
        try {
            context = ay.this.f137a;
            String packageName = context.getPackageName();
            e2 = ay.this.e();
            ay.a aVar = new ay.a();
            aVar.f141a = ay.c.a(this.f40268a, packageName, e2, "GUID");
            aVar.f40256b = ay.c.a(this.f40268a, packageName, e2, "OUID");
            aVar.f40257c = ay.c.a(this.f40268a, packageName, e2, "DUID");
            aVar.f40258d = ay.c.a(this.f40268a, packageName, e2, "AUID");
            ay.this.f139a = aVar;
            ay.this.b();
            ay.this.f136a = 2;
            obj5 = ay.this.f140a;
            synchronized (obj5) {
                try {
                    obj6 = ay.this.f140a;
                    obj6.notifyAll();
                } catch (Exception unused) {
                }
            }
        } catch (Exception unused2) {
            ay.this.b();
            ay.this.f136a = 2;
            obj3 = ay.this.f140a;
            synchronized (obj3) {
                try {
                    obj4 = ay.this.f140a;
                    obj4.notifyAll();
                } catch (Exception unused3) {
                }
            }
        } catch (Throwable th) {
            ay.this.b();
            ay.this.f136a = 2;
            obj = ay.this.f140a;
            synchronized (obj) {
                try {
                    obj2 = ay.this.f140a;
                    obj2.notifyAll();
                } catch (Exception unused4) {
                }
                throw th;
            }
        }
    }
}
