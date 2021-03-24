package d.b.c0.k.h;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f42621a = "https://etrade.baidu.com/sgw/common/pingd/trace";

    static {
        if (d.b.c0.k.b.a.d() != 1) {
            f42621a = "http://sandbox.y.nuomi.com/c/uniongw/o/common/pingd/trace";
        }
    }

    public void a(d.b.c0.k.a.c cVar, d.b.c0.k.a.b bVar, d.b.c0.k.a.a aVar) {
        DataOutputStream dataOutputStream;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(f42621a).openConnection();
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
                d.b.c0.n.c.c(dataOutputStream);
            } catch (Throwable unused) {
                if (aVar != null) {
                    try {
                        aVar.b(null, null);
                    } catch (Throwable th) {
                        d.b.c0.n.c.c(dataOutputStream);
                        throw th;
                    }
                }
                d.b.c0.n.c.c(dataOutputStream);
            }
        } catch (Throwable unused2) {
            dataOutputStream = null;
        }
    }
}
