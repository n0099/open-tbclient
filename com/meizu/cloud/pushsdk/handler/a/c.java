package com.meizu.cloud.pushsdk.handler.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.google.protobuf.CodedInputStream;
import com.meizu.cloud.pushsdk.NotificationService;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.handler.MzPushMessage;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.notification.model.styleenum.BaseStyleModel;
import com.meizu.cloud.pushsdk.notification.model.styleenum.InnerStyleLayout;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import com.repackage.ni9;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c extends a<MessageV3> {
    public c(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    private String k(MessageV3 messageV3) {
        String selfDefineContentString = MzPushMessage.fromMessageV3(messageV3).getSelfDefineContentString();
        if (!TextUtils.isEmpty(selfDefineContentString)) {
            try {
                return new JSONObject(selfDefineContentString).getString("package_name");
            } catch (JSONException unused) {
                ni9.b("AbstractMessageHandler", "no quick json message");
            }
        }
        return null;
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 4;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(MessageV3 messageV3, com.meizu.cloud.pushsdk.notification.c cVar) {
        if (cVar != null) {
            cVar.e(messageV3);
            c(messageV3);
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(Intent intent) {
        ni9.d("AbstractMessageHandler", "start MessageV3Handler match");
        if (a(0, g(intent))) {
            if (PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_NOTIFICATION_SHOW_V3.equals(i(intent))) {
                return true;
            }
            if (TextUtils.isEmpty(i(intent))) {
                String stringExtra = intent.getStringExtra("message");
                if (!TextUtils.isEmpty(stringExtra) && a(stringExtra)) {
                    ni9.b("AbstractMessageHandler", "old cloud notification message");
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: d */
    public void b(MessageV3 messageV3) {
        com.meizu.cloud.pushsdk.util.d.c(c(), messageV3.getUploadDataPackageName(), messageV3.getDeviceId(), messageV3.getTaskId(), messageV3.getSeqId(), messageV3.getPushTimestamp());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: e */
    public void c(MessageV3 messageV3) {
        com.meizu.cloud.pushsdk.util.d.a(c(), messageV3.getUploadDataPackageName(), messageV3.getDeviceId(), messageV3.getTaskId(), messageV3.getSeqId(), messageV3.getPushTimestamp());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: f  reason: avoid collision after fix types in other method */
    public boolean g(MessageV3 messageV3) {
        return a(messageV3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: g  reason: avoid collision after fix types in other method */
    public com.meizu.cloud.pushsdk.notification.c a(MessageV3 messageV3) {
        PushNotificationBuilder pushNotificationBuilder = new PushNotificationBuilder(c());
        pushNotificationBuilder.setClickPackageName(k(messageV3));
        b().a(pushNotificationBuilder);
        com.meizu.cloud.pushsdk.notification.c cVar = null;
        if (messageV3.getmNotificationStyle() != null) {
            int baseStyle = messageV3.getmNotificationStyle().getBaseStyle();
            if (BaseStyleModel.FLYME.getCode() == baseStyle) {
                int innerStyle = messageV3.getmNotificationStyle().getInnerStyle();
                if (InnerStyleLayout.EXPANDABLE_STANDARD.getCode() == innerStyle) {
                    ni9.d("AbstractMessageHandler", "show Standard Notification with Expandable disable");
                    cVar = new com.meizu.cloud.pushsdk.notification.b.c(c(), pushNotificationBuilder);
                } else if (InnerStyleLayout.EXPANDABLE_TEXT.getCode() == innerStyle) {
                    ni9.d("AbstractMessageHandler", "show Standard Notification with Expandable Text");
                    cVar = new com.meizu.cloud.pushsdk.notification.b.b(c(), pushNotificationBuilder);
                } else if (InnerStyleLayout.EXPANDABLE_PIC.getCode() == innerStyle) {
                    ni9.d("AbstractMessageHandler", "show Standard Notification with Expandable Picture");
                    cVar = new com.meizu.cloud.pushsdk.notification.b.a(c(), pushNotificationBuilder);
                } else if (InnerStyleLayout.EXPANDABLE_VIDEO.getCode() == innerStyle) {
                    ni9.d("AbstractMessageHandler", "show Flyme Video notification");
                    cVar = new com.meizu.cloud.pushsdk.notification.a.d(c(), pushNotificationBuilder);
                }
            } else if (BaseStyleModel.PURE_PICTURE.getCode() == baseStyle) {
                cVar = new com.meizu.cloud.pushsdk.notification.b(c(), pushNotificationBuilder);
                ni9.d("AbstractMessageHandler", "show Pure Picture Notification");
            } else if (BaseStyleModel.ANDROID.getCode() == baseStyle) {
                int innerStyle2 = messageV3.getmNotificationStyle().getInnerStyle();
                if (InnerStyleLayout.EXPANDABLE_STANDARD.getCode() == innerStyle2) {
                    ni9.d("AbstractMessageHandler", "show Android  Notification with Expandable disable");
                    cVar = new com.meizu.cloud.pushsdk.notification.a.c(c(), pushNotificationBuilder);
                } else if (InnerStyleLayout.EXPANDABLE_TEXT.getCode() == innerStyle2) {
                    ni9.d("AbstractMessageHandler", "show Android  Notification with Expandable Text");
                    cVar = new com.meizu.cloud.pushsdk.notification.a.b(c(), pushNotificationBuilder);
                } else if (InnerStyleLayout.EXPANDABLE_PIC.getCode() == innerStyle2) {
                    ni9.d("AbstractMessageHandler", "show Android  Notification with Expandable Picture");
                    cVar = new com.meizu.cloud.pushsdk.notification.a.a(c(), pushNotificationBuilder);
                } else if (InnerStyleLayout.EXPANDABLE_VIDEO.getCode() == innerStyle2) {
                    ni9.d("AbstractMessageHandler", "show Flyme Video notification");
                    cVar = new com.meizu.cloud.pushsdk.notification.a.d(c(), pushNotificationBuilder);
                }
            }
        }
        if (cVar == null) {
            ni9.b("AbstractMessageHandler", "use standard v2 notification");
            return new com.meizu.cloud.pushsdk.notification.d(c(), pushNotificationBuilder);
        }
        return cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: h */
    public boolean f(MessageV3 messageV3) {
        String uriPackageName = messageV3.getUriPackageName();
        if (TextUtils.isEmpty(uriPackageName)) {
            return true;
        }
        return MzSystemUtils.isPackageInstalled(c(), uriPackageName);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: i */
    public int d(MessageV3 messageV3) {
        Context c;
        int i;
        String taskId;
        String deviceId;
        String str;
        int i2 = 0;
        if (messageV3.getmTimeDisplaySetting() != null && messageV3.getmTimeDisplaySetting().isTimeDisplay()) {
            if (System.currentTimeMillis() > Long.valueOf(messageV3.getmTimeDisplaySetting().getEndShowTime()).longValue()) {
                i2 = 1;
                c = c();
                i = 2200;
                taskId = messageV3.getTaskId();
                deviceId = messageV3.getDeviceId();
                str = "schedule notification expire";
            } else if (System.currentTimeMillis() > Long.valueOf(messageV3.getmTimeDisplaySetting().getStartShowTime()).longValue()) {
                i2 = 2;
                c = c();
                i = 2201;
                taskId = messageV3.getTaskId();
                deviceId = messageV3.getDeviceId();
                str = "schedule notification on time";
            } else {
                i2 = 3;
                c = c();
                i = 2202;
                taskId = messageV3.getTaskId();
                deviceId = messageV3.getDeviceId();
                str = "schedule notification delay";
            }
            com.meizu.cloud.pushsdk.util.d.a(c, str, i, taskId, deviceId);
        }
        return i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: j */
    public MessageV3 c(Intent intent) {
        return MessageV3.parse(c().getPackageName(), g(intent), h(intent), d(intent), e(intent), f(intent), intent.getStringExtra(PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_NOTIFICATION_SHOW_V3.equals(i(intent)) ? PushConstants.MZ_PUSH_PRIVATE_MESSAGE : "message"));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: j */
    public void e(MessageV3 messageV3) {
        Context c = c();
        c();
        AlarmManager alarmManager = (AlarmManager) c.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intent intent = new Intent(c(), NotificationService.class);
        intent.setPackage(messageV3.getPackageName());
        intent.addCategory(messageV3.getPackageName());
        intent.setData(Uri.parse("custom://" + System.currentTimeMillis()));
        intent.putExtra("command_type", "reflect_receiver");
        intent.setAction(PushConstants.MZ_PUSH_ON_MESSAGE_ACTION);
        intent.putExtra(PushConstants.EXTRA_APP_PUSH_SCHEDULE_NOTIFICATION_MESSAGE, messageV3);
        intent.putExtra("method", PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_SCHEDULE_NOTIFICATION);
        PendingIntent service = PendingIntent.getService(c(), 0, intent, MinSdkChecker.isSupportSetDrawableSmallIcon() ? CodedInputStream.DEFAULT_SIZE_LIMIT : 1073741824);
        String startShowTime = messageV3.getmTimeDisplaySetting().getStartShowTime();
        String format = TextUtils.isEmpty(startShowTime) ? null : new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(Long.valueOf(startShowTime).longValue()));
        long longValue = Long.valueOf(startShowTime).longValue() - System.currentTimeMillis();
        ni9.d("AbstractMessageHandler", "after " + (longValue / 1000) + " seconds Notification AlarmManager execute At " + format);
        if (Build.VERSION.SDK_INT < 19) {
            alarmManager.set(2, SystemClock.elapsedRealtime() + longValue, service);
            return;
        }
        ni9.d("AbstractMessageHandler", "setAlarmManager setWindow ELAPSED_REALTIME_WAKEUP");
        alarmManager.setExact(2, SystemClock.elapsedRealtime() + longValue, service);
    }
}
