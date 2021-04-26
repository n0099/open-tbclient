package d.a.j0.r1.h.f;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.R;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class d {
    public static String a(String str) {
        return c(d(str));
    }

    public static String b(String str) {
        return c(str).trim();
    }

    public static String c(String str) {
        Pattern compile = Pattern.compile(TbadkCoreApplication.getInst().getString(R.string.tail_remove_dupe_regex));
        boolean z = false;
        int i2 = 0;
        while (!z && i2 < 1000) {
            Matcher matcher = compile.matcher(str);
            if (matcher.find()) {
                str = matcher.replaceAll(TbadkCoreApplication.getInst().getString(R.string.tail_remove_dupe_replace));
                i2++;
            } else {
                z = true;
            }
        }
        return str;
    }

    public static String d(String str) {
        return str.trim();
    }

    public static boolean e(String str) {
        Matcher matcher = Pattern.compile(TbFaceManager.f13601d).matcher(str);
        while (matcher.find()) {
            if (TbFaceManager.e().g(matcher.group()) <= 0) {
                return false;
            }
        }
        return true;
    }

    public static String f(String str) {
        String c2 = c(str);
        if (StringUtils.isNull(c2)) {
            return TbadkCoreApplication.getInst().getString(R.string.tail_empty_toast);
        }
        return !e(c2) ? TbadkCoreApplication.getInst().getString(R.string.tail_invalid_emotion) : "";
    }
}
