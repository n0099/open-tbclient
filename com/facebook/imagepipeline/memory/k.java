package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.imagepipeline.memory.BasePool;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class k extends BasePool<NativeMemoryChunk> {
    private final int[] kjE;

    public k(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        super(cVar, rVar, sVar);
        SparseIntArray sparseIntArray = rVar.kjV;
        this.kjE = new int[sparseIntArray.size()];
        for (int i = 0; i < this.kjE.length; i++) {
            this.kjE[i] = sparseIntArray.keyAt(i);
        }
        initialize();
    }

    public int cIh() {
        return this.kjE[0];
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: CG */
    public NativeMemoryChunk Cv(int i) {
        return new NativeMemoryChunk(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: a */
    public void aR(NativeMemoryChunk nativeMemoryChunk) {
        com.facebook.common.internal.g.checkNotNull(nativeMemoryChunk);
        nativeMemoryChunk.close();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    protected int Cx(int i) {
        return i;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    protected int Cw(int i) {
        int[] iArr;
        if (i <= 0) {
            throw new BasePool.InvalidSizeException(Integer.valueOf(i));
        }
        for (int i2 : this.kjE) {
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
    public int aS(NativeMemoryChunk nativeMemoryChunk) {
        com.facebook.common.internal.g.checkNotNull(nativeMemoryChunk);
        return nativeMemoryChunk.getSize();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: c */
    public boolean aT(NativeMemoryChunk nativeMemoryChunk) {
        com.facebook.common.internal.g.checkNotNull(nativeMemoryChunk);
        return !nativeMemoryChunk.isClosed();
    }
}
