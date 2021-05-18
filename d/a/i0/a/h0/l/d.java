package d.a.i0.a.h0.l;

import android.app.Activity;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import d.a.i0.a.k;
import d.a.i0.a.l0.g;
import d.a.i0.a.l0.j;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f42042d = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.i0.a.l0.a f42043a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.a.y.a f42044b = new d.a.i0.a.y.a();

    /* renamed from: c  reason: collision with root package name */
    public j f42045c;

    /* loaded from: classes2.dex */
    public class a extends d.a.i0.a.l0.n.a {

        /* renamed from: a  reason: collision with root package name */
        public String f42046a;

        /* renamed from: b  reason: collision with root package name */
        public String f42047b;

        public a(@NonNull String str, @NonNull String str2) {
            this.f42046a = str;
            this.f42047b = str2;
            if (d.f42042d) {
                Log.d("SwanAppV8Master", "basePath: " + str + ", jsFile: " + str2);
            }
        }

        @Override // d.a.i0.a.l0.n.b
        public String a() {
            return this.f42047b;
        }

        @Override // d.a.i0.a.l0.n.a, d.a.i0.a.l0.n.b
        @Nullable
        public V8EngineConfiguration.CodeCacheSetting b() {
            if (d.f42042d) {
                Log.d("SwanAppV8Master", "pathList item: " + this.f42046a);
            }
            return d.a.i0.a.h0.d.a.a("appframe", this.f42046a);
        }

        @Override // d.a.i0.a.l0.n.a, d.a.i0.a.l0.n.b
        public void c(d.a.i0.a.l0.a aVar) {
            if (d.this.f42045c != null) {
                d.this.f42045c.a(aVar);
            }
            aVar.y0();
        }

        @Override // d.a.i0.a.l0.n.a, d.a.i0.a.l0.n.b
        public void d(d.a.i0.a.l0.a aVar) {
            d.this.f42044b.b(aVar, d.a.i0.a.c1.a.b());
        }

        @Override // d.a.i0.a.l0.n.b
        public String getInitBasePath() {
            return this.f42046a;
        }
    }

    public d(@NonNull String str, @NonNull String str2) {
        this.f42043a = d.a.i0.a.l0.f.c(e(), new a(str, str2), d.a.i0.a.r1.l.e.m() ? new f() : null);
    }

    public void d(Activity activity) {
        this.f42044b.a(activity);
    }

    public g e() {
        g.b bVar = new g.b();
        bVar.c(1);
        bVar.b(d.a.i0.a.h0.l.g.e.b());
        return bVar.a();
    }

    public void f() {
        this.f42043a.k0();
    }

    public String g() {
        return this.f42043a.f43121g;
    }

    public d.a.i0.a.l0.a h() {
        return this.f42043a;
    }

    public void i(V8EngineConfiguration.JSCacheCallback jSCacheCallback) {
        this.f42043a.B0(jSCacheCallback);
    }

    public void j(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        this.f42043a.C0(codeCacheSetting);
    }

    public void k(j jVar) {
        this.f42045c = jVar;
    }
}
