package d.a.f0.a.l;

import com.baidu.tbadk.core.util.UrlSchemaHelper;
import d.a.f0.a.k.g;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes2.dex */
public class a {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        return (c(str).booleanValue() || d(str).booleanValue()) ? str.split("\\?")[0] : str;
    }

    public static HttpURLConnection b(URL url) throws IOException {
        if (url.getProtocol().toLowerCase().equals("https")) {
            g.a();
            return (HttpsURLConnection) url.openConnection();
        }
        return (HttpURLConnection) url.openConnection();
    }

    public static Boolean c(String str) {
        return e(str, UrlSchemaHelper.SCHEMA_TYPE_HTTP);
    }

    public static Boolean d(String str) {
        return e(str, UrlSchemaHelper.SCHEMA_TYPE_HTTPS);
    }

    public static Boolean e(String str, String str2) {
        boolean z = false;
        if (str != null && str.trim().toLowerCase(Locale.getDefault()).indexOf(str2) == 0) {
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
