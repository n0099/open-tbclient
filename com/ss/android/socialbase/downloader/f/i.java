package com.ss.android.socialbase.downloader.f;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class i {
    public volatile m a;

    /* renamed from: b  reason: collision with root package name */
    public int f62375b;

    /* renamed from: c  reason: collision with root package name */
    public final long f62376c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicLong f62377d;

    /* renamed from: e  reason: collision with root package name */
    public volatile long f62378e;

    /* renamed from: f  reason: collision with root package name */
    public long f62379f;

    /* renamed from: g  reason: collision with root package name */
    public int f62380g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f62381h;

    public i(long j2, long j3) {
        AtomicLong atomicLong = new AtomicLong();
        this.f62377d = atomicLong;
        this.f62375b = 0;
        this.f62376c = j2;
        atomicLong.set(j2);
        this.f62378e = j2;
        if (j3 >= j2) {
            this.f62379f = j3;
        } else {
            this.f62379f = -1L;
        }
    }

    public long a() {
        return this.f62377d.get() - this.f62376c;
    }

    public long b() {
        long j2 = this.f62379f;
        if (j2 >= this.f62376c) {
            return (j2 - e()) + 1;
        }
        return -1L;
    }

    public long c() {
        return this.f62376c;
    }

    public long d() {
        long j2 = this.f62377d.get();
        long j3 = this.f62379f;
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
            if (d2 > this.f62378e) {
                return d2;
            }
        }
        return this.f62378e;
    }

    public long f() {
        return this.f62379f;
    }

    public int g() {
        return this.f62380g;
    }

    public void h() {
        this.f62375b++;
    }

    public void i() {
        this.f62375b--;
    }

    public int j() {
        return this.f62375b;
    }

    public JSONObject k() throws JSONException {
        JSONObject jSONObject = this.f62381h;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
            this.f62381h = jSONObject;
        }
        jSONObject.put("st", c());
        jSONObject.put(com.baidu.fsg.base.statistics.k.f34934b, d());
        jSONObject.put(com.baidu.fsg.base.statistics.h.a, f());
        return jSONObject;
    }

    public String toString() {
        return "Segment{startOffset=" + this.f62376c + ",\t currentOffset=" + this.f62377d + ",\t currentOffsetRead=" + e() + ",\t endOffset=" + this.f62379f + ExtendedMessageFormat.END_FE;
    }

    public void a(long j2) {
        long j3 = this.f62376c;
        if (j2 < j3) {
            j2 = j3;
        }
        long j4 = this.f62379f;
        if (j4 > 0) {
            long j5 = j4 + 1;
            if (j2 > j5) {
                j2 = j5;
            }
        }
        this.f62377d.set(j2);
    }

    public void c(long j2) {
        if (j2 >= this.f62376c) {
            this.f62379f = j2;
            return;
        }
        String str = "setEndOffset: endOffset = " + j2 + ", segment = " + this;
        if (j2 == -1) {
            this.f62379f = j2;
        }
    }

    public void b(long j2) {
        this.f62377d.addAndGet(j2);
    }

    public void d(long j2) {
        if (j2 >= this.f62377d.get()) {
            this.f62378e = j2;
        }
    }

    public void b(int i2) {
        this.f62375b = i2;
    }

    public void a(int i2) {
        this.f62380g = i2;
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
        this.f62377d = atomicLong;
        this.f62375b = 0;
        this.f62376c = iVar.f62376c;
        this.f62379f = iVar.f62379f;
        atomicLong.set(iVar.f62377d.get());
        this.f62378e = this.f62377d.get();
        this.f62380g = iVar.f62380g;
    }

    public i(JSONObject jSONObject) {
        this.f62377d = new AtomicLong();
        this.f62375b = 0;
        this.f62376c = jSONObject.optLong("st");
        c(jSONObject.optLong(com.baidu.fsg.base.statistics.h.a));
        a(jSONObject.optLong(com.baidu.fsg.base.statistics.k.f34934b));
        d(d());
    }
}
