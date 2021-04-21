package d.b.n0.a;

import android.content.Context;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import d.b.n0.a.f.i;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f65026a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f65027b;

    /* renamed from: c  reason: collision with root package name */
    public long f65028c;

    /* renamed from: d  reason: collision with root package name */
    public long f65029d;

    /* renamed from: e  reason: collision with root package name */
    public long f65030e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f65031f;

    /* renamed from: g  reason: collision with root package name */
    public int f65032g;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Context f65033a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f65034b = true;

        /* renamed from: c  reason: collision with root package name */
        public long f65035c = StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD;

        /* renamed from: d  reason: collision with root package name */
        public long f65036d = 60000;

        /* renamed from: e  reason: collision with root package name */
        public long f65037e = 10000;

        /* renamed from: f  reason: collision with root package name */
        public boolean f65038f = false;

        /* renamed from: g  reason: collision with root package name */
        public int f65039g = 1000;

        public b c() {
            if (this.f65033a == null) {
                i.b("Context must be not empty!");
                return null;
            }
            return new b(this, (byte) 0);
        }

        public a e(Context context) {
            this.f65033a = context;
            return this;
        }

        public a j(boolean z) {
            this.f65034b = z;
            return this;
        }

        public a k(int i) {
            if (i <= 0) {
                i = 0;
            }
            if (i >= 1000) {
                i = 1000;
            }
            this.f65039g = i;
            return this;
        }

        public a l(boolean z) {
            this.f65038f = z;
            return this;
        }

        public a m(int i) {
            this.f65036d = i * 60 * 1000;
            return this;
        }

        public a n(long j) {
            this.f65035c = j * 1000;
            return this;
        }

        public a o(long j) {
            this.f65037e = j * 1000;
            return this;
        }
    }

    public /* synthetic */ b(a aVar, byte b2) {
        this(aVar);
    }

    public final Context a() {
        return this.f65026a;
    }

    public final boolean b() {
        return this.f65027b;
    }

    public final long c() {
        return this.f65028c;
    }

    public final long d() {
        return this.f65029d;
    }

    public final long e() {
        return this.f65030e;
    }

    public final boolean f() {
        return this.f65031f;
    }

    public final int g() {
        return this.f65032g;
    }

    public b(a aVar) {
        this.f65026a = aVar.f65033a;
        this.f65027b = aVar.f65034b;
        this.f65028c = aVar.f65035c;
        this.f65029d = aVar.f65036d;
        this.f65031f = aVar.f65038f;
        this.f65030e = aVar.f65037e;
        this.f65032g = aVar.f65039g;
    }
}
