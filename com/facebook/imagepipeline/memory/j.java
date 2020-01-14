package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.imagepipeline.memory.BasePool;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes10.dex */
public class j extends BasePool<byte[]> implements com.facebook.common.memory.a {
    private final int[] lTM;

    public j(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        super(cVar, rVar, sVar);
        SparseIntArray sparseIntArray = rVar.lUd;
        this.lTM = new int[sparseIntArray.size()];
        for (int i = 0; i < sparseIntArray.size(); i++) {
            this.lTM[i] = sparseIntArray.keyAt(i);
        }
        initialize();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: Iu */
    public byte[] Ik(int i) {
        return new byte[i];
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: ah */
    public void bn(byte[] bArr) {
        com.facebook.common.internal.g.checkNotNull(bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    public int Im(int i) {
        return i;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    protected int Il(int i) {
        int[] iArr;
        if (i <= 0) {
            throw new BasePool.InvalidSizeException(Integer.valueOf(i));
        }
        for (int i2 : this.lTM) {
            if (i2 >= i) {
                return i2;
            }
        }
        return i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: ai */
    public int bo(byte[] bArr) {
        com.facebook.common.internal.g.checkNotNull(bArr);
        return bArr.length;
    }
}
