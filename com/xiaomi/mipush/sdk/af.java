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
    public Context f49a;

    /* renamed from: a  reason: collision with other field name */
    public List f50a;

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
        this.f50a = new ArrayList();
        Context applicationContext = context.getApplicationContext();
        this.f49a = applicationContext;
        if (applicationContext == null) {
            this.f49a = context;
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
            synchronized (this.f50a) {
                x xVar = new x();
                xVar.f89a = str;
                if (this.f50a.contains(xVar)) {
                    for (x xVar2 : this.f50a) {
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
                string = this.f49a.getSharedPreferences("mipush_extra", 0).getString(auVar.name(), "");
            }
            return string;
        }
        return (String) invokeL.objValue;
    }

    public synchronized void a(au auVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, auVar, str) == null) {
            synchronized (this) {
                SharedPreferences sharedPreferences = this.f49a.getSharedPreferences("mipush_extra", 0);
                sharedPreferences.edit().putString(auVar.name(), str).commit();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m110a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            synchronized (this.f50a) {
                x xVar = new x();
                xVar.a = 0;
                xVar.f89a = str;
                if (this.f50a.contains(xVar)) {
                    this.f50a.remove(xVar);
                }
                this.f50a.add(xVar);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m111a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            synchronized (this.f50a) {
                x xVar = new x();
                xVar.f89a = str;
                return this.f50a.contains(xVar);
            }
        }
        return invokeL.booleanValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            synchronized (this.f50a) {
                x xVar = new x();
                xVar.f89a = str;
                if (this.f50a.contains(xVar)) {
                    Iterator it = this.f50a.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        x xVar2 = (x) it.next();
                        if (xVar.equals(xVar2)) {
                            xVar = xVar2;
                            break;
                        }
                    }
                }
                xVar.a++;
                this.f50a.remove(xVar);
                this.f50a.add(xVar);
            }
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            synchronized (this.f50a) {
                x xVar = new x();
                xVar.f89a = str;
                if (this.f50a.contains(xVar)) {
                    this.f50a.remove(xVar);
                }
            }
        }
    }
}
