package com.vivo.push.d.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.util.u;
import com.vivo.push.util.z;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public final class d implements a {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, c> a;
    public transient /* synthetic */ FieldHolder $fh;
    public String b;
    public z c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1080867653, "Lcom/vivo/push/d/b/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1080867653, "Lcom/vivo/push/d/b/d;");
                return;
            }
        }
        a = new ConcurrentHashMap();
    }

    @Override // com.vivo.push.d.b.a
    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a("");
        }
    }

    @Override // com.vivo.push.d.b.a
    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            b("");
        }
    }

    @Override // com.vivo.push.d.b.a
    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.c.a();
            a.clear();
        }
    }

    @Override // com.vivo.push.d.b.a
    public final long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.c.b("APP_TOKEN_VALIDITY_PERIOD", 0L);
        }
        return invokeV.longValue;
    }

    @Override // com.vivo.push.d.b.a
    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.c.b("APP_TOKEN", (String) null);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.vivo.push.d.b.a
    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.c.c("APP_TOKEN");
        }
    }

    @Override // com.vivo.push.d.b.a
    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.c.b("APP_TAGS", (String) null);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.vivo.push.d.b.a
    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.c.c("APP_TAGS");
        }
    }

    @Override // com.vivo.push.d.b.a
    public final String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.c.b("APP_ALIAS", (String) null);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.vivo.push.d.b.a
    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.c.c("APP_ALIAS");
        }
    }

    @Override // com.vivo.push.d.b.a
    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.c.a("AGREE_PRIVACY_STATEMENT");
        }
        return invokeV.booleanValue;
    }

    public d(z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = zVar;
    }

    @Override // com.vivo.push.d.b.a
    public final void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.c.a("APP_TOKEN_VALIDITY_PERIOD", j);
        }
    }

    @Override // com.vivo.push.d.b.a
    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.c.a("APP_TOKEN", str);
        }
    }

    @Override // com.vivo.push.d.b.a
    public final void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.c.a("APP_TAGS", str);
        }
    }

    @Override // com.vivo.push.d.b.a
    public final void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.c.a("APP_ALIAS", str);
        }
    }

    public static String a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        List<ResolveInfo> queryBroadcastReceivers;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            Intent intent = new Intent(str2);
            intent.setPackage(str);
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null || (queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 64)) == null || queryBroadcastReceivers.size() <= 0) {
                    return null;
                }
                return queryBroadcastReceivers.get(0).activityInfo.name;
            } catch (Exception e) {
                u.a("PushRelyImpl", "error  " + e.getMessage());
                return null;
            }
        }
        return (String) invokeLLL.objValue;
    }

    @Override // com.vivo.push.d.b.a
    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c cVar = a.get(com.vivo.push.d.a.a().b().getPackageName());
            if (cVar != null) {
                String a2 = cVar.a();
                if (!TextUtils.isEmpty(a2)) {
                    return a2;
                }
            }
            String b = this.c.b();
            if (!TextUtils.isEmpty(b)) {
                if (cVar == null) {
                    cVar = new c();
                }
                cVar.a(b);
                a.put(com.vivo.push.d.a.a().b().getPackageName(), cVar);
            }
            return b;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.vivo.push.d.b.a
    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c cVar = a.get(com.vivo.push.d.a.a().b().getPackageName());
            if (cVar != null) {
                String b = cVar.b();
                if (!TextUtils.isEmpty(b)) {
                    return b;
                }
            }
            String c = this.c.c();
            if (!TextUtils.isEmpty(c)) {
                if (cVar == null) {
                    cVar = new c();
                }
                cVar.b(c);
                a.put(com.vivo.push.d.a.a().b().getPackageName(), cVar);
            }
            return c;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.vivo.push.d.b.a
    public final String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) {
            if (!TextUtils.isEmpty(this.b)) {
                return this.b;
            }
            if (context != null && !TextUtils.isEmpty(str)) {
                String packageName = context.getPackageName();
                String a2 = a(context, packageName, str);
                this.b = a2;
                if (TextUtils.isEmpty(a2)) {
                    u.d("PushRelyImpl", " reflectReceiver error: receiver for: " + str + " not found, package: " + packageName);
                }
                return this.b;
            }
            u.a("PushRelyImpl", "getReceiverClassName() params error, context = " + context + ", action = " + str);
            return "";
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.vivo.push.d.b.a
    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.c.a("APP_APPID", str);
            c cVar = a.get(com.vivo.push.d.a.a().b().getPackageName());
            if (cVar == null) {
                cVar = new c();
            }
            cVar.a(str);
            a.put(com.vivo.push.d.a.a().b().getPackageName(), cVar);
        }
    }

    @Override // com.vivo.push.d.b.a
    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.c.a("APP_APIKEY", str);
            c cVar = a.get(com.vivo.push.d.a.a().b().getPackageName());
            if (cVar == null) {
                cVar = new c();
            }
            cVar.b(str);
            a.put(com.vivo.push.d.a.a().b().getPackageName(), cVar);
        }
    }
}
