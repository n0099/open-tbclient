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
/* loaded from: classes8.dex */
public class af {
    public static /* synthetic */ Interceptable $ic;
    public static volatile af a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f41a;

    /* renamed from: a  reason: collision with other field name */
    public List<x> f42a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1871206910, "Lcom/xiaomi/mipush/sdk/af;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1871206910, "Lcom/xiaomi/mipush/sdk/af;");
        }
    }

    public af(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f42a = new ArrayList();
        Context applicationContext = context.getApplicationContext();
        this.f41a = applicationContext;
        if (applicationContext == null) {
            this.f41a = context;
        }
    }

    public static af a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (a == null) {
                synchronized (af.class) {
                    if (a == null) {
                        a = new af(context);
                    }
                }
            }
            return a;
        }
        return (af) invokeL.objValue;
    }

    public int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this.f42a) {
                x xVar = new x();
                xVar.f81a = str;
                if (this.f42a.contains(xVar)) {
                    for (x xVar2 : this.f42a) {
                        if (xVar2.equals(xVar)) {
                            return xVar2.a;
                        }
                    }
                }
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public synchronized String a(au auVar) {
        InterceptResult invokeL;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, auVar)) == null) {
            synchronized (this) {
                string = this.f41a.getSharedPreferences("mipush_extra", 0).getString(auVar.name(), "");
            }
            return string;
        }
        return (String) invokeL.objValue;
    }

    public synchronized void a(au auVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, auVar, str) == null) {
            synchronized (this) {
                SharedPreferences sharedPreferences = this.f41a.getSharedPreferences("mipush_extra", 0);
                sharedPreferences.edit().putString(auVar.name(), str).commit();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m105a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            synchronized (this.f42a) {
                x xVar = new x();
                xVar.a = 0;
                xVar.f81a = str;
                if (this.f42a.contains(xVar)) {
                    this.f42a.remove(xVar);
                }
                this.f42a.add(xVar);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m106a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            synchronized (this.f42a) {
                x xVar = new x();
                xVar.f81a = str;
                return this.f42a.contains(xVar);
            }
        }
        return invokeL.booleanValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            synchronized (this.f42a) {
                x xVar = new x();
                xVar.f81a = str;
                if (this.f42a.contains(xVar)) {
                    Iterator<x> it = this.f42a.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        x next = it.next();
                        if (xVar.equals(next)) {
                            xVar = next;
                            break;
                        }
                    }
                }
                xVar.a++;
                this.f42a.remove(xVar);
                this.f42a.add(xVar);
            }
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            synchronized (this.f42a) {
                x xVar = new x();
                xVar.f81a = str;
                if (this.f42a.contains(xVar)) {
                    this.f42a.remove(xVar);
                }
            }
        }
    }
}
