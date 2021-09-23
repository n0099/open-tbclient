package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes10.dex */
public class fm implements Cloneable {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f77962a = "wcc-ml-test10.bj";

    /* renamed from: b  reason: collision with root package name */
    public static final String f77963b;

    /* renamed from: c  reason: collision with root package name */
    public static String f77964c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f410a;

    /* renamed from: a  reason: collision with other field name */
    public fp f411a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f412a;

    /* renamed from: b  reason: collision with other field name */
    public boolean f413b;

    /* renamed from: d  reason: collision with root package name */
    public String f77965d;

    /* renamed from: e  reason: collision with root package name */
    public String f77966e;

    /* renamed from: f  reason: collision with root package name */
    public String f77967f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56374695, "Lcom/xiaomi/push/fm;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56374695, "Lcom/xiaomi/push/fm;");
                return;
            }
        }
        f77963b = ae.f77657a;
        f77964c = null;
    }

    public fm(Map<String, Integer> map, int i2, String str, fp fpVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map, Integer.valueOf(i2), str, fpVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f412a = fl.f395a;
        this.f413b = true;
        a(map, i2, str, fpVar);
    }

    public static final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = f77964c;
            return str != null ? str : ab.m142a() ? "sandbox.xmpush.xiaomi.com" : ab.b() ? f77963b : "app.chat.xiaomi.net";
        }
        return (String) invokeV.objValue;
    }

    public static final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            f77964c = str;
        }
    }

    private void a(Map<String, Integer> map, int i2, String str, fp fpVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(InputDeviceCompat.SOURCE_TRACKBALL, this, map, i2, str, fpVar) == null) {
            this.f410a = i2;
            this.f77965d = str;
            this.f411a = fpVar;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public int mo331a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f410a : invokeV.intValue;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f412a = z;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m332a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f412a : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m333a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (byte[]) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f77967f : (String) invokeV.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f77967f = str;
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f77966e == null) {
                this.f77966e = a();
            }
            return this.f77966e;
        }
        return (String) invokeV.objValue;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f77966e = str;
        }
    }
}
