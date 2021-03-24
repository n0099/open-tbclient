package com.bytedance.sdk.openadsdk.l;

import android.os.SystemClock;
import com.baidu.android.common.others.lang.StringUtil;
import com.bytedance.sdk.openadsdk.utils.u;
/* loaded from: classes6.dex */
public class b implements Comparable, Runnable {

    /* renamed from: a  reason: collision with root package name */
    public g f29761a;

    /* renamed from: b  reason: collision with root package name */
    public a f29762b;

    /* renamed from: c  reason: collision with root package name */
    public long f29763c;

    /* renamed from: d  reason: collision with root package name */
    public Thread f29764d = null;

    public b(g gVar, a aVar) {
        this.f29761a = null;
        this.f29762b = null;
        this.f29763c = 0L;
        this.f29761a = gVar;
        this.f29762b = aVar;
        this.f29763c = SystemClock.uptimeMillis();
    }

    public g a() {
        return this.f29761a;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj instanceof b) {
            return this.f29761a.compareTo(((b) obj).a());
        }
        return 0;
    }

    public boolean equals(Object obj) {
        g gVar;
        return (obj instanceof b) && (gVar = this.f29761a) != null && gVar.equals(((b) obj).a());
    }

    public int hashCode() {
        return this.f29761a.hashCode();
    }

    @Override // java.lang.Runnable
    public void run() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = uptimeMillis - this.f29763c;
        this.f29764d = Thread.currentThread();
        g gVar = this.f29761a;
        if (gVar != null) {
            gVar.run();
        }
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        a aVar = this.f29762b;
        if (aVar != null) {
            d.a(aVar, j, uptimeMillis2);
        }
        Object[] objArr = new Object[8];
        objArr[0] = "run: pool  = ";
        a aVar2 = this.f29762b;
        String str = StringUtil.NULL_STRING;
        objArr[1] = aVar2 != null ? aVar2.a() : StringUtil.NULL_STRING;
        objArr[2] = " waitTime =";
        objArr[3] = Long.valueOf(j);
        objArr[4] = " taskCost = ";
        objArr[5] = Long.valueOf(uptimeMillis2);
        objArr[6] = " name=";
        g gVar2 = this.f29761a;
        if (gVar2 != null) {
            str = gVar2.h();
        }
        objArr[7] = str;
        u.b("DelegateRunnable", objArr);
    }
}
