package com.xiaomi.smack;

import com.baidu.sapi2.SapiSafeFacade;
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
            return a instanceof UnknownHostException ? SapiSafeFacade.SAPIWEBVIEW_LOGIN : th instanceof l ? 399 : 0;
        } else if (message.indexOf("Network is unreachable") != -1) {
            return SapiSafeFacade.SAPIWEBVIEW_BACK;
        } else {
            if (message.indexOf("Connection refused") != -1) {
                return SapiSafeFacade.SAPIWEBVIEW_FINISH;
            }
            if (message.indexOf("Connection timed out") != -1) {
                return 105;
            }
            if (message.endsWith("EACCES (Permission denied)")) {
                return 101;
            }
            if (message.indexOf("Connection reset by peer") != -1) {
                return SapiSafeFacade.SAPIWEBVIEW_REG;
            }
            if (message.indexOf("Broken pipe") != -1) {
                return 110;
            }
            if (message.indexOf("No route to host") != -1) {
                return SapiSafeFacade.SAPIWEBVIEW_AUTHORIZATION;
            }
            if (message.endsWith("EINVAL (Invalid argument)")) {
                return SapiSafeFacade.SAPIWEBVIEW_MODIFY_PWD;
            }
            return 199;
        }
    }
}
