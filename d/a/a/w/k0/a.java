package d.a.a.w.k0;

import com.baidu.android.common.others.IStringUtil;
/* loaded from: classes.dex */
public final class a {
    public static String a(int i, int[] iArr, String[] strArr, int[] iArr2) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2];
            if (i3 == 1 || i3 == 2) {
                sb.append('[');
                sb.append(iArr2[i2]);
                sb.append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sb.append(IStringUtil.EXTENSION_SEPARATOR);
                if (strArr[i2] != null) {
                    sb.append(strArr[i2]);
                }
            }
        }
        return sb.toString();
    }
}
