package d.b.g0.l.l.h.f;

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
public class c<T> implements d.b.g0.l.h.c<T> {

    /* renamed from: e  reason: collision with root package name */
    public d.b.g0.l.h.c<T> f48947e;

    /* renamed from: f  reason: collision with root package name */
    public int f48948f = 0;

    public c(d.b.g0.l.h.c<T> cVar) {
        this.f48947e = cVar;
    }

    @Override // d.b.g0.l.h.c
    public void a(T t) {
        d.b.g0.l.h.c<T> cVar = this.f48947e;
        if (cVar != null) {
            try {
                cVar.a(t);
            } catch (Exception e2) {
                if (d.b.g0.l.f.f48888a) {
                    Log.e("PMSDownStreamGuard", e() + ": Except onDownloadProgress t=" + t.toString());
                    Log.e("PMSDownStreamGuard", e() + ": Except onDownloadProgress e=" + Log.getStackTraceString(e2));
                    throw e2;
                }
            }
        }
    }

    @Override // d.b.g0.l.h.c
    public void b(T t) {
        d.b.g0.l.h.c<T> cVar = this.f48947e;
        if (cVar != null) {
            try {
                cVar.b(t);
            } catch (Exception e2) {
                if (d.b.g0.l.f.f48888a) {
                    Log.e("PMSDownStreamGuard", e() + ": Except onDownloadFinish: t=" + t.toString());
                    Log.e("PMSDownStreamGuard", e() + ": Except onDownloadFinish: cb=" + this.f48947e);
                    Log.e("PMSDownStreamGuard", e() + ": Except onDownloadFinish: e=" + Log.getStackTraceString(e2));
                    throw e2;
                }
            }
        }
    }

    @Override // d.b.g0.l.h.c
    public void c(T t) {
        d.b.g0.l.h.c<T> cVar = this.f48947e;
        if (cVar != null) {
            try {
                cVar.c(t);
            } catch (Exception e2) {
                if (d.b.g0.l.f.f48888a) {
                    Log.e("PMSDownStreamGuard", e() + ": Except onDownloadStop t=" + t.toString());
                    Log.e("PMSDownStreamGuard", e() + ": Except onDownloadStop e=" + Log.getStackTraceString(e2));
                    throw e2;
                }
            }
        }
    }

    @Override // d.b.g0.l.h.c
    public Map<String, Object> d() {
        return this.f48947e.d();
    }

    public final String e() {
        return d.b.g0.l.f.b().A();
    }

    @Override // d.b.g0.l.h.c
    public d.b.g0.l.k.a f(T t, BufferedSource bufferedSource, File file, long j) throws IOException {
        d.b.g0.l.h.c<T> cVar = this.f48947e;
        if (cVar != null) {
            return cVar.f(t, bufferedSource, file, j);
        }
        return new d.b.g0.l.k.a(2302, "业务层默认不处理下载流");
    }

    @Override // d.b.g0.l.h.e
    @NonNull
    public Bundle g(@NonNull Bundle bundle, Set<String> set) {
        d.b.g0.l.h.c<T> cVar = this.f48947e;
        return cVar == null ? new Bundle() : cVar.g(bundle, set);
    }

    @Override // d.b.g0.l.h.c
    public void i(T t) {
        d.b.g0.l.h.c<T> cVar = this.f48947e;
        if (cVar != null) {
            try {
                cVar.i(t);
            } catch (Exception e2) {
                if (d.b.g0.l.f.f48888a) {
                    Log.e("PMSDownStreamGuard", e() + ": Except onDownloadStart t=" + t.toString());
                    Log.e("PMSDownStreamGuard", e() + ": Except onDownloadStart e=" + Log.getStackTraceString(e2));
                    throw e2;
                }
            }
        }
    }

    @Override // d.b.g0.l.h.c
    public String j(T t) {
        d.b.g0.l.h.c<T> cVar = this.f48947e;
        String j = cVar != null ? cVar.j(t) : null;
        if (d.b.g0.l.f.f48888a) {
            Log.d("PMSDownStreamGuard", e() + ": getDownloadPath:" + j);
        }
        if (j == null) {
            try {
                j = d.b.g0.l.r.d.c(AppRuntime.getAppContext()).getAbsolutePath();
            } catch (Exception e2) {
                if (d.b.g0.l.f.f48888a) {
                    Log.e("PMSDownStreamGuard", e() + ": getDownloadPath error: e=" + Log.getStackTraceString(e2));
                    throw e2;
                }
            }
            if (d.b.g0.l.f.f48888a) {
                Log.d("PMSDownStreamGuard", e() + ": getDownloadPath failed, using default path:" + j);
            }
        }
        return j;
    }

    @Override // d.b.g0.l.h.c
    public void l(T t, d.b.g0.l.k.a aVar) {
        d.b.g0.l.h.c<T> cVar = this.f48947e;
        if (cVar != null) {
            try {
                cVar.l(t, aVar);
            } catch (Exception e2) {
                if (d.b.g0.l.f.f48888a) {
                    Log.e("PMSDownStreamGuard", e() + ": notify onDownloadError t=" + t.toString());
                    Log.e("PMSDownStreamGuard", e() + ": notify onDownloadError e=" + Log.getStackTraceString(e2));
                    throw e2;
                }
            }
        }
    }

    @Override // d.b.g0.l.h.c
    public void o(T t) {
        d.b.g0.l.h.c<T> cVar = this.f48947e;
        if (cVar != null) {
            try {
                cVar.o(t);
            } catch (Exception e2) {
                if (d.b.g0.l.f.f48888a) {
                    Log.e("PMSDownStreamGuard", e() + ": Except onDownloading t=" + t.toString());
                    Log.e("PMSDownStreamGuard", e() + ": Except onDownloading e=" + Log.getStackTraceString(e2));
                    throw e2;
                }
            }
        }
    }
}
