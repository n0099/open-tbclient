package com.google.android.gms.internal.common;

import com.baidu.android.common.others.lang.StringUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
/* loaded from: classes9.dex */
public final class zzy {
    public static String zza(@CheckForNull String str, @CheckForNull Object... objArr) {
        int length;
        int length2;
        int indexOf;
        String str2;
        String sb;
        int i = 0;
        int i2 = 0;
        while (true) {
            length = objArr.length;
            if (i2 >= length) {
                break;
            }
            Object obj = objArr[i2];
            if (obj == null) {
                sb = StringUtil.NULL_STRING;
            } else {
                try {
                    sb = obj.toString();
                } catch (Exception e) {
                    String name = obj.getClass().getName();
                    String hexString = Integer.toHexString(System.identityHashCode(obj));
                    StringBuilder sb2 = new StringBuilder(String.valueOf(name).length() + 1 + String.valueOf(hexString).length());
                    sb2.append(name);
                    sb2.append('@');
                    sb2.append(hexString);
                    String sb3 = sb2.toString();
                    Logger logger = Logger.getLogger("com.google.common.base.Strings");
                    Level level = Level.WARNING;
                    if (sb3.length() != 0) {
                        str2 = "Exception during lenientFormat for ".concat(sb3);
                    } else {
                        str2 = new String("Exception during lenientFormat for ");
                    }
                    logger.logp(level, "com.google.common.base.Strings", "lenientToString", str2, (Throwable) e);
                    String name2 = e.getClass().getName();
                    StringBuilder sb4 = new StringBuilder(sb3.length() + 9 + String.valueOf(name2).length());
                    sb4.append("<");
                    sb4.append(sb3);
                    sb4.append(" threw ");
                    sb4.append(name2);
                    sb4.append(">");
                    sb = sb4.toString();
                }
            }
            objArr[i2] = sb;
            i2++;
        }
        StringBuilder sb5 = new StringBuilder(str.length() + (length * 16));
        int i3 = 0;
        while (true) {
            length2 = objArr.length;
            if (i >= length2 || (indexOf = str.indexOf("%s", i3)) == -1) {
                break;
            }
            sb5.append((CharSequence) str, i3, indexOf);
            sb5.append(objArr[i]);
            i3 = indexOf + 2;
            i++;
        }
        sb5.append((CharSequence) str, i3, str.length());
        if (i < length2) {
            sb5.append(" [");
            sb5.append(objArr[i]);
            for (int i4 = i + 1; i4 < objArr.length; i4++) {
                sb5.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb5.append(objArr[i4]);
            }
            sb5.append(']');
        }
        return sb5.toString();
    }
}
