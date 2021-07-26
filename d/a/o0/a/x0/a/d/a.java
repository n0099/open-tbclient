package d.a.o0.a.x0.a.d;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.o0.a.a1.e;
import d.a.o0.a.k2.b;
import d.a.o0.t.d;
import java.io.File;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static File f48878a;

    /* renamed from: b  reason: collision with root package name */
    public static String f48879b;

    /* renamed from: c  reason: collision with root package name */
    public static String f48880c;

    /* renamed from: d  reason: collision with root package name */
    public static String f48881d;

    /* renamed from: e  reason: collision with root package name */
    public static String f48882e;

    /* renamed from: f  reason: collision with root package name */
    public static String f48883f;

    /* renamed from: g  reason: collision with root package name */
    public static String f48884g;

    /* renamed from: h  reason: collision with root package name */
    public static String f48885h;

    /* renamed from: i  reason: collision with root package name */
    public static String f48886i;
    public static String j;
    public static String k;
    public static String l;
    public static String m;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1286019347, "Ld/a/o0/a/x0/a/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1286019347, "Ld/a/o0/a/x0/a/d/a;");
                return;
            }
        }
        f48878a = e.g();
        f48879b = "swan_core";
        f48880c = "extension_core";
        f48881d = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
        f48882e = "cloneFolder_";
        f48883f = f48881d + File.separator + f48882e;
        f48884g = "clone_pkg_folder";
        f48885h = "clone_core_folder";
        f48886i = "clone_dynamic_lib_folder";
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
