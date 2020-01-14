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
    private static final Pattern mGw = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    private static final Pattern mGx = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    private static final Pattern mGy = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
    private static final Map<String, Integer> mGz = new HashMap();

    static {
        mGz.put("aliceblue", -984833);
        mGz.put("antiquewhite", -332841);
        mGz.put("aqua", -16711681);
        mGz.put("aquamarine", -8388652);
        mGz.put("azure", -983041);
        mGz.put("beige", -657956);
        mGz.put("bisque", -6972);
        mGz.put("black", Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK));
        mGz.put("blanchedalmond", -5171);
        mGz.put("blue", -16776961);
        mGz.put("blueviolet", -7722014);
        mGz.put("brown", -5952982);
        mGz.put("burlywood", -2180985);
        mGz.put("cadetblue", -10510688);
        mGz.put("chartreuse", -8388864);
        mGz.put("chocolate", -2987746);
        mGz.put("coral", -32944);
        mGz.put("cornflowerblue", -10185235);
        mGz.put("cornsilk", -1828);
        mGz.put("crimson", -2354116);
        mGz.put("cyan", -16711681);
        mGz.put("darkblue", -16777077);
        mGz.put("darkcyan", -16741493);
        mGz.put("darkgoldenrod", -4684277);
        mGz.put("darkgray", -5658199);
        mGz.put("darkgreen", -16751616);
        mGz.put("darkgrey", -5658199);
        mGz.put("darkkhaki", -4343957);
        mGz.put("darkmagenta", -7667573);
        mGz.put("darkolivegreen", -11179217);
        mGz.put("darkorange", -29696);
        mGz.put("darkorchid", -6737204);
        mGz.put("darkred", -7667712);
        mGz.put("darksalmon", -1468806);
        mGz.put("darkseagreen", -7357297);
        mGz.put("darkslateblue", -12042869);
        mGz.put("darkslategray", -13676721);
        mGz.put("darkslategrey", -13676721);
        mGz.put("darkturquoise", -16724271);
        mGz.put("darkviolet", -7077677);
        mGz.put("deeppink", -60269);
        mGz.put("deepskyblue", -16728065);
        mGz.put("dimgray", -9868951);
        mGz.put("dimgrey", -9868951);
        mGz.put("dodgerblue", -14774017);
        mGz.put("firebrick", -5103070);
        mGz.put("floralwhite", -1296);
        mGz.put("forestgreen", -14513374);
        mGz.put("fuchsia", -65281);
        mGz.put("gainsboro", -2302756);
        mGz.put("ghostwhite", -460545);
        mGz.put("gold", -10496);
        mGz.put("goldenrod", -2448096);
        mGz.put(com.baidu.fsg.face.base.b.c.m, -8355712);
        mGz.put("green", -16744448);
        mGz.put("greenyellow", -5374161);
        mGz.put("grey", -8355712);
        mGz.put("honeydew", -983056);
        mGz.put("hotpink", -38476);
        mGz.put("indianred", -3318692);
        mGz.put("indigo", -11861886);
        mGz.put("ivory", -16);
        mGz.put("khaki", -989556);
        mGz.put("lavender", -1644806);
        mGz.put("lavenderblush", -3851);
        mGz.put("lawngreen", -8586240);
        mGz.put("lemonchiffon", -1331);
        mGz.put("lightblue", -5383962);
        mGz.put("lightcoral", -1015680);
        mGz.put("lightcyan", -2031617);
        mGz.put("lightgoldenrodyellow", -329006);
        mGz.put("lightgray", -2894893);
        mGz.put("lightgreen", -7278960);
        mGz.put("lightgrey", -2894893);
        mGz.put("lightpink", -18751);
        mGz.put("lightsalmon", -24454);
        mGz.put("lightseagreen", -14634326);
        mGz.put("lightskyblue", -7876870);
        mGz.put("lightslategray", -8943463);
        mGz.put("lightslategrey", -8943463);
        mGz.put("lightsteelblue", -5192482);
        mGz.put("lightyellow", -32);
        mGz.put("lime", -16711936);
        mGz.put("limegreen", -13447886);
        mGz.put("linen", -331546);
        mGz.put("magenta", -65281);
        mGz.put("maroon", -8388608);
        mGz.put("mediumaquamarine", -10039894);
        mGz.put("mediumblue", -16777011);
        mGz.put("mediumorchid", -4565549);
        mGz.put("mediumpurple", -7114533);
        mGz.put("mediumseagreen", -12799119);
        mGz.put("mediumslateblue", -8689426);
        mGz.put("mediumspringgreen", -16713062);
        mGz.put("mediumturquoise", -12004916);
        mGz.put("mediumvioletred", -3730043);
        mGz.put("midnightblue", -15132304);
        mGz.put("mintcream", -655366);
        mGz.put("mistyrose", -6943);
        mGz.put("moccasin", -6987);
        mGz.put("navajowhite", -8531);
        mGz.put("navy", -16777088);
        mGz.put("oldlace", -133658);
        mGz.put("olive", -8355840);
        mGz.put("olivedrab", -9728477);
        mGz.put("orange", -23296);
        mGz.put("orangered", -47872);
        mGz.put("orchid", -2461482);
        mGz.put("palegoldenrod", -1120086);
        mGz.put("palegreen", -6751336);
        mGz.put("paleturquoise", -5247250);
        mGz.put("palevioletred", -2396013);
        mGz.put("papayawhip", -4139);
        mGz.put("peachpuff", -9543);
        mGz.put("peru", -3308225);
        mGz.put("pink", -16181);
        mGz.put("plum", -2252579);
        mGz.put("powderblue", -5185306);
        mGz.put("purple", -8388480);
        mGz.put("rebeccapurple", -10079335);
        mGz.put("red", Integer.valueOf((int) SupportMenu.CATEGORY_MASK));
        mGz.put("rosybrown", -4419697);
        mGz.put("royalblue", -12490271);
        mGz.put("saddlebrown", -7650029);
        mGz.put("salmon", -360334);
        mGz.put("sandybrown", -744352);
        mGz.put("seagreen", -13726889);
        mGz.put("seashell", -2578);
        mGz.put("sienna", -6270419);
        mGz.put("silver", -4144960);
        mGz.put("skyblue", -7876885);
        mGz.put("slateblue", -9807155);
        mGz.put("slategray", -9404272);
        mGz.put("slategrey", -9404272);
        mGz.put("snow", -1286);
        mGz.put("springgreen", -16711809);
        mGz.put("steelblue", -12156236);
        mGz.put("tan", -2968436);
        mGz.put("teal", -16744320);
        mGz.put("thistle", -2572328);
        mGz.put("tomato", -40121);
        mGz.put("transparent", 0);
        mGz.put("turquoise", -12525360);
        mGz.put("violet", -1146130);
        mGz.put("wheat", -663885);
        mGz.put("white", -1);
        mGz.put("whitesmoke", -657931);
        mGz.put("yellow", Integer.valueOf((int) InputDeviceCompat.SOURCE_ANY));
        mGz.put("yellowgreen", -6632142);
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
            Matcher matcher = (z ? mGy : mGx).matcher(replace);
            if (matcher.matches()) {
                if (z) {
                    parseInt = (int) (255.0f * Float.parseFloat(matcher.group(4)));
                } else {
                    parseInt = Integer.parseInt(matcher.group(4), 10);
                }
                return M(parseInt, Integer.parseInt(matcher.group(1), 10), Integer.parseInt(matcher.group(2), 10), Integer.parseInt(matcher.group(3), 10));
            }
        } else if (replace.startsWith("rgb")) {
            Matcher matcher2 = mGw.matcher(replace);
            if (matcher2.matches()) {
                return ak(Integer.parseInt(matcher2.group(1), 10), Integer.parseInt(matcher2.group(2), 10), Integer.parseInt(matcher2.group(3), 10));
            }
        } else {
            Integer num = mGz.get(v.Qo(replace));
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
