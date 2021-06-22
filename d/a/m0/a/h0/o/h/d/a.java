package d.a.m0.a.h0.o.h.d;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.clientupdate.download.DownloadManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.core.prefetch.image.config.image.SystemStrategyImpl;
import d.a.m0.t.d;
import java.io.File;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.a.h0.o.h.d.c.a f46237a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.a.h0.o.h.d.b.a f46238b;

    /* renamed from: c  reason: collision with root package name */
    public File f46239c;

    /* renamed from: d  reason: collision with root package name */
    public long f46240d;

    /* renamed from: e  reason: collision with root package name */
    public int f46241e;

    /* renamed from: f  reason: collision with root package name */
    public int f46242f;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public d.a.m0.a.h0.o.h.d.c.a f46243a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.m0.a.h0.o.h.d.b.a f46244b;

        /* renamed from: c  reason: collision with root package name */
        public File f46245c;

        /* renamed from: d  reason: collision with root package name */
        public long f46246d;

        /* renamed from: e  reason: collision with root package name */
        public int f46247e = 0;

        /* renamed from: f  reason: collision with root package name */
        public int f46248f = 0;

        public b g(d.a.m0.a.h0.o.h.d.c.a aVar) {
            this.f46243a = aVar;
            return this;
        }

        public b h(d.a.m0.a.h0.o.h.d.b.a aVar) {
            this.f46244b = aVar;
            return this;
        }

        public b i(long j) {
            this.f46246d = j;
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final a f46249a = new a();
    }

    public static a a() {
        return c.f46249a;
    }

    public static String c() {
        return AppRuntime.getAppContext().getExternalCacheDir() + File.separator + "swan_hybrid";
    }

    public File b() {
        if (this.f46239c == null) {
            String m = d.m();
            if (TextUtils.isEmpty(m)) {
                return null;
            }
            this.f46239c = new File(m, "swan_hybrid");
        }
        return this.f46239c;
    }

    public d.a.m0.a.h0.o.h.d.c.a d() {
        if (this.f46237a == null) {
            this.f46237a = new d.a.m0.a.h0.o.h.d.c.b();
        }
        return this.f46237a;
    }

    public int e() {
        if (this.f46241e <= 0) {
            this.f46241e = 60000;
        }
        return this.f46241e;
    }

    public d.a.m0.a.h0.o.h.d.b.a f() {
        if (this.f46238b == null) {
            this.f46238b = new SystemStrategyImpl();
        }
        return this.f46238b;
    }

    public long g() {
        if (this.f46240d <= 0) {
            this.f46240d = DownloadManager.MIN_LEFT_SIZE;
        }
        return this.f46240d;
    }

    public int h() {
        if (this.f46242f <= 0) {
            this.f46242f = 60000;
        }
        return this.f46242f;
    }

    public void i(b bVar) {
        if (bVar == null) {
            return;
        }
        this.f46237a = bVar.f46243a;
        this.f46238b = bVar.f46244b;
        this.f46239c = bVar.f46245c;
        this.f46240d = bVar.f46246d;
        this.f46241e = bVar.f46247e;
        this.f46242f = bVar.f46248f;
        if (d.a.m0.a.h0.o.h.e.a.f46250a) {
            Log.d("HybridIntercept", toString());
        }
    }

    @NonNull
    public String toString() {
        return "SwanHybridInterceptConfig{CacheKeyProvider=" + this.f46237a + ", InterceptStrategy=" + this.f46238b + ", CacheFolder=" + this.f46239c + ", MaxCacheSize=" + (this.f46240d / 1048576) + "MB, ConnectTimeout=" + this.f46241e + ", ReadTimeout=" + this.f46242f + '}';
    }

    public a() {
    }
}
