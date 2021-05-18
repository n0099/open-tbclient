package d.a.k0.g1;

import com.baidu.adp.lib.util.StringUtils;
import d.a.c.e.p.k;
/* loaded from: classes4.dex */
public class b {
    public static String a(String str) {
        int indexOf;
        String urlDecode = k.getUrlDecode(str);
        if (urlDecode == null) {
            return urlDecode;
        }
        int lastIndexOf = urlDecode.lastIndexOf("/");
        if (lastIndexOf == -1 || (indexOf = urlDecode.indexOf(".", lastIndexOf)) == -1) {
            return null;
        }
        return urlDecode.substring(lastIndexOf + 1, indexOf);
    }

    public static boolean b(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        String urlDecode = k.getUrlDecode(str);
        return !StringUtils.isNull(urlDecode) && urlDecode.contains("?t=");
    }
}
