package d.b.h0.a1;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes3.dex */
public class a {
    public static String a(String str) {
        int i;
        if (StringUtils.isNull(str)) {
            return null;
        }
        int indexOf = str.indexOf("(");
        int indexOf2 = str.indexOf(SmallTailInfo.EMOTION_SUFFIX);
        if (indexOf == -1 || indexOf2 == -1 || (i = indexOf + 1) >= indexOf2) {
            return null;
        }
        return str.substring(i, indexOf2);
    }

    public static boolean b(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return str.equals("4") || str.equals("5");
    }
}
