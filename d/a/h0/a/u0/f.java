package d.a.h0.a.u0;

import android.os.Bundle;
import android.util.Log;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.h0.a.k;
import d.a.h0.a.r1.i;
import d.a.h0.a.r1.m;
import d.a.h0.a.y0.e.f.c;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class f extends m {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f44736i = k.f43101a;

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, AbstractC0821f> f44737f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public final d.a.h0.a.y0.e.f.c f44738g = new c.a();

    /* renamed from: h  reason: collision with root package name */
    public final d.a.h0.a.y0.e.f.c f44739h = new c.a();

    /* loaded from: classes2.dex */
    public class a implements d.a.h0.a.i2.u0.b<AbstractC0821f> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(AbstractC0821f abstractC0821f) {
            abstractC0821f.g(f.this);
            f.this.f44737f.put(abstractC0821f.f44745e, abstractC0821f);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a.h0.a.i2.u0.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.i2.s0.a f44741e;

        public b(d.a.h0.a.i2.s0.a aVar) {
            this.f44741e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(String str) {
            if ("on_progress".equals(str)) {
                f.this.y((i.a) new i.a("installer_on_progress").s(" event_params_installer_progress", this.f44741e.j()));
            } else if ("pump_finish".equals(str)) {
                f.this.o("installer_on_pump_finish");
            } else if ("finish".equals(str)) {
                f.this.o("installer_on_finish");
            } else if (IntentConfig.START.equals(str)) {
                f.this.o("installer_on_start");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.a.h0.a.i2.u0.b<AbstractC0821f> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.i2.s0.a f44743e;

        public c(f fVar, d.a.h0.a.i2.s0.a aVar) {
            this.f44743e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(AbstractC0821f abstractC0821f) {
            this.f44743e.d(abstractC0821f);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements d.a.h0.a.i2.u0.b<AbstractC0821f> {
        public d(f fVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(AbstractC0821f abstractC0821f) {
            abstractC0821f.e();
        }
    }

    /* loaded from: classes2.dex */
    public class e implements d.a.h0.a.i2.u0.b<AbstractC0821f> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean[] f44744e;

        public e(f fVar, boolean[] zArr) {
            this.f44744e = zArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(AbstractC0821f abstractC0821f) {
            boolean[] zArr = this.f44744e;
            zArr[0] = abstractC0821f.c() & zArr[0];
        }
    }

    /* renamed from: d.a.h0.a.u0.f$f  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractC0821f implements d.a.h0.a.i2.u0.b<Pipe.SourceChannel> {

        /* renamed from: e  reason: collision with root package name */
        public final String f44745e;

        /* renamed from: f  reason: collision with root package name */
        public final Bundle f44746f = new Bundle();

        /* renamed from: g  reason: collision with root package name */
        public f f44747g;

        public AbstractC0821f(String str) {
            this.f44745e = str;
        }

        public Bundle b() {
            return this.f44746f;
        }

        public boolean c() {
            return b().getBoolean("flag_is_ok");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: d */
        public void onCallback(Pipe.SourceChannel sourceChannel) {
            f fVar = this.f44747g;
            if (fVar == null || !f(sourceChannel, fVar.f44738g.A())) {
                return;
            }
            h();
        }

        public void e() {
        }

        public abstract boolean f(Pipe.SourceChannel sourceChannel, Bundle bundle);

        public final void g(f fVar) {
            this.f44747g = fVar;
        }

        public final void h() {
            this.f44746f.putBoolean("flag_is_ok", true);
        }

        public String toString() {
            return this.f44745e;
        }
    }

    public final void A(String str) {
        if (f44736i) {
            d.a.h0.a.y0.g.a.d(this.f44738g.n("launch_id", "")).f(str).b("SwanInstaller");
            Log.i("SwanInstaller", str);
        }
    }

    public f e(AbstractC0821f... abstractC0821fArr) {
        d.a.h0.a.i2.u0.a.d(new a(), abstractC0821fArr);
        return this;
    }

    public f f(Bundle bundle) {
        this.f44738g.C(bundle);
        return this;
    }

    public final void g(d.a.h0.a.i2.u0.b<AbstractC0821f> bVar) {
        d.a.h0.a.i2.u0.a.c(bVar, this.f44737f.values());
    }

    public synchronized f h(ReadableByteChannel readableByteChannel) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f44739h.b();
        d.a.h0.a.i2.s0.a aVar = new d.a.h0.a.i2.s0.a();
        aVar.o(32768);
        aVar.q(30L, TimeUnit.SECONDS);
        aVar.g(this.f44738g.A());
        aVar.p(new b(aVar));
        g(new c(this, aVar));
        A("connect: " + readableByteChannel + " at: " + currentTimeMillis);
        aVar.h(readableByteChannel);
        boolean i2 = i();
        if (f44736i) {
            A("allOk: " + i2 + " cost: " + (System.currentTimeMillis() - currentTimeMillis));
        }
        if (!i2) {
            g(new d(this));
        }
        return this;
    }

    public boolean i() {
        if (this.f44737f.isEmpty() || this.f44739h.d("flag_is_ok", false)) {
            return true;
        }
        boolean[] zArr = {true};
        g(new e(this, zArr));
        this.f44739h.q("flag_is_ok", zArr[0]);
        return zArr[0];
    }
}
