package com.facebook.imagepipeline.memory;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
@TargetApi(21)
/* loaded from: classes2.dex */
public class c extends BasePool<Bitmap> {
    public c(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        super(cVar, rVar, sVar);
        initialize();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: yc */
    public Bitmap xU(int i) {
        return Bitmap.createBitmap(1, (int) Math.ceil(i / 2.0d), Bitmap.Config.RGB_565);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: O */
    public void aH(Bitmap bitmap) {
        com.facebook.common.internal.g.checkNotNull(bitmap);
        bitmap.recycle();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    protected int xV(int i) {
        return i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: P */
    public int aI(Bitmap bitmap) {
        com.facebook.common.internal.g.checkNotNull(bitmap);
        return bitmap.getAllocationByteCount();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    protected int xW(int i) {
        return i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: Q */
    public boolean aJ(Bitmap bitmap) {
        com.facebook.common.internal.g.checkNotNull(bitmap);
        return !bitmap.isRecycled() && bitmap.isMutable();
    }
}
