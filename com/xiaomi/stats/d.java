package com.xiaomi.stats;

import com.xiaomi.smack.l;
import java.net.UnknownHostException;
/* loaded from: classes2.dex */
final class d {

    /* loaded from: classes2.dex */
    static class a {
        com.xiaomi.push.thrift.a a;
        String b;

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a a(Exception exc) {
        e(exc);
        boolean z = exc instanceof l;
        Exception exc2 = exc;
        if (z) {
            Throwable a2 = ((l) exc).a();
            exc2 = exc;
            if (a2 != null) {
                exc2 = ((l) exc).a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        String str = exc2.getClass().getSimpleName() + ":" + message;
        int a3 = com.xiaomi.smack.c.a(exc2);
        if (a3 != 0) {
            aVar.a = com.xiaomi.push.thrift.a.a(a3 + com.xiaomi.push.thrift.a.GSLB_REQUEST_SUCCESS.a());
        }
        if (aVar.a == null) {
            aVar.a = com.xiaomi.push.thrift.a.GSLB_TCP_ERR_OTHER;
        }
        if (aVar.a == com.xiaomi.push.thrift.a.GSLB_TCP_ERR_OTHER) {
            aVar.b = str;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a b(Exception exc) {
        Throwable cause;
        e(exc);
        boolean z = exc instanceof l;
        Exception exc2 = exc;
        if (z) {
            Throwable a2 = ((l) exc).a();
            exc2 = exc;
            if (a2 != null) {
                exc2 = ((l) exc).a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        int a3 = com.xiaomi.smack.c.a(exc2);
        String str = exc2.getClass().getSimpleName() + ":" + message;
        if (a3 != 0) {
            aVar.a = com.xiaomi.push.thrift.a.a(a3 + com.xiaomi.push.thrift.a.CONN_SUCCESS.a());
            if (aVar.a == com.xiaomi.push.thrift.a.CONN_BOSH_ERR && (cause = exc2.getCause()) != null && (cause instanceof UnknownHostException)) {
                aVar.a = com.xiaomi.push.thrift.a.CONN_BOSH_UNKNOWNHOST;
            }
        } else {
            aVar.a = com.xiaomi.push.thrift.a.CONN_XMPP_ERR;
        }
        if (aVar.a == com.xiaomi.push.thrift.a.CONN_TCP_ERR_OTHER || aVar.a == com.xiaomi.push.thrift.a.CONN_XMPP_ERR || aVar.a == com.xiaomi.push.thrift.a.CONN_BOSH_ERR) {
            aVar.b = str;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a c(Exception exc) {
        e(exc);
        boolean z = exc instanceof l;
        Exception exc2 = exc;
        if (z) {
            Throwable a2 = ((l) exc).a();
            exc2 = exc;
            if (a2 != null) {
                exc2 = ((l) exc).a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        String str = exc2.getClass().getSimpleName() + ":" + message;
        switch (com.xiaomi.smack.c.a(exc2)) {
            case 105:
                aVar.a = com.xiaomi.push.thrift.a.BIND_TCP_READ_TIMEOUT;
                break;
            case 109:
                aVar.a = com.xiaomi.push.thrift.a.BIND_TCP_CONNRESET;
                break;
            case 110:
                aVar.a = com.xiaomi.push.thrift.a.BIND_TCP_BROKEN_PIPE;
                break;
            case 199:
                aVar.a = com.xiaomi.push.thrift.a.BIND_TCP_ERR;
                break;
            case 499:
                aVar.a = com.xiaomi.push.thrift.a.BIND_BOSH_ERR;
                if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                    aVar.a = com.xiaomi.push.thrift.a.BIND_BOSH_ITEM_NOT_FOUND;
                    break;
                }
                break;
            default:
                aVar.a = com.xiaomi.push.thrift.a.BIND_XMPP_ERR;
                break;
        }
        if (aVar.a == com.xiaomi.push.thrift.a.BIND_TCP_ERR || aVar.a == com.xiaomi.push.thrift.a.BIND_XMPP_ERR || aVar.a == com.xiaomi.push.thrift.a.BIND_BOSH_ERR) {
            aVar.b = str;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a d(Exception exc) {
        e(exc);
        boolean z = exc instanceof l;
        Exception exc2 = exc;
        if (z) {
            Throwable a2 = ((l) exc).a();
            exc2 = exc;
            if (a2 != null) {
                exc2 = ((l) exc).a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        String str = exc2.getClass().getSimpleName() + ":" + message;
        switch (com.xiaomi.smack.c.a(exc2)) {
            case 105:
                aVar.a = com.xiaomi.push.thrift.a.CHANNEL_TCP_READTIMEOUT;
                break;
            case 109:
                aVar.a = com.xiaomi.push.thrift.a.CHANNEL_TCP_CONNRESET;
                break;
            case 110:
                aVar.a = com.xiaomi.push.thrift.a.CHANNEL_TCP_BROKEN_PIPE;
                break;
            case 199:
                aVar.a = com.xiaomi.push.thrift.a.CHANNEL_TCP_ERR;
                break;
            case 499:
                aVar.a = com.xiaomi.push.thrift.a.CHANNEL_BOSH_EXCEPTION;
                if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                    aVar.a = com.xiaomi.push.thrift.a.CHANNEL_BOSH_ITEMNOTFIND;
                    break;
                }
                break;
            default:
                aVar.a = com.xiaomi.push.thrift.a.CHANNEL_XMPPEXCEPTION;
                break;
        }
        if (aVar.a == com.xiaomi.push.thrift.a.CHANNEL_TCP_ERR || aVar.a == com.xiaomi.push.thrift.a.CHANNEL_XMPPEXCEPTION || aVar.a == com.xiaomi.push.thrift.a.CHANNEL_BOSH_EXCEPTION) {
            aVar.b = str;
        }
        return aVar;
    }

    private static void e(Exception exc) {
        if (exc == null) {
            throw new NullPointerException();
        }
    }
}
