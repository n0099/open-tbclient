package d.a.i0.r.y;

import android.text.TextUtils;
import com.baidu.wallet.core.Domains;
import java.net.MalformedURLException;
import java.net.URL;
/* loaded from: classes3.dex */
public class p {
    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            URL url = new URL(str);
            String protocol = url.getProtocol();
            if ("file".equals(protocol)) {
                return true;
            }
            if (!"http".equals(protocol) && !"https".equals(protocol)) {
                return false;
            }
            if (url.getHost().endsWith(Domains.BAIDU)) {
                if (str.contains("tieba_hybrid_enabled=1")) {
                    return true;
                }
                if (str.contains("tieba_hybrid_enabled%3D1")) {
                    return true;
                }
            }
            return false;
        } catch (MalformedURLException unused) {
            return false;
        }
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            URL url = new URL(str);
            String protocol = url.getProtocol();
            if ("file".equals(protocol)) {
                return true;
            }
            if (!"http".equals(protocol) && !"https".equals(protocol)) {
                return false;
            }
            return url.getHost().endsWith(Domains.BAIDU);
        } catch (MalformedURLException unused) {
            return false;
        }
    }
}
