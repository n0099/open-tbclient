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
/* loaded from: classes5.dex */
public final class d {
    private static final Pattern mGr = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    private static final Pattern mGs = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    private static final Pattern mGt = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
    private static final Map<String, Integer> mGu = new HashMap();

    static {
        mGu.put("aliceblue", -984833);
        mGu.put("antiquewhite", -332841);
        mGu.put("aqua", -16711681);
        mGu.put("aquamarine", -8388652);
        mGu.put("azure", -983041);
        mGu.put("beige", -657956);
        mGu.put("bisque", -6972);
        mGu.put("black", Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK));
        mGu.put("blanchedalmond", -5171);
        mGu.put("blue", -16776961);
        mGu.put("blueviolet", -7722014);
        mGu.put("brown", -5952982);
        mGu.put("burlywood", -2180985);
        mGu.put("cadetblue", -10510688);
        mGu.put("chartreuse", -8388864);
        mGu.put("chocolate", -2987746);
        mGu.put("coral", -32944);
        mGu.put("cornflowerblue", -10185235);
        mGu.put("cornsilk", -1828);
        mGu.put("crimson", -2354116);
        mGu.put("cyan", -16711681);
        mGu.put("darkblue", -16777077);
        mGu.put("darkcyan", -16741493);
        mGu.put("darkgoldenrod", -4684277);
        mGu.put("darkgray", -5658199);
        mGu.put("darkgreen", -16751616);
        mGu.put("darkgrey", -5658199);
        mGu.put("darkkhaki", -4343957);
        mGu.put("darkmagenta", -7667573);
        mGu.put("darkolivegreen", -11179217);
        mGu.put("darkorange", -29696);
        mGu.put("darkorchid", -6737204);
        mGu.put("darkred", -7667712);
        mGu.put("darksalmon", -1468806);
        mGu.put("darkseagreen", -7357297);
        mGu.put("darkslateblue", -12042869);
        mGu.put("darkslategray", -13676721);
        mGu.put("darkslategrey", -13676721);
        mGu.put("darkturquoise", -16724271);
        mGu.put("darkviolet", -7077677);
        mGu.put("deeppink", -60269);
        mGu.put("deepskyblue", -16728065);
        mGu.put("dimgray", -9868951);
        mGu.put("dimgrey", -9868951);
        mGu.put("dodgerblue", -14774017);
        mGu.put("firebrick", -5103070);
        mGu.put("floralwhite", -1296);
        mGu.put("forestgreen", -14513374);
        mGu.put("fuchsia", -65281);
        mGu.put("gainsboro", -2302756);
        mGu.put("ghostwhite", -460545);
        mGu.put("gold", -10496);
        mGu.put("goldenrod", -2448096);
        mGu.put(com.baidu.fsg.face.base.b.c.m, -8355712);
        mGu.put("green", -16744448);
        mGu.put("greenyellow", -5374161);
        mGu.put("grey", -8355712);
        mGu.put("honeydew", -983056);
        mGu.put("hotpink", -38476);
        mGu.put("indianred", -3318692);
        mGu.put("indigo", -11861886);
        mGu.put("ivory", -16);
        mGu.put("khaki", -989556);
        mGu.put("lavender", -1644806);
        mGu.put("lavenderblush", -3851);
        mGu.put("lawngreen", -8586240);
        mGu.put("lemonchiffon", -1331);
        mGu.put("lightblue", -5383962);
        mGu.put("lightcoral", -1015680);
        mGu.put("lightcyan", -2031617);
        mGu.put("lightgoldenrodyellow", -329006);
        mGu.put("lightgray", -2894893);
        mGu.put("lightgreen", -7278960);
        mGu.put("lightgrey", -2894893);
        mGu.put("lightpink", -18751);
        mGu.put("lightsalmon", -24454);
        mGu.put("lightseagreen", -14634326);
        mGu.put("lightskyblue", -7876870);
        mGu.put("lightslategray", -8943463);
        mGu.put("lightslategrey", -8943463);
        mGu.put("lightsteelblue", -5192482);
        mGu.put("lightyellow", -32);
        mGu.put("lime", -16711936);
        mGu.put("limegreen", -13447886);
        mGu.put("linen", -331546);
        mGu.put("magenta", -65281);
        mGu.put("maroon", -8388608);
        mGu.put("mediumaquamarine", -10039894);
        mGu.put("mediumblue", -16777011);
        mGu.put("mediumorchid", -4565549);
        mGu.put("mediumpurple", -7114533);
        mGu.put("mediumseagreen", -12799119);
        mGu.put("mediumslateblue", -8689426);
        mGu.put("mediumspringgreen", -16713062);
        mGu.put("mediumturquoise", -12004916);
        mGu.put("mediumvioletred", -3730043);
        mGu.put("midnightblue", -15132304);
        mGu.put("mintcream", -655366);
        mGu.put("mistyrose", -6943);
        mGu.put("moccasin", -6987);
        mGu.put("navajowhite", -8531);
        mGu.put("navy", -16777088);
        mGu.put("oldlace", -133658);
        mGu.put("olive", -8355840);
        mGu.put("olivedrab", -9728477);
        mGu.put("orange", -23296);
        mGu.put("orangered", -47872);
        mGu.put("orchid", -2461482);
        mGu.put("palegoldenrod", -1120086);
        mGu.put("palegreen", -6751336);
        mGu.put("paleturquoise", -5247250);
        mGu.put("palevioletred", -2396013);
        mGu.put("papayawhip", -4139);
        mGu.put("peachpuff", -9543);
        mGu.put("peru", -3308225);
        mGu.put("pink", -16181);
        mGu.put("plum", -2252579);
        mGu.put("powderblue", -5185306);
        mGu.put("purple", -8388480);
        mGu.put("rebeccapurple", -10079335);
        mGu.put("red", Integer.valueOf((int) SupportMenu.CATEGORY_MASK));
        mGu.put("rosybrown", -4419697);
        mGu.put("royalblue", -12490271);
        mGu.put("saddlebrown", -7650029);
        mGu.put("salmon", -360334);
        mGu.put("sandybrown", -744352);
        mGu.put("seagreen", -13726889);
        mGu.put("seashell", -2578);
        mGu.put("sienna", -6270419);
        mGu.put("silver", -4144960);
        mGu.put("skyblue", -7876885);
        mGu.put("slateblue", -9807155);
        mGu.put("slategray", -9404272);
        mGu.put("slategrey", -9404272);
        mGu.put("snow", -1286);
        mGu.put("springgreen", -16711809);
        mGu.put("steelblue", -12156236);
        mGu.put("tan", -2968436);
        mGu.put("teal", -16744320);
        mGu.put("thistle", -2572328);
        mGu.put("tomato", -40121);
        mGu.put("transparent", 0);
        mGu.put("turquoise", -12525360);
        mGu.put("violet", -1146130);
        mGu.put("wheat", -663885);
        mGu.put("white", -1);
        mGu.put("whitesmoke", -657931);
        mGu.put("yellow", Integer.valueOf((int) InputDeviceCompat.SOURCE_ANY));
        mGu.put("yellowgreen", -6632142);
    }

    public static int PZ(String str) {
        return aN(str, false);
    }

    public static int Qa(String str) {
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
            Matcher matcher = (z ? mGt : mGs).matcher(replace);
            if (matcher.matches()) {
                if (z) {
                    parseInt = (int) (255.0f * Float.parseFloat(matcher.group(4)));
                } else {
                    parseInt = Integer.parseInt(matcher.group(4), 10);
                }
                return M(parseInt, Integer.parseInt(matcher.group(1), 10), Integer.parseInt(matcher.group(2), 10), Integer.parseInt(matcher.group(3), 10));
            }
        } else if (replace.startsWith("rgb")) {
            Matcher matcher2 = mGr.matcher(replace);
            if (matcher2.matches()) {
                return ak(Integer.parseInt(matcher2.group(1), 10), Integer.parseInt(matcher2.group(2), 10), Integer.parseInt(matcher2.group(3), 10));
            }
        } else {
            Integer num = mGu.get(v.Qo(replace));
            if (num != null) {
                return num.intValue();
            }
        }
        throw new IllegalArgumentException();
    }

    private static int M(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    private static int ak(int i, int i2, int i3) {
        return M(255, i, i2, i3);
    }
}
