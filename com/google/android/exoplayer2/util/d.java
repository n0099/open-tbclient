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
    private static final Pattern mHp = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    private static final Pattern mHq = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    private static final Pattern mHr = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
    private static final Map<String, Integer> mHs = new HashMap();

    static {
        mHs.put("aliceblue", -984833);
        mHs.put("antiquewhite", -332841);
        mHs.put("aqua", -16711681);
        mHs.put("aquamarine", -8388652);
        mHs.put("azure", -983041);
        mHs.put("beige", -657956);
        mHs.put("bisque", -6972);
        mHs.put("black", Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK));
        mHs.put("blanchedalmond", -5171);
        mHs.put("blue", -16776961);
        mHs.put("blueviolet", -7722014);
        mHs.put("brown", -5952982);
        mHs.put("burlywood", -2180985);
        mHs.put("cadetblue", -10510688);
        mHs.put("chartreuse", -8388864);
        mHs.put("chocolate", -2987746);
        mHs.put("coral", -32944);
        mHs.put("cornflowerblue", -10185235);
        mHs.put("cornsilk", -1828);
        mHs.put("crimson", -2354116);
        mHs.put("cyan", -16711681);
        mHs.put("darkblue", -16777077);
        mHs.put("darkcyan", -16741493);
        mHs.put("darkgoldenrod", -4684277);
        mHs.put("darkgray", -5658199);
        mHs.put("darkgreen", -16751616);
        mHs.put("darkgrey", -5658199);
        mHs.put("darkkhaki", -4343957);
        mHs.put("darkmagenta", -7667573);
        mHs.put("darkolivegreen", -11179217);
        mHs.put("darkorange", -29696);
        mHs.put("darkorchid", -6737204);
        mHs.put("darkred", -7667712);
        mHs.put("darksalmon", -1468806);
        mHs.put("darkseagreen", -7357297);
        mHs.put("darkslateblue", -12042869);
        mHs.put("darkslategray", -13676721);
        mHs.put("darkslategrey", -13676721);
        mHs.put("darkturquoise", -16724271);
        mHs.put("darkviolet", -7077677);
        mHs.put("deeppink", -60269);
        mHs.put("deepskyblue", -16728065);
        mHs.put("dimgray", -9868951);
        mHs.put("dimgrey", -9868951);
        mHs.put("dodgerblue", -14774017);
        mHs.put("firebrick", -5103070);
        mHs.put("floralwhite", -1296);
        mHs.put("forestgreen", -14513374);
        mHs.put("fuchsia", -65281);
        mHs.put("gainsboro", -2302756);
        mHs.put("ghostwhite", -460545);
        mHs.put("gold", -10496);
        mHs.put("goldenrod", -2448096);
        mHs.put(com.baidu.fsg.face.base.b.c.m, -8355712);
        mHs.put("green", -16744448);
        mHs.put("greenyellow", -5374161);
        mHs.put("grey", -8355712);
        mHs.put("honeydew", -983056);
        mHs.put("hotpink", -38476);
        mHs.put("indianred", -3318692);
        mHs.put("indigo", -11861886);
        mHs.put("ivory", -16);
        mHs.put("khaki", -989556);
        mHs.put("lavender", -1644806);
        mHs.put("lavenderblush", -3851);
        mHs.put("lawngreen", -8586240);
        mHs.put("lemonchiffon", -1331);
        mHs.put("lightblue", -5383962);
        mHs.put("lightcoral", -1015680);
        mHs.put("lightcyan", -2031617);
        mHs.put("lightgoldenrodyellow", -329006);
        mHs.put("lightgray", -2894893);
        mHs.put("lightgreen", -7278960);
        mHs.put("lightgrey", -2894893);
        mHs.put("lightpink", -18751);
        mHs.put("lightsalmon", -24454);
        mHs.put("lightseagreen", -14634326);
        mHs.put("lightskyblue", -7876870);
        mHs.put("lightslategray", -8943463);
        mHs.put("lightslategrey", -8943463);
        mHs.put("lightsteelblue", -5192482);
        mHs.put("lightyellow", -32);
        mHs.put("lime", -16711936);
        mHs.put("limegreen", -13447886);
        mHs.put("linen", -331546);
        mHs.put("magenta", -65281);
        mHs.put("maroon", -8388608);
        mHs.put("mediumaquamarine", -10039894);
        mHs.put("mediumblue", -16777011);
        mHs.put("mediumorchid", -4565549);
        mHs.put("mediumpurple", -7114533);
        mHs.put("mediumseagreen", -12799119);
        mHs.put("mediumslateblue", -8689426);
        mHs.put("mediumspringgreen", -16713062);
        mHs.put("mediumturquoise", -12004916);
        mHs.put("mediumvioletred", -3730043);
        mHs.put("midnightblue", -15132304);
        mHs.put("mintcream", -655366);
        mHs.put("mistyrose", -6943);
        mHs.put("moccasin", -6987);
        mHs.put("navajowhite", -8531);
        mHs.put("navy", -16777088);
        mHs.put("oldlace", -133658);
        mHs.put("olive", -8355840);
        mHs.put("olivedrab", -9728477);
        mHs.put("orange", -23296);
        mHs.put("orangered", -47872);
        mHs.put("orchid", -2461482);
        mHs.put("palegoldenrod", -1120086);
        mHs.put("palegreen", -6751336);
        mHs.put("paleturquoise", -5247250);
        mHs.put("palevioletred", -2396013);
        mHs.put("papayawhip", -4139);
        mHs.put("peachpuff", -9543);
        mHs.put("peru", -3308225);
        mHs.put("pink", -16181);
        mHs.put("plum", -2252579);
        mHs.put("powderblue", -5185306);
        mHs.put("purple", -8388480);
        mHs.put("rebeccapurple", -10079335);
        mHs.put("red", Integer.valueOf((int) SupportMenu.CATEGORY_MASK));
        mHs.put("rosybrown", -4419697);
        mHs.put("royalblue", -12490271);
        mHs.put("saddlebrown", -7650029);
        mHs.put("salmon", -360334);
        mHs.put("sandybrown", -744352);
        mHs.put("seagreen", -13726889);
        mHs.put("seashell", -2578);
        mHs.put("sienna", -6270419);
        mHs.put("silver", -4144960);
        mHs.put("skyblue", -7876885);
        mHs.put("slateblue", -9807155);
        mHs.put("slategray", -9404272);
        mHs.put("slategrey", -9404272);
        mHs.put("snow", -1286);
        mHs.put("springgreen", -16711809);
        mHs.put("steelblue", -12156236);
        mHs.put("tan", -2968436);
        mHs.put("teal", -16744320);
        mHs.put("thistle", -2572328);
        mHs.put("tomato", -40121);
        mHs.put("transparent", 0);
        mHs.put("turquoise", -12525360);
        mHs.put("violet", -1146130);
        mHs.put("wheat", -663885);
        mHs.put("white", -1);
        mHs.put("whitesmoke", -657931);
        mHs.put("yellow", Integer.valueOf((int) InputDeviceCompat.SOURCE_ANY));
        mHs.put("yellowgreen", -6632142);
    }

    public static int Qn(String str) {
        return aN(str, false);
    }

    public static int Qo(String str) {
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
            Matcher matcher = (z ? mHr : mHq).matcher(replace);
            if (matcher.matches()) {
                if (z) {
                    parseInt = (int) (255.0f * Float.parseFloat(matcher.group(4)));
                } else {
                    parseInt = Integer.parseInt(matcher.group(4), 10);
                }
                return M(parseInt, Integer.parseInt(matcher.group(1), 10), Integer.parseInt(matcher.group(2), 10), Integer.parseInt(matcher.group(3), 10));
            }
        } else if (replace.startsWith("rgb")) {
            Matcher matcher2 = mHp.matcher(replace);
            if (matcher2.matches()) {
                return al(Integer.parseInt(matcher2.group(1), 10), Integer.parseInt(matcher2.group(2), 10), Integer.parseInt(matcher2.group(3), 10));
            }
        } else {
            Integer num = mHs.get(v.QC(replace));
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
