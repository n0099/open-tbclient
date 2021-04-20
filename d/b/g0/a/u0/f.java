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
    public static final boolean i = k.f45443a;

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, AbstractC0862f> f46995f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public final d.b.g0.a.y0.e.f.c f46996g = new c.a();

    /* renamed from: h  reason: collision with root package name */
    public final d.b.g0.a.y0.e.f.c f46997h = new c.a();

    /* loaded from: classes2.dex */
    public class a implements d.b.g0.a.i2.u0.b<AbstractC0862f> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(AbstractC0862f abstractC0862f) {
            abstractC0862f.g(f.this);
            f.this.f46995f.put(abstractC0862f.f47003e, abstractC0862f);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.g0.a.i2.u0.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.i2.s0.a f46999e;

        public b(d.b.g0.a.i2.s0.a aVar) {
            this.f46999e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(String str) {
            if ("on_progress".equals(str)) {
                f.this.t((i.a) new i.a("installer_on_progress").s(" event_params_installer_progress", this.f46999e.j()));
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
    public class c implements d.b.g0.a.i2.u0.b<AbstractC0862f> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.i2.s0.a f47001e;

        public c(f fVar, d.b.g0.a.i2.s0.a aVar) {
            this.f47001e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(AbstractC0862f abstractC0862f) {
            this.f47001e.d(abstractC0862f);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements d.b.g0.a.i2.u0.b<AbstractC0862f> {
        public d(f fVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(AbstractC0862f abstractC0862f) {
            abstractC0862f.e();
        }
    }

    /* loaded from: classes2.dex */
    public class e implements d.b.g0.a.i2.u0.b<AbstractC0862f> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean[] f47002e;

        public e(f fVar, boolean[] zArr) {
            this.f47002e = zArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(AbstractC0862f abstractC0862f) {
            boolean[] zArr = this.f47002e;
            zArr[0] = abstractC0862f.c() & zArr[0];
        }
    }

    /* renamed from: d.b.g0.a.u0.f$f  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractC0862f implements d.b.g0.a.i2.u0.b<Pipe.SourceChannel> {

        /* renamed from: e  reason: collision with root package name */
        public final String f47003e;

        /* renamed from: f  reason: collision with root package name */
        public final Bundle f47004f = new Bundle();

        /* renamed from: g  reason: collision with root package name */
        public f f47005g;

        public AbstractC0862f(String str) {
            this.f47003e = str;
        }

        public Bundle b() {
            return this.f47004f;
        }

        public boolean c() {
            return b().getBoolean("flag_is_ok");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: d */
        public void onCallback(Pipe.SourceChannel sourceChannel) {
            f fVar = this.f47005g;
            if (fVar == null || !f(sourceChannel, fVar.f46996g.A())) {
                return;
            }
            h();
        }

        public void e() {
        }

        public abstract boolean f(Pipe.SourceChannel sourceChannel, Bundle bundle);

        public final void g(f fVar) {
            this.f47005g = fVar;
        }

        public final void h() {
            this.f47004f.putBoolean("flag_is_ok", true);
        }

        public String toString() {
            return this.f47003e;
        }
    }

    public final void A(String str) {
        if (i) {
            d.b.g0.a.y0.g.a.d(this.f46996g.n("launch_id", "")).f(str).b("SwanInstaller");
            Log.i("SwanInstaller", str);
        }
    }

    public f e(AbstractC0862f... abstractC0862fArr) {
        d.b.g0.a.i2.u0.a.d(new a(), abstractC0862fArr);
        return this;
    }

    public f f(Bundle bundle) {
        this.f46996g.C(bundle);
        return this;
    }

    public final void g(d.b.g0.a.i2.u0.b<AbstractC0862f> bVar) {
        d.b.g0.a.i2.u0.a.c(bVar, this.f46995f.values());
    }

    public synchronized f y(ReadableByteChannel readableByteChannel) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f46997h.b();
        d.b.g0.a.i2.s0.a aVar = new d.b.g0.a.i2.s0.a();
        aVar.o(32768);
        aVar.q(30L, TimeUnit.SECONDS);
        aVar.g(this.f46996g.A());
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
        if (this.f46995f.isEmpty() || this.f46997h.d("flag_is_ok", false)) {
            return true;
        }
        boolean[] zArr = {true};
        g(new e(this, zArr));
        this.f46997h.q("flag_is_ok", zArr[0]);
        return zArr[0];
    }
}
