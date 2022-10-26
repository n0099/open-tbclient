package com.heytap.mcssdk.callback;

import java.util.List;
/* loaded from: classes7.dex */
public interface PushCallback {
    void onGetAliases(int i, List list);

    void onGetNotificationStatus(int i, int i2);

    void onGetPushStatus(int i, int i2);

    void onGetTags(int i, List list);

    void onGetUserAccounts(int i, List list);

    void onRegister(int i, String str);

    void onSetAliases(int i, List list);

    void onSetPushTime(int i, String str);

    void onSetTags(int i, List list);

    void onSetUserAccounts(int i, List list);

    void onUnRegister(int i);

    void onUnsetAliases(int i, List list);

    void onUnsetTags(int i, List list);

    void onUnsetUserAccounts(int i, List list);
}
