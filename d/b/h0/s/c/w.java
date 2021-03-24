package d.b.h0.s.c;

import android.net.Uri;
import com.baidu.wallet.core.Domains;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f51236a = Arrays.asList(Domains.BAIDU, Domains.NUOMI, Domains.BAIFUBAO, ".hao123.com");

    /* renamed from: b  reason: collision with root package name */
    public static List<String> f51237b;

    public static boolean a(String str) {
        String o;
        if (d.b.b.e.p.k.isEmpty(str)) {
            return false;
        }
        Uri parse = Uri.parse(str);
        if (parse == null || !"file".equals(parse.getScheme()) || parse.getPath() == null || !parse.getPath().contains("bdtbNWCache")) {
            if (f51237b == null && (o = d.b.h0.r.d0.b.i().o("js_host_white_list", null)) != null) {
                f51237b = b(o);
            }
            if (f51237b == null) {
                f51237b = f51236a;
            }
            if (parse != null) {
                String host = parse.getHost();
                for (String str2 : f51237b) {
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
        if (d.b.b.e.p.k.isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split(";"));
    }

    public static void c(String str) {
        if (str == null) {
            d.b.h0.r.d0.b.i().w("js_host_white_list", "");
        } else {
            d.b.h0.r.d0.b.i().w("js_host_white_list", str);
        }
        f51237b = b(str);
    }
}
