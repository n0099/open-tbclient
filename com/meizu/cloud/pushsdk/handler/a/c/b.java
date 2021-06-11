package com.meizu.cloud.pushsdk.handler.a.c;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
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
        if (TextUtils.isEmpty(uriPackageName)) {
            uriPackageName = messageV3.getUploadDataPackageName();
        }
        d.j.a.a.a.d("AbstractMessageHandler", "openClassName is " + uriPackageName);
        if (messageV3.getClickType() == 0) {
            intent = context.getPackageManager().getLaunchIntentForPackage(uriPackageName);
            if (intent != null && messageV3.getParamsMap() != null) {
                for (Map.Entry<String, String> entry : messageV3.getParamsMap().entrySet()) {
                    d.j.a.a.a.d("AbstractMessageHandler", " launcher activity key " + entry.getKey() + " value " + entry.getValue());
                    if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                        intent.putExtra(entry.getKey(), entry.getValue());
                    }
                }
            }
        } else if (1 == messageV3.getClickType()) {
            intent = new Intent();
            if (messageV3.getParamsMap() != null) {
                for (Map.Entry<String, String> entry2 : messageV3.getParamsMap().entrySet()) {
                    d.j.a.a.a.d("AbstractMessageHandler", " key " + entry2.getKey() + " value " + entry2.getValue());
                    if (!TextUtils.isEmpty(entry2.getKey()) && !TextUtils.isEmpty(entry2.getValue())) {
                        intent.putExtra(entry2.getKey(), entry2.getValue());
                    }
                }
            }
            intent.setClassName(uriPackageName, messageV3.getActivity());
            d.j.a.a.a.d("AbstractMessageHandler", intent.toUri(1));
        } else if (2 == messageV3.getClickType()) {
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(messageV3.getWebUrl()));
            String uriPackageName2 = messageV3.getUriPackageName();
            if (!TextUtils.isEmpty(uriPackageName2)) {
                intent2.setPackage(uriPackageName2);
                d.j.a.a.a.d("AbstractMessageHandler", "set uri package " + uriPackageName2);
            }
            intent = intent2;
        } else {
            if (3 == messageV3.getClickType()) {
                d.j.a.a.a.d("AbstractMessageHandler", "CLICK_TYPE_SELF_DEFINE_ACTION");
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
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(MessageV3 messageV3, com.meizu.cloud.pushsdk.notification.c cVar) {
        com.meizu.cloud.pushsdk.util.b.a(c(), messageV3.getPackageName(), 0);
        Intent a2 = a(c(), messageV3);
        if (a2 != null) {
            a2.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            try {
                c().startActivity(a2);
            } catch (Exception e2) {
                d.j.a.a.a.b("AbstractMessageHandler", "Click message StartActivity error " + e2.getMessage());
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
            d.j.a.a.a.b("AbstractMessageHandler", "delete notifyId " + a3.a() + " notifyKey " + a3.b());
            if (TextUtils.isEmpty(a3.b())) {
                com.meizu.cloud.pushsdk.platform.a.b.a(c()).a(messageV3.getUploadDataPackageName(), a3.a());
            } else {
                com.meizu.cloud.pushsdk.platform.a.b.a(c()).a(messageV3.getUploadDataPackageName(), a3.b());
            }
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(Intent intent) {
        d.j.a.a.a.d("AbstractMessageHandler", "start NotificationClickMessageHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE.equals(i(intent));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: d */
    public boolean g(MessageV3 messageV3) {
        return a(messageV3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: e */
    public void b(MessageV3 messageV3) {
        com.meizu.cloud.pushsdk.util.d.e(c(), messageV3.getUploadDataPackageName(), TextUtils.isEmpty(messageV3.getDeviceId()) ? d((Intent) null) : messageV3.getDeviceId(), messageV3.getTaskId(), messageV3.getSeqId(), messageV3.getPushTimestamp());
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:13:0x0006 */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.meizu.cloud.pushsdk.notification.MPushMessage] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.meizu.cloud.pushsdk.handler.a.c.b, com.meizu.cloud.pushsdk.handler.a.a] */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.content.Intent] */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Intent] */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.String] */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: j */
    public MessageV3 c(Intent intent) {
        MPushMessage mPushMessage;
        String g2;
        String d2;
        String taskId;
        ?? r0 = "parse MessageV2 to MessageV3";
        String str = PushConstants.MZ_PUSH_PRIVATE_MESSAGE;
        String str2 = "AbstractMessageHandler";
        try {
            try {
                d.j.a.a.a.b("AbstractMessageHandler", "parse message V3");
                MessageV3 messageV3 = (MessageV3) intent.getParcelableExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE);
                if (messageV3 != null) {
                    return messageV3;
                }
            } catch (Exception unused) {
                d.j.a.a.a.b("AbstractMessageHandler", "cannot get messageV3");
            }
            return MessageV3.parse(g2, (String) d2, taskId, (MPushMessage) mPushMessage);
        } finally {
            d.j.a.a.a.b(str2, r0);
            mPushMessage = (MPushMessage) intent.getSerializableExtra(str);
            MessageV3.parse(g(intent), d(intent), mPushMessage.getTaskId(), mPushMessage);
        }
    }
}
