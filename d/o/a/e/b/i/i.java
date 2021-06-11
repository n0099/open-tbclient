package d.o.a.e.b.i;

import android.util.Log;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final long f71063a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicLong f71064b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f71065c;

    /* renamed from: d  reason: collision with root package name */
    public long f71066d;

    /* renamed from: e  reason: collision with root package name */
    public int f71067e;

    /* renamed from: f  reason: collision with root package name */
    public volatile l f71068f;

    /* renamed from: g  reason: collision with root package name */
    public int f71069g;

    public i(long j, long j2) {
        AtomicLong atomicLong = new AtomicLong();
        this.f71064b = atomicLong;
        this.f71069g = 0;
        this.f71063a = j;
        atomicLong.set(j);
        this.f71065c = j;
        if (j2 >= j) {
            this.f71066d = j2;
        } else {
            this.f71066d = -1L;
        }
    }

    public long a() {
        return this.f71064b.get() - this.f71063a;
    }

    public void b(int i2) {
        this.f71067e = i2;
    }

    public void c(long j) {
        if (j >= this.f71063a) {
            this.f71064b.set(j);
        }
    }

    public long d() {
        long j = this.f71066d;
        if (j >= this.f71063a) {
            return (j - k()) + 1;
        }
        return -1L;
    }

    public void e(int i2) {
        this.f71069g = i2;
    }

    public void f(long j) {
        this.f71064b.addAndGet(j);
    }

    public long g() {
        return this.f71063a;
    }

    public void h(long j) {
        if (j >= this.f71063a) {
            this.f71066d = j;
            return;
        }
        Log.w("Segment", "setEndOffset: endOffset = " + j + ", segment = " + this);
        if (j == -1) {
            this.f71066d = j;
        }
    }

    public long i() {
        return this.f71064b.get();
    }

    public void j(long j) {
        if (j >= this.f71064b.get()) {
            this.f71065c = j;
        }
    }

    public long k() {
        l lVar = this.f71068f;
        if (lVar != null) {
            long s = lVar.s();
            if (s > this.f71065c) {
                return s;
            }
        }
        return this.f71065c;
    }

    public long l() {
        return this.f71066d;
    }

    public int m() {
        return this.f71067e;
    }

    public void n() {
        this.f71069g++;
    }

    public void o() {
        this.f71069g--;
    }

    public int p() {
        return this.f71069g;
    }

    public JSONObject q() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("st", g());
        jSONObject.put("cu", i());
        jSONObject.put("en", l());
        return jSONObject;
    }

    public String toString() {
        return "Segment{startOffset=" + this.f71063a + ",\t currentOffset=" + this.f71064b + ",\t currentOffsetRead=" + k() + ",\t endOffset=" + this.f71066d + '}';
    }

    public i(i iVar) {
        AtomicLong atomicLong = new AtomicLong();
        this.f71064b = atomicLong;
        this.f71069g = 0;
        this.f71063a = iVar.f71063a;
        atomicLong.set(iVar.f71064b.get());
        this.f71065c = this.f71064b.get();
        this.f71066d = iVar.f71066d;
        this.f71067e = iVar.f71067e;
    }

    public i(JSONObject jSONObject) {
        this.f71064b = new AtomicLong();
        this.f71069g = 0;
        this.f71063a = jSONObject.optLong("st");
        h(jSONObject.optLong("en"));
        c(jSONObject.optLong("cu"));
        j(i());
    }
}
