package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.LoggerInterface;
/* loaded from: classes8.dex */
public class dl implements LoggerInterface {
    private LoggerInterface a;
    private LoggerInterface b;

    public dl(LoggerInterface loggerInterface, LoggerInterface loggerInterface2) {
        this.a = null;
        this.b = null;
        this.a = loggerInterface;
        this.b = loggerInterface2;
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String str) {
        if (this.a != null) {
            this.a.log(str);
        }
        if (this.b != null) {
            this.b.log(str);
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String str, Throwable th) {
        if (this.a != null) {
            this.a.log(str, th);
        }
        if (this.b != null) {
            this.b.log(str, th);
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void setTag(String str) {
    }
}
