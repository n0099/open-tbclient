package d.a.m0.a.h0.m.r;

import android.text.TextUtils;
import android.util.Log;
import d.a.m0.a.a1.e;
import d.a.m0.a.a1.h.a;
import d.a.m0.a.k;
import d.a.m0.n.h.g;
import d.a.m0.t.d;
import java.io.File;
import java.util.List;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46201a = k.f46983a;

    public static String a(String str) {
        return e(str, "swan_sub_package_zip");
    }

    public static String b(String str, String str2) {
        return a(e.C0620e.i(str, str2).getPath());
    }

    public static String c(String str) {
        return e(str, "swan_sub_package_zip");
    }

    public static String d(String str, String str2) {
        File a2 = d.a.m0.a.c1.b.g().a(str, str2);
        if (a2 != null) {
            return c(a2.getPath());
        }
        return null;
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
        return h(new File(gVar.f51788a), new File(e.C0620e.i(gVar.o, String.valueOf(gVar.f51796i)).getPath(), gVar.p));
    }

    public static boolean h(File file, File file2) {
        boolean T;
        if (file != null && file2 != null) {
            if (!file.exists()) {
                if (f46201a) {
                    Log.e("SubPkgDownloadUtil", "解压分包时，ZIP包不存在");
                }
                return false;
            } else if (!file2.exists() && !file2.mkdirs()) {
                if (f46201a) {
                    Log.e("SubPkgDownloadUtil", "创建分包解压文件夹失败");
                }
                return false;
            } else {
                a.b i2 = d.a.m0.a.a1.h.a.i(file);
                int i3 = i2.f44499b;
                if (i3 != -1) {
                    T = d.a.m0.a.a1.h.a.c(i2.f44498a, file2, i3).f44496a;
                } else {
                    T = d.T(file.getAbsolutePath(), file2.getAbsolutePath());
                }
                if (T) {
                    if (f46201a) {
                        Log.e("SubPkgDownloadUtil", "分包解压成功");
                        return true;
                    }
                    return true;
                } else if (f46201a) {
                    Log.e("SubPkgDownloadUtil", "分包解压文件失败, file:" + file.getAbsolutePath() + " folder:" + file2.getAbsolutePath());
                }
            }
        }
        return false;
    }
}
