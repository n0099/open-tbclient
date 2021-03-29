package d.b.g0.a.u0;

import android.os.Bundle;
import android.util.Log;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.b.g0.a.k;
import d.b.g0.a.r1.i;
import d.b.g0.a.r1.m;
import d.b.g0.a.y0.e.f.c;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class f extends m {
    public static final boolean i = k.f45051a;

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, AbstractC0850f> f46603f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public final d.b.g0.a.y0.e.f.c f46604g = new c.a();

    /* renamed from: h  reason: collision with root package name */
    public final d.b.g0.a.y0.e.f.c f46605h = new c.a();

    /* loaded from: classes2.dex */
    public class a implements d.b.g0.a.i2.u0.b<AbstractC0850f> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(AbstractC0850f abstractC0850f) {
            abstractC0850f.g(f.this);
            f.this.f46603f.put(abstractC0850f.f46611e, abstractC0850f);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.g0.a.i2.u0.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.i2.s0.a f46607e;

        public b(d.b.g0.a.i2.s0.a aVar) {
            this.f46607e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(String str) {
            if ("on_progress".equals(str)) {
                f.this.t((i.a) new i.a("installer_on_progress").s(" event_params_installer_progress", this.f46607e.j()));
            } else if ("pump_finish".equals(str)) {
                f.this.r("installer_on_pump_finish");
            } else if ("finish".equals(str)) {
                f.this.r("installer_on_finish");
            } else if (IntentConfig.START.equals(str)) {
                f.this.r("installer_on_start");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.b.g0.a.i2.u0.b<AbstractC0850f> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.i2.s0.a f46609e;

        public c(f fVar, d.b.g0.a.i2.s0.a aVar) {
            this.f46609e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(AbstractC0850f abstractC0850f) {
            this.f46609e.d(abstractC0850f);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements d.b.g0.a.i2.u0.b<AbstractC0850f> {
        public d(f fVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(AbstractC0850f abstractC0850f) {
            abstractC0850f.e();
        }
    }

    /* loaded from: classes2.dex */
    public class e implements d.b.g0.a.i2.u0.b<AbstractC0850f> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean[] f46610e;

        public e(f fVar, boolean[] zArr) {
            this.f46610e = zArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(AbstractC0850f abstractC0850f) {
            boolean[] zArr = this.f46610e;
            zArr[0] = abstractC0850f.c() & zArr[0];
        }
    }

    /* renamed from: d.b.g0.a.u0.f$f  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractC0850f implements d.b.g0.a.i2.u0.b<Pipe.SourceChannel> {

        /* renamed from: e  reason: collision with root package name */
        public final String f46611e;

        /* renamed from: f  reason: collision with root package name */
        public final Bundle f46612f = new Bundle();

        /* renamed from: g  reason: collision with root package name */
        public f f46613g;

        public AbstractC0850f(String str) {
            this.f46611e = str;
        }

        public Bundle b() {
            return this.f46612f;
        }

        public boolean c() {
            return b().getBoolean("flag_is_ok");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: d */
        public void onCallback(Pipe.SourceChannel sourceChannel) {
            f fVar = this.f46613g;
            if (fVar == null || !f(sourceChannel, fVar.f46604g.A())) {
                return;
            }
            h();
        }

        public void e() {
        }

        public abstract boolean f(Pipe.SourceChannel sourceChannel, Bundle bundle);

        public final void g(f fVar) {
            this.f46613g = fVar;
        }

        public final void h() {
            this.f46612f.putBoolean("flag_is_ok", true);
        }

        public String toString() {
            return this.f46611e;
        }
    }

    public final void A(String str) {
        if (i) {
            d.b.g0.a.y0.g.a.d(this.f46604g.n("launch_id", "")).f(str).b("SwanInstaller");
            Log.i("SwanInstaller", str);
        }
    }

    public f e(AbstractC0850f... abstractC0850fArr) {
        d.b.g0.a.i2.u0.a.d(new a(), abstractC0850fArr);
        return this;
    }

    public f f(Bundle bundle) {
        this.f46604g.C(bundle);
        return this;
    }

    public final void g(d.b.g0.a.i2.u0.b<AbstractC0850f> bVar) {
        d.b.g0.a.i2.u0.a.c(bVar, this.f46603f.values());
    }

    public synchronized f y(ReadableByteChannel readableByteChannel) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f46605h.b();
        d.b.g0.a.i2.s0.a aVar = new d.b.g0.a.i2.s0.a();
        aVar.o(32768);
        aVar.q(30L, TimeUnit.SECONDS);
        aVar.g(this.f46604g.A());
        aVar.p(new b(aVar));
        g(new c(this, aVar));
        A("connect: " + readableByteChannel + " at: " + currentTimeMillis);
        aVar.h(readableByteChannel);
        boolean z = z();
        if (i) {
            A("allOk: " + z + " cost: " + (System.currentTimeMillis() - currentTimeMillis));
        }
        if (!z) {
            g(new d(this));
        }
        return this;
    }

    public boolean z() {
        if (this.f46603f.isEmpty() || this.f46605h.d("flag_is_ok", false)) {
            return true;
        }
        boolean[] zArr = {true};
        g(new e(this, zArr));
        this.f46605h.q("flag_is_ok", zArr[0]);
        return zArr[0];
    }
}
