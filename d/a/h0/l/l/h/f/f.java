package d.a.h0.l.l.h.f;

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
    public e f47185e;

    /* renamed from: f  reason: collision with root package name */
    public T f47186f;

    /* renamed from: g  reason: collision with root package name */
    public File f47187g;

    /* renamed from: h  reason: collision with root package name */
    public AtomicBoolean f47188h = new AtomicBoolean(false);

    /* renamed from: i  reason: collision with root package name */
    public c<T> f47189i;
    public boolean j;

    public f(e eVar, T t, c<T> cVar) {
        this.f47185e = eVar;
        this.f47186f = t;
        this.f47189i = cVar;
    }

    public final void a(int i2, d.a.h0.l.k.e eVar) {
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
        if (eVar instanceof d.a.h0.l.k.f) {
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, eVar.f47153g);
        }
        d.a.h0.l.p.a.a(eVar.f47154h, "pkg_download", null, i2, jSONObject);
    }

    public boolean b(int i2) {
        d.a.h0.l.k.e eVar = this.f47185e.f47184b;
        if (eVar.f47151e != i2) {
            eVar.f47151e = i2;
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
        if (TextUtils.isEmpty(this.f47185e.f47184b.f47147a)) {
            File b2 = d.a.h0.l.r.d.b(this.f47189i.e(this.f47186f), this.f47185e.f47184b.l);
            this.f47187g = b2;
            if (b2 == null) {
                this.f47189i.f(this.f47186f, new d.a.h0.l.k.a(2203, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH));
                return false;
            }
            this.f47185e.f47184b.f47147a = b2.getAbsolutePath();
            return true;
        }
        return true;
    }

    public boolean d(f<T> fVar) {
        e eVar;
        d.a.h0.l.k.e eVar2;
        e eVar3;
        d.a.h0.l.k.e eVar4;
        return (fVar == null || (eVar = fVar.f47185e) == null || (eVar2 = eVar.f47184b) == null || (eVar3 = this.f47185e) == null || (eVar4 = eVar3.f47184b) == null || !eVar4.equals(eVar2)) ? false : true;
    }

    public d.a.h0.l.h.c<T> e() {
        return this.f47189i;
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
        return this.f47186f;
    }

    public int g() {
        return new d.a.h0.l.l.h.d.a().a(this.f47189i.k()).intValue();
    }

    public int h() {
        return this.f47185e.f47184b.f47151e;
    }

    public int hashCode() {
        return Objects.hash(this.f47185e.f47184b);
    }

    public boolean i(long j) {
        String e2 = this.f47189i.e(this.f47186f);
        if (e2 == null) {
            return false;
        }
        try {
            StatFs statFs = new StatFs(e2);
            if (Build.VERSION.SDK_INT >= 18) {
                return statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong() > j;
            }
            return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks()) > j;
        } catch (Throwable th) {
            if (d.a.h0.l.f.f47117a) {
                Log.d("ThunderInfoTask", d.a.h0.l.f.b().u() + ": path exception or no space left." + th.toString());
            }
            return false;
        }
    }

    public boolean j() {
        return this.j;
    }

    public void k() {
        this.f47189i.a(this.f47186f);
    }

    public void l() {
        b(3);
        this.f47189i.f(this.f47186f, this.f47185e.f47183a);
    }

    public void m() {
        b(10);
        this.f47189i.i(this.f47186f);
    }

    public void n() {
        if (d.a.h0.l.f.f47117a) {
            Log.d("ThunderInfoTask", d.a.h0.l.f.b().u() + ": onNotifyPending" + this);
        }
        this.j = true;
        r(true);
    }

    public void o() {
        b(1);
        this.f47189i.d(this.f47186f);
    }

    public void p() {
        b(2);
        this.f47189i.j(this.f47186f);
    }

    public void q(boolean z) {
        if (d.a.h0.l.f.f47117a) {
            Log.d("ThunderInfoTask", d.a.h0.l.f.b().u() + ": onResetPending" + this);
        }
        if (z) {
            this.f47185e.f47184b.f47148b = 0L;
        }
        b(0);
        r(false);
        this.j = false;
    }

    public void r(boolean z) {
        if (this.f47188h.get() != z) {
            this.f47188h.set(z);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (d.a.h0.l.f.f47117a) {
            Log.d("ThunderInfoTask", d.a.h0.l.f.b().u() + ": run:" + this.f47185e.f47184b.n);
        }
        j jVar = new j(this);
        while (true) {
            d.a.h0.l.k.a aVar = this.f47185e.f47183a;
            if (aVar != null && aVar.f47144a == 2200) {
                return;
            }
            if (this.f47188h.get()) {
                if (d.a.h0.l.f.f47117a) {
                    Log.d("ThunderInfoTask", d.a.h0.l.f.b().u() + ": stopped:" + this.f47185e.f47184b.n);
                }
                p();
                return;
            }
            jVar.b();
            d.a.h0.l.k.a aVar2 = this.f47185e.f47183a;
            if (aVar2 != null) {
                if (aVar2.f47144a != 2200) {
                    if (this.f47188h.get()) {
                        if (d.a.h0.l.f.f47117a) {
                            Log.d("ThunderInfoTask", d.a.h0.l.f.b().u() + ": stopped:" + this.f47185e.f47184b.n);
                        }
                        p();
                        return;
                    }
                    if (d.a.h0.l.f.f47117a) {
                        Log.d("ThunderInfoTask", d.a.h0.l.f.b().u() + ": retry download:" + this.f47185e.f47184b.n);
                    }
                    c<T> cVar = this.f47189i;
                    int i2 = cVar.f47180f + 1;
                    cVar.f47180f = i2;
                    if (i2 < 3) {
                        try {
                            if (!this.f47188h.get()) {
                                Thread.sleep(this.f47189i.f47180f * 1000);
                            }
                        } catch (InterruptedException unused) {
                        }
                    } else {
                        l();
                        e eVar = this.f47185e;
                        a(eVar.f47183a.f47144a, eVar.f47184b);
                        return;
                    }
                } else {
                    if (d.a.h0.l.f.f47117a) {
                        Log.d("ThunderInfoTask", d.a.h0.l.f.b().u() + ": success download:" + this.f47185e.f47184b.n);
                    }
                    m();
                    return;
                }
            }
        }
    }

    public String toString() {
        return "downloadUrl:" + this.f47185e.f47184b.n + ",versionName:" + this.f47185e.f47184b.j + ",versionCode:" + this.f47185e.f47184b.f47155i + "md5:" + this.f47185e.f47184b.l + "bundleId:" + this.f47185e.f47184b.f47153g;
    }
}
