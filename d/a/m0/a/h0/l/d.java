package d.a.m0.a.h0.l;

import android.app.Activity;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import d.a.m0.a.k;
import d.a.m0.a.l0.g;
import d.a.m0.a.l0.j;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f46000d = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.a.l0.a f46001a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.a.y.a f46002b = new d.a.m0.a.y.a();

    /* renamed from: c  reason: collision with root package name */
    public j f46003c;

    /* loaded from: classes3.dex */
    public class a extends d.a.m0.a.l0.n.a {

        /* renamed from: a  reason: collision with root package name */
        public String f46004a;

        /* renamed from: b  reason: collision with root package name */
        public String f46005b;

        public a(@NonNull String str, @NonNull String str2) {
            this.f46004a = str;
            this.f46005b = str2;
            if (d.f46000d) {
                Log.d("SwanAppV8Master", "basePath: " + str + ", jsFile: " + str2);
            }
        }

        @Override // d.a.m0.a.l0.n.b
        public String a() {
            return this.f46005b;
        }

        @Override // d.a.m0.a.l0.n.a, d.a.m0.a.l0.n.b
        @Nullable
        public V8EngineConfiguration.CodeCacheSetting b() {
            if (d.f46000d) {
                Log.d("SwanAppV8Master", "pathList item: " + this.f46004a);
            }
            return d.a.m0.a.h0.d.a.a("appframe", this.f46004a);
        }

        @Override // d.a.m0.a.l0.n.a, d.a.m0.a.l0.n.b
        public void c(d.a.m0.a.l0.a aVar) {
            if (d.this.f46003c != null) {
                d.this.f46003c.a(aVar);
            }
            aVar.y0();
        }

        @Override // d.a.m0.a.l0.n.a, d.a.m0.a.l0.n.b
        public void d(d.a.m0.a.l0.a aVar) {
            d.this.f46002b.b(aVar, d.a.m0.a.c1.a.b());
        }

        @Override // d.a.m0.a.l0.n.b
        public String getInitBasePath() {
            return this.f46004a;
        }
    }

    public d(@NonNull String str, @NonNull String str2) {
        this.f46001a = d.a.m0.a.l0.f.c(e(), new a(str, str2), d.a.m0.a.r1.l.e.m() ? new f() : null);
    }

    public void d(Activity activity) {
        this.f46002b.a(activity);
    }

    public g e() {
        g.b bVar = new g.b();
        bVar.c(1);
        bVar.b(d.a.m0.a.h0.l.g.e.b());
        return bVar.a();
    }

    public void f() {
        this.f46001a.k0();
    }

    public String g() {
        return this.f46001a.f47079g;
    }

    public d.a.m0.a.l0.a h() {
        return this.f46001a;
    }

    public void i(V8EngineConfiguration.JSCacheCallback jSCacheCallback) {
        this.f46001a.B0(jSCacheCallback);
    }

    public void j(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        this.f46001a.C0(codeCacheSetting);
    }

    public void k(j jVar) {
        this.f46003c = jVar;
    }
}
