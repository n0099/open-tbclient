package d.o.a.e.b.i;

import android.util.Log;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final long f71167a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicLong f71168b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f71169c;

    /* renamed from: d  reason: collision with root package name */
    public long f71170d;

    /* renamed from: e  reason: collision with root package name */
    public int f71171e;

    /* renamed from: f  reason: collision with root package name */
    public volatile l f71172f;

    /* renamed from: g  reason: collision with root package name */
    public int f71173g;

    public i(long j, long j2) {
        AtomicLong atomicLong = new AtomicLong();
        this.f71168b = atomicLong;
        this.f71173g = 0;
        this.f71167a = j;
        atomicLong.set(j);
        this.f71169c = j;
        if (j2 >= j) {
            this.f71170d = j2;
        } else {
            this.f71170d = -1L;
        }
    }

    public long a() {
        return this.f71168b.get() - this.f71167a;
    }

    public void b(int i2) {
        this.f71171e = i2;
    }

    public void c(long j) {
        if (j >= this.f71167a) {
            this.f71168b.set(j);
        }
    }

    public long d() {
        long j = this.f71170d;
        if (j >= this.f71167a) {
            return (j - k()) + 1;
        }
        return -1L;
    }

    public void e(int i2) {
        this.f71173g = i2;
    }

    public void f(long j) {
        this.f71168b.addAndGet(j);
    }

    public long g() {
        return this.f71167a;
    }

    public void h(long j) {
        if (j >= this.f71167a) {
            this.f71170d = j;
            return;
        }
        Log.w("Segment", "setEndOffset: endOffset = " + j + ", segment = " + this);
        if (j == -1) {
            this.f71170d = j;
        }
    }

    public long i() {
        return this.f71168b.get();
    }

    public void j(long j) {
        if (j >= this.f71168b.get()) {
            this.f71169c = j;
        }
    }

    public long k() {
        l lVar = this.f71172f;
        if (lVar != null) {
            long s = lVar.s();
            if (s > this.f71169c) {
                return s;
            }
        }
        return this.f71169c;
    }

    public long l() {
        return this.f71170d;
    }

    public int m() {
        return this.f71171e;
    }

    public void n() {
        this.f71173g++;
    }

    public void o() {
        this.f71173g--;
    }

    public int p() {
        return this.f71173g;
    }

    public JSONObject q() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("st", g());
        jSONObject.put("cu", i());
        jSONObject.put("en", l());
        return jSONObject;
    }

    public String toString() {
        return "Segment{startOffset=" + this.f71167a + ",\t currentOffset=" + this.f71168b + ",\t currentOffsetRead=" + k() + ",\t endOffset=" + this.f71170d + '}';
    }

    public i(i iVar) {
        AtomicLong atomicLong = new AtomicLong();
        this.f71168b = atomicLong;
        this.f71173g = 0;
        this.f71167a = iVar.f71167a;
        atomicLong.set(iVar.f71168b.get());
        this.f71169c = this.f71168b.get();
        this.f71170d = iVar.f71170d;
        this.f71171e = iVar.f71171e;
    }

    public i(JSONObject jSONObject) {
        this.f71168b = new AtomicLong();
        this.f71173g = 0;
        this.f71167a = jSONObject.optLong("st");
        h(jSONObject.optLong("en"));
        c(jSONObject.optLong("cu"));
        j(i());
    }
}
