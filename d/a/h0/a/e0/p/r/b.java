package d.a.h0.a.e0.p.r;

import android.text.TextUtils;
import android.util.Log;
import d.a.h0.a.k;
import d.a.h0.a.u0.d;
import d.a.h0.a.u0.g.a;
import d.a.h0.g.q.a;
import d.a.h0.l.k.g;
import java.io.File;
import java.util.List;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42260a = k.f43101a;

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
        return h(new File(gVar.f47147a), new File(d.e.h(gVar.o, String.valueOf(gVar.f47155i)).getPath(), gVar.p));
    }

    public static boolean h(File file, File file2) {
        boolean F;
        if (file != null && file2 != null) {
            if (!file.exists()) {
                if (f42260a) {
                    Log.e("SubPkgDownloadUtil", "解压分包时，ZIP包不存在");
                }
                return false;
            } else if (!file2.exists() && !file2.mkdirs()) {
                if (f42260a) {
                    Log.e("SubPkgDownloadUtil", "创建分包解压文件夹失败");
                }
                return false;
            } else {
                a.b f2 = d.a.h0.a.u0.g.a.f(file);
                int i2 = f2.f44753b;
                if (i2 != -1) {
                    F = d.a.h0.a.u0.g.a.a(f2.f44752a, file2, i2).f44750a;
                } else {
                    F = d.a.h0.p.d.F(file.getAbsolutePath(), file2.getAbsolutePath());
                }
                if (F) {
                    if (f42260a) {
                        Log.e("SubPkgDownloadUtil", "分包解压成功");
                        return true;
                    }
                    return true;
                } else if (f42260a) {
                    Log.e("SubPkgDownloadUtil", "分包解压文件失败, file:" + file.getAbsolutePath() + " folder:" + file2.getAbsolutePath());
                }
            }
        }
        return false;
    }
}
