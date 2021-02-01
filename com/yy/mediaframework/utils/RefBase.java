package com.yy.mediaframework.utils;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class RefBase {
    private AtomicInteger mRefCnt = new AtomicInteger(0);

    public RefBase() {
        addRef();
    }

    public int addRef() {
        return this.mRefCnt.addAndGet(1);
    }

    public int decRef() {
        int decrementAndGet = this.mRefCnt.decrementAndGet();
        if (decrementAndGet == 0) {
            free();
            return 0;
        }
        return decrementAndGet;
    }

    public void free() {
    }
}
