package com.ss.android.socialbase.downloader.f;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class i {
    public volatile m a;

    /* renamed from: b  reason: collision with root package name */
    public int f60068b;

    /* renamed from: c  reason: collision with root package name */
    public final long f60069c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicLong f60070d;

    /* renamed from: e  reason: collision with root package name */
    public volatile long f60071e;

    /* renamed from: f  reason: collision with root package name */
    public long f60072f;

    /* renamed from: g  reason: collision with root package name */
    public int f60073g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f60074h;

    public i(long j2, long j3) {
        AtomicLong atomicLong = new AtomicLong();
        this.f60070d = atomicLong;
        this.f60068b = 0;
        this.f60069c = j2;
        atomicLong.set(j2);
        this.f60071e = j2;
        if (j3 >= j2) {
            this.f60072f = j3;
        } else {
            this.f60072f = -1L;
        }
    }

    public long a() {
        return this.f60070d.get() - this.f60069c;
    }

    public long b() {
        long j2 = this.f60072f;
        if (j2 >= this.f60069c) {
            return (j2 - e()) + 1;
        }
        return -1L;
    }

    public long c() {
        return this.f60069c;
    }

    public long d() {
        long j2 = this.f60070d.get();
        long j3 = this.f60072f;
        if (j3 > 0) {
            long j4 = j3 + 1;
            if (j2 > j4) {
                return j4;
            }
        }
        return j2;
    }

    public long e() {
        m mVar = this.a;
        if (mVar != null) {
            long d2 = mVar.d();
            if (d2 > this.f60071e) {
                return d2;
            }
        }
        return this.f60071e;
    }

    public long f() {
        return this.f60072f;
    }

    public int g() {
        return this.f60073g;
    }

    public void h() {
        this.f60068b++;
    }

    public void i() {
        this.f60068b--;
    }

    public int j() {
        return this.f60068b;
    }

    public JSONObject k() throws JSONException {
        JSONObject jSONObject = this.f60074h;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
            this.f60074h = jSONObject;
        }
        jSONObject.put("st", c());
        jSONObject.put(com.baidu.fsg.base.statistics.k.f33836b, d());
        jSONObject.put(com.baidu.fsg.base.statistics.h.a, f());
        return jSONObject;
    }

    public String toString() {
        return "Segment{startOffset=" + this.f60069c + ",\t currentOffset=" + this.f60070d + ",\t currentOffsetRead=" + e() + ",\t endOffset=" + this.f60072f + ExtendedMessageFormat.END_FE;
    }

    public void a(long j2) {
        long j3 = this.f60069c;
        if (j2 < j3) {
            j2 = j3;
        }
        long j4 = this.f60072f;
        if (j4 > 0) {
            long j5 = j4 + 1;
            if (j2 > j5) {
                j2 = j5;
            }
        }
        this.f60070d.set(j2);
    }

    public void c(long j2) {
        if (j2 >= this.f60069c) {
            this.f60072f = j2;
            return;
        }
        String str = "setEndOffset: endOffset = " + j2 + ", segment = " + this;
        if (j2 == -1) {
            this.f60072f = j2;
        }
    }

    public void b(long j2) {
        this.f60070d.addAndGet(j2);
    }

    public void d(long j2) {
        if (j2 >= this.f60070d.get()) {
            this.f60071e = j2;
        }
    }

    public void b(int i2) {
        this.f60068b = i2;
    }

    public void a(int i2) {
        this.f60073g = i2;
    }

    public static String a(List<i> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Collections.sort(list, new Comparator<i>() { // from class: com.ss.android.socialbase.downloader.f.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(i iVar, i iVar2) {
                return (int) (iVar.c() - iVar2.c());
            }
        });
        StringBuilder sb = new StringBuilder();
        for (i iVar : list) {
            sb.append(iVar);
            sb.append("\r\n");
        }
        return sb.toString();
    }

    public i(i iVar) {
        AtomicLong atomicLong = new AtomicLong();
        this.f60070d = atomicLong;
        this.f60068b = 0;
        this.f60069c = iVar.f60069c;
        this.f60072f = iVar.f60072f;
        atomicLong.set(iVar.f60070d.get());
        this.f60071e = this.f60070d.get();
        this.f60073g = iVar.f60073g;
    }

    public i(JSONObject jSONObject) {
        this.f60070d = new AtomicLong();
        this.f60068b = 0;
        this.f60069c = jSONObject.optLong("st");
        c(jSONObject.optLong(com.baidu.fsg.base.statistics.h.a));
        a(jSONObject.optLong(com.baidu.fsg.base.statistics.k.f33836b));
        d(d());
    }
}
