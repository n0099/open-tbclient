package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.LoggerInterface;
/* loaded from: classes6.dex */
public class dl implements LoggerInterface {

    /* renamed from: a  reason: collision with root package name */
    private LoggerInterface f13948a;

    /* renamed from: b  reason: collision with root package name */
    private LoggerInterface f13949b;

    public dl(LoggerInterface loggerInterface, LoggerInterface loggerInterface2) {
        this.f13948a = null;
        this.f13949b = null;
        this.f13948a = loggerInterface;
        this.f13949b = loggerInterface2;
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String str) {
        if (this.f13948a != null) {
            this.f13948a.log(str);
        }
        if (this.f13949b != null) {
            this.f13949b.log(str);
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String str, Throwable th) {
        if (this.f13948a != null) {
            this.f13948a.log(str, th);
        }
        if (this.f13949b != null) {
            this.f13949b.log(str, th);
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void setTag(String str) {
    }
}
