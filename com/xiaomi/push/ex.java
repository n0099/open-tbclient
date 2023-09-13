package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.MiPushClient;
/* loaded from: classes10.dex */
public enum ex {
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
    public final String f336a;

    ex(String str) {
        this.f336a = str;
    }

    public static int a(String str) {
        ex[] values;
        int i = -1;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        for (ex exVar : values()) {
            if (exVar.f336a.equals(str)) {
                i = em.a(exVar);
            }
        }
        return i;
    }
}
