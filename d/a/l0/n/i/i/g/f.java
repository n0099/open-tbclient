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
    public e f51728e;

    /* renamed from: f  reason: collision with root package name */
    public T f51729f;

    /* renamed from: g  reason: collision with root package name */
    public File f51730g;

    /* renamed from: h  reason: collision with root package name */
    public AtomicBoolean f51731h = new AtomicBoolean(false);

    /* renamed from: i  reason: collision with root package name */
    public c<T> f51732i;
    public boolean j;

    public f(e eVar, T t, c<T> cVar) {
        this.f51728e = eVar;
        this.f51729f = t;
        this.f51732i = cVar;
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
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, eVar.f51686g);
        }
        d.a.l0.n.m.a.a(eVar.f51687h, "pkg_download", null, i2, jSONObject);
    }

    public boolean b(int i2) {
        d.a.l0.n.h.e eVar = this.f51728e.f51727b;
        if (eVar.f51684e != i2) {
            eVar.f51684e = i2;
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
        if (TextUtils.isEmpty(this.f51728e.f51727b.f51680a)) {
            File b2 = d.a.l0.n.o.d.b(this.f51732i.d(this.f51729f), this.f51728e.f51727b.l);
            this.f51730g = b2;
            if (b2 == null) {
                this.f51730g = d.a.l0.n.o.d.b(d.a.l0.m.b.b().getAppContext().getCacheDir().getAbsolutePath(), this.f51728e.f51727b.l);
            }
            File file = this.f51730g;
            if (file == null) {
                this.f51732i.e(this.f51729f, new d.a.l0.n.h.a(2203, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH));
                return false;
            }
            this.f51728e.f51727b.f51680a = file.getAbsolutePath();
            return true;
        }
        return true;
    }

    public boolean d(f<T> fVar) {
        e eVar;
        d.a.l0.n.h.e eVar2;
        e eVar3;
        d.a.l0.n.h.e eVar4;
        return (fVar == null || (eVar = fVar.f51728e) == null || (eVar2 = eVar.f51727b) == null || (eVar3 = this.f51728e) == null || (eVar4 = eVar3.f51727b) == null || !eVar4.equals(eVar2)) ? false : true;
    }

    public d.a.l0.n.f.c<T> e() {
        return this.f51732i;
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
        return this.f51729f;
    }

    public int g() {
        return new d.a.l0.n.i.i.d.a().a(this.f51732i.k()).intValue();
    }

    public int h() {
        return this.f51728e.f51727b.f51684e;
    }

    public int hashCode() {
        return Objects.hash(this.f51728e.f51727b);
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public boolean i(long j) {
        String d2 = this.f51732i.d(this.f51729f);
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
            if (d.a.l0.n.c.f51658a) {
                Log.d("ThunderInfoTask", d.a.l0.n.c.b().v() + ": path exception or no space left." + th.toString());
            }
            return false;
        }
    }

    public boolean j() {
        return this.j;
    }

    public void k() {
        this.f51732i.a(this.f51729f);
    }

    public void l() {
        b(3);
        this.f51732i.e(this.f51729f, this.f51728e.f51726a);
    }

    public void m() {
        b(10);
        this.f51732i.i(this.f51729f);
    }

    public void n() {
        if (d.a.l0.n.c.f51658a) {
            Log.d("ThunderInfoTask", d.a.l0.n.c.b().v() + ": onNotifyPending" + this);
        }
        this.j = true;
        r(true);
    }

    public void o() {
        b(1);
        this.f51732i.c(this.f51729f);
    }

    public void p() {
        b(2);
        this.f51732i.j(this.f51729f);
    }

    public void q(boolean z) {
        if (d.a.l0.n.c.f51658a) {
            Log.d("ThunderInfoTask", d.a.l0.n.c.b().v() + ": onResetPending" + this);
        }
        if (z) {
            this.f51728e.f51727b.f51681b = 0L;
        }
        b(0);
        r(false);
        this.j = false;
    }

    public void r(boolean z) {
        if (this.f51731h.get() != z) {
            this.f51731h.set(z);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (d.a.l0.n.c.f51658a) {
            Log.d("ThunderInfoTask", d.a.l0.n.c.b().v() + ": run:" + this.f51728e.f51727b.n);
        }
        j jVar = new j(this);
        while (true) {
            d.a.l0.n.h.a aVar = this.f51728e.f51726a;
            if (aVar != null && aVar.f51676a == 2200) {
                return;
            }
            if (this.f51731h.get()) {
                if (d.a.l0.n.c.f51658a) {
                    Log.d("ThunderInfoTask", d.a.l0.n.c.b().v() + ": stopped:" + this.f51728e.f51727b.n);
                }
                p();
                return;
            }
            jVar.b();
            d.a.l0.n.h.a aVar2 = this.f51728e.f51726a;
            if (aVar2 != null) {
                if (aVar2.f51676a != 2200) {
                    if (this.f51731h.get()) {
                        if (d.a.l0.n.c.f51658a) {
                            Log.d("ThunderInfoTask", d.a.l0.n.c.b().v() + ": stopped:" + this.f51728e.f51727b.n);
                        }
                        p();
                        return;
                    }
                    if (d.a.l0.n.c.f51658a) {
                        Log.d("ThunderInfoTask", d.a.l0.n.c.b().v() + ": retry download:" + this.f51728e.f51727b.n);
                    }
                    c<T> cVar = this.f51732i;
                    int i2 = cVar.f51723f + 1;
                    cVar.f51723f = i2;
                    if (i2 < 3) {
                        try {
                            if (!this.f51731h.get()) {
                                Thread.sleep(this.f51732i.f51723f * 1000);
                            }
                        } catch (InterruptedException unused) {
                        }
                    } else {
                        l();
                        e eVar = this.f51728e;
                        a(eVar.f51726a.f51676a, eVar.f51727b);
                        return;
                    }
                } else {
                    if (d.a.l0.n.c.f51658a) {
                        Log.d("ThunderInfoTask", d.a.l0.n.c.b().v() + ": success download:" + this.f51728e.f51727b.n);
                    }
                    m();
                    return;
                }
            }
        }
    }

    public String toString() {
        return "downloadUrl:" + this.f51728e.f51727b.n + ",versionName:" + this.f51728e.f51727b.j + ",versionCode:" + this.f51728e.f51727b.f51688i + "md5:" + this.f51728e.f51727b.l + "bundleId:" + this.f51728e.f51727b.f51686g;
    }
}
