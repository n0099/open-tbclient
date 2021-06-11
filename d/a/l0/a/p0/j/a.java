package d.a.l0.a.p0.j;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import d.a.l0.a.k;
import d.a.l0.a.k2.g.h;
import d.a.l0.a.v1.c.c;
import d.a.l0.a.v1.c.f.e;
import d.a.l0.t.d;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47782a = k.f46875a;

    /* renamed from: d.a.l0.a.p0.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0855a implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return TextUtils.isDigitsOnly(str);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Comparator<File> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            long lastModified = file.lastModified();
            long lastModified2 = file2.lastModified();
            if (lastModified == lastModified2) {
                return 0;
            }
            return lastModified - lastModified2 > 0 ? -1 : 1;
        }
    }

    public static void a(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (!ProcessUtils.isMainProcess()) {
            d.a.l0.a.v1.c.a e2 = d.a.l0.a.v1.c.a.e();
            c cVar = new c(18, bundle);
            cVar.f(true);
            e2.h(cVar);
            return;
        }
        String string = bundle.getString("arg_dst_folder");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        b(new File(string), bundle.getLongArray("arg_ignore_vers"));
    }

    public static void b(File file, long... jArr) {
        File[] listFiles;
        if (!ProcessUtils.isMainProcess()) {
            Bundle bundle = new Bundle();
            bundle.putString("arg_dst_folder", file.getPath());
            if (jArr != null && jArr.length > 0) {
                bundle.putLongArray("arg_ignore_vers", jArr);
            }
            a(bundle);
        } else if (file != null && file.exists() && file.isDirectory()) {
            ArrayList arrayList = new ArrayList();
            if (jArr != null) {
                for (long j : jArr) {
                    if (j > 0) {
                        arrayList.add(Long.valueOf(j));
                    }
                }
            }
            arrayList.addAll(e());
            arrayList.addAll(d(file, 3));
            if (f47782a) {
                Log.d("ExtCore-Utils", "deleteOldExtensionCores dstFolder: " + file.getPath() + " ignoreVersions: " + Arrays.toString(arrayList.toArray()));
            }
            for (File file2 : file.listFiles()) {
                if (!g(file2, arrayList)) {
                    if (f47782a) {
                        Log.d("ExtCore-Utils", "deleteOldExtensionCores deleteFolder: " + file2);
                    }
                    d.K(file2);
                }
            }
        }
    }

    @NonNull
    public static String c(int i2) {
        return i2 == 1 ? "key_is_need_update_game_ext_preset" : "key_is_need_update_preset";
    }

    public static List<Long> d(File file, int i2) {
        File[] listFiles;
        ArrayList arrayList = new ArrayList();
        if (i2 <= 0 || file == null || !file.exists() || !file.isDirectory() || (listFiles = file.listFiles(new C0855a())) == null) {
            return arrayList;
        }
        Arrays.sort(listFiles, new b());
        int min = Math.min(listFiles.length, i2);
        for (int i3 = 0; i3 < min; i3++) {
            try {
                arrayList.add(Long.valueOf(Long.parseLong(listFiles[i3].getName())));
            } catch (NumberFormatException e2) {
                d.a.l0.a.e0.d.i("ExtCore-Utils", "get extension version fail", e2);
            }
        }
        return arrayList;
    }

    public static ArrayList<Long> e() {
        ExtensionCore a2;
        ArrayList<Long> arrayList = new ArrayList<>();
        for (d.a.l0.a.v1.c.f.c cVar : e.k().q()) {
            SwanAppCores n = cVar.n();
            if (n != null && cVar.H() && (a2 = n.a()) != null && !arrayList.contains(Long.valueOf(a2.extensionCoreVersionCode))) {
                arrayList.add(Long.valueOf(a2.extensionCoreVersionCode));
            }
        }
        if (f47782a) {
            Log.d("ExtCore-Utils", "SwanCoreVersion usedVersions: " + Arrays.toString(arrayList.toArray()));
        }
        return arrayList;
    }

    public static boolean f(int i2) {
        if (i2 == 1) {
            return d.a.l0.a.u1.a.a.y();
        }
        return d.a.l0.a.u1.a.a.x();
    }

    public static boolean g(File file, List<Long> list) {
        if (list == null) {
            return false;
        }
        String name = file.getName();
        for (Long l : list) {
            if (TextUtils.equals(name, String.valueOf(l.longValue()))) {
                return true;
            }
        }
        return false;
    }

    public static boolean h(int i2) {
        return h.a().getBoolean(c(i2), false);
    }

    public static void i(int i2, boolean z) {
        h.a().putBoolean(c(i2), z);
    }
}
