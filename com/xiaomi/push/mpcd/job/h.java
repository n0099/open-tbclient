package com.xiaomi.push.mpcd.job;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class h extends g {
    private boolean a;
    private boolean b;
    private boolean e;
    private boolean f;

    public h(Context context, int i, boolean z, boolean z2, boolean z3, boolean z4) {
        super(context, i);
        this.a = z;
        this.b = z2;
        if (com.xiaomi.channel.commonutils.android.f.g()) {
            this.b = false;
        }
        this.e = z3;
        this.f = z4;
    }

    private String a(Context context) {
        if (this.f) {
            try {
                if (com.xiaomi.channel.commonutils.android.f.g()) {
                    return "";
                }
                Iterator<String> it = com.xiaomi.channel.commonutils.android.d.j(context).iterator();
                String str = "";
                while (it.hasNext()) {
                    String next = it.next();
                    if (!TextUtils.isEmpty(str)) {
                        str = str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR;
                    }
                    str = str + com.xiaomi.channel.commonutils.string.d.a(next) + Constants.ACCEPT_TIME_SEPARATOR_SP + com.xiaomi.channel.commonutils.string.d.b(next);
                }
                return str;
            } catch (Throwable th) {
                return "";
            }
        }
        return "off";
    }

    private String f() {
        if (this.a) {
            try {
                String g = g();
                return TextUtils.isEmpty(g) ? "" : com.xiaomi.channel.commonutils.string.d.a(g) + Constants.ACCEPT_TIME_SEPARATOR_SP + com.xiaomi.channel.commonutils.string.d.b(g);
            } catch (Throwable th) {
                return "";
            }
        }
        return "off";
    }

    @TargetApi(9)
    private String g() {
        if (com.xiaomi.channel.commonutils.android.f.g()) {
            return "";
        }
        String macAddress = Build.VERSION.SDK_INT < 23 ? ((WifiManager) this.d.getSystemService(IXAdSystemUtils.NT_WIFI)).getConnectionInfo().getMacAddress() : "";
        if (TextUtils.isEmpty(macAddress)) {
            if (Build.VERSION.SDK_INT < 9) {
                return "";
            }
            try {
                for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                    if ("wlan0".equalsIgnoreCase(networkInterface.getName())) {
                        byte[] hardwareAddress = networkInterface.getHardwareAddress();
                        if (hardwareAddress == null) {
                            return "";
                        }
                        StringBuilder sb = new StringBuilder();
                        int length = hardwareAddress.length;
                        for (int i = 0; i < length; i++) {
                            sb.append(String.format("%02x:", Byte.valueOf(hardwareAddress[i])));
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        return sb.toString().toUpperCase();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "";
        }
        return macAddress;
    }

    private String h() {
        if (this.b) {
            try {
                String subscriberId = ((TelephonyManager) this.d.getSystemService("phone")).getSubscriberId();
                return TextUtils.isEmpty(subscriberId) ? "" : com.xiaomi.channel.commonutils.string.d.a(subscriberId) + Constants.ACCEPT_TIME_SEPARATOR_SP + com.xiaomi.channel.commonutils.string.d.b(subscriberId);
            } catch (Throwable th) {
                return "";
            }
        }
        return "off";
    }

    private String i() {
        if (this.e) {
            try {
                String simSerialNumber = ((TelephonyManager) this.d.getSystemService("phone")).getSimSerialNumber();
                return TextUtils.isEmpty(simSerialNumber) ? "" : com.xiaomi.channel.commonutils.string.d.a(simSerialNumber) + Constants.ACCEPT_TIME_SEPARATOR_SP + com.xiaomi.channel.commonutils.string.d.b(simSerialNumber);
            } catch (Throwable th) {
                return "";
            }
        }
        return "off";
    }

    @Override // com.xiaomi.channel.commonutils.misc.h.a
    public int a() {
        return 13;
    }

    @Override // com.xiaomi.push.mpcd.job.g
    public String b() {
        return f() + "|" + h() + "|" + i() + "|" + a(this.d);
    }

    @Override // com.xiaomi.push.mpcd.job.g
    public com.xiaomi.xmpush.thrift.d d() {
        return com.xiaomi.xmpush.thrift.d.DeviceBaseInfo;
    }
}
