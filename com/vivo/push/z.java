package com.vivo.push;

import android.net.Uri;
import com.baidu.mapapi.UIMsg;
/* loaded from: classes5.dex */
public final class z {
    public static final Uri a = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/config");
    public static final Uri b = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/permission");
    public static final Uri c = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/clientState");
    public static final Uri d = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/debugInfo");

    public static String a(int i) {
        switch (i) {
            case 2002:
                return "method_alias_bind";
            case 2003:
                return "method_alias_unbind";
            case 2004:
                return "method_tag_bind";
            case 2005:
                return "method_tag_unbind";
            case UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND /* 2006 */:
                return "method_sdk_bind";
            case UIMsg.m_AppUI.MSG_APP_VERSION_NAV_MODULE /* 2007 */:
                return "method_sdk_unbind";
            case UIMsg.m_AppUI.MSG_APP_VERSION_FORCE_NAV_MODULE /* 2008 */:
                return "method_stop";
            default:
                return null;
        }
    }
}
