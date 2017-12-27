package com.coloros.mcssdk.d;

import com.coloros.mcssdk.e.e;
import java.util.List;
/* loaded from: classes2.dex */
public interface b {
    void onGetAliases(int i, List<e> list);

    void onGetNotificationStatus(int i, int i2);

    void onGetPushStatus(int i, int i2);

    void onGetTags(int i, List<e> list);

    void onGetUserAccounts(int i, List<e> list);

    void onRegister(int i, String str);

    void onSetAliases(int i, List<e> list);

    void onSetPushTime(int i, String str);

    void onSetTags(int i, List<e> list);

    void onSetUserAccounts(int i, List<e> list);

    void onUnRegister(int i);

    void onUnsetAliases(int i, List<e> list);

    void onUnsetTags(int i, List<e> list);

    void onUnsetUserAccounts(int i, List<e> list);
}
