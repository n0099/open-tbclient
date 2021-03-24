package d.o.a.e.b.l;

import kotlin.text.Typography;
/* loaded from: classes7.dex */
public class f {
    public static String a(String str, String str2, String[] strArr) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(Typography.quote);
        sb.append(str2);
        sb.append(Typography.quote);
        sb.append(" (");
        h(sb, strArr);
        sb.append(") VALUES (");
        d(sb, strArr.length);
        sb.append(')');
        return sb.toString();
    }

    public static String b(String str, String[] strArr) {
        String str2 = Typography.quote + str + Typography.quote;
        StringBuilder sb = new StringBuilder("DELETE FROM ");
        sb.append(str2);
        if (strArr != null && strArr.length > 0) {
            sb.append(" WHERE ");
            g(sb, str2, strArr);
        }
        return sb.toString();
    }

    public static String c(String str, String[] strArr, String[] strArr2) {
        String str2 = Typography.quote + str + Typography.quote;
        StringBuilder sb = new StringBuilder("UPDATE ");
        sb.append(str2);
        sb.append(" SET ");
        j(sb, strArr);
        if (strArr2 != null && strArr2.length > 0) {
            sb.append(" WHERE ");
            g(sb, str2, strArr2);
        }
        return sb.toString();
    }

    public static StringBuilder d(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 < i - 1) {
                sb.append("?,");
            } else {
                sb.append('?');
            }
        }
        return sb;
    }

    public static StringBuilder e(StringBuilder sb, String str) {
        sb.append(Typography.quote);
        sb.append(str);
        sb.append(Typography.quote);
        return sb;
    }

    public static StringBuilder f(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(".\"");
        sb.append(str2);
        sb.append(Typography.quote);
        return sb;
    }

    public static StringBuilder g(StringBuilder sb, String str, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            f(sb, str, strArr[i]);
            sb.append("=?");
            if (i < strArr.length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static StringBuilder h(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(Typography.quote);
            sb.append(strArr[i]);
            sb.append(Typography.quote);
            if (i < length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static String i(String str, String[] strArr, String[] strArr2) {
        StringBuilder sb = new StringBuilder("INSERT OR REPLACE INTO ");
        sb.append(Typography.quote + str + Typography.quote);
        sb.append(" (");
        h(sb, strArr);
        sb.append(") VALUES (");
        d(sb, strArr.length);
        sb.append(')');
        return sb.toString();
    }

    public static StringBuilder j(StringBuilder sb, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            e(sb, strArr[i]);
            sb.append("=?");
            if (i < strArr.length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }
}
