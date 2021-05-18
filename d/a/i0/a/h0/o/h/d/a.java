package d.a.i0.a.h0.o.h.d;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.clientupdate.download.DownloadManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.core.prefetch.image.config.image.SystemStrategyImpl;
import d.a.i0.t.d;
import java.io.File;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.i0.a.h0.o.h.d.c.a f42279a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.a.h0.o.h.d.b.a f42280b;

    /* renamed from: c  reason: collision with root package name */
    public File f42281c;

    /* renamed from: d  reason: collision with root package name */
    public long f42282d;

    /* renamed from: e  reason: collision with root package name */
    public int f42283e;

    /* renamed from: f  reason: collision with root package name */
    public int f42284f;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public d.a.i0.a.h0.o.h.d.c.a f42285a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.i0.a.h0.o.h.d.b.a f42286b;

        /* renamed from: c  reason: collision with root package name */
        public File f42287c;

        /* renamed from: d  reason: collision with root package name */
        public long f42288d;

        /* renamed from: e  reason: collision with root package name */
        public int f42289e = 0;

        /* renamed from: f  reason: collision with root package name */
        public int f42290f = 0;

        public b g(d.a.i0.a.h0.o.h.d.c.a aVar) {
            this.f42285a = aVar;
            return this;
        }

        public b h(d.a.i0.a.h0.o.h.d.b.a aVar) {
            this.f42286b = aVar;
            return this;
        }

        public b i(long j) {
            this.f42288d = j;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final a f42291a = new a();
    }

    public static a a() {
        return c.f42291a;
    }

    public static String c() {
        return AppRuntime.getAppContext().getExternalCacheDir() + File.separator + "swan_hybrid";
    }

    public File b() {
        if (this.f42281c == null) {
            String m = d.m();
            if (TextUtils.isEmpty(m)) {
                return null;
            }
            this.f42281c = new File(m, "swan_hybrid");
        }
        return this.f42281c;
    }

    public d.a.i0.a.h0.o.h.d.c.a d() {
        if (this.f42279a == null) {
            this.f42279a = new d.a.i0.a.h0.o.h.d.c.b();
        }
        return this.f42279a;
    }

    public int e() {
        if (this.f42283e <= 0) {
            this.f42283e = 60000;
        }
        return this.f42283e;
    }

    public d.a.i0.a.h0.o.h.d.b.a f() {
        if (this.f42280b == null) {
            this.f42280b = new SystemStrategyImpl();
        }
        return this.f42280b;
    }

    public long g() {
        if (this.f42282d <= 0) {
            this.f42282d = DownloadManager.MIN_LEFT_SIZE;
        }
        return this.f42282d;
    }

    public int h() {
        if (this.f42284f <= 0) {
            this.f42284f = 60000;
        }
        return this.f42284f;
    }

    public void i(b bVar) {
        if (bVar == null) {
            return;
        }
        this.f42279a = bVar.f42285a;
        this.f42280b = bVar.f42286b;
        this.f42281c = bVar.f42287c;
        this.f42282d = bVar.f42288d;
        this.f42283e = bVar.f42289e;
        this.f42284f = bVar.f42290f;
        if (d.a.i0.a.h0.o.h.e.a.f42292a) {
            Log.d("HybridIntercept", toString());
        }
    }

    @NonNull
    public String toString() {
        return "SwanHybridInterceptConfig{CacheKeyProvider=" + this.f42279a + ", InterceptStrategy=" + this.f42280b + ", CacheFolder=" + this.f42281c + ", MaxCacheSize=" + (this.f42282d / 1048576) + "MB, ConnectTimeout=" + this.f42283e + ", ReadTimeout=" + this.f42284f + '}';
    }

    public a() {
    }
}
