package d.a.z0.e;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<Integer> f71608a;

    /* renamed from: b  reason: collision with root package name */
    public static String f71609b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(372887063, "Ld/a/z0/e/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(372887063, "Ld/a/z0/e/b;");
                return;
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>(4);
        f71608a = arrayList;
        arrayList.add(10000);
        f71608a.add(10001);
        f71608a.add(10002);
        f71608a.add(20001);
        f71608a.add(-1);
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (TextUtils.isEmpty(f71609b)) {
                f71609b = d.a.z0.e.h.d.a();
            }
            if (TextUtils.isEmpty(f71609b)) {
                return 20001;
            }
            if (f71609b.toUpperCase().contains("HUAWEI")) {
                return 10001;
            }
            return f71609b.toUpperCase().contains("XIAOMI") ? 10002 : 20001;
        }
        return invokeV.intValue;
    }
}
