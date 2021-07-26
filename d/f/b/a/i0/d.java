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
    public static final Pattern f70912a;

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f70913b;

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f70914c;

    /* renamed from: d  reason: collision with root package name */
    public static final Map<String, Integer> f70915d;
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
        f70912a = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
        f70913b = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
        f70914c = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
        HashMap hashMap = new HashMap();
        f70915d = hashMap;
        hashMap.put("aliceblue", -984833);
        f70915d.put("antiquewhite", -332841);
        f70915d.put("aqua", -16711681);
        f70915d.put("aquamarine", -8388652);
        f70915d.put("azure", -983041);
        f70915d.put("beige", -657956);
        f70915d.put("bisque", -6972);
        f70915d.put("black", -16777216);
        f70915d.put("blanchedalmond", -5171);
        f70915d.put("blue", -16776961);
        f70915d.put("blueviolet", -7722014);
        f70915d.put("brown", -5952982);
        f70915d.put("burlywood", -2180985);
        f70915d.put("cadetblue", -10510688);
        f70915d.put("chartreuse", -8388864);
        f70915d.put("chocolate", -2987746);
        f70915d.put("coral", -32944);
        f70915d.put("cornflowerblue", -10185235);
        f70915d.put("cornsilk", -1828);
        f70915d.put("crimson", -2354116);
        f70915d.put("cyan", -16711681);
        f70915d.put("darkblue", -16777077);
        f70915d.put("darkcyan", -16741493);
        f70915d.put("darkgoldenrod", -4684277);
        f70915d.put("darkgray", -5658199);
        f70915d.put("darkgreen", -16751616);
        f70915d.put("darkgrey", -5658199);
        f70915d.put("darkkhaki", -4343957);
        f70915d.put("darkmagenta", -7667573);
        f70915d.put("darkolivegreen", -11179217);
        f70915d.put("darkorange", -29696);
        f70915d.put("darkorchid", -6737204);
        f70915d.put("darkred", -7667712);
        f70915d.put("darksalmon", -1468806);
        f70915d.put("darkseagreen", -7357297);
        f70915d.put("darkslateblue", -12042869);
        f70915d.put("darkslategray", -13676721);
        f70915d.put("darkslategrey", -13676721);
        f70915d.put("darkturquoise", -16724271);
        f70915d.put("darkviolet", -7077677);
        f70915d.put("deeppink", -60269);
        f70915d.put("deepskyblue", -16728065);
        f70915d.put("dimgray", -9868951);
        f70915d.put("dimgrey", -9868951);
        f70915d.put("dodgerblue", -14774017);
        f70915d.put("firebrick", -5103070);
        f70915d.put("floralwhite", -1296);
        f70915d.put("forestgreen", -14513374);
        f70915d.put("fuchsia", -65281);
        f70915d.put("gainsboro", -2302756);
        f70915d.put("ghostwhite", -460545);
        f70915d.put("gold", -10496);
        f70915d.put("goldenrod", -2448096);
        f70915d.put("gray", -8355712);
        f70915d.put("green", -16744448);
        f70915d.put("greenyellow", -5374161);
        f70915d.put("grey", -8355712);
        f70915d.put("honeydew", -983056);
        f70915d.put("hotpink", -38476);
        f70915d.put("indianred", -3318692);
        f70915d.put("indigo", -11861886);
        f70915d.put("ivory", -16);
        f70915d.put("khaki", -989556);
        f70915d.put("lavender", -1644806);
        f70915d.put("lavenderblush", -3851);
        f70915d.put("lawngreen", -8586240);
        f70915d.put("lemonchiffon", -1331);
        f70915d.put("lightblue", -5383962);
        f70915d.put("lightcoral", -1015680);
        f70915d.put("lightcyan", -2031617);
        f70915d.put("lightgoldenrodyellow", -329006);
        f70915d.put("lightgray", -2894893);
        f70915d.put("lightgreen", -7278960);
        f70915d.put("lightgrey", -2894893);
        f70915d.put("lightpink", -18751);
        f70915d.put("lightsalmon", -24454);
        f70915d.put("lightseagreen", -14634326);
        f70915d.put("lightskyblue", -7876870);
        f70915d.put("lightslategray", -8943463);
        f70915d.put("lightslategrey", -8943463);
        f70915d.put("lightsteelblue", -5192482);
        f70915d.put("lightyellow", -32);
        f70915d.put("lime", -16711936);
        f70915d.put("limegreen", -13447886);
        f70915d.put("linen", -331546);
        f70915d.put("magenta", -65281);
        f70915d.put("maroon", -8388608);
        f70915d.put("mediumaquamarine", -10039894);
        f70915d.put("mediumblue", -16777011);
        f70915d.put("mediumorchid", -4565549);
        f70915d.put("mediumpurple", -7114533);
        f70915d.put("mediumseagreen", -12799119);
        f70915d.put("mediumslateblue", -8689426);
        f70915d.put("mediumspringgreen", -16713062);
        f70915d.put("mediumturquoise", -12004916);
        f70915d.put("mediumvioletred", -3730043);
        f70915d.put("midnightblue", -15132304);
        f70915d.put("mintcream", -655366);
        f70915d.put("mistyrose", -6943);
        f70915d.put("moccasin", -6987);
        f70915d.put("navajowhite", -8531);
        f70915d.put("navy", -16777088);
        f70915d.put("oldlace", -133658);
        f70915d.put("olive", -8355840);
        f70915d.put("olivedrab", -9728477);
        f70915d.put("orange", -23296);
        f70915d.put("orangered", -47872);
        f70915d.put("orchid", -2461482);
        f70915d.put("palegoldenrod", -1120086);
        f70915d.put("palegreen", -6751336);
        f70915d.put("paleturquoise", -5247250);
        f70915d.put("palevioletred", -2396013);
        f70915d.put("papayawhip", -4139);
        f70915d.put("peachpuff", -9543);
        f70915d.put("peru", -3308225);
        f70915d.put("pink", -16181);
        f70915d.put("plum", -2252579);
        f70915d.put("powderblue", -5185306);
        f70915d.put("purple", -8388480);
        f70915d.put("rebeccapurple", -10079335);
        f70915d.put("red", Integer.valueOf((int) SupportMenu.CATEGORY_MASK));
        f70915d.put("rosybrown", -4419697);
        f70915d.put("royalblue", -12490271);
        f70915d.put("saddlebrown", -7650029);
        f70915d.put("salmon", -360334);
        f70915d.put("sandybrown", -744352);
        f70915d.put("seagreen", -13726889);
        f70915d.put("seashell", -2578);
        f70915d.put("sienna", -6270419);
        f70915d.put("silver", -4144960);
        f70915d.put("skyblue", -7876885);
        f70915d.put("slateblue", -9807155);
        f70915d.put("slategray", -9404272);
        f70915d.put("slategrey", -9404272);
        f70915d.put("snow", -1286);
        f70915d.put("springgreen", -16711809);
        f70915d.put("steelblue", -12156236);
        f70915d.put("tan", -2968436);
        f70915d.put("teal", -16744320);
        f70915d.put("thistle", -2572328);
        f70915d.put("tomato", -40121);
        f70915d.put(OpenFlutter.EXTRA_TRANSPARANT, 0);
        f70915d.put("turquoise", -12525360);
        f70915d.put("violet", -1146130);
        f70915d.put("wheat", -663885);
        f70915d.put("white", -1);
        f70915d.put("whitesmoke", Integer.valueOf((int) BDEmotionPanelManager.COLOR_EMOTION_TYPE_LAYOUT));
        f70915d.put("yellow", -256);
        f70915d.put("yellowgreen", -6632142);
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
                Matcher matcher = (z ? f70914c : f70913b).matcher(replace);
                if (matcher.matches()) {
                    if (z) {
                        parseInt = (int) (Float.parseFloat(matcher.group(4)) * 255.0f);
                    } else {
                        parseInt = Integer.parseInt(matcher.group(4), 10);
                    }
                    return a(parseInt, Integer.parseInt(matcher.group(1), 10), Integer.parseInt(matcher.group(2), 10), Integer.parseInt(matcher.group(3), 10));
                }
            } else if (replace.startsWith("rgb")) {
                Matcher matcher2 = f70912a.matcher(replace);
                if (matcher2.matches()) {
                    return e(Integer.parseInt(matcher2.group(1), 10), Integer.parseInt(matcher2.group(2), 10), Integer.parseInt(matcher2.group(3), 10));
                }
            } else {
                Integer num = f70915d.get(v.J(replace));
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
