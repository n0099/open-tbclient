package com.xiaomi.push.mpcd.job;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.xiaomi.push.service.an;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class o extends g {
    private final Object a;
    private String b;
    private SharedPreferences e;
    private com.xiaomi.metoknlp.devicediscover.a f;

    public o(Context context, int i) {
        super(context, i);
        this.a = new Object();
        this.f = new p(this);
        a(context);
    }

    private void a(Context context) {
        com.xiaomi.metoknlp.a.a(context).f();
        com.xiaomi.metoknlp.a.a().a(this.f, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str) {
        try {
            String jSONArray = new JSONObject(str).getJSONArray("devices").toString();
            String substring = jSONArray.substring(1, jSONArray.length() - 1);
            if (!TextUtils.isEmpty(substring)) {
                return com.xiaomi.channel.commonutils.string.d.g(substring);
            }
        } catch (Throwable th) {
        }
        return "";
    }

    @Override // com.xiaomi.channel.commonutils.misc.h.a
    public int a() {
        return 14;
    }

    @Override // com.xiaomi.push.mpcd.job.g
    public String b() {
        if (com.xiaomi.channel.commonutils.network.d.e(this.d)) {
            com.xiaomi.metoknlp.a.a().c();
            synchronized (this.a) {
                try {
                    this.a.wait(10000L);
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
            this.e = this.d.getSharedPreferences("mipush_extra", 4);
            SharedPreferences.Editor edit = this.e.edit();
            edit.putLong("last_mac_upload_timestamp", System.currentTimeMillis());
            edit.commit();
        }
        String str = this.b;
        this.b = "";
        return str;
    }

    @Override // com.xiaomi.push.mpcd.job.g
    public com.xiaomi.xmpush.thrift.d d() {
        return com.xiaomi.xmpush.thrift.d.WifiDevicesMac;
    }

    @Override // com.xiaomi.push.mpcd.job.g
    protected boolean e() {
        if (f()) {
            return com.xiaomi.channel.commonutils.misc.f.a(this.d, String.valueOf(a()), this.c);
        }
        int max = Math.max(3600, an.a(this.d).a(com.xiaomi.xmpush.thrift.g.WifiDevicesMacWifiUnchangedCollectionFrequency.a(), 7200));
        long currentTimeMillis = System.currentTimeMillis();
        this.e = this.d.getSharedPreferences("mipush_extra", 4);
        return ((((float) Math.abs(currentTimeMillis - this.e.getLong("last_mac_upload_timestamp", 0L))) > (((float) (max * 1000)) * 0.9f) ? 1 : (((float) Math.abs(currentTimeMillis - this.e.getLong("last_mac_upload_timestamp", 0L))) == (((float) (max * 1000)) * 0.9f) ? 0 : -1)) >= 0) && com.xiaomi.channel.commonutils.misc.f.a(this.d, String.valueOf(a()), (long) max);
    }

    public boolean f() {
        WifiInfo connectionInfo;
        try {
            this.e = this.d.getSharedPreferences("mipush_extra", 4);
            String string = this.e.getString("last_wifi_ssid", "");
            WifiManager wifiManager = (WifiManager) this.d.getSystemService(IXAdSystemUtils.NT_WIFI);
            if (wifiManager.isWifiEnabled() && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                SharedPreferences.Editor edit = this.e.edit();
                edit.putString("last_wifi_ssid", connectionInfo.getSSID());
                edit.commit();
                if (TextUtils.isEmpty(string)) {
                    return false;
                }
                return !TextUtils.equals(connectionInfo.getSSID(), string);
            }
        } catch (Throwable th) {
        }
        return true;
    }
}
