package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static n f78043a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f968a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f969a;

    /* renamed from: b  reason: collision with root package name */
    public final List<String> f78044b;

    /* renamed from: c  reason: collision with root package name */
    public final List<String> f78045c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(311648642, "Lcom/xiaomi/push/service/n;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(311648642, "Lcom/xiaomi/push/service/n;");
        }
    }

    public n(Context context) {
        String[] split;
        String[] split2;
        String[] split3;
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
        this.f969a = new ArrayList();
        this.f78044b = new ArrayList();
        this.f78045c = new ArrayList();
        Context applicationContext = context.getApplicationContext();
        this.f968a = applicationContext;
        if (applicationContext == null) {
            this.f968a = context;
        }
        SharedPreferences sharedPreferences = this.f968a.getSharedPreferences("mipush_app_info", 0);
        for (String str : sharedPreferences.getString("unregistered_pkg_names", "").split(",")) {
            if (TextUtils.isEmpty(str)) {
                this.f969a.add(str);
            }
        }
        for (String str2 : sharedPreferences.getString("disable_push_pkg_names", "").split(",")) {
            if (!TextUtils.isEmpty(str2)) {
                this.f78044b.add(str2);
            }
        }
        for (String str3 : sharedPreferences.getString("disable_push_pkg_names_cache", "").split(",")) {
            if (!TextUtils.isEmpty(str3)) {
                this.f78045c.add(str3);
            }
        }
    }

    public static n a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f78043a == null) {
                f78043a = new n(context);
            }
            return f78043a;
        }
        return (n) invokeL.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            synchronized (this.f969a) {
                if (!this.f969a.contains(str)) {
                    this.f969a.add(str);
                    this.f968a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", com.xiaomi.push.bm.a(this.f969a, ",")).commit();
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m636a(String str) {
        InterceptResult invokeL;
        boolean contains;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            synchronized (this.f969a) {
                contains = this.f969a.contains(str);
            }
            return contains;
        }
        return invokeL.booleanValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            synchronized (this.f78044b) {
                if (!this.f78044b.contains(str)) {
                    this.f78044b.add(str);
                    this.f968a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", com.xiaomi.push.bm.a(this.f78044b, ",")).commit();
                }
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m637b(String str) {
        InterceptResult invokeL;
        boolean contains;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            synchronized (this.f78044b) {
                contains = this.f78044b.contains(str);
            }
            return contains;
        }
        return invokeL.booleanValue;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            synchronized (this.f78045c) {
                if (!this.f78045c.contains(str)) {
                    this.f78045c.add(str);
                    this.f968a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", com.xiaomi.push.bm.a(this.f78045c, ",")).commit();
                }
            }
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m638c(String str) {
        InterceptResult invokeL;
        boolean contains;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            synchronized (this.f78045c) {
                contains = this.f78045c.contains(str);
            }
            return contains;
        }
        return invokeL.booleanValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            synchronized (this.f969a) {
                if (this.f969a.contains(str)) {
                    this.f969a.remove(str);
                    this.f968a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", com.xiaomi.push.bm.a(this.f969a, ",")).commit();
                }
            }
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            synchronized (this.f78044b) {
                if (this.f78044b.contains(str)) {
                    this.f78044b.remove(str);
                    this.f968a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", com.xiaomi.push.bm.a(this.f78044b, ",")).commit();
                }
            }
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            synchronized (this.f78045c) {
                if (this.f78045c.contains(str)) {
                    this.f78045c.remove(str);
                    this.f968a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", com.xiaomi.push.bm.a(this.f78045c, ",")).commit();
                }
            }
        }
    }
}
