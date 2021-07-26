package com.bytedance.sdk.openadsdk.multipro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class f implements a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile f f31808a;

    /* renamed from: b  reason: collision with root package name */
    public static WeakReference<Context> f31809b;

    /* renamed from: c  reason: collision with root package name */
    public static List<a> f31810c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(935188219, "Lcom/bytedance/sdk/openadsdk/multipro/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(935188219, "Lcom/bytedance/sdk/openadsdk/multipro/f;");
                return;
            }
        }
        List<a> synchronizedList = Collections.synchronizedList(new ArrayList());
        f31810c = synchronizedList;
        synchronizedList.add(new com.bytedance.sdk.openadsdk.multipro.d.c());
        f31810c.add(new com.bytedance.sdk.openadsdk.multipro.a.b());
        f31810c.add(new com.bytedance.sdk.openadsdk.multipro.c.b());
        f31810c.add(new com.bytedance.sdk.openadsdk.multipro.c.a());
        for (a aVar : f31810c) {
            aVar.b();
        }
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static f b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (context != null) {
                f31809b = new WeakReference<>(context.getApplicationContext());
            }
            if (f31808a == null) {
                synchronized (f.class) {
                    if (f31808a == null) {
                        f31808a = new f();
                    }
                }
            }
            return f31808a;
        }
        return (f) invokeL.objValue;
    }

    private boolean c(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, uri)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "" : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            for (a aVar : f31810c) {
                aVar.a(context);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Cursor a(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, uri, strArr, str, strArr2, str2)) == null) {
            try {
                a b2 = b(uri);
                if (b2 != null) {
                    return b2.a(uri, strArr, str, strArr2, str2);
                }
                return null;
            } catch (Throwable th) {
                k.a("TTProviderManager", "==provider query error==", th);
                return null;
            }
        }
        return (Cursor) invokeLLLLL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public String a(@NonNull Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, uri)) == null) {
            try {
                a b2 = b(uri);
                if (b2 != null) {
                    return b2.a(uri);
                }
                return null;
            } catch (Throwable th) {
                k.a("TTProviderManager", "==provider getType error==", th);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    private a b(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, uri)) == null) {
            if (uri == null) {
                return null;
            }
            if (!c(uri)) {
                k.b("TTProviderManager", "uri is error1");
                return null;
            }
            String[] split = uri.getPath().split("/");
            if (split.length < 2) {
                k.b("TTProviderManager", "uri is error2");
                return null;
            }
            String str = split[1];
            if (TextUtils.isEmpty(str)) {
                k.b("TTProviderManager", "uri is error3");
                return null;
            }
            for (a aVar : f31810c) {
                if (str.equals(aVar.a())) {
                    return aVar;
                }
            }
            k.b("TTProviderManager", "uri is error4");
            return null;
        }
        return (a) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Uri a(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, uri, contentValues)) == null) {
            try {
                a b2 = b(uri);
                if (b2 != null) {
                    return b2.a(uri, contentValues);
                }
                return null;
            } catch (Throwable th) {
                k.a("TTProviderManager", "==provider insert error==", th);
                return null;
            }
        }
        return (Uri) invokeLL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri, str, strArr)) == null) {
            try {
                a b2 = b(uri);
                if (b2 != null) {
                    return b2.a(uri, str, strArr);
                }
                return 0;
            } catch (Throwable th) {
                k.a("TTProviderManager", "==provider delete error==", th);
                return 0;
            }
        }
        return invokeLLL.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, uri, contentValues, str, strArr)) == null) {
            try {
                a b2 = b(uri);
                if (b2 != null) {
                    return b2.a(uri, contentValues, str, strArr);
                }
                return 0;
            } catch (Throwable th) {
                k.a("TTProviderManager", "==provider update error==", th);
                return 0;
            }
        }
        return invokeLLLL.intValue;
    }
}
