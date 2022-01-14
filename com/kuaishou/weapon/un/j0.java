package com.kuaishou.weapon.un;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes3.dex */
public class j0 {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static final String f55090b = "su";

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f55091c;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(534994666, "Lcom/kuaishou/weapon/un/j0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(534994666, "Lcom/kuaishou/weapon/un/j0;");
                return;
            }
        }
        f55091c = new String[]{u1.a("jMfC18KMz8zAws+M"), u1.a("jMfC18KMz8zAws+MwcrNjA=="), u1.a("jMfC18KMz8zAws+M28HKzYw="), u1.a("jNDBys2M"), u1.a("jNDWjMHKzYw="), u1.a("jNDa0NfGzozBys2M"), u1.a("jNDa0NfGzozBys2MxcLKz9DCxcaM"), u1.a("jNDa0NfGzozbwcrNjA==")};
    }

    public j0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    private String[] a(String[] strArr) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, strArr)) == null) {
            ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
            try {
                str = System.getenv("PATH");
            } catch (Exception unused) {
            }
            if (str != null && !"".equals(str)) {
                String[] split = str.split(":");
                int length = split.length;
                for (int i2 = 0; i2 < length; i2++) {
                    String str2 = split[i2];
                    if (!str2.endsWith("/")) {
                        str2 = str2 + '/';
                    }
                    if (!arrayList.contains(str2)) {
                        arrayList.add(str2);
                    }
                }
                return (String[]) arrayList.toArray(new String[0]);
            }
            return (String[]) arrayList.toArray(new String[0]);
        }
        return (String[]) invokeL.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                for (String str : a(f55091c)) {
                    if (new File(str, f55090b).exists()) {
                        return 1;
                    }
                }
                return 0;
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                return x0.a("su -v").replace(StringUtils.LF, "");
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String b2 = x0.b(u1.a("0cyNwsfBjdDGwNbRxg=="));
            return (b2 != null && "0".equals(b2)) ? 0 : 1;
        }
        return invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String b2 = x0.b(u1.a("0cyNx8bB1sTEwsHPxg=="));
            return (b2 != null && "0".equals(b2)) ? 0 : 1;
        }
        return invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String b2 = x0.b(u1.a("0cyN0MbA1tHG"));
            return (b2 != null && "0".equals(b2)) ? 0 : 1;
        }
        return invokeV.intValue;
    }
}
