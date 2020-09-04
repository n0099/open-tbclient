package com.xiaomi.push;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.down.manage.DownloadConstants;
import java.net.UnknownHostException;
/* loaded from: classes7.dex */
final class hc {

    /* loaded from: classes7.dex */
    static class a {
        fh a;

        /* renamed from: a  reason: collision with other field name */
        String f423a;

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a a(Exception exc) {
        m332a(exc);
        boolean z = exc instanceof gd;
        Exception exc2 = exc;
        if (z) {
            Throwable a2 = ((gd) exc).a();
            exc2 = exc;
            if (a2 != null) {
                exc2 = ((gd) exc).a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        String str = exc2.getClass().getSimpleName() + ":" + message;
        int a3 = fu.a(exc2);
        if (a3 != 0) {
            aVar.a = fh.a(a3 + fh.GSLB_REQUEST_SUCCESS.a());
        }
        if (aVar.a == null) {
            aVar.a = fh.GSLB_TCP_ERR_OTHER;
        }
        if (aVar.a == fh.GSLB_TCP_ERR_OTHER) {
            aVar.f423a = str;
        }
        return aVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static void m332a(Exception exc) {
        if (exc == null) {
            throw new NullPointerException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a b(Exception exc) {
        Throwable cause;
        m332a(exc);
        boolean z = exc instanceof gd;
        Exception exc2 = exc;
        if (z) {
            Throwable a2 = ((gd) exc).a();
            exc2 = exc;
            if (a2 != null) {
                exc2 = ((gd) exc).a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        int a3 = fu.a(exc2);
        String str = exc2.getClass().getSimpleName() + ":" + message;
        if (a3 != 0) {
            aVar.a = fh.a(a3 + fh.CONN_SUCCESS.a());
            if (aVar.a == fh.CONN_BOSH_ERR && (cause = exc2.getCause()) != null && (cause instanceof UnknownHostException)) {
                aVar.a = fh.CONN_BOSH_UNKNOWNHOST;
            }
        } else {
            aVar.a = fh.CONN_XMPP_ERR;
        }
        if (aVar.a == fh.CONN_TCP_ERR_OTHER || aVar.a == fh.CONN_XMPP_ERR || aVar.a == fh.CONN_BOSH_ERR) {
            aVar.f423a = str;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a c(Exception exc) {
        m332a(exc);
        boolean z = exc instanceof gd;
        Exception exc2 = exc;
        if (z) {
            Throwable a2 = ((gd) exc).a();
            exc2 = exc;
            if (a2 != null) {
                exc2 = ((gd) exc).a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        String str = exc2.getClass().getSimpleName() + ":" + message;
        switch (fu.a(exc2)) {
            case 105:
                aVar.a = fh.BIND_TCP_READ_TIMEOUT;
                break;
            case 109:
                aVar.a = fh.BIND_TCP_CONNRESET;
                break;
            case 110:
                aVar.a = fh.BIND_TCP_BROKEN_PIPE;
                break;
            case Opcodes.IFNONNULL /* 199 */:
                aVar.a = fh.BIND_TCP_ERR;
                break;
            case DownloadConstants.STATUS_DEVICE_NOT_FOUND_ERROR /* 499 */:
                aVar.a = fh.BIND_BOSH_ERR;
                if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                    aVar.a = fh.BIND_BOSH_ITEM_NOT_FOUND;
                    break;
                }
                break;
            default:
                aVar.a = fh.BIND_XMPP_ERR;
                break;
        }
        if (aVar.a == fh.BIND_TCP_ERR || aVar.a == fh.BIND_XMPP_ERR || aVar.a == fh.BIND_BOSH_ERR) {
            aVar.f423a = str;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a d(Exception exc) {
        m332a(exc);
        boolean z = exc instanceof gd;
        Exception exc2 = exc;
        if (z) {
            Throwable a2 = ((gd) exc).a();
            exc2 = exc;
            if (a2 != null) {
                exc2 = ((gd) exc).a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        String str = exc2.getClass().getSimpleName() + ":" + message;
        switch (fu.a(exc2)) {
            case 105:
                aVar.a = fh.CHANNEL_TCP_READTIMEOUT;
                break;
            case 109:
                aVar.a = fh.CHANNEL_TCP_CONNRESET;
                break;
            case 110:
                aVar.a = fh.CHANNEL_TCP_BROKEN_PIPE;
                break;
            case Opcodes.IFNONNULL /* 199 */:
                aVar.a = fh.CHANNEL_TCP_ERR;
                break;
            case DownloadConstants.STATUS_DEVICE_NOT_FOUND_ERROR /* 499 */:
                aVar.a = fh.CHANNEL_BOSH_EXCEPTION;
                if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                    aVar.a = fh.CHANNEL_BOSH_ITEMNOTFIND;
                    break;
                }
                break;
            default:
                aVar.a = fh.CHANNEL_XMPPEXCEPTION;
                break;
        }
        if (aVar.a == fh.CHANNEL_TCP_ERR || aVar.a == fh.CHANNEL_XMPPEXCEPTION || aVar.a == fh.CHANNEL_BOSH_EXCEPTION) {
            aVar.f423a = str;
        }
        return aVar;
    }
}
