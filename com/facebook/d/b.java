package com.facebook.d;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.manage.DownloadConstants;
import com.facebook.common.internal.g;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpStatus;
/* loaded from: classes12.dex */
public class b {
    public static int MZ(int i) {
        return d.MZ(i);
    }

    public static int x(InputStream inputStream) {
        try {
            int y = y(inputStream);
            if (y == 0) {
                return 0;
            }
            return d.h(inputStream, y);
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
            if ((i == 192 && Na(i2)) || i2 == i) {
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

    private static boolean Na(int i) {
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
            case HttpStatus.SC_MULTI_STATUS /* 207 */:
                return true;
            case 196:
            case 200:
            case 204:
            default:
                return false;
        }
    }

    private static int y(InputStream inputStream) throws IOException {
        int a;
        if (g(inputStream, 225) && c.a(inputStream, 2, false) - 2 > 6) {
            int a2 = c.a(inputStream, 4, false);
            int a3 = c.a(inputStream, 2, false);
            int i = (a - 4) - 2;
            if (a2 == 1165519206 && a3 == 0) {
                return i;
            }
        }
        return 0;
    }
}
