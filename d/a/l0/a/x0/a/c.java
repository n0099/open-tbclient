package d.a.l0.a.x0.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.ActivityChooserModel;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.database.SwanAppDbControl;
import d.a.l0.t.d;
import java.io.File;
/* loaded from: classes3.dex */
public class c {

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final c f45747a = new c();
    }

    public static c c() {
        return b.f45747a;
    }

    public final boolean a(File file, File file2) {
        if (file != null && file.exists() && file2 != null) {
            if (!file2.exists()) {
                d.k(file2);
            }
            String[] list = file.list();
            if (list != null && list.length != 0) {
                for (String str : list) {
                    if (!TextUtils.isEmpty(str)) {
                        File file3 = new File(file, str);
                        if (file3.exists()) {
                            boolean isFile = file3.isFile();
                            File file4 = new File(file2, str);
                            if (file4.exists()) {
                                d.i(file4);
                            }
                            if (isFile) {
                                d.h(file4);
                                d.f(file3, file4);
                            } else if (file3.isDirectory()) {
                                d.e(file3, file4);
                            }
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final boolean b(@NonNull File file) {
        if (file.exists() && file.isDirectory()) {
            File file2 = new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs/");
            File file3 = new File(d.a.l0.a.k2.h.c.A());
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                d.k(file2);
                d.k(file3);
                File file4 = null;
                for (File file5 : listFiles) {
                    String name = file5.getName();
                    if (!TextUtils.isEmpty(name)) {
                        if (name.endsWith(ActivityChooserModel.HISTORY_FILE_EXTENSION)) {
                            file4 = new File(file2, name);
                        } else if (name.endsWith(".kv")) {
                            file4 = new File(file3, name);
                        }
                        if (file4 != null) {
                            if (file4.exists()) {
                                d.K(file4);
                            }
                            if (file5.isFile()) {
                                d.h(file4);
                                d.f(file5, file4);
                            } else {
                                d.e(file5, file4);
                            }
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public boolean d(String str) {
        return true;
    }

    public boolean e(String str, File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        return a(new File(file, d.a.l0.a.x0.a.d.a.f45755h), d.a.l0.a.x0.a.d.a.f45748a);
    }

    public boolean f(String str, File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        boolean a2 = a(new File(file, d.a.l0.a.x0.a.d.a.k), new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "databases"));
        SwanAppDbControl.f(AppRuntime.getAppContext()).p();
        d.a.l0.n.g.e.a.a().c();
        d.a.l0.a.c1.a.Z().H();
        return a2;
    }

    public boolean g(String str, File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        return a(new File(file, d.a.l0.a.x0.a.d.a.f45756i), AppRuntime.getAppContext().getFilesDir());
    }

    public boolean h(String str, File file) {
        if (TextUtils.isEmpty(str) || file == null || !file.exists()) {
            return false;
        }
        return b(new File(file, d.a.l0.a.x0.a.d.a.j));
    }

    public boolean i(String str) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        d.a.l0.a.x0.a.a.n().p("installSwanApp start, appKey = " + str);
        File a2 = d.a.l0.a.x0.a.d.a.a();
        if (a2 != null && a2.exists()) {
            File file = new File(a2, d.a.l0.a.x0.a.d.a.m);
            if (!file.exists()) {
                d.a.l0.a.x0.a.a.n().p("installSwanApp clone_zipFiles file not exists");
                return false;
            }
            File a3 = d.a.l0.a.x0.a.b.a(d.F(file), a2);
            if (a3 != null && a3.exists()) {
                File file2 = new File(d.a.l0.a.x0.a.d.a.f45751d);
                if (file2.exists()) {
                    d.K(file2);
                }
                if (!d.k(file2)) {
                    d.a.l0.a.x0.a.a.n().p("installSwanApp root cache dir create fail");
                    return false;
                }
                boolean z = d.V(a3.getAbsolutePath(), d.a.l0.a.x0.a.d.a.f45751d) == null;
                if (z) {
                    d.i(file);
                    d.i(a3);
                }
                d.a.l0.a.x0.a.a.n().p("unzip file status = " + z);
                File file3 = new File(d.a.l0.a.x0.a.d.a.f45751d);
                String[] list = file3.list();
                if (list != null && list.length != 0) {
                    int length = list.length;
                    int i2 = 0;
                    while (true) {
                        str2 = null;
                        if (i2 >= length) {
                            str3 = null;
                            break;
                        }
                        String str4 = list[i2];
                        if (!TextUtils.isEmpty(str4) && str4.startsWith(d.a.l0.a.x0.a.d.a.f45752e)) {
                            str2 = str4.substring(d.a.l0.a.x0.a.d.a.f45752e.length());
                            str3 = str4;
                            break;
                        }
                        i2++;
                    }
                    if (TextUtils.equals(str, str2) && !TextUtils.isEmpty(str3)) {
                        File file4 = new File(d.a.l0.a.x0.a.d.a.f45751d, str3);
                        boolean j = j(str, file4);
                        boolean e2 = e(str, file4);
                        boolean h2 = h(str, file4);
                        boolean f2 = f(str, file4);
                        boolean d2 = d(str);
                        boolean g2 = g(str, file4);
                        d.a.l0.a.x0.a.a.n().p("installSwanPkg = " + j + " ; installCore = " + e2 + " ; installSp = " + h2 + " ; installDb = " + f2 + " ; installAbTest = " + d2 + " ; installDynamicLib = " + g2);
                        return d.i(file3);
                    }
                    d.a.l0.a.x0.a.a.n().p("installSwanApp install appKey not match zip file appKey");
                    return false;
                }
                d.a.l0.a.x0.a.a.n().p("installSwanApp unzip file length invalid");
                return false;
            }
            d.a.l0.a.x0.a.a.n().p("installSwanApp cloneZip.zip file not exists");
        }
        return false;
    }

    public boolean j(String str, File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        return a(new File(file, d.a.l0.a.x0.a.d.a.f45754g), d.a.l0.a.x0.a.d.a.f45748a);
    }

    public c() {
    }
}
