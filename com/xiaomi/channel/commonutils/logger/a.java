package com.xiaomi.channel.commonutils.logger;

import android.util.Log;
import com.baidu.android.util.devices.RomUtils;
/* loaded from: classes9.dex */
public class a implements LoggerInterface {
    private String a = RomUtils.MANUFACTURER_XIAOMI;

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String str) {
        Log.v(this.a, str);
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String str, Throwable th) {
        Log.v(this.a, str, th);
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void setTag(String str) {
        this.a = str;
    }
}
