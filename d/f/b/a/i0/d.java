package d.f.b.a.i0;

import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.spswitch.utils.BDEmotionPanelManager;
import com.baidu.tieba.flutter.base.util.OpenFlutter;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f70458a;

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f70459b;

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f70460c;

    /* renamed from: d  reason: collision with root package name */
    public static final Map<String, Integer> f70461d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(85386820, "Ld/f/b/a/i0/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(85386820, "Ld/f/b/a/i0/d;");
                return;
            }
        }
        f70458a = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
        f70459b = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
        f70460c = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
        HashMap hashMap = new HashMap();
        f70461d = hashMap;
        hashMap.put("aliceblue", -984833);
        f70461d.put("antiquewhite", -332841);
        f70461d.put("aqua", -16711681);
        f70461d.put("aquamarine", -8388652);
        f70461d.put("azure", -983041);
        f70461d.put("beige", -657956);
        f70461d.put("bisque", -6972);
        f70461d.put("black", -16777216);
        f70461d.put("blanchedalmond", -5171);
        f70461d.put("blue", -16776961);
        f70461d.put("blueviolet", -7722014);
        f70461d.put("brown", -5952982);
        f70461d.put("burlywood", -2180985);
        f70461d.put("cadetblue", -10510688);
        f70461d.put("chartreuse", -8388864);
        f70461d.put("chocolate", -2987746);
        f70461d.put("coral", -32944);
        f70461d.put("cornflowerblue", -10185235);
        f70461d.put("cornsilk", -1828);
        f70461d.put("crimson", -2354116);
        f70461d.put("cyan", -16711681);
        f70461d.put("darkblue", -16777077);
        f70461d.put("darkcyan", -16741493);
        f70461d.put("darkgoldenrod", -4684277);
        f70461d.put("darkgray", -5658199);
        f70461d.put("darkgreen", -16751616);
        f70461d.put("darkgrey", -5658199);
        f70461d.put("darkkhaki", -4343957);
        f70461d.put("darkmagenta", -7667573);
        f70461d.put("darkolivegreen", -11179217);
        f70461d.put("darkorange", -29696);
        f70461d.put("darkorchid", -6737204);
        f70461d.put("darkred", -7667712);
        f70461d.put("darksalmon", -1468806);
        f70461d.put("darkseagreen", -7357297);
        f70461d.put("darkslateblue", -12042869);
        f70461d.put("darkslategray", -13676721);
        f70461d.put("darkslategrey", -13676721);
        f70461d.put("darkturquoise", -16724271);
        f70461d.put("darkviolet", -7077677);
        f70461d.put("deeppink", -60269);
        f70461d.put("deepskyblue", -16728065);
        f70461d.put("dimgray", -9868951);
        f70461d.put("dimgrey", -9868951);
        f70461d.put("dodgerblue", -14774017);
        f70461d.put("firebrick", -5103070);
        f70461d.put("floralwhite", -1296);
        f70461d.put("forestgreen", -14513374);
        f70461d.put("fuchsia", -65281);
        f70461d.put("gainsboro", -2302756);
        f70461d.put("ghostwhite", -460545);
        f70461d.put("gold", -10496);
        f70461d.put("goldenrod", -2448096);
        f70461d.put("gray", -8355712);
        f70461d.put("green", -16744448);
        f70461d.put("greenyellow", -5374161);
        f70461d.put("grey", -8355712);
        f70461d.put("honeydew", -983056);
        f70461d.put("hotpink", -38476);
        f70461d.put("indianred", -3318692);
        f70461d.put("indigo", -11861886);
        f70461d.put("ivory", -16);
        f70461d.put("khaki", -989556);
        f70461d.put("lavender", -1644806);
        f70461d.put("lavenderblush", -3851);
        f70461d.put("lawngreen", -8586240);
        f70461d.put("lemonchiffon", -1331);
        f70461d.put("lightblue", -5383962);
        f70461d.put("lightcoral", -1015680);
        f70461d.put("lightcyan", -2031617);
        f70461d.put("lightgoldenrodyellow", -329006);
        f70461d.put("lightgray", -2894893);
        f70461d.put("lightgreen", -7278960);
        f70461d.put("lightgrey", -2894893);
        f70461d.put("lightpink", -18751);
        f70461d.put("lightsalmon", -24454);
        f70461d.put("lightseagreen", -14634326);
        f70461d.put("lightskyblue", -7876870);
        f70461d.put("lightslategray", -8943463);
        f70461d.put("lightslategrey", -8943463);
        f70461d.put("lightsteelblue", -5192482);
        f70461d.put("lightyellow", -32);
        f70461d.put("lime", -16711936);
        f70461d.put("limegreen", -13447886);
        f70461d.put("linen", -331546);
        f70461d.put("magenta", -65281);
        f70461d.put("maroon", -8388608);
        f70461d.put("mediumaquamarine", -10039894);
        f70461d.put("mediumblue", -16777011);
        f70461d.put("mediumorchid", -4565549);
        f70461d.put("mediumpurple", -7114533);
        f70461d.put("mediumseagreen", -12799119);
        f70461d.put("mediumslateblue", -8689426);
        f70461d.put("mediumspringgreen", -16713062);
        f70461d.put("mediumturquoise", -12004916);
        f70461d.put("mediumvioletred", -3730043);
        f70461d.put("midnightblue", -15132304);
        f70461d.put("mintcream", -655366);
        f70461d.put("mistyrose", -6943);
        f70461d.put("moccasin", -6987);
        f70461d.put("navajowhite", -8531);
        f70461d.put("navy", -16777088);
        f70461d.put("oldlace", -133658);
        f70461d.put("olive", -8355840);
        f70461d.put("olivedrab", -9728477);
        f70461d.put("orange", -23296);
        f70461d.put("orangered", -47872);
        f70461d.put("orchid", -2461482);
        f70461d.put("palegoldenrod", -1120086);
        f70461d.put("palegreen", -6751336);
        f70461d.put("paleturquoise", -5247250);
        f70461d.put("palevioletred", -2396013);
        f70461d.put("papayawhip", -4139);
        f70461d.put("peachpuff", -9543);
        f70461d.put("peru", -3308225);
        f70461d.put("pink", -16181);
        f70461d.put("plum", -2252579);
        f70461d.put("powderblue", -5185306);
        f70461d.put("purple", -8388480);
        f70461d.put("rebeccapurple", -10079335);
        f70461d.put("red", Integer.valueOf((int) SupportMenu.CATEGORY_MASK));
        f70461d.put("rosybrown", -4419697);
        f70461d.put("royalblue", -12490271);
        f70461d.put("saddlebrown", -7650029);
        f70461d.put("salmon", -360334);
        f70461d.put("sandybrown", -744352);
        f70461d.put("seagreen", -13726889);
        f70461d.put("seashell", -2578);
        f70461d.put("sienna", -6270419);
        f70461d.put("silver", -4144960);
        f70461d.put("skyblue", -7876885);
        f70461d.put("slateblue", -9807155);
        f70461d.put("slategray", -9404272);
        f70461d.put("slategrey", -9404272);
        f70461d.put("snow", -1286);
        f70461d.put("springgreen", -16711809);
        f70461d.put("steelblue", -12156236);
        f70461d.put("tan", -2968436);
        f70461d.put("teal", -16744320);
        f70461d.put("thistle", -2572328);
        f70461d.put("tomato", -40121);
        f70461d.put(OpenFlutter.EXTRA_TRANSPARANT, 0);
        f70461d.put("turquoise", -12525360);
        f70461d.put("violet", -1146130);
        f70461d.put("wheat", -663885);
        f70461d.put("white", -1);
        f70461d.put("whitesmoke", Integer.valueOf((int) BDEmotionPanelManager.COLOR_EMOTION_TYPE_LAYOUT));
        f70461d.put("yellow", -256);
        f70461d.put("yellowgreen", -6632142);
    }

    public static int a(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIII = interceptable.invokeIIII(65537, null, i2, i3, i4, i5)) == null) ? (i2 << 24) | (i3 << 16) | (i4 << 8) | i5 : invokeIIII.intValue;
    }

    public static int b(String str, boolean z) {
        InterceptResult invokeLZ;
        int parseInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, str, z)) == null) {
            a.a(!TextUtils.isEmpty(str));
            String replace = str.replace(" ", "");
            if (replace.charAt(0) == '#') {
                int parseLong = (int) Long.parseLong(replace.substring(1), 16);
                if (replace.length() == 7) {
                    return (-16777216) | parseLong;
                }
                if (replace.length() == 9) {
                    return ((parseLong & 255) << 24) | (parseLong >>> 8);
                }
                throw new IllegalArgumentException();
            }
            if (replace.startsWith("rgba")) {
                Matcher matcher = (z ? f70460c : f70459b).matcher(replace);
                if (matcher.matches()) {
                    if (z) {
                        parseInt = (int) (Float.parseFloat(matcher.group(4)) * 255.0f);
                    } else {
                        parseInt = Integer.parseInt(matcher.group(4), 10);
                    }
                    return a(parseInt, Integer.parseInt(matcher.group(1), 10), Integer.parseInt(matcher.group(2), 10), Integer.parseInt(matcher.group(3), 10));
                }
            } else if (replace.startsWith("rgb")) {
                Matcher matcher2 = f70458a.matcher(replace);
                if (matcher2.matches()) {
                    return e(Integer.parseInt(matcher2.group(1), 10), Integer.parseInt(matcher2.group(2), 10), Integer.parseInt(matcher2.group(3), 10));
                }
            } else {
                Integer num = f70461d.get(v.J(replace));
                if (num != null) {
                    return num.intValue();
                }
            }
            throw new IllegalArgumentException();
        }
        return invokeLZ.intValue;
    }

    public static int c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? b(str, true) : invokeL.intValue;
    }

    public static int d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? b(str, false) : invokeL.intValue;
    }

    public static int e(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(AdIconUtil.AD_TEXT_ID, null, i2, i3, i4)) == null) ? a(255, i2, i3, i4) : invokeIII.intValue;
    }
}
