package d.a.n0.a;

import android.content.Context;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import d.a.n0.a.f.i;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f63337a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f63338b;

    /* renamed from: c  reason: collision with root package name */
    public long f63339c;

    /* renamed from: d  reason: collision with root package name */
    public long f63340d;

    /* renamed from: e  reason: collision with root package name */
    public long f63341e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f63342f;

    /* renamed from: g  reason: collision with root package name */
    public int f63343g;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Context f63344a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f63345b = true;

        /* renamed from: c  reason: collision with root package name */
        public long f63346c = StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD;

        /* renamed from: d  reason: collision with root package name */
        public long f63347d = 60000;

        /* renamed from: e  reason: collision with root package name */
        public long f63348e = 10000;

        /* renamed from: f  reason: collision with root package name */
        public boolean f63349f = false;

        /* renamed from: g  reason: collision with root package name */
        public int f63350g = 1000;

        public b c() {
            if (this.f63344a == null) {
                i.b("Context must be not empty!");
                return null;
            }
            return new b(this, (byte) 0);
        }

        public a e(Context context) {
            this.f63344a = context;
            return this;
        }

        public a j(boolean z) {
            this.f63345b = z;
            return this;
        }

        public a k(int i2) {
            if (i2 <= 0) {
                i2 = 0;
            }
            if (i2 >= 1000) {
                i2 = 1000;
            }
            this.f63350g = i2;
            return this;
        }

        public a l(boolean z) {
            this.f63349f = z;
            return this;
        }

        public a m(int i2) {
            this.f63347d = i2 * 60 * 1000;
            return this;
        }

        public a n(long j) {
            this.f63346c = j * 1000;
            return this;
        }

        public a o(long j) {
            this.f63348e = j * 1000;
            return this;
        }
    }

    public /* synthetic */ b(a aVar, byte b2) {
        this(aVar);
    }

    public final Context a() {
        return this.f63337a;
    }

    public final boolean b() {
        return this.f63338b;
    }

    public final long c() {
        return this.f63339c;
    }

    public final long d() {
        return this.f63340d;
    }

    public final long e() {
        return this.f63341e;
    }

    public final boolean f() {
        return this.f63342f;
    }

    public final int g() {
        return this.f63343g;
    }

    public b(a aVar) {
        this.f63337a = aVar.f63344a;
        this.f63338b = aVar.f63345b;
        this.f63339c = aVar.f63346c;
        this.f63340d = aVar.f63347d;
        this.f63342f = aVar.f63349f;
        this.f63341e = aVar.f63348e;
        this.f63343g = aVar.f63350g;
    }
}
