package d.a.r0.b.g;

import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.r0.b.d;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f54803a = "key_user_last_access_tab_";

    /* renamed from: b  reason: collision with root package name */
    public static String f54804b = "key_frs_new_area_tab_sort_";

    /* renamed from: c  reason: collision with root package name */
    public static int f54805c = Integer.MAX_VALUE;

    /* renamed from: d  reason: collision with root package name */
    public static final String f54806d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f54807e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-943798469, "Ld/a/r0/b/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-943798469, "Ld/a/r0/b/g/a;");
                return;
            }
        }
        f54806d = TbadkCoreApplication.getInst().getString(R.string.frs_hot_tab_name);
        f54807e = TbadkCoreApplication.getInst().getString(R.string.frs_new_area_tab_name);
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return f54804b + TbadkCoreApplication.getCurrentAccount();
        }
        return (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return f54803a + TbadkCoreApplication.getCurrentAccount();
        }
        return (String) invokeV.objValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (d.p()) {
                return 1;
            }
            if (d.q()) {
                return 503;
            }
            if (d.r()) {
                return h(e());
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? d.a.r0.r.d0.b.j().k(a(), f54805c) : invokeV.intValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? d.a.r0.r.d0.b.j().p(b(), f54806d) : (String) invokeV.objValue;
    }

    public static void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2) == null) {
            d.a.r0.r.d0.b.j().v(a(), i2);
        }
    }

    public static void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            if (f54806d.equals(str) || f54807e.equals(str)) {
                d.a.r0.r.d0.b.j().x(b(), str);
            }
        }
    }

    public static int h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? (!f54806d.equals(str) && f54807e.equals(str)) ? 503 : 1 : invokeL.intValue;
    }
}
