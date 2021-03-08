package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.LoggerInterface;
/* loaded from: classes5.dex */
public class dl implements LoggerInterface {

    /* renamed from: a  reason: collision with root package name */
    private LoggerInterface f8324a;
    private LoggerInterface b;

    public dl(LoggerInterface loggerInterface, LoggerInterface loggerInterface2) {
        this.f8324a = null;
        this.b = null;
        this.f8324a = loggerInterface;
        this.b = loggerInterface2;
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String str) {
        if (this.f8324a != null) {
            this.f8324a.log(str);
        }
        if (this.b != null) {
            this.b.log(str);
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String str, Throwable th) {
        if (this.f8324a != null) {
            this.f8324a.log(str, th);
        }
        if (this.b != null) {
            this.b.log(str, th);
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void setTag(String str) {
    }
}
