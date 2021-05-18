package d.a.k0.r.a.j;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import d.a.k0.r.a.f.b;
import java.io.File;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static long f60244a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static String f60245b = "1";

    /* renamed from: c  reason: collision with root package name */
    public static String f60246c = "5";

    /* renamed from: d  reason: collision with root package name */
    public static String f60247d = "6";

    /* renamed from: e  reason: collision with root package name */
    public static String f60248e = "7";

    public static void a() {
        File file = new File(d.a.k0.r.a.i.a.f60237b);
        if (file.exists()) {
            FileHelper.deleteFileOrDir(file);
        }
    }

    public static void b(File file) {
        File[] listFiles;
        File file2 = new File(d.a.k0.r.a.i.a.f60237b);
        if (!file2.exists() || (listFiles = file2.listFiles()) == null) {
            return;
        }
        for (File file3 : listFiles) {
            if (file3 != null && !file3.equals(file)) {
                FileHelper.deleteFileOrDir(file3);
            }
        }
    }

    public static void c() {
        TbadkCoreApplication.getInst().getContext().getSharedPreferences("bc_splash_info_new", 0).edit().putString("bc_splash_info_new", "").apply();
    }

    public static String d() {
        return TbadkCoreApplication.getInst().getContext().getSharedPreferences("bc_splash_info_new", 0).getString("bc_splash_info_new", "");
    }

    public static boolean e() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - f60244a;
        if (0 >= j || j >= 500) {
            f60244a = currentTimeMillis;
            return false;
        }
        return true;
    }

    public static void f(AdInfo adInfo) {
        TbadkCoreApplication.getInst().getContext().getSharedPreferences("bc_splash_info_new", 0).edit().putString("bc_splash_info_new", b.a(adInfo).toString()).apply();
    }

    public static void g(b bVar) {
        if (bVar == null) {
            c();
        } else {
            TbadkCoreApplication.getInst().getContext().getSharedPreferences("bc_splash_info_new", 0).edit().putString("bc_splash_info_new", bVar.toString()).apply();
        }
    }

    public static void h(String str) {
        StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", str).param("obj_type", "a064").eventStat();
    }

    public static void i(String str, String str2, int i2) {
        StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", str).param("obj_type", "a064").param("obj_locate", str2).param(TiebaStatic.Params.RESOURCE_ID, Math.max(i2, 0)).eventStat();
    }

    public static void j(String str, String str2) {
        StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", str).param("obj_type", "a064").param("obj_locate", str2).eventStat();
    }
}
