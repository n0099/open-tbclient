package com.xiaomi.miui.pushads.sdk;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.push.cd;
import com.xiaomi.push.ce;
import com.xiaomi.push.cg;
import com.xiaomi.push.cj;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class l extends MiPushClient.MiPushClientCallback implements c {
    private static l a;

    /* renamed from: a  reason: collision with other field name */
    static final /* synthetic */ boolean f104a;

    /* renamed from: a  reason: collision with other field name */
    private int f105a;

    /* renamed from: a  reason: collision with other field name */
    private Context f106a;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f107a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f108a;

    /* renamed from: a  reason: collision with other field name */
    private e f109a;

    /* renamed from: a  reason: collision with other field name */
    private g f110a;

    /* renamed from: a  reason: collision with other field name */
    private cd f111a;

    /* renamed from: a  reason: collision with other field name */
    private cj f112a;

    /* renamed from: a  reason: collision with other field name */
    private String f113a;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    private String f114b;
    private String c;

    static {
        f104a = !l.class.desiredAssertionStatus();
    }

    private PendingIntent a(h hVar, int i) {
        Intent intent = new Intent(this.f106a, MiPushRelayTraceService.class);
        Bundle bundle = new Bundle();
        bundle.putAll(hVar.a());
        bundle.putInt("intenttype", i);
        if (i == 2 && this.f109a != null) {
            PendingIntent a2 = this.f109a.a(new h(hVar));
            if (a2 != null) {
                bundle.putParcelable("pendingintent", a2);
            }
        }
        intent.putExtras(bundle);
        int i2 = (int) hVar.f182a;
        return PendingIntent.getService(this.f106a, (i2 * i2) + i, intent, 134217728);
    }

    public static synchronized l a() {
        l lVar;
        synchronized (l.class) {
            lVar = a;
        }
        return lVar;
    }

    private void a(h hVar) {
        Bitmap decodeFile;
        a("sdk handle notify");
        int hashCode = hVar.d.hashCode() + hVar.a.hashCode();
        int a2 = this.f109a.a();
        Notification.Builder builder = new Notification.Builder(this.f106a);
        if (a2 != 0) {
            builder.setSmallIcon(a2);
        }
        NotificationBaseRemoteView notificationBaseRemoteView = new NotificationBaseRemoteView(this.f106a);
        notificationBaseRemoteView.a(hVar.d, hVar.e);
        notificationBaseRemoteView.a(a2);
        a(hVar, hashCode, notificationBaseRemoteView);
        builder.setContent(notificationBaseRemoteView);
        builder.setTicker(hVar.c).setAutoCancel(true);
        builder.setContentIntent(a(hVar, 2));
        builder.setDeleteIntent(a(hVar, 1));
        Notification build = builder.build();
        if (!TextUtils.isEmpty(hVar.a()) && (decodeFile = BitmapFactory.decodeFile(hVar.a())) != null) {
            a("big picture");
            NotificationBigRemoteView notificationBigRemoteView = new NotificationBigRemoteView(this.f106a);
            notificationBigRemoteView.a(hVar.d, hVar.e);
            notificationBigRemoteView.a(a2);
            notificationBigRemoteView.a(decodeFile);
            a(hVar, hashCode, notificationBigRemoteView);
            build.bigContentView = notificationBigRemoteView;
        }
        ((NotificationManager) this.f106a.getSystemService("notification")).notify(hashCode, build);
    }

    private void a(h hVar, int i, NotificationBaseRemoteView notificationBaseRemoteView) {
        PendingIntent pendingIntent = null;
        h hVar2 = new h(hVar);
        if (hVar.g != null && !TextUtils.isEmpty(hVar.g.trim()) && this.f109a != null) {
            pendingIntent = this.f109a.b(hVar2);
        }
        if (pendingIntent == null) {
            return;
        }
        Intent intent = new Intent(this.f106a, MiPushRelayTraceService.class);
        Bundle bundle = new Bundle();
        bundle.putAll(hVar.a());
        bundle.putInt("intenttype", 2);
        bundle.putInt("notifyid", i);
        bundle.putParcelable("pendingintent", pendingIntent);
        intent.putExtras(bundle);
        int i2 = (int) hVar.f182a;
        notificationBaseRemoteView.a(hVar.g, PendingIntent.getService(this.f106a, (i2 * i2) + 3, intent, 134217728));
    }

    private void a(ce ceVar) {
        if (this.f112a != null) {
            a(this.f114b + "--->receivedT " + ceVar.f182a);
            this.f112a.c(new cg(ceVar));
        }
    }

    public static void a(String str) {
        Log.d("ads-notify-fd5dfce4", str);
    }

    private void a(String str, int i, String str2) {
        new j(this.f106a, this.f107a, str, i, str2, this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
    }

    private void a(String str, long j, int i) {
        this.b++;
        d.a("存入cache 的数量: " + this.b);
        if (this.f110a != null) {
            this.f110a.a(str, j, i);
            this.f110a.a();
        }
    }

    private void a(String str, String str2) {
        a(str, 0, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m105a(ce ceVar) {
        int i;
        int i2;
        if (ceVar.c <= 0) {
            a("white user");
            return true;
        }
        switch (ceVar.a) {
            case 1:
                i = ceVar.c * 4;
                a("bubble uplimit: " + i);
                i2 = this.f107a.getInt("bubblecount", 0);
                break;
            case 2:
                i = ceVar.c;
                a("notify uplimit: " + i);
                i2 = this.f107a.getInt("notifycount", 0);
                break;
            default:
                i = 0;
                i2 = 0;
                break;
        }
        if (i2 > i) {
            a("reach up limit---already count： " + i2 + " 上限: " + i);
            return false;
        }
        return true;
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m106a(String str) {
        boolean z = true;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("showType") != 1000) {
                z = false;
            } else if (this.f111a != null) {
                this.f111a.a(jSONObject.optString("content"));
            } else {
                Log.e("ads-notify-fd5dfce4", "接受到外部的消息，但是外部的listener");
            }
        } catch (JSONException e) {
        }
        return z;
    }

    private void b(ce ceVar) {
        a(ceVar);
        if (ceVar.a == 1) {
            a aVar = (a) ceVar;
            if (this.f109a != null) {
                this.f109a.a(aVar);
            }
        } else if (ceVar.a == 2) {
            h hVar = (h) ceVar;
            try {
                a(this.f114b + "--->get notify");
                if (this.f109a != null) {
                    if (this.f109a.m101a(new h(hVar))) {
                        return;
                    }
                    a(hVar);
                }
            } catch (Exception e) {
                Log.e("ads-notify-fd5dfce4", "SDK 发出notification 失败");
            }
        }
    }

    public synchronized int a(int i) {
        int i2 = 0;
        synchronized (this) {
            if (i == 2) {
                i2 = this.f107a.getInt("notifycount", 0);
            } else if (i == 1) {
                i2 = this.f107a.getInt("bubblecount", 0);
            }
        }
        return i2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m107a(int i) {
        if (i == 2) {
            this.f107a.edit().putInt("notifycount", this.f107a.getInt("notifycount", 0) + 1).commit();
        } else if (i == 1) {
            this.f107a.edit().putInt("bubblecount", this.f107a.getInt("bubblecount", 0) + 1).commit();
        }
    }

    @Override // com.xiaomi.miui.pushads.sdk.c
    public void a(int i, ce ceVar, j jVar) {
        if (ceVar == null) {
            a(this.f114b + "--->cell is null");
            return;
        }
        if (i == -1) {
            a(this.f114b + "--->download failed: " + ceVar.f182a);
            ceVar.d++;
            if (ceVar.d < 10) {
                d.a("下载失败写入缓存 " + ceVar.h + "  " + ceVar.f184b + "  " + ceVar.d);
                a(ceVar.h, ceVar.f184b, ceVar.d);
            } else {
                d.a("下载失败次数超过 10 不写入缓存");
            }
        } else if (i == 0) {
            if (ceVar.c > 0) {
                this.f105a++;
                a().m107a(ceVar.a);
            }
            a(this.f114b + "--->download sucess: id: " + ceVar.f182a + " type: " + ceVar.a + " count: " + a().a(ceVar.a));
        } else {
            Log.w("com.miui.ads", "广告无效或者超过限制 " + i);
            d.a("广告无效或者超过限制");
        }
        if (this.f109a == null || i != 0) {
            return;
        }
        if (m105a(ceVar)) {
            b(ceVar);
        } else {
            a(this.f114b + "--->reach limit, no return to app");
        }
    }

    @Override // com.xiaomi.mipush.sdk.MiPushClient.MiPushClientCallback
    public void onCommandResult(String str, long j, String str2, List<String> list) {
        boolean z;
        int i = 0;
        a(this.f114b + "--->onCommandResult == " + str + " resultCode: " + j + " reason: " + str2);
        for (int i2 = 0; i2 < list.size(); i2++) {
            a("param: " + list.get(i2));
        }
        if (TextUtils.equals(MiPushClient.COMMAND_SET_ALIAS, str)) {
            boolean z2 = false;
            while (i < list.size()) {
                if (TextUtils.equals(this.f113a, list.get(i))) {
                    z = true;
                    a(this.f114b + "--->alias ok: ");
                } else {
                    z = z2;
                }
                i++;
                z2 = z;
            }
            if (z2) {
                return;
            }
            a(this.f114b + "--->alias failed, retry: ");
        }
    }

    @Override // com.xiaomi.mipush.sdk.MiPushClient.MiPushClientCallback
    public void onInitializeResult(long j, String str, String str2) {
        if (this.f109a != null) {
            Message obtainMessage = this.f108a.obtainMessage();
            obtainMessage.what = 4;
            obtainMessage.arg1 = (int) j;
            obtainMessage.obj = str2;
            this.f108a.sendMessage(obtainMessage);
        }
        if (0 != j) {
            a(this.f114b + "--->chanle failed， need app reopen");
            return;
        }
        a(this.f114b + "--->cahnel OK");
        this.f108a.sendEmptyMessage(3);
        if (!f.a(this.c)) {
            this.f108a.sendEmptyMessage(6);
        }
        this.f108a.sendEmptyMessage(5);
    }

    @Override // com.xiaomi.mipush.sdk.MiPushClient.MiPushClientCallback
    public void onReceiveMessage(String str, String str2, String str3, boolean z) {
        a(this.f114b + "--->##" + str3);
        if (f.a(this.f113a) && f.a(this.c)) {
            a(this.f114b + "--->no alias，ignore the msg " + str + "##" + str3);
        } else if (!f.a(str2) && !f.a(this.f113a) && !TextUtils.equals(this.f113a, str2)) {
            a(this.f114b + "--->get msg for different alias. unset " + str + "##" + str3);
            MiPushClient.unsetAlias(this.f106a, str2, getCategory());
        } else if (!f.a(str3) && !f.a(this.c) && !TextUtils.equals(this.c, str3)) {
            a(this.f114b + "--->get msg for old topic, unset " + str + "##" + str3);
            MiPushClient.unsubscribe(this.f106a, str3, getCategory());
        } else if (m106a(str)) {
        } else {
            a(str, this.f114b);
        }
    }

    @Override // com.xiaomi.mipush.sdk.MiPushClient.MiPushClientCallback
    public void onSubscribeResult(long j, String str, String str2) {
        a(this.f114b + "--->topic resultCode: " + j + " reason: " + str + " topic: " + str2);
        if (j != 0) {
            this.f108a.sendEmptyMessageDelayed(6, BdKVCache.MILLS_1Hour);
        }
    }

    @Override // com.xiaomi.mipush.sdk.MiPushClient.MiPushClientCallback
    public void onUnsubscribeResult(long j, String str, String str2) {
        a(this.f114b + "--->unsuscribe topic resultCode: " + j + " reason: " + str + " topic: " + str2);
    }
}
