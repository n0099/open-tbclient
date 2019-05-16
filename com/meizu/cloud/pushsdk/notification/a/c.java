package com.meizu.cloud.pushsdk.notification.a;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
/* loaded from: classes3.dex */
public class c extends com.meizu.cloud.pushsdk.notification.a {
    public c(Context context, PushNotificationBuilder pushNotificationBuilder) {
        super(context, pushNotificationBuilder);
    }

    @Override // com.meizu.cloud.pushsdk.notification.a
    protected void b(Notification.Builder builder, MessageV3 messageV3) {
        AppIconSetting appIconSetting = messageV3.getmAppIconSetting();
        if (appIconSetting != null) {
            if (appIconSetting.isDefaultLargeIcon()) {
                builder.setLargeIcon((this.b == null || this.b.getmLargIcon() == 0) ? a(this.a, messageV3.getUploadDataPackageName()) : BitmapFactory.decodeResource(this.a.getResources(), this.b.getmLargIcon()));
            } else if (Thread.currentThread() != this.a.getMainLooper().getThread()) {
                Bitmap a = a(appIconSetting.getLargeIconUrl());
                if (a == null) {
                    builder.setLargeIcon(a(this.a, messageV3.getUploadDataPackageName()));
                    return;
                }
                com.meizu.cloud.a.a.i("AbstractPushNotification", "On other Thread down load largeIcon image success");
                builder.setLargeIcon(a);
            }
        }
    }
}
