package d.a.l0.a.h0.k;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.swan.apps.jsbridge.SwanAppJsBridge;
import d.a.l0.a.k;
import d.a.l0.a.l0.g;
import d.a.l0.a.l0.j;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f45884c = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.a.l0.a f45885a;

    /* renamed from: b  reason: collision with root package name */
    public j f45886b;

    /* loaded from: classes2.dex */
    public class a extends d.a.l0.a.l0.n.a {

        /* renamed from: a  reason: collision with root package name */
        public String f45887a;

        /* renamed from: b  reason: collision with root package name */
        public String f45888b;

        public a(@NonNull String str, @NonNull String str2) {
            this.f45887a = str;
            this.f45888b = str2;
            if (c.f45884c) {
                Log.d("SwanAppV8Daemon", "basePath: " + str + ", jsFile: " + str2);
            }
        }

        @Override // d.a.l0.a.l0.n.b
        public String a() {
            return this.f45888b;
        }

        @Override // d.a.l0.a.l0.n.a, d.a.l0.a.l0.n.b
        @Nullable
        public V8EngineConfiguration.CodeCacheSetting b() {
            return super.b();
        }

        @Override // d.a.l0.a.l0.n.a, d.a.l0.a.l0.n.b
        public void c(d.a.l0.a.l0.a aVar) {
            if (c.this.f45886b != null) {
                c.this.f45886b.a(aVar);
            }
            aVar.y0();
        }

        @Override // d.a.l0.a.l0.n.a, d.a.l0.a.l0.n.b
        public void d(d.a.l0.a.l0.a aVar) {
            super.d(aVar);
        }

        @Override // d.a.l0.a.l0.n.b
        public String getInitBasePath() {
            return this.f45887a;
        }
    }

    public c(@NonNull String str, @NonNull String str2) {
        this.f45885a = d.a.l0.a.l0.f.c(c(), new a(str, str2), null);
        this.f45885a.addJavascriptInterface(new b(this.f45885a), SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
    }

    public final g c() {
        g.b bVar = new g.b();
        bVar.c(3);
        bVar.b(d.a.l0.a.h0.k.a.b());
        return bVar.a();
    }

    public d.a.l0.a.l0.a d() {
        return this.f45885a;
    }

    public void e() {
        d.a.l0.a.l0.a aVar = this.f45885a;
        if (aVar != null) {
            aVar.k0();
            this.f45885a = null;
        }
        this.f45886b = null;
    }

    public void f(j jVar) {
        this.f45886b = jVar;
    }
}
