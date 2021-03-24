package d.b.g0.a.l0.k;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import d.b.g0.a.a2.g.h;
import d.b.g0.a.b2.b;
import d.b.g0.a.k;
import d.b.g0.a.n1.c.c;
import d.b.g0.a.n1.c.f.e;
import d.b.g0.p.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45168a = k.f45050a;

    public static void a(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (!ProcessUtils.isMainProcess()) {
            d.b.g0.a.n1.c.a e2 = d.b.g0.a.n1.c.a.e();
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
            arrayList.addAll(d());
            if (f45168a) {
                Log.d("ExtCore-Utils", "deleteOldExtensionCores dstFolder: " + file.getPath() + " ignoreVersions: " + Arrays.toString(arrayList.toArray()));
            }
            for (File file2 : file.listFiles()) {
                if (!h(file2, arrayList)) {
                    if (f45168a) {
                        Log.d("ExtCore-Utils", "deleteOldExtensionCores deleteFolder: " + file2);
                    }
                    d.f(file2);
                }
            }
        }
    }

    @NonNull
    public static String c(int i) {
        return i == 1 ? "key_is_need_update_game_ext_preset" : "key_is_need_update_preset";
    }

    public static ArrayList<Long> d() {
        ExtensionCore a2;
        ArrayList<Long> arrayList = new ArrayList<>();
        for (d.b.g0.a.n1.c.f.c cVar : e.j().p()) {
            SwanAppCores k = cVar.k();
            if (k != null && cVar.D() && (a2 = k.a()) != null && !arrayList.contains(Long.valueOf(a2.extensionCoreVersionCode))) {
                arrayList.add(Long.valueOf(a2.extensionCoreVersionCode));
            }
        }
        if (f45168a) {
            Log.d("ExtCore-Utils", "SwanCoreVersion usedVersions: " + Arrays.toString(arrayList.toArray()));
        }
        return arrayList;
    }

    public static long e(@Nullable String str) {
        String[] k = k(str);
        if (k == null) {
            return 0L;
        }
        int i = 0;
        long j = 0;
        while (i < 3) {
            try {
                j = (j << 16) | (i < k.length ? Integer.valueOf(k[i]).intValue() : 0L);
                i++;
            } catch (NumberFormatException e2) {
                if (f45168a) {
                    throw e2;
                }
                return 0L;
            }
        }
        if (f45168a) {
            Log.d("ExtCore-Utils", "getVersionCode versionName: " + str + " ,versionCode: " + j);
        }
        return j;
    }

    public static String f(long j) {
        return b.q(j);
    }

    public static boolean g(int i) {
        if (i == 1) {
            return d.b.g0.a.m1.a.a.w();
        }
        return d.b.g0.a.m1.a.a.v();
    }

    public static boolean h(File file, List<Long> list) {
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

    public static boolean i(int i) {
        return h.a().getBoolean(c(i), false);
    }

    public static void j(int i, boolean z) {
        h.a().putBoolean(c(i), z);
    }

    public static String[] k(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
        if (split.length == 0 || split.length != 3) {
            return null;
        }
        return split;
    }
}
