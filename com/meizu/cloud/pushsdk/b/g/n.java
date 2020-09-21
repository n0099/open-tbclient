package com.meizu.cloud.pushsdk.b.g;

import java.io.IOException;
import java.io.InterruptedIOException;
/* loaded from: classes3.dex */
public class n {
    public static final n a = new n() { // from class: com.meizu.cloud.pushsdk.b.g.n.1
        @Override // com.meizu.cloud.pushsdk.b.g.n
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
