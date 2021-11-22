package com.meizu.cloud.pushsdk.b.g;

import java.io.IOException;
import java.io.InterruptedIOException;
/* loaded from: classes2.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public static final n f68317a = new n() { // from class: com.meizu.cloud.pushsdk.b.g.n.1
        @Override // com.meizu.cloud.pushsdk.b.g.n
        public void a() throws IOException {
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public boolean f68318b;

    /* renamed from: c  reason: collision with root package name */
    public long f68319c;

    public void a() throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        }
        if (this.f68318b && this.f68319c - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
