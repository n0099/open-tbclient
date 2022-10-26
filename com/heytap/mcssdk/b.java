package com.heytap.mcssdk;

import android.content.Context;
import com.heytap.mcssdk.callback.PushCallback;
import java.util.List;
/* loaded from: classes7.dex */
public interface b extends c {
    @Deprecated
    void clearNotificationType();

    void clearNotifications();

    void getAliases();

    void getNotificationStatus();

    void getRegister();

    String getRegisterID();

    void getTags();

    @Deprecated
    void getUserAccounts();

    void openNotificationSettings();

    void pausePush();

    void register(Context context, String str, String str2, PushCallback pushCallback);

    void requestNotificationPermission();

    void resumePush();

    void setAliases(List list);

    @Deprecated
    void setNotificationType(int i);

    void setPushTime(List list, int i, int i2, int i3, int i4);

    void setRegisterID(String str);

    void setTags(List list);

    @Deprecated
    void setUserAccount(String str);

    @Deprecated
    void setUserAccounts(List list);

    void unRegister();

    void unsetAlias(String str);

    @Deprecated
    void unsetAliases(List list);

    void unsetTags(List list);

    @Deprecated
    void unsetUserAccounts(List list);
}
