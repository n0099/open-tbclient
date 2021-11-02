package com.meizu.cloud.pushsdk.notification.a;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
/* loaded from: classes2.dex */
public class c extends com.meizu.cloud.pushsdk.notification.a {
    public c(Context context, PushNotificationBuilder pushNotificationBuilder) {
        super(context, pushNotificationBuilder);
    }

    @Override // com.meizu.cloud.pushsdk.notification.a
    public void b(Notification.Builder builder, MessageV3 messageV3) {
        Bitmap a2;
        String str;
        AppIconSetting appIconSetting = messageV3.getmAppIconSetting();
        if (appIconSetting != null) {
            if (appIconSetting.isDefaultLargeIcon()) {
                PushNotificationBuilder pushNotificationBuilder = this.f67641b;
                if (pushNotificationBuilder != null && pushNotificationBuilder.getmLargIcon() != 0) {
                    a2 = BitmapFactory.decodeResource(this.f67640a.getResources(), this.f67641b.getmLargIcon());
                    str = "set largeIcon by resource id";
                } else if (this.f67641b.getAppLargeIcon() != null) {
                    a2 = this.f67641b.getAppLargeIcon();
                    str = "set largeIcon by bitmap provided by user setting";
                } else {
                    a2 = a(this.f67640a, messageV3.getUploadDataPackageName());
                    str = "set largeIcon by package default large icon";
                }
                b.l.a.a.a.d("AbstractPushNotification", str);
            } else if (Thread.currentThread() == this.f67640a.getMainLooper().getThread()) {
                return;
            } else {
                Bitmap a3 = a(appIconSetting.getLargeIconUrl());
                if (a3 != null) {
                    b.l.a.a.a.d("AbstractPushNotification", "On other Thread down load largeIcon image success");
                    builder.setLargeIcon(a3);
                    return;
                }
                a2 = a(this.f67640a, messageV3.getUploadDataPackageName());
            }
            builder.setLargeIcon(a2);
        }
    }
}
