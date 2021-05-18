package d.a.j0.k0;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public static String a(List<String> list) {
        if (ListUtils.getCount(list) <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (String str : list) {
            if (!StringUtils.isNull(str)) {
                if (!z && !StringUtils.isNull(sb.toString())) {
                    z = true;
                }
                if (z) {
                    sb.append("_");
                }
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public static List<String> b(List<String> list, int i2) {
        int count = ListUtils.getCount(list);
        return (count <= 0 || i2 < 0 || count <= i2) ? list : ListUtils.subList(list, count - i2, count);
    }
}
