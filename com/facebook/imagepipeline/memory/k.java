package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.imagepipeline.memory.BasePool;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes4.dex */
public class k extends BasePool<NativeMemoryChunk> {
    private final int[] ndp;

    public k(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        super(cVar, rVar, sVar);
        SparseIntArray sparseIntArray = rVar.ndG;
        this.ndp = new int[sparseIntArray.size()];
        for (int i = 0; i < this.ndp.length; i++) {
            this.ndp[i] = sparseIntArray.keyAt(i);
        }
        initialize();
    }

    public int dIQ() {
        return this.ndp[0];
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: Jy */
    public NativeMemoryChunk Jn(int i) {
        return new NativeMemoryChunk(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: a */
    public void bl(NativeMemoryChunk nativeMemoryChunk) {
        com.facebook.common.internal.g.checkNotNull(nativeMemoryChunk);
        nativeMemoryChunk.close();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    protected int Jp(int i) {
        return i;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    protected int Jo(int i) {
        int[] iArr;
        if (i <= 0) {
            throw new BasePool.InvalidSizeException(Integer.valueOf(i));
        }
        for (int i2 : this.ndp) {
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
    public int bm(NativeMemoryChunk nativeMemoryChunk) {
        com.facebook.common.internal.g.checkNotNull(nativeMemoryChunk);
        return nativeMemoryChunk.getSize();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: c */
    public boolean bn(NativeMemoryChunk nativeMemoryChunk) {
        com.facebook.common.internal.g.checkNotNull(nativeMemoryChunk);
        return !nativeMemoryChunk.isClosed();
    }
}
