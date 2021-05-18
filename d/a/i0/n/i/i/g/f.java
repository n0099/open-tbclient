package d.a.i0.n.i.i.g;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import java.io.File;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f<T> implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public e f47878e;

    /* renamed from: f  reason: collision with root package name */
    public T f47879f;

    /* renamed from: g  reason: collision with root package name */
    public File f47880g;

    /* renamed from: h  reason: collision with root package name */
    public AtomicBoolean f47881h = new AtomicBoolean(false);

    /* renamed from: i  reason: collision with root package name */
    public c<T> f47882i;
    public boolean j;

    public f(e eVar, T t, c<T> cVar) {
        this.f47878e = eVar;
        this.f47879f = t;
        this.f47882i = cVar;
    }

    public final void a(int i2, d.a.i0.n.h.e eVar) {
        if (eVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (i2 == 2200) {
            i2 = 0;
        } else {
            try {
                jSONObject.put("response", eVar.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (eVar instanceof d.a.i0.n.h.f) {
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, eVar.f47836g);
        }
        d.a.i0.n.m.a.a(eVar.f47837h, "pkg_download", null, i2, jSONObject);
    }

    public boolean b(int i2) {
        d.a.i0.n.h.e eVar = this.f47878e.f47877b;
        if (eVar.f47834e != i2) {
            eVar.f47834e = i2;
            if (i2 != 2 && i2 != 3 && i2 != 10) {
                r(false);
            } else {
                r(true);
            }
            return true;
        }
        return false;
    }

    public boolean c() {
        if (TextUtils.isEmpty(this.f47878e.f47877b.f47830a)) {
            File b2 = d.a.i0.n.o.d.b(this.f47882i.d(this.f47879f), this.f47878e.f47877b.l);
            this.f47880g = b2;
            if (b2 == null) {
                this.f47880g = d.a.i0.n.o.d.b(d.a.i0.m.b.b().getAppContext().getCacheDir().getAbsolutePath(), this.f47878e.f47877b.l);
            }
            File file = this.f47880g;
            if (file == null) {
                this.f47882i.e(this.f47879f, new d.a.i0.n.h.a(2203, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH));
                return false;
            }
            this.f47878e.f47877b.f47830a = file.getAbsolutePath();
            return true;
        }
        return true;
    }

    public boolean d(f<T> fVar) {
        e eVar;
        d.a.i0.n.h.e eVar2;
        e eVar3;
        d.a.i0.n.h.e eVar4;
        return (fVar == null || (eVar = fVar.f47878e) == null || (eVar2 = eVar.f47877b) == null || (eVar3 = this.f47878e) == null || (eVar4 = eVar3.f47877b) == null || !eVar4.equals(eVar2)) ? false : true;
    }

    public d.a.i0.n.f.c<T> e() {
        return this.f47882i;
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj != null && (obj instanceof f)) {
            return d((f) obj);
        }
        return false;
    }

    public T f() {
        return this.f47879f;
    }

    public int g() {
        return new d.a.i0.n.i.i.d.a().a(this.f47882i.k()).intValue();
    }

    public int h() {
        return this.f47878e.f47877b.f47834e;
    }

    public int hashCode() {
        return Objects.hash(this.f47878e.f47877b);
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public boolean i(long j) {
        String d2 = this.f47882i.d(this.f47879f);
        if (d2 == null) {
            return false;
        }
        try {
            StatFs statFs = new StatFs(d2);
            if (Build.VERSION.SDK_INT >= 18) {
                return statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong() > j;
            }
            return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks()) > j;
        } catch (Throwable th) {
            if (d.a.i0.n.c.f47808a) {
                Log.d("ThunderInfoTask", d.a.i0.n.c.b().v() + ": path exception or no space left." + th.toString());
            }
            return false;
        }
    }

    public boolean j() {
        return this.j;
    }

    public void k() {
        this.f47882i.a(this.f47879f);
    }

    public void l() {
        b(3);
        this.f47882i.e(this.f47879f, this.f47878e.f47876a);
    }

    public void m() {
        b(10);
        this.f47882i.i(this.f47879f);
    }

    public void n() {
        if (d.a.i0.n.c.f47808a) {
            Log.d("ThunderInfoTask", d.a.i0.n.c.b().v() + ": onNotifyPending" + this);
        }
        this.j = true;
        r(true);
    }

    public void o() {
        b(1);
        this.f47882i.c(this.f47879f);
    }

    public void p() {
        b(2);
        this.f47882i.j(this.f47879f);
    }

    public void q(boolean z) {
        if (d.a.i0.n.c.f47808a) {
            Log.d("ThunderInfoTask", d.a.i0.n.c.b().v() + ": onResetPending" + this);
        }
        if (z) {
            this.f47878e.f47877b.f47831b = 0L;
        }
        b(0);
        r(false);
        this.j = false;
    }

    public void r(boolean z) {
        if (this.f47881h.get() != z) {
            this.f47881h.set(z);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (d.a.i0.n.c.f47808a) {
            Log.d("ThunderInfoTask", d.a.i0.n.c.b().v() + ": run:" + this.f47878e.f47877b.n);
        }
        j jVar = new j(this);
        while (true) {
            d.a.i0.n.h.a aVar = this.f47878e.f47876a;
            if (aVar != null && aVar.f47826a == 2200) {
                return;
            }
            if (this.f47881h.get()) {
                if (d.a.i0.n.c.f47808a) {
                    Log.d("ThunderInfoTask", d.a.i0.n.c.b().v() + ": stopped:" + this.f47878e.f47877b.n);
                }
                p();
                return;
            }
            jVar.b();
            d.a.i0.n.h.a aVar2 = this.f47878e.f47876a;
            if (aVar2 != null) {
                if (aVar2.f47826a != 2200) {
                    if (this.f47881h.get()) {
                        if (d.a.i0.n.c.f47808a) {
                            Log.d("ThunderInfoTask", d.a.i0.n.c.b().v() + ": stopped:" + this.f47878e.f47877b.n);
                        }
                        p();
                        return;
                    }
                    if (d.a.i0.n.c.f47808a) {
                        Log.d("ThunderInfoTask", d.a.i0.n.c.b().v() + ": retry download:" + this.f47878e.f47877b.n);
                    }
                    c<T> cVar = this.f47882i;
                    int i2 = cVar.f47873f + 1;
                    cVar.f47873f = i2;
                    if (i2 < 3) {
                        try {
                            if (!this.f47881h.get()) {
                                Thread.sleep(this.f47882i.f47873f * 1000);
                            }
                        } catch (InterruptedException unused) {
                        }
                    } else {
                        l();
                        e eVar = this.f47878e;
                        a(eVar.f47876a.f47826a, eVar.f47877b);
                        return;
                    }
                } else {
                    if (d.a.i0.n.c.f47808a) {
                        Log.d("ThunderInfoTask", d.a.i0.n.c.b().v() + ": success download:" + this.f47878e.f47877b.n);
                    }
                    m();
                    return;
                }
            }
        }
    }

    public String toString() {
        return "downloadUrl:" + this.f47878e.f47877b.n + ",versionName:" + this.f47878e.f47877b.j + ",versionCode:" + this.f47878e.f47877b.f47838i + "md5:" + this.f47878e.f47877b.l + "bundleId:" + this.f47878e.f47877b.f47836g;
    }
}
