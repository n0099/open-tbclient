package com.bytedance.sdk.openadsdk.multipro.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.core.o;
import java.util.Map;
/* loaded from: classes6.dex */
public class c implements com.bytedance.sdk.openadsdk.multipro.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f31508a;

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
            }
        }
    }

    private Context c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            Context context = this.f31508a;
            return context == null ? o.a() : context;
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "t_sp" : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            this.f31508a = context;
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
        Map<String, ?> b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, uri, strArr, str, strArr2, str2)) == null) {
            if (!uri.getPath().split("/")[2].equals("get_all") || (b2 = b.b(c(), uri.getQueryParameter("sp_file_name"))) == null) {
                return null;
            }
            MatrixCursor matrixCursor = new MatrixCursor(new String[]{"cursor_name", "cursor_type", "cursor_value"});
            for (String str3 : b2.keySet()) {
                Object[] objArr = new Object[3];
                objArr[0] = str3;
                objArr[2] = b2.get(str3);
                if (objArr[2] instanceof Boolean) {
                    objArr[1] = "boolean";
                } else if (objArr[2] instanceof String) {
                    objArr[1] = "string";
                } else if (objArr[2] instanceof Integer) {
                    objArr[1] = "int";
                } else if (objArr[2] instanceof Long) {
                    objArr[1] = "long";
                } else if (objArr[2] instanceof Float) {
                    objArr[1] = ShaderParams.VALUE_TYPE_FLOAT;
                }
                matrixCursor.addRow(objArr);
            }
            return matrixCursor;
        }
        return (Cursor) invokeLLLLL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public String a(@NonNull Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, uri)) == null) {
            String[] split = uri.getPath().split("/");
            String str = split[2];
            String str2 = split[3];
            if (str.equals("contain")) {
                return b.a(o.a(), uri.getQueryParameter("sp_file_name"), str2) + "";
            }
            return "" + b.a(c(), uri.getQueryParameter("sp_file_name"), str2, str);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Uri a(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, uri, contentValues)) == null) {
            if (contentValues == null) {
                return null;
            }
            String[] split = uri.getPath().split("/");
            String str = split[2];
            String str2 = split[3];
            Object obj = contentValues.get("value");
            if (obj != null) {
                b.a(c(), uri.getQueryParameter("sp_file_name"), str2, obj);
            }
            return null;
        }
        return (Uri) invokeLL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri, str, strArr)) == null) {
            String[] split = uri.getPath().split("/");
            if (split[2].equals("clean")) {
                b.a(c(), uri.getQueryParameter("sp_file_name"));
                return 0;
            }
            String str2 = split[3];
            if (b.a(c(), uri.getQueryParameter("sp_file_name"), str2)) {
                b.b(c(), uri.getQueryParameter("sp_file_name"), str2);
            }
            return 0;
        }
        return invokeLLL.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, uri, contentValues, str, strArr)) == null) {
            if (contentValues == null) {
                return 0;
            }
            a(uri, contentValues);
            return 0;
        }
        return invokeLLLL.intValue;
    }
}
