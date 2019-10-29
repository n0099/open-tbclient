package com.xiaomi.push.mpcd.job;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes3.dex */
public class m extends g {
    private Comparator<ScanResult> a;

    public m(Context context, int i) {
        super(context, i);
        this.a = new n(this);
    }

    @Override // com.xiaomi.channel.commonutils.misc.h.a
    public int a() {
        return 8;
    }

    @Override // com.xiaomi.push.mpcd.job.g
    public String b() {
        WifiInfo connectionInfo;
        StringBuilder sb = new StringBuilder();
        try {
            WifiManager wifiManager = (WifiManager) this.d.getSystemService("wifi");
            if (wifiManager.isWifiEnabled() && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                sb.append(connectionInfo.getSSID()).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(com.xiaomi.channel.commonutils.string.d.g(connectionInfo.getBSSID())).append("|");
            }
            List<ScanResult> scanResults = wifiManager.getScanResults();
            if (!com.xiaomi.channel.commonutils.misc.c.a(scanResults)) {
                Collections.sort(scanResults, this.a);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= Math.min(10, scanResults.size())) {
                        break;
                    }
                    ScanResult scanResult = scanResults.get(i2);
                    if (i2 > 0) {
                        sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                    }
                    if (scanResult != null) {
                        sb.append(scanResult.SSID).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(com.xiaomi.channel.commonutils.string.d.g(scanResult.BSSID)).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(scanResult.level);
                    }
                    i = i2 + 1;
                }
            }
        } catch (Throwable th) {
        }
        return sb.toString();
    }

    @Override // com.xiaomi.push.mpcd.job.g
    public com.xiaomi.xmpush.thrift.d d() {
        return com.xiaomi.xmpush.thrift.d.WIFI;
    }
}
