package d.a.m0.a.h0.k;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.swan.apps.jsbridge.SwanAppJsBridge;
import d.a.m0.a.k;
import d.a.m0.a.l0.g;
import d.a.m0.a.l0.j;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f45992c = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.a.l0.a f45993a;

    /* renamed from: b  reason: collision with root package name */
    public j f45994b;

    /* loaded from: classes3.dex */
    public class a extends d.a.m0.a.l0.n.a {

        /* renamed from: a  reason: collision with root package name */
        public String f45995a;

        /* renamed from: b  reason: collision with root package name */
        public String f45996b;

        public a(@NonNull String str, @NonNull String str2) {
            this.f45995a = str;
            this.f45996b = str2;
            if (c.f45992c) {
                Log.d("SwanAppV8Daemon", "basePath: " + str + ", jsFile: " + str2);
            }
        }

        @Override // d.a.m0.a.l0.n.b
        public String a() {
            return this.f45996b;
        }

        @Override // d.a.m0.a.l0.n.a, d.a.m0.a.l0.n.b
        @Nullable
        public V8EngineConfiguration.CodeCacheSetting b() {
            return super.b();
        }

        @Override // d.a.m0.a.l0.n.a, d.a.m0.a.l0.n.b
        public void c(d.a.m0.a.l0.a aVar) {
            if (c.this.f45994b != null) {
                c.this.f45994b.a(aVar);
            }
            aVar.y0();
        }

        @Override // d.a.m0.a.l0.n.a, d.a.m0.a.l0.n.b
        public void d(d.a.m0.a.l0.a aVar) {
            super.d(aVar);
        }

        @Override // d.a.m0.a.l0.n.b
        public String getInitBasePath() {
            return this.f45995a;
        }
    }

    public c(@NonNull String str, @NonNull String str2) {
        this.f45993a = d.a.m0.a.l0.f.c(c(), new a(str, str2), null);
        this.f45993a.addJavascriptInterface(new b(this.f45993a), SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
    }

    public final g c() {
        g.b bVar = new g.b();
        bVar.c(3);
        bVar.b(d.a.m0.a.h0.k.a.b());
        return bVar.a();
    }

    public d.a.m0.a.l0.a d() {
        return this.f45993a;
    }

    public void e() {
        d.a.m0.a.l0.a aVar = this.f45993a;
        if (aVar != null) {
            aVar.k0();
            this.f45993a = null;
        }
        this.f45994b = null;
    }

    public void f(j jVar) {
        this.f45994b = jVar;
    }
}
