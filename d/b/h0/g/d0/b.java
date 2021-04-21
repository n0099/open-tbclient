package d.b.h0.g.d0;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserModel;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.h0.a.f2.c;
import d.b.h0.a.f2.d;
import d.b.h0.a.k;
import d.b.h0.a.r1.e;
import java.io.File;
import java.util.Set;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f48804c = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f48805a;

    /* renamed from: b  reason: collision with root package name */
    public File f48806b;

    /* loaded from: classes3.dex */
    public class a implements c.a<Long> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.f2.c.a
        /* renamed from: a */
        public Long update() throws IllegalStateException {
            return Long.valueOf(b.this.e());
        }
    }

    public b() {
        String g2 = g();
        if (f48804c) {
            Log.i("SwanGameStorageManager", "preferencesName:" + g2);
        }
        if (g2 != null) {
            this.f48805a = d.b.h0.a.w0.a.c().getSharedPreferences(g2, 0);
            File i = i();
            this.f48806b = new File(i, g2 + ActivityChooserModel.HISTORY_FILE_EXTENSION);
        }
        d.f45188h.e(new a());
    }

    public static void b() {
        d("aigame_storage_");
    }

    public static void c(String str) {
        d(String.format("aigame_storage_%s_anonymous", str, ""));
    }

    public static void d(String str) {
        File[] listFiles;
        if (str == null || !str.startsWith("aigame_storage_") || (listFiles = i().listFiles()) == null) {
            return;
        }
        for (File file : listFiles) {
            if (file.getName().startsWith(str)) {
                file.delete();
            }
        }
    }

    @NonNull
    public static File i() {
        return new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs");
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean a() {
        return j() && this.f48805a.edit().clear().commit();
    }

    public long e() {
        File file = this.f48806b;
        if (file != null) {
            return file.length();
        }
        return 0L;
    }

    public String[] f() {
        if (j()) {
            Set<String> keySet = this.f48805a.getAll().keySet();
            String[] strArr = new String[keySet.size()];
            keySet.toArray(strArr);
            return strArr;
        }
        return new String[0];
    }

    @Nullable
    public final String g() {
        String T = e.T();
        if (TextUtils.isEmpty(T)) {
            return null;
        }
        return String.format("aigame_storage_%s_anonymous", T);
    }

    public String h(String str, String str2) {
        if (j()) {
            return this.f48805a.getString(str, str2);
        }
        return null;
    }

    public final boolean j() {
        return this.f48805a != null;
    }

    public long k() {
        return Config.FULL_TRACE_LOG_LIMIT;
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean l(String str, String str2) {
        return j() && this.f48805a.edit().putString(str, str2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean m(String str) {
        return j() && this.f48805a.edit().remove(str).commit();
    }
}
