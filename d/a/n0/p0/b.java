package d.a.n0.p0;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import d.a.n0.t.m;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f53408a = "#";

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f53409b = Pattern.compile("#([^#(]+)#", 2);

    public static String a(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (str.charAt(0) == '#' && str.charAt(str.length() - 1) == '#') {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append(f53408a);
        sb.append(str);
        sb.append(f53408a);
        return sb.toString();
    }

    public static boolean b(TbPageContext<?> tbPageContext) {
        return c(tbPageContext, true, true);
    }

    public static boolean c(TbPageContext<?> tbPageContext, boolean z, boolean z2) {
        return false;
    }

    public static String d(String str) {
        String str2;
        StringBuffer stringBuffer = new StringBuffer("http://tieba.baidu.com/n/video/opersquare?tab=hot&topic_name=");
        int length = str.length();
        if (length > 2 && str.charAt(0) == '#') {
            int i2 = length - 1;
            if (str.charAt(i2) == '#') {
                str2 = str.substring(1, i2);
                stringBuffer.append(str2);
                return stringBuffer.toString();
            }
        }
        str2 = null;
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    public static boolean e(String str) {
        return str != null && str.startsWith(f53408a) && str.endsWith(f53408a) && "".equals(str.substring(1, str.length() - 1).trim());
    }

    public static boolean f(String str) {
        return f53408a.equals(str);
    }

    public static boolean g() {
        return PluginPackageManager.O().b0("com.baidu.tieba.pluginHotTopic");
    }

    public static boolean h(boolean z) {
        boolean appResponseToIntentClass;
        if (PluginPackageManager.O().d0("com.baidu.tieba.pluginHotTopic")) {
            if (z) {
                appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(HotTopicActivityConfig.class);
            } else {
                appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(HotSelectActivityConfig.class);
            }
            return appResponseToIntentClass;
        }
        return false;
    }

    public static void i(m mVar) {
        int i2 = mVar.f54582b;
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.HOT_TOPIC_CLICK).param("obj_locate", i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? "" : "1" : TbadkCoreStatisticKey.HOT_TOPIC_CLICK_PB_BOTTOM : "pb" : "frs" : "index"));
    }

    public static SpannableString j(String str) {
        if (StringUtils.isNull(str)) {
            return new SpannableString("");
        }
        Matcher matcher = f53409b.matcher(str);
        SpannableString spannableString = new SpannableString(str);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (!e(str.substring(start, end))) {
                spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0304)), start, end, 18);
            }
        }
        return spannableString;
    }

    public static void k(Spannable spannable) {
        ImageSpan[] imageSpanArr;
        if (spannable == null) {
            return;
        }
        String obj = spannable.toString();
        if (StringUtils.isNull(obj)) {
            return;
        }
        Matcher matcher = f53409b.matcher(obj);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (!e(obj.substring(start, end)) && ((imageSpanArr = (ImageSpan[]) spannable.getSpans(start, end, ImageSpan.class)) == null || imageSpanArr.length <= 0)) {
                spannable.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0304)), start, end, 18);
            }
        }
    }
}
