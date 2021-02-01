package com.vivo.push.util;

import android.content.Context;
import com.vivo.push.model.InsideNotificationItem;
/* loaded from: classes15.dex */
public interface BaseNotifyDataAdapter {
    int getDefaultNotifyIcon();

    int getDefaultSmallIconId();

    int getNotifyMode(InsideNotificationItem insideNotificationItem);

    void init(Context context);
}
