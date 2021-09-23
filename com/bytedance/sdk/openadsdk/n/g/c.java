package com.bytedance.sdk.openadsdk.n.g;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.core.o;
import java.lang.reflect.Method;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static c f68608e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f68609a;

    /* renamed from: b  reason: collision with root package name */
    public Object f68610b;

    /* renamed from: c  reason: collision with root package name */
    public Method f68611c;

    /* renamed from: d  reason: collision with root package name */
    public Method f68612d;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68609a = null;
        this.f68610b = null;
        this.f68611c = null;
        this.f68612d = null;
        Context a2 = o.a();
        this.f68609a = a2;
        if (a2 != null) {
            Object systemService = a2.getSystemService("storage");
            this.f68610b = systemService;
            try {
                this.f68611c = systemService.getClass().getMethod("getVolumeList", new Class[0]);
                this.f68612d = this.f68610b.getClass().getMethod("getVolumeState", String.class);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f68608e == null) {
                synchronized (c.class) {
                    if (f68608e == null) {
                        f68608e = new c();
                    }
                }
            }
            return f68608e;
        }
        return (c) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Object obj = this.f68610b;
            if (obj != null && (method = this.f68611c) != null && this.f68612d != null) {
                try {
                    Object[] objArr = (Object[]) method.invoke(obj, new Object[0]);
                    if (objArr != null && objArr.length != 0) {
                        Method method2 = objArr[0].getClass().getMethod("getPath", new Class[0]);
                        Method method3 = objArr[0].getClass().getMethod("isEmulated", new Class[0]);
                        if (method2 != null && method3 != null) {
                            for (Object obj2 : objArr) {
                                if (((Boolean) method3.invoke(obj2, new Object[0])).booleanValue() && this.f68612d.invoke(this.f68610b, (String) method2.invoke(obj2, new Object[0])).equals("mounted")) {
                                    return true;
                                }
                            }
                        }
                    }
                    return false;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
