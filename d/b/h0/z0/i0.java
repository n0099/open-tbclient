package d.b.h0.z0;

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
    public static TextView f51697a;

    public static int a(char c2) {
        return f(c2) ? 1 : 2;
    }

    public static int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            i = f(str.charAt(i2)) ? i + 1 : i + 2;
        }
        return i;
    }

    public static int c(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int codePointCount = str.codePointCount(0, str.length());
        int i = 0;
        for (int i2 = 1; i2 <= codePointCount; i2++) {
            str.substring(str.offsetByCodePoints(0, i2 - 1), str.offsetByCodePoints(0, i2)).length();
            i++;
        }
        return i;
    }

    public static int d(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int codePointCount = str.codePointCount(0, str.length());
        int i = 0;
        for (int i2 = 1; i2 <= codePointCount; i2++) {
            String substring = str.substring(str.offsetByCodePoints(0, i2 - 1), str.offsetByCodePoints(0, i2));
            i = substring.length() >= 2 ? i + 2 : i + b(substring);
        }
        return i;
    }

    public static String e(String str, int i) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (b(str) > i) {
            return k(str, 0, i - 2) + StringHelper.STRING_MORE;
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

    public static Pair<Integer, Integer> i(String str, int i, int i2) {
        try {
            if (f51697a == null) {
                f51697a = new TextView(TbadkCoreApplication.getInst().getContext());
            }
            TextView textView = f51697a;
            if (textView.getLayoutParams() == null) {
                textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            }
            textView.setText(str);
            textView.setTextSize(0, i);
            textView.measure(View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
            return new Pair<>(Integer.valueOf(textView.getMeasuredHeight()), Integer.valueOf(textView.getLineCount()));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String j(String str, int i) {
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
            return sb.toString();
        }
        if (i > 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < str.length(); i3++) {
                char charAt = str.charAt(i3);
                if (i2 >= i) {
                    if (i2 == i) {
                        return sb.toString();
                    }
                    return sb.deleteCharAt(sb.length() - 1).toString();
                }
                if (i2 >= 0) {
                    sb.append(charAt);
                }
                i2 = g(charAt) ? i2 + 1 : i2 + 2;
            }
        }
        return sb.toString();
    }

    public static String k(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && i <= i2) {
            if (i >= 0 && i2 >= 0) {
                int i3 = 0;
                for (int i4 = 0; i4 < str.length(); i4++) {
                    char charAt = str.charAt(i4);
                    if (i3 >= i2) {
                        if (i3 == i2) {
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
                    if (i3 >= i) {
                        sb.append(charAt);
                    }
                    i3 = f(charAt) ? i3 + 1 : i3 + 2;
                }
            }
            return sb.toString();
        }
        return sb.toString();
    }

    public static String l(String str, int i) {
        int codePointCount = str.codePointCount(0, str.length());
        int i2 = 1;
        String str2 = str;
        while (i2 <= codePointCount) {
            String substring = str.substring(0, str.offsetByCodePoints(0, i2));
            if (c(substring) > i) {
                break;
            }
            i2++;
            str2 = substring;
        }
        return str2;
    }

    public static String m(String str, int i) {
        int codePointCount = str.codePointCount(0, str.length());
        int i2 = 1;
        String str2 = str;
        while (i2 <= codePointCount) {
            String substring = str.substring(0, str.offsetByCodePoints(0, i2));
            if (d(substring) > i) {
                break;
            }
            i2++;
            str2 = substring;
        }
        return str2;
    }
}
