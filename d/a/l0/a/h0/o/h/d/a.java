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
    public d.a.l0.a.h0.o.h.d.c.a f46129a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.l0.a.h0.o.h.d.b.a f46130b;

    /* renamed from: c  reason: collision with root package name */
    public File f46131c;

    /* renamed from: d  reason: collision with root package name */
    public long f46132d;

    /* renamed from: e  reason: collision with root package name */
    public int f46133e;

    /* renamed from: f  reason: collision with root package name */
    public int f46134f;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public d.a.l0.a.h0.o.h.d.c.a f46135a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.l0.a.h0.o.h.d.b.a f46136b;

        /* renamed from: c  reason: collision with root package name */
        public File f46137c;

        /* renamed from: d  reason: collision with root package name */
        public long f46138d;

        /* renamed from: e  reason: collision with root package name */
        public int f46139e = 0;

        /* renamed from: f  reason: collision with root package name */
        public int f46140f = 0;

        public b g(d.a.l0.a.h0.o.h.d.c.a aVar) {
            this.f46135a = aVar;
            return this;
        }

        public b h(d.a.l0.a.h0.o.h.d.b.a aVar) {
            this.f46136b = aVar;
            return this;
        }

        public b i(long j) {
            this.f46138d = j;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final a f46141a = new a();
    }

    public static a a() {
        return c.f46141a;
    }

    public static String c() {
        return AppRuntime.getAppContext().getExternalCacheDir() + File.separator + "swan_hybrid";
    }

    public File b() {
        if (this.f46131c == null) {
            String m = d.m();
            if (TextUtils.isEmpty(m)) {
                return null;
            }
            this.f46131c = new File(m, "swan_hybrid");
        }
        return this.f46131c;
    }

    public d.a.l0.a.h0.o.h.d.c.a d() {
        if (this.f46129a == null) {
            this.f46129a = new d.a.l0.a.h0.o.h.d.c.b();
        }
        return this.f46129a;
    }

    public int e() {
        if (this.f46133e <= 0) {
            this.f46133e = 60000;
        }
        return this.f46133e;
    }

    public d.a.l0.a.h0.o.h.d.b.a f() {
        if (this.f46130b == null) {
            this.f46130b = new SystemStrategyImpl();
        }
        return this.f46130b;
    }

    public long g() {
        if (this.f46132d <= 0) {
            this.f46132d = DownloadManager.MIN_LEFT_SIZE;
        }
        return this.f46132d;
    }

    public int h() {
        if (this.f46134f <= 0) {
            this.f46134f = 60000;
        }
        return this.f46134f;
    }

    public void i(b bVar) {
        if (bVar == null) {
            return;
        }
        this.f46129a = bVar.f46135a;
        this.f46130b = bVar.f46136b;
        this.f46131c = bVar.f46137c;
        this.f46132d = bVar.f46138d;
        this.f46133e = bVar.f46139e;
        this.f46134f = bVar.f46140f;
        if (d.a.l0.a.h0.o.h.e.a.f46142a) {
            Log.d("HybridIntercept", toString());
        }
    }

    @NonNull
    public String toString() {
        return "SwanHybridInterceptConfig{CacheKeyProvider=" + this.f46129a + ", InterceptStrategy=" + this.f46130b + ", CacheFolder=" + this.f46131c + ", MaxCacheSize=" + (this.f46132d / 1048576) + "MB, ConnectTimeout=" + this.f46133e + ", ReadTimeout=" + this.f46134f + '}';
    }

    public a() {
    }
}
