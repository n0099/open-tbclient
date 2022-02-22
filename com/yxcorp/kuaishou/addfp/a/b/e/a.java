package com.yxcorp.kuaishou.addfp.a.b.e;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f61719b;

    /* renamed from: c  reason: collision with root package name */
    public static final Uri f61720c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(609102169, "Lcom/yxcorp/kuaishou/addfp/a/b/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(609102169, "Lcom/yxcorp/kuaishou/addfp/a/b/e/a;");
                return;
            }
        }
        f61720c = Uri.parse("content://cn.nubia.identity/identity");
    }

    public a(Context context) {
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

    public static a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f61719b == null) {
                synchronized (a.class) {
                    if (f61719b == null) {
                        f61719b = new a(context);
                    }
                }
            }
            return f61719b;
        }
        return (a) invokeL.objValue;
    }

    private String a(String str, String str2) {
        Bundle call;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, str, str2)) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 17) {
                    ContentProviderClient acquireUnstableContentProviderClient = this.a.getContentResolver().acquireUnstableContentProviderClient(f61720c);
                    call = acquireUnstableContentProviderClient.call(str2, null, null);
                    if (acquireUnstableContentProviderClient != null) {
                        if (Build.VERSION.SDK_INT >= 24) {
                            acquireUnstableContentProviderClient.close();
                        } else {
                            acquireUnstableContentProviderClient.release();
                        }
                    }
                } else {
                    call = this.a.getContentResolver().call(f61720c, str2, (String) null, (Bundle) null);
                }
                return (call == null || call.getInt("code", -1) != 0) ? "" : call.getString("id");
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public final boolean a() {
        Bundle call;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 17) {
                    ContentProviderClient acquireUnstableContentProviderClient = this.a.getContentResolver().acquireUnstableContentProviderClient(f61720c);
                    call = acquireUnstableContentProviderClient.call("isSupport", null, null);
                    if (acquireUnstableContentProviderClient != null) {
                        if (Build.VERSION.SDK_INT >= 24) {
                            acquireUnstableContentProviderClient.close();
                        } else {
                            acquireUnstableContentProviderClient.release();
                        }
                    }
                } else {
                    call = this.a.getContentResolver().call(f61720c, "isSupport", (String) null, (Bundle) null);
                }
                if (call.getInt("code", -1) == 0) {
                    return call.getBoolean("issupport", true);
                }
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? a(null, "getOAID") : (String) invokeV.objValue;
    }
}
