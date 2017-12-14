package com.xiaomi.smack;

import com.baidu.tbadk.TbConfig;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
/* loaded from: classes2.dex */
public class c {
    public static int a(Throwable th) {
        Throwable a = (!(th instanceof l) || ((l) th).a() == null) ? th : ((l) th).a();
        String message = a.getMessage();
        if (a.getCause() != null) {
            message = a.getCause().getMessage();
        }
        if (a instanceof SocketTimeoutException) {
            return 105;
        }
        if (!(a instanceof SocketException)) {
            if (a instanceof UnknownHostException) {
                return 107;
            }
            return th instanceof l ? 399 : 0;
        } else if (message.indexOf("Network is unreachable") != -1) {
            return 102;
        } else {
            if (message.indexOf("Connection refused") != -1) {
                return 103;
            }
            if (message.indexOf("Connection timed out") != -1) {
                return 105;
            }
            if (message.endsWith("EACCES (Permission denied)")) {
                return 101;
            }
            if (message.indexOf("Connection reset by peer") != -1) {
                return 109;
            }
            if (message.indexOf("Broken pipe") != -1) {
                return TbConfig.BIG_PHOTO_MAX_SIZE;
            }
            if (message.indexOf("No route to host") != -1) {
                return 104;
            }
            return message.endsWith("EINVAL (Invalid argument)") ? 106 : 199;
        }
    }
}
