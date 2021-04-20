package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.LoggerInterface;
/* loaded from: classes7.dex */
public class de implements LoggerInterface {

    /* renamed from: a  reason: collision with root package name */
    public LoggerInterface f40646a;

    /* renamed from: b  reason: collision with root package name */
    public LoggerInterface f40647b;

    public de(LoggerInterface loggerInterface, LoggerInterface loggerInterface2) {
        this.f40646a = null;
        this.f40647b = null;
        this.f40646a = loggerInterface;
        this.f40647b = loggerInterface2;
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String str) {
        LoggerInterface loggerInterface = this.f40646a;
        if (loggerInterface != null) {
            loggerInterface.log(str);
        }
        LoggerInterface loggerInterface2 = this.f40647b;
        if (loggerInterface2 != null) {
            loggerInterface2.log(str);
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String str, Throwable th) {
        LoggerInterface loggerInterface = this.f40646a;
        if (loggerInterface != null) {
            loggerInterface.log(str, th);
        }
        LoggerInterface loggerInterface2 = this.f40647b;
        if (loggerInterface2 != null) {
            loggerInterface2.log(str, th);
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void setTag(String str) {
    }
}
