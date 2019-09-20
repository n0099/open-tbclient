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
    /* renamed from: Ei */
    public Bitmap Ea(int i) {
        return Bitmap.createBitmap(1, (int) Math.ceil(i / 2.0d), Bitmap.Config.RGB_565);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: X */
    public void aW(Bitmap bitmap) {
        com.facebook.common.internal.g.checkNotNull(bitmap);
        bitmap.recycle();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    protected int Eb(int i) {
        return i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: Y */
    public int aX(Bitmap bitmap) {
        com.facebook.common.internal.g.checkNotNull(bitmap);
        return bitmap.getAllocationByteCount();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    protected int Ec(int i) {
        return i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: Z */
    public boolean aY(Bitmap bitmap) {
        com.facebook.common.internal.g.checkNotNull(bitmap);
        return !bitmap.isRecycled() && bitmap.isMutable();
    }
}
