package d.a.l0.a.h0.o.h.d;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.clientupdate.download.DownloadManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.core.prefetch.image.config.image.SystemStrategyImpl;
import d.a.l0.t.d;
import java.io.File;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.a.h0.o.h.d.c.a f42453a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.l0.a.h0.o.h.d.b.a f42454b;

    /* renamed from: c  reason: collision with root package name */
    public File f42455c;

    /* renamed from: d  reason: collision with root package name */
    public long f42456d;

    /* renamed from: e  reason: collision with root package name */
    public int f42457e;

    /* renamed from: f  reason: collision with root package name */
    public int f42458f;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public d.a.l0.a.h0.o.h.d.c.a f42459a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.l0.a.h0.o.h.d.b.a f42460b;

        /* renamed from: c  reason: collision with root package name */
        public File f42461c;

        /* renamed from: d  reason: collision with root package name */
        public long f42462d;

        /* renamed from: e  reason: collision with root package name */
        public int f42463e = 0;

        /* renamed from: f  reason: collision with root package name */
        public int f42464f = 0;

        public b g(d.a.l0.a.h0.o.h.d.c.a aVar) {
            this.f42459a = aVar;
            return this;
        }

        public b h(d.a.l0.a.h0.o.h.d.b.a aVar) {
            this.f42460b = aVar;
            return this;
        }

        public b i(long j) {
            this.f42462d = j;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final a f42465a = new a();
    }

    public static a a() {
        return c.f42465a;
    }

    public static String c() {
        return AppRuntime.getAppContext().getExternalCacheDir() + File.separator + "swan_hybrid";
    }

    public File b() {
        if (this.f42455c == null) {
            String m = d.m();
            if (TextUtils.isEmpty(m)) {
                return null;
            }
            this.f42455c = new File(m, "swan_hybrid");
        }
        return this.f42455c;
    }

    public d.a.l0.a.h0.o.h.d.c.a d() {
        if (this.f42453a == null) {
            this.f42453a = new d.a.l0.a.h0.o.h.d.c.b();
        }
        return this.f42453a;
    }

    public int e() {
        if (this.f42457e <= 0) {
            this.f42457e = 60000;
        }
        return this.f42457e;
    }

    public d.a.l0.a.h0.o.h.d.b.a f() {
        if (this.f42454b == null) {
            this.f42454b = new SystemStrategyImpl();
        }
        return this.f42454b;
    }

    public long g() {
        if (this.f42456d <= 0) {
            this.f42456d = DownloadManager.MIN_LEFT_SIZE;
        }
        return this.f42456d;
    }

    public int h() {
        if (this.f42458f <= 0) {
            this.f42458f = 60000;
        }
        return this.f42458f;
    }

    public void i(b bVar) {
        if (bVar == null) {
            return;
        }
        this.f42453a = bVar.f42459a;
        this.f42454b = bVar.f42460b;
        this.f42455c = bVar.f42461c;
        this.f42456d = bVar.f42462d;
        this.f42457e = bVar.f42463e;
        this.f42458f = bVar.f42464f;
        if (d.a.l0.a.h0.o.h.e.a.f42466a) {
            Log.d("HybridIntercept", toString());
        }
    }

    @NonNull
    public String toString() {
        return "SwanHybridInterceptConfig{CacheKeyProvider=" + this.f42453a + ", InterceptStrategy=" + this.f42454b + ", CacheFolder=" + this.f42455c + ", MaxCacheSize=" + (this.f42456d / 1048576) + "MB, ConnectTimeout=" + this.f42457e + ", ReadTimeout=" + this.f42458f + '}';
    }

    public a() {
    }
}
