package d.b.m0.a;

import android.content.Context;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import d.b.m0.a.f.i;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f64030a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f64031b;

    /* renamed from: c  reason: collision with root package name */
    public long f64032c;

    /* renamed from: d  reason: collision with root package name */
    public long f64033d;

    /* renamed from: e  reason: collision with root package name */
    public long f64034e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f64035f;

    /* renamed from: g  reason: collision with root package name */
    public int f64036g;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Context f64037a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f64038b = true;

        /* renamed from: c  reason: collision with root package name */
        public long f64039c = StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD;

        /* renamed from: d  reason: collision with root package name */
        public long f64040d = 60000;

        /* renamed from: e  reason: collision with root package name */
        public long f64041e = 10000;

        /* renamed from: f  reason: collision with root package name */
        public boolean f64042f = false;

        /* renamed from: g  reason: collision with root package name */
        public int f64043g = 1000;

        public b c() {
            if (this.f64037a == null) {
                i.b("Context must be not empty!");
                return null;
            }
            return new b(this, (byte) 0);
        }

        public a e(Context context) {
            this.f64037a = context;
            return this;
        }

        public a j(boolean z) {
            this.f64038b = z;
            return this;
        }

        public a k(int i) {
            if (i <= 0) {
                i = 0;
            }
            if (i >= 1000) {
                i = 1000;
            }
            this.f64043g = i;
            return this;
        }

        public a l(boolean z) {
            this.f64042f = z;
            return this;
        }

        public a m(int i) {
            this.f64040d = i * 60 * 1000;
            return this;
        }

        public a n(long j) {
            this.f64039c = j * 1000;
            return this;
        }

        public a o(long j) {
            this.f64041e = j * 1000;
            return this;
        }
    }

    public /* synthetic */ b(a aVar, byte b2) {
        this(aVar);
    }

    public final Context a() {
        return this.f64030a;
    }

    public final boolean b() {
        return this.f64031b;
    }

    public final long c() {
        return this.f64032c;
    }

    public final long d() {
        return this.f64033d;
    }

    public final long e() {
        return this.f64034e;
    }

    public final boolean f() {
        return this.f64035f;
    }

    public final int g() {
        return this.f64036g;
    }

    public b(a aVar) {
        this.f64030a = aVar.f64037a;
        this.f64031b = aVar.f64038b;
        this.f64032c = aVar.f64039c;
        this.f64033d = aVar.f64040d;
        this.f64035f = aVar.f64042f;
        this.f64034e = aVar.f64041e;
        this.f64036g = aVar.f64043g;
    }
}
