package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.imagepipeline.memory.BasePool;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes15.dex */
public class j extends BasePool<byte[]> implements com.facebook.common.memory.a {
    private final int[] pnQ;

    public j(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        super(cVar, rVar, sVar);
        SparseIntArray sparseIntArray = rVar.poh;
        this.pnQ = new int[sparseIntArray.size()];
        for (int i = 0; i < sparseIntArray.size(); i++) {
            this.pnQ[i] = sparseIntArray.keyAt(i);
        }
        initialize();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: QX */
    public byte[] QN(int i) {
        return new byte[i];
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: aq */
    public void bw(byte[] bArr) {
        com.facebook.common.internal.g.checkNotNull(bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    public int QP(int i) {
        return i;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    protected int QO(int i) {
        int[] iArr;
        if (i <= 0) {
            throw new BasePool.InvalidSizeException(Integer.valueOf(i));
        }
        for (int i2 : this.pnQ) {
            if (i2 >= i) {
                return i2;
            }
        }
        return i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: ar */
    public int bx(byte[] bArr) {
        com.facebook.common.internal.g.checkNotNull(bArr);
        return bArr.length;
    }
}
