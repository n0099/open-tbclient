package com.facebook.imagepipeline.e;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public abstract class b extends com.facebook.datasource.a<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    protected abstract void e(@Nullable Bitmap bitmap);

    @Override // com.facebook.datasource.a
    public void g(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> bVar) {
        if (bVar.isFinished()) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> result = bVar.getResult();
            Bitmap bitmap = null;
            if (result != null && (result.get() instanceof com.facebook.imagepipeline.g.b)) {
                bitmap = ((com.facebook.imagepipeline.g.b) result.get()).epO();
            }
            try {
                e(bitmap);
            } finally {
                com.facebook.common.references.a.c(result);
            }
        }
    }
}
