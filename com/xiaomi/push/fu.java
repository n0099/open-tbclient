package com.xiaomi.push;

import com.alibaba.fastjson.asm.Opcodes;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
/* loaded from: classes12.dex */
public class fu {
    public static int a(Throwable th) {
        Throwable a2 = (!(th instanceof gd) || ((gd) th).a() == null) ? th : ((gd) th).a();
        String message = a2.getMessage();
        if (a2.getCause() != null) {
            message = a2.getCause().getMessage();
        }
        if (a2 instanceof SocketTimeoutException) {
            return 105;
        }
        if (!(a2 instanceof SocketException)) {
            if (a2 instanceof UnknownHostException) {
                return 107;
            }
            return th instanceof gd ? 399 : 0;
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
                return 110;
            }
            if (message.indexOf("No route to host") != -1) {
                return 104;
            }
            if (message.endsWith("EINVAL (Invalid argument)")) {
                return 106;
            }
            return Opcodes.IFNONNULL;
        }
    }
}
