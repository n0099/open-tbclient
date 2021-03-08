package com.thunder.livesdk.helper;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public class NativeByteBufferPool {
    public static AtomicReference<IByteBufferPool> mNativeByteBufferPool = new AtomicReference<>(null);

    public static synchronized void release() {
        synchronized (NativeByteBufferPool.class) {
            if (mNativeByteBufferPool.get() != null) {
                mNativeByteBufferPool.get().clear();
                mNativeByteBufferPool.set(null);
            }
        }
    }

    public static synchronized void alloc() {
        synchronized (NativeByteBufferPool.class) {
            if (mNativeByteBufferPool.get() == null) {
                mNativeByteBufferPool.set(new MshByteBufferPool());
            }
        }
    }

    public static IByteBufferPool get() {
        return mNativeByteBufferPool.get();
    }
}
