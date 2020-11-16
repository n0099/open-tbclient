package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.imagepipeline.memory.BasePool;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes15.dex */
public class k extends BasePool<NativeMemoryChunk> {
    private final int[] oYZ;

    public k(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        super(cVar, rVar, sVar);
        SparseIntArray sparseIntArray = rVar.oZq;
        this.oYZ = new int[sparseIntArray.size()];
        for (int i = 0; i < this.oYZ.length; i++) {
            this.oYZ[i] = sparseIntArray.keyAt(i);
        }
        initialize();
    }

    public int equ() {
        return this.oYZ[0];
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: Qc */
    public NativeMemoryChunk PR(int i) {
        return new NativeMemoryChunk(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: a */
    public void bx(NativeMemoryChunk nativeMemoryChunk) {
        com.facebook.common.internal.g.checkNotNull(nativeMemoryChunk);
        nativeMemoryChunk.close();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    protected int PT(int i) {
        return i;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    protected int PS(int i) {
        int[] iArr;
        if (i <= 0) {
            throw new BasePool.InvalidSizeException(Integer.valueOf(i));
        }
        for (int i2 : this.oYZ) {
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
    public int by(NativeMemoryChunk nativeMemoryChunk) {
        com.facebook.common.internal.g.checkNotNull(nativeMemoryChunk);
        return nativeMemoryChunk.getSize();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: c */
    public boolean bz(NativeMemoryChunk nativeMemoryChunk) {
        com.facebook.common.internal.g.checkNotNull(nativeMemoryChunk);
        return !nativeMemoryChunk.isClosed();
    }
}
