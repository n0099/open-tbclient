package d.a.m0.n.i.i.g;

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
    public e f51836e;

    /* renamed from: f  reason: collision with root package name */
    public T f51837f;

    /* renamed from: g  reason: collision with root package name */
    public File f51838g;

    /* renamed from: h  reason: collision with root package name */
    public AtomicBoolean f51839h = new AtomicBoolean(false);

    /* renamed from: i  reason: collision with root package name */
    public c<T> f51840i;
    public boolean j;

    public f(e eVar, T t, c<T> cVar) {
        this.f51836e = eVar;
        this.f51837f = t;
        this.f51840i = cVar;
    }

    public final void a(int i2, d.a.m0.n.h.e eVar) {
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
        if (eVar instanceof d.a.m0.n.h.f) {
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, eVar.f51794g);
        }
        d.a.m0.n.m.a.a(eVar.f51795h, "pkg_download", null, i2, jSONObject);
    }

    public boolean b(int i2) {
        d.a.m0.n.h.e eVar = this.f51836e.f51835b;
        if (eVar.f51792e != i2) {
            eVar.f51792e = i2;
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
        if (TextUtils.isEmpty(this.f51836e.f51835b.f51788a)) {
            File b2 = d.a.m0.n.o.d.b(this.f51840i.d(this.f51837f), this.f51836e.f51835b.l);
            this.f51838g = b2;
            if (b2 == null) {
                this.f51838g = d.a.m0.n.o.d.b(d.a.m0.m.b.b().getAppContext().getCacheDir().getAbsolutePath(), this.f51836e.f51835b.l);
            }
            File file = this.f51838g;
            if (file == null) {
                this.f51840i.e(this.f51837f, new d.a.m0.n.h.a(2203, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH));
                return false;
            }
            this.f51836e.f51835b.f51788a = file.getAbsolutePath();
            return true;
        }
        return true;
    }

    public boolean d(f<T> fVar) {
        e eVar;
        d.a.m0.n.h.e eVar2;
        e eVar3;
        d.a.m0.n.h.e eVar4;
        return (fVar == null || (eVar = fVar.f51836e) == null || (eVar2 = eVar.f51835b) == null || (eVar3 = this.f51836e) == null || (eVar4 = eVar3.f51835b) == null || !eVar4.equals(eVar2)) ? false : true;
    }

    public d.a.m0.n.f.c<T> e() {
        return this.f51840i;
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
        return this.f51837f;
    }

    public int g() {
        return new d.a.m0.n.i.i.d.a().a(this.f51840i.k()).intValue();
    }

    public int h() {
        return this.f51836e.f51835b.f51792e;
    }

    public int hashCode() {
        return Objects.hash(this.f51836e.f51835b);
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public boolean i(long j) {
        String d2 = this.f51840i.d(this.f51837f);
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
            if (d.a.m0.n.c.f51766a) {
                Log.d("ThunderInfoTask", d.a.m0.n.c.b().v() + ": path exception or no space left." + th.toString());
            }
            return false;
        }
    }

    public boolean j() {
        return this.j;
    }

    public void k() {
        this.f51840i.a(this.f51837f);
    }

    public void l() {
        b(3);
        this.f51840i.e(this.f51837f, this.f51836e.f51834a);
    }

    public void m() {
        b(10);
        this.f51840i.i(this.f51837f);
    }

    public void n() {
        if (d.a.m0.n.c.f51766a) {
            Log.d("ThunderInfoTask", d.a.m0.n.c.b().v() + ": onNotifyPending" + this);
        }
        this.j = true;
        r(true);
    }

    public void o() {
        b(1);
        this.f51840i.c(this.f51837f);
    }

    public void p() {
        b(2);
        this.f51840i.j(this.f51837f);
    }

    public void q(boolean z) {
        if (d.a.m0.n.c.f51766a) {
            Log.d("ThunderInfoTask", d.a.m0.n.c.b().v() + ": onResetPending" + this);
        }
        if (z) {
            this.f51836e.f51835b.f51789b = 0L;
        }
        b(0);
        r(false);
        this.j = false;
    }

    public void r(boolean z) {
        if (this.f51839h.get() != z) {
            this.f51839h.set(z);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (d.a.m0.n.c.f51766a) {
            Log.d("ThunderInfoTask", d.a.m0.n.c.b().v() + ": run:" + this.f51836e.f51835b.n);
        }
        j jVar = new j(this);
        while (true) {
            d.a.m0.n.h.a aVar = this.f51836e.f51834a;
            if (aVar != null && aVar.f51784a == 2200) {
                return;
            }
            if (this.f51839h.get()) {
                if (d.a.m0.n.c.f51766a) {
                    Log.d("ThunderInfoTask", d.a.m0.n.c.b().v() + ": stopped:" + this.f51836e.f51835b.n);
                }
                p();
                return;
            }
            jVar.b();
            d.a.m0.n.h.a aVar2 = this.f51836e.f51834a;
            if (aVar2 != null) {
                if (aVar2.f51784a != 2200) {
                    if (this.f51839h.get()) {
                        if (d.a.m0.n.c.f51766a) {
                            Log.d("ThunderInfoTask", d.a.m0.n.c.b().v() + ": stopped:" + this.f51836e.f51835b.n);
                        }
                        p();
                        return;
                    }
                    if (d.a.m0.n.c.f51766a) {
                        Log.d("ThunderInfoTask", d.a.m0.n.c.b().v() + ": retry download:" + this.f51836e.f51835b.n);
                    }
                    c<T> cVar = this.f51840i;
                    int i2 = cVar.f51831f + 1;
                    cVar.f51831f = i2;
                    if (i2 < 3) {
                        try {
                            if (!this.f51839h.get()) {
                                Thread.sleep(this.f51840i.f51831f * 1000);
                            }
                        } catch (InterruptedException unused) {
                        }
                    } else {
                        l();
                        e eVar = this.f51836e;
                        a(eVar.f51834a.f51784a, eVar.f51835b);
                        return;
                    }
                } else {
                    if (d.a.m0.n.c.f51766a) {
                        Log.d("ThunderInfoTask", d.a.m0.n.c.b().v() + ": success download:" + this.f51836e.f51835b.n);
                    }
                    m();
                    return;
                }
            }
        }
    }

    public String toString() {
        return "downloadUrl:" + this.f51836e.f51835b.n + ",versionName:" + this.f51836e.f51835b.j + ",versionCode:" + this.f51836e.f51835b.f51796i + "md5:" + this.f51836e.f51835b.l + "bundleId:" + this.f51836e.f51835b.f51794g;
    }
}
