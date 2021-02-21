package com.facebook.d;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.manage.DownloadConstants;
import com.facebook.common.internal.g;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class b {
    public static int Qr(int i) {
        return d.Qr(i);
    }

    public static int z(InputStream inputStream) {
        try {
            int A = A(inputStream);
            if (A == 0) {
                return 0;
            }
            return d.h(inputStream, A);
        } catch (IOException e) {
            return 0;
        }
    }

    public static boolean g(InputStream inputStream, int i) throws IOException {
        g.checkNotNull(inputStream);
        while (c.a(inputStream, 1, false) == 255) {
            int i2 = 255;
            while (i2 == 255) {
                i2 = c.a(inputStream, 1, false);
            }
            if ((i == 192 && Qs(i2)) || i2 == i) {
                return true;
            }
            if (i2 != 216 && i2 != 1) {
                if (i2 == 217 || i2 == 218) {
                    return false;
                }
                inputStream.skip(c.a(inputStream, 2, false) - 2);
            }
        }
        return false;
    }

    private static boolean Qs(int i) {
        switch (i) {
            case 192:
            case 193:
            case DownloadConstants.STATUS_WAITING_TO_RETRY /* 194 */:
            case DownloadConstants.STATUS_WAITING_FOR_NETWORK /* 195 */:
            case Constants.METHOD_IM_DELIVER_CONFIG_MSG /* 197 */:
            case Opcodes.IFNULL /* 198 */:
            case Opcodes.IFNONNULL /* 199 */:
            case 201:
            case 202:
            case 203:
            case 205:
            case 206:
            case 207:
                return true;
            case 196:
            case 200:
            case 204:
            default:
                return false;
        }
    }

    private static int A(InputStream inputStream) throws IOException {
        int a2;
        if (g(inputStream, 225) && c.a(inputStream, 2, false) - 2 > 6) {
            int a3 = c.a(inputStream, 4, false);
            int a4 = c.a(inputStream, 2, false);
            int i = (a2 - 4) - 2;
            if (a3 == 1165519206 && a4 == 0) {
                return i;
            }
        }
        return 0;
    }
}
