package com.xiaomi.miui.pushads.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.push.ce;
import com.xiaomi.push.cf;
import java.util.List;
/* loaded from: classes6.dex */
public class k extends MiPushClient.MiPushClientCallback implements c {
    private static k a;

    /* renamed from: a  reason: collision with other field name */
    private int f93a;

    /* renamed from: a  reason: collision with other field name */
    private Context f94a;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f95a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f96a;

    /* renamed from: a  reason: collision with other field name */
    private g f97a;

    /* renamed from: a  reason: collision with other field name */
    private cf f98a;

    /* renamed from: a  reason: collision with other field name */
    private String f99a;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    private String f100b;

    /* loaded from: classes6.dex */
    public enum a {
        NONE,
        Wifi,
        MN2G,
        MN3G,
        MN4G
    }

    public static synchronized k a() {
        k kVar;
        synchronized (k.class) {
            kVar = a;
        }
        return kVar;
    }

    public static void a(String str) {
        Log.d("ads-notify-fd5dfce4", str);
    }

    private void a(String str, int i, String str2) {
        new j(this.f94a, this.f95a, str, i, str2, this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
    }

    private void a(String str, long j, int i) {
        this.b++;
        d.a("存入cache 的数量: " + this.b);
        this.f97a.a(str, j, i);
        this.f97a.a();
    }

    private void a(String str, String str2) {
        a(str, 0, str2);
    }

    private boolean a(ce ceVar) {
        int i;
        int i2;
        if (ceVar.c <= 0) {
            a("白名单用户");
            return true;
        }
        switch (ceVar.a) {
            case 1:
                i = ceVar.c * 4;
                a("冒泡上限: " + i);
                i2 = this.f95a.getInt("bubblecount", 0);
                break;
            case 2:
                i = ceVar.c;
                a("通知上限: " + i);
                i2 = this.f95a.getInt("notifycount", 0);
                break;
            default:
                i = 0;
                i2 = 0;
                break;
        }
        if (i2 > i) {
            a("广告次数超过上限---已经获得次数： " + i2 + " 上限: " + i);
            return false;
        }
        return true;
    }

    public synchronized int a(int i) {
        int i2 = 0;
        synchronized (this) {
            if (i == 2) {
                i2 = this.f95a.getInt("notifycount", 0);
            } else if (i == 1) {
                i2 = this.f95a.getInt("bubblecount", 0);
            }
        }
        return i2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m113a(int i) {
        if (i == 2) {
            this.f95a.edit().putInt("notifycount", this.f95a.getInt("notifycount", 0) + 1).commit();
        } else if (i == 1) {
            this.f95a.edit().putInt("bubblecount", this.f95a.getInt("bubblecount", 0) + 1).commit();
        }
    }

    @Override // com.xiaomi.miui.pushads.sdk.c
    public void a(int i, ce ceVar, j jVar) {
        if (ceVar == null) {
            a("返回广告为null");
            return;
        }
        if (i == -1) {
            a("广告下载失败: " + ceVar.f180a);
            ceVar.d++;
            if (ceVar.d < 10) {
                d.a("下载失败写入缓存 " + ceVar.h + "  " + ceVar.f182b + "  " + ceVar.d);
                a(ceVar.h, ceVar.f182b, ceVar.d);
            } else {
                d.a("下载失败次数超过 10 不写入缓存");
            }
        } else if (i == 0) {
            if (ceVar.c > 0) {
                this.f93a++;
                a().m113a(ceVar.a);
            }
            a("广告下载成功: id: " + ceVar.f180a + " 类型: " + ceVar.a + " 成功次数: " + a().a(ceVar.a));
        } else {
            Log.w("com.miui.ads", "广告无效或者超过限制 " + i);
            d.a("广告无效或者超过限制");
        }
        if (this.f98a == null || i != 0) {
            return;
        }
        if (!a(ceVar)) {
            a("广告数量超过限制，不返回给APP");
            return;
        }
        a("===========给APP 发送广告信息");
        this.f98a.a(ceVar);
    }

    @Override // com.xiaomi.mipush.sdk.MiPushClient.MiPushClientCallback
    public void onCommandResult(String str, long j, String str2, List<String> list) {
        boolean z;
        int i = 0;
        if (j != 0) {
            a("命令失败: " + str + " code: " + j + " reason: " + str2);
            for (int i2 = 0; i2 < list.size(); i2++) {
                a("param: " + list.get(i2));
            }
        }
        if (TextUtils.equals(MiPushClient.COMMAND_SET_ALIAS, str)) {
            boolean z2 = false;
            while (i < list.size()) {
                if (TextUtils.equals(this.f99a, list.get(i))) {
                    z = true;
                    a("设置别名成功: ");
                } else {
                    z = z2;
                }
                i++;
                z2 = z;
            }
            if (z2) {
                return;
            }
            a("设置别名失败，重新设置: ");
            this.f96a.sendEmptyMessage(2);
        }
    }

    @Override // com.xiaomi.mipush.sdk.MiPushClient.MiPushClientCallback
    public void onInitializeResult(long j, String str, String str2) {
        if (this.f98a != null) {
            Message obtainMessage = this.f96a.obtainMessage();
            obtainMessage.what = 4;
            obtainMessage.arg1 = (int) j;
            obtainMessage.obj = str2;
            this.f96a.sendMessage(obtainMessage);
        }
        if (0 != j) {
            a("通道初始化失败， 已经通知了app，需要重新 open 通道");
            return;
        }
        a("通道进行初始化OK");
        this.f96a.sendEmptyMessage(3);
        this.f96a.sendEmptyMessage(5);
    }

    @Override // com.xiaomi.mipush.sdk.MiPushClient.MiPushClientCallback
    public void onReceiveMessage(String str, String str2, String str3, boolean z) {
        a("接受到消息 " + str + "##" + str3 + "##");
        if (f.a(this.f99a)) {
            a("没有有效alias，忽略消息 " + str + "##" + str3 + "##");
        } else if (f.a(str2) || f.a(this.f99a) || TextUtils.equals(this.f99a, str2)) {
            a(str, this.f100b);
        } else {
            a("接受到不同alias 的消息，注销旧的 " + str + "##" + str3 + "##");
            MiPushClient.unsetAlias(this.f94a, str2, getCategory());
        }
    }

    @Override // com.xiaomi.mipush.sdk.MiPushClient.MiPushClientCallback
    public void onSubscribeResult(long j, String str, String str2) {
    }

    @Override // com.xiaomi.mipush.sdk.MiPushClient.MiPushClientCallback
    public void onUnsubscribeResult(long j, String str, String str2) {
    }
}
