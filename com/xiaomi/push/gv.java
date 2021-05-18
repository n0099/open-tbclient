package com.xiaomi.push;

import java.net.UnknownHostException;
/* loaded from: classes7.dex */
public final class gv {

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public ew f37764a;

        /* renamed from: a  reason: collision with other field name */
        public String f452a;
    }

    public static a a(Exception exc) {
        m348a(exc);
        boolean z = exc instanceof fw;
        Exception exc2 = exc;
        if (z) {
            fw fwVar = (fw) exc;
            exc2 = exc;
            if (fwVar.a() != null) {
                exc2 = fwVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        String str = exc2.getClass().getSimpleName() + ":" + message;
        int a2 = fn.a(exc2);
        if (a2 != 0) {
            aVar.f37764a = ew.a(ew.GSLB_REQUEST_SUCCESS.a() + a2);
        }
        if (aVar.f37764a == null) {
            aVar.f37764a = ew.GSLB_TCP_ERR_OTHER;
        }
        if (aVar.f37764a == ew.GSLB_TCP_ERR_OTHER) {
            aVar.f452a = str;
        }
        return aVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m348a(Exception exc) {
        if (exc == null) {
            throw null;
        }
    }

    public static a b(Exception exc) {
        ew ewVar;
        ew ewVar2;
        Throwable cause;
        m348a(exc);
        boolean z = exc instanceof fw;
        Exception exc2 = exc;
        if (z) {
            fw fwVar = (fw) exc;
            exc2 = exc;
            if (fwVar.a() != null) {
                exc2 = fwVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        int a2 = fn.a(exc2);
        String str = exc2.getClass().getSimpleName() + ":" + message;
        if (a2 != 0) {
            ew a3 = ew.a(ew.CONN_SUCCESS.a() + a2);
            aVar.f37764a = a3;
            if (a3 == ew.CONN_BOSH_ERR && (cause = exc2.getCause()) != null && (cause instanceof UnknownHostException)) {
                ewVar = ew.CONN_BOSH_UNKNOWNHOST;
            }
            ewVar2 = aVar.f37764a;
            if (ewVar2 != ew.CONN_TCP_ERR_OTHER || ewVar2 == ew.CONN_XMPP_ERR || ewVar2 == ew.CONN_BOSH_ERR) {
                aVar.f452a = str;
            }
            return aVar;
        }
        ewVar = ew.CONN_XMPP_ERR;
        aVar.f37764a = ewVar;
        ewVar2 = aVar.f37764a;
        if (ewVar2 != ew.CONN_TCP_ERR_OTHER) {
        }
        aVar.f452a = str;
        return aVar;
    }

    public static a c(Exception exc) {
        ew ewVar;
        ew ewVar2;
        m348a(exc);
        boolean z = exc instanceof fw;
        Exception exc2 = exc;
        if (z) {
            fw fwVar = (fw) exc;
            exc2 = exc;
            if (fwVar.a() != null) {
                exc2 = fwVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        int a2 = fn.a(exc2);
        String str = exc2.getClass().getSimpleName() + ":" + message;
        if (a2 == 105) {
            ewVar = ew.BIND_TCP_READ_TIMEOUT;
        } else if (a2 == 199) {
            ewVar = ew.BIND_TCP_ERR;
        } else if (a2 == 499) {
            aVar.f37764a = ew.BIND_BOSH_ERR;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                ewVar = ew.BIND_BOSH_ITEM_NOT_FOUND;
            }
            ewVar2 = aVar.f37764a;
            if (ewVar2 != ew.BIND_TCP_ERR || ewVar2 == ew.BIND_XMPP_ERR || ewVar2 == ew.BIND_BOSH_ERR) {
                aVar.f452a = str;
            }
            return aVar;
        } else {
            ewVar = a2 != 109 ? a2 != 110 ? ew.BIND_XMPP_ERR : ew.BIND_TCP_BROKEN_PIPE : ew.BIND_TCP_CONNRESET;
        }
        aVar.f37764a = ewVar;
        ewVar2 = aVar.f37764a;
        if (ewVar2 != ew.BIND_TCP_ERR) {
        }
        aVar.f452a = str;
        return aVar;
    }

    public static a d(Exception exc) {
        ew ewVar;
        ew ewVar2;
        m348a(exc);
        boolean z = exc instanceof fw;
        Exception exc2 = exc;
        if (z) {
            fw fwVar = (fw) exc;
            exc2 = exc;
            if (fwVar.a() != null) {
                exc2 = fwVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        int a2 = fn.a(exc2);
        String str = exc2.getClass().getSimpleName() + ":" + message;
        if (a2 == 105) {
            ewVar = ew.CHANNEL_TCP_READTIMEOUT;
        } else if (a2 == 199) {
            ewVar = ew.CHANNEL_TCP_ERR;
        } else if (a2 == 499) {
            aVar.f37764a = ew.CHANNEL_BOSH_EXCEPTION;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                ewVar = ew.CHANNEL_BOSH_ITEMNOTFIND;
            }
            ewVar2 = aVar.f37764a;
            if (ewVar2 != ew.CHANNEL_TCP_ERR || ewVar2 == ew.CHANNEL_XMPPEXCEPTION || ewVar2 == ew.CHANNEL_BOSH_EXCEPTION) {
                aVar.f452a = str;
            }
            return aVar;
        } else {
            ewVar = a2 != 109 ? a2 != 110 ? ew.CHANNEL_XMPPEXCEPTION : ew.CHANNEL_TCP_BROKEN_PIPE : ew.CHANNEL_TCP_CONNRESET;
        }
        aVar.f37764a = ewVar;
        ewVar2 = aVar.f37764a;
        if (ewVar2 != ew.CHANNEL_TCP_ERR) {
        }
        aVar.f452a = str;
        return aVar;
    }
}
