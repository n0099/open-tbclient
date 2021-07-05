package d.a.r0.p0;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.r0.t.m;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f55544a = "#";

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f55545b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1922124348, "Ld/a/r0/p0/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1922124348, "Ld/a/r0/p0/b;");
                return;
            }
        }
        f55545b = Pattern.compile("#([^#(]+)#", 2);
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return "";
            }
            if (str.charAt(0) == '#' && str.charAt(str.length() - 1) == '#') {
                return str;
            }
            StringBuilder sb = new StringBuilder(str.length() + 2);
            sb.append(f55544a);
            sb.append(str);
            sb.append(f55544a);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static boolean b(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, tbPageContext)) == null) ? c(tbPageContext, true, true) : invokeL.booleanValue;
    }

    public static boolean c(TbPageContext<?> tbPageContext, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{tbPageContext, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) {
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
        return (String) invokeL.objValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? str != null && str.startsWith(f55544a) && str.endsWith(f55544a) && "".equals(str.substring(1, str.length() - 1).trim()) : invokeL.booleanValue;
    }

    public static boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) ? f55544a.equals(str) : invokeL.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? PluginPackageManager.O().b0("com.baidu.tieba.pluginHotTopic") : invokeV.booleanValue;
    }

    public static boolean h(boolean z) {
        InterceptResult invokeZ;
        boolean appResponseToIntentClass;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65544, null, z)) == null) {
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
        return invokeZ.booleanValue;
    }

    public static void i(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, mVar) == null) {
            int i2 = mVar.f56723b;
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.HOT_TOPIC_CLICK).param("obj_locate", i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? "" : "1" : TbadkCoreStatisticKey.HOT_TOPIC_CLICK_PB_BOTTOM : "pb" : "frs" : "index"));
        }
    }

    public static SpannableString j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return new SpannableString("");
            }
            Matcher matcher = f55545b.matcher(str);
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
        return (SpannableString) invokeL.objValue;
    }

    public static void k(Spannable spannable) {
        ImageSpan[] imageSpanArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, spannable) == null) || spannable == null) {
            return;
        }
        String obj = spannable.toString();
        if (StringUtils.isNull(obj)) {
            return;
        }
        Matcher matcher = f55545b.matcher(obj);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (!e(obj.substring(start, end)) && ((imageSpanArr = (ImageSpan[]) spannable.getSpans(start, end, ImageSpan.class)) == null || imageSpanArr.length <= 0)) {
                spannable.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0304)), start, end, 18);
            }
        }
    }
}
