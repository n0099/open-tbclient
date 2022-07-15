package com.repackage;

import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
/* loaded from: classes7.dex */
public class x81 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "https://etrade.baidu.com/sgw/common/pingd/trace";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755217824, "Lcom/repackage/x81;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755217824, "Lcom/repackage/x81;");
                return;
            }
        }
        if (x71.a() != 1) {
            a = "http://sandbox.y.nuomi.com/c/uniongw/o/common/pingd/trace";
        }
    }

    public x81() {
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

    public void a(s71 s71Var, r71 r71Var, q71 q71Var) {
        DataOutputStream dataOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLL(1048576, this, s71Var, r71Var, q71Var) != null) {
            return;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(a).openConnection();
            for (Map.Entry<String, String> entry : s71Var.c().entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry2 : r71Var.c().entrySet()) {
                String encode = URLEncoder.encode(entry2.getValue(), IMAudioTransRequest.CHARSET);
                sb.append(entry2.getKey());
                sb.append("=");
                sb.append(encode);
                sb.append("&");
            }
            byte[] bytes = sb.toString().getBytes();
            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bytes.length));
            httpURLConnection.connect();
            dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                dataOutputStream.write(bytes);
                dataOutputStream.flush();
                int responseCode = httpURLConnection.getResponseCode();
                if (q71Var != null) {
                    if (responseCode >= 200 && responseCode <= 299) {
                        q71Var.c(null);
                    } else {
                        q71Var.a(null, 119501, null);
                    }
                }
                g91.a(dataOutputStream);
            } catch (Throwable unused) {
                if (q71Var != null) {
                    try {
                        q71Var.a(null, 119501, null);
                    } catch (Throwable th) {
                        g91.a(dataOutputStream);
                        throw th;
                    }
                }
                g91.a(dataOutputStream);
            }
        } catch (Throwable unused2) {
            dataOutputStream = null;
        }
    }
}
