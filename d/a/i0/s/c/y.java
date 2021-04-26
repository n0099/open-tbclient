package d.a.i0.s.c;

import android.net.Uri;
import com.baidu.wallet.core.Domains;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f49654a = Arrays.asList(Domains.BAIDU, Domains.NUOMI, Domains.BAIFUBAO, ".hao123.com");

    /* renamed from: b  reason: collision with root package name */
    public static List<String> f49655b;

    public static boolean a(String str) {
        String p;
        if (d.a.c.e.p.k.isEmpty(str)) {
            return false;
        }
        Uri parse = Uri.parse(str);
        if (parse == null || !"file".equals(parse.getScheme()) || parse.getPath() == null || !parse.getPath().contains("bdtbNWCache")) {
            if (f49655b == null && (p = d.a.i0.r.d0.b.j().p("js_host_white_list", null)) != null) {
                f49655b = b(p);
            }
            if (f49655b == null) {
                f49655b = f49654a;
            }
            if (parse != null) {
                String host = parse.getHost();
                for (String str2 : f49655b) {
                    if (host.endsWith(str2)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public static List<String> b(String str) {
        if (d.a.c.e.p.k.isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split(";"));
    }

    public static void c(String str) {
        if (str == null) {
            d.a.i0.r.d0.b.j().x("js_host_white_list", "");
        } else {
            d.a.i0.r.d0.b.j().x("js_host_white_list", str);
        }
        f49655b = b(str);
    }
}
