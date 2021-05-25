package d.a.m0.i0;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    public static String a(ArrayList<String> arrayList, String str, int i2) {
        ArrayList arrayList2 = new ArrayList();
        if (!ListUtils.isEmpty(arrayList)) {
            arrayList2.addAll(arrayList);
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList2.add(str);
        }
        List<String> c2 = c(arrayList2, i2);
        if (ListUtils.isEmpty(c2)) {
            return null;
        }
        return b(c2);
    }

    public static String b(List<String> list) {
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

    public static List<String> c(List<String> list, int i2) {
        int count = ListUtils.getCount(list);
        return (count <= 0 || i2 < 0 || count <= i2) ? list : ListUtils.subList(list, count - i2, count);
    }
}
