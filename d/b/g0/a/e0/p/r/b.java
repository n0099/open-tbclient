package d.b.g0.a.e0.p.r;

import android.text.TextUtils;
import android.util.Log;
import d.b.g0.a.k;
import d.b.g0.a.u0.d;
import d.b.g0.a.u0.g.a;
import d.b.g0.g.q.a;
import d.b.g0.l.k.g;
import java.io.File;
import java.util.List;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44234a = k.f45051a;

    public static String a(String str) {
        return e(str, "swan_sub_package_zip");
    }

    public static String b(String str, String str2) {
        return a(d.e.h(str, str2).getPath());
    }

    public static String c(String str) {
        return e(str, "swan_sub_package_zip");
    }

    public static String d(String str, String str2) {
        return c(a.d.h(str, str2).getPath());
    }

    public static String e(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str, str2);
            if (file.exists()) {
                return file.getPath();
            }
            if (file.mkdirs()) {
                return file.getPath();
            }
        }
        return null;
    }

    public static boolean f(List<g> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        return list.get(0).r;
    }

    public static boolean g(g gVar) {
        if (gVar == null || TextUtils.isEmpty(gVar.o)) {
            return false;
        }
        return h(new File(gVar.f48917a), new File(d.e.h(gVar.o, String.valueOf(gVar.i)).getPath(), gVar.p));
    }

    public static boolean h(File file, File file2) {
        boolean F;
        if (file != null && file2 != null) {
            if (!file.exists()) {
                if (f44234a) {
                    Log.e("SubPkgDownloadUtil", "解压分包时，ZIP包不存在");
                }
                return false;
            } else if (!file2.exists() && !file2.mkdirs()) {
                if (f44234a) {
                    Log.e("SubPkgDownloadUtil", "创建分包解压文件夹失败");
                }
                return false;
            } else {
                a.b f2 = d.b.g0.a.u0.g.a.f(file);
                int i = f2.f46619b;
                if (i != -1) {
                    F = d.b.g0.a.u0.g.a.a(f2.f46618a, file2, i).f46616a;
                } else {
                    F = d.b.g0.p.d.F(file.getAbsolutePath(), file2.getAbsolutePath());
                }
                if (F) {
                    if (f44234a) {
                        Log.e("SubPkgDownloadUtil", "分包解压成功");
                        return true;
                    }
                    return true;
                } else if (f44234a) {
                    Log.e("SubPkgDownloadUtil", "分包解压文件失败, file:" + file.getAbsolutePath() + " folder:" + file2.getAbsolutePath());
                }
            }
        }
        return false;
    }
}
