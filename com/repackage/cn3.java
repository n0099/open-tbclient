package com.repackage;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class cn3 extends zm3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755791479, "Lcom/repackage/cn3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755791479, "Lcom/repackage/cn3;");
                return;
            }
        }
        a = eh1.a;
    }

    public cn3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final Cursor a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            MatrixCursor matrixCursor = new MatrixCursor(new String[]{"params"}, 1);
            matrixCursor.newRow().add("params", str);
            return matrixCursor;
        }
        return (Cursor) invokeL.objValue;
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("swan_sdk_version", fh1.a());
                jSONObject.put("swan_core_version", z93.h(0));
                jSONObject.put("game_core_version", z93.h(1));
                jSONObject.put("uid", bk2.h0().i(AppRuntime.getAppContext()));
                jSONObject.put("puid", bk2.h0().h(AppRuntime.getAppContext()));
                jSONObject.put("ua", qx1.s());
                jSONObject.put("ut", qx1.f());
                jSONObject.put("timestamp", System.currentTimeMillis());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public final String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return Base64.encodeToString(en3.b(str.getBytes(), "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDI4nl5QCs/mwaPjm2H4cHaxTBya7F1S1f2IXBwfEB6QD16esL+37EX+SeGR3NQ+0Xxs32Bpl/E70xlII24e/E6GJnU1vks/d1+h4rBjv987X2eppIBrT8f6COjczYcUm0OBa7IGmAMnqMCnOt/U1Wx3Mn7zniQKueT5DjQBOuxyQIDAQAB", 117), 10);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.zm3
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, uri, strArr, str, strArr2, str2)) == null) {
            String b = b();
            if (a) {
                Log.i("ParamsProcessor", "params: " + b);
            }
            String c = c(b);
            if (a) {
                Log.i("ParamsProcessor", "encryption params: " + c);
            }
            return a(c);
        }
        return (Cursor) invokeLLLLL.objValue;
    }
}
