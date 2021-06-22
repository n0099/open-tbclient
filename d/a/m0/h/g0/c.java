package d.a.m0.h.g0;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserModel;
import com.baidu.mobstat.Config;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.m0.a.k;
import d.a.m0.a.p.b.a.l;
import d.a.m0.a.q2.c;
import d.a.m0.a.r0.n;
import d.a.m0.h.s.a;
import java.io.File;
import java.util.Set;
@Singleton
@Service
/* loaded from: classes3.dex */
public class c implements l {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f51164c = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f51165a;

    /* renamed from: b  reason: collision with root package name */
    public File f51166b;

    /* loaded from: classes3.dex */
    public class a implements c.a<Long> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.q2.c.a
        /* renamed from: a */
        public Long update() throws IllegalStateException {
            return Long.valueOf(c.this.m());
        }
    }

    public c() {
        String o = o();
        if (f51164c) {
            Log.i("SwanGameStorageManager", "preferencesName:" + o);
        }
        if (o != null) {
            this.f51165a = d.a.m0.a.c1.a.b().getSharedPreferences(o, 0);
            File q = q();
            this.f51166b = new File(q, o + ActivityChooserModel.HISTORY_FILE_EXTENSION);
        }
        d.a.m0.a.q2.d.f48017h.e(new a());
    }

    public static void k(String str) {
        l(String.format("aigame_storage_%s_anonymous", str, ""));
    }

    public static void l(String str) {
        File[] listFiles;
        if (str == null || !str.startsWith("aigame_storage_") || (listFiles = q().listFiles()) == null) {
            return;
        }
        for (File file : listFiles) {
            if (file.getName().startsWith(str)) {
                d.a.m0.t.d.K(file);
            }
        }
    }

    @NonNull
    public static File q() {
        return new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs");
    }

    @Override // d.a.m0.a.p.b.a.l
    public String a(String str) {
        return n.U(str);
    }

    @Override // d.a.m0.a.p.b.a.l
    public d.a.m0.a.n0.c b() {
        return new d.a.m0.h.g0.a();
    }

    @Override // d.a.m0.a.p.b.a.l
    public void c() {
        n.c();
    }

    @Override // d.a.m0.a.p.b.a.l
    public File[] d() {
        return q().listFiles();
    }

    @Override // d.a.m0.a.p.b.a.l
    public String e() {
        return n.n();
    }

    @Override // d.a.m0.a.p.b.a.l
    public void f() {
        String I = d.a.m0.t.d.I(d.a.m0.h.s.a.d());
        String I2 = d.a.m0.t.d.I(a.d.g());
        g();
        c();
        d.a.m0.t.d.j(I);
        d.a.m0.t.d.j(I2);
    }

    @Override // d.a.m0.a.p.b.a.l
    public void g() {
        l("aigame_storage_");
    }

    @Override // d.a.m0.a.p.b.a.l
    public String h(String str) {
        return n.V(str);
    }

    @Override // d.a.m0.a.p.b.a.l
    public void i() {
        d.a.m0.a.r0.k.c();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean j() {
        return r() && this.f51165a.edit().clear().commit();
    }

    public long m() {
        File file = this.f51166b;
        if (file != null) {
            return file.length();
        }
        return 0L;
    }

    public String[] n() {
        if (r()) {
            Set<String> keySet = this.f51165a.getAll().keySet();
            String[] strArr = new String[keySet.size()];
            keySet.toArray(strArr);
            return strArr;
        }
        return new String[0];
    }

    @Nullable
    public final String o() {
        String V = d.a.m0.a.a2.e.V();
        if (TextUtils.isEmpty(V)) {
            return null;
        }
        return String.format("aigame_storage_%s_anonymous", V);
    }

    public String p(String str, String str2) {
        if (r()) {
            return this.f51165a.getString(str, str2);
        }
        return null;
    }

    public final boolean r() {
        return this.f51165a != null;
    }

    public long s() {
        return Config.FULL_TRACE_LOG_LIMIT;
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean t(String str, String str2) {
        return r() && this.f51165a.edit().putString(str, str2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean u(String str) {
        return r() && this.f51165a.edit().remove(str).commit();
    }
}
