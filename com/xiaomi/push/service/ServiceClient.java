package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.push.eq;
import com.xiaomi.push.fz;
import com.xiaomi.push.ga;
import com.xiaomi.push.gb;
import com.xiaomi.push.ge;
import com.xiaomi.push.gn;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;
/* loaded from: classes7.dex */
public class ServiceClient {

    /* renamed from: a  reason: collision with other field name */
    public static ServiceClient f826a;

    /* renamed from: a  reason: collision with other field name */
    public static String f827a;

    /* renamed from: a  reason: collision with other field name */
    public Context f828a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f831a;

    /* renamed from: b  reason: collision with other field name */
    public Messenger f832b;

    /* renamed from: b  reason: collision with root package name */
    public static String f38831b = gn.a(5) + "-";

    /* renamed from: a  reason: collision with root package name */
    public static long f38830a = 0;

    /* renamed from: a  reason: collision with other field name */
    public Messenger f829a = null;

    /* renamed from: a  reason: collision with other field name */
    public List<Message> f830a = new ArrayList();

    /* renamed from: b  reason: collision with other field name */
    public boolean f833b = false;

    public ServiceClient(Context context) {
        this.f831a = false;
        this.f828a = context.getApplicationContext();
        if (m533a()) {
            com.xiaomi.channel.commonutils.logger.b.c("use miui push service");
            this.f831a = true;
        }
    }

    private Intent a() {
        if (!isMiuiPushServiceEnabled()) {
            Intent intent = new Intent(this.f828a, XMPushService.class);
            intent.putExtra(az.A, this.f828a.getPackageName());
            b();
            return intent;
        }
        Intent intent2 = new Intent();
        intent2.setPackage("com.xiaomi.xmsf");
        intent2.setClassName("com.xiaomi.xmsf", m529a());
        intent2.putExtra(az.A, this.f828a.getPackageName());
        m531a();
        return intent2;
    }

    private Message a(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    /* renamed from: a  reason: collision with other method in class */
    private String m529a() {
        try {
            return this.f828a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
        } catch (Exception unused) {
            return "com.xiaomi.xmsf.push.service.XMPushService";
        }
    }

    private String a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        int i2 = 1;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append(":");
            sb.append(entry.getValue());
            if (i2 < map.size()) {
                sb.append(",");
            }
            i2++;
        }
        return sb.toString();
    }

    private Map<String, String> a(List<NameValuePair> list) {
        HashMap hashMap = new HashMap();
        if (list != null && list.size() > 0) {
            for (NameValuePair nameValuePair : list) {
                if (nameValuePair != null) {
                    hashMap.put(nameValuePair.getName(), nameValuePair.getValue());
                }
            }
        }
        return hashMap;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m531a() {
        this.f828a.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f828a, XMPushService.class), 2, 1);
    }

    /* renamed from: a  reason: collision with other method in class */
    private synchronized void m532a(Intent intent) {
        if (this.f833b) {
            Message a2 = a(intent);
            if (this.f830a.size() >= 50) {
                this.f830a.remove(0);
            }
            this.f830a.add(a2);
            return;
        }
        if (this.f832b == null) {
            this.f828a.bindService(intent, new bh(this), 1);
            this.f833b = true;
            this.f830a.clear();
            this.f830a.add(a(intent));
        } else {
            try {
                this.f832b.send(a(intent));
            } catch (RemoteException unused) {
                this.f832b = null;
                this.f833b = false;
            }
        }
    }

    private void a(Intent intent, String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        intent.putExtra(az.p, str);
        intent.putExtra(az.s, str2);
        intent.putExtra(az.u, str3);
        intent.putExtra(az.w, str5);
        intent.putExtra(az.v, str4);
        intent.putExtra(az.x, z);
        intent.putExtra(az.D, f827a);
        intent.putExtra(az.H, this.f829a);
        if (map != null && map.size() > 0) {
            String a2 = a(map);
            if (!TextUtils.isEmpty(a2)) {
                intent.putExtra(az.y, a2);
            }
        }
        if (map2 == null || map2.size() <= 0) {
            return;
        }
        String a3 = a(map2);
        if (TextUtils.isEmpty(a3)) {
            return;
        }
        intent.putExtra(az.z, a3);
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m533a() {
        if (com.xiaomi.push.ab.f38118e) {
            return false;
        }
        try {
            PackageInfo packageInfo = this.f828a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo == null) {
                return false;
            }
            return packageInfo.versionCode >= 104;
        } catch (Exception unused) {
            return false;
        }
    }

    private void b() {
        this.f828a.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f828a, XMPushService.class), 1, 1);
    }

    public static ServiceClient getInstance(Context context) {
        if (f826a == null) {
            f826a = new ServiceClient(context);
        }
        return f826a;
    }

    public static String getSession() {
        return f827a;
    }

    public static void setSession(String str) {
        f827a = str;
    }

    public boolean batchSendMessage(gb[] gbVarArr, boolean z) {
        if (com.xiaomi.push.bg.b(this.f828a)) {
            Intent a2 = a();
            int length = gbVarArr.length;
            Bundle[] bundleArr = new Bundle[length];
            for (int i2 = 0; i2 < gbVarArr.length; i2++) {
                String a3 = eq.a();
                if (!TextUtils.isEmpty(a3)) {
                    fz fzVar = new fz("pf", null, null, null);
                    fz fzVar2 = new fz("sent", null, null, null);
                    fzVar2.m323a(a3);
                    fzVar.a(fzVar2);
                    gbVarArr[i2].a(fzVar);
                }
                com.xiaomi.channel.commonutils.logger.b.c("SEND:" + gbVarArr[i2].a());
                bundleArr[i2] = gbVarArr[i2].a();
            }
            if (length > 0) {
                a2.setAction(az.f38915g);
                a2.putExtra(az.D, f827a);
                a2.putExtra("ext_packets", bundleArr);
                a2.putExtra("ext_encrypt", z);
                return startServiceSafely(a2);
            }
            return false;
        }
        return false;
    }

    public void checkAlive() {
        Intent a2 = a();
        a2.setAction("com.xiaomi.push.check_alive");
        startServiceSafely(a2);
    }

    public boolean closeChannel() {
        Intent a2 = a();
        a2.setAction(az.f38917i);
        return startServiceSafely(a2);
    }

    public boolean closeChannel(String str) {
        Intent a2 = a();
        a2.setAction(az.f38917i);
        a2.putExtra(az.s, str);
        return startServiceSafely(a2);
    }

    public boolean closeChannel(String str, String str2) {
        Intent a2 = a();
        a2.setAction(az.f38917i);
        a2.putExtra(az.s, str);
        a2.putExtra(az.p, str2);
        return startServiceSafely(a2);
    }

    @Deprecated
    public boolean forceReconnection(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        return forceReconnection(str, str2, str3, str4, str5, z, a(list), a(list2));
    }

    public boolean forceReconnection(String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        Intent a2 = a();
        a2.setAction(az.j);
        a(a2, str, str2, str3, str4, str5, z, map, map2);
        return startServiceSafely(a2);
    }

    public boolean isMiuiPushServiceEnabled() {
        return this.f831a;
    }

    public int openChannel(String str, String str2, String str3, String str4, String str5, Map<String, String> map, Map<String, String> map2, boolean z) {
        Intent a2 = a();
        a2.setAction(az.f38912d);
        a(a2, str, str2, str3, str4, str5, z, map, map2);
        startServiceSafely(a2);
        return 0;
    }

    @Deprecated
    public int openChannel(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        return openChannel(str, str2, str3, str4, str5, a(list), a(list2), z);
    }

    @Deprecated
    public void resetConnection(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        resetConnection(str, str2, str3, str4, str5, z, a(list), a(list2));
    }

    public void resetConnection(String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        Intent a2 = a();
        a2.setAction(az.k);
        a(a2, str, str2, str3, str4, str5, z, map, map2);
        startServiceSafely(a2);
    }

    public boolean sendIQ(ga gaVar) {
        if (com.xiaomi.push.bg.b(this.f828a)) {
            Intent a2 = a();
            Bundle a3 = gaVar.a();
            if (a3 != null) {
                com.xiaomi.channel.commonutils.logger.b.c("SEND:" + gaVar.a());
                a2.setAction(az.f38914f);
                a2.putExtra(az.D, f827a);
                a2.putExtra("ext_packet", a3);
                return startServiceSafely(a2);
            }
            return false;
        }
        return false;
    }

    public boolean sendMessage(gb gbVar, boolean z) {
        if (com.xiaomi.push.bg.b(this.f828a)) {
            Intent a2 = a();
            String a3 = eq.a();
            if (!TextUtils.isEmpty(a3)) {
                fz fzVar = new fz("pf", null, null, null);
                fz fzVar2 = new fz("sent", null, null, null);
                fzVar2.m323a(a3);
                fzVar.a(fzVar2);
                gbVar.a(fzVar);
            }
            Bundle a4 = gbVar.a();
            if (a4 != null) {
                com.xiaomi.channel.commonutils.logger.b.c("SEND:" + gbVar.a());
                a2.setAction(az.f38913e);
                a2.putExtra(az.D, f827a);
                a2.putExtra("ext_packet", a4);
                a2.putExtra("ext_encrypt", z);
                return startServiceSafely(a2);
            }
            return false;
        }
        return false;
    }

    public boolean sendMessage(byte[] bArr, String str, String str2) {
        String str3;
        if (!com.xiaomi.push.bg.b(this.f828a) || bArr == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            com.xiaomi.channel.commonutils.logger.b.m58a("Failed to send message: message|userId|chid may be empty, or the network is unavailable.");
            return false;
        }
        Intent a2 = a();
        if (bArr != null) {
            a2.setAction(az.f38913e);
            a2.putExtra(az.D, f827a);
            a2.putExtra("ext_raw_packet", bArr);
            int indexOf = str.indexOf("@");
            String str4 = null;
            String substring = indexOf != -1 ? str.substring(0, indexOf) : null;
            int lastIndexOf = str.lastIndexOf("/");
            if (lastIndexOf != -1) {
                str4 = str.substring(indexOf + 1, lastIndexOf);
                str3 = str.substring(lastIndexOf + 1);
            } else {
                str3 = null;
            }
            a2.putExtra(az.p, substring);
            a2.putExtra(az.q, str4);
            a2.putExtra(az.r, str3);
            StringBuilder sb = new StringBuilder();
            sb.append(f38831b);
            long j = f38830a;
            f38830a = 1 + j;
            sb.append(j);
            String sb2 = sb.toString();
            a2.putExtra("ext_pkt_id", sb2);
            a2.putExtra("ext_chid", str2);
            com.xiaomi.channel.commonutils.logger.b.e("SEND: chid=" + str2 + ", packetId=" + sb2);
            return startServiceSafely(a2);
        }
        return false;
    }

    public boolean sendPresence(ge geVar) {
        if (com.xiaomi.push.bg.b(this.f828a)) {
            Intent a2 = a();
            Bundle a3 = geVar.a();
            if (a3 != null) {
                com.xiaomi.channel.commonutils.logger.b.c("SEND:" + geVar.a());
                a2.setAction(az.f38916h);
                a2.putExtra(az.D, f827a);
                a2.putExtra("ext_packet", a3);
                return startServiceSafely(a2);
            }
            return false;
        }
        return false;
    }

    public void setMessenger(Messenger messenger) {
        this.f829a = messenger;
    }

    public boolean startServiceSafely(Intent intent) {
        try {
            if (com.xiaomi.push.l.m523a() || Build.VERSION.SDK_INT < 26) {
                this.f828a.startService(intent);
                return true;
            }
            m532a(intent);
            return true;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return false;
        }
    }

    @Deprecated
    public void updateChannelInfo(String str, List<NameValuePair> list, List<NameValuePair> list2) {
        updateChannelInfo(str, a(list), a(list2));
    }

    public void updateChannelInfo(String str, Map<String, String> map, Map<String, String> map2) {
        Intent a2 = a();
        a2.setAction(az.l);
        if (map != null) {
            String a3 = a(map);
            if (!TextUtils.isEmpty(a3)) {
                a2.putExtra(az.y, a3);
            }
        }
        if (map2 != null) {
            String a4 = a(map2);
            if (!TextUtils.isEmpty(a4)) {
                a2.putExtra(az.z, a4);
            }
        }
        a2.putExtra(az.s, str);
        startServiceSafely(a2);
    }
}
