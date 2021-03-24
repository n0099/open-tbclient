package d.b.h0.a0;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f49679a = "add_user_collect_emotoin";

    /* renamed from: b  reason: collision with root package name */
    public static String f49680b = "image_url";

    /* renamed from: c  reason: collision with root package name */
    public static String f49681c = "package_id";

    /* renamed from: d  reason: collision with root package name */
    public static String f49682d = "#(meme,setting)";

    /* renamed from: e  reason: collision with root package name */
    public static String f49683e = "#(meme,collect_";

    /* renamed from: f  reason: collision with root package name */
    public static String f49684f = "meme,collect_";

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f49685a;

        /* renamed from: b  reason: collision with root package name */
        public String f49686b;
    }

    public static String a() {
        StringBuilder sb = new StringBuilder();
        sb.append("collect_");
        sb.append(TbadkCoreApplication.getCurrentAccount() == null ? "" : TbadkCoreApplication.getCurrentAccount());
        return sb.toString();
    }

    public static String b() {
        return Math.abs(a().hashCode()) + "";
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Matcher matcher = Pattern.compile("#\\(meme,collect_[a-zA-Z0-9_,]+\\)").matcher(str);
        int i = 0;
        int i2 = 0;
        while (matcher.find()) {
            String[] split = matcher.group().split(",");
            if (split != null && split.length == 5 && split[1] != null && split[1].startsWith("#\\(meme,collect_[a-zA-Z0-9_,]+\\)")) {
                i2++;
            }
        }
        Matcher matcher2 = Pattern.compile("#\\(meme,[a-zA-Z0-9_,]+\\)").matcher(str);
        while (matcher2.find()) {
            String[] split2 = matcher2.group().split(",");
            if (split2 != null && split2.length == 5 && split2[1] != null && !split2[1].startsWith("#\\(meme,collect_[a-zA-Z0-9_,]+\\)") && split2[1].contains("_")) {
                i++;
            }
        }
        if (i2 > 0) {
            StatisticItem statisticItem = new StatisticItem("c12223");
            statisticItem.param("obj_param1", i2);
            TiebaStatic.log(statisticItem);
        }
        if (i > 0) {
            StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.FACESHOP_USE_EMOTION);
            statisticItem2.param("obj_param1", i);
            TiebaStatic.log(statisticItem2);
        }
    }
}
