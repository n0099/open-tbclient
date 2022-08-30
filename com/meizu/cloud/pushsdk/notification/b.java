package com.meizu.cloud.pushsdk.notification;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.notification.model.styleenum.InnerStyleLayout;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
/* loaded from: classes8.dex */
public class b extends com.meizu.cloud.pushsdk.notification.b.c {
    public b(Context context, PushNotificationBuilder pushNotificationBuilder) {
        super(context, pushNotificationBuilder);
    }

    @Override // com.meizu.cloud.pushsdk.notification.a
    public void b(Notification notification, MessageV3 messageV3) {
        if (MinSdkChecker.isSupportNotificationBuild()) {
            Bitmap a = a(messageV3.getmNotificationStyle().getBannerImageUrl());
            if (a() || a == null) {
                return;
            }
            RemoteViews remoteViews = new RemoteViews(this.a.getPackageName(), com.meizu.cloud.pushsdk.notification.c.c.c(this.a));
            remoteViews.setImageViewBitmap(com.meizu.cloud.pushsdk.notification.c.c.i(this.a), a);
            remoteViews.setViewVisibility(com.meizu.cloud.pushsdk.notification.c.c.j(this.a), 8);
            remoteViews.setViewVisibility(com.meizu.cloud.pushsdk.notification.c.c.i(this.a), 0);
            notification.contentView = remoteViews;
            if (messageV3.getmNotificationStyle().getInnerStyle() == InnerStyleLayout.EXPANDABLE_PIC.getCode()) {
                Bitmap a2 = a(messageV3.getmNotificationStyle().getExpandableImageUrl());
                if (a() || a2 == null) {
                    return;
                }
                RemoteViews remoteViews2 = new RemoteViews(this.a.getPackageName(), com.meizu.cloud.pushsdk.notification.c.c.c(this.a));
                remoteViews2.setImageViewBitmap(com.meizu.cloud.pushsdk.notification.c.c.j(this.a), a2);
                remoteViews2.setViewVisibility(com.meizu.cloud.pushsdk.notification.c.c.j(this.a), 0);
                remoteViews2.setViewVisibility(com.meizu.cloud.pushsdk.notification.c.c.i(this.a), 8);
                notification.bigContentView = remoteViews2;
            }
        }
    }
}
