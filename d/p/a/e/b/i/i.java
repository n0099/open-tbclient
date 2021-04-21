package d.p.a.e.b.i;

import android.util.Log;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final long f68184a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicLong f68185b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f68186c;

    /* renamed from: d  reason: collision with root package name */
    public long f68187d;

    /* renamed from: e  reason: collision with root package name */
    public int f68188e;

    /* renamed from: f  reason: collision with root package name */
    public volatile l f68189f;

    /* renamed from: g  reason: collision with root package name */
    public int f68190g;

    public i(long j, long j2) {
        AtomicLong atomicLong = new AtomicLong();
        this.f68185b = atomicLong;
        this.f68190g = 0;
        this.f68184a = j;
        atomicLong.set(j);
        this.f68186c = j;
        if (j2 >= j) {
            this.f68187d = j2;
        } else {
            this.f68187d = -1L;
        }
    }

    public long a() {
        return this.f68185b.get() - this.f68184a;
    }

    public void b(int i) {
        this.f68188e = i;
    }

    public void c(long j) {
        if (j >= this.f68184a) {
            this.f68185b.set(j);
        }
    }

    public long d() {
        long j = this.f68187d;
        if (j >= this.f68184a) {
            return (j - k()) + 1;
        }
        return -1L;
    }

    public void e(int i) {
        this.f68190g = i;
    }

    public void f(long j) {
        this.f68185b.addAndGet(j);
    }

    public long g() {
        return this.f68184a;
    }

    public void h(long j) {
        if (j >= this.f68184a) {
            this.f68187d = j;
            return;
        }
        Log.w("Segment", "setEndOffset: endOffset = " + j + ", segment = " + this);
        if (j == -1) {
            this.f68187d = j;
        }
    }

    public long i() {
        return this.f68185b.get();
    }

    public void j(long j) {
        if (j >= this.f68185b.get()) {
            this.f68186c = j;
        }
    }

    public long k() {
        l lVar = this.f68189f;
        if (lVar != null) {
            long s = lVar.s();
            if (s > this.f68186c) {
                return s;
            }
        }
        return this.f68186c;
    }

    public long l() {
        return this.f68187d;
    }

    public int m() {
        return this.f68188e;
    }

    public void n() {
        this.f68190g++;
    }

    public void o() {
        this.f68190g--;
    }

    public int p() {
        return this.f68190g;
    }

    public JSONObject q() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("st", g());
        jSONObject.put("cu", i());
        jSONObject.put("en", l());
        return jSONObject;
    }

    public String toString() {
        return "Segment{startOffset=" + this.f68184a + ",\t currentOffset=" + this.f68185b + ",\t currentOffsetRead=" + k() + ",\t endOffset=" + this.f68187d + '}';
    }

    public i(i iVar) {
        AtomicLong atomicLong = new AtomicLong();
        this.f68185b = atomicLong;
        this.f68190g = 0;
        this.f68184a = iVar.f68184a;
        atomicLong.set(iVar.f68185b.get());
        this.f68186c = this.f68185b.get();
        this.f68187d = iVar.f68187d;
        this.f68188e = iVar.f68188e;
    }

    public i(JSONObject jSONObject) {
        this.f68185b = new AtomicLong();
        this.f68190g = 0;
        this.f68184a = jSONObject.optLong("st");
        h(jSONObject.optLong("en"));
        c(jSONObject.optLong("cu"));
        j(i());
    }
}
