package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.LoggerInterface;
/* loaded from: classes6.dex */
public class dl implements LoggerInterface {

    /* renamed from: a  reason: collision with root package name */
    private LoggerInterface f14245a;

    /* renamed from: b  reason: collision with root package name */
    private LoggerInterface f14246b;

    public dl(LoggerInterface loggerInterface, LoggerInterface loggerInterface2) {
        this.f14245a = null;
        this.f14246b = null;
        this.f14245a = loggerInterface;
        this.f14246b = loggerInterface2;
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String str) {
        if (this.f14245a != null) {
            this.f14245a.log(str);
        }
        if (this.f14246b != null) {
            this.f14246b.log(str);
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String str, Throwable th) {
        if (this.f14245a != null) {
            this.f14245a.log(str, th);
        }
        if (this.f14246b != null) {
            this.f14246b.log(str, th);
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void setTag(String str) {
    }
}
