package com.facebook.imagepipeline.e;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public abstract class b extends com.facebook.datasource.a<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    protected abstract void onNewResultImpl(@Nullable Bitmap bitmap);

    @Override // com.facebook.datasource.a
    public void onNewResultImpl(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> bVar) {
        if (bVar.isFinished()) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> result = bVar.getResult();
            Bitmap bitmap = null;
            if (result != null && (result.get() instanceof com.facebook.imagepipeline.g.b)) {
                bitmap = ((com.facebook.imagepipeline.g.b) result.get()).dqs();
            }
            try {
                onNewResultImpl(bitmap);
            } finally {
                com.facebook.common.references.a.c(result);
            }
        }
    }
}
