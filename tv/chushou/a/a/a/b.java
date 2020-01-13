package tv.chushou.a.a.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
/* loaded from: classes4.dex */
public final class b {
    public static boolean equals(@Nullable Object obj, @Nullable Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    @NonNull
    public static String format(@Nullable String str, @Nullable Object... objArr) {
        int i = 0;
        if (str == null) {
            str = "null";
        }
        int length = objArr == null ? 0 : objArr.length;
        StringBuilder sb = new StringBuilder(str.length() + (length * 16));
        int i2 = 0;
        while (i < length) {
            int indexOf = str.indexOf("%s", i2);
            if (indexOf == -1) {
                break;
            }
            sb.append((CharSequence) str, i2, indexOf);
            sb.append(objArr[i]);
            i2 = indexOf + 2;
            i++;
        }
        sb.append((CharSequence) str, i2, str.length());
        if (i < length) {
            sb.append(" [");
            sb.append(objArr[i]);
            for (int i3 = i + 1; i3 < objArr.length; i3++) {
                sb.append(", ");
                sb.append(objArr[i3]);
            }
            sb.append(']');
        }
        return sb.toString();
    }
}
