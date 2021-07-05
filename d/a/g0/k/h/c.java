package d.a.g0.k.h;

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
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f45438a = "https://etrade.baidu.com/sgw/common/pingd/trace";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2016023652, "Ld/a/g0/k/h/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2016023652, "Ld/a/g0/k/h/c;");
                return;
            }
        }
        if (d.a.g0.k.b.a.d() != 1) {
            f45438a = "http://sandbox.y.nuomi.com/c/uniongw/o/common/pingd/trace";
        }
    }

    public c() {
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

    public void a(d.a.g0.k.a.c cVar, d.a.g0.k.a.b bVar, d.a.g0.k.a.a aVar) {
        DataOutputStream dataOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLL(1048576, this, cVar, bVar, aVar) != null) {
            return;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(f45438a).openConnection();
            for (Map.Entry<String, String> entry : cVar.d().entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry2 : bVar.d().entrySet()) {
                String encode = URLEncoder.encode(entry2.getValue(), "utf-8");
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
                if (aVar != null) {
                    if (responseCode >= 200 && responseCode <= 299) {
                        aVar.a(null);
                    } else {
                        aVar.b(null, null);
                    }
                }
                d.a.g0.n.c.c(dataOutputStream);
            } catch (Throwable unused) {
                if (aVar != null) {
                    try {
                        aVar.b(null, null);
                    } catch (Throwable th) {
                        d.a.g0.n.c.c(dataOutputStream);
                        throw th;
                    }
                }
                d.a.g0.n.c.c(dataOutputStream);
            }
        } catch (Throwable unused2) {
            dataOutputStream = null;
        }
    }
}
