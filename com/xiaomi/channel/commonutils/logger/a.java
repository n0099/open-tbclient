package com.xiaomi.channel.commonutils.logger;

import android.util.Log;
import com.baidu.android.util.devices.RomUtils;
/* loaded from: classes12.dex */
public class a implements LoggerInterface {

    /* renamed from: a  reason: collision with root package name */
    private String f4718a = RomUtils.MANUFACTURER_XIAOMI;

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String str) {
        Log.v(this.f4718a, str);
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String str, Throwable th) {
        Log.v(this.f4718a, str, th);
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void setTag(String str) {
        this.f4718a = str;
    }
}
