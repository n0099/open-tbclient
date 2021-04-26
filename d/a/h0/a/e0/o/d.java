package d.a.h0.a.e0.o;

import android.app.Activity;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import d.a.h0.a.k;
import d.a.h0.g.i.g;
import d.a.h0.g.i.h;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f42119d = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.h0.g.i.a f42120a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.h0.g.e.a f42121b = new d.a.h0.g.e.a();

    /* renamed from: c  reason: collision with root package name */
    public b f42122c;

    /* loaded from: classes2.dex */
    public class a extends d.a.h0.g.i.n.a {

        /* renamed from: a  reason: collision with root package name */
        public String f42123a;

        /* renamed from: b  reason: collision with root package name */
        public String f42124b;

        public a(@NonNull String str, @NonNull String str2) {
            this.f42123a = str;
            this.f42124b = str2;
            if (d.f42119d) {
                Log.d("SwanAppV8Master", "basePath: " + str + ", jsFile: " + str2);
            }
        }

        @Override // d.a.h0.g.i.n.b
        public String a() {
            return this.f42124b;
        }

        @Override // d.a.h0.g.i.n.a, d.a.h0.g.i.n.b
        @Nullable
        public V8EngineConfiguration.CodeCacheSetting b() {
            if (d.a.h0.a.w0.a.N().u(0)) {
                if (d.f42119d) {
                    Log.d("SwanAppV8Master", "pathList item: " + this.f42123a);
                }
                return d.a.h0.a.e0.i.a.a("appframe", this.f42123a);
            }
            return null;
        }

        @Override // d.a.h0.g.i.n.a, d.a.h0.g.i.n.b
        public void c(d.a.h0.g.i.a aVar) {
            d.this.f42121b.b(aVar, d.a.h0.a.w0.a.c());
        }

        @Override // d.a.h0.g.i.n.a, d.a.h0.g.i.n.b
        public void d(d.a.h0.g.i.a aVar) {
            if (d.this.f42122c != null) {
                d.this.f42122c.a(aVar);
            }
            aVar.u0();
        }

        @Override // d.a.h0.g.i.n.b
        public String getInitBasePath() {
            return this.f42123a;
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(d.a.h0.g.i.a aVar);
    }

    public d(@NonNull String str, @NonNull String str2) {
        this.f42120a = g.c(e(), new a(str, str2), null);
    }

    public void d(Activity activity) {
        this.f42121b.a(activity);
    }

    public final h e() {
        h.b bVar = new h.b();
        bVar.c(1);
        bVar.b(d.a.h0.a.e0.o.f.a.b());
        return bVar.a();
    }

    public void f() {
        this.f42120a.h0();
    }

    public String g() {
        return this.f42120a.f46356g;
    }

    public d.a.h0.g.i.a h() {
        return this.f42120a;
    }

    public void i(V8EngineConfiguration.JSCacheCallback jSCacheCallback) {
        this.f42120a.w0(jSCacheCallback);
    }

    public void j(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        this.f42120a.x0(codeCacheSetting);
    }

    public void k(b bVar) {
        this.f42122c = bVar;
    }
}
