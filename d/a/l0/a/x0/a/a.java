package d.a.l0.a.x0.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserModel;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.QuickPersistConfig;
import d.a.l0.a.a1.e;
import d.a.l0.a.k;
import d.a.l0.a.p.d.e0;
import d.a.l0.t.d;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49415a = k.f46875a;

    /* renamed from: d.a.l0.a.x0.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0959a implements e0.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ File f49416a;

        public C0959a(File file) {
            this.f49416a = file;
        }

        @Override // d.a.l0.a.p.d.e0.a
        public void onResult(String str) {
            if (!k.f46875a) {
                d.K(this.f49416a);
            }
            a aVar = a.this;
            aVar.p("upload file: done. feedback data = " + str);
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f49418a = new a(null);
    }

    public /* synthetic */ a(C0959a c0959a) {
        this();
    }

    public static a n() {
        return b.f49418a;
    }

    public boolean a(String str) {
        return true;
    }

    public boolean b(String str, File file) {
        File q = q(str, file, d.a.l0.a.x0.a.d.a.f49429h);
        if (q == null) {
            return false;
        }
        File file2 = new File(d.a.l0.a.x0.a.d.a.f49422a, str);
        if (file2.exists()) {
            File file3 = new File(q, str);
            d.k(file3);
            d.e(file2, file3);
            return true;
        }
        return false;
    }

    public boolean c(String str, File file) {
        File q = q(str, file, d.a.l0.a.x0.a.d.a.k);
        if (q == null) {
            return false;
        }
        j("ai_apps.db", q);
        j("ai_apps_pms.db", q);
        return true;
    }

    public boolean d(String str, File file) {
        File q = q(str, new File(file, d.a.l0.a.x0.a.d.a.f49430i), "swan_plugin_workspace");
        if (q == null) {
            return false;
        }
        File q2 = e.q();
        if (q2.exists()) {
            d.e(q2, q);
            return false;
        }
        return false;
    }

    public boolean e(Context context, String str, File file) {
        File q = q(str, file, d.a.l0.a.x0.a.d.a.j);
        if (context == null || q == null) {
            return false;
        }
        return m(context, str, q, new File(d.a.l0.a.k2.h.c.A()), ".kv") | m(context, str, q, new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs/"), ActivityChooserModel.HISTORY_FILE_EXTENSION);
    }

    public void f(Context context, String str) {
        p("cloneSwanApp: start");
        r(h(context, str), str);
        p("cloneSwanApp: end");
    }

    public final void g(Context context, String str, File file) {
        boolean i2 = i(str, file);
        boolean b2 = b(d.a.l0.a.x0.a.d.a.f49423b, file);
        boolean b3 = b(d.a.l0.a.x0.a.d.a.f49424c, file);
        boolean e2 = e(context, str, file);
        boolean c2 = c(str, file);
        boolean a2 = a(str);
        boolean d2 = d(str, file);
        p("cloneSwanPkg = " + i2 + " ; cloneSwanCore = " + b2 + " ; cloneExtensionCore = " + b3 + " ; cloneSp = " + e2 + " ; cloneDb = " + c2 + " ; cloneAbTest = " + a2 + " ; cloneDynamicLib = " + d2);
    }

    public File h(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            p("appKey is empty");
            return null;
        }
        p("cloneFilesAndMakeZip start, appKey = " + str);
        File file = new File(d.a.l0.a.x0.a.d.a.f49427f + str);
        if (!l(file)) {
            p("delete old tmp dir failed");
            return null;
        }
        File a2 = d.a.l0.a.x0.a.d.a.a();
        if (a2 == null) {
            p("dest zip dir is null");
            return null;
        }
        File file2 = new File(a2, d.a.l0.a.x0.a.d.a.l);
        if (file2.exists()) {
            d.K(file2);
        }
        d.h(file2);
        g(context, str, file);
        o(file.getParentFile(), file2);
        p("cloneFilesAndMakeZip end, appKey = " + str);
        return file2;
    }

    public boolean i(String str, File file) {
        File q = q(str, file, d.a.l0.a.x0.a.d.a.f49428g);
        if (q == null) {
            return false;
        }
        File file2 = new File(d.a.l0.a.x0.a.d.a.f49422a, str);
        if (file2.exists()) {
            File file3 = new File(q, str);
            d.k(file3);
            d.e(file2, file3);
            return true;
        }
        return false;
    }

    public final void j(String str, File file) {
        if (TextUtils.isEmpty(str) || file == null || !file.exists()) {
            return;
        }
        File databasePath = AppRuntime.getApplication().getDatabasePath(str);
        if (databasePath.exists()) {
            d.f(databasePath, new File(file, str));
        }
    }

    public final void k(String str, File file, File file2, String str2) {
        if (TextUtils.isEmpty(str) || file == null || !file.exists() || file2 == null || !file2.exists()) {
            return;
        }
        String str3 = str + str2;
        File file3 = new File(file, str3);
        if (file3.exists()) {
            d.f(file3, new File(file2, str3));
        }
    }

    public boolean l(File file) {
        if (file == null) {
            return false;
        }
        d.i(file);
        return d.k(file);
    }

    public final boolean m(@NonNull Context context, @NonNull String str, @NonNull File file, @Nullable File file2, @NonNull String str2) {
        if (file2 != null && file2.exists() && file2.isDirectory()) {
            String[] strArr = {"aiapp_" + str, "aiapp_setting_" + str, "searchbox_webapps_sp", "searchbox_sconsole_sp", "aiapp_open_stat", QuickPersistConfig.SP_FILE_STARTUP, "com.baidu.searchbox_aiapp_openstat", "aiapps_favorite", "aiapps_guide_dialog_sp", "key_pms_sp_name", context.getPackageName() + "_preferences", "abtesting"};
            for (int i2 = 0; i2 < 12; i2++) {
                k(strArr[i2], file2, file, str2);
            }
            return true;
        }
        return false;
    }

    public final void o(File file, File file2) {
        boolean W = d.W(file.getAbsolutePath(), file2.getAbsolutePath());
        if (W) {
            d.i(file);
        }
        p("zip file status = " + W);
    }

    public void p(String str) {
        if (TextUtils.isEmpty(str) || !f49415a) {
            return;
        }
        Log.d("SwanAppCloneModule", str);
    }

    public File q(String str, File file, String str2) {
        if (TextUtils.isEmpty(str) || file == null || TextUtils.isEmpty(str2)) {
            return null;
        }
        File file2 = new File(file, str2);
        if (d.k(file2)) {
            return file2;
        }
        return null;
    }

    public boolean r(File file, String str) {
        String[] list;
        if (file != null && file.exists()) {
            File file2 = new File(d.a.l0.a.x0.a.d.a.f49422a, str);
            String str2 = (!file2.exists() || (list = file2.list()) == null || list.length <= 0) ? "-1" : list[0];
            p("upload file: ready");
            e0 t = d.a.l0.a.c1.a.t();
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("aiappid", str);
            hashMap.put("aiappversion", str2);
            t.c(hashMap, file, new C0959a(file));
            return true;
        }
        p("no zip file");
        return false;
    }

    public a() {
    }
}
