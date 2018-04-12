package com.meizu.cloud.pushsdk.handler.a.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.notification.MPushMessage;
import com.meizu.cloud.pushsdk.notification.e;
import com.meizu.cloud.pushsdk.util.c;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.Map;
/* loaded from: classes3.dex */
public class a extends com.meizu.cloud.pushsdk.handler.a.a<MessageV3> {
    public a(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
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
                if (0 != 0) {
                    return null;
                }
                com.meizu.cloud.a.a.e("AbstractMessageHandler", "parse MessageV2 to MessageV3");
                MPushMessage mPushMessage2 = (MPushMessage) intent.getSerializableExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE);
                return MessageV3.parse(g(intent), d(intent), mPushMessage2.getTaskId(), mPushMessage2);
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(MessageV3 messageV3, e eVar) {
        com.meizu.cloud.pushsdk.util.b.a(c(), messageV3.getPackageName(), 0);
        Intent a = a(c(), messageV3);
        if (a != null) {
            a.addFlags(268435456);
            try {
                c().startActivity(a);
            } catch (Exception e) {
                com.meizu.cloud.a.a.e("AbstractMessageHandler", "Click message StartActivity error " + e.getMessage());
            }
        }
        if (!TextUtils.isEmpty(messageV3.getTitle()) && !TextUtils.isEmpty(messageV3.getContent())) {
            b().a(c(), messageV3.getTitle(), messageV3.getContent(), a(messageV3.getWebUrl(), messageV3.getParamsMap()));
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(Intent intent) {
        com.meizu.cloud.a.a.i("AbstractMessageHandler", "start NotificationClickMessageHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE.equals(i(intent));
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 64;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: a */
    public void b(MessageV3 messageV3) {
        c.e(c(), messageV3.getUploadDataPackageName(), messageV3.getDeviceId(), messageV3.getTaskId(), messageV3.getSeqId(), messageV3.getPushTimestamp());
    }

    private Intent a(Context context, MessageV3 messageV3) {
        Intent intent;
        if (messageV3.getClickType() == 0) {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(messageV3.getUploadDataPackageName());
            if (launchIntentForPackage != null && messageV3.getParamsMap() != null) {
                for (Map.Entry<String, String> entry : messageV3.getParamsMap().entrySet()) {
                    com.meizu.cloud.a.a.i("AbstractMessageHandler", " launcher activity key " + entry.getKey() + " value " + entry.getValue());
                    if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                        launchIntentForPackage.putExtra(entry.getKey(), b(entry.getValue()));
                    }
                }
                return launchIntentForPackage;
            }
            return launchIntentForPackage;
        } else if (1 == messageV3.getClickType()) {
            String str = "";
            if (messageV3.getParamsMap() != null) {
                for (Map.Entry<String, String> entry2 : messageV3.getParamsMap().entrySet()) {
                    com.meizu.cloud.a.a.i("AbstractMessageHandler", " key " + entry2.getKey() + " value " + entry2.getValue());
                    String str2 = (TextUtils.isEmpty(entry2.getKey()) || TextUtils.isEmpty(entry2.getValue())) ? str : str + "S." + entry2.getKey() + "=" + b(entry2.getValue()) + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR;
                    com.meizu.cloud.a.a.i("AbstractMessageHandler", "paramValue " + str2);
                    str = str2;
                }
            }
            String str3 = "intent:#Intent;component=" + messageV3.getUploadDataPackageName() + "/" + messageV3.getActivity() + (TextUtils.isEmpty(str) ? ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str) + "end";
            com.meizu.cloud.a.a.i("AbstractMessageHandler", "open activity intent uri " + str3);
            try {
                intent = Intent.parseUri(str3, 1);
            } catch (URISyntaxException e) {
                com.meizu.cloud.a.a.e("AbstractMessageHandler", "parse Uri error " + e.getMessage());
                intent = null;
            }
            return intent;
        } else if (2 == messageV3.getClickType()) {
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(messageV3.getWebUrl()));
            String uriPackageName = messageV3.getUriPackageName();
            if (!TextUtils.isEmpty(uriPackageName)) {
                intent2.setPackage(uriPackageName);
                com.meizu.cloud.a.a.i("AbstractMessageHandler", "set uri package " + uriPackageName);
                return intent2;
            }
            return intent2;
        } else if (3 != messageV3.getClickType()) {
            return null;
        } else {
            com.meizu.cloud.a.a.i("AbstractMessageHandler", "CLICK_TYPE_SELF_DEFINE_ACTION");
            return null;
        }
    }

    private String b(String str) {
        try {
            str = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            com.meizu.cloud.a.a.i("AbstractMessageHandler", "encode url fail");
        }
        Log.i("AbstractMessageHandler", "encode all value is " + str);
        return str;
    }
}
