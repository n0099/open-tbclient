package d.a.i0.a.x0.a.d;

import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.i0.a.a1.e;
import d.a.i0.a.k2.b;
import d.a.i0.t.d;
import java.io.File;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static File f45572a = e.g();

    /* renamed from: b  reason: collision with root package name */
    public static String f45573b = "swan_core";

    /* renamed from: c  reason: collision with root package name */
    public static String f45574c = "extension_core";

    /* renamed from: d  reason: collision with root package name */
    public static String f45575d = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";

    /* renamed from: e  reason: collision with root package name */
    public static String f45576e = "cloneFolder_";

    /* renamed from: f  reason: collision with root package name */
    public static String f45577f = f45575d + File.separator + f45576e;

    /* renamed from: g  reason: collision with root package name */
    public static String f45578g = "clone_pkg_folder";

    /* renamed from: h  reason: collision with root package name */
    public static String f45579h = "clone_core_folder";

    /* renamed from: i  reason: collision with root package name */
    public static String f45580i = "clone_dynamic_lib_folder";
    public static String j = "clone_sp_folder";
    public static String k = "clone_db_folder";
    public static String l = "cloneZip.zip";
    public static String m = "clone_zipFiles";

    public static File a() {
        File file = new File(b.w());
        if (d.k(file)) {
            return file;
        }
        return null;
    }
}
