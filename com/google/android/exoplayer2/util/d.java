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
/* loaded from: classes4.dex */
public final class d {
    private static final Pattern mCA = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    private static final Pattern mCB = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    private static final Pattern mCC = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
    private static final Map<String, Integer> mCD = new HashMap();

    static {
        mCD.put("aliceblue", -984833);
        mCD.put("antiquewhite", -332841);
        mCD.put("aqua", -16711681);
        mCD.put("aquamarine", -8388652);
        mCD.put("azure", -983041);
        mCD.put("beige", -657956);
        mCD.put("bisque", -6972);
        mCD.put("black", Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK));
        mCD.put("blanchedalmond", -5171);
        mCD.put("blue", -16776961);
        mCD.put("blueviolet", -7722014);
        mCD.put("brown", -5952982);
        mCD.put("burlywood", -2180985);
        mCD.put("cadetblue", -10510688);
        mCD.put("chartreuse", -8388864);
        mCD.put("chocolate", -2987746);
        mCD.put("coral", -32944);
        mCD.put("cornflowerblue", -10185235);
        mCD.put("cornsilk", -1828);
        mCD.put("crimson", -2354116);
        mCD.put("cyan", -16711681);
        mCD.put("darkblue", -16777077);
        mCD.put("darkcyan", -16741493);
        mCD.put("darkgoldenrod", -4684277);
        mCD.put("darkgray", -5658199);
        mCD.put("darkgreen", -16751616);
        mCD.put("darkgrey", -5658199);
        mCD.put("darkkhaki", -4343957);
        mCD.put("darkmagenta", -7667573);
        mCD.put("darkolivegreen", -11179217);
        mCD.put("darkorange", -29696);
        mCD.put("darkorchid", -6737204);
        mCD.put("darkred", -7667712);
        mCD.put("darksalmon", -1468806);
        mCD.put("darkseagreen", -7357297);
        mCD.put("darkslateblue", -12042869);
        mCD.put("darkslategray", -13676721);
        mCD.put("darkslategrey", -13676721);
        mCD.put("darkturquoise", -16724271);
        mCD.put("darkviolet", -7077677);
        mCD.put("deeppink", -60269);
        mCD.put("deepskyblue", -16728065);
        mCD.put("dimgray", -9868951);
        mCD.put("dimgrey", -9868951);
        mCD.put("dodgerblue", -14774017);
        mCD.put("firebrick", -5103070);
        mCD.put("floralwhite", -1296);
        mCD.put("forestgreen", -14513374);
        mCD.put("fuchsia", -65281);
        mCD.put("gainsboro", -2302756);
        mCD.put("ghostwhite", -460545);
        mCD.put("gold", -10496);
        mCD.put("goldenrod", -2448096);
        mCD.put(com.baidu.fsg.face.base.b.c.m, -8355712);
        mCD.put("green", -16744448);
        mCD.put("greenyellow", -5374161);
        mCD.put("grey", -8355712);
        mCD.put("honeydew", -983056);
        mCD.put("hotpink", -38476);
        mCD.put("indianred", -3318692);
        mCD.put("indigo", -11861886);
        mCD.put("ivory", -16);
        mCD.put("khaki", -989556);
        mCD.put("lavender", -1644806);
        mCD.put("lavenderblush", -3851);
        mCD.put("lawngreen", -8586240);
        mCD.put("lemonchiffon", -1331);
        mCD.put("lightblue", -5383962);
        mCD.put("lightcoral", -1015680);
        mCD.put("lightcyan", -2031617);
        mCD.put("lightgoldenrodyellow", -329006);
        mCD.put("lightgray", -2894893);
        mCD.put("lightgreen", -7278960);
        mCD.put("lightgrey", -2894893);
        mCD.put("lightpink", -18751);
        mCD.put("lightsalmon", -24454);
        mCD.put("lightseagreen", -14634326);
        mCD.put("lightskyblue", -7876870);
        mCD.put("lightslategray", -8943463);
        mCD.put("lightslategrey", -8943463);
        mCD.put("lightsteelblue", -5192482);
        mCD.put("lightyellow", -32);
        mCD.put("lime", -16711936);
        mCD.put("limegreen", -13447886);
        mCD.put("linen", -331546);
        mCD.put("magenta", -65281);
        mCD.put("maroon", -8388608);
        mCD.put("mediumaquamarine", -10039894);
        mCD.put("mediumblue", -16777011);
        mCD.put("mediumorchid", -4565549);
        mCD.put("mediumpurple", -7114533);
        mCD.put("mediumseagreen", -12799119);
        mCD.put("mediumslateblue", -8689426);
        mCD.put("mediumspringgreen", -16713062);
        mCD.put("mediumturquoise", -12004916);
        mCD.put("mediumvioletred", -3730043);
        mCD.put("midnightblue", -15132304);
        mCD.put("mintcream", -655366);
        mCD.put("mistyrose", -6943);
        mCD.put("moccasin", -6987);
        mCD.put("navajowhite", -8531);
        mCD.put("navy", -16777088);
        mCD.put("oldlace", -133658);
        mCD.put("olive", -8355840);
        mCD.put("olivedrab", -9728477);
        mCD.put("orange", -23296);
        mCD.put("orangered", -47872);
        mCD.put("orchid", -2461482);
        mCD.put("palegoldenrod", -1120086);
        mCD.put("palegreen", -6751336);
        mCD.put("paleturquoise", -5247250);
        mCD.put("palevioletred", -2396013);
        mCD.put("papayawhip", -4139);
        mCD.put("peachpuff", -9543);
        mCD.put("peru", -3308225);
        mCD.put("pink", -16181);
        mCD.put("plum", -2252579);
        mCD.put("powderblue", -5185306);
        mCD.put("purple", -8388480);
        mCD.put("rebeccapurple", -10079335);
        mCD.put("red", Integer.valueOf((int) SupportMenu.CATEGORY_MASK));
        mCD.put("rosybrown", -4419697);
        mCD.put("royalblue", -12490271);
        mCD.put("saddlebrown", -7650029);
        mCD.put("salmon", -360334);
        mCD.put("sandybrown", -744352);
        mCD.put("seagreen", -13726889);
        mCD.put("seashell", -2578);
        mCD.put("sienna", -6270419);
        mCD.put("silver", -4144960);
        mCD.put("skyblue", -7876885);
        mCD.put("slateblue", -9807155);
        mCD.put("slategray", -9404272);
        mCD.put("slategrey", -9404272);
        mCD.put("snow", -1286);
        mCD.put("springgreen", -16711809);
        mCD.put("steelblue", -12156236);
        mCD.put("tan", -2968436);
        mCD.put("teal", -16744320);
        mCD.put("thistle", -2572328);
        mCD.put("tomato", -40121);
        mCD.put("transparent", 0);
        mCD.put("turquoise", -12525360);
        mCD.put("violet", -1146130);
        mCD.put("wheat", -663885);
        mCD.put("white", -1);
        mCD.put("whitesmoke", -657931);
        mCD.put("yellow", Integer.valueOf((int) InputDeviceCompat.SOURCE_ANY));
        mCD.put("yellowgreen", -6632142);
    }

    public static int PO(String str) {
        return aN(str, false);
    }

    public static int PP(String str) {
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
            Matcher matcher = (z ? mCC : mCB).matcher(replace);
            if (matcher.matches()) {
                if (z) {
                    parseInt = (int) (255.0f * Float.parseFloat(matcher.group(4)));
                } else {
                    parseInt = Integer.parseInt(matcher.group(4), 10);
                }
                return M(parseInt, Integer.parseInt(matcher.group(1), 10), Integer.parseInt(matcher.group(2), 10), Integer.parseInt(matcher.group(3), 10));
            }
        } else if (replace.startsWith("rgb")) {
            Matcher matcher2 = mCA.matcher(replace);
            if (matcher2.matches()) {
                return ak(Integer.parseInt(matcher2.group(1), 10), Integer.parseInt(matcher2.group(2), 10), Integer.parseInt(matcher2.group(3), 10));
            }
        } else {
            Integer num = mCD.get(v.Qd(replace));
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
