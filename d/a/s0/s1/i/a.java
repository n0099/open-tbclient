package d.a.s0.s1.i;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
import java.util.Map;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, String> f65371a;
    public transient /* synthetic */ FieldHolder $fh;

    public static Map<String, String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (f65371a == null) {
                try {
                    Field declaredField = Class.forName("dalvik.system.VMRuntime").getDeclaredField("ABI_TO_INSTRUCTION_SET_MAP");
                    declaredField.setAccessible(true);
                    f65371a = (Map) declaredField.get(null);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return f65371a;
        }
        return (Map) invokeV.objValue;
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            try {
                ApplicationInfo.class.getField("primaryCpuAbi").set(((PackageInfo) Class.forName("android.webkit.WebViewFactory").getMethod("getLoadedPackageInfo", new Class[0]).invoke(null, new Object[0])).applicationInfo, str);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
