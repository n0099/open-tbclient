package com.meizu.cloud.pushsdk.handler.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.NotificationService;
import com.meizu.cloud.pushsdk.common.b.h;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.notification.g;
import com.meizu.cloud.pushsdk.notification.model.styleenum.BaseStyleModel;
import com.meizu.cloud.pushsdk.notification.model.styleenum.InnerStyleLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes2.dex */
public class c extends a<MessageV3> {
    public c(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: j */
    public MessageV3 c(Intent intent) {
        String stringExtra;
        if (PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_NOTIFICATION_SHOW_V3.equals(i(intent))) {
            stringExtra = intent.getStringExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE);
        } else {
            stringExtra = intent.getStringExtra("message");
        }
        return MessageV3.parse(c().getPackageName(), g(intent), h(intent), d(intent), e(intent), f(intent), stringExtra);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(MessageV3 messageV3, com.meizu.cloud.pushsdk.notification.e eVar) {
        if (eVar != null) {
            eVar.c(messageV3);
            b().b(c(), messageV3.getTitle(), messageV3.getContent(), a(messageV3.getWebUrl(), messageV3.getParamsMap()));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: c  reason: avoid collision after fix types in other method */
    public com.meizu.cloud.pushsdk.notification.e a(MessageV3 messageV3) {
        PushNotificationBuilder pushNotificationBuilder = new PushNotificationBuilder();
        b().a(pushNotificationBuilder);
        com.meizu.cloud.pushsdk.notification.e eVar = null;
        if (messageV3.getmNotificationStyle() != null) {
            int baseStyle = messageV3.getmNotificationStyle().getBaseStyle();
            if (BaseStyleModel.FLYME.getCode() == baseStyle) {
                int innerStyle = messageV3.getmNotificationStyle().getInnerStyle();
                if (InnerStyleLayout.EXPANDABLE_STANDARD.getCode() == innerStyle) {
                    com.meizu.cloud.a.a.i("AbstractMessageHandler", "show Standard Notification with Expandable disable");
                    eVar = new com.meizu.cloud.pushsdk.notification.f(c(), pushNotificationBuilder);
                } else if (InnerStyleLayout.EXPANDABLE_TEXT.getCode() == innerStyle) {
                    com.meizu.cloud.a.a.i("AbstractMessageHandler", "show Standard Notification with Expandable Text");
                    eVar = new com.meizu.cloud.pushsdk.notification.c(c(), pushNotificationBuilder);
                } else if (InnerStyleLayout.EXPANDABLE_PIC.getCode() == innerStyle) {
                    com.meizu.cloud.a.a.i("AbstractMessageHandler", "show Standard Notification with Expandable Picture");
                    eVar = new com.meizu.cloud.pushsdk.notification.b(c(), pushNotificationBuilder);
                } else if (InnerStyleLayout.EXPANDABLE_VIDEO.getCode() == innerStyle) {
                    com.meizu.cloud.a.a.i("AbstractMessageHandler", "show Flyme Video notification");
                    eVar = new com.meizu.cloud.pushsdk.notification.a.d(c(), pushNotificationBuilder);
                }
            } else if (BaseStyleModel.PURE_PICTURE.getCode() == baseStyle) {
                eVar = new com.meizu.cloud.pushsdk.notification.d(c(), pushNotificationBuilder);
                com.meizu.cloud.a.a.i("AbstractMessageHandler", "show Pure Picture Notification");
            } else if (BaseStyleModel.ANDROID.getCode() == baseStyle) {
                int innerStyle2 = messageV3.getmNotificationStyle().getInnerStyle();
                if (InnerStyleLayout.EXPANDABLE_STANDARD.getCode() == innerStyle2) {
                    com.meizu.cloud.a.a.i("AbstractMessageHandler", "show Android  Notification with Expandable disable");
                    eVar = new com.meizu.cloud.pushsdk.notification.a.c(c(), pushNotificationBuilder);
                } else if (InnerStyleLayout.EXPANDABLE_TEXT.getCode() == innerStyle2) {
                    com.meizu.cloud.a.a.i("AbstractMessageHandler", "show Android  Notification with Expandable Text");
                    eVar = new com.meizu.cloud.pushsdk.notification.a.b(c(), pushNotificationBuilder);
                } else if (InnerStyleLayout.EXPANDABLE_PIC.getCode() == innerStyle2) {
                    com.meizu.cloud.a.a.i("AbstractMessageHandler", "show Android  Notification with Expandable Picture");
                    eVar = new com.meizu.cloud.pushsdk.notification.a.a(c(), pushNotificationBuilder);
                } else if (InnerStyleLayout.EXPANDABLE_VIDEO.getCode() == innerStyle2) {
                    com.meizu.cloud.a.a.i("AbstractMessageHandler", "show Flyme Video notification");
                    eVar = new com.meizu.cloud.pushsdk.notification.a.d(c(), pushNotificationBuilder);
                }
            }
        }
        if (eVar == null) {
            com.meizu.cloud.a.a.e("AbstractMessageHandler", "use standard v2 notification");
            return new g(c(), pushNotificationBuilder);
        }
        return eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public int d(MessageV3 messageV3) {
        if (messageV3.getmTimeDisplaySetting() == null || !messageV3.getmTimeDisplaySetting().isTimeDisplay()) {
            return 0;
        }
        if (System.currentTimeMillis() > Long.valueOf(messageV3.getmTimeDisplaySetting().getEndShowTime()).longValue()) {
            com.meizu.cloud.pushsdk.util.d.a(c(), "schedule notification expire", (int) PushConstants.EXPIRE_NOTIFICATION, messageV3.getTaskId(), messageV3.getDeviceId());
            return 1;
        } else if (System.currentTimeMillis() > Long.valueOf(messageV3.getmTimeDisplaySetting().getStartShowTime()).longValue()) {
            com.meizu.cloud.pushsdk.util.d.a(c(), "schedule notification on time", (int) PushConstants.ONTIME_NOTIFICATION, messageV3.getTaskId(), messageV3.getDeviceId());
            return 2;
        } else {
            com.meizu.cloud.pushsdk.util.d.a(c(), "schedule notification delay", (int) PushConstants.DELAY_NOTIFICATION, messageV3.getTaskId(), messageV3.getDeviceId());
            return 3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
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
        PendingIntent service = PendingIntent.getService(c(), 0, intent, 1073741824);
        String startShowTime = messageV3.getmTimeDisplaySetting().getStartShowTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = null;
        if (!TextUtils.isEmpty(startShowTime)) {
            str = simpleDateFormat.format(new Date(Long.valueOf(startShowTime).longValue()));
        }
        long longValue = Long.valueOf(startShowTime).longValue() - System.currentTimeMillis();
        com.meizu.cloud.a.a.i("AbstractMessageHandler", "after " + (longValue / 1000) + " seconds Notification AlarmManager execute At " + str);
        if (h.a(19)) {
            com.meizu.cloud.a.a.i("AbstractMessageHandler", "setAlarmManager setWindow ELAPSED_REALTIME_WAKEUP");
            alarmManager.setExact(2, longValue + SystemClock.elapsedRealtime(), service);
            return;
        }
        alarmManager.set(2, longValue + SystemClock.elapsedRealtime(), service);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(Intent intent) {
        com.meizu.cloud.a.a.i("AbstractMessageHandler", "start MessageV3Handler match");
        if (a(0, g(intent))) {
            if (PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_NOTIFICATION_SHOW_V3.equals(i(intent))) {
                return true;
            }
            if (TextUtils.isEmpty(i(intent))) {
                String stringExtra = intent.getStringExtra("message");
                if (TextUtils.isEmpty(stringExtra) || !a(stringExtra)) {
                    return false;
                }
                com.meizu.cloud.a.a.e("AbstractMessageHandler", "old cloud notification message");
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 4;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: a */
    public void b(MessageV3 messageV3) {
        com.meizu.cloud.pushsdk.util.d.c(c(), messageV3.getUploadDataPackageName(), messageV3.getDeviceId(), messageV3.getTaskId(), messageV3.getSeqId(), messageV3.getPushTimestamp());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: b */
    public void c(MessageV3 messageV3) {
        com.meizu.cloud.pushsdk.util.d.a(c(), messageV3.getUploadDataPackageName(), messageV3.getDeviceId(), messageV3.getTaskId(), messageV3.getSeqId(), messageV3.getPushTimestamp());
    }
}
