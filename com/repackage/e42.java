package com.repackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebResourceResponse;
import com.baidubce.http.Headers;
import com.repackage.c42;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class e42 extends v32 implements q32 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public n32 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e42(@NonNull Context context, k32 k32Var) {
        super(context, k32Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, k32Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (k32) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new f42();
    }

    @Override // com.repackage.c42
    @SuppressLint({"BDThrowableCheck"})
    public WebResourceResponse a(@NonNull c42.a aVar) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            String d = aVar.d();
            if (!d(aVar)) {
                return aVar.b(d, aVar.getRequestHeaders(), aVar.c());
            }
            if (q32.a) {
                Log.d("HybridIntercept", "intercept file = " + d);
            }
            String c = c(d);
            if (TextUtils.isEmpty(c)) {
                if (q32.a) {
                    throw new IllegalArgumentException("file path can't be null, src = " + d);
                }
                return null;
            }
            File file = new File(c);
            if (file.exists() && file.isFile()) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    if (c.endsWith(FileHelper.FILE_CACHE_CSS)) {
                        str = "text/css";
                    } else {
                        str = c.endsWith(".js") ? "application/javascript" : "text/plan";
                    }
                    return b(str, fileInputStream);
                } catch (Throwable th) {
                    if (q32.a) {
                        Log.e("HybridIntercept", Log.getStackTraceString(th));
                    }
                }
            }
            hw1.c("HybridIntercept", "file intercept error, src = " + d);
            return null;
        }
        return (WebResourceResponse) invokeL.objValue;
    }

    public final WebResourceResponse b(String str, InputStream inputStream) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, inputStream)) == null) {
            HashMap hashMap = new HashMap(1);
            hashMap.put(Headers.CACHE_CONTROL, "max-age=86400");
            return new WebResourceResponse(true, str, "UTF-8", 200, "ok", hashMap, new BufferedInputStream(inputStream));
        }
        return (WebResourceResponse) invokeLL.objValue;
    }

    public String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (str.startsWith("interceptfile://") && str.length() > 16) {
                str = str.substring(16);
            }
            if (q32.a) {
                Log.d("HybridIntercept", "file request url = " + str);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public boolean d(@NonNull c42.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) {
            if (aVar.c()) {
                return this.b.a(aVar);
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
