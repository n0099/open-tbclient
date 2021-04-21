package d.b.h0.a.u0;

import android.os.Bundle;
import android.util.Log;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.b.h0.a.k;
import d.b.h0.a.r1.i;
import d.b.h0.a.r1.m;
import d.b.h0.a.y0.e.f.c;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class f extends m {
    public static final boolean i = k.f45772a;

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, AbstractC0882f> f47324f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public final d.b.h0.a.y0.e.f.c f47325g = new c.a();

    /* renamed from: h  reason: collision with root package name */
    public final d.b.h0.a.y0.e.f.c f47326h = new c.a();

    /* loaded from: classes2.dex */
    public class a implements d.b.h0.a.i2.u0.b<AbstractC0882f> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(AbstractC0882f abstractC0882f) {
            abstractC0882f.g(f.this);
            f.this.f47324f.put(abstractC0882f.f47332e, abstractC0882f);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.h0.a.i2.u0.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.i2.s0.a f47328e;

        public b(d.b.h0.a.i2.s0.a aVar) {
            this.f47328e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(String str) {
            if ("on_progress".equals(str)) {
                f.this.t((i.a) new i.a("installer_on_progress").s(" event_params_installer_progress", this.f47328e.j()));
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
    public class c implements d.b.h0.a.i2.u0.b<AbstractC0882f> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.i2.s0.a f47330e;

        public c(f fVar, d.b.h0.a.i2.s0.a aVar) {
            this.f47330e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(AbstractC0882f abstractC0882f) {
            this.f47330e.d(abstractC0882f);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements d.b.h0.a.i2.u0.b<AbstractC0882f> {
        public d(f fVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(AbstractC0882f abstractC0882f) {
            abstractC0882f.e();
        }
    }

    /* loaded from: classes2.dex */
    public class e implements d.b.h0.a.i2.u0.b<AbstractC0882f> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean[] f47331e;

        public e(f fVar, boolean[] zArr) {
            this.f47331e = zArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(AbstractC0882f abstractC0882f) {
            boolean[] zArr = this.f47331e;
            zArr[0] = abstractC0882f.c() & zArr[0];
        }
    }

    /* renamed from: d.b.h0.a.u0.f$f  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractC0882f implements d.b.h0.a.i2.u0.b<Pipe.SourceChannel> {

        /* renamed from: e  reason: collision with root package name */
        public final String f47332e;

        /* renamed from: f  reason: collision with root package name */
        public final Bundle f47333f = new Bundle();

        /* renamed from: g  reason: collision with root package name */
        public f f47334g;

        public AbstractC0882f(String str) {
            this.f47332e = str;
        }

        public Bundle b() {
            return this.f47333f;
        }

        public boolean c() {
            return b().getBoolean("flag_is_ok");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: d */
        public void onCallback(Pipe.SourceChannel sourceChannel) {
            f fVar = this.f47334g;
            if (fVar == null || !f(sourceChannel, fVar.f47325g.A())) {
                return;
            }
            h();
        }

        public void e() {
        }

        public abstract boolean f(Pipe.SourceChannel sourceChannel, Bundle bundle);

        public final void g(f fVar) {
            this.f47334g = fVar;
        }

        public final void h() {
            this.f47333f.putBoolean("flag_is_ok", true);
        }

        public String toString() {
            return this.f47332e;
        }
    }

    public final void A(String str) {
        if (i) {
            d.b.h0.a.y0.g.a.d(this.f47325g.n("launch_id", "")).f(str).b("SwanInstaller");
            Log.i("SwanInstaller", str);
        }
    }

    public f e(AbstractC0882f... abstractC0882fArr) {
        d.b.h0.a.i2.u0.a.d(new a(), abstractC0882fArr);
        return this;
    }

    public f f(Bundle bundle) {
        this.f47325g.C(bundle);
        return this;
    }

    public final void g(d.b.h0.a.i2.u0.b<AbstractC0882f> bVar) {
        d.b.h0.a.i2.u0.a.c(bVar, this.f47324f.values());
    }

    public synchronized f y(ReadableByteChannel readableByteChannel) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f47326h.b();
        d.b.h0.a.i2.s0.a aVar = new d.b.h0.a.i2.s0.a();
        aVar.o(32768);
        aVar.q(30L, TimeUnit.SECONDS);
        aVar.g(this.f47325g.A());
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
        if (this.f47324f.isEmpty() || this.f47326h.d("flag_is_ok", false)) {
            return true;
        }
        boolean[] zArr = {true};
        g(new e(this, zArr));
        this.f47326h.q("flag_is_ok", zArr[0]);
        return zArr[0];
    }
}
