package com.meizu.cloud.pushsdk.notification.a;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
/* loaded from: classes5.dex */
public class c extends com.meizu.cloud.pushsdk.notification.a {
    public c(Context context, PushNotificationBuilder pushNotificationBuilder) {
        super(context, pushNotificationBuilder);
    }

    @Override // com.meizu.cloud.pushsdk.notification.a
    protected void b(Notification.Builder builder, MessageV3 messageV3) {
        Bitmap a2;
        AppIconSetting appIconSetting = messageV3.getmAppIconSetting();
        if (appIconSetting != null) {
            if (!appIconSetting.isDefaultLargeIcon()) {
                if (Thread.currentThread() != this.f11327a.getMainLooper().getThread()) {
                    Bitmap a3 = a(appIconSetting.getLargeIconUrl());
                    if (a3 == null) {
                        builder.setLargeIcon(a(this.f11327a, messageV3.getUploadDataPackageName()));
                        return;
                    }
                    com.meizu.cloud.a.a.i("AbstractPushNotification", "On other Thread down load largeIcon image success");
                    builder.setLargeIcon(a3);
                    return;
                }
                return;
            }
            if (this.f11328b != null && this.f11328b.getmLargIcon() != 0) {
                a2 = BitmapFactory.decodeResource(this.f11327a.getResources(), this.f11328b.getmLargIcon());
                com.meizu.cloud.a.a.i("AbstractPushNotification", "set largeIcon by resource id");
            } else if (this.f11328b.getAppLargeIcon() != null) {
                a2 = this.f11328b.getAppLargeIcon();
                com.meizu.cloud.a.a.i("AbstractPushNotification", "set largeIcon by bitmap provided by user setting");
            } else {
                a2 = a(this.f11327a, messageV3.getUploadDataPackageName());
                com.meizu.cloud.a.a.i("AbstractPushNotification", "set largeIcon by package default large icon");
            }
            builder.setLargeIcon(a2);
        }
    }
}
