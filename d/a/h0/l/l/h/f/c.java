package d.a.h0.l.l.h.f;

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
public class c<T> implements d.a.h0.l.h.c<T> {

    /* renamed from: e  reason: collision with root package name */
    public d.a.h0.l.h.c<T> f47179e;

    /* renamed from: f  reason: collision with root package name */
    public int f47180f = 0;

    public c(d.a.h0.l.h.c<T> cVar) {
        this.f47179e = cVar;
    }

    @Override // d.a.h0.l.h.c
    public void a(T t) {
        d.a.h0.l.h.c<T> cVar = this.f47179e;
        if (cVar != null) {
            try {
                cVar.a(t);
            } catch (Exception e2) {
                if (d.a.h0.l.f.f47117a) {
                    Log.e("PMSDownStreamGuard", h() + ": Except onDownloadProgress t=" + t.toString());
                    Log.e("PMSDownStreamGuard", h() + ": Except onDownloadProgress e=" + Log.getStackTraceString(e2));
                    throw e2;
                }
            }
        }
    }

    @Override // d.a.h0.l.h.c
    public d.a.h0.l.k.a b(T t, BufferedSource bufferedSource, File file, long j) throws IOException {
        d.a.h0.l.h.c<T> cVar = this.f47179e;
        if (cVar != null) {
            return cVar.b(t, bufferedSource, file, j);
        }
        return new d.a.h0.l.k.a(2302, "业务层默认不处理下载流");
    }

    @Override // d.a.h0.l.h.c
    public void d(T t) {
        d.a.h0.l.h.c<T> cVar = this.f47179e;
        if (cVar != null) {
            try {
                cVar.d(t);
            } catch (Exception e2) {
                if (d.a.h0.l.f.f47117a) {
                    Log.e("PMSDownStreamGuard", h() + ": Except onDownloadStart t=" + t.toString());
                    Log.e("PMSDownStreamGuard", h() + ": Except onDownloadStart e=" + Log.getStackTraceString(e2));
                    throw e2;
                }
            }
        }
    }

    @Override // d.a.h0.l.h.c
    public String e(T t) {
        d.a.h0.l.h.c<T> cVar = this.f47179e;
        String e2 = cVar != null ? cVar.e(t) : null;
        if (d.a.h0.l.f.f47117a) {
            Log.d("PMSDownStreamGuard", h() + ": getDownloadPath:" + e2);
        }
        if (e2 == null) {
            try {
                e2 = d.a.h0.l.r.d.c(AppRuntime.getAppContext()).getAbsolutePath();
            } catch (Exception e3) {
                if (d.a.h0.l.f.f47117a) {
                    Log.e("PMSDownStreamGuard", h() + ": getDownloadPath error: e=" + Log.getStackTraceString(e3));
                    throw e3;
                }
            }
            if (d.a.h0.l.f.f47117a) {
                Log.d("PMSDownStreamGuard", h() + ": getDownloadPath failed, using default path:" + e2);
            }
        }
        return e2;
    }

    @Override // d.a.h0.l.h.c
    public void f(T t, d.a.h0.l.k.a aVar) {
        d.a.h0.l.h.c<T> cVar = this.f47179e;
        if (cVar != null) {
            try {
                cVar.f(t, aVar);
            } catch (Exception e2) {
                if (d.a.h0.l.f.f47117a) {
                    Log.e("PMSDownStreamGuard", h() + ": notify onDownloadError t=" + t.toString());
                    Log.e("PMSDownStreamGuard", h() + ": notify onDownloadError e=" + Log.getStackTraceString(e2));
                    throw e2;
                }
            }
        }
    }

    @Override // d.a.h0.l.h.c
    public void g(T t) {
        d.a.h0.l.h.c<T> cVar = this.f47179e;
        if (cVar != null) {
            try {
                cVar.g(t);
            } catch (Exception e2) {
                if (d.a.h0.l.f.f47117a) {
                    Log.e("PMSDownStreamGuard", h() + ": Except onDownloading t=" + t.toString());
                    Log.e("PMSDownStreamGuard", h() + ": Except onDownloading e=" + Log.getStackTraceString(e2));
                    throw e2;
                }
            }
        }
    }

    public final String h() {
        return d.a.h0.l.f.b().u();
    }

    @Override // d.a.h0.l.h.c
    public void i(T t) {
        d.a.h0.l.h.c<T> cVar = this.f47179e;
        if (cVar != null) {
            try {
                cVar.i(t);
            } catch (Exception e2) {
                if (d.a.h0.l.f.f47117a) {
                    Log.e("PMSDownStreamGuard", h() + ": Except onDownloadFinish: t=" + t.toString());
                    Log.e("PMSDownStreamGuard", h() + ": Except onDownloadFinish: cb=" + this.f47179e);
                    Log.e("PMSDownStreamGuard", h() + ": Except onDownloadFinish: e=" + Log.getStackTraceString(e2));
                    throw e2;
                }
            }
        }
    }

    @Override // d.a.h0.l.h.c
    public void j(T t) {
        d.a.h0.l.h.c<T> cVar = this.f47179e;
        if (cVar != null) {
            try {
                cVar.j(t);
            } catch (Exception e2) {
                if (d.a.h0.l.f.f47117a) {
                    Log.e("PMSDownStreamGuard", h() + ": Except onDownloadStop t=" + t.toString());
                    Log.e("PMSDownStreamGuard", h() + ": Except onDownloadStop e=" + Log.getStackTraceString(e2));
                    throw e2;
                }
            }
        }
    }

    @Override // d.a.h0.l.h.c
    public Map<String, Object> k() {
        return this.f47179e.k();
    }

    @Override // d.a.h0.l.h.e
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        d.a.h0.l.h.c<T> cVar = this.f47179e;
        return cVar == null ? new Bundle() : cVar.m(bundle, set);
    }
}
