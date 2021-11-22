package com.sdk.base.framework.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public class k<T> implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f69093a = "com.sdk.base.framework.a.k";

    /* renamed from: b  reason: collision with root package name */
    public static final Boolean f69094b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public String f69095c;

    /* renamed from: d  reason: collision with root package name */
    public String f69096d;

    /* renamed from: e  reason: collision with root package name */
    public TreeMap<String, Object> f69097e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<File> f69098f;

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, Object> f69099g;

    /* renamed from: h  reason: collision with root package name */
    public int f69100h;

    /* renamed from: i  reason: collision with root package name */
    public com.sdk.base.framework.b.b<T> f69101i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1040379298, "Lcom/sdk/base/framework/a/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1040379298, "Lcom/sdk/base/framework/a/k;");
                return;
            }
        }
        f69094b = Boolean.valueOf(com.sdk.base.framework.c.f.f69125b);
    }

    public k() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f69095c = j.f69084a.toString();
        this.f69100h = 0;
    }

    public static String b(TreeMap<String, Object> treeMap) {
        InterceptResult invokeL;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, treeMap)) == null) {
            if (treeMap != null) {
                try {
                    sb = new StringBuilder();
                    for (Map.Entry<String, Object> entry : treeMap.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value != null && com.sdk.base.framework.a.a.c.b(key).booleanValue()) {
                            String encode = URLEncoder.encode(value.toString(), "UTF-8");
                            boolean z = com.sdk.base.framework.c.f.f69128e;
                            sb.append(key);
                            sb.append("=");
                            sb.append(encode);
                            sb.append("&");
                        }
                    }
                    sb.deleteCharAt(sb.length() - 1);
                } catch (Exception e2) {
                    com.sdk.base.framework.a.a.c.b(f69093a, e2.getMessage(), f69094b);
                    throw new Exception("http请求参数出错");
                }
            } else {
                sb = null;
            }
            if (sb == null) {
                return null;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f69095c : (String) invokeV.objValue;
    }

    public final void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f69100h = i2;
        }
    }

    public final void a(com.sdk.base.framework.b.b<T> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f69101i = bVar;
        }
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && com.sdk.base.framework.a.a.c.b(str).booleanValue()) {
            this.f69095c = str;
        }
    }

    public final void a(ArrayList<File> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) {
            this.f69098f = arrayList;
        }
    }

    public final void a(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hashMap) == null) {
            this.f69099g = hashMap;
        }
    }

    public final void a(TreeMap<String, Object> treeMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, treeMap) == null) {
            this.f69097e = treeMap;
        }
    }

    public final ArrayList<File> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f69098f : (ArrayList) invokeV.objValue;
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f69096d = str;
        }
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ArrayList<File> arrayList = this.f69098f;
            return (arrayList == null || arrayList.size() == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f69096d : (String) invokeV.objValue;
    }

    public final TreeMap<String, Object> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f69097e : (TreeMap) invokeV.objValue;
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f69100h : invokeV.intValue;
    }

    public final com.sdk.base.framework.b.b<T> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f69101i : (com.sdk.base.framework.b.b) invokeV.objValue;
    }

    public final HashMap<String, Object> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f69099g : (HashMap) invokeV.objValue;
    }
}
