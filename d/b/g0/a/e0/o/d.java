package d.b.g0.a.e0.o;

import android.app.Activity;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import d.b.g0.a.k;
import d.b.g0.g.i.g;
import d.b.g0.g.i.h;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f44099d = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.g.i.a f44100a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.g0.g.e.a f44101b = new d.b.g0.g.e.a();

    /* renamed from: c  reason: collision with root package name */
    public b f44102c;

    /* loaded from: classes2.dex */
    public class a extends d.b.g0.g.i.n.a {

        /* renamed from: a  reason: collision with root package name */
        public String f44103a;

        /* renamed from: b  reason: collision with root package name */
        public String f44104b;

        public a(@NonNull String str, @NonNull String str2) {
            this.f44103a = str;
            this.f44104b = str2;
            if (d.f44099d) {
                Log.d("SwanAppV8Master", "basePath: " + str + ", jsFile: " + str2);
            }
        }

        @Override // d.b.g0.g.i.n.b
        public String a() {
            return this.f44104b;
        }

        @Override // d.b.g0.g.i.n.a, d.b.g0.g.i.n.b
        @Nullable
        public V8EngineConfiguration.CodeCacheSetting b() {
            if (d.b.g0.a.w0.a.N().G(0)) {
                if (d.f44099d) {
                    Log.d("SwanAppV8Master", "pathList item: " + this.f44103a);
                }
                return d.b.g0.a.e0.i.a.a("appframe", this.f44103a);
            }
            return null;
        }

        @Override // d.b.g0.g.i.n.a, d.b.g0.g.i.n.b
        public void c(d.b.g0.g.i.a aVar) {
            if (d.this.f44102c != null) {
                d.this.f44102c.a(aVar);
            }
            aVar.t0();
        }

        @Override // d.b.g0.g.i.n.a, d.b.g0.g.i.n.b
        public void d(d.b.g0.g.i.a aVar) {
            d.this.f44101b.b(aVar, d.b.g0.a.w0.a.c());
        }

        @Override // d.b.g0.g.i.n.b
        public String getInitBasePath() {
            return this.f44103a;
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(d.b.g0.g.i.a aVar);
    }

    public d(@NonNull String str, @NonNull String str2) {
        this.f44100a = g.c(e(), new a(str, str2), null);
    }

    public void d(Activity activity) {
        this.f44101b.a(activity);
    }

    public final h e() {
        h.b bVar = new h.b();
        bVar.c(1);
        bVar.b(d.b.g0.a.e0.o.f.a.b());
        return bVar.a();
    }

    public void f() {
        this.f44100a.g0();
    }

    public String g() {
        return this.f44100a.f48162g;
    }

    public d.b.g0.g.i.a h() {
        return this.f44100a;
    }

    public void i(V8EngineConfiguration.JSCacheCallback jSCacheCallback) {
        this.f44100a.v0(jSCacheCallback);
    }

    public void j(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        this.f44100a.w0(codeCacheSetting);
    }

    public void k(b bVar) {
        this.f44102c = bVar;
    }
}
