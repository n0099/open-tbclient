package com.vivo.push.c;

import com.baidu.android.imsdk.IMConstants;
import com.baidu.mapapi.UIMsg;
/* loaded from: classes8.dex */
public final class ah {
    public static com.vivo.push.v a(com.vivo.push.y yVar) {
        switch (yVar.b()) {
            case 0:
            case 2000:
            case 2001:
            case 2002:
            case 2003:
            case 2004:
            case 2005:
            case UIMsg.m_AppUI.MSG_APP_VERSION_FORCE_NAV_MODULE /* 2008 */:
            case UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE /* 2009 */:
            case 2010:
            case IMConstants.IM_MSG_TYPE_SHIELD /* 2011 */:
            case IMConstants.IM_MSG_TYPE_SHIELD_ME /* 2012 */:
            case IMConstants.IM_MSG_TYPE_UNSUBSCRIBE_ME /* 2013 */:
            case IMConstants.IM_MSG_TYPE_UNSUBSCRIBE_ME_SEND_FAIL /* 2014 */:
                return new ai(yVar);
            case 1:
                return new ab(yVar);
            case 2:
                return new h(yVar);
            case 3:
                return new o(yVar);
            case 4:
                return new q(yVar);
            case 5:
                return new s(yVar);
            case 6:
                return new y(yVar);
            case 7:
                return new m(yVar);
            case 8:
                return new k(yVar);
            case 9:
                return new g(yVar);
            case 10:
                return new d(yVar);
            case 11:
                return new ae(yVar);
            case 12:
                return new f(yVar);
            case 20:
                return new ag(yVar);
            case 100:
                return new b(yVar);
            case 101:
                return new c(yVar);
            case UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND /* 2006 */:
                return new a(yVar);
            case UIMsg.m_AppUI.MSG_APP_VERSION_NAV_MODULE /* 2007 */:
                return new aj(yVar);
            default:
                return null;
        }
    }

    public static aa b(com.vivo.push.y yVar) {
        switch (yVar.b()) {
            case 1:
                return new ab(yVar);
            case 2:
                return new h(yVar);
            case 3:
                return new o(yVar);
            case 4:
                return new q(yVar);
            case 5:
                return new s(yVar);
            case 6:
                return new y(yVar);
            case 7:
                return new m(yVar);
            case 8:
                return new k(yVar);
            case 9:
                return new g(yVar);
            case 10:
                return new d(yVar);
            case 11:
                return new ae(yVar);
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            default:
                return null;
            case 20:
                return new ag(yVar);
        }
    }
}
