package com.meizu.cloud.pushsdk.notification.b;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
/* loaded from: classes3.dex */
public class a extends c {
    public a(Context context, PushNotificationBuilder pushNotificationBuilder) {
        super(context, pushNotificationBuilder);
    }

    private void b(RemoteViews remoteViews, MessageV3 messageV3) {
        Bitmap a;
        if (messageV3.getmNotificationStyle() == null || a()) {
            return;
        }
        if (TextUtils.isEmpty(messageV3.getmNotificationStyle().getExpandableImageUrl()) || (a = a(messageV3.getmNotificationStyle().getExpandableImageUrl())) == null) {
            remoteViews.setViewVisibility(com.meizu.cloud.pushsdk.notification.c.c.g(this.a), 8);
            return;
        }
        remoteViews.setViewVisibility(com.meizu.cloud.pushsdk.notification.c.c.g(this.a), 0);
        remoteViews.setImageViewBitmap(com.meizu.cloud.pushsdk.notification.c.c.g(this.a), a);
    }

    @Override // com.meizu.cloud.pushsdk.notification.a
    public void b(Notification notification, MessageV3 messageV3) {
        if (MinSdkChecker.isSupportNotificationBuild()) {
            RemoteViews remoteViews = new RemoteViews(this.a.getPackageName(), com.meizu.cloud.pushsdk.notification.c.c.a(this.a));
            remoteViews.setTextViewText(com.meizu.cloud.pushsdk.notification.c.c.d(this.a), messageV3.getTitle());
            remoteViews.setTextViewText(com.meizu.cloud.pushsdk.notification.c.c.e(this.a), messageV3.getContent());
            remoteViews.setLong(com.meizu.cloud.pushsdk.notification.c.c.f(this.a), "setTime", System.currentTimeMillis());
            a(remoteViews, messageV3);
            b(remoteViews, messageV3);
            notification.bigContentView = remoteViews;
        }
    }
}
