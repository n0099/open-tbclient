package com.meizu.cloud.pushsdk.notification.a;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
/* loaded from: classes6.dex */
public class a extends c {
    public a(Context context, PushNotificationBuilder pushNotificationBuilder) {
        super(context, pushNotificationBuilder);
    }

    @Override // com.meizu.cloud.pushsdk.notification.a
    protected void a(Notification.Builder builder, MessageV3 messageV3) {
        Bitmap a2;
        if (MinSdkChecker.isSupportNotificationBuild()) {
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle();
            if (messageV3.getmNotificationStyle() == null || a() || TextUtils.isEmpty(messageV3.getmNotificationStyle().getExpandableImageUrl()) || (a2 = a(messageV3.getmNotificationStyle().getExpandableImageUrl())) == null) {
                return;
            }
            bigPictureStyle.setBigContentTitle(messageV3.getTitle());
            bigPictureStyle.bigPicture(a2);
            builder.setStyle(bigPictureStyle);
        }
    }
}
