package com.bytedance.sdk.openadsdk.multipro.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.e;
import com.bytedance.sdk.openadsdk.core.o;
/* loaded from: classes9.dex */
public class b implements com.bytedance.sdk.openadsdk.multipro.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final Object f68032b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f68033a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1067556205, "Lcom/bytedance/sdk/openadsdk/multipro/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1067556205, "Lcom/bytedance/sdk/openadsdk/multipro/a/b;");
                return;
            }
        }
        f68032b = new Object();
    }

    public b() {
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

    private boolean b(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, uri)) == null) {
            boolean z = uri == null || TextUtils.isEmpty(uri.getPath());
            if (z) {
                k.b("DBMultiProviderImpl", "==check uri is null==");
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    private Context c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            Context context = this.f68033a;
            return context == null ? o.a() : context;
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "t_db" : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            this.f68033a = context;
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
            k.b("DBMultiProviderImpl", "query: " + String.valueOf(uri));
            synchronized (f68032b) {
                if (b(uri)) {
                    return null;
                }
                String[] split = uri.getPath().split("/");
                if (split != null && split.length >= 4) {
                    String str3 = split[2];
                    String str4 = split[3];
                    if ("ttopensdk.db".equals(str3)) {
                        return e.a(c()).a().a(str4, strArr, str, strArr2, null, null, str2);
                    }
                    return null;
                }
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
            k.b("DBMultiProviderImpl", "getType: " + String.valueOf(uri));
            synchronized (f68032b) {
                if (b(uri)) {
                    return null;
                }
                String[] split = uri.getPath().split("/");
                if (split != null && split.length >= 5) {
                    String str = split[2];
                    String str2 = split[3];
                    String str3 = split[4];
                    if ("ttopensdk.db".equals(str)) {
                        if ("execSQL".equals(str3)) {
                            String queryParameter = uri.getQueryParameter("sql");
                            if (!TextUtils.isEmpty(queryParameter)) {
                                e.a(c()).a().a(Uri.decode(queryParameter));
                            }
                        } else if ("transactionBegin".equals(str3)) {
                            e.a(c()).a().a();
                        } else if ("transactionSetSuccess".equals(str3)) {
                            e.a(c()).a().b();
                        } else if ("transactionEnd".equals(str3)) {
                            e.a(c()).a().c();
                        }
                    }
                    return null;
                }
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Uri a(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, uri, contentValues)) == null) {
            k.b("DBMultiProviderImpl", "insert: " + String.valueOf(uri));
            synchronized (f68032b) {
                if (b(uri)) {
                    return null;
                }
                String[] split = uri.getPath().split("/");
                if (split != null && split.length >= 4) {
                    String str = split[2];
                    String str2 = split[3];
                    if ("ttopensdk.db".equals(str)) {
                        e.a(c()).a().a(str2, (String) null, contentValues);
                    }
                    return null;
                }
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
            k.b("DBMultiProviderImpl", "delete: " + String.valueOf(uri));
            synchronized (f68032b) {
                if (b(uri)) {
                    return 0;
                }
                String[] split = uri.getPath().split("/");
                if (split != null && split.length >= 4) {
                    String str2 = split[2];
                    String str3 = split[3];
                    if ("ttopensdk.db".equals(str2)) {
                        return e.a(c()).a().a(str3, str, strArr);
                    }
                    return 0;
                }
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
            k.b("DBMultiProviderImpl", "update: " + String.valueOf(uri));
            synchronized (f68032b) {
                if (b(uri)) {
                    return 0;
                }
                String[] split = uri.getPath().split("/");
                if (split != null && split.length >= 4) {
                    String str2 = split[2];
                    String str3 = split[3];
                    if ("ttopensdk.db".equals(str2)) {
                        return e.a(c()).a().a(str3, contentValues, str, strArr);
                    }
                    return 0;
                }
                return 0;
            }
        }
        return invokeLLLL.intValue;
    }
}
