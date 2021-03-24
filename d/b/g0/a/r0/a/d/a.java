package d.b.g0.a.r0.a.d;

import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.g0.a.a2.b;
import d.b.g0.a.u0.d;
import java.io.File;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static File f45710a = d.d();

    /* renamed from: b  reason: collision with root package name */
    public static String f45711b = "swan_core";

    /* renamed from: c  reason: collision with root package name */
    public static String f45712c = "extension_core";

    /* renamed from: d  reason: collision with root package name */
    public static String f45713d = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";

    /* renamed from: e  reason: collision with root package name */
    public static String f45714e = "cloneFolder_";

    /* renamed from: f  reason: collision with root package name */
    public static String f45715f = f45713d + File.separator + f45714e;

    /* renamed from: g  reason: collision with root package name */
    public static String f45716g = "clone_pkg_folder";

    /* renamed from: h  reason: collision with root package name */
    public static String f45717h = "clone_core_folder";
    public static String i = "clone_dynamic_lib_folder";
    public static String j = "clone_sp_folder";
    public static String k = "clone_db_folder";
    public static String l = "cloneZip.zip";
    public static String m = "clone_zipFiles";

    public static File a() {
        File file = new File(b.g());
        if (d.b.g0.p.d.h(file)) {
            return file;
        }
        return null;
    }
}
