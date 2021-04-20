package d.g.c.a;

import com.baidu.android.common.others.lang.StringUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes6.dex */
public final class q {
    public static boolean a(String str) {
        return m.e(str);
    }

    public static String b(String str, Object... objArr) {
        int indexOf;
        String valueOf = String.valueOf(str);
        int i = 0;
        if (objArr == null) {
            objArr = new Object[]{"(Object[])null"};
        } else {
            for (int i2 = 0; i2 < objArr.length; i2++) {
                objArr[i2] = c(objArr[i2]);
            }
        }
        StringBuilder sb = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i3 = 0;
        while (i < objArr.length && (indexOf = valueOf.indexOf("%s", i3)) != -1) {
            sb.append((CharSequence) valueOf, i3, indexOf);
            sb.append(objArr[i]);
            i3 = indexOf + 2;
            i++;
        }
        sb.append((CharSequence) valueOf, i3, valueOf.length());
        if (i < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i]);
            for (int i4 = i + 1; i4 < objArr.length; i4++) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(objArr[i4]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static String c(Object obj) {
        try {
            return String.valueOf(obj);
        } catch (Exception e2) {
            String str = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
            Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + str, (Throwable) e2);
            return "<" + str + " threw " + e2.getClass().getName() + ">";
        }
    }
}
