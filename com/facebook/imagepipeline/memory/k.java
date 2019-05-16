package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.imagepipeline.memory.BasePool;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class k extends BasePool<NativeMemoryChunk> {
    private final int[] kbv;

    public k(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        super(cVar, rVar, sVar);
        SparseIntArray sparseIntArray = rVar.kbM;
        this.kbv = new int[sparseIntArray.size()];
        for (int i = 0; i < this.kbv.length; i++) {
            this.kbv[i] = sparseIntArray.keyAt(i);
        }
        initialize();
    }

    public int cGY() {
        return this.kbv[0];
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: Dy */
    public NativeMemoryChunk Dn(int i) {
        return new NativeMemoryChunk(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: a */
    public void aW(NativeMemoryChunk nativeMemoryChunk) {
        com.facebook.common.internal.g.checkNotNull(nativeMemoryChunk);
        nativeMemoryChunk.close();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    protected int Dp(int i) {
        return i;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    protected int Do(int i) {
        int[] iArr;
        if (i <= 0) {
            throw new BasePool.InvalidSizeException(Integer.valueOf(i));
        }
        for (int i2 : this.kbv) {
            if (i2 >= i) {
                return i2;
            }
        }
        return i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: b */
    public int aX(NativeMemoryChunk nativeMemoryChunk) {
        com.facebook.common.internal.g.checkNotNull(nativeMemoryChunk);
        return nativeMemoryChunk.getSize();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: c */
    public boolean aY(NativeMemoryChunk nativeMemoryChunk) {
        com.facebook.common.internal.g.checkNotNull(nativeMemoryChunk);
        return !nativeMemoryChunk.isClosed();
    }
}
