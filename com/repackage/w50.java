package com.repackage;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
/* loaded from: classes7.dex */
public class w50 {
    public static /* synthetic */ Interceptable $ic = null;
    public static volatile w50 c = null;
    public static int d = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final OkHttpClient a;
    public Context b;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x50 a;
        public final /* synthetic */ byte[] b;
        public final /* synthetic */ y50 c;
        public final /* synthetic */ w50 d;

        public a(w50 w50Var, x50 x50Var, byte[] bArr, y50 y50Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w50Var, x50Var, bArr, y50Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = w50Var;
            this.a = x50Var;
            this.b = bArr;
            this.c = y50Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.d.e(this.a.b(), this.a.a(), this.b, this.a.d(), this.a.c(), this.c);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755250529, "Lcom/repackage/w50;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755250529, "Lcom/repackage/w50;");
        }
    }

    public w50(Context context) {
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
        this.a = new OkHttpClient.Builder().connectTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).build();
        this.b = context;
    }

    public static w50 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (c == null) {
                synchronized (w50.class) {
                    if (c == null) {
                        c = new w50(context);
                    }
                }
            }
            return c;
        }
        return (w50) invokeL.objValue;
    }

    public static Headers c(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, map)) == null) {
            try {
                Headers.Builder builder = new Headers.Builder();
                if (map != null && map.size() > 0) {
                    for (String str : map.keySet()) {
                        String str2 = str.toString();
                        builder.add(str2, map.get(str2));
                    }
                }
                return builder.build();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (Headers) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String b() {
        InterceptResult invokeV;
        String defaultUserAgent;
        int length;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                try {
                    defaultUserAgent = WebSettings.getDefaultUserAgent(this.b);
                } catch (Exception unused) {
                }
                StringBuffer stringBuffer = new StringBuffer();
                length = defaultUserAgent.length();
                for (i = 0; i < length; i++) {
                    char charAt = defaultUserAgent.charAt(i);
                    if (charAt <= 31 || charAt >= 127) {
                        stringBuffer.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                    } else {
                        stringBuffer.append(charAt);
                    }
                }
                e60.a("HttpExecutor", "getUserAgent:" + stringBuffer.toString());
                return stringBuffer.toString();
            }
            defaultUserAgent = System.getProperty("http.agent");
            StringBuffer stringBuffer2 = new StringBuffer();
            length = defaultUserAgent.length();
            while (i < length) {
            }
            e60.a("HttpExecutor", "getUserAgent:" + stringBuffer2.toString());
            return stringBuffer2.toString();
        }
        return (String) invokeV.objValue;
    }

    public final void e(String str, String str2, byte[] bArr, Map<String, String> map, String str3, y50 y50Var) {
        Request.Builder addHeader;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, bArr, map, str3, y50Var}) == null) {
            try {
                if ("POST".equals(str)) {
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "application/x-www-form-urlencoded";
                    }
                    addHeader = new Request.Builder().url(str2).headers(c(map)).removeHeader("User-Agent").addHeader("User-Agent", b()).post(RequestBody.create(MediaType.parse(str3), bArr));
                } else {
                    addHeader = new Request.Builder().url(str2).headers(c(map)).removeHeader("User-Agent").addHeader("User-Agent", b());
                }
                Response execute = this.a.newCall(addHeader.build()).execute();
                byte[] bytes = execute.body().bytes();
                e60.c("HttpExecutor", "requestUrl:" + str2 + "\nrequest method: " + str + "\nrequest contentType: " + str3 + "\nresponse : " + new String(bytes));
                y50Var.a(execute.code(), bytes);
            } catch (Exception e) {
                e.printStackTrace();
                if (y50Var != null) {
                    y50Var.b(d, "Http Unknown exception".getBytes());
                }
            }
        }
    }
}
