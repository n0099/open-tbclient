package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.IStringUtil;
import com.bumptech.glide.load.engine.GlideException;
import com.google.android.gms.common.annotation.KeepForSdk;
@KeepForSdk
/* loaded from: classes9.dex */
public final class HexDumpUtils {
    @Nullable
    @KeepForSdk
    public static String dump(@NonNull byte[] bArr, int i, int i2, boolean z) {
        int length;
        int i3;
        if (bArr != null && (length = bArr.length) != 0 && i >= 0 && i2 > 0 && i + i2 <= length) {
            if (z) {
                i3 = 75;
            } else {
                i3 = 57;
            }
            StringBuilder sb = new StringBuilder(i3 * ((i2 + 15) / 16));
            int i4 = i2;
            int i5 = 0;
            int i6 = 0;
            while (i4 > 0) {
                if (i5 == 0) {
                    if (i2 < 65536) {
                        sb.append(String.format("%04X:", Integer.valueOf(i)));
                    } else {
                        sb.append(String.format("%08X:", Integer.valueOf(i)));
                    }
                    i6 = i;
                } else if (i5 == 8) {
                    sb.append(" -");
                }
                sb.append(String.format(" %02X", Integer.valueOf(bArr[i] & 255)));
                i4--;
                i5++;
                if (z && (i5 == 16 || i4 == 0)) {
                    int i7 = 16 - i5;
                    if (i7 > 0) {
                        for (int i8 = 0; i8 < i7; i8++) {
                            sb.append("   ");
                        }
                    }
                    if (i7 >= 8) {
                        sb.append(GlideException.IndentedAppendable.INDENT);
                    }
                    sb.append(GlideException.IndentedAppendable.INDENT);
                    for (int i9 = 0; i9 < i5; i9++) {
                        char c = (char) bArr[i6 + i9];
                        if (c < ' ' || c > '~') {
                            c = IStringUtil.EXTENSION_SEPARATOR;
                        }
                        sb.append(c);
                    }
                }
                if (i5 == 16 || i4 == 0) {
                    sb.append('\n');
                    i5 = 0;
                }
                i++;
            }
            return sb.toString();
        }
        return null;
    }
}
