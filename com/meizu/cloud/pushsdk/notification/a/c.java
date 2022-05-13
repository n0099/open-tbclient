package com.meizu.cloud.pushsdk.notification.a;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.repackage.tl9;
/* loaded from: classes5.dex */
public class c extends com.meizu.cloud.pushsdk.notification.a {
    public c(Context context, PushNotificationBuilder pushNotificationBuilder) {
        super(context, pushNotificationBuilder);
    }

    @Override // com.meizu.cloud.pushsdk.notification.a
    public void b(Notification.Builder builder, MessageV3 messageV3) {
        Bitmap a;
        String str;
        AppIconSetting appIconSetting = messageV3.getmAppIconSetting();
        if (appIconSetting != null) {
            if (appIconSetting.isDefaultLargeIcon()) {
                PushNotificationBuilder pushNotificationBuilder = this.b;
                if (pushNotificationBuilder != null && pushNotificationBuilder.getmLargIcon() != 0) {
                    a = BitmapFactory.decodeResource(this.a.getResources(), this.b.getmLargIcon());
                    str = "set largeIcon by resource id";
                } else if (this.b.getAppLargeIcon() != null) {
                    a = this.b.getAppLargeIcon();
                    str = "set largeIcon by bitmap provided by user setting";
                } else {
                    a = a(this.a, messageV3.getUploadDataPackageName());
                    str = "set largeIcon by package default large icon";
                }
                tl9.d("AbstractPushNotification", str);
            } else if (Thread.currentThread() == this.a.getMainLooper().getThread()) {
                return;
            } else {
                Bitmap a2 = a(appIconSetting.getLargeIconUrl());
                if (a2 != null) {
                    tl9.d("AbstractPushNotification", "On other Thread down load largeIcon image success");
                    builder.setLargeIcon(a2);
                    return;
                }
                a = a(this.a, messageV3.getUploadDataPackageName());
            }
            builder.setLargeIcon(a);
        }
    }
}
