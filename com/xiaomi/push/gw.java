package com.xiaomi.push;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.down.manage.DownloadConstants;
import java.net.UnknownHostException;
/* loaded from: classes8.dex */
final class gw {

    /* loaded from: classes8.dex */
    static class a {
        fb a;

        /* renamed from: a  reason: collision with other field name */
        String f435a;

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a a(Exception exc) {
        m321a(exc);
        boolean z = exc instanceof fx;
        Exception exc2 = exc;
        if (z) {
            Throwable a2 = ((fx) exc).a();
            exc2 = exc;
            if (a2 != null) {
                exc2 = ((fx) exc).a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        String str = exc2.getClass().getSimpleName() + ":" + message;
        int a3 = fo.a(exc2);
        if (a3 != 0) {
            aVar.a = fb.a(a3 + fb.GSLB_REQUEST_SUCCESS.a());
        }
        if (aVar.a == null) {
            aVar.a = fb.GSLB_TCP_ERR_OTHER;
        }
        if (aVar.a == fb.GSLB_TCP_ERR_OTHER) {
            aVar.f435a = str;
        }
        return aVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static void m321a(Exception exc) {
        if (exc == null) {
            throw new NullPointerException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a b(Exception exc) {
        Throwable cause;
        m321a(exc);
        boolean z = exc instanceof fx;
        Exception exc2 = exc;
        if (z) {
            Throwable a2 = ((fx) exc).a();
            exc2 = exc;
            if (a2 != null) {
                exc2 = ((fx) exc).a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        int a3 = fo.a(exc2);
        String str = exc2.getClass().getSimpleName() + ":" + message;
        if (a3 != 0) {
            aVar.a = fb.a(a3 + fb.CONN_SUCCESS.a());
            if (aVar.a == fb.CONN_BOSH_ERR && (cause = exc2.getCause()) != null && (cause instanceof UnknownHostException)) {
                aVar.a = fb.CONN_BOSH_UNKNOWNHOST;
            }
        } else {
            aVar.a = fb.CONN_XMPP_ERR;
        }
        if (aVar.a == fb.CONN_TCP_ERR_OTHER || aVar.a == fb.CONN_XMPP_ERR || aVar.a == fb.CONN_BOSH_ERR) {
            aVar.f435a = str;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a c(Exception exc) {
        m321a(exc);
        boolean z = exc instanceof fx;
        Exception exc2 = exc;
        if (z) {
            Throwable a2 = ((fx) exc).a();
            exc2 = exc;
            if (a2 != null) {
                exc2 = ((fx) exc).a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        String str = exc2.getClass().getSimpleName() + ":" + message;
        switch (fo.a(exc2)) {
            case 105:
                aVar.a = fb.BIND_TCP_READ_TIMEOUT;
                break;
            case 109:
                aVar.a = fb.BIND_TCP_CONNRESET;
                break;
            case 110:
                aVar.a = fb.BIND_TCP_BROKEN_PIPE;
                break;
            case Opcodes.IFNONNULL /* 199 */:
                aVar.a = fb.BIND_TCP_ERR;
                break;
            case DownloadConstants.STATUS_DEVICE_NOT_FOUND_ERROR /* 499 */:
                aVar.a = fb.BIND_BOSH_ERR;
                if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                    aVar.a = fb.BIND_BOSH_ITEM_NOT_FOUND;
                    break;
                }
                break;
            default:
                aVar.a = fb.BIND_XMPP_ERR;
                break;
        }
        if (aVar.a == fb.BIND_TCP_ERR || aVar.a == fb.BIND_XMPP_ERR || aVar.a == fb.BIND_BOSH_ERR) {
            aVar.f435a = str;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a d(Exception exc) {
        m321a(exc);
        boolean z = exc instanceof fx;
        Exception exc2 = exc;
        if (z) {
            Throwable a2 = ((fx) exc).a();
            exc2 = exc;
            if (a2 != null) {
                exc2 = ((fx) exc).a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        String str = exc2.getClass().getSimpleName() + ":" + message;
        switch (fo.a(exc2)) {
            case 105:
                aVar.a = fb.CHANNEL_TCP_READTIMEOUT;
                break;
            case 109:
                aVar.a = fb.CHANNEL_TCP_CONNRESET;
                break;
            case 110:
                aVar.a = fb.CHANNEL_TCP_BROKEN_PIPE;
                break;
            case Opcodes.IFNONNULL /* 199 */:
                aVar.a = fb.CHANNEL_TCP_ERR;
                break;
            case DownloadConstants.STATUS_DEVICE_NOT_FOUND_ERROR /* 499 */:
                aVar.a = fb.CHANNEL_BOSH_EXCEPTION;
                if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                    aVar.a = fb.CHANNEL_BOSH_ITEMNOTFIND;
                    break;
                }
                break;
            default:
                aVar.a = fb.CHANNEL_XMPPEXCEPTION;
                break;
        }
        if (aVar.a == fb.CHANNEL_TCP_ERR || aVar.a == fb.CHANNEL_XMPPEXCEPTION || aVar.a == fb.CHANNEL_BOSH_EXCEPTION) {
            aVar.f435a = str;
        }
        return aVar;
    }
}
