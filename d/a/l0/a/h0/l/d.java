package d.a.l0.a.h0.l;

import android.app.Activity;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import d.a.l0.a.k;
import d.a.l0.a.l0.g;
import d.a.l0.a.l0.j;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f45892d = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.a.l0.a f45893a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.l0.a.y.a f45894b = new d.a.l0.a.y.a();

    /* renamed from: c  reason: collision with root package name */
    public j f45895c;

    /* loaded from: classes2.dex */
    public class a extends d.a.l0.a.l0.n.a {

        /* renamed from: a  reason: collision with root package name */
        public String f45896a;

        /* renamed from: b  reason: collision with root package name */
        public String f45897b;

        public a(@NonNull String str, @NonNull String str2) {
            this.f45896a = str;
            this.f45897b = str2;
            if (d.f45892d) {
                Log.d("SwanAppV8Master", "basePath: " + str + ", jsFile: " + str2);
            }
        }

        @Override // d.a.l0.a.l0.n.b
        public String a() {
            return this.f45897b;
        }

        @Override // d.a.l0.a.l0.n.a, d.a.l0.a.l0.n.b
        @Nullable
        public V8EngineConfiguration.CodeCacheSetting b() {
            if (d.f45892d) {
                Log.d("SwanAppV8Master", "pathList item: " + this.f45896a);
            }
            return d.a.l0.a.h0.d.a.a("appframe", this.f45896a);
        }

        @Override // d.a.l0.a.l0.n.a, d.a.l0.a.l0.n.b
        public void c(d.a.l0.a.l0.a aVar) {
            if (d.this.f45895c != null) {
                d.this.f45895c.a(aVar);
            }
            aVar.y0();
        }

        @Override // d.a.l0.a.l0.n.a, d.a.l0.a.l0.n.b
        public void d(d.a.l0.a.l0.a aVar) {
            d.this.f45894b.b(aVar, d.a.l0.a.c1.a.b());
        }

        @Override // d.a.l0.a.l0.n.b
        public String getInitBasePath() {
            return this.f45896a;
        }
    }

    public d(@NonNull String str, @NonNull String str2) {
        this.f45893a = d.a.l0.a.l0.f.c(e(), new a(str, str2), d.a.l0.a.r1.l.e.m() ? new f() : null);
    }

    public void d(Activity activity) {
        this.f45894b.a(activity);
    }

    public g e() {
        g.b bVar = new g.b();
        bVar.c(1);
        bVar.b(d.a.l0.a.h0.l.g.e.b());
        return bVar.a();
    }

    public void f() {
        this.f45893a.k0();
    }

    public String g() {
        return this.f45893a.f46971g;
    }

    public d.a.l0.a.l0.a h() {
        return this.f45893a;
    }

    public void i(V8EngineConfiguration.JSCacheCallback jSCacheCallback) {
        this.f45893a.B0(jSCacheCallback);
    }

    public void j(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        this.f45893a.C0(codeCacheSetting);
    }

    public void k(j jVar) {
        this.f45895c = jVar;
    }
}
