package com.facebook.imagepipeline.e;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public abstract class b extends com.facebook.datasource.a<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    protected abstract void h(@Nullable Bitmap bitmap);

    @Override // com.facebook.datasource.a
    public void g(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> bVar) {
        if (bVar.isFinished()) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> result = bVar.getResult();
            Bitmap bitmap = null;
            if (result != null && (result.get() instanceof com.facebook.imagepipeline.g.b)) {
                bitmap = ((com.facebook.imagepipeline.g.b) result.get()).dsL();
            }
            try {
                h(bitmap);
            } finally {
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) result);
            }
        }
    }
}
