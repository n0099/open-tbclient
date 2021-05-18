package com.vivo.push.c;

import com.baidu.android.imsdk.IMConstants;
import com.baidu.mapapi.UIMsg;
/* loaded from: classes7.dex */
public final class ai {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.vivo.push.v a(com.vivo.push.y yVar) {
        com.vivo.push.v ahVar;
        int b2 = yVar.b();
        if (b2 == 20) {
            ahVar = new ah(yVar);
        } else if (b2 == 100) {
            ahVar = new b(yVar);
        } else if (b2 != 101) {
            switch (b2) {
                case 0:
                    ahVar = new aj(yVar);
                    break;
                case 1:
                    ahVar = new ac(yVar);
                    break;
                case 2:
                    ahVar = new h(yVar);
                    break;
                case 3:
                    ahVar = new p(yVar);
                    break;
                case 4:
                    ahVar = new r(yVar);
                    break;
                case 5:
                    ahVar = new t(yVar);
                    break;
                case 6:
                    ahVar = new z(yVar);
                    break;
                case 7:
                    ahVar = new n(yVar);
                    break;
                case 8:
                    ahVar = new l(yVar);
                    break;
                case 9:
                    ahVar = new g(yVar);
                    break;
                case 10:
                    ahVar = new d(yVar);
                    break;
                case 11:
                    ahVar = new af(yVar);
                    break;
                case 12:
                    ahVar = new f(yVar);
                    break;
                default:
                    switch (b2) {
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
                        case IMConstants.IM_MSG_TYPE_SHIELD_ME /* 2012 */:
                        case IMConstants.IM_MSG_TYPE_UNSUBSCRIBE_ME /* 2013 */:
                        case IMConstants.IM_MSG_TYPE_UNSUBSCRIBE_ME_SEND_FAIL /* 2014 */:
                        case 2015:
                            break;
                        case 2006:
                            ahVar = new a(yVar);
                            break;
                        case 2007:
                            ahVar = new ak(yVar);
                            break;
                        default:
                            return null;
                    }
            }
        } else {
            ahVar = new c(yVar);
        }
        return ahVar;
    }

    public static ab b(com.vivo.push.y yVar) {
        ab ahVar;
        int b2 = yVar.b();
        if (b2 == 20) {
            ahVar = new ah(yVar);
        } else if (b2 != 2016) {
            switch (b2) {
                case 1:
                    ahVar = new ac(yVar);
                    break;
                case 2:
                    ahVar = new h(yVar);
                    break;
                case 3:
                    ahVar = new p(yVar);
                    break;
                case 4:
                    ahVar = new r(yVar);
                    break;
                case 5:
                    ahVar = new t(yVar);
                    break;
                case 6:
                    ahVar = new z(yVar);
                    break;
                case 7:
                    ahVar = new n(yVar);
                    break;
                case 8:
                    ahVar = new l(yVar);
                    break;
                case 9:
                    ahVar = new g(yVar);
                    break;
                case 10:
                    ahVar = new d(yVar);
                    break;
                case 11:
                    ahVar = new af(yVar);
                    break;
                default:
                    return null;
            }
        } else {
            ahVar = new k(yVar);
        }
        return ahVar;
    }
}
