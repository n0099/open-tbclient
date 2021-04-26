package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.LoggerInterface;
/* loaded from: classes7.dex */
public class de implements LoggerInterface {

    /* renamed from: a  reason: collision with root package name */
    public LoggerInterface f38258a;

    /* renamed from: b  reason: collision with root package name */
    public LoggerInterface f38259b;

    public de(LoggerInterface loggerInterface, LoggerInterface loggerInterface2) {
        this.f38258a = null;
        this.f38259b = null;
        this.f38258a = loggerInterface;
        this.f38259b = loggerInterface2;
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String str) {
        LoggerInterface loggerInterface = this.f38258a;
        if (loggerInterface != null) {
            loggerInterface.log(str);
        }
        LoggerInterface loggerInterface2 = this.f38259b;
        if (loggerInterface2 != null) {
            loggerInterface2.log(str);
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String str, Throwable th) {
        LoggerInterface loggerInterface = this.f38258a;
        if (loggerInterface != null) {
            loggerInterface.log(str, th);
        }
        LoggerInterface loggerInterface2 = this.f38259b;
        if (loggerInterface2 != null) {
            loggerInterface2.log(str, th);
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void setTag(String str) {
    }
}
