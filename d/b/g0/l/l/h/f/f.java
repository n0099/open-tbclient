package d.b.g0.l.l.h.f;

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
    public e f48954e;

    /* renamed from: f  reason: collision with root package name */
    public T f48955f;

    /* renamed from: g  reason: collision with root package name */
    public File f48956g;

    /* renamed from: h  reason: collision with root package name */
    public AtomicBoolean f48957h = new AtomicBoolean(false);
    public c<T> i;
    public boolean j;

    public f(e eVar, T t, c<T> cVar) {
        this.f48954e = eVar;
        this.f48955f = t;
        this.i = cVar;
    }

    public final void a(int i, d.b.g0.l.k.e eVar) {
        if (eVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (i == 2200) {
            i = 0;
        } else {
            try {
                jSONObject.put("response", eVar.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (eVar instanceof d.b.g0.l.k.f) {
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, eVar.f48923g);
        }
        d.b.g0.l.p.a.a(eVar.f48924h, "pkg_download", null, i, jSONObject);
    }

    public boolean b(int i) {
        d.b.g0.l.k.e eVar = this.f48954e.f48953b;
        if (eVar.f48921e != i) {
            eVar.f48921e = i;
            if (i != 2 && i != 3 && i != 10) {
                r(false);
            } else {
                r(true);
            }
            return true;
        }
        return false;
    }

    public boolean c() {
        if (TextUtils.isEmpty(this.f48954e.f48953b.f48917a)) {
            File b2 = d.b.g0.l.r.d.b(this.i.j(this.f48955f), this.f48954e.f48953b.l);
            this.f48956g = b2;
            if (b2 == null) {
                this.i.l(this.f48955f, new d.b.g0.l.k.a(2203, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH));
                return false;
            }
            this.f48954e.f48953b.f48917a = b2.getAbsolutePath();
            return true;
        }
        return true;
    }

    public boolean d(f<T> fVar) {
        e eVar;
        d.b.g0.l.k.e eVar2;
        e eVar3;
        d.b.g0.l.k.e eVar4;
        return (fVar == null || (eVar = fVar.f48954e) == null || (eVar2 = eVar.f48953b) == null || (eVar3 = this.f48954e) == null || (eVar4 = eVar3.f48953b) == null || !eVar4.equals(eVar2)) ? false : true;
    }

    public d.b.g0.l.h.c<T> e() {
        return this.i;
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
        return this.f48955f;
    }

    public int g() {
        return new d.b.g0.l.l.h.d.a().a(this.i.d()).intValue();
    }

    public int h() {
        return this.f48954e.f48953b.f48921e;
    }

    public int hashCode() {
        return Objects.hash(this.f48954e.f48953b);
    }

    public boolean i(long j) {
        String j2 = this.i.j(this.f48955f);
        if (j2 == null) {
            return false;
        }
        try {
            StatFs statFs = new StatFs(j2);
            if (Build.VERSION.SDK_INT >= 18) {
                return statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong() > j;
            }
            return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks()) > j;
        } catch (Throwable th) {
            if (d.b.g0.l.f.f48889a) {
                Log.d("ThunderInfoTask", d.b.g0.l.f.b().A() + ": path exception or no space left." + th.toString());
            }
            return false;
        }
    }

    public boolean j() {
        return this.j;
    }

    public void k() {
        this.i.a(this.f48955f);
    }

    public void l() {
        b(3);
        this.i.l(this.f48955f, this.f48954e.f48952a);
    }

    public void m() {
        b(10);
        this.i.b(this.f48955f);
    }

    public void n() {
        if (d.b.g0.l.f.f48889a) {
            Log.d("ThunderInfoTask", d.b.g0.l.f.b().A() + ": onNotifyPending" + this);
        }
        this.j = true;
        r(true);
    }

    public void o() {
        b(1);
        this.i.i(this.f48955f);
    }

    public void p() {
        b(2);
        this.i.c(this.f48955f);
    }

    public void q(boolean z) {
        if (d.b.g0.l.f.f48889a) {
            Log.d("ThunderInfoTask", d.b.g0.l.f.b().A() + ": onResetPending" + this);
        }
        if (z) {
            this.f48954e.f48953b.f48918b = 0L;
        }
        b(0);
        r(false);
        this.j = false;
    }

    public void r(boolean z) {
        if (this.f48957h.get() != z) {
            this.f48957h.set(z);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (d.b.g0.l.f.f48889a) {
            Log.d("ThunderInfoTask", d.b.g0.l.f.b().A() + ": run:" + this.f48954e.f48953b.n);
        }
        j jVar = new j(this);
        while (true) {
            d.b.g0.l.k.a aVar = this.f48954e.f48952a;
            if (aVar != null && aVar.f48914a == 2200) {
                return;
            }
            if (this.f48957h.get()) {
                if (d.b.g0.l.f.f48889a) {
                    Log.d("ThunderInfoTask", d.b.g0.l.f.b().A() + ": stopped:" + this.f48954e.f48953b.n);
                }
                p();
                return;
            }
            jVar.b();
            d.b.g0.l.k.a aVar2 = this.f48954e.f48952a;
            if (aVar2 != null) {
                if (aVar2.f48914a != 2200) {
                    if (this.f48957h.get()) {
                        if (d.b.g0.l.f.f48889a) {
                            Log.d("ThunderInfoTask", d.b.g0.l.f.b().A() + ": stopped:" + this.f48954e.f48953b.n);
                        }
                        p();
                        return;
                    }
                    if (d.b.g0.l.f.f48889a) {
                        Log.d("ThunderInfoTask", d.b.g0.l.f.b().A() + ": retry download:" + this.f48954e.f48953b.n);
                    }
                    c<T> cVar = this.i;
                    int i = cVar.f48949f + 1;
                    cVar.f48949f = i;
                    if (i < 3) {
                        try {
                            if (!this.f48957h.get()) {
                                Thread.sleep(this.i.f48949f * 1000);
                            }
                        } catch (InterruptedException unused) {
                        }
                    } else {
                        l();
                        e eVar = this.f48954e;
                        a(eVar.f48952a.f48914a, eVar.f48953b);
                        return;
                    }
                } else {
                    if (d.b.g0.l.f.f48889a) {
                        Log.d("ThunderInfoTask", d.b.g0.l.f.b().A() + ": success download:" + this.f48954e.f48953b.n);
                    }
                    m();
                    return;
                }
            }
        }
    }

    public String toString() {
        return "downloadUrl:" + this.f48954e.f48953b.n + ",versionName:" + this.f48954e.f48953b.j + ",versionCode:" + this.f48954e.f48953b.i + "md5:" + this.f48954e.f48953b.l + "bundleId:" + this.f48954e.f48953b.f48923g;
    }
}
