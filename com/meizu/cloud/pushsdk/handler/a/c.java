package com.meizu.cloud.pushsdk.handler.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.android.util.time.DateTimeUtil;
import com.meizu.cloud.pushsdk.NotificationService;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.handler.MzPushMessage;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.notification.model.styleenum.BaseStyleModel;
import com.meizu.cloud.pushsdk.notification.model.styleenum.InnerStyleLayout;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c extends a<MessageV3> {
    public c(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    private String i(MessageV3 messageV3) {
        String selfDefineContentString = MzPushMessage.fromMessageV3(messageV3).getSelfDefineContentString();
        if (TextUtils.isEmpty(selfDefineContentString)) {
            return null;
        }
        try {
            return new JSONObject(selfDefineContentString).getString("package_name");
        } catch (JSONException e) {
            com.meizu.cloud.a.a.e("AbstractMessageHandler", "no quick json message");
            return null;
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 4;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(MessageV3 messageV3, com.meizu.cloud.pushsdk.notification.c cVar) {
        if (cVar != null) {
            cVar.e(messageV3);
            b(messageV3);
        }
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: c */
    public void b(MessageV3 messageV3) {
        com.meizu.cloud.pushsdk.util.c.c(c(), messageV3.getUploadDataPackageName(), messageV3.getDeviceId(), messageV3.getTaskId(), messageV3.getSeqId(), messageV3.getPushTimestamp());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: d */
    public void c(MessageV3 messageV3) {
        com.meizu.cloud.pushsdk.util.c.a(c(), messageV3.getUploadDataPackageName(), messageV3.getDeviceId(), messageV3.getTaskId(), messageV3.getSeqId(), messageV3.getPushTimestamp());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: e  reason: avoid collision after fix types in other method */
    public com.meizu.cloud.pushsdk.notification.c a(MessageV3 messageV3) {
        PushNotificationBuilder pushNotificationBuilder = new PushNotificationBuilder();
        pushNotificationBuilder.setClickPackageName(i(messageV3));
        b().a(pushNotificationBuilder);
        com.meizu.cloud.pushsdk.notification.c cVar = null;
        if (messageV3.getmNotificationStyle() != null) {
            int baseStyle = messageV3.getmNotificationStyle().getBaseStyle();
            if (BaseStyleModel.FLYME.getCode() == baseStyle) {
                int innerStyle = messageV3.getmNotificationStyle().getInnerStyle();
                if (InnerStyleLayout.EXPANDABLE_STANDARD.getCode() == innerStyle) {
                    com.meizu.cloud.a.a.i("AbstractMessageHandler", "show Standard Notification with Expandable disable");
                    cVar = new com.meizu.cloud.pushsdk.notification.b.c(c(), pushNotificationBuilder);
                } else if (InnerStyleLayout.EXPANDABLE_TEXT.getCode() == innerStyle) {
                    com.meizu.cloud.a.a.i("AbstractMessageHandler", "show Standard Notification with Expandable Text");
                    cVar = new com.meizu.cloud.pushsdk.notification.b.b(c(), pushNotificationBuilder);
                } else if (InnerStyleLayout.EXPANDABLE_PIC.getCode() == innerStyle) {
                    com.meizu.cloud.a.a.i("AbstractMessageHandler", "show Standard Notification with Expandable Picture");
                    cVar = new com.meizu.cloud.pushsdk.notification.b.a(c(), pushNotificationBuilder);
                } else if (InnerStyleLayout.EXPANDABLE_VIDEO.getCode() == innerStyle) {
                    com.meizu.cloud.a.a.i("AbstractMessageHandler", "show Flyme Video notification");
                    cVar = new com.meizu.cloud.pushsdk.notification.a.d(c(), pushNotificationBuilder);
                }
            } else if (BaseStyleModel.PURE_PICTURE.getCode() == baseStyle) {
                cVar = new com.meizu.cloud.pushsdk.notification.b(c(), pushNotificationBuilder);
                com.meizu.cloud.a.a.i("AbstractMessageHandler", "show Pure Picture Notification");
            } else if (BaseStyleModel.ANDROID.getCode() == baseStyle) {
                int innerStyle2 = messageV3.getmNotificationStyle().getInnerStyle();
                if (InnerStyleLayout.EXPANDABLE_STANDARD.getCode() == innerStyle2) {
                    com.meizu.cloud.a.a.i("AbstractMessageHandler", "show Android  Notification with Expandable disable");
                    cVar = new com.meizu.cloud.pushsdk.notification.a.c(c(), pushNotificationBuilder);
                } else if (InnerStyleLayout.EXPANDABLE_TEXT.getCode() == innerStyle2) {
                    com.meizu.cloud.a.a.i("AbstractMessageHandler", "show Android  Notification with Expandable Text");
                    cVar = new com.meizu.cloud.pushsdk.notification.a.b(c(), pushNotificationBuilder);
                } else if (InnerStyleLayout.EXPANDABLE_PIC.getCode() == innerStyle2) {
                    com.meizu.cloud.a.a.i("AbstractMessageHandler", "show Android  Notification with Expandable Picture");
                    cVar = new com.meizu.cloud.pushsdk.notification.a.a(c(), pushNotificationBuilder);
                } else if (InnerStyleLayout.EXPANDABLE_VIDEO.getCode() == innerStyle2) {
                    com.meizu.cloud.a.a.i("AbstractMessageHandler", "show Flyme Video notification");
                    cVar = new com.meizu.cloud.pushsdk.notification.a.d(c(), pushNotificationBuilder);
                }
            }
        }
        if (cVar == null) {
            com.meizu.cloud.a.a.e("AbstractMessageHandler", "use standard v2 notification");
            return new com.meizu.cloud.pushsdk.notification.d(c(), pushNotificationBuilder);
        }
        return cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public boolean f(MessageV3 messageV3) {
        String uriPackageName = messageV3.getUriPackageName();
        if (TextUtils.isEmpty(uriPackageName)) {
            return true;
        }
        return MzSystemUtils.isPackageInstalled(c(), uriPackageName);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: g */
    public int d(MessageV3 messageV3) {
        if (messageV3.getmTimeDisplaySetting() == null || !messageV3.getmTimeDisplaySetting().isTimeDisplay()) {
            return 0;
        }
        if (System.currentTimeMillis() > Long.valueOf(messageV3.getmTimeDisplaySetting().getEndShowTime()).longValue()) {
            com.meizu.cloud.pushsdk.util.c.a(c(), "schedule notification expire", (int) PushConstants.EXPIRE_NOTIFICATION, messageV3.getTaskId(), messageV3.getDeviceId());
            return 1;
        } else if (System.currentTimeMillis() > Long.valueOf(messageV3.getmTimeDisplaySetting().getStartShowTime()).longValue()) {
            com.meizu.cloud.pushsdk.util.c.a(c(), "schedule notification on time", (int) PushConstants.ONTIME_NOTIFICATION, messageV3.getTaskId(), messageV3.getDeviceId());
            return 2;
        } else {
            com.meizu.cloud.pushsdk.util.c.a(c(), "schedule notification delay", (int) PushConstants.DELAY_NOTIFICATION, messageV3.getTaskId(), messageV3.getDeviceId());
            return 3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: h */
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
        PendingIntent service = PendingIntent.getService(c(), 0, intent, MinSdkChecker.isSupportSetDrawableSmallIcon() ? 67108864 : 1073741824);
        String startShowTime = messageV3.getmTimeDisplaySetting().getStartShowTime();
        String format = TextUtils.isEmpty(startShowTime) ? null : new SimpleDateFormat(DateTimeUtil.TIME_FORMAT).format(new Date(Long.valueOf(startShowTime).longValue()));
        long longValue = Long.valueOf(startShowTime).longValue() - System.currentTimeMillis();
        com.meizu.cloud.a.a.i("AbstractMessageHandler", "after " + (longValue / 1000) + " seconds Notification AlarmManager execute At " + format);
        if (Build.VERSION.SDK_INT < 19) {
            alarmManager.set(2, longValue + SystemClock.elapsedRealtime(), service);
            return;
        }
        com.meizu.cloud.a.a.i("AbstractMessageHandler", "setAlarmManager setWindow ELAPSED_REALTIME_WAKEUP");
        alarmManager.setExact(2, longValue + SystemClock.elapsedRealtime(), service);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: j */
    public MessageV3 c(Intent intent) {
        return MessageV3.parse(c().getPackageName(), g(intent), h(intent), d(intent), e(intent), f(intent), PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_NOTIFICATION_SHOW_V3.equals(i(intent)) ? intent.getStringExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE) : intent.getStringExtra("message"));
    }
}
