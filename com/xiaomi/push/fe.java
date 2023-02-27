package com.xiaomi.push;

import java.net.UnknownHostException;
/* loaded from: classes8.dex */
public final class fe {

    /* loaded from: classes8.dex */
    public static class a {
        public ey a;

        /* renamed from: a  reason: collision with other field name */
        public String f360a;
    }

    public static a a(Exception exc) {
        m390a(exc);
        boolean z = exc instanceof gg;
        Exception exc2 = exc;
        if (z) {
            gg ggVar = (gg) exc;
            exc2 = exc;
            if (ggVar.a() != null) {
                exc2 = ggVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        String str = exc2.getClass().getSimpleName() + ":" + message;
        int a2 = fx.a(exc2);
        if (a2 != 0) {
            aVar.a = ey.a(ey.GSLB_REQUEST_SUCCESS.a() + a2);
        }
        if (aVar.a == null) {
            aVar.a = ey.GSLB_TCP_ERR_OTHER;
        }
        if (aVar.a == ey.GSLB_TCP_ERR_OTHER) {
            aVar.f360a = str;
        }
        return aVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m390a(Exception exc) {
        if (exc == null) {
            throw null;
        }
    }

    public static a b(Exception exc) {
        ey eyVar;
        ey eyVar2;
        Throwable cause;
        m390a(exc);
        boolean z = exc instanceof gg;
        Exception exc2 = exc;
        if (z) {
            gg ggVar = (gg) exc;
            exc2 = exc;
            if (ggVar.a() != null) {
                exc2 = ggVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        int a2 = fx.a(exc2);
        String str = exc2.getClass().getSimpleName() + ":" + message;
        if (a2 != 0) {
            ey a3 = ey.a(ey.CONN_SUCCESS.a() + a2);
            aVar.a = a3;
            if (a3 == ey.CONN_BOSH_ERR && (cause = exc2.getCause()) != null && (cause instanceof UnknownHostException)) {
                eyVar = ey.CONN_BOSH_UNKNOWNHOST;
            }
            eyVar2 = aVar.a;
            if (eyVar2 != ey.CONN_TCP_ERR_OTHER || eyVar2 == ey.CONN_XMPP_ERR || eyVar2 == ey.CONN_BOSH_ERR) {
                aVar.f360a = str;
            }
            return aVar;
        }
        eyVar = ey.CONN_XMPP_ERR;
        aVar.a = eyVar;
        eyVar2 = aVar.a;
        if (eyVar2 != ey.CONN_TCP_ERR_OTHER) {
        }
        aVar.f360a = str;
        return aVar;
    }

    public static a c(Exception exc) {
        ey eyVar;
        ey eyVar2;
        m390a(exc);
        boolean z = exc instanceof gg;
        Exception exc2 = exc;
        if (z) {
            gg ggVar = (gg) exc;
            exc2 = exc;
            if (ggVar.a() != null) {
                exc2 = ggVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        int a2 = fx.a(exc2);
        String str = exc2.getClass().getSimpleName() + ":" + message;
        if (a2 == 105) {
            eyVar = ey.BIND_TCP_READ_TIMEOUT;
        } else if (a2 == 199) {
            eyVar = ey.BIND_TCP_ERR;
        } else if (a2 == 499) {
            aVar.a = ey.BIND_BOSH_ERR;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                eyVar = ey.BIND_BOSH_ITEM_NOT_FOUND;
            }
            eyVar2 = aVar.a;
            if (eyVar2 != ey.BIND_TCP_ERR || eyVar2 == ey.BIND_XMPP_ERR || eyVar2 == ey.BIND_BOSH_ERR) {
                aVar.f360a = str;
            }
            return aVar;
        } else {
            eyVar = a2 != 109 ? a2 != 110 ? ey.BIND_XMPP_ERR : ey.BIND_TCP_BROKEN_PIPE : ey.BIND_TCP_CONNRESET;
        }
        aVar.a = eyVar;
        eyVar2 = aVar.a;
        if (eyVar2 != ey.BIND_TCP_ERR) {
        }
        aVar.f360a = str;
        return aVar;
    }

    public static a d(Exception exc) {
        ey eyVar;
        ey eyVar2;
        m390a(exc);
        boolean z = exc instanceof gg;
        Exception exc2 = exc;
        if (z) {
            gg ggVar = (gg) exc;
            exc2 = exc;
            if (ggVar.a() != null) {
                exc2 = ggVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        int a2 = fx.a(exc2);
        String str = exc2.getClass().getSimpleName() + ":" + message;
        if (a2 == 105) {
            eyVar = ey.CHANNEL_TCP_READTIMEOUT;
        } else if (a2 == 199) {
            eyVar = ey.CHANNEL_TCP_ERR;
        } else if (a2 == 499) {
            aVar.a = ey.CHANNEL_BOSH_EXCEPTION;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                eyVar = ey.CHANNEL_BOSH_ITEMNOTFIND;
            }
            eyVar2 = aVar.a;
            if (eyVar2 != ey.CHANNEL_TCP_ERR || eyVar2 == ey.CHANNEL_XMPPEXCEPTION || eyVar2 == ey.CHANNEL_BOSH_EXCEPTION) {
                aVar.f360a = str;
            }
            return aVar;
        } else {
            eyVar = a2 != 109 ? a2 != 110 ? ey.CHANNEL_XMPPEXCEPTION : ey.CHANNEL_TCP_BROKEN_PIPE : ey.CHANNEL_TCP_CONNRESET;
        }
        aVar.a = eyVar;
        eyVar2 = aVar.a;
        if (eyVar2 != ey.CHANNEL_TCP_ERR) {
        }
        aVar.f360a = str;
        return aVar;
    }
}
