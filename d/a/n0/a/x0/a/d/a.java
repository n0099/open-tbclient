package d.a.n0.a.x0.a.d;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.n0.a.a1.e;
import d.a.n0.a.k2.b;
import d.a.n0.t.d;
import java.io.File;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static File f48374a;

    /* renamed from: b  reason: collision with root package name */
    public static String f48375b;

    /* renamed from: c  reason: collision with root package name */
    public static String f48376c;

    /* renamed from: d  reason: collision with root package name */
    public static String f48377d;

    /* renamed from: e  reason: collision with root package name */
    public static String f48378e;

    /* renamed from: f  reason: collision with root package name */
    public static String f48379f;

    /* renamed from: g  reason: collision with root package name */
    public static String f48380g;

    /* renamed from: h  reason: collision with root package name */
    public static String f48381h;

    /* renamed from: i  reason: collision with root package name */
    public static String f48382i;
    public static String j;
    public static String k;
    public static String l;
    public static String m;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1791577972, "Ld/a/n0/a/x0/a/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1791577972, "Ld/a/n0/a/x0/a/d/a;");
                return;
            }
        }
        f48374a = e.g();
        f48375b = "swan_core";
        f48376c = "extension_core";
        f48377d = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
        f48378e = "cloneFolder_";
        f48379f = f48377d + File.separator + f48378e;
        f48380g = "clone_pkg_folder";
        f48381h = "clone_core_folder";
        f48382i = "clone_dynamic_lib_folder";
        j = "clone_sp_folder";
        k = "clone_db_folder";
        l = "cloneZip.zip";
        m = "clone_zipFiles";
    }

    public static File a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            File file = new File(b.w());
            if (d.k(file)) {
                return file;
            }
            return null;
        }
        return (File) invokeV.objValue;
    }
}
