package com.xiaomi.push.mpcd.job;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Build;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes3.dex */
public class e extends g {
    public e(Context context, int i) {
        super(context, i);
    }

    @Override // com.xiaomi.channel.commonutils.misc.h.a
    public int a() {
        return 6;
    }

    @Override // com.xiaomi.push.mpcd.job.g
    public String b() {
        StringBuilder sb = new StringBuilder();
        try {
            Set<BluetoothDevice> bondedDevices = BluetoothAdapter.getDefaultAdapter().getBondedDevices();
            if (!com.xiaomi.channel.commonutils.misc.c.a(bondedDevices)) {
                int i = 0;
                Iterator<BluetoothDevice> it = bondedDevices.iterator();
                while (true) {
                    int i2 = i;
                    if (!it.hasNext()) {
                        break;
                    }
                    BluetoothDevice next = it.next();
                    if (i2 > 10) {
                        break;
                    }
                    if (sb.length() > 0) {
                        sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                    }
                    sb.append(next.getName()).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(next.getAddress()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    if (Build.VERSION.SDK_INT >= 18) {
                        sb.append(next.getType());
                    }
                    i = i2 + 1;
                }
            }
        } catch (Throwable th) {
        }
        return sb.toString();
    }

    @Override // com.xiaomi.push.mpcd.job.g
    protected boolean c() {
        return this.d.getPackageManager().checkPermission("android.permission.BLUETOOTH", this.d.getPackageName()) == 0;
    }

    @Override // com.xiaomi.push.mpcd.job.g
    public com.xiaomi.xmpush.thrift.d d() {
        return com.xiaomi.xmpush.thrift.d.Bluetooth;
    }
}
