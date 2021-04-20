package d.o.a.e.b.i;

import android.util.Log;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final long f68037a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicLong f68038b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f68039c;

    /* renamed from: d  reason: collision with root package name */
    public long f68040d;

    /* renamed from: e  reason: collision with root package name */
    public int f68041e;

    /* renamed from: f  reason: collision with root package name */
    public volatile l f68042f;

    /* renamed from: g  reason: collision with root package name */
    public int f68043g;

    public i(long j, long j2) {
        AtomicLong atomicLong = new AtomicLong();
        this.f68038b = atomicLong;
        this.f68043g = 0;
        this.f68037a = j;
        atomicLong.set(j);
        this.f68039c = j;
        if (j2 >= j) {
            this.f68040d = j2;
        } else {
            this.f68040d = -1L;
        }
    }

    public long a() {
        return this.f68038b.get() - this.f68037a;
    }

    public void b(int i) {
        this.f68041e = i;
    }

    public void c(long j) {
        if (j >= this.f68037a) {
            this.f68038b.set(j);
        }
    }

    public long d() {
        long j = this.f68040d;
        if (j >= this.f68037a) {
            return (j - k()) + 1;
        }
        return -1L;
    }

    public void e(int i) {
        this.f68043g = i;
    }

    public void f(long j) {
        this.f68038b.addAndGet(j);
    }

    public long g() {
        return this.f68037a;
    }

    public void h(long j) {
        if (j >= this.f68037a) {
            this.f68040d = j;
            return;
        }
        Log.w("Segment", "setEndOffset: endOffset = " + j + ", segment = " + this);
        if (j == -1) {
            this.f68040d = j;
        }
    }

    public long i() {
        return this.f68038b.get();
    }

    public void j(long j) {
        if (j >= this.f68038b.get()) {
            this.f68039c = j;
        }
    }

    public long k() {
        l lVar = this.f68042f;
        if (lVar != null) {
            long s = lVar.s();
            if (s > this.f68039c) {
                return s;
            }
        }
        return this.f68039c;
    }

    public long l() {
        return this.f68040d;
    }

    public int m() {
        return this.f68041e;
    }

    public void n() {
        this.f68043g++;
    }

    public void o() {
        this.f68043g--;
    }

    public int p() {
        return this.f68043g;
    }

    public JSONObject q() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("st", g());
        jSONObject.put("cu", i());
        jSONObject.put("en", l());
        return jSONObject;
    }

    public String toString() {
        return "Segment{startOffset=" + this.f68037a + ",\t currentOffset=" + this.f68038b + ",\t currentOffsetRead=" + k() + ",\t endOffset=" + this.f68040d + '}';
    }

    public i(i iVar) {
        AtomicLong atomicLong = new AtomicLong();
        this.f68038b = atomicLong;
        this.f68043g = 0;
        this.f68037a = iVar.f68037a;
        atomicLong.set(iVar.f68038b.get());
        this.f68039c = this.f68038b.get();
        this.f68040d = iVar.f68040d;
        this.f68041e = iVar.f68041e;
    }

    public i(JSONObject jSONObject) {
        this.f68038b = new AtomicLong();
        this.f68043g = 0;
        this.f68037a = jSONObject.optLong("st");
        h(jSONObject.optLong("en"));
        c(jSONObject.optLong("cu"));
        j(i());
    }
}
