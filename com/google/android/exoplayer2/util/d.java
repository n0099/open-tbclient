package com.google.android.exoplayer2.util;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.InputDeviceCompat;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public final class d {
    private static final Pattern mHc = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    private static final Pattern mHd = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    private static final Pattern mHe = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
    private static final Map<String, Integer> mHf = new HashMap();

    static {
        mHf.put("aliceblue", -984833);
        mHf.put("antiquewhite", -332841);
        mHf.put("aqua", -16711681);
        mHf.put("aquamarine", -8388652);
        mHf.put("azure", -983041);
        mHf.put("beige", -657956);
        mHf.put("bisque", -6972);
        mHf.put("black", Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK));
        mHf.put("blanchedalmond", -5171);
        mHf.put("blue", -16776961);
        mHf.put("blueviolet", -7722014);
        mHf.put("brown", -5952982);
        mHf.put("burlywood", -2180985);
        mHf.put("cadetblue", -10510688);
        mHf.put("chartreuse", -8388864);
        mHf.put("chocolate", -2987746);
        mHf.put("coral", -32944);
        mHf.put("cornflowerblue", -10185235);
        mHf.put("cornsilk", -1828);
        mHf.put("crimson", -2354116);
        mHf.put("cyan", -16711681);
        mHf.put("darkblue", -16777077);
        mHf.put("darkcyan", -16741493);
        mHf.put("darkgoldenrod", -4684277);
        mHf.put("darkgray", -5658199);
        mHf.put("darkgreen", -16751616);
        mHf.put("darkgrey", -5658199);
        mHf.put("darkkhaki", -4343957);
        mHf.put("darkmagenta", -7667573);
        mHf.put("darkolivegreen", -11179217);
        mHf.put("darkorange", -29696);
        mHf.put("darkorchid", -6737204);
        mHf.put("darkred", -7667712);
        mHf.put("darksalmon", -1468806);
        mHf.put("darkseagreen", -7357297);
        mHf.put("darkslateblue", -12042869);
        mHf.put("darkslategray", -13676721);
        mHf.put("darkslategrey", -13676721);
        mHf.put("darkturquoise", -16724271);
        mHf.put("darkviolet", -7077677);
        mHf.put("deeppink", -60269);
        mHf.put("deepskyblue", -16728065);
        mHf.put("dimgray", -9868951);
        mHf.put("dimgrey", -9868951);
        mHf.put("dodgerblue", -14774017);
        mHf.put("firebrick", -5103070);
        mHf.put("floralwhite", -1296);
        mHf.put("forestgreen", -14513374);
        mHf.put("fuchsia", -65281);
        mHf.put("gainsboro", -2302756);
        mHf.put("ghostwhite", -460545);
        mHf.put("gold", -10496);
        mHf.put("goldenrod", -2448096);
        mHf.put(com.baidu.fsg.face.base.b.c.m, -8355712);
        mHf.put("green", -16744448);
        mHf.put("greenyellow", -5374161);
        mHf.put("grey", -8355712);
        mHf.put("honeydew", -983056);
        mHf.put("hotpink", -38476);
        mHf.put("indianred", -3318692);
        mHf.put("indigo", -11861886);
        mHf.put("ivory", -16);
        mHf.put("khaki", -989556);
        mHf.put("lavender", -1644806);
        mHf.put("lavenderblush", -3851);
        mHf.put("lawngreen", -8586240);
        mHf.put("lemonchiffon", -1331);
        mHf.put("lightblue", -5383962);
        mHf.put("lightcoral", -1015680);
        mHf.put("lightcyan", -2031617);
        mHf.put("lightgoldenrodyellow", -329006);
        mHf.put("lightgray", -2894893);
        mHf.put("lightgreen", -7278960);
        mHf.put("lightgrey", -2894893);
        mHf.put("lightpink", -18751);
        mHf.put("lightsalmon", -24454);
        mHf.put("lightseagreen", -14634326);
        mHf.put("lightskyblue", -7876870);
        mHf.put("lightslategray", -8943463);
        mHf.put("lightslategrey", -8943463);
        mHf.put("lightsteelblue", -5192482);
        mHf.put("lightyellow", -32);
        mHf.put("lime", -16711936);
        mHf.put("limegreen", -13447886);
        mHf.put("linen", -331546);
        mHf.put("magenta", -65281);
        mHf.put("maroon", -8388608);
        mHf.put("mediumaquamarine", -10039894);
        mHf.put("mediumblue", -16777011);
        mHf.put("mediumorchid", -4565549);
        mHf.put("mediumpurple", -7114533);
        mHf.put("mediumseagreen", -12799119);
        mHf.put("mediumslateblue", -8689426);
        mHf.put("mediumspringgreen", -16713062);
        mHf.put("mediumturquoise", -12004916);
        mHf.put("mediumvioletred", -3730043);
        mHf.put("midnightblue", -15132304);
        mHf.put("mintcream", -655366);
        mHf.put("mistyrose", -6943);
        mHf.put("moccasin", -6987);
        mHf.put("navajowhite", -8531);
        mHf.put("navy", -16777088);
        mHf.put("oldlace", -133658);
        mHf.put("olive", -8355840);
        mHf.put("olivedrab", -9728477);
        mHf.put("orange", -23296);
        mHf.put("orangered", -47872);
        mHf.put("orchid", -2461482);
        mHf.put("palegoldenrod", -1120086);
        mHf.put("palegreen", -6751336);
        mHf.put("paleturquoise", -5247250);
        mHf.put("palevioletred", -2396013);
        mHf.put("papayawhip", -4139);
        mHf.put("peachpuff", -9543);
        mHf.put("peru", -3308225);
        mHf.put("pink", -16181);
        mHf.put("plum", -2252579);
        mHf.put("powderblue", -5185306);
        mHf.put("purple", -8388480);
        mHf.put("rebeccapurple", -10079335);
        mHf.put("red", Integer.valueOf((int) SupportMenu.CATEGORY_MASK));
        mHf.put("rosybrown", -4419697);
        mHf.put("royalblue", -12490271);
        mHf.put("saddlebrown", -7650029);
        mHf.put("salmon", -360334);
        mHf.put("sandybrown", -744352);
        mHf.put("seagreen", -13726889);
        mHf.put("seashell", -2578);
        mHf.put("sienna", -6270419);
        mHf.put("silver", -4144960);
        mHf.put("skyblue", -7876885);
        mHf.put("slateblue", -9807155);
        mHf.put("slategray", -9404272);
        mHf.put("slategrey", -9404272);
        mHf.put("snow", -1286);
        mHf.put("springgreen", -16711809);
        mHf.put("steelblue", -12156236);
        mHf.put("tan", -2968436);
        mHf.put("teal", -16744320);
        mHf.put("thistle", -2572328);
        mHf.put("tomato", -40121);
        mHf.put("transparent", 0);
        mHf.put("turquoise", -12525360);
        mHf.put("violet", -1146130);
        mHf.put("wheat", -663885);
        mHf.put("white", -1);
        mHf.put("whitesmoke", -657931);
        mHf.put("yellow", Integer.valueOf((int) InputDeviceCompat.SOURCE_ANY));
        mHf.put("yellowgreen", -6632142);
    }

    public static int Qm(String str) {
        return aN(str, false);
    }

    public static int Qn(String str) {
        return aN(str, true);
    }

    private static int aN(String str, boolean z) {
        int parseInt;
        a.checkArgument(!TextUtils.isEmpty(str));
        String replace = str.replace(HanziToPinyin.Token.SEPARATOR, "");
        if (replace.charAt(0) == '#') {
            int parseLong = (int) Long.parseLong(replace.substring(1), 16);
            if (replace.length() == 7) {
                return parseLong | ViewCompat.MEASURED_STATE_MASK;
            }
            if (replace.length() == 9) {
                return (parseLong >>> 8) | ((parseLong & 255) << 24);
            }
            throw new IllegalArgumentException();
        }
        if (replace.startsWith("rgba")) {
            Matcher matcher = (z ? mHe : mHd).matcher(replace);
            if (matcher.matches()) {
                if (z) {
                    parseInt = (int) (255.0f * Float.parseFloat(matcher.group(4)));
                } else {
                    parseInt = Integer.parseInt(matcher.group(4), 10);
                }
                return M(parseInt, Integer.parseInt(matcher.group(1), 10), Integer.parseInt(matcher.group(2), 10), Integer.parseInt(matcher.group(3), 10));
            }
        } else if (replace.startsWith("rgb")) {
            Matcher matcher2 = mHc.matcher(replace);
            if (matcher2.matches()) {
                return al(Integer.parseInt(matcher2.group(1), 10), Integer.parseInt(matcher2.group(2), 10), Integer.parseInt(matcher2.group(3), 10));
            }
        } else {
            Integer num = mHf.get(v.QB(replace));
            if (num != null) {
                return num.intValue();
            }
        }
        throw new IllegalArgumentException();
    }

    private static int M(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    private static int al(int i, int i2, int i3) {
        return M(255, i, i2, i3);
    }
}
