package d.a.h0.a.r0.a.d;

import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.h0.a.a2.b;
import d.a.h0.a.u0.d;
import java.io.File;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static File f43792a = d.d();

    /* renamed from: b  reason: collision with root package name */
    public static String f43793b = "swan_core";

    /* renamed from: c  reason: collision with root package name */
    public static String f43794c = "extension_core";

    /* renamed from: d  reason: collision with root package name */
    public static String f43795d = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";

    /* renamed from: e  reason: collision with root package name */
    public static String f43796e = "cloneFolder_";

    /* renamed from: f  reason: collision with root package name */
    public static String f43797f = f43795d + File.separator + f43796e;

    /* renamed from: g  reason: collision with root package name */
    public static String f43798g = "clone_pkg_folder";

    /* renamed from: h  reason: collision with root package name */
    public static String f43799h = "clone_core_folder";

    /* renamed from: i  reason: collision with root package name */
    public static String f43800i = "clone_dynamic_lib_folder";
    public static String j = "clone_sp_folder";
    public static String k = "clone_db_folder";
    public static String l = "cloneZip.zip";
    public static String m = "clone_zipFiles";

    public static File a() {
        File file = new File(b.g());
        if (d.a.h0.p.d.h(file)) {
            return file;
        }
        return null;
    }
}
