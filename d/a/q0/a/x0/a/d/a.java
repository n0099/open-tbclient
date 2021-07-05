package d.a.q0.a.x0.a.d;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.q0.a.a1.e;
import d.a.q0.a.k2.b;
import d.a.q0.t.d;
import java.io.File;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static File f51676a;

    /* renamed from: b  reason: collision with root package name */
    public static String f51677b;

    /* renamed from: c  reason: collision with root package name */
    public static String f51678c;

    /* renamed from: d  reason: collision with root package name */
    public static String f51679d;

    /* renamed from: e  reason: collision with root package name */
    public static String f51680e;

    /* renamed from: f  reason: collision with root package name */
    public static String f51681f;

    /* renamed from: g  reason: collision with root package name */
    public static String f51682g;

    /* renamed from: h  reason: collision with root package name */
    public static String f51683h;

    /* renamed from: i  reason: collision with root package name */
    public static String f51684i;
    public static String j;
    public static String k;
    public static String l;
    public static String m;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(274902097, "Ld/a/q0/a/x0/a/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(274902097, "Ld/a/q0/a/x0/a/d/a;");
                return;
            }
        }
        f51676a = e.g();
        f51677b = "swan_core";
        f51678c = "extension_core";
        f51679d = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
        f51680e = "cloneFolder_";
        f51681f = f51679d + File.separator + f51680e;
        f51682g = "clone_pkg_folder";
        f51683h = "clone_core_folder";
        f51684i = "clone_dynamic_lib_folder";
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
