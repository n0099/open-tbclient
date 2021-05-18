package d.a.j0.s.c;

import android.net.Uri;
import com.baidu.wallet.core.Domains;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f50473a = Arrays.asList(Domains.BAIDU, Domains.NUOMI, Domains.BAIFUBAO, ".hao123.com");

    /* renamed from: b  reason: collision with root package name */
    public static List<String> f50474b;

    public static boolean a(String str) {
        String p;
        if (d.a.c.e.p.k.isEmpty(str)) {
            return false;
        }
        Uri parse = Uri.parse(str);
        if (parse == null || !"file".equals(parse.getScheme()) || parse.getPath() == null || !parse.getPath().contains("bdtbNWCache")) {
            if (f50474b == null && (p = d.a.j0.r.d0.b.j().p("js_host_white_list", null)) != null) {
                f50474b = b(p);
            }
            if (f50474b == null) {
                f50474b = f50473a;
            }
            if (parse != null) {
                String host = parse.getHost();
                for (String str2 : f50474b) {
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
            d.a.j0.r.d0.b.j().x("js_host_white_list", "");
        } else {
            d.a.j0.r.d0.b.j().x("js_host_white_list", str);
        }
        f50474b = b(str);
    }
}
