package d.a.l0.a.a1;

import android.os.Bundle;
import android.util.Log;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.l0.a.a2.i;
import d.a.l0.a.a2.m;
import d.a.l0.a.f1.e.f.c;
import d.a.l0.a.k;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class g extends m {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f40696i = k.f43199a;

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, f> f40697f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public final d.a.l0.a.f1.e.f.c f40698g = new c.a();

    /* renamed from: h  reason: collision with root package name */
    public final d.a.l0.a.f1.e.f.c f40699h = new c.a();

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.v2.e1.b<f> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(f fVar) {
            fVar.g(g.this);
            g.this.f40697f.put(fVar.f40705e, fVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.l0.a.v2.e1.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.v2.c1.a f40701e;

        public b(d.a.l0.a.v2.c1.a aVar) {
            this.f40701e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            if ("on_progress".equals(str)) {
                g.this.A((i.a) new i.a("installer_on_progress").u(" event_params_installer_progress", this.f40701e.j()));
            } else if ("pump_finish".equals(str)) {
                g.this.q("installer_on_pump_finish");
            } else if ("finish".equals(str)) {
                g.this.q("installer_on_finish");
            } else if (IntentConfig.START.equals(str)) {
                g.this.q("installer_on_start");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.l0.a.v2.e1.b<f> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.v2.c1.a f40703e;

        public c(g gVar, d.a.l0.a.v2.c1.a aVar) {
            this.f40703e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(f fVar) {
            this.f40703e.d(fVar);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.l0.a.v2.e1.b<f> {
        public d(g gVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(f fVar) {
            fVar.e();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.a.l0.a.v2.e1.b<f> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean[] f40704e;

        public e(g gVar, boolean[] zArr) {
            this.f40704e = zArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(f fVar) {
            boolean[] zArr = this.f40704e;
            zArr[0] = fVar.c() & zArr[0];
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class f implements d.a.l0.a.v2.e1.b<Pipe.SourceChannel> {

        /* renamed from: e  reason: collision with root package name */
        public final String f40705e;

        /* renamed from: f  reason: collision with root package name */
        public final Bundle f40706f = new Bundle();

        /* renamed from: g  reason: collision with root package name */
        public g f40707g;

        public f(String str) {
            this.f40705e = str;
        }

        public Bundle b() {
            return this.f40706f;
        }

        public boolean c() {
            return b().getBoolean("flag_is_ok");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: d */
        public void onCallback(Pipe.SourceChannel sourceChannel) {
            g gVar = this.f40707g;
            if (gVar == null || !f(sourceChannel, gVar.f40698g.C())) {
                return;
            }
            h();
        }

        public void e() {
        }

        public abstract boolean f(Pipe.SourceChannel sourceChannel, Bundle bundle);

        public final void g(g gVar) {
            this.f40707g = gVar;
        }

        public final void h() {
            this.f40706f.putBoolean("flag_is_ok", true);
        }

        public String toString() {
            return this.f40705e;
        }
    }

    public g f(f... fVarArr) {
        d.a.l0.a.v2.e1.a.d(new a(), fVarArr);
        return this;
    }

    public g g(Bundle bundle) {
        this.f40698g.D(bundle);
        return this;
    }

    public final void h(d.a.l0.a.v2.e1.b<f> bVar) {
        d.a.l0.a.v2.e1.a.c(bVar, this.f40697f.values());
    }

    public synchronized g i(ReadableByteChannel readableByteChannel) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f40699h.b();
        d.a.l0.a.v2.c1.a aVar = new d.a.l0.a.v2.c1.a();
        aVar.o(32768);
        aVar.q(30L, TimeUnit.SECONDS);
        aVar.g(this.f40698g.C());
        aVar.p(new b(aVar));
        h(new c(this, aVar));
        k("connect: " + readableByteChannel + " at: " + currentTimeMillis);
        aVar.h(readableByteChannel);
        boolean j = j();
        if (f40696i) {
            k("allOk: " + j + " cost: " + (System.currentTimeMillis() - currentTimeMillis));
        }
        if (!j) {
            h(new d(this));
        }
        return this;
    }

    public boolean j() {
        if (this.f40697f.isEmpty() || this.f40699h.e("flag_is_ok", false)) {
            return true;
        }
        boolean[] zArr = {true};
        h(new e(this, zArr));
        this.f40699h.s("flag_is_ok", zArr[0]);
        return zArr[0];
    }

    public final void k(String str) {
        if (f40696i) {
            d.a.l0.a.f1.g.a.d(this.f40698g.o("launch_id", "")).f(str).b("SwanInstaller");
            Log.i("SwanInstaller", str);
        }
    }
}
