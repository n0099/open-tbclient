package d.a.l0.n.i.i.g;

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
    public e f48054e;

    /* renamed from: f  reason: collision with root package name */
    public T f48055f;

    /* renamed from: g  reason: collision with root package name */
    public File f48056g;

    /* renamed from: h  reason: collision with root package name */
    public AtomicBoolean f48057h = new AtomicBoolean(false);

    /* renamed from: i  reason: collision with root package name */
    public c<T> f48058i;
    public boolean j;

    public f(e eVar, T t, c<T> cVar) {
        this.f48054e = eVar;
        this.f48055f = t;
        this.f48058i = cVar;
    }

    public final void a(int i2, d.a.l0.n.h.e eVar) {
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
        if (eVar instanceof d.a.l0.n.h.f) {
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, eVar.f48012g);
        }
        d.a.l0.n.m.a.a(eVar.f48013h, "pkg_download", null, i2, jSONObject);
    }

    public boolean b(int i2) {
        d.a.l0.n.h.e eVar = this.f48054e.f48053b;
        if (eVar.f48010e != i2) {
            eVar.f48010e = i2;
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
        if (TextUtils.isEmpty(this.f48054e.f48053b.f48006a)) {
            File b2 = d.a.l0.n.o.d.b(this.f48058i.d(this.f48055f), this.f48054e.f48053b.l);
            this.f48056g = b2;
            if (b2 == null) {
                this.f48056g = d.a.l0.n.o.d.b(d.a.l0.m.b.b().getAppContext().getCacheDir().getAbsolutePath(), this.f48054e.f48053b.l);
            }
            File file = this.f48056g;
            if (file == null) {
                this.f48058i.e(this.f48055f, new d.a.l0.n.h.a(2203, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH));
                return false;
            }
            this.f48054e.f48053b.f48006a = file.getAbsolutePath();
            return true;
        }
        return true;
    }

    public boolean d(f<T> fVar) {
        e eVar;
        d.a.l0.n.h.e eVar2;
        e eVar3;
        d.a.l0.n.h.e eVar4;
        return (fVar == null || (eVar = fVar.f48054e) == null || (eVar2 = eVar.f48053b) == null || (eVar3 = this.f48054e) == null || (eVar4 = eVar3.f48053b) == null || !eVar4.equals(eVar2)) ? false : true;
    }

    public d.a.l0.n.f.c<T> e() {
        return this.f48058i;
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
        return this.f48055f;
    }

    public int g() {
        return new d.a.l0.n.i.i.d.a().a(this.f48058i.k()).intValue();
    }

    public int h() {
        return this.f48054e.f48053b.f48010e;
    }

    public int hashCode() {
        return Objects.hash(this.f48054e.f48053b);
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public boolean i(long j) {
        String d2 = this.f48058i.d(this.f48055f);
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
            if (d.a.l0.n.c.f47984a) {
                Log.d("ThunderInfoTask", d.a.l0.n.c.b().v() + ": path exception or no space left." + th.toString());
            }
            return false;
        }
    }

    public boolean j() {
        return this.j;
    }

    public void k() {
        this.f48058i.a(this.f48055f);
    }

    public void l() {
        b(3);
        this.f48058i.e(this.f48055f, this.f48054e.f48052a);
    }

    public void m() {
        b(10);
        this.f48058i.i(this.f48055f);
    }

    public void n() {
        if (d.a.l0.n.c.f47984a) {
            Log.d("ThunderInfoTask", d.a.l0.n.c.b().v() + ": onNotifyPending" + this);
        }
        this.j = true;
        r(true);
    }

    public void o() {
        b(1);
        this.f48058i.c(this.f48055f);
    }

    public void p() {
        b(2);
        this.f48058i.j(this.f48055f);
    }

    public void q(boolean z) {
        if (d.a.l0.n.c.f47984a) {
            Log.d("ThunderInfoTask", d.a.l0.n.c.b().v() + ": onResetPending" + this);
        }
        if (z) {
            this.f48054e.f48053b.f48007b = 0L;
        }
        b(0);
        r(false);
        this.j = false;
    }

    public void r(boolean z) {
        if (this.f48057h.get() != z) {
            this.f48057h.set(z);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (d.a.l0.n.c.f47984a) {
            Log.d("ThunderInfoTask", d.a.l0.n.c.b().v() + ": run:" + this.f48054e.f48053b.n);
        }
        j jVar = new j(this);
        while (true) {
            d.a.l0.n.h.a aVar = this.f48054e.f48052a;
            if (aVar != null && aVar.f48002a == 2200) {
                return;
            }
            if (this.f48057h.get()) {
                if (d.a.l0.n.c.f47984a) {
                    Log.d("ThunderInfoTask", d.a.l0.n.c.b().v() + ": stopped:" + this.f48054e.f48053b.n);
                }
                p();
                return;
            }
            jVar.b();
            d.a.l0.n.h.a aVar2 = this.f48054e.f48052a;
            if (aVar2 != null) {
                if (aVar2.f48002a != 2200) {
                    if (this.f48057h.get()) {
                        if (d.a.l0.n.c.f47984a) {
                            Log.d("ThunderInfoTask", d.a.l0.n.c.b().v() + ": stopped:" + this.f48054e.f48053b.n);
                        }
                        p();
                        return;
                    }
                    if (d.a.l0.n.c.f47984a) {
                        Log.d("ThunderInfoTask", d.a.l0.n.c.b().v() + ": retry download:" + this.f48054e.f48053b.n);
                    }
                    c<T> cVar = this.f48058i;
                    int i2 = cVar.f48049f + 1;
                    cVar.f48049f = i2;
                    if (i2 < 3) {
                        try {
                            if (!this.f48057h.get()) {
                                Thread.sleep(this.f48058i.f48049f * 1000);
                            }
                        } catch (InterruptedException unused) {
                        }
                    } else {
                        l();
                        e eVar = this.f48054e;
                        a(eVar.f48052a.f48002a, eVar.f48053b);
                        return;
                    }
                } else {
                    if (d.a.l0.n.c.f47984a) {
                        Log.d("ThunderInfoTask", d.a.l0.n.c.b().v() + ": success download:" + this.f48054e.f48053b.n);
                    }
                    m();
                    return;
                }
            }
        }
    }

    public String toString() {
        return "downloadUrl:" + this.f48054e.f48053b.n + ",versionName:" + this.f48054e.f48053b.j + ",versionCode:" + this.f48054e.f48053b.f48014i + "md5:" + this.f48054e.f48053b.l + "bundleId:" + this.f48054e.f48053b.f48012g;
    }
}
