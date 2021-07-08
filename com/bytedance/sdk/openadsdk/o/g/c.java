package com.bytedance.sdk.openadsdk.o.g;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.core.o;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static c f31779e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f31780a;

    /* renamed from: b  reason: collision with root package name */
    public Object f31781b;

    /* renamed from: c  reason: collision with root package name */
    public Method f31782c;

    /* renamed from: d  reason: collision with root package name */
    public Method f31783d;

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
        this.f31780a = null;
        this.f31781b = null;
        this.f31782c = null;
        this.f31783d = null;
        Context a2 = o.a();
        this.f31780a = a2;
        if (a2 != null) {
            Object systemService = a2.getSystemService("storage");
            this.f31781b = systemService;
            try {
                this.f31782c = systemService.getClass().getMethod("getVolumeList", new Class[0]);
                this.f31783d = this.f31781b.getClass().getMethod("getVolumeState", String.class);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f31779e == null) {
                synchronized (c.class) {
                    if (f31779e == null) {
                        f31779e = new c();
                    }
                }
            }
            return f31779e;
        }
        return (c) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Object obj = this.f31781b;
            if (obj != null && (method = this.f31782c) != null && this.f31783d != null) {
                try {
                    Object[] objArr = (Object[]) method.invoke(obj, new Object[0]);
                    if (objArr != null && objArr.length != 0) {
                        Method method2 = objArr[0].getClass().getMethod("getPath", new Class[0]);
                        Method method3 = objArr[0].getClass().getMethod("isEmulated", new Class[0]);
                        if (method2 != null && method3 != null) {
                            for (Object obj2 : objArr) {
                                if (((Boolean) method3.invoke(obj2, new Object[0])).booleanValue() && this.f31783d.invoke(this.f31781b, (String) method2.invoke(obj2, new Object[0])).equals("mounted")) {
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
