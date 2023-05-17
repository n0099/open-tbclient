package com.yy.hiidostatis.message.module.sessionreport;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public class CalValue {
    public volatile Object tempStorage;
    public AtomicInteger times = new AtomicInteger(0);
    public volatile Number value;

    public CalValue updateTempStorage(Object obj) {
        this.tempStorage = obj;
        return this;
    }

    public CalValue updateValue(Number number) {
        this.value = number;
        this.times.incrementAndGet();
        return this;
    }
}
