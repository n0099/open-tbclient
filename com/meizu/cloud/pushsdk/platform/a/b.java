package com.meizu.cloud.pushsdk.platform.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.networking.c.k;
import com.meizu.cloud.pushsdk.networking.error.ANError;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class b {
    private static b a;
    private Handler c;
    private Context d;
    private a e;
    private int f = 0;
    private ScheduledExecutorService b = Executors.newSingleThreadScheduledExecutor();

    public b(Context context) {
        this.d = context;
        this.e = new a(context);
        this.c = new Handler(this.d.getMainLooper()) { // from class: com.meizu.cloud.pushsdk.platform.a.b.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                String string = message.getData().getString("deviceId");
                String string2 = message.getData().getString("appId");
                String string3 = message.getData().getString(WBConstants.SSO_APP_KEY);
                switch (message.what) {
                    case 0:
                        b.this.a(string2, string3, string);
                        return;
                    case 1:
                        b.this.b(string2, string3, string);
                        return;
                    case 2:
                        b.this.c(message.getData().getString("packageName"), string);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public static b a(Context context) {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b(context);
                }
            }
        }
        return a;
    }

    public void a(String str, String str2) {
        String a2 = com.meizu.cloud.pushsdk.util.b.a(this.d);
        int b = com.meizu.cloud.pushsdk.util.b.b(this.d);
        if (!TextUtils.isEmpty(a2) && System.currentTimeMillis() / 1000 < b) {
            RegisterStatus registerStatus = new RegisterStatus();
            registerStatus.setCode(BasicPushStatus.SUCCESS_CODE);
            registerStatus.setMessage("already register PushId,dont register frequently");
            registerStatus.setPushId(a2);
            registerStatus.setExpireTime((int) (b - (System.currentTimeMillis() / 1000)));
            PlatformMessageSender.sendRegisterStatus(this.d, registerStatus);
            return;
        }
        com.meizu.cloud.pushsdk.util.b.a(this.d, "");
        com.meizu.cloud.a.a.i("PushPlatformManager", "after " + (this.f * 10) + " seconds start register");
        a(0, str, str2, this.f * 10);
    }

    public void a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            int i = this.f;
            this.f = i + 1;
            if (i < 3) {
                com.meizu.cloud.a.a.e("PushPlatformManager", "Get deviceId error so after " + (this.f * 10) + " seconds retry register");
                a(0, str, str2, this.f * 10);
                return;
            }
        }
        com.meizu.cloud.a.a.i("PushPlatformManager", "device retry count " + this.f);
        this.f = 0;
        this.e.a(str, str2, str3, new k() { // from class: com.meizu.cloud.pushsdk.platform.a.b.8
            @Override // com.meizu.cloud.pushsdk.networking.c.k
            public void a(com.meizu.cloud.pushsdk.networking.b.k kVar, String str4) {
                com.meizu.cloud.a.a.e("PushPlatformManager", str4.toString());
                RegisterStatus registerStatus = new RegisterStatus(str4.toString());
                com.meizu.cloud.a.a.e("PushPlatformManager", "registerStatus " + registerStatus);
                PlatformMessageSender.sendRegisterStatus(b.this.d, registerStatus);
            }

            @Override // com.meizu.cloud.pushsdk.networking.c.k
            public void a(ANError aNError) {
                if (aNError.getResponse() != null) {
                    com.meizu.cloud.a.a.e("PushPlatformManager", "status code=" + aNError.getErrorCode() + " data=" + aNError.getResponse());
                }
                RegisterStatus registerStatus = new RegisterStatus();
                registerStatus.setCode(String.valueOf(aNError.getErrorCode()));
                registerStatus.setMessage(aNError.getErrorBody());
                com.meizu.cloud.a.a.e("PushPlatformManager", "registerStatus " + registerStatus);
                PlatformMessageSender.sendRegisterStatus(b.this.d, registerStatus);
            }
        });
    }

    public void b(String str, String str2) {
        if (TextUtils.isEmpty(com.meizu.cloud.pushsdk.util.b.a(this.d))) {
            UnRegisterStatus unRegisterStatus = new UnRegisterStatus();
            unRegisterStatus.setCode(BasicPushStatus.SUCCESS_CODE);
            unRegisterStatus.setMessage("already unRegister PushId,dont unRegister frequently");
            unRegisterStatus.setIsUnRegisterSuccess(true);
            PlatformMessageSender.sendUnRegisterStatus(this.d, unRegisterStatus);
            return;
        }
        a(1, str, str2, 0L);
    }

    public void b(String str, String str2, String str3) {
        this.e.b(str, str2, str3, new k() { // from class: com.meizu.cloud.pushsdk.platform.a.b.9
            @Override // com.meizu.cloud.pushsdk.networking.c.k
            public void a(com.meizu.cloud.pushsdk.networking.b.k kVar, String str4) {
                com.meizu.cloud.a.a.e("PushPlatformManager", "unRegister" + str4.toString());
                UnRegisterStatus unRegisterStatus = new UnRegisterStatus(str4.toString());
                com.meizu.cloud.a.a.e("PushPlatformManager", "unRegisterStatus " + unRegisterStatus);
                PlatformMessageSender.sendUnRegisterStatus(b.this.d, unRegisterStatus);
            }

            @Override // com.meizu.cloud.pushsdk.networking.c.k
            public void a(ANError aNError) {
                UnRegisterStatus unRegisterStatus = new UnRegisterStatus();
                unRegisterStatus.setCode(String.valueOf(aNError.getErrorCode()));
                unRegisterStatus.setIsUnRegisterSuccess(false);
                unRegisterStatus.setMessage(aNError.getErrorBody());
                com.meizu.cloud.a.a.e("PushPlatformManager", "unRegisterStatus " + unRegisterStatus);
                PlatformMessageSender.sendUnRegisterStatus(b.this.d, unRegisterStatus);
            }
        });
    }

    public void c(final String str, String str2) {
        this.e.a(str, str2, new k() { // from class: com.meizu.cloud.pushsdk.platform.a.b.10
            @Override // com.meizu.cloud.pushsdk.networking.c.k
            public void a(com.meizu.cloud.pushsdk.networking.b.k kVar, String str3) {
                com.meizu.cloud.a.a.e("PushPlatformManager", "unregisetr advance pakcage " + str + " result " + str3);
            }

            @Override // com.meizu.cloud.pushsdk.networking.c.k
            public void a(ANError aNError) {
                com.meizu.cloud.a.a.e("PushPlatformManager", "unregisetr advance pakcage " + str + " error " + aNError.getErrorBody());
            }
        });
    }

    public void c(String str, String str2, String str3) {
        this.e.c(str, str2, str3, new k() { // from class: com.meizu.cloud.pushsdk.platform.a.b.11
            @Override // com.meizu.cloud.pushsdk.networking.c.k
            public void a(com.meizu.cloud.pushsdk.networking.b.k kVar, String str4) {
                com.meizu.cloud.a.a.e("PushPlatformManager", "checkPush" + str4.toString());
                PushSwitchStatus pushSwitchStatus = new PushSwitchStatus(str4.toString());
                com.meizu.cloud.a.a.e("PushPlatformManager", "pushSwitchStatus " + pushSwitchStatus);
                PlatformMessageSender.sendPushStatus(b.this.d, pushSwitchStatus);
            }

            @Override // com.meizu.cloud.pushsdk.networking.c.k
            public void a(ANError aNError) {
                PushSwitchStatus pushSwitchStatus = new PushSwitchStatus();
                pushSwitchStatus.setCode(String.valueOf(aNError.getErrorCode()));
                pushSwitchStatus.setMessage(aNError.getErrorBody());
                com.meizu.cloud.a.a.e("PushPlatformManager", "pushSwitchStatus " + pushSwitchStatus);
                PlatformMessageSender.sendPushStatus(b.this.d, pushSwitchStatus);
            }
        });
    }

    public void a(String str, String str2, String str3, int i, boolean z) {
        if (i == 0) {
            com.meizu.cloud.pushsdk.util.b.a(this.d, this.d.getPackageName(), z);
        } else if (i == 1) {
            com.meizu.cloud.pushsdk.util.b.b(this.d, this.d.getPackageName(), z);
        }
        this.e.a(str, str2, str3, i, z, new k() { // from class: com.meizu.cloud.pushsdk.platform.a.b.12
            @Override // com.meizu.cloud.pushsdk.networking.c.k
            public void a(com.meizu.cloud.pushsdk.networking.b.k kVar, String str4) {
                com.meizu.cloud.a.a.e("PushPlatformManager", "switchPush" + str4.toString());
                PushSwitchStatus pushSwitchStatus = new PushSwitchStatus(str4.toString());
                com.meizu.cloud.a.a.e("PushPlatformManager", "switchPush" + pushSwitchStatus);
                PlatformMessageSender.sendPushStatus(b.this.d, pushSwitchStatus);
            }

            @Override // com.meizu.cloud.pushsdk.networking.c.k
            public void a(ANError aNError) {
                PushSwitchStatus pushSwitchStatus = new PushSwitchStatus();
                pushSwitchStatus.setCode(String.valueOf(aNError.getErrorCode()));
                pushSwitchStatus.setMessage(aNError.getErrorBody());
                com.meizu.cloud.a.a.e("PushPlatformManager", "pushSwitchStatus " + pushSwitchStatus);
                PlatformMessageSender.sendPushStatus(b.this.d, pushSwitchStatus);
            }
        });
        PlatformMessageSender.switchPushMessageSetting(this.d, i, z, this.d.getPackageName());
    }

    public void a(String str, String str2, String str3, String str4) {
        this.e.a(str, str2, str3, str4, new k() { // from class: com.meizu.cloud.pushsdk.platform.a.b.13
            @Override // com.meizu.cloud.pushsdk.networking.c.k
            public void a(com.meizu.cloud.pushsdk.networking.b.k kVar, String str5) {
                com.meizu.cloud.a.a.e("PushPlatformManager", "subScribeTags" + str5.toString());
                SubTagsStatus subTagsStatus = new SubTagsStatus(str5.toString());
                com.meizu.cloud.a.a.e("PushPlatformManager", "subScribeTags " + subTagsStatus.getTagList());
                PlatformMessageSender.sendSubTags(b.this.d, subTagsStatus);
            }

            @Override // com.meizu.cloud.pushsdk.networking.c.k
            public void a(ANError aNError) {
                SubTagsStatus subTagsStatus = new SubTagsStatus();
                subTagsStatus.setCode(String.valueOf(aNError.getErrorCode()));
                subTagsStatus.setMessage(aNError.getErrorBody());
                com.meizu.cloud.a.a.e("PushPlatformManager", "subScribeTags " + subTagsStatus);
                PlatformMessageSender.sendSubTags(b.this.d, subTagsStatus);
            }
        });
    }

    public void b(String str, String str2, String str3, String str4) {
        this.e.b(str, str2, str3, str4, new k() { // from class: com.meizu.cloud.pushsdk.platform.a.b.2
            @Override // com.meizu.cloud.pushsdk.networking.c.k
            public void a(com.meizu.cloud.pushsdk.networking.b.k kVar, String str5) {
                com.meizu.cloud.a.a.e("PushPlatformManager", "unSubScribeTags " + str5.toString());
                SubTagsStatus subTagsStatus = new SubTagsStatus(str5.toString());
                com.meizu.cloud.a.a.e("PushPlatformManager", "unSubScribeTags " + subTagsStatus);
                PlatformMessageSender.sendSubTags(b.this.d, subTagsStatus);
            }

            @Override // com.meizu.cloud.pushsdk.networking.c.k
            public void a(ANError aNError) {
                SubTagsStatus subTagsStatus = new SubTagsStatus();
                subTagsStatus.setCode(String.valueOf(aNError.getErrorCode()));
                subTagsStatus.setMessage(aNError.getErrorBody());
                com.meizu.cloud.a.a.e("PushPlatformManager", "subScribeTags " + subTagsStatus);
                PlatformMessageSender.sendSubTags(b.this.d, subTagsStatus);
            }
        });
    }

    public void d(String str, String str2, String str3) {
        this.e.d(str, str2, str3, new k() { // from class: com.meizu.cloud.pushsdk.platform.a.b.3
            @Override // com.meizu.cloud.pushsdk.networking.c.k
            public void a(com.meizu.cloud.pushsdk.networking.b.k kVar, String str4) {
                com.meizu.cloud.a.a.e("PushPlatformManager", "checkSubScribeTags " + str4.toString());
                SubTagsStatus subTagsStatus = new SubTagsStatus(str4.toString());
                com.meizu.cloud.a.a.e("PushPlatformManager", "checkSubScribeTags " + subTagsStatus);
                PlatformMessageSender.sendSubTags(b.this.d, subTagsStatus);
            }

            @Override // com.meizu.cloud.pushsdk.networking.c.k
            public void a(ANError aNError) {
                SubTagsStatus subTagsStatus = new SubTagsStatus();
                subTagsStatus.setCode(String.valueOf(aNError.getErrorCode()));
                subTagsStatus.setMessage(aNError.getErrorDetail() + aNError.getErrorBody());
                com.meizu.cloud.a.a.e("PushPlatformManager", "subScribeTags " + subTagsStatus);
                PlatformMessageSender.sendSubTags(b.this.d, subTagsStatus);
            }
        });
    }

    public void c(String str, String str2, String str3, String str4) {
        this.e.c(str, str2, str3, str4, new k() { // from class: com.meizu.cloud.pushsdk.platform.a.b.4
            @Override // com.meizu.cloud.pushsdk.networking.c.k
            public void a(com.meizu.cloud.pushsdk.networking.b.k kVar, String str5) {
                com.meizu.cloud.a.a.e("PushPlatformManager", "subScribeAlias " + str5.toString());
                SubAliasStatus subAliasStatus = new SubAliasStatus(str5.toString());
                com.meizu.cloud.a.a.e("PushPlatformManager", "subScribeAlias " + subAliasStatus);
                PlatformMessageSender.sendSubAlias(b.this.d, subAliasStatus);
            }

            @Override // com.meizu.cloud.pushsdk.networking.c.k
            public void a(ANError aNError) {
                SubAliasStatus subAliasStatus = new SubAliasStatus();
                subAliasStatus.setCode(String.valueOf(aNError.getErrorCode()));
                subAliasStatus.setMessage(aNError.getErrorDetail() + " " + aNError.getErrorBody());
                com.meizu.cloud.a.a.e("PushPlatformManager", "subScribeAlias " + subAliasStatus);
                PlatformMessageSender.sendSubAlias(b.this.d, subAliasStatus);
            }
        });
    }

    public void d(String str, String str2, String str3, String str4) {
        this.e.d(str, str2, str3, str4, new k() { // from class: com.meizu.cloud.pushsdk.platform.a.b.5
            @Override // com.meizu.cloud.pushsdk.networking.c.k
            public void a(com.meizu.cloud.pushsdk.networking.b.k kVar, String str5) {
                com.meizu.cloud.a.a.e("PushPlatformManager", "unSubScribeAlias " + str5.toString());
                SubAliasStatus subAliasStatus = new SubAliasStatus(str5.toString());
                com.meizu.cloud.a.a.e("PushPlatformManager", "unSubScribeAlias " + subAliasStatus);
                PlatformMessageSender.sendSubAlias(b.this.d, subAliasStatus);
            }

            @Override // com.meizu.cloud.pushsdk.networking.c.k
            public void a(ANError aNError) {
                SubAliasStatus subAliasStatus = new SubAliasStatus();
                subAliasStatus.setCode(String.valueOf(aNError.getErrorCode()));
                subAliasStatus.setMessage(aNError.getErrorBody());
                com.meizu.cloud.a.a.e("PushPlatformManager", "subScribeAlias " + subAliasStatus);
                PlatformMessageSender.sendSubAlias(b.this.d, subAliasStatus);
            }
        });
    }

    public void e(String str, String str2, String str3) {
        this.e.e(str, str2, str3, new k() { // from class: com.meizu.cloud.pushsdk.platform.a.b.6
            @Override // com.meizu.cloud.pushsdk.networking.c.k
            public void a(com.meizu.cloud.pushsdk.networking.b.k kVar, String str4) {
                com.meizu.cloud.a.a.e("PushPlatformManager", "checkSubScribeAlias " + str4.toString());
                SubAliasStatus subAliasStatus = new SubAliasStatus(str4.toString());
                com.meizu.cloud.a.a.e("PushPlatformManager", "checkSubScribeAlias " + subAliasStatus);
                PlatformMessageSender.sendSubAlias(b.this.d, subAliasStatus);
            }

            @Override // com.meizu.cloud.pushsdk.networking.c.k
            public void a(ANError aNError) {
                SubAliasStatus subAliasStatus = new SubAliasStatus();
                subAliasStatus.setCode(String.valueOf(aNError.getErrorCode()));
                subAliasStatus.setMessage(aNError.getErrorBody());
                com.meizu.cloud.a.a.e("PushPlatformManager", "subScribeAlias " + subAliasStatus);
                PlatformMessageSender.sendSubAlias(b.this.d, subAliasStatus);
            }
        });
    }

    private void a(final int i, final String str, final String str2, long j) {
        this.b.schedule(new Runnable() { // from class: com.meizu.cloud.pushsdk.platform.a.b.7
            @Override // java.lang.Runnable
            public void run() {
                String deviceId = MzSystemUtils.getDeviceId(b.this.d);
                Message obtainMessage = b.this.c.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putString("deviceId", deviceId);
                bundle.putString("appId", str);
                bundle.putString(WBConstants.SSO_APP_KEY, str2);
                obtainMessage.setData(bundle);
                obtainMessage.what = i;
                com.meizu.cloud.a.a.e("PushPlatformManager", "deviceId " + deviceId);
                b.this.c.sendMessage(obtainMessage);
                if (!TextUtils.isEmpty(deviceId)) {
                    com.meizu.cloud.a.a.i("PushPlatformManager", "put deviceId " + deviceId + " to preference");
                    com.meizu.cloud.pushsdk.util.b.b(b.this.d, deviceId);
                }
            }
        }, j, TimeUnit.SECONDS);
    }
}
