package com.xiaomi.push.log;

import com.xiaomi.channel.commonutils.logger.LoggerInterface;
/* loaded from: classes2.dex */
public class e implements LoggerInterface {
    private LoggerInterface a;
    private LoggerInterface b;

    public e(LoggerInterface loggerInterface, LoggerInterface loggerInterface2) {
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
