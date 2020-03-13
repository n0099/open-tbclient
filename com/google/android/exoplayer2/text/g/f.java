package com.google.android.exoplayer2.text.g;

import android.support.annotation.NonNull;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.google.android.exoplayer2.text.g.e;
import com.google.android.exoplayer2.util.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class f {
    public static final Pattern mCp = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
    private static final Pattern mCq = Pattern.compile("(\\S+?):(\\S+)");
    private final StringBuilder mBt = new StringBuilder();

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(l lVar, e.a aVar, List<d> list) {
        String readLine = lVar.readLine();
        if (readLine == null) {
            return false;
        }
        Matcher matcher = mCp.matcher(readLine);
        if (matcher.matches()) {
            return a(null, matcher, lVar, aVar, this.mBt, list);
        }
        String readLine2 = lVar.readLine();
        if (readLine2 != null) {
            Matcher matcher2 = mCp.matcher(readLine2);
            if (matcher2.matches()) {
                return a(readLine.trim(), matcher2, lVar, aVar, this.mBt, list);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, e.a aVar) {
        Matcher matcher = mCq.matcher(str);
        while (matcher.find()) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            try {
                if ("line".equals(group)) {
                    b(group2, aVar);
                } else if ("align".equals(group)) {
                    aVar.b(Qi(group2));
                } else if ("position".equals(group)) {
                    c(group2, aVar);
                } else if (TiebaInitialize.LogFields.SIZE.equals(group)) {
                    aVar.bB(h.Ql(group2));
                } else {
                    Log.w("WebvttCueParser", "Unknown cue setting " + group + ":" + group2);
                }
            } catch (NumberFormatException e) {
                Log.w("WebvttCueParser", "Skipping bad cue setting: " + matcher.group());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, String str2, e.a aVar, List<d> list) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Stack stack = new Stack();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < str2.length()) {
            char charAt = str2.charAt(i);
            switch (charAt) {
                case '&':
                    int indexOf = str2.indexOf(59, i + 1);
                    int indexOf2 = str2.indexOf(32, i + 1);
                    if (indexOf == -1) {
                        indexOf = indexOf2;
                    } else if (indexOf2 != -1) {
                        indexOf = Math.min(indexOf, indexOf2);
                    }
                    if (indexOf != -1) {
                        a(str2.substring(i + 1, indexOf), spannableStringBuilder);
                        if (indexOf == indexOf2) {
                            spannableStringBuilder.append(HanziToPinyin.Token.SEPARATOR);
                        }
                        i = indexOf + 1;
                        break;
                    } else {
                        spannableStringBuilder.append(charAt);
                        i++;
                        break;
                    }
                case '<':
                    if (i + 1 >= str2.length()) {
                        i++;
                        break;
                    } else {
                        boolean z = str2.charAt(i + 1) == '/';
                        int bJ = bJ(str2, i + 1);
                        boolean z2 = str2.charAt(bJ + (-2)) == '/';
                        String substring = str2.substring((z ? 2 : 1) + i, z2 ? bJ - 2 : bJ - 1);
                        String Qj = Qj(substring);
                        if (Qj != null) {
                            if (!PY(Qj)) {
                                i = bJ;
                                break;
                            } else if (z) {
                                while (!stack.isEmpty()) {
                                    a aVar2 = (a) stack.pop();
                                    a(str, aVar2, spannableStringBuilder, list, arrayList);
                                    if (aVar2.name.equals(Qj)) {
                                        i = bJ;
                                        break;
                                    }
                                }
                                i = bJ;
                            } else if (!z2) {
                                stack.push(a.bK(substring, spannableStringBuilder.length()));
                                i = bJ;
                                break;
                            }
                        }
                        i = bJ;
                        break;
                    }
                default:
                    spannableStringBuilder.append(charAt);
                    i++;
                    break;
            }
        }
        while (!stack.isEmpty()) {
            a(str, (a) stack.pop(), spannableStringBuilder, list, arrayList);
        }
        a(str, a.dyx(), spannableStringBuilder, list, arrayList);
        aVar.f(spannableStringBuilder);
    }

    private static boolean a(String str, Matcher matcher, l lVar, e.a aVar, StringBuilder sb, List<d> list) {
        try {
            aVar.gz(h.Qk(matcher.group(1))).gA(h.Qk(matcher.group(2)));
            a(matcher.group(3), aVar);
            sb.setLength(0);
            while (true) {
                String readLine = lVar.readLine();
                if (!TextUtils.isEmpty(readLine)) {
                    if (sb.length() > 0) {
                        sb.append("\n");
                    }
                    sb.append(readLine.trim());
                } else {
                    a(str, sb.toString(), aVar, list);
                    return true;
                }
            }
        } catch (NumberFormatException e) {
            Log.w("WebvttCueParser", "Skipping cue with bad header: " + matcher.group());
            return false;
        }
    }

    private static void b(String str, e.a aVar) throws NumberFormatException {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            aVar.LE(Qh(str.substring(indexOf + 1)));
            str = str.substring(0, indexOf);
        } else {
            aVar.LE(Integer.MIN_VALUE);
        }
        if (str.endsWith("%")) {
            aVar.bz(h.Ql(str)).LD(0);
            return;
        }
        int parseInt = Integer.parseInt(str);
        if (parseInt < 0) {
            parseInt--;
        }
        aVar.bz(parseInt).LD(1);
    }

    private static void c(String str, e.a aVar) throws NumberFormatException {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            aVar.LF(Qh(str.substring(indexOf + 1)));
            str = str.substring(0, indexOf);
        } else {
            aVar.LF(Integer.MIN_VALUE);
        }
        aVar.bA(h.Ql(str));
    }

    private static int Qh(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    c = 1;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    c = 2;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    c = 3;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return 0;
            case 1:
            case 2:
                return 1;
            case 3:
                return 2;
            default:
                Log.w("WebvttCueParser", "Invalid anchor value: " + str);
                return Integer.MIN_VALUE;
        }
    }

    private static Layout.Alignment Qi(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    c = 2;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    c = 3;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    c = 4;
                    break;
                }
                break;
            case 3317767:
                if (str.equals("left")) {
                    c = 1;
                    break;
                }
                break;
            case 108511772:
                if (str.equals(HorizontalTranslateLayout.DIRECTION_RIGHT)) {
                    c = 5;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
                return Layout.Alignment.ALIGN_NORMAL;
            case 2:
            case 3:
                return Layout.Alignment.ALIGN_CENTER;
            case 4:
            case 5:
                return Layout.Alignment.ALIGN_OPPOSITE;
            default:
                Log.w("WebvttCueParser", "Invalid alignment value: " + str);
                return null;
        }
    }

    private static int bJ(String str, int i) {
        int indexOf = str.indexOf(62, i);
        return indexOf == -1 ? str.length() : indexOf + 1;
    }

    private static void a(String str, SpannableStringBuilder spannableStringBuilder) {
        char c = 65535;
        switch (str.hashCode()) {
            case 3309:
                if (str.equals("gt")) {
                    c = 1;
                    break;
                }
                break;
            case 3464:
                if (str.equals("lt")) {
                    c = 0;
                    break;
                }
                break;
            case 96708:
                if (str.equals("amp")) {
                    c = 3;
                    break;
                }
                break;
            case 3374865:
                if (str.equals("nbsp")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                spannableStringBuilder.append('<');
                return;
            case 1:
                spannableStringBuilder.append('>');
                return;
            case 2:
                spannableStringBuilder.append(' ');
                return;
            case 3:
                spannableStringBuilder.append('&');
                return;
            default:
                Log.w("WebvttCueParser", "ignoring unsupported entity: '&" + str + ";'");
                return;
        }
    }

    private static boolean PY(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case 98:
                if (str.equals("b")) {
                    c = 0;
                    break;
                }
                break;
            case 99:
                if (str.equals("c")) {
                    c = 1;
                    break;
                }
                break;
            case 105:
                if (str.equals("i")) {
                    c = 2;
                    break;
                }
                break;
            case 117:
                if (str.equals("u")) {
                    c = 4;
                    break;
                }
                break;
            case 118:
                if (str.equals("v")) {
                    c = 5;
                    break;
                }
                break;
            case 3314158:
                if (str.equals("lang")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return true;
            default:
                return false;
        }
    }

    private static void a(String str, a aVar, SpannableStringBuilder spannableStringBuilder, List<d> list, List<b> list2) {
        int i = aVar.position;
        int length = spannableStringBuilder.length();
        String str2 = aVar.name;
        char c = 65535;
        switch (str2.hashCode()) {
            case 0:
                if (str2.equals("")) {
                    c = 6;
                    break;
                }
                break;
            case 98:
                if (str2.equals("b")) {
                    c = 0;
                    break;
                }
                break;
            case 99:
                if (str2.equals("c")) {
                    c = 3;
                    break;
                }
                break;
            case 105:
                if (str2.equals("i")) {
                    c = 1;
                    break;
                }
                break;
            case 117:
                if (str2.equals("u")) {
                    c = 2;
                    break;
                }
                break;
            case 118:
                if (str2.equals("v")) {
                    c = 5;
                    break;
                }
                break;
            case 3314158:
                if (str2.equals("lang")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                spannableStringBuilder.setSpan(new StyleSpan(1), i, length, 33);
                break;
            case 1:
                spannableStringBuilder.setSpan(new StyleSpan(2), i, length, 33);
                break;
            case 2:
                spannableStringBuilder.setSpan(new UnderlineSpan(), i, length, 33);
                break;
            case 3:
            case 4:
            case 5:
            case 6:
                break;
            default:
                return;
        }
        list2.clear();
        a(list, str, aVar, list2);
        int size = list2.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(spannableStringBuilder, list2.get(i2).mCu, i, length);
        }
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, d dVar, int i, int i2) {
        if (dVar != null) {
            if (dVar.getStyle() != -1) {
                spannableStringBuilder.setSpan(new StyleSpan(dVar.getStyle()), i, i2, 33);
            }
            if (dVar.dym()) {
                spannableStringBuilder.setSpan(new StrikethroughSpan(), i, i2, 33);
            }
            if (dVar.dyn()) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i, i2, 33);
            }
            if (dVar.dyp()) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(dVar.getFontColor()), i, i2, 33);
            }
            if (dVar.dyq()) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(dVar.getBackgroundColor()), i, i2, 33);
            }
            if (dVar.dyo() != null) {
                spannableStringBuilder.setSpan(new TypefaceSpan(dVar.dyo()), i, i2, 33);
            }
            if (dVar.dyr() != null) {
                spannableStringBuilder.setSpan(new AlignmentSpan.Standard(dVar.dyr()), i, i2, 33);
            }
            switch (dVar.dys()) {
                case 1:
                    spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) dVar.dyt(), true), i, i2, 33);
                    return;
                case 2:
                    spannableStringBuilder.setSpan(new RelativeSizeSpan(dVar.dyt()), i, i2, 33);
                    return;
                case 3:
                    spannableStringBuilder.setSpan(new RelativeSizeSpan(dVar.dyt() / 100.0f), i, i2, 33);
                    return;
                default:
                    return;
            }
        }
    }

    private static String Qj(String str) {
        String trim = str.trim();
        if (trim.isEmpty()) {
            return null;
        }
        return trim.split("[ \\.]")[0];
    }

    private static void a(List<d> list, String str, a aVar, List<b> list2) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            d dVar = list.get(i);
            int a2 = dVar.a(str, aVar.name, aVar.mCt, aVar.mCs);
            if (a2 > 0) {
                list2.add(new b(a2, dVar));
            }
        }
        Collections.sort(list2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class b implements Comparable<b> {
        public final d mCu;
        public final int score;

        public b(int i, d dVar) {
            this.score = i;
            this.mCu = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(@NonNull b bVar) {
            return this.score - bVar.score;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {
        private static final String[] mCr = new String[0];
        public final String mCs;
        public final String[] mCt;
        public final String name;
        public final int position;

        private a(String str, int i, String str2, String[] strArr) {
            this.position = i;
            this.name = str;
            this.mCs = str2;
            this.mCt = strArr;
        }

        public static a bK(String str, int i) {
            String substring;
            String str2;
            String[] strArr;
            String trim = str.trim();
            if (trim.isEmpty()) {
                return null;
            }
            int indexOf = trim.indexOf(HanziToPinyin.Token.SEPARATOR);
            if (indexOf == -1) {
                substring = trim;
                str2 = "";
            } else {
                String trim2 = trim.substring(indexOf).trim();
                substring = trim.substring(0, indexOf);
                str2 = trim2;
            }
            String[] split = substring.split("\\.");
            String str3 = split[0];
            if (split.length > 1) {
                strArr = (String[]) Arrays.copyOfRange(split, 1, split.length);
            } else {
                strArr = mCr;
            }
            return new a(str3, i, str2, strArr);
        }

        public static a dyx() {
            return new a("", 0, "", new String[0]);
        }
    }
}
