package com.meizu.cloud.pushsdk.notification.a;

import android.app.Notification;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.handler.MessageV4;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.notification.c.e;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
import java.io.File;
/* loaded from: classes6.dex */
public class d extends c {
    public d(Context context, PushNotificationBuilder pushNotificationBuilder) {
        super(context, pushNotificationBuilder);
    }

    @Override // com.meizu.cloud.pushsdk.notification.a
    public void a(Notification.Builder builder, MessageV3 messageV3) {
        if (MinSdkChecker.isSupportNotificationBuild()) {
            Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
            bigTextStyle.setBigContentTitle(messageV3.getTitle());
            bigTextStyle.bigText(messageV3.getmNotificationStyle().getExpandableText());
            builder.setStyle(bigTextStyle);
        }
    }

    @Override // com.meizu.cloud.pushsdk.notification.a
    public void a(Notification notification, MessageV3 messageV3) {
        super.a(notification, messageV3);
        MessageV4 parse = MessageV4.parse(messageV3);
        if (parse.getActVideoSetting() == null || (parse.getActVideoSetting().isWifiDisplay() && !com.meizu.cloud.pushsdk.util.a.b(this.f37700a))) {
            d.h.a.a.a.b("AbstractPushNotification", "only wifi can download act");
            return;
        }
        final String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdkAct/" + messageV3.getUploadDataPackageName();
        String valueOf = String.valueOf(System.currentTimeMillis());
        String actUrl = parse.getActVideoSetting().getActUrl();
        if (!TextUtils.isEmpty(actUrl) && com.meizu.cloud.pushsdk.b.a.a(actUrl, str, valueOf).a().c().b()) {
            d.h.a.a.a.d("AbstractPushNotification", "down load " + actUrl + " success");
            String str2 = str + File.separator + "ACT-" + valueOf;
            boolean a2 = new e(str + File.separator + valueOf, str2).a();
            StringBuilder sb = new StringBuilder();
            sb.append("zip file ");
            sb.append(a2);
            d.h.a.a.a.d("AbstractPushNotification", sb.toString());
            if (a2) {
                Bundle bundle = new Bundle();
                bundle.putString("path", str2);
                Bundle bundle2 = new Bundle();
                bundle2.putBundle("big", bundle);
                if (MinSdkChecker.isSupportVideoNotification()) {
                    notification.extras.putBundle("flyme.active", bundle2);
                }
            }
        }
        com.meizu.cloud.pushsdk.c.b.a.b.a(new Runnable() { // from class: com.meizu.cloud.pushsdk.notification.a.d.1
            @Override // java.lang.Runnable
            public void run() {
                File[] b2;
                for (File file : com.meizu.cloud.pushsdk.notification.c.a.b(str, String.valueOf(System.currentTimeMillis() - 86400000))) {
                    com.meizu.cloud.pushsdk.notification.c.a.b(file.getPath());
                    d.h.a.a.a.d("AbstractPushNotification", "Delete file directory " + file.getName() + "\n");
                }
            }
        });
    }
}
