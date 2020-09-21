package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.MiPushClient;
/* loaded from: classes9.dex */
public enum fg {
    COMMAND_REGISTER("register"),
    COMMAND_UNREGISTER("unregister"),
    COMMAND_SET_ALIAS(MiPushClient.COMMAND_SET_ALIAS),
    COMMAND_UNSET_ALIAS(MiPushClient.COMMAND_UNSET_ALIAS),
    COMMAND_SET_ACCOUNT(MiPushClient.COMMAND_SET_ACCOUNT),
    COMMAND_UNSET_ACCOUNT(MiPushClient.COMMAND_UNSET_ACCOUNT),
    COMMAND_SUBSCRIBE_TOPIC(MiPushClient.COMMAND_SUBSCRIBE_TOPIC),
    COMMAND_UNSUBSCRIBE_TOPIC(MiPushClient.COMMAND_UNSUBSCRIBE_TOPIC),
    COMMAND_SET_ACCEPT_TIME(MiPushClient.COMMAND_SET_ACCEPT_TIME),
    COMMAND_CHK_VDEVID("check-vdeviceid");
    

    /* renamed from: a  reason: collision with other field name */
    public final String f319a;

    fg(String str) {
        this.f319a = str;
    }

    public static int a(String str) {
        fg[] values;
        int i = -1;
        if (!TextUtils.isEmpty(str)) {
            for (fg fgVar : values()) {
                if (fgVar.f319a.equals(str)) {
                    i = fa.a(fgVar);
                }
            }
        }
        return i;
    }
}
