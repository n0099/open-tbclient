package d.a.l0.n.i.i.g;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class c<T> implements d.a.l0.n.f.c<T> {

    /* renamed from: e  reason: collision with root package name */
    public d.a.l0.n.f.c<T> f48048e;

    /* renamed from: f  reason: collision with root package name */
    public int f48049f = 0;

    public c(d.a.l0.n.f.c<T> cVar) {
        this.f48048e = cVar;
    }

    @Override // d.a.l0.n.f.c
    public void a(T t) {
        d.a.l0.n.f.c<T> cVar = this.f48048e;
        if (cVar != null) {
            try {
                cVar.a(t);
            } catch (Exception e2) {
                if (d.a.l0.n.c.f47984a) {
                    Log.e("PMSDownStreamGuard", g() + ": Except onDownloadProgress t=" + t.toString());
                    Log.e("PMSDownStreamGuard", g() + ": Except onDownloadProgress e=" + Log.getStackTraceString(e2));
                    throw e2;
                }
            }
        }
    }

    @Override // d.a.l0.n.f.c
    public void c(T t) {
        d.a.l0.n.f.c<T> cVar = this.f48048e;
        if (cVar != null) {
            try {
                cVar.c(t);
            } catch (Exception e2) {
                if (d.a.l0.n.c.f47984a) {
                    Log.e("PMSDownStreamGuard", g() + ": Except onDownloadStart t=" + t.toString());
                    Log.e("PMSDownStreamGuard", g() + ": Except onDownloadStart e=" + Log.getStackTraceString(e2));
                    throw e2;
                }
            }
        }
    }

    @Override // d.a.l0.n.f.c
    public String d(T t) {
        d.a.l0.n.f.c<T> cVar = this.f48048e;
        String d2 = cVar != null ? cVar.d(t) : null;
        if (d.a.l0.n.c.f47984a) {
            Log.d("PMSDownStreamGuard", g() + ": getDownloadPath:" + d2);
        }
        if (d2 == null) {
            try {
                d2 = d.a.l0.n.o.d.c(AppRuntime.getAppContext()).getAbsolutePath();
            } catch (Exception e2) {
                if (d.a.l0.n.c.f47984a) {
                    Log.e("PMSDownStreamGuard", g() + ": getDownloadPath error: e=" + Log.getStackTraceString(e2));
                    throw e2;
                }
            }
            if (d.a.l0.n.c.f47984a) {
                Log.d("PMSDownStreamGuard", g() + ": getDownloadPath failed, using default path:" + d2);
            }
        }
        return d2;
    }

    @Override // d.a.l0.n.f.c
    public void e(T t, d.a.l0.n.h.a aVar) {
        d.a.l0.n.f.c<T> cVar = this.f48048e;
        if (cVar != null) {
            try {
                cVar.e(t, aVar);
            } catch (Exception e2) {
                if (d.a.l0.n.c.f47984a) {
                    Log.e("PMSDownStreamGuard", g() + ": notify onDownloadError t=" + t.toString());
                    Log.e("PMSDownStreamGuard", g() + ": notify onDownloadError e=" + Log.getStackTraceString(e2));
                    throw e2;
                }
            }
        }
    }

    @Override // d.a.l0.n.f.c
    public void f(T t) {
        d.a.l0.n.f.c<T> cVar = this.f48048e;
        if (cVar != null) {
            try {
                cVar.f(t);
            } catch (Exception e2) {
                if (d.a.l0.n.c.f47984a) {
                    Log.e("PMSDownStreamGuard", g() + ": Except onDownloading t=" + t.toString());
                    Log.e("PMSDownStreamGuard", g() + ": Except onDownloading e=" + Log.getStackTraceString(e2));
                    throw e2;
                }
            }
        }
    }

    public final String g() {
        return d.a.l0.n.c.b().v();
    }

    @Override // d.a.l0.n.f.c
    public d.a.l0.n.h.a h(T t, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
        d.a.l0.n.f.c<T> cVar = this.f48048e;
        if (cVar != null) {
            return cVar.h(t, file, j, readableByteChannel);
        }
        return new d.a.l0.n.h.a(2302, "业务层默认不处理下载流");
    }

    @Override // d.a.l0.n.f.c
    public void i(T t) {
        d.a.l0.n.f.c<T> cVar = this.f48048e;
        if (cVar != null) {
            try {
                cVar.i(t);
            } catch (Exception e2) {
                if (d.a.l0.n.c.f47984a) {
                    Log.e("PMSDownStreamGuard", g() + ": Except onDownloadFinish: t=" + t.toString());
                    Log.e("PMSDownStreamGuard", g() + ": Except onDownloadFinish: cb=" + this.f48048e);
                    Log.e("PMSDownStreamGuard", g() + ": Except onDownloadFinish: e=" + Log.getStackTraceString(e2));
                    throw e2;
                }
            }
        }
    }

    @Override // d.a.l0.n.f.c
    public void j(T t) {
        d.a.l0.n.f.c<T> cVar = this.f48048e;
        if (cVar != null) {
            try {
                cVar.j(t);
            } catch (Exception e2) {
                if (d.a.l0.n.c.f47984a) {
                    Log.e("PMSDownStreamGuard", g() + ": Except onDownloadStop t=" + t.toString());
                    Log.e("PMSDownStreamGuard", g() + ": Except onDownloadStop e=" + Log.getStackTraceString(e2));
                    throw e2;
                }
            }
        }
    }

    @Override // d.a.l0.n.f.c
    public Map<String, Object> k() {
        return this.f48048e.k();
    }

    @Override // d.a.l0.n.f.e
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        d.a.l0.n.f.c<T> cVar = this.f48048e;
        return cVar == null ? new Bundle() : cVar.m(bundle, set);
    }
}
