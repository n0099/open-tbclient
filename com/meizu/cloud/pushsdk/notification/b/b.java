package com.meizu.cloud.pushsdk.notification.b;

import android.app.Notification;
import android.content.Context;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
/* loaded from: classes6.dex */
public class b extends c {
    public b(Context context, PushNotificationBuilder pushNotificationBuilder) {
        super(context, pushNotificationBuilder);
    }

    @Override // com.meizu.cloud.pushsdk.notification.a
    public void b(Notification notification, MessageV3 messageV3) {
        if (MinSdkChecker.isSupportNotificationBuild()) {
            RemoteViews remoteViews = new RemoteViews(this.f37511a.getPackageName(), com.meizu.cloud.pushsdk.notification.c.c.b(this.f37511a));
            remoteViews.setTextViewText(com.meizu.cloud.pushsdk.notification.c.c.d(this.f37511a), messageV3.getTitle());
            remoteViews.setLong(com.meizu.cloud.pushsdk.notification.c.c.f(this.f37511a), "setTime", System.currentTimeMillis());
            a(remoteViews, messageV3);
            if (messageV3.getmNotificationStyle() != null && !TextUtils.isEmpty(messageV3.getmNotificationStyle().getExpandableText())) {
                remoteViews.setViewVisibility(com.meizu.cloud.pushsdk.notification.c.c.h(this.f37511a), 0);
                remoteViews.setTextViewText(com.meizu.cloud.pushsdk.notification.c.c.h(this.f37511a), messageV3.getmNotificationStyle().getExpandableText());
            }
            notification.bigContentView = remoteViews;
        }
    }
}
