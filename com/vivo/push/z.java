package com.vivo.push;

import android.net.Uri;
import com.baidu.mapapi.UIMsg;
/* loaded from: classes7.dex */
public final class z {

    /* renamed from: a  reason: collision with root package name */
    public static final Uri f39596a = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/config");

    /* renamed from: b  reason: collision with root package name */
    public static final Uri f39597b = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/permission");

    /* renamed from: c  reason: collision with root package name */
    public static final Uri f39598c = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/clientState");

    /* renamed from: d  reason: collision with root package name */
    public static final Uri f39599d = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/debugInfo");

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
            case 2006:
                return "method_sdk_bind";
            case 2007:
                return "method_sdk_unbind";
            case UIMsg.m_AppUI.MSG_APP_VERSION_FORCE_NAV_MODULE /* 2008 */:
                return "method_stop";
            default:
                return null;
        }
    }
}
