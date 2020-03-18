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
    private static final Pattern mIZ = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    private static final Pattern mJa = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    private static final Pattern mJb = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
    private static final Map<String, Integer> mJc = new HashMap();

    static {
        mJc.put("aliceblue", -984833);
        mJc.put("antiquewhite", -332841);
        mJc.put("aqua", -16711681);
        mJc.put("aquamarine", -8388652);
        mJc.put("azure", -983041);
        mJc.put("beige", -657956);
        mJc.put("bisque", -6972);
        mJc.put("black", Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK));
        mJc.put("blanchedalmond", -5171);
        mJc.put("blue", -16776961);
        mJc.put("blueviolet", -7722014);
        mJc.put("brown", -5952982);
        mJc.put("burlywood", -2180985);
        mJc.put("cadetblue", -10510688);
        mJc.put("chartreuse", -8388864);
        mJc.put("chocolate", -2987746);
        mJc.put("coral", -32944);
        mJc.put("cornflowerblue", -10185235);
        mJc.put("cornsilk", -1828);
        mJc.put("crimson", -2354116);
        mJc.put("cyan", -16711681);
        mJc.put("darkblue", -16777077);
        mJc.put("darkcyan", -16741493);
        mJc.put("darkgoldenrod", -4684277);
        mJc.put("darkgray", -5658199);
        mJc.put("darkgreen", -16751616);
        mJc.put("darkgrey", -5658199);
        mJc.put("darkkhaki", -4343957);
        mJc.put("darkmagenta", -7667573);
        mJc.put("darkolivegreen", -11179217);
        mJc.put("darkorange", -29696);
        mJc.put("darkorchid", -6737204);
        mJc.put("darkred", -7667712);
        mJc.put("darksalmon", -1468806);
        mJc.put("darkseagreen", -7357297);
        mJc.put("darkslateblue", -12042869);
        mJc.put("darkslategray", -13676721);
        mJc.put("darkslategrey", -13676721);
        mJc.put("darkturquoise", -16724271);
        mJc.put("darkviolet", -7077677);
        mJc.put("deeppink", -60269);
        mJc.put("deepskyblue", -16728065);
        mJc.put("dimgray", -9868951);
        mJc.put("dimgrey", -9868951);
        mJc.put("dodgerblue", -14774017);
        mJc.put("firebrick", -5103070);
        mJc.put("floralwhite", -1296);
        mJc.put("forestgreen", -14513374);
        mJc.put("fuchsia", -65281);
        mJc.put("gainsboro", -2302756);
        mJc.put("ghostwhite", -460545);
        mJc.put("gold", -10496);
        mJc.put("goldenrod", -2448096);
        mJc.put(com.baidu.fsg.face.base.b.c.m, -8355712);
        mJc.put("green", -16744448);
        mJc.put("greenyellow", -5374161);
        mJc.put("grey", -8355712);
        mJc.put("honeydew", -983056);
        mJc.put("hotpink", -38476);
        mJc.put("indianred", -3318692);
        mJc.put("indigo", -11861886);
        mJc.put("ivory", -16);
        mJc.put("khaki", -989556);
        mJc.put("lavender", -1644806);
        mJc.put("lavenderblush", -3851);
        mJc.put("lawngreen", -8586240);
        mJc.put("lemonchiffon", -1331);
        mJc.put("lightblue", -5383962);
        mJc.put("lightcoral", -1015680);
        mJc.put("lightcyan", -2031617);
        mJc.put("lightgoldenrodyellow", -329006);
        mJc.put("lightgray", -2894893);
        mJc.put("lightgreen", -7278960);
        mJc.put("lightgrey", -2894893);
        mJc.put("lightpink", -18751);
        mJc.put("lightsalmon", -24454);
        mJc.put("lightseagreen", -14634326);
        mJc.put("lightskyblue", -7876870);
        mJc.put("lightslategray", -8943463);
        mJc.put("lightslategrey", -8943463);
        mJc.put("lightsteelblue", -5192482);
        mJc.put("lightyellow", -32);
        mJc.put("lime", -16711936);
        mJc.put("limegreen", -13447886);
        mJc.put("linen", -331546);
        mJc.put("magenta", -65281);
        mJc.put("maroon", -8388608);
        mJc.put("mediumaquamarine", -10039894);
        mJc.put("mediumblue", -16777011);
        mJc.put("mediumorchid", -4565549);
        mJc.put("mediumpurple", -7114533);
        mJc.put("mediumseagreen", -12799119);
        mJc.put("mediumslateblue", -8689426);
        mJc.put("mediumspringgreen", -16713062);
        mJc.put("mediumturquoise", -12004916);
        mJc.put("mediumvioletred", -3730043);
        mJc.put("midnightblue", -15132304);
        mJc.put("mintcream", -655366);
        mJc.put("mistyrose", -6943);
        mJc.put("moccasin", -6987);
        mJc.put("navajowhite", -8531);
        mJc.put("navy", -16777088);
        mJc.put("oldlace", -133658);
        mJc.put("olive", -8355840);
        mJc.put("olivedrab", -9728477);
        mJc.put("orange", -23296);
        mJc.put("orangered", -47872);
        mJc.put("orchid", -2461482);
        mJc.put("palegoldenrod", -1120086);
        mJc.put("palegreen", -6751336);
        mJc.put("paleturquoise", -5247250);
        mJc.put("palevioletred", -2396013);
        mJc.put("papayawhip", -4139);
        mJc.put("peachpuff", -9543);
        mJc.put("peru", -3308225);
        mJc.put("pink", -16181);
        mJc.put("plum", -2252579);
        mJc.put("powderblue", -5185306);
        mJc.put("purple", -8388480);
        mJc.put("rebeccapurple", -10079335);
        mJc.put("red", Integer.valueOf((int) SupportMenu.CATEGORY_MASK));
        mJc.put("rosybrown", -4419697);
        mJc.put("royalblue", -12490271);
        mJc.put("saddlebrown", -7650029);
        mJc.put("salmon", -360334);
        mJc.put("sandybrown", -744352);
        mJc.put("seagreen", -13726889);
        mJc.put("seashell", -2578);
        mJc.put("sienna", -6270419);
        mJc.put("silver", -4144960);
        mJc.put("skyblue", -7876885);
        mJc.put("slateblue", -9807155);
        mJc.put("slategray", -9404272);
        mJc.put("slategrey", -9404272);
        mJc.put("snow", -1286);
        mJc.put("springgreen", -16711809);
        mJc.put("steelblue", -12156236);
        mJc.put("tan", -2968436);
        mJc.put("teal", -16744320);
        mJc.put("thistle", -2572328);
        mJc.put("tomato", -40121);
        mJc.put("transparent", 0);
        mJc.put("turquoise", -12525360);
        mJc.put("violet", -1146130);
        mJc.put("wheat", -663885);
        mJc.put("white", -1);
        mJc.put("whitesmoke", -657931);
        mJc.put("yellow", Integer.valueOf((int) InputDeviceCompat.SOURCE_ANY));
        mJc.put("yellowgreen", -6632142);
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
            Matcher matcher = (z ? mJb : mJa).matcher(replace);
            if (matcher.matches()) {
                if (z) {
                    parseInt = (int) (255.0f * Float.parseFloat(matcher.group(4)));
                } else {
                    parseInt = Integer.parseInt(matcher.group(4), 10);
                }
                return M(parseInt, Integer.parseInt(matcher.group(1), 10), Integer.parseInt(matcher.group(2), 10), Integer.parseInt(matcher.group(3), 10));
            }
        } else if (replace.startsWith("rgb")) {
            Matcher matcher2 = mIZ.matcher(replace);
            if (matcher2.matches()) {
                return al(Integer.parseInt(matcher2.group(1), 10), Integer.parseInt(matcher2.group(2), 10), Integer.parseInt(matcher2.group(3), 10));
            }
        } else {
            Integer num = mJc.get(v.QB(replace));
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
