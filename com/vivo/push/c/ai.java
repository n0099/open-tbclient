package com.vivo.push.c;

import com.baidu.android.imsdk.IMConstants;
import com.baidu.mapapi.UIMsg;
/* loaded from: classes9.dex */
public final class ai {
    public static com.vivo.push.v a(com.vivo.push.y yVar) {
        switch (yVar.b()) {
            case 0:
            case 2000:
            case 2001:
            case 2002:
            case 2003:
            case 2004:
            case 2005:
            case 2008:
            case UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE /* 2009 */:
            case 2010:
            case IMConstants.IM_MSG_TYPE_SHIELD /* 2011 */:
            case 2012:
            case 2013:
            case IMConstants.IM_MSG_TYPE_UNSUBSCRIBE_ME_SEND_FAIL /* 2014 */:
            case 2015:
                return new aj(yVar);
            case 1:
                return new ac(yVar);
            case 2:
                return new h(yVar);
            case 3:
                return new p(yVar);
            case 4:
                return new r(yVar);
            case 5:
                return new t(yVar);
            case 6:
                return new z(yVar);
            case 7:
                return new n(yVar);
            case 8:
                return new l(yVar);
            case 9:
                return new g(yVar);
            case 10:
                return new d(yVar);
            case 11:
                return new af(yVar);
            case 12:
                return new f(yVar);
            case 20:
                return new ah(yVar);
            case 100:
                return new b(yVar);
            case 101:
                return new c(yVar);
            case UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND /* 2006 */:
                return new a(yVar);
            case UIMsg.m_AppUI.MSG_APP_VERSION_NAV_MODULE /* 2007 */:
                return new ak(yVar);
            default:
                return null;
        }
    }

    public static ab b(com.vivo.push.y yVar) {
        switch (yVar.b()) {
            case 1:
                return new ac(yVar);
            case 2:
                return new h(yVar);
            case 3:
                return new p(yVar);
            case 4:
                return new r(yVar);
            case 5:
                return new t(yVar);
            case 6:
                return new z(yVar);
            case 7:
                return new n(yVar);
            case 8:
                return new l(yVar);
            case 9:
                return new g(yVar);
            case 10:
                return new d(yVar);
            case 11:
                return new af(yVar);
            case 20:
                return new ah(yVar);
            case 2016:
                return new k(yVar);
            default:
                return null;
        }
    }
}
