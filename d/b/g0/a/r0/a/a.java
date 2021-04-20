package d.b.g0.a.r0.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserModel;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.QuickPersistConfig;
import d.b.g0.a.k;
import d.b.g0.a.p.c.w;
import d.b.g0.g.l.n;
import d.b.g0.p.d;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46096a = k.f45443a;

    /* renamed from: d.b.g0.a.r0.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0787a implements w.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ File f46097a;

        public C0787a(File file) {
            this.f46097a = file;
        }

        @Override // d.b.g0.a.p.c.w.a
        public void onResult(String str) {
            if (!k.f45443a) {
                d.w(this.f46097a);
            }
            a aVar = a.this;
            aVar.p("upload file: done. feedback data = " + str);
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f46099a = new a(null);
    }

    public /* synthetic */ a(C0787a c0787a) {
        this();
    }

    public static a n() {
        return b.f46099a;
    }

    public boolean a(String str) {
        return true;
    }

    public boolean b(String str, File file) {
        File q = q(str, file, d.b.g0.a.r0.a.d.a.f46110h);
        if (q == null) {
            return false;
        }
        File file2 = new File(d.b.g0.a.r0.a.d.a.f46103a, str);
        if (file2.exists()) {
            File file3 = new File(q, str);
            d.h(file3);
            d.b(file2, file3);
            return true;
        }
        return false;
    }

    public boolean c(String str, File file) {
        File q = q(str, file, d.b.g0.a.r0.a.d.a.k);
        if (q == null) {
            return false;
        }
        j("ai_apps.db", q);
        j("ai_apps_pms.db", q);
        return true;
    }

    public boolean d(String str, File file) {
        File q = q(str, new File(file, d.b.g0.a.r0.a.d.a.i), "swan_plugin_workspace");
        if (q == null) {
            return false;
        }
        File j = d.b.g0.a.u0.d.j();
        if (j.exists()) {
            d.b(j, q);
            return false;
        }
        return false;
    }

    public boolean e(Context context, String str, File file) {
        File q = q(str, file, d.b.g0.a.r0.a.d.a.j);
        if (context == null || q == null) {
            return false;
        }
        return m(context, str, q, new File(AppRuntime.getAppContext().getFilesDir(), "swan_prefs"), ".kv") | m(context, str, q, new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs/"), ActivityChooserModel.HISTORY_FILE_EXTENSION);
    }

    public void f(Context context, String str) {
        p("cloneSwanApp: start");
        r(h(context, str), str);
        p("cloneSwanApp: end");
    }

    public final void g(Context context, String str, File file) {
        boolean i = i(str, file);
        boolean b2 = b(d.b.g0.a.r0.a.d.a.f46104b, file);
        boolean b3 = b(d.b.g0.a.r0.a.d.a.f46105c, file);
        boolean e2 = e(context, str, file);
        boolean c2 = c(str, file);
        boolean a2 = a(str);
        boolean d2 = d(str, file);
        p("cloneSwanPkg = " + i + " ; cloneSwanCore = " + b2 + " ; cloneExtensionCore = " + b3 + " ; cloneSp = " + e2 + " ; cloneDb = " + c2 + " ; cloneAbTest = " + a2 + " ; cloneDynamicLib = " + d2);
    }

    public File h(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            p("appKey is empty");
            return null;
        }
        p("cloneFilesAndMakeZip start, appKey = " + str);
        File file = new File(d.b.g0.a.r0.a.d.a.f46108f + str);
        if (!l(file)) {
            p("delete old tmp dir failed");
            return null;
        }
        File a2 = d.b.g0.a.r0.a.d.a.a();
        if (a2 == null) {
            p("dest zip dir is null");
            return null;
        }
        File file2 = new File(a2, d.b.g0.a.r0.a.d.a.l);
        if (file2.exists()) {
            d.w(file2);
        }
        d.e(file2);
        g(context, str, file);
        o(file.getParentFile(), file2);
        p("cloneFilesAndMakeZip end, appKey = " + str);
        return file2;
    }

    public boolean i(String str, File file) {
        File q = q(str, file, d.b.g0.a.r0.a.d.a.f46109g);
        if (q == null) {
            return false;
        }
        File file2 = new File(d.b.g0.a.r0.a.d.a.f46103a, str);
        if (file2.exists()) {
            File file3 = new File(q, str);
            d.h(file3);
            d.b(file2, file3);
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
            d.c(databasePath, new File(file, str));
        }
    }

    public final void k(String str, File file, File file2, String str2) {
        if (TextUtils.isEmpty(str) || file == null || !file.exists() || file2 == null || !file2.exists()) {
            return;
        }
        String str3 = str + str2;
        File file3 = new File(file, str3);
        if (file3.exists()) {
            d.c(file3, new File(file2, str3));
        }
    }

    public boolean l(File file) {
        if (file == null) {
            return false;
        }
        d.f(file);
        return d.h(file);
    }

    public final boolean m(@NonNull Context context, @NonNull String str, @NonNull File file, @Nullable File file2, @NonNull String str2) {
        if (file2 != null && file2.exists() && file2.isDirectory()) {
            String[] strArr = {"aiapp_" + str, "aiapp_setting_" + str, "searchbox_webapps_sp", "searchbox_sconsole_sp", "aiapp_open_stat", QuickPersistConfig.SP_FILE_STARTUP, "com.baidu.searchbox_aiapp_openstat", "aiapps_favorite", "aiapps_guide_dialog_sp", "key_pms_sp_name", context.getPackageName() + "_preferences", "abtesting"};
            for (int i = 0; i < 12; i++) {
                k(strArr[i], file2, file, str2);
            }
            return true;
        }
        return false;
    }

    public final void o(File file, File file2) {
        boolean a0 = n.a0(file.getAbsolutePath(), file2.getAbsolutePath());
        if (a0) {
            d.f(file);
        }
        p("zip file status = " + a0);
    }

    public void p(String str) {
        if (TextUtils.isEmpty(str) || !f46096a) {
            return;
        }
        Log.d("SwanAppCloneModule", str);
    }

    public File q(String str, File file, String str2) {
        if (TextUtils.isEmpty(str) || file == null || TextUtils.isEmpty(str2)) {
            return null;
        }
        File file2 = new File(file, str2);
        if (d.h(file2)) {
            return file2;
        }
        return null;
    }

    public boolean r(File file, String str) {
        String[] list;
        if (file != null && file.exists()) {
            File file2 = new File(d.b.g0.a.r0.a.d.a.f46103a, str);
            String str2 = (!file2.exists() || (list = file2.list()) == null || list.length <= 0) ? "-1" : list[0];
            p("upload file: ready");
            w q = d.b.g0.a.w0.a.q();
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("aiappid", str);
            hashMap.put("aiappversion", str2);
            q.c(hashMap, file, new C0787a(file));
            return true;
        }
        p("no zip file");
        return false;
    }

    public a() {
    }
}
