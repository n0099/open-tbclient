package com.vivo.push.c;

import com.baidu.mapapi.UIMsg;
/* loaded from: classes3.dex */
public final class ah {
    public static com.vivo.push.s a(com.vivo.push.v vVar) {
        switch (vVar.b()) {
            case 0:
            case 2000:
            case 2001:
            case 2002:
            case 2003:
            case 2004:
            case 2005:
            case UIMsg.m_AppUI.MSG_APP_VERSION_FORCE_NAV_MODULE /* 2008 */:
            case UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE /* 2009 */:
            case UIMsg.m_AppUI.V_WM_PERMCHECK /* 2010 */:
            case 2011:
            case 2012:
            case 2013:
                return new ai(vVar);
            case 1:
                return new ab(vVar);
            case 2:
                return new h(vVar);
            case 3:
                return new o(vVar);
            case 4:
                return new q(vVar);
            case 5:
                return new s(vVar);
            case 6:
                return new y(vVar);
            case 7:
                return new m(vVar);
            case 8:
                return new k(vVar);
            case 9:
                return new g(vVar);
            case 10:
                return new d(vVar);
            case 11:
                return new ae(vVar);
            case 12:
                return new f(vVar);
            case 20:
                return new ag(vVar);
            case 100:
                return new b(vVar);
            case 101:
                return new c(vVar);
            case UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND /* 2006 */:
                return new a(vVar);
            case UIMsg.m_AppUI.MSG_APP_VERSION_NAV_MODULE /* 2007 */:
                return new aj(vVar);
            default:
                return null;
        }
    }

    public static aa b(com.vivo.push.v vVar) {
        switch (vVar.b()) {
            case 1:
                return new ab(vVar);
            case 2:
                return new h(vVar);
            case 3:
                return new o(vVar);
            case 4:
                return new q(vVar);
            case 5:
                return new s(vVar);
            case 6:
                return new y(vVar);
            case 7:
                return new m(vVar);
            case 8:
                return new k(vVar);
            case 9:
                return new g(vVar);
            case 10:
                return new d(vVar);
            case 11:
                return new ae(vVar);
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
                return new ag(vVar);
        }
    }
}
