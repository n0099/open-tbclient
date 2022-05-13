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
/* loaded from: classes6.dex */
public class f70 {
    public static /* synthetic */ Interceptable $ic = null;
    public static volatile f70 c = null;
    public static int d = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final OkHttpClient a;
    public Context b;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g70 a;
        public final /* synthetic */ byte[] b;
        public final /* synthetic */ h70 c;
        public final /* synthetic */ f70 d;

        public a(f70 f70Var, g70 g70Var, byte[] bArr, h70 h70Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f70Var, g70Var, bArr, h70Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = f70Var;
            this.a = g70Var;
            this.b = bArr;
            this.c = h70Var;
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755755054, "Lcom/repackage/f70;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755755054, "Lcom/repackage/f70;");
        }
    }

    public f70(Context context) {
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

    public static f70 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (c == null) {
                synchronized (f70.class) {
                    if (c == null) {
                        c = new f70(context);
                    }
                }
            }
            return c;
        }
        return (f70) invokeL.objValue;
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
                n70.a("HttpExecutor", "getUserAgent:" + stringBuffer.toString());
                return stringBuffer.toString();
            }
            defaultUserAgent = System.getProperty("http.agent");
            StringBuffer stringBuffer2 = new StringBuffer();
            length = defaultUserAgent.length();
            while (i < length) {
            }
            n70.a("HttpExecutor", "getUserAgent:" + stringBuffer2.toString());
            return stringBuffer2.toString();
        }
        return (String) invokeV.objValue;
    }

    public final void e(String str, String str2, byte[] bArr, Map<String, String> map, String str3, h70 h70Var) {
        Request.Builder addHeader;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, bArr, map, str3, h70Var}) == null) {
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
                n70.c("HttpExecutor", "requestUrl:" + str2 + "\nrequest method: " + str + "\nrequest contentType: " + str3 + "\nresponse : " + new String(bytes));
                h70Var.a(execute.code(), bytes);
            } catch (Exception e) {
                e.printStackTrace();
                if (h70Var != null) {
                    h70Var.b(d, "Http Unknown exception".getBytes());
                }
            }
        }
    }
}
