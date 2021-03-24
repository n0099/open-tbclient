package d.b.m0.a;

import android.content.Context;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import d.b.m0.a.f.i;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f64029a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f64030b;

    /* renamed from: c  reason: collision with root package name */
    public long f64031c;

    /* renamed from: d  reason: collision with root package name */
    public long f64032d;

    /* renamed from: e  reason: collision with root package name */
    public long f64033e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f64034f;

    /* renamed from: g  reason: collision with root package name */
    public int f64035g;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Context f64036a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f64037b = true;

        /* renamed from: c  reason: collision with root package name */
        public long f64038c = StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD;

        /* renamed from: d  reason: collision with root package name */
        public long f64039d = 60000;

        /* renamed from: e  reason: collision with root package name */
        public long f64040e = 10000;

        /* renamed from: f  reason: collision with root package name */
        public boolean f64041f = false;

        /* renamed from: g  reason: collision with root package name */
        public int f64042g = 1000;

        public b c() {
            if (this.f64036a == null) {
                i.b("Context must be not empty!");
                return null;
            }
            return new b(this, (byte) 0);
        }

        public a e(Context context) {
            this.f64036a = context;
            return this;
        }

        public a j(boolean z) {
            this.f64037b = z;
            return this;
        }

        public a k(int i) {
            if (i <= 0) {
                i = 0;
            }
            if (i >= 1000) {
                i = 1000;
            }
            this.f64042g = i;
            return this;
        }

        public a l(boolean z) {
            this.f64041f = z;
            return this;
        }

        public a m(int i) {
            this.f64039d = i * 60 * 1000;
            return this;
        }

        public a n(long j) {
            this.f64038c = j * 1000;
            return this;
        }

        public a o(long j) {
            this.f64040e = j * 1000;
            return this;
        }
    }

    public /* synthetic */ b(a aVar, byte b2) {
        this(aVar);
    }

    public final Context a() {
        return this.f64029a;
    }

    public final boolean b() {
        return this.f64030b;
    }

    public final long c() {
        return this.f64031c;
    }

    public final long d() {
        return this.f64032d;
    }

    public final long e() {
        return this.f64033e;
    }

    public final boolean f() {
        return this.f64034f;
    }

    public final int g() {
        return this.f64035g;
    }

    public b(a aVar) {
        this.f64029a = aVar.f64036a;
        this.f64030b = aVar.f64037b;
        this.f64031c = aVar.f64038c;
        this.f64032d = aVar.f64039d;
        this.f64034f = aVar.f64041f;
        this.f64033e = aVar.f64040e;
        this.f64035g = aVar.f64042g;
    }
}
