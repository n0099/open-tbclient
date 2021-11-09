package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class ae {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile ae f70585a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f64a;

    /* renamed from: a  reason: collision with other field name */
    public List<w> f65a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1871206941, "Lcom/xiaomi/mipush/sdk/ae;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1871206941, "Lcom/xiaomi/mipush/sdk/ae;");
        }
    }

    public ae(Context context) {
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
        this.f65a = new ArrayList();
        Context applicationContext = context.getApplicationContext();
        this.f64a = applicationContext;
        if (applicationContext == null) {
            this.f64a = context;
        }
    }

    public static ae a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f70585a == null) {
                synchronized (ae.class) {
                    if (f70585a == null) {
                        f70585a = new ae(context);
                    }
                }
            }
            return f70585a;
        }
        return (ae) invokeL.objValue;
    }

    public int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this.f65a) {
                w wVar = new w();
                wVar.f103a = str;
                if (this.f65a.contains(wVar)) {
                    for (w wVar2 : this.f65a) {
                        if (wVar2.equals(wVar)) {
                            return wVar2.f70642a;
                        }
                    }
                }
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public synchronized String a(at atVar) {
        InterceptResult invokeL;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, atVar)) == null) {
            synchronized (this) {
                string = this.f64a.getSharedPreferences("mipush_extra", 0).getString(atVar.name(), "");
            }
            return string;
        }
        return (String) invokeL.objValue;
    }

    public synchronized void a(at atVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, atVar, str) == null) {
            synchronized (this) {
                SharedPreferences sharedPreferences = this.f64a.getSharedPreferences("mipush_extra", 0);
                sharedPreferences.edit().putString(atVar.name(), str).commit();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m93a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            synchronized (this.f65a) {
                w wVar = new w();
                wVar.f70642a = 0;
                wVar.f103a = str;
                if (this.f65a.contains(wVar)) {
                    this.f65a.remove(wVar);
                }
                this.f65a.add(wVar);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m94a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            synchronized (this.f65a) {
                w wVar = new w();
                wVar.f103a = str;
                return this.f65a.contains(wVar);
            }
        }
        return invokeL.booleanValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            synchronized (this.f65a) {
                w wVar = new w();
                wVar.f103a = str;
                if (this.f65a.contains(wVar)) {
                    Iterator<w> it = this.f65a.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        w next = it.next();
                        if (wVar.equals(next)) {
                            wVar = next;
                            break;
                        }
                    }
                }
                wVar.f70642a++;
                this.f65a.remove(wVar);
                this.f65a.add(wVar);
            }
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            synchronized (this.f65a) {
                w wVar = new w();
                wVar.f103a = str;
                if (this.f65a.contains(wVar)) {
                    this.f65a.remove(wVar);
                }
            }
        }
    }
}
