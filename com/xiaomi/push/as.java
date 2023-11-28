package com.xiaomi.push;

import android.os.IBinder;
import com.xiaomi.push.aq;
/* loaded from: classes10.dex */
public class as implements Runnable {
    public final /* synthetic */ IBinder a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ aq.a f111a;

    public as(aq.a aVar, IBinder iBinder) {
        this.f111a = aVar;
        this.a = iBinder;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        try {
            aq.this.f109a = aq.b.a(this.a);
            aq.this.f110b = aq.b.m277a(this.a);
            aq.this.b();
            aq.this.f105a = 2;
            obj5 = aq.this.f108a;
            synchronized (obj5) {
                try {
                    obj6 = aq.this.f108a;
                    obj6.notifyAll();
                } catch (Exception unused) {
                }
            }
        } catch (Exception unused2) {
            aq.this.b();
            aq.this.f105a = 2;
            obj3 = aq.this.f108a;
            synchronized (obj3) {
                try {
                    obj4 = aq.this.f108a;
                    obj4.notifyAll();
                } catch (Exception unused3) {
                }
            }
        } catch (Throwable th) {
            aq.this.b();
            aq.this.f105a = 2;
            obj = aq.this.f108a;
            synchronized (obj) {
                try {
                    obj2 = aq.this.f108a;
                    obj2.notifyAll();
                } catch (Exception unused4) {
                }
                throw th;
            }
        }
    }
}
