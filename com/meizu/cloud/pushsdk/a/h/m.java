package com.meizu.cloud.pushsdk.a.h;

import java.io.IOException;
import java.io.InterruptedIOException;
/* loaded from: classes2.dex */
public class m {
    public static final m a = new m() { // from class: com.meizu.cloud.pushsdk.a.h.m.1
        @Override // com.meizu.cloud.pushsdk.a.h.m
        public void a() throws IOException {
        }
    };
    private boolean b;
    private long c;

    public void a() throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        }
        if (this.b && this.c - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
