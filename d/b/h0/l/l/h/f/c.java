package d.b.h0.l.l.h.f;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import okio.BufferedSource;
/* loaded from: classes3.dex */
public class c<T> implements d.b.h0.l.h.c<T> {

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.l.h.c<T> f49669e;

    /* renamed from: f  reason: collision with root package name */
    public int f49670f = 0;

    public c(d.b.h0.l.h.c<T> cVar) {
        this.f49669e = cVar;
    }

    @Override // d.b.h0.l.h.c
    public void a(T t) {
        d.b.h0.l.h.c<T> cVar = this.f49669e;
        if (cVar != null) {
            try {
                cVar.a(t);
            } catch (Exception e2) {
                if (d.b.h0.l.f.f49610a) {
                    Log.e("PMSDownStreamGuard", e() + ": Except onDownloadProgress t=" + t.toString());
                    Log.e("PMSDownStreamGuard", e() + ": Except onDownloadProgress e=" + Log.getStackTraceString(e2));
                    throw e2;
                }
            }
        }
    }

    @Override // d.b.h0.l.h.c
    public void b(T t) {
        d.b.h0.l.h.c<T> cVar = this.f49669e;
        if (cVar != null) {
            try {
                cVar.b(t);
            } catch (Exception e2) {
                if (d.b.h0.l.f.f49610a) {
                    Log.e("PMSDownStreamGuard", e() + ": Except onDownloadFinish: t=" + t.toString());
                    Log.e("PMSDownStreamGuard", e() + ": Except onDownloadFinish: cb=" + this.f49669e);
                    Log.e("PMSDownStreamGuard", e() + ": Except onDownloadFinish: e=" + Log.getStackTraceString(e2));
                    throw e2;
                }
            }
        }
    }

    @Override // d.b.h0.l.h.c
    public void c(T t) {
        d.b.h0.l.h.c<T> cVar = this.f49669e;
        if (cVar != null) {
            try {
                cVar.c(t);
            } catch (Exception e2) {
                if (d.b.h0.l.f.f49610a) {
                    Log.e("PMSDownStreamGuard", e() + ": Except onDownloadStop t=" + t.toString());
                    Log.e("PMSDownStreamGuard", e() + ": Except onDownloadStop e=" + Log.getStackTraceString(e2));
                    throw e2;
                }
            }
        }
    }

    @Override // d.b.h0.l.h.c
    public Map<String, Object> d() {
        return this.f49669e.d();
    }

    public final String e() {
        return d.b.h0.l.f.b().A();
    }

    @Override // d.b.h0.l.h.c
    public d.b.h0.l.k.a f(T t, BufferedSource bufferedSource, File file, long j) throws IOException {
        d.b.h0.l.h.c<T> cVar = this.f49669e;
        if (cVar != null) {
            return cVar.f(t, bufferedSource, file, j);
        }
        return new d.b.h0.l.k.a(2302, "业务层默认不处理下载流");
    }

    @Override // d.b.h0.l.h.e
    @NonNull
    public Bundle g(@NonNull Bundle bundle, Set<String> set) {
        d.b.h0.l.h.c<T> cVar = this.f49669e;
        return cVar == null ? new Bundle() : cVar.g(bundle, set);
    }

    @Override // d.b.h0.l.h.c
    public void i(T t) {
        d.b.h0.l.h.c<T> cVar = this.f49669e;
        if (cVar != null) {
            try {
                cVar.i(t);
            } catch (Exception e2) {
                if (d.b.h0.l.f.f49610a) {
                    Log.e("PMSDownStreamGuard", e() + ": Except onDownloadStart t=" + t.toString());
                    Log.e("PMSDownStreamGuard", e() + ": Except onDownloadStart e=" + Log.getStackTraceString(e2));
                    throw e2;
                }
            }
        }
    }

    @Override // d.b.h0.l.h.c
    public String j(T t) {
        d.b.h0.l.h.c<T> cVar = this.f49669e;
        String j = cVar != null ? cVar.j(t) : null;
        if (d.b.h0.l.f.f49610a) {
            Log.d("PMSDownStreamGuard", e() + ": getDownloadPath:" + j);
        }
        if (j == null) {
            try {
                j = d.b.h0.l.r.d.c(AppRuntime.getAppContext()).getAbsolutePath();
            } catch (Exception e2) {
                if (d.b.h0.l.f.f49610a) {
                    Log.e("PMSDownStreamGuard", e() + ": getDownloadPath error: e=" + Log.getStackTraceString(e2));
                    throw e2;
                }
            }
            if (d.b.h0.l.f.f49610a) {
                Log.d("PMSDownStreamGuard", e() + ": getDownloadPath failed, using default path:" + j);
            }
        }
        return j;
    }

    @Override // d.b.h0.l.h.c
    public void l(T t, d.b.h0.l.k.a aVar) {
        d.b.h0.l.h.c<T> cVar = this.f49669e;
        if (cVar != null) {
            try {
                cVar.l(t, aVar);
            } catch (Exception e2) {
                if (d.b.h0.l.f.f49610a) {
                    Log.e("PMSDownStreamGuard", e() + ": notify onDownloadError t=" + t.toString());
                    Log.e("PMSDownStreamGuard", e() + ": notify onDownloadError e=" + Log.getStackTraceString(e2));
                    throw e2;
                }
            }
        }
    }

    @Override // d.b.h0.l.h.c
    public void n(T t) {
        d.b.h0.l.h.c<T> cVar = this.f49669e;
        if (cVar != null) {
            try {
                cVar.n(t);
            } catch (Exception e2) {
                if (d.b.h0.l.f.f49610a) {
                    Log.e("PMSDownStreamGuard", e() + ": Except onDownloading t=" + t.toString());
                    Log.e("PMSDownStreamGuard", e() + ": Except onDownloading e=" + Log.getStackTraceString(e2));
                    throw e2;
                }
            }
        }
    }
}
