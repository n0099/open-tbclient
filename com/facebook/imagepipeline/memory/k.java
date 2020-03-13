package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.imagepipeline.memory.BasePool;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes12.dex */
public class k extends BasePool<NativeMemoryChunk> {
    private final int[] lUG;

    public k(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        super(cVar, rVar, sVar);
        SparseIntArray sparseIntArray = rVar.lUX;
        this.lUG = new int[sparseIntArray.size()];
        for (int i = 0; i < this.lUG.length; i++) {
            this.lUG[i] = sparseIntArray.keyAt(i);
        }
        initialize();
    }

    public int dqZ() {
        return this.lUG[0];
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: IA */
    public NativeMemoryChunk Ip(int i) {
        return new NativeMemoryChunk(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: a */
    public void bp(NativeMemoryChunk nativeMemoryChunk) {
        com.facebook.common.internal.g.checkNotNull(nativeMemoryChunk);
        nativeMemoryChunk.close();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    protected int Ir(int i) {
        return i;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    protected int Iq(int i) {
        int[] iArr;
        if (i <= 0) {
            throw new BasePool.InvalidSizeException(Integer.valueOf(i));
        }
        for (int i2 : this.lUG) {
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
    public int bq(NativeMemoryChunk nativeMemoryChunk) {
        com.facebook.common.internal.g.checkNotNull(nativeMemoryChunk);
        return nativeMemoryChunk.getSize();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: c */
    public boolean br(NativeMemoryChunk nativeMemoryChunk) {
        com.facebook.common.internal.g.checkNotNull(nativeMemoryChunk);
        return !nativeMemoryChunk.isClosed();
    }
}
