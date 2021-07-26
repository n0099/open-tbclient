package com.meizu.cloud.pushsdk.b.g;

import java.io.IOException;
import java.io.InterruptedIOException;
/* loaded from: classes6.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public static final n f37465a = new n() { // from class: com.meizu.cloud.pushsdk.b.g.n.1
        @Override // com.meizu.cloud.pushsdk.b.g.n
        public void a() throws IOException {
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public boolean f37466b;

    /* renamed from: c  reason: collision with root package name */
    public long f37467c;

    public void a() throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        }
        if (this.f37466b && this.f37467c - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
