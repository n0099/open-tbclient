package com.xiaomi.push;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.down.manage.DownloadConstants;
import java.net.UnknownHostException;
/* loaded from: classes6.dex */
final class hc {

    /* loaded from: classes6.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        fh f14080a;

        /* renamed from: a  reason: collision with other field name */
        String f501a;

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a a(Exception exc) {
        m357a(exc);
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
            aVar.f14080a = fh.a(a3 + fh.GSLB_REQUEST_SUCCESS.a());
        }
        if (aVar.f14080a == null) {
            aVar.f14080a = fh.GSLB_TCP_ERR_OTHER;
        }
        if (aVar.f14080a == fh.GSLB_TCP_ERR_OTHER) {
            aVar.f501a = str;
        }
        return aVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static void m357a(Exception exc) {
        if (exc == null) {
            throw new NullPointerException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a b(Exception exc) {
        Throwable cause;
        m357a(exc);
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
            aVar.f14080a = fh.a(a3 + fh.CONN_SUCCESS.a());
            if (aVar.f14080a == fh.CONN_BOSH_ERR && (cause = exc2.getCause()) != null && (cause instanceof UnknownHostException)) {
                aVar.f14080a = fh.CONN_BOSH_UNKNOWNHOST;
            }
        } else {
            aVar.f14080a = fh.CONN_XMPP_ERR;
        }
        if (aVar.f14080a == fh.CONN_TCP_ERR_OTHER || aVar.f14080a == fh.CONN_XMPP_ERR || aVar.f14080a == fh.CONN_BOSH_ERR) {
            aVar.f501a = str;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a c(Exception exc) {
        m357a(exc);
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
                aVar.f14080a = fh.BIND_TCP_READ_TIMEOUT;
                break;
            case 109:
                aVar.f14080a = fh.BIND_TCP_CONNRESET;
                break;
            case 110:
                aVar.f14080a = fh.BIND_TCP_BROKEN_PIPE;
                break;
            case Opcodes.IFNONNULL /* 199 */:
                aVar.f14080a = fh.BIND_TCP_ERR;
                break;
            case DownloadConstants.STATUS_DEVICE_NOT_FOUND_ERROR /* 499 */:
                aVar.f14080a = fh.BIND_BOSH_ERR;
                if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                    aVar.f14080a = fh.BIND_BOSH_ITEM_NOT_FOUND;
                    break;
                }
                break;
            default:
                aVar.f14080a = fh.BIND_XMPP_ERR;
                break;
        }
        if (aVar.f14080a == fh.BIND_TCP_ERR || aVar.f14080a == fh.BIND_XMPP_ERR || aVar.f14080a == fh.BIND_BOSH_ERR) {
            aVar.f501a = str;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a d(Exception exc) {
        m357a(exc);
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
                aVar.f14080a = fh.CHANNEL_TCP_READTIMEOUT;
                break;
            case 109:
                aVar.f14080a = fh.CHANNEL_TCP_CONNRESET;
                break;
            case 110:
                aVar.f14080a = fh.CHANNEL_TCP_BROKEN_PIPE;
                break;
            case Opcodes.IFNONNULL /* 199 */:
                aVar.f14080a = fh.CHANNEL_TCP_ERR;
                break;
            case DownloadConstants.STATUS_DEVICE_NOT_FOUND_ERROR /* 499 */:
                aVar.f14080a = fh.CHANNEL_BOSH_EXCEPTION;
                if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                    aVar.f14080a = fh.CHANNEL_BOSH_ITEMNOTFIND;
                    break;
                }
                break;
            default:
                aVar.f14080a = fh.CHANNEL_XMPPEXCEPTION;
                break;
        }
        if (aVar.f14080a == fh.CHANNEL_TCP_ERR || aVar.f14080a == fh.CHANNEL_XMPPEXCEPTION || aVar.f14080a == fh.CHANNEL_BOSH_EXCEPTION) {
            aVar.f501a = str;
        }
        return aVar;
    }
}
