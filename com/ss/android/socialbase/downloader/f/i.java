package com.ss.android.socialbase.downloader.f;

import android.util.Log;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class i {
    public volatile m a;

    /* renamed from: b  reason: collision with root package name */
    public int f43301b;

    /* renamed from: c  reason: collision with root package name */
    public final long f43302c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicLong f43303d;

    /* renamed from: e  reason: collision with root package name */
    public volatile long f43304e;

    /* renamed from: f  reason: collision with root package name */
    public long f43305f;

    /* renamed from: g  reason: collision with root package name */
    public int f43306g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f43307h;

    public i(long j, long j2) {
        AtomicLong atomicLong = new AtomicLong();
        this.f43303d = atomicLong;
        this.f43301b = 0;
        this.f43302c = j;
        atomicLong.set(j);
        this.f43304e = j;
        if (j2 >= j) {
            this.f43305f = j2;
        } else {
            this.f43305f = -1L;
        }
    }

    public long a() {
        return this.f43303d.get() - this.f43302c;
    }

    public long b() {
        long j = this.f43305f;
        if (j >= this.f43302c) {
            return (j - e()) + 1;
        }
        return -1L;
    }

    public long c() {
        return this.f43302c;
    }

    public long d() {
        long j = this.f43303d.get();
        long j2 = this.f43305f;
        if (j2 > 0) {
            long j3 = j2 + 1;
            if (j > j3) {
                return j3;
            }
        }
        return j;
    }

    public long e() {
        m mVar = this.a;
        if (mVar != null) {
            long d2 = mVar.d();
            if (d2 > this.f43304e) {
                return d2;
            }
        }
        return this.f43304e;
    }

    public long f() {
        return this.f43305f;
    }

    public int g() {
        return this.f43306g;
    }

    public void h() {
        this.f43301b++;
    }

    public void i() {
        this.f43301b--;
    }

    public int j() {
        return this.f43301b;
    }

    public JSONObject k() throws JSONException {
        JSONObject jSONObject = this.f43307h;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
            this.f43307h = jSONObject;
        }
        jSONObject.put("st", c());
        jSONObject.put("cu", d());
        jSONObject.put("en", f());
        return jSONObject;
    }

    public String toString() {
        return "Segment{startOffset=" + this.f43302c + ",\t currentOffset=" + this.f43303d + ",\t currentOffsetRead=" + e() + ",\t endOffset=" + this.f43305f + '}';
    }

    public void a(long j) {
        long j2 = this.f43302c;
        if (j < j2) {
            j = j2;
        }
        long j3 = this.f43305f;
        if (j3 > 0) {
            long j4 = j3 + 1;
            if (j > j4) {
                j = j4;
            }
        }
        this.f43303d.set(j);
    }

    public void c(long j) {
        if (j >= this.f43302c) {
            this.f43305f = j;
            return;
        }
        Log.w("Segment", "setEndOffset: endOffset = " + j + ", segment = " + this);
        if (j == -1) {
            this.f43305f = j;
        }
    }

    public void b(long j) {
        this.f43303d.addAndGet(j);
    }

    public void d(long j) {
        if (j >= this.f43303d.get()) {
            this.f43304e = j;
        }
    }

    public void b(int i) {
        this.f43301b = i;
    }

    public void a(int i) {
        this.f43306g = i;
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
        this.f43303d = atomicLong;
        this.f43301b = 0;
        this.f43302c = iVar.f43302c;
        this.f43305f = iVar.f43305f;
        atomicLong.set(iVar.f43303d.get());
        this.f43304e = this.f43303d.get();
        this.f43306g = iVar.f43306g;
    }

    public i(JSONObject jSONObject) {
        this.f43303d = new AtomicLong();
        this.f43301b = 0;
        this.f43302c = jSONObject.optLong("st");
        c(jSONObject.optLong("en"));
        a(jSONObject.optLong("cu"));
        d(d());
    }
}
