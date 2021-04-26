package com.heytap.mcssdk.callback;

import com.heytap.mcssdk.mode.SubscribeResult;
import java.util.List;
/* loaded from: classes6.dex */
public interface PushCallback {
    void onGetAliases(int i2, List<SubscribeResult> list);

    void onGetNotificationStatus(int i2, int i3);

    void onGetPushStatus(int i2, int i3);

    void onGetTags(int i2, List<SubscribeResult> list);

    void onGetUserAccounts(int i2, List<SubscribeResult> list);

    void onRegister(int i2, String str);

    void onSetAliases(int i2, List<SubscribeResult> list);

    void onSetPushTime(int i2, String str);

    void onSetTags(int i2, List<SubscribeResult> list);

    void onSetUserAccounts(int i2, List<SubscribeResult> list);

    void onUnRegister(int i2);

    void onUnsetAliases(int i2, List<SubscribeResult> list);

    void onUnsetTags(int i2, List<SubscribeResult> list);

    void onUnsetUserAccounts(int i2, List<SubscribeResult> list);
}
