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
    private static final Pattern mHe = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    private static final Pattern mHf = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    private static final Pattern mHg = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
    private static final Map<String, Integer> mHh = new HashMap();

    static {
        mHh.put("aliceblue", -984833);
        mHh.put("antiquewhite", -332841);
        mHh.put("aqua", -16711681);
        mHh.put("aquamarine", -8388652);
        mHh.put("azure", -983041);
        mHh.put("beige", -657956);
        mHh.put("bisque", -6972);
        mHh.put("black", Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK));
        mHh.put("blanchedalmond", -5171);
        mHh.put("blue", -16776961);
        mHh.put("blueviolet", -7722014);
        mHh.put("brown", -5952982);
        mHh.put("burlywood", -2180985);
        mHh.put("cadetblue", -10510688);
        mHh.put("chartreuse", -8388864);
        mHh.put("chocolate", -2987746);
        mHh.put("coral", -32944);
        mHh.put("cornflowerblue", -10185235);
        mHh.put("cornsilk", -1828);
        mHh.put("crimson", -2354116);
        mHh.put("cyan", -16711681);
        mHh.put("darkblue", -16777077);
        mHh.put("darkcyan", -16741493);
        mHh.put("darkgoldenrod", -4684277);
        mHh.put("darkgray", -5658199);
        mHh.put("darkgreen", -16751616);
        mHh.put("darkgrey", -5658199);
        mHh.put("darkkhaki", -4343957);
        mHh.put("darkmagenta", -7667573);
        mHh.put("darkolivegreen", -11179217);
        mHh.put("darkorange", -29696);
        mHh.put("darkorchid", -6737204);
        mHh.put("darkred", -7667712);
        mHh.put("darksalmon", -1468806);
        mHh.put("darkseagreen", -7357297);
        mHh.put("darkslateblue", -12042869);
        mHh.put("darkslategray", -13676721);
        mHh.put("darkslategrey", -13676721);
        mHh.put("darkturquoise", -16724271);
        mHh.put("darkviolet", -7077677);
        mHh.put("deeppink", -60269);
        mHh.put("deepskyblue", -16728065);
        mHh.put("dimgray", -9868951);
        mHh.put("dimgrey", -9868951);
        mHh.put("dodgerblue", -14774017);
        mHh.put("firebrick", -5103070);
        mHh.put("floralwhite", -1296);
        mHh.put("forestgreen", -14513374);
        mHh.put("fuchsia", -65281);
        mHh.put("gainsboro", -2302756);
        mHh.put("ghostwhite", -460545);
        mHh.put("gold", -10496);
        mHh.put("goldenrod", -2448096);
        mHh.put(com.baidu.fsg.face.base.b.c.m, -8355712);
        mHh.put("green", -16744448);
        mHh.put("greenyellow", -5374161);
        mHh.put("grey", -8355712);
        mHh.put("honeydew", -983056);
        mHh.put("hotpink", -38476);
        mHh.put("indianred", -3318692);
        mHh.put("indigo", -11861886);
        mHh.put("ivory", -16);
        mHh.put("khaki", -989556);
        mHh.put("lavender", -1644806);
        mHh.put("lavenderblush", -3851);
        mHh.put("lawngreen", -8586240);
        mHh.put("lemonchiffon", -1331);
        mHh.put("lightblue", -5383962);
        mHh.put("lightcoral", -1015680);
        mHh.put("lightcyan", -2031617);
        mHh.put("lightgoldenrodyellow", -329006);
        mHh.put("lightgray", -2894893);
        mHh.put("lightgreen", -7278960);
        mHh.put("lightgrey", -2894893);
        mHh.put("lightpink", -18751);
        mHh.put("lightsalmon", -24454);
        mHh.put("lightseagreen", -14634326);
        mHh.put("lightskyblue", -7876870);
        mHh.put("lightslategray", -8943463);
        mHh.put("lightslategrey", -8943463);
        mHh.put("lightsteelblue", -5192482);
        mHh.put("lightyellow", -32);
        mHh.put("lime", -16711936);
        mHh.put("limegreen", -13447886);
        mHh.put("linen", -331546);
        mHh.put("magenta", -65281);
        mHh.put("maroon", -8388608);
        mHh.put("mediumaquamarine", -10039894);
        mHh.put("mediumblue", -16777011);
        mHh.put("mediumorchid", -4565549);
        mHh.put("mediumpurple", -7114533);
        mHh.put("mediumseagreen", -12799119);
        mHh.put("mediumslateblue", -8689426);
        mHh.put("mediumspringgreen", -16713062);
        mHh.put("mediumturquoise", -12004916);
        mHh.put("mediumvioletred", -3730043);
        mHh.put("midnightblue", -15132304);
        mHh.put("mintcream", -655366);
        mHh.put("mistyrose", -6943);
        mHh.put("moccasin", -6987);
        mHh.put("navajowhite", -8531);
        mHh.put("navy", -16777088);
        mHh.put("oldlace", -133658);
        mHh.put("olive", -8355840);
        mHh.put("olivedrab", -9728477);
        mHh.put("orange", -23296);
        mHh.put("orangered", -47872);
        mHh.put("orchid", -2461482);
        mHh.put("palegoldenrod", -1120086);
        mHh.put("palegreen", -6751336);
        mHh.put("paleturquoise", -5247250);
        mHh.put("palevioletred", -2396013);
        mHh.put("papayawhip", -4139);
        mHh.put("peachpuff", -9543);
        mHh.put("peru", -3308225);
        mHh.put("pink", -16181);
        mHh.put("plum", -2252579);
        mHh.put("powderblue", -5185306);
        mHh.put("purple", -8388480);
        mHh.put("rebeccapurple", -10079335);
        mHh.put("red", Integer.valueOf((int) SupportMenu.CATEGORY_MASK));
        mHh.put("rosybrown", -4419697);
        mHh.put("royalblue", -12490271);
        mHh.put("saddlebrown", -7650029);
        mHh.put("salmon", -360334);
        mHh.put("sandybrown", -744352);
        mHh.put("seagreen", -13726889);
        mHh.put("seashell", -2578);
        mHh.put("sienna", -6270419);
        mHh.put("silver", -4144960);
        mHh.put("skyblue", -7876885);
        mHh.put("slateblue", -9807155);
        mHh.put("slategray", -9404272);
        mHh.put("slategrey", -9404272);
        mHh.put("snow", -1286);
        mHh.put("springgreen", -16711809);
        mHh.put("steelblue", -12156236);
        mHh.put("tan", -2968436);
        mHh.put("teal", -16744320);
        mHh.put("thistle", -2572328);
        mHh.put("tomato", -40121);
        mHh.put("transparent", 0);
        mHh.put("turquoise", -12525360);
        mHh.put("violet", -1146130);
        mHh.put("wheat", -663885);
        mHh.put("white", -1);
        mHh.put("whitesmoke", -657931);
        mHh.put("yellow", Integer.valueOf((int) InputDeviceCompat.SOURCE_ANY));
        mHh.put("yellowgreen", -6632142);
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
            Matcher matcher = (z ? mHg : mHf).matcher(replace);
            if (matcher.matches()) {
                if (z) {
                    parseInt = (int) (255.0f * Float.parseFloat(matcher.group(4)));
                } else {
                    parseInt = Integer.parseInt(matcher.group(4), 10);
                }
                return M(parseInt, Integer.parseInt(matcher.group(1), 10), Integer.parseInt(matcher.group(2), 10), Integer.parseInt(matcher.group(3), 10));
            }
        } else if (replace.startsWith("rgb")) {
            Matcher matcher2 = mHe.matcher(replace);
            if (matcher2.matches()) {
                return al(Integer.parseInt(matcher2.group(1), 10), Integer.parseInt(matcher2.group(2), 10), Integer.parseInt(matcher2.group(3), 10));
            }
        } else {
            Integer num = mHh.get(v.QB(replace));
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
