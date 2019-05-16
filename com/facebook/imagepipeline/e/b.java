package com.facebook.imagepipeline.e;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public abstract class b extends com.facebook.datasource.a<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    protected abstract void f(@Nullable Bitmap bitmap);

    @Override // com.facebook.datasource.a
    public void g(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bVar) {
        if (bVar.isFinished()) {
            com.facebook.common.references.a<com.facebook.imagepipeline.f.b> result = bVar.getResult();
            Bitmap bitmap = null;
            if (result != null && (result.get() instanceof com.facebook.imagepipeline.f.a)) {
                bitmap = ((com.facebook.imagepipeline.f.a) result.get()).cGz();
            }
            try {
                f(bitmap);
            } finally {
                com.facebook.common.references.a.c(result);
            }
        }
    }
}
