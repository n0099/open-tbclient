package com.meizu.cloud.pushsdk.handler.a.c;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.handler.MzPushMessage;
import com.meizu.cloud.pushsdk.notification.MPushMessage;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
import java.util.Map;
/* loaded from: classes7.dex */
public class b extends com.meizu.cloud.pushsdk.handler.a.a<MessageV3> {
    public b(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    private Intent a(Context context, MessageV3 messageV3) {
        Intent intent;
        String uriPackageName = messageV3.getUriPackageName();
        String uploadDataPackageName = TextUtils.isEmpty(uriPackageName) ? messageV3.getUploadDataPackageName() : uriPackageName;
        com.meizu.cloud.a.a.i("AbstractMessageHandler", "openClassName is " + uploadDataPackageName);
        if (messageV3.getClickType() == 0) {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(uploadDataPackageName);
            if (launchIntentForPackage == null || messageV3.getParamsMap() == null) {
                intent = launchIntentForPackage;
            } else {
                for (Map.Entry<String, String> entry : messageV3.getParamsMap().entrySet()) {
                    com.meizu.cloud.a.a.i("AbstractMessageHandler", " launcher activity key " + entry.getKey() + " value " + entry.getValue());
                    if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                        launchIntentForPackage.putExtra(entry.getKey(), entry.getValue());
                    }
                }
                intent = launchIntentForPackage;
            }
        } else if (1 == messageV3.getClickType()) {
            Intent intent2 = new Intent();
            if (messageV3.getParamsMap() != null) {
                for (Map.Entry<String, String> entry2 : messageV3.getParamsMap().entrySet()) {
                    com.meizu.cloud.a.a.i("AbstractMessageHandler", " key " + entry2.getKey() + " value " + entry2.getValue());
                    if (!TextUtils.isEmpty(entry2.getKey()) && !TextUtils.isEmpty(entry2.getValue())) {
                        intent2.putExtra(entry2.getKey(), entry2.getValue());
                    }
                }
            }
            intent2.setClassName(uploadDataPackageName, messageV3.getActivity());
            com.meizu.cloud.a.a.i("AbstractMessageHandler", intent2.toUri(1));
            intent = intent2;
        } else if (2 == messageV3.getClickType()) {
            intent = new Intent("android.intent.action.VIEW", Uri.parse(messageV3.getWebUrl()));
            String uriPackageName2 = messageV3.getUriPackageName();
            if (!TextUtils.isEmpty(uriPackageName2)) {
                intent.setPackage(uriPackageName2);
                com.meizu.cloud.a.a.i("AbstractMessageHandler", "set uri package " + uriPackageName2);
            }
        } else {
            if (3 == messageV3.getClickType()) {
                com.meizu.cloud.a.a.i("AbstractMessageHandler", "CLICK_TYPE_SELF_DEFINE_ACTION");
            }
            intent = null;
        }
        if (intent != null) {
            intent.putExtra(PushConstants.MZ_PUSH_PLATFROM_EXTRA, com.meizu.cloud.pushsdk.handler.a.b.d.a().a(messageV3.getTaskId()).a().b());
        }
        return intent;
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 64;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(MessageV3 messageV3, com.meizu.cloud.pushsdk.notification.c cVar) {
        com.meizu.cloud.pushsdk.util.b.a(c(), messageV3.getPackageName(), 0);
        Intent a2 = a(c(), messageV3);
        if (a2 != null) {
            a2.addFlags(268435456);
            try {
                c().startActivity(a2);
            } catch (Exception e) {
                com.meizu.cloud.a.a.e("AbstractMessageHandler", "Click message StartActivity error " + e.getMessage());
            }
        }
        if (!TextUtils.isEmpty(messageV3.getTitle()) && !TextUtils.isEmpty(messageV3.getContent()) && b() != null) {
            b().a(c(), MzPushMessage.fromMessageV3(messageV3));
        }
        if (!MinSdkChecker.isSupportSetDrawableSmallIcon()) {
            b(messageV3);
            return;
        }
        com.meizu.cloud.pushsdk.notification.model.a a3 = com.meizu.cloud.pushsdk.notification.model.a.a(messageV3);
        if (a3 != null) {
            com.meizu.cloud.a.a.e("AbstractMessageHandler", "delete notifyId " + a3.a() + " notifyKey " + a3.b());
            if (TextUtils.isEmpty(a3.b())) {
                com.meizu.cloud.pushsdk.platform.a.b.a(c()).a(messageV3.getUploadDataPackageName(), a3.a());
            } else {
                com.meizu.cloud.pushsdk.platform.a.b.a(c()).a(messageV3.getUploadDataPackageName(), a3.b());
            }
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(Intent intent) {
        com.meizu.cloud.a.a.i("AbstractMessageHandler", "start NotificationClickMessageHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE.equals(i(intent));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: d */
    public boolean g(MessageV3 messageV3) {
        return a(messageV3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: e */
    public void b(MessageV3 messageV3) {
        com.meizu.cloud.pushsdk.util.d.e(c(), messageV3.getUploadDataPackageName(), TextUtils.isEmpty(messageV3.getDeviceId()) ? d((Intent) null) : messageV3.getDeviceId(), messageV3.getTaskId(), messageV3.getSeqId(), messageV3.getPushTimestamp());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: j */
    public MessageV3 c(Intent intent) {
        String str = null;
        try {
            try {
                com.meizu.cloud.a.a.e("AbstractMessageHandler", "parse message V3");
                MessageV3 messageV3 = (MessageV3) intent.getParcelableExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE);
                if (messageV3 == null) {
                    com.meizu.cloud.a.a.e("AbstractMessageHandler", "parse MessageV2 to MessageV3");
                    MPushMessage mPushMessage = (MPushMessage) intent.getSerializableExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE);
                    str = g(intent);
                    return MessageV3.parse(str, d(intent), mPushMessage.getTaskId(), mPushMessage);
                }
                return messageV3;
            } catch (Exception e) {
                com.meizu.cloud.a.a.e("AbstractMessageHandler", "cannot get messageV3");
                if (0 == 0) {
                    com.meizu.cloud.a.a.e("AbstractMessageHandler", "parse MessageV2 to MessageV3");
                    MPushMessage mPushMessage2 = (MPushMessage) intent.getSerializableExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE);
                    return MessageV3.parse(g(intent), d(intent), mPushMessage2.getTaskId(), mPushMessage2);
                }
                return null;
            }
        } catch (Throwable th) {
            if (str == null) {
                com.meizu.cloud.a.a.e("AbstractMessageHandler", "parse MessageV2 to MessageV3");
                MPushMessage mPushMessage3 = (MPushMessage) intent.getSerializableExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE);
                MessageV3.parse(g(intent), d(intent), mPushMessage3.getTaskId(), mPushMessage3);
            }
            throw th;
        }
    }
}
