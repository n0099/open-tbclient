package d.a.o0.a0;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f51432a = "add_user_collect_emotoin";

    /* renamed from: b  reason: collision with root package name */
    public static String f51433b = "image_url";

    /* renamed from: c  reason: collision with root package name */
    public static String f51434c = "package_id";

    /* renamed from: d  reason: collision with root package name */
    public static String f51435d = "#(meme,setting)";

    /* renamed from: e  reason: collision with root package name */
    public static String f51436e = "#(meme,collect_";

    /* renamed from: f  reason: collision with root package name */
    public static String f51437f = "meme,collect_";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f51438a;

        /* renamed from: b  reason: collision with root package name */
        public String f51439b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(974807886, "Ld/a/o0/a0/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(974807886, "Ld/a/o0/a0/d;");
        }
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("collect_");
            sb.append(TbadkCoreApplication.getCurrentAccount() == null ? "" : TbadkCoreApplication.getCurrentAccount());
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return Math.abs(a().hashCode()) + "";
        }
        return (String) invokeV.objValue;
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        Matcher matcher = Pattern.compile("#\\(meme,collect_[a-zA-Z0-9_,]+\\)").matcher(str);
        int i2 = 0;
        int i3 = 0;
        while (matcher.find()) {
            String[] split = matcher.group().split(",");
            if (split != null && split.length == 5 && split[1] != null && split[1].startsWith("#\\(meme,collect_[a-zA-Z0-9_,]+\\)")) {
                i3++;
            }
        }
        Matcher matcher2 = Pattern.compile("#\\(meme,[a-zA-Z0-9_,]+\\)").matcher(str);
        while (matcher2.find()) {
            String[] split2 = matcher2.group().split(",");
            if (split2 != null && split2.length == 5 && split2[1] != null && !split2[1].startsWith("#\\(meme,collect_[a-zA-Z0-9_,]+\\)") && split2[1].contains("_")) {
                i2++;
            }
        }
        if (i3 > 0) {
            StatisticItem statisticItem = new StatisticItem("c12223");
            statisticItem.param("obj_param1", i3);
            TiebaStatic.log(statisticItem);
        }
        if (i2 > 0) {
            StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.FACESHOP_USE_EMOTION);
            statisticItem2.param("obj_param1", i2);
            TiebaStatic.log(statisticItem2);
        }
    }
}
