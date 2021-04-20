package d.b.m0.a;

import android.content.Context;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import d.b.m0.a.f.i;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f64758a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f64759b;

    /* renamed from: c  reason: collision with root package name */
    public long f64760c;

    /* renamed from: d  reason: collision with root package name */
    public long f64761d;

    /* renamed from: e  reason: collision with root package name */
    public long f64762e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f64763f;

    /* renamed from: g  reason: collision with root package name */
    public int f64764g;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Context f64765a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f64766b = true;

        /* renamed from: c  reason: collision with root package name */
        public long f64767c = StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD;

        /* renamed from: d  reason: collision with root package name */
        public long f64768d = 60000;

        /* renamed from: e  reason: collision with root package name */
        public long f64769e = 10000;

        /* renamed from: f  reason: collision with root package name */
        public boolean f64770f = false;

        /* renamed from: g  reason: collision with root package name */
        public int f64771g = 1000;

        public b c() {
            if (this.f64765a == null) {
                i.b("Context must be not empty!");
                return null;
            }
            return new b(this, (byte) 0);
        }

        public a e(Context context) {
            this.f64765a = context;
            return this;
        }

        public a j(boolean z) {
            this.f64766b = z;
            return this;
        }

        public a k(int i) {
            if (i <= 0) {
                i = 0;
            }
            if (i >= 1000) {
                i = 1000;
            }
            this.f64771g = i;
            return this;
        }

        public a l(boolean z) {
            this.f64770f = z;
            return this;
        }

        public a m(int i) {
            this.f64768d = i * 60 * 1000;
            return this;
        }

        public a n(long j) {
            this.f64767c = j * 1000;
            return this;
        }

        public a o(long j) {
            this.f64769e = j * 1000;
            return this;
        }
    }

    public /* synthetic */ b(a aVar, byte b2) {
        this(aVar);
    }

    public final Context a() {
        return this.f64758a;
    }

    public final boolean b() {
        return this.f64759b;
    }

    public final long c() {
        return this.f64760c;
    }

    public final long d() {
        return this.f64761d;
    }

    public final long e() {
        return this.f64762e;
    }

    public final boolean f() {
        return this.f64763f;
    }

    public final int g() {
        return this.f64764g;
    }

    public b(a aVar) {
        this.f64758a = aVar.f64765a;
        this.f64759b = aVar.f64766b;
        this.f64760c = aVar.f64767c;
        this.f64761d = aVar.f64768d;
        this.f64763f = aVar.f64770f;
        this.f64762e = aVar.f64769e;
        this.f64764g = aVar.f64771g;
    }
}
