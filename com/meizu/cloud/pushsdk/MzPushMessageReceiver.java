package com.meizu.cloud.pushsdk;

import android.content.Context;
import android.content.Intent;
import com.meizu.cloud.pushsdk.base.IntentReceiver;
import com.meizu.cloud.pushsdk.handler.MzPushMessage;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;
import com.meizu.cloud.pushsdk.util.d;
/* loaded from: classes6.dex */
public abstract class MzPushMessageReceiver extends IntentReceiver {
    public static final String TAG = "MzPushMessageReceiver";

    @Override // com.meizu.cloud.pushsdk.base.IntentReceiver
    public void onHandleIntent(Context context, Intent intent) {
        a.a(context).a(TAG, new com.meizu.cloud.pushsdk.handler.a() { // from class: com.meizu.cloud.pushsdk.MzPushMessageReceiver.1
            @Override // com.meizu.cloud.pushsdk.handler.a
            public void a(Context context2, Intent intent2) {
                com.meizu.cloud.a.a.i(MzPushMessageReceiver.TAG, "onMessage Flyme3 " + intent2);
                MzPushMessageReceiver.this.onMessage(context2, intent2);
            }

            @Override // com.meizu.cloud.pushsdk.handler.b
            public void a(Context context2, MzPushMessage mzPushMessage) {
                com.meizu.cloud.a.a.i(MzPushMessageReceiver.TAG, "onNotificationClicked title " + mzPushMessage.getTitle() + "content " + mzPushMessage.getContent() + " selfDefineContentString " + mzPushMessage.getSelfDefineContentString());
                MzPushMessageReceiver.this.onNotificationClicked(context2, mzPushMessage);
            }

            @Override // com.meizu.cloud.pushsdk.handler.b
            public void a(Context context2, PushSwitchStatus pushSwitchStatus) {
                com.meizu.cloud.a.a.i(MzPushMessageReceiver.TAG, "onPushStatus " + pushSwitchStatus);
                MzPushMessageReceiver.this.onPushStatus(context2, pushSwitchStatus);
            }

            @Override // com.meizu.cloud.pushsdk.handler.b
            public void a(Context context2, RegisterStatus registerStatus) {
                com.meizu.cloud.a.a.i(MzPushMessageReceiver.TAG, "onRegisterStatus " + registerStatus);
                MzPushMessageReceiver.this.onRegisterStatus(context2, registerStatus);
            }

            @Override // com.meizu.cloud.pushsdk.handler.b
            public void a(Context context2, SubAliasStatus subAliasStatus) {
                com.meizu.cloud.a.a.i(MzPushMessageReceiver.TAG, "onSubAliasStatus " + subAliasStatus);
                MzPushMessageReceiver.this.onSubAliasStatus(context2, subAliasStatus);
            }

            @Override // com.meizu.cloud.pushsdk.handler.b
            public void a(Context context2, SubTagsStatus subTagsStatus) {
                com.meizu.cloud.a.a.i(MzPushMessageReceiver.TAG, "onSubTagsStatus " + subTagsStatus);
                MzPushMessageReceiver.this.onSubTagsStatus(context2, subTagsStatus);
            }

            @Override // com.meizu.cloud.pushsdk.handler.b
            public void a(Context context2, UnRegisterStatus unRegisterStatus) {
                com.meizu.cloud.a.a.i(MzPushMessageReceiver.TAG, "onUnRegisterStatus " + unRegisterStatus);
                MzPushMessageReceiver.this.onUnRegisterStatus(context2, unRegisterStatus);
            }

            @Override // com.meizu.cloud.pushsdk.handler.b
            public void a(Context context2, String str) {
                com.meizu.cloud.a.a.i(MzPushMessageReceiver.TAG, "onRegister " + str);
                MzPushMessageReceiver.this.onRegister(context2, str);
            }

            @Override // com.meizu.cloud.pushsdk.handler.b
            public void a(Context context2, String str, String str2) {
                MzPushMessageReceiver.this.onMessage(context2, str, str2);
                com.meizu.cloud.a.a.i(MzPushMessageReceiver.TAG, "receive message " + str + " platformExtra " + str2);
            }

            @Override // com.meizu.cloud.pushsdk.handler.b
            public void a(Context context2, boolean z) {
                com.meizu.cloud.a.a.i(MzPushMessageReceiver.TAG, "onUnRegister " + z);
                MzPushMessageReceiver.this.onUnRegister(context2, z);
            }

            @Override // com.meizu.cloud.pushsdk.handler.b
            public void a(PushNotificationBuilder pushNotificationBuilder) {
                MzPushMessageReceiver.this.onUpdateNotificationBuilder(pushNotificationBuilder);
            }

            @Override // com.meizu.cloud.pushsdk.handler.b
            public void b(Context context2, MzPushMessage mzPushMessage) {
                com.meizu.cloud.a.a.i(MzPushMessageReceiver.TAG, "onNotificationArrived title " + mzPushMessage.getTitle() + "content " + mzPushMessage.getContent() + " selfDefineContentString " + mzPushMessage.getSelfDefineContentString());
                MzPushMessageReceiver.this.onNotificationArrived(context2, mzPushMessage);
            }

            @Override // com.meizu.cloud.pushsdk.handler.b
            public void b(Context context2, String str) {
                MzPushMessageReceiver.this.onMessage(context2, str);
                com.meizu.cloud.a.a.i(MzPushMessageReceiver.TAG, "receive message " + str);
            }

            @Override // com.meizu.cloud.pushsdk.handler.b
            public void c(Context context2, MzPushMessage mzPushMessage) {
                com.meizu.cloud.a.a.i(MzPushMessageReceiver.TAG, "onNotificationDeleted title " + mzPushMessage.getTitle() + "content " + mzPushMessage.getContent() + " selfDefineContentString " + mzPushMessage.getSelfDefineContentString());
                MzPushMessageReceiver.this.onNotificationDeleted(context2, mzPushMessage);
            }

            @Override // com.meizu.cloud.pushsdk.handler.b
            public void c(Context context2, String str) {
                com.meizu.cloud.a.a.i(MzPushMessageReceiver.TAG, "onNotifyMessageArrived " + str);
                MzPushMessageReceiver.this.onNotifyMessageArrived(context2, str);
            }
        }).a(intent);
    }

    public void onMessage(Context context, Intent intent) {
    }

    public void onMessage(Context context, String str) {
    }

    public void onMessage(Context context, String str, String str2) {
    }

    public void onNotificationArrived(Context context, MzPushMessage mzPushMessage) {
    }

    public void onNotificationClicked(Context context, MzPushMessage mzPushMessage) {
    }

    public void onNotificationDeleted(Context context, MzPushMessage mzPushMessage) {
    }

    public void onNotifyMessageArrived(Context context, String str) {
    }

    public abstract void onPushStatus(Context context, PushSwitchStatus pushSwitchStatus);

    @Override // com.meizu.cloud.pushsdk.base.IntentReceiver, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            super.onReceive(context, intent);
        } catch (Exception e) {
            com.meizu.cloud.a.a.e(TAG, "Event core error " + e.getMessage());
            d.a(context, context.getPackageName(), null, null, PushManager.TAG, "MzPushMessageReceiver " + e.getMessage(), 3000);
        }
    }

    @Deprecated
    public abstract void onRegister(Context context, String str);

    public abstract void onRegisterStatus(Context context, RegisterStatus registerStatus);

    public abstract void onSubAliasStatus(Context context, SubAliasStatus subAliasStatus);

    public abstract void onSubTagsStatus(Context context, SubTagsStatus subTagsStatus);

    @Deprecated
    public abstract void onUnRegister(Context context, boolean z);

    public abstract void onUnRegisterStatus(Context context, UnRegisterStatus unRegisterStatus);

    public void onUpdateNotificationBuilder(PushNotificationBuilder pushNotificationBuilder) {
    }
}
