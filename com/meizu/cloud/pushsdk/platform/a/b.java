package com.meizu.cloud.pushsdk.platform.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.a.e.k;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import com.meizu.cloud.pushsdk.util.c;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class b {
    private static b a;
    private ExecutorService b = Executors.newSingleThreadExecutor();
    private Handler c;
    private Context d;
    private a e;

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

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (a == null) {
                a = new b(context);
            }
            bVar = a;
        }
        return bVar;
    }

    public void a(String str, String str2) {
        String a2 = c.a(this.d);
        int b = c.b(this.d);
        if (!TextUtils.isEmpty(a2) && System.currentTimeMillis() / 1000 < b) {
            RegisterStatus registerStatus = new RegisterStatus();
            registerStatus.setCode(BasicPushStatus.SUCCESS_CODE);
            registerStatus.setMessage("already register PushId,dont register frequently");
            registerStatus.setPushId(a2);
            registerStatus.setExpireTime((int) (b - (System.currentTimeMillis() / 1000)));
            PlatformMessageSender.a(this.d, registerStatus);
            return;
        }
        a(0, str, str2);
    }

    public void a(String str, String str2, String str3) {
        this.e.a(str, str2, str3, new k() { // from class: com.meizu.cloud.pushsdk.platform.a.b.8
            @Override // com.meizu.cloud.pushsdk.a.e.k
            public void a(com.meizu.cloud.pushsdk.a.d.k kVar, String str4) {
                com.meizu.cloud.a.a.e("PushPlatformManager", str4.toString());
                RegisterStatus registerStatus = new RegisterStatus(str4.toString());
                com.meizu.cloud.a.a.e("PushPlatformManager", "registerStatus " + registerStatus);
                PlatformMessageSender.a(b.this.d, registerStatus);
            }

            @Override // com.meizu.cloud.pushsdk.a.e.k
            public void a(com.meizu.cloud.pushsdk.a.c.a aVar) {
                if (aVar.a() != null) {
                    com.meizu.cloud.a.a.e("PushPlatformManager", "status code=" + aVar.c() + " data=" + aVar.a());
                }
                RegisterStatus registerStatus = new RegisterStatus();
                registerStatus.setCode(String.valueOf(aVar.c()));
                registerStatus.setMessage(aVar.e());
                com.meizu.cloud.a.a.e("PushPlatformManager", "registerStatus " + registerStatus);
                PlatformMessageSender.a(b.this.d, registerStatus);
            }
        });
    }

    public void b(String str, String str2) {
        if (TextUtils.isEmpty(c.a(this.d))) {
            UnRegisterStatus unRegisterStatus = new UnRegisterStatus();
            unRegisterStatus.setCode(BasicPushStatus.SUCCESS_CODE);
            unRegisterStatus.setMessage("already unRegister PushId,dont unRegister frequently");
            unRegisterStatus.setIsUnRegisterSuccess(true);
            PlatformMessageSender.a(this.d, unRegisterStatus);
            return;
        }
        a(1, str, str2);
    }

    public void b(String str, String str2, String str3) {
        this.e.b(str, str2, str3, new k() { // from class: com.meizu.cloud.pushsdk.platform.a.b.9
            @Override // com.meizu.cloud.pushsdk.a.e.k
            public void a(com.meizu.cloud.pushsdk.a.d.k kVar, String str4) {
                com.meizu.cloud.a.a.e("PushPlatformManager", "unRegister" + str4.toString());
                UnRegisterStatus unRegisterStatus = new UnRegisterStatus(str4.toString());
                com.meizu.cloud.a.a.e("PushPlatformManager", "unRegisterStatus " + unRegisterStatus);
                PlatformMessageSender.a(b.this.d, unRegisterStatus);
            }

            @Override // com.meizu.cloud.pushsdk.a.e.k
            public void a(com.meizu.cloud.pushsdk.a.c.a aVar) {
                UnRegisterStatus unRegisterStatus = new UnRegisterStatus();
                unRegisterStatus.setCode(String.valueOf(aVar.c()));
                unRegisterStatus.setIsUnRegisterSuccess(false);
                unRegisterStatus.setMessage(aVar.e());
                com.meizu.cloud.a.a.e("PushPlatformManager", "unRegisterStatus " + unRegisterStatus);
                PlatformMessageSender.a(b.this.d, unRegisterStatus);
            }
        });
    }

    public void a(final String str) {
        this.b.execute(new Runnable() { // from class: com.meizu.cloud.pushsdk.platform.a.b.10
            @Override // java.lang.Runnable
            public void run() {
                String b = MzSystemUtils.b(b.this.d);
                Message obtainMessage = b.this.c.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putString("deviceId", b);
                bundle.putString("packageName", str);
                obtainMessage.setData(bundle);
                obtainMessage.what = 2;
                com.meizu.cloud.a.a.e("PushPlatformManager", "deviceId " + b + "packageName " + str);
                b.this.c.sendMessage(obtainMessage);
            }
        });
    }

    public void c(final String str, String str2) {
        this.e.a(str, str2, new k() { // from class: com.meizu.cloud.pushsdk.platform.a.b.11
            @Override // com.meizu.cloud.pushsdk.a.e.k
            public void a(com.meizu.cloud.pushsdk.a.d.k kVar, String str3) {
                com.meizu.cloud.a.a.e("PushPlatformManager", "unregisetr advance pakcage " + str + " result " + str3);
            }

            @Override // com.meizu.cloud.pushsdk.a.e.k
            public void a(com.meizu.cloud.pushsdk.a.c.a aVar) {
                com.meizu.cloud.a.a.e("PushPlatformManager", "unregisetr advance pakcage " + str + " error " + aVar.e());
            }
        });
    }

    public void c(String str, String str2, String str3) {
        this.e.c(str, str2, str3, new k() { // from class: com.meizu.cloud.pushsdk.platform.a.b.12
            @Override // com.meizu.cloud.pushsdk.a.e.k
            public void a(com.meizu.cloud.pushsdk.a.d.k kVar, String str4) {
                com.meizu.cloud.a.a.e("PushPlatformManager", "checkPush" + str4.toString());
                PushSwitchStatus pushSwitchStatus = new PushSwitchStatus(str4.toString());
                com.meizu.cloud.a.a.e("PushPlatformManager", "pushSwitchStatus " + pushSwitchStatus);
                PlatformMessageSender.a(b.this.d, pushSwitchStatus);
            }

            @Override // com.meizu.cloud.pushsdk.a.e.k
            public void a(com.meizu.cloud.pushsdk.a.c.a aVar) {
                PushSwitchStatus pushSwitchStatus = new PushSwitchStatus();
                pushSwitchStatus.setCode(String.valueOf(aVar.c()));
                pushSwitchStatus.setMessage(aVar.e());
                com.meizu.cloud.a.a.e("PushPlatformManager", "pushSwitchStatus " + pushSwitchStatus);
                PlatformMessageSender.a(b.this.d, pushSwitchStatus);
            }
        });
    }

    public void a(String str, String str2, String str3, int i, boolean z) {
        if (i == 0) {
            c.a(this.d, this.d.getPackageName(), z);
        } else if (i == 1) {
            c.b(this.d, this.d.getPackageName(), z);
        }
        this.e.a(str, str2, TextUtils.isEmpty(str3) ? "0" : str3, i, z, new k() { // from class: com.meizu.cloud.pushsdk.platform.a.b.13
            @Override // com.meizu.cloud.pushsdk.a.e.k
            public void a(com.meizu.cloud.pushsdk.a.d.k kVar, String str4) {
                com.meizu.cloud.a.a.e("PushPlatformManager", "switchPush" + str4.toString());
                PushSwitchStatus pushSwitchStatus = new PushSwitchStatus(str4.toString());
                com.meizu.cloud.a.a.e("PushPlatformManager", "switchPush" + pushSwitchStatus);
                PlatformMessageSender.a(b.this.d, pushSwitchStatus);
            }

            @Override // com.meizu.cloud.pushsdk.a.e.k
            public void a(com.meizu.cloud.pushsdk.a.c.a aVar) {
                PushSwitchStatus pushSwitchStatus = new PushSwitchStatus();
                pushSwitchStatus.setCode(String.valueOf(aVar.c()));
                pushSwitchStatus.setMessage(aVar.e());
                com.meizu.cloud.a.a.e("PushPlatformManager", "pushSwitchStatus " + pushSwitchStatus);
                PlatformMessageSender.a(b.this.d, pushSwitchStatus);
            }
        });
        PlatformMessageSender.a(this.d, i, z, this.d.getPackageName());
    }

    public void a(String str, String str2, String str3, String str4) {
        this.e.a(str, str2, str3, str4, new k() { // from class: com.meizu.cloud.pushsdk.platform.a.b.14
            @Override // com.meizu.cloud.pushsdk.a.e.k
            public void a(com.meizu.cloud.pushsdk.a.d.k kVar, String str5) {
                com.meizu.cloud.a.a.e("PushPlatformManager", "subScribeTags" + str5.toString());
                SubTagsStatus subTagsStatus = new SubTagsStatus(str5.toString());
                com.meizu.cloud.a.a.e("PushPlatformManager", "subScribeTags " + subTagsStatus.getTagList());
                PlatformMessageSender.a(b.this.d, subTagsStatus);
            }

            @Override // com.meizu.cloud.pushsdk.a.e.k
            public void a(com.meizu.cloud.pushsdk.a.c.a aVar) {
                SubTagsStatus subTagsStatus = new SubTagsStatus();
                subTagsStatus.setCode(String.valueOf(aVar.c()));
                subTagsStatus.setMessage(aVar.e());
                com.meizu.cloud.a.a.e("PushPlatformManager", "subScribeTags " + subTagsStatus);
                PlatformMessageSender.a(b.this.d, subTagsStatus);
            }
        });
    }

    public void b(String str, String str2, String str3, String str4) {
        this.e.b(str, str2, str3, str4, new k() { // from class: com.meizu.cloud.pushsdk.platform.a.b.2
            @Override // com.meizu.cloud.pushsdk.a.e.k
            public void a(com.meizu.cloud.pushsdk.a.d.k kVar, String str5) {
                com.meizu.cloud.a.a.e("PushPlatformManager", "unSubScribeTags " + str5.toString());
                SubTagsStatus subTagsStatus = new SubTagsStatus(str5.toString());
                com.meizu.cloud.a.a.e("PushPlatformManager", "unSubScribeTags " + subTagsStatus);
                PlatformMessageSender.a(b.this.d, subTagsStatus);
            }

            @Override // com.meizu.cloud.pushsdk.a.e.k
            public void a(com.meizu.cloud.pushsdk.a.c.a aVar) {
                SubTagsStatus subTagsStatus = new SubTagsStatus();
                subTagsStatus.setCode(String.valueOf(aVar.c()));
                subTagsStatus.setMessage(aVar.e());
                com.meizu.cloud.a.a.e("PushPlatformManager", "subScribeTags " + subTagsStatus);
                PlatformMessageSender.a(b.this.d, subTagsStatus);
            }
        });
    }

    public void d(String str, String str2, String str3) {
        this.e.d(str, str2, str3, new k() { // from class: com.meizu.cloud.pushsdk.platform.a.b.3
            @Override // com.meizu.cloud.pushsdk.a.e.k
            public void a(com.meizu.cloud.pushsdk.a.d.k kVar, String str4) {
                com.meizu.cloud.a.a.e("PushPlatformManager", "checkSubScribeTags " + str4.toString());
                SubTagsStatus subTagsStatus = new SubTagsStatus(str4.toString());
                com.meizu.cloud.a.a.e("PushPlatformManager", "checkSubScribeTags " + subTagsStatus);
                PlatformMessageSender.a(b.this.d, subTagsStatus);
            }

            @Override // com.meizu.cloud.pushsdk.a.e.k
            public void a(com.meizu.cloud.pushsdk.a.c.a aVar) {
                SubTagsStatus subTagsStatus = new SubTagsStatus();
                subTagsStatus.setCode(String.valueOf(aVar.c()));
                subTagsStatus.setMessage(aVar.b() + aVar.e());
                com.meizu.cloud.a.a.e("PushPlatformManager", "subScribeTags " + subTagsStatus);
                PlatformMessageSender.a(b.this.d, subTagsStatus);
            }
        });
    }

    public void c(String str, String str2, String str3, String str4) {
        this.e.c(str, str2, str3, str4, new k() { // from class: com.meizu.cloud.pushsdk.platform.a.b.4
            @Override // com.meizu.cloud.pushsdk.a.e.k
            public void a(com.meizu.cloud.pushsdk.a.d.k kVar, String str5) {
                com.meizu.cloud.a.a.e("PushPlatformManager", "subScribeAlias " + str5.toString());
                SubAliasStatus subAliasStatus = new SubAliasStatus(str5.toString());
                com.meizu.cloud.a.a.e("PushPlatformManager", "subScribeAlias " + subAliasStatus);
                PlatformMessageSender.a(b.this.d, subAliasStatus);
            }

            @Override // com.meizu.cloud.pushsdk.a.e.k
            public void a(com.meizu.cloud.pushsdk.a.c.a aVar) {
                SubAliasStatus subAliasStatus = new SubAliasStatus();
                subAliasStatus.setCode(String.valueOf(aVar.c()));
                subAliasStatus.setMessage(aVar.b() + " " + aVar.e());
                com.meizu.cloud.a.a.e("PushPlatformManager", "subScribeAlias " + subAliasStatus);
                PlatformMessageSender.a(b.this.d, subAliasStatus);
            }
        });
    }

    public void d(String str, String str2, String str3, String str4) {
        this.e.d(str, str2, str3, str4, new k() { // from class: com.meizu.cloud.pushsdk.platform.a.b.5
            @Override // com.meizu.cloud.pushsdk.a.e.k
            public void a(com.meizu.cloud.pushsdk.a.d.k kVar, String str5) {
                com.meizu.cloud.a.a.e("PushPlatformManager", "unSubScribeAlias " + str5.toString());
                SubAliasStatus subAliasStatus = new SubAliasStatus(str5.toString());
                com.meizu.cloud.a.a.e("PushPlatformManager", "unSubScribeAlias " + subAliasStatus);
                PlatformMessageSender.a(b.this.d, subAliasStatus);
            }

            @Override // com.meizu.cloud.pushsdk.a.e.k
            public void a(com.meizu.cloud.pushsdk.a.c.a aVar) {
                SubAliasStatus subAliasStatus = new SubAliasStatus();
                subAliasStatus.setCode(String.valueOf(aVar.c()));
                subAliasStatus.setMessage(aVar.e());
                com.meizu.cloud.a.a.e("PushPlatformManager", "subScribeAlias " + subAliasStatus);
                PlatformMessageSender.a(b.this.d, subAliasStatus);
            }
        });
    }

    public void e(String str, String str2, String str3) {
        this.e.e(str, str2, str3, new k() { // from class: com.meizu.cloud.pushsdk.platform.a.b.6
            @Override // com.meizu.cloud.pushsdk.a.e.k
            public void a(com.meizu.cloud.pushsdk.a.d.k kVar, String str4) {
                com.meizu.cloud.a.a.e("PushPlatformManager", "checkSubScribeAlias " + str4.toString());
                SubAliasStatus subAliasStatus = new SubAliasStatus(str4.toString());
                com.meizu.cloud.a.a.e("PushPlatformManager", "checkSubScribeAlias " + subAliasStatus);
                PlatformMessageSender.a(b.this.d, subAliasStatus);
            }

            @Override // com.meizu.cloud.pushsdk.a.e.k
            public void a(com.meizu.cloud.pushsdk.a.c.a aVar) {
                SubAliasStatus subAliasStatus = new SubAliasStatus();
                subAliasStatus.setCode(String.valueOf(aVar.c()));
                subAliasStatus.setMessage(aVar.e());
                com.meizu.cloud.a.a.e("PushPlatformManager", "subScribeAlias " + subAliasStatus);
                PlatformMessageSender.a(b.this.d, subAliasStatus);
            }
        });
    }

    private void a(final int i, final String str, final String str2) {
        this.b.execute(new Runnable() { // from class: com.meizu.cloud.pushsdk.platform.a.b.7
            @Override // java.lang.Runnable
            public void run() {
                String b = MzSystemUtils.b(b.this.d);
                Message obtainMessage = b.this.c.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putString("deviceId", b);
                bundle.putString("appId", str);
                bundle.putString(WBConstants.SSO_APP_KEY, str2);
                obtainMessage.setData(bundle);
                obtainMessage.what = i;
                com.meizu.cloud.a.a.e("PushPlatformManager", "deviceId " + b);
                b.this.c.sendMessage(obtainMessage);
                if (!TextUtils.isEmpty(b)) {
                    com.meizu.cloud.a.a.i("PushPlatformManager", "put deviceId " + b + " to preference");
                    c.b(b.this.d, b);
                }
            }
        });
    }
}
