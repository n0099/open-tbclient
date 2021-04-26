package d.a.i0.z0;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
/* loaded from: classes3.dex */
public class i0 {

    /* renamed from: a  reason: collision with root package name */
    public static TextView f50136a;

    public static int a(char c2) {
        return f(c2) ? 1 : 2;
    }

    public static int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            i2 = f(str.charAt(i3)) ? i2 + 1 : i2 + 2;
        }
        return i2;
    }

    public static int c(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int codePointCount = str.codePointCount(0, str.length());
        int i2 = 0;
        for (int i3 = 1; i3 <= codePointCount; i3++) {
            str.substring(str.offsetByCodePoints(0, i3 - 1), str.offsetByCodePoints(0, i3)).length();
            i2++;
        }
        return i2;
    }

    public static int d(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int codePointCount = str.codePointCount(0, str.length());
        int i2 = 0;
        for (int i3 = 1; i3 <= codePointCount; i3++) {
            String substring = str.substring(str.offsetByCodePoints(0, i3 - 1), str.offsetByCodePoints(0, i3));
            i2 = substring.length() >= 2 ? i2 + 2 : i2 + b(substring);
        }
        return i2;
    }

    public static String e(String str, int i2) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (b(str) > i2) {
            return k(str, 0, i2 - 2) + StringHelper.STRING_MORE;
        }
        return str;
    }

    public static boolean f(char c2) {
        if (c2 < 'a' || c2 > 'z') {
            if (c2 < 'A' || c2 > 'Z') {
                return (c2 >= '0' && c2 <= '9') || c2 == ' ';
            }
            return true;
        }
        return true;
    }

    public static boolean g(char c2) {
        if (c2 < 'a' || c2 > 'z') {
            return (c2 >= '0' && c2 <= '9') || c2 == ' ';
        }
        return true;
    }

    public static boolean h(char c2) {
        return c2 >= 55296 && c2 <= 56319;
    }

    public static Pair<Integer, Integer> i(String str, int i2, int i3) {
        try {
            if (f50136a == null) {
                f50136a = new TextView(TbadkCoreApplication.getInst().getContext());
            }
            TextView textView = f50136a;
            if (textView.getLayoutParams() == null) {
                textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            }
            textView.setText(str);
            textView.setTextSize(0, i2);
            textView.measure(View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
            return new Pair<>(Integer.valueOf(textView.getMeasuredHeight()), Integer.valueOf(textView.getLineCount()));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String j(String str, int i2) {
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
            return sb.toString();
        }
        if (i2 > 0) {
            int i3 = 0;
            for (int i4 = 0; i4 < str.length(); i4++) {
                char charAt = str.charAt(i4);
                if (i3 >= i2) {
                    if (i3 == i2) {
                        return sb.toString();
                    }
                    return sb.deleteCharAt(sb.length() - 1).toString();
                }
                if (i3 >= 0) {
                    sb.append(charAt);
                }
                i3 = g(charAt) ? i3 + 1 : i3 + 2;
            }
        }
        return sb.toString();
    }

    public static String k(String str, int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && i2 <= i3) {
            if (i2 >= 0 && i3 >= 0) {
                int i4 = 0;
                for (int i5 = 0; i5 < str.length(); i5++) {
                    char charAt = str.charAt(i5);
                    if (i4 >= i3) {
                        if (i4 == i3) {
                            if (h(sb.charAt(sb.length() - 1))) {
                                sb.append(charAt);
                                return sb.toString();
                            }
                            return sb.toString();
                        } else if (sb.length() > 2 && h(sb.charAt(sb.length() - 2))) {
                            return sb.toString();
                        } else {
                            return sb.deleteCharAt(sb.length() - 1).toString();
                        }
                    }
                    if (i4 >= i2) {
                        sb.append(charAt);
                    }
                    i4 = f(charAt) ? i4 + 1 : i4 + 2;
                }
            }
            return sb.toString();
        }
        return sb.toString();
    }

    public static String l(String str, int i2) {
        int codePointCount = str.codePointCount(0, str.length());
        int i3 = 1;
        String str2 = str;
        while (i3 <= codePointCount) {
            String substring = str.substring(0, str.offsetByCodePoints(0, i3));
            if (c(substring) > i2) {
                break;
            }
            i3++;
            str2 = substring;
        }
        return str2;
    }

    public static String m(String str, int i2) {
        int codePointCount = str.codePointCount(0, str.length());
        int i3 = 1;
        String str2 = str;
        while (i3 <= codePointCount) {
            String substring = str.substring(0, str.offsetByCodePoints(0, i3));
            if (d(substring) > i2) {
                break;
            }
            i3++;
            str2 = substring;
        }
        return str2;
    }
}
