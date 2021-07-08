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
/* loaded from: classes6.dex */
public class fm implements Cloneable {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f40133a = "wcc-ml-test10.bj";

    /* renamed from: b  reason: collision with root package name */
    public static final String f40134b;

    /* renamed from: c  reason: collision with root package name */
    public static String f40135c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f406a;

    /* renamed from: a  reason: collision with other field name */
    public fp f407a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f408a;

    /* renamed from: b  reason: collision with other field name */
    public boolean f409b;

    /* renamed from: d  reason: collision with root package name */
    public String f40136d;

    /* renamed from: e  reason: collision with root package name */
    public String f40137e;

    /* renamed from: f  reason: collision with root package name */
    public String f40138f;

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
        f40134b = ae.f39834a;
        f40135c = null;
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
        this.f408a = fl.f391a;
        this.f409b = true;
        a(map, i2, str, fpVar);
    }

    public static final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = f40135c;
            return str != null ? str : ab.m139a() ? "sandbox.xmpush.xiaomi.com" : ab.b() ? f40134b : "app.chat.xiaomi.net";
        }
        return (String) invokeV.objValue;
    }

    public static final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            f40135c = str;
        }
    }

    private void a(Map<String, Integer> map, int i2, String str, fp fpVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(InputDeviceCompat.SOURCE_TRACKBALL, this, map, i2, str, fpVar) == null) {
            this.f406a = i2;
            this.f40136d = str;
            this.f407a = fpVar;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public int mo328a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f406a : invokeV.intValue;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f408a = z;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m329a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f408a : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m330a() {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f40138f : (String) invokeV.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f40138f = str;
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f40137e == null) {
                this.f40137e = a();
            }
            return this.f40137e;
        }
        return (String) invokeV.objValue;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f40137e = str;
        }
    }
}
