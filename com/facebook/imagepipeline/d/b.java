package com.facebook.imagepipeline.d;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public abstract class b extends com.facebook.datasource.a<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    protected abstract void e(@Nullable Bitmap bitmap);

    @Override // com.facebook.datasource.a
    public void g(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> bVar) {
        if (bVar.isFinished()) {
            com.facebook.common.references.a<com.facebook.imagepipeline.f.c> result = bVar.getResult();
            Bitmap bitmap = null;
            if (result != null && (result.get() instanceof com.facebook.imagepipeline.f.b)) {
                bitmap = ((com.facebook.imagepipeline.f.b) result.get()).evu();
            }
            try {
                e(bitmap);
            } finally {
                com.facebook.common.references.a.c(result);
            }
        }
    }
}
