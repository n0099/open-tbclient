package d.b.g0.a.r0.a.d;

import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.g0.a.a2.b;
import d.b.g0.a.u0.d;
import java.io.File;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static File f46103a = d.d();

    /* renamed from: b  reason: collision with root package name */
    public static String f46104b = "swan_core";

    /* renamed from: c  reason: collision with root package name */
    public static String f46105c = "extension_core";

    /* renamed from: d  reason: collision with root package name */
    public static String f46106d = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";

    /* renamed from: e  reason: collision with root package name */
    public static String f46107e = "cloneFolder_";

    /* renamed from: f  reason: collision with root package name */
    public static String f46108f = f46106d + File.separator + f46107e;

    /* renamed from: g  reason: collision with root package name */
    public static String f46109g = "clone_pkg_folder";

    /* renamed from: h  reason: collision with root package name */
    public static String f46110h = "clone_core_folder";
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
