package d.f.b.a.i0;

import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
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
/* loaded from: classes10.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f73355a;

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f73356b;

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f73357c;

    /* renamed from: d  reason: collision with root package name */
    public static final Map<String, Integer> f73358d;
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
        f73355a = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
        f73356b = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
        f73357c = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
        HashMap hashMap = new HashMap();
        f73358d = hashMap;
        hashMap.put("aliceblue", -984833);
        f73358d.put("antiquewhite", -332841);
        f73358d.put("aqua", -16711681);
        f73358d.put("aquamarine", -8388652);
        f73358d.put("azure", -983041);
        f73358d.put("beige", -657956);
        f73358d.put("bisque", -6972);
        f73358d.put("black", -16777216);
        f73358d.put("blanchedalmond", -5171);
        f73358d.put("blue", -16776961);
        f73358d.put("blueviolet", -7722014);
        f73358d.put("brown", -5952982);
        f73358d.put("burlywood", -2180985);
        f73358d.put("cadetblue", -10510688);
        f73358d.put("chartreuse", -8388864);
        f73358d.put("chocolate", -2987746);
        f73358d.put("coral", -32944);
        f73358d.put("cornflowerblue", -10185235);
        f73358d.put("cornsilk", -1828);
        f73358d.put("crimson", -2354116);
        f73358d.put("cyan", -16711681);
        f73358d.put("darkblue", -16777077);
        f73358d.put("darkcyan", -16741493);
        f73358d.put("darkgoldenrod", -4684277);
        f73358d.put("darkgray", -5658199);
        f73358d.put("darkgreen", -16751616);
        f73358d.put("darkgrey", -5658199);
        f73358d.put("darkkhaki", -4343957);
        f73358d.put("darkmagenta", -7667573);
        f73358d.put("darkolivegreen", -11179217);
        f73358d.put("darkorange", -29696);
        f73358d.put("darkorchid", -6737204);
        f73358d.put("darkred", -7667712);
        f73358d.put("darksalmon", -1468806);
        f73358d.put("darkseagreen", -7357297);
        f73358d.put("darkslateblue", -12042869);
        f73358d.put("darkslategray", -13676721);
        f73358d.put("darkslategrey", -13676721);
        f73358d.put("darkturquoise", -16724271);
        f73358d.put("darkviolet", -7077677);
        f73358d.put("deeppink", -60269);
        f73358d.put("deepskyblue", -16728065);
        f73358d.put("dimgray", -9868951);
        f73358d.put("dimgrey", -9868951);
        f73358d.put("dodgerblue", -14774017);
        f73358d.put("firebrick", -5103070);
        f73358d.put("floralwhite", -1296);
        f73358d.put("forestgreen", -14513374);
        f73358d.put("fuchsia", -65281);
        f73358d.put("gainsboro", -2302756);
        f73358d.put("ghostwhite", -460545);
        f73358d.put("gold", -10496);
        f73358d.put("goldenrod", -2448096);
        f73358d.put("gray", -8355712);
        f73358d.put("green", -16744448);
        f73358d.put("greenyellow", -5374161);
        f73358d.put("grey", -8355712);
        f73358d.put("honeydew", -983056);
        f73358d.put("hotpink", -38476);
        f73358d.put("indianred", -3318692);
        f73358d.put("indigo", -11861886);
        f73358d.put("ivory", -16);
        f73358d.put("khaki", -989556);
        f73358d.put("lavender", -1644806);
        f73358d.put("lavenderblush", -3851);
        f73358d.put("lawngreen", -8586240);
        f73358d.put("lemonchiffon", -1331);
        f73358d.put("lightblue", -5383962);
        f73358d.put("lightcoral", -1015680);
        f73358d.put("lightcyan", -2031617);
        f73358d.put("lightgoldenrodyellow", -329006);
        f73358d.put("lightgray", -2894893);
        f73358d.put("lightgreen", -7278960);
        f73358d.put("lightgrey", -2894893);
        f73358d.put("lightpink", -18751);
        f73358d.put("lightsalmon", -24454);
        f73358d.put("lightseagreen", -14634326);
        f73358d.put("lightskyblue", -7876870);
        f73358d.put("lightslategray", -8943463);
        f73358d.put("lightslategrey", -8943463);
        f73358d.put("lightsteelblue", -5192482);
        f73358d.put("lightyellow", -32);
        f73358d.put("lime", -16711936);
        f73358d.put("limegreen", -13447886);
        f73358d.put("linen", -331546);
        f73358d.put("magenta", -65281);
        f73358d.put("maroon", -8388608);
        f73358d.put("mediumaquamarine", -10039894);
        f73358d.put("mediumblue", -16777011);
        f73358d.put("mediumorchid", -4565549);
        f73358d.put("mediumpurple", -7114533);
        f73358d.put("mediumseagreen", -12799119);
        f73358d.put("mediumslateblue", -8689426);
        f73358d.put("mediumspringgreen", -16713062);
        f73358d.put("mediumturquoise", -12004916);
        f73358d.put("mediumvioletred", -3730043);
        f73358d.put("midnightblue", -15132304);
        f73358d.put("mintcream", -655366);
        f73358d.put("mistyrose", -6943);
        f73358d.put("moccasin", -6987);
        f73358d.put("navajowhite", -8531);
        f73358d.put("navy", -16777088);
        f73358d.put("oldlace", -133658);
        f73358d.put("olive", -8355840);
        f73358d.put("olivedrab", -9728477);
        f73358d.put("orange", -23296);
        f73358d.put("orangered", -47872);
        f73358d.put("orchid", -2461482);
        f73358d.put("palegoldenrod", -1120086);
        f73358d.put("palegreen", -6751336);
        f73358d.put("paleturquoise", -5247250);
        f73358d.put("palevioletred", -2396013);
        f73358d.put("papayawhip", -4139);
        f73358d.put("peachpuff", -9543);
        f73358d.put("peru", -3308225);
        f73358d.put("pink", -16181);
        f73358d.put("plum", -2252579);
        f73358d.put("powderblue", -5185306);
        f73358d.put("purple", -8388480);
        f73358d.put("rebeccapurple", -10079335);
        f73358d.put("red", Integer.valueOf((int) SupportMenu.CATEGORY_MASK));
        f73358d.put("rosybrown", -4419697);
        f73358d.put("royalblue", -12490271);
        f73358d.put("saddlebrown", -7650029);
        f73358d.put("salmon", -360334);
        f73358d.put("sandybrown", -744352);
        f73358d.put("seagreen", -13726889);
        f73358d.put("seashell", -2578);
        f73358d.put("sienna", -6270419);
        f73358d.put("silver", -4144960);
        f73358d.put("skyblue", -7876885);
        f73358d.put("slateblue", -9807155);
        f73358d.put("slategray", -9404272);
        f73358d.put("slategrey", -9404272);
        f73358d.put("snow", -1286);
        f73358d.put("springgreen", -16711809);
        f73358d.put("steelblue", -12156236);
        f73358d.put("tan", -2968436);
        f73358d.put("teal", -16744320);
        f73358d.put("thistle", -2572328);
        f73358d.put("tomato", -40121);
        f73358d.put(OpenFlutter.EXTRA_TRANSPARANT, 0);
        f73358d.put("turquoise", -12525360);
        f73358d.put("violet", -1146130);
        f73358d.put("wheat", -663885);
        f73358d.put("white", -1);
        f73358d.put("whitesmoke", Integer.valueOf((int) BDEmotionPanelManager.COLOR_EMOTION_TYPE_LAYOUT));
        f73358d.put("yellow", -256);
        f73358d.put("yellowgreen", -6632142);
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
                Matcher matcher = (z ? f73357c : f73356b).matcher(replace);
                if (matcher.matches()) {
                    if (z) {
                        parseInt = (int) (Float.parseFloat(matcher.group(4)) * 255.0f);
                    } else {
                        parseInt = Integer.parseInt(matcher.group(4), 10);
                    }
                    return a(parseInt, Integer.parseInt(matcher.group(1), 10), Integer.parseInt(matcher.group(2), 10), Integer.parseInt(matcher.group(3), 10));
                }
            } else if (replace.startsWith("rgb")) {
                Matcher matcher2 = f73355a.matcher(replace);
                if (matcher2.matches()) {
                    return e(Integer.parseInt(matcher2.group(1), 10), Integer.parseInt(matcher2.group(2), 10), Integer.parseInt(matcher2.group(3), 10));
                }
            } else {
                Integer num = f73358d.get(v.J(replace));
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) ? b(str, false) : invokeL.intValue;
    }

    public static int e(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(AdIconUtil.AD_TEXT_ID, null, i2, i3, i4)) == null) ? a(255, i2, i3, i4) : invokeIII.intValue;
    }
}
