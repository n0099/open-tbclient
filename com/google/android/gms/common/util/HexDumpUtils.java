package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import com.google.android.gms.common.annotation.KeepForSdk;
@KeepForSdk
/* loaded from: classes7.dex */
public final class HexDumpUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public HexDumpUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Nullable
    @KeepForSdk
    public static String dump(@NonNull byte[] bArr, int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (bArr == null || (length = bArr.length) == 0 || i < 0 || i2 <= 0 || i + i2 > length) {
                return null;
            }
            StringBuilder sb = new StringBuilder((z ? 75 : 57) * ((i2 + 15) / 16));
            int i3 = i2;
            int i4 = 0;
            int i5 = 0;
            while (i3 > 0) {
                if (i4 == 0) {
                    if (i2 < 65536) {
                        sb.append(String.format("%04X:", Integer.valueOf(i)));
                    } else {
                        sb.append(String.format("%08X:", Integer.valueOf(i)));
                    }
                    i5 = i;
                } else if (i4 == 8) {
                    sb.append(" -");
                }
                sb.append(String.format(" %02X", Integer.valueOf(bArr[i] & 255)));
                i3--;
                i4++;
                if (z && (i4 == 16 || i3 == 0)) {
                    int i6 = 16 - i4;
                    if (i6 > 0) {
                        for (int i7 = 0; i7 < i6; i7++) {
                            sb.append("   ");
                        }
                    }
                    if (i6 >= 8) {
                        sb.append(GlideException.IndentedAppendable.INDENT);
                    }
                    sb.append(GlideException.IndentedAppendable.INDENT);
                    for (int i8 = 0; i8 < i4; i8++) {
                        char c = (char) bArr[i5 + i8];
                        if (c < ' ' || c > '~') {
                            c = IStringUtil.EXTENSION_SEPARATOR;
                        }
                        sb.append(c);
                    }
                }
                if (i4 == 16 || i3 == 0) {
                    sb.append('\n');
                    i4 = 0;
                }
                i++;
            }
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }
}
