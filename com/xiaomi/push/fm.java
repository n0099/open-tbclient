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
/* loaded from: classes4.dex */
public class fm implements Cloneable {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "wcc-ml-test10.bj";

    /* renamed from: b  reason: collision with root package name */
    public static final String f61082b;

    /* renamed from: c  reason: collision with root package name */
    public static String f61083c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f411a;

    /* renamed from: a  reason: collision with other field name */
    public fp f412a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f413a;

    /* renamed from: b  reason: collision with other field name */
    public boolean f414b;

    /* renamed from: d  reason: collision with root package name */
    public String f61084d;

    /* renamed from: e  reason: collision with root package name */
    public String f61085e;

    /* renamed from: f  reason: collision with root package name */
    public String f61086f;

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
        f61082b = ae.a;
        f61083c = null;
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
        this.f413a = fl.f396a;
        this.f414b = true;
        a(map, i2, str, fpVar);
    }

    public static final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = f61083c;
            return str != null ? str : ab.m203a() ? "sandbox.xmpush.xiaomi.com" : ab.b() ? f61082b : "app.chat.xiaomi.net";
        }
        return (String) invokeV.objValue;
    }

    public static final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            f61083c = str;
        }
    }

    private void a(Map<String, Integer> map, int i2, String str, fp fpVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(InputDeviceCompat.SOURCE_TRACKBALL, this, map, i2, str, fpVar) == null) {
            this.f411a = i2;
            this.f61084d = str;
            this.f412a = fpVar;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public int mo392a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f411a : invokeV.intValue;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f413a = z;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m393a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f413a : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m394a() {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f61086f : (String) invokeV.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f61086f = str;
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f61085e == null) {
                this.f61085e = a();
            }
            return this.f61085e;
        }
        return (String) invokeV.objValue;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f61085e = str;
        }
    }
}
