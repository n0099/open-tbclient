package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.ContentUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.f70;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e70 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e70 e;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public Context c;
    public boolean d;

    public e70() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = "";
    }

    public static e70 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (e == null) {
                synchronized (e70.class) {
                    if (e == null) {
                        e = new e70();
                    }
                }
            }
            return e;
        }
        return (e70) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d : invokeV.booleanValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : invokeV.intValue;
    }

    public void e(Context context, String str, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.b = str;
            if (context != null) {
                this.c = context.getApplicationContext();
            }
            this.a = i;
            this.d = z;
        }
    }

    public void f(JSONArray jSONArray, boolean z, boolean z2, boolean z3) {
        byte[] a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{jSONArray, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (TextUtils.isEmpty(this.b) || this.c == null || jSONArray == null || jSONArray.length() == 0) {
                n70.a("IMLiteUBC", "cuid is empty or context null or upload json is null");
                return;
            }
            Context context = this.c;
            if (jSONArray == null || jSONArray.length() == 0) {
                n70.a("UBCUploader", "upload json is null");
                return;
            }
            n70.a("UBCUploader", "uploadjson:" + jSONArray.toString() + ", isReal:" + z + ", isSave:" + z2);
            if (z2) {
                n70.a("UBCUploader", "save ubcdata");
                return;
            }
            JSONObject a2 = new k70(z, jSONArray).a();
            if (a2 == null) {
                n70.a("UBCUploader", "uploadJsonData is null");
                return;
            }
            String jSONObject = a2.toString();
            if (TextUtils.isEmpty(jSONObject)) {
                a = null;
            } else {
                a = m70.a(jSONObject.getBytes());
                if (a != null && a.length > 2) {
                    a[0] = ContentUtil.GZIP_HEAD_1;
                    a[1] = ContentUtil.GZIP_HEAD_2;
                }
            }
            byte[] bArr = a;
            if (bArr == null || bArr.length < 3) {
                n70.a("UBCUploader", "uploadGzip is null or uploadGzip length<3");
                return;
            }
            n70.a("UBCUploader", "gzip success, length:" + bArr.length);
            n70.a("UBCUploader", "start execute http upload data");
            i70 i70Var = new i70(context);
            f70 a3 = f70.a(context);
            if (context == null || TextUtils.isEmpty(i70Var.a())) {
                i70Var.b(f70.d, Constants.ERROR_MSG_PARAMETER_ERROR.getBytes());
            } else if (z3) {
                j70.a().b(new f70.a(a3, i70Var, bArr, i70Var));
            } else {
                a3.e(i70Var.b(), i70Var.a(), bArr, i70Var.d(), i70Var.c(), i70Var);
            }
        }
    }
}
