package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.util.concurrent.Executor;
/* loaded from: classes12.dex */
public class an extends z {
    private final ContentResolver mContentResolver;

    public an(Executor executor, com.facebook.common.memory.g gVar, ContentResolver contentResolver) {
        super(executor, gVar);
        this.mContentResolver = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.z
    protected com.facebook.imagepipeline.g.e g(ImageRequest imageRequest) throws IOException {
        return f(this.mContentResolver.openInputStream(imageRequest.dGU()), -1);
    }

    @Override // com.facebook.imagepipeline.producers.z
    protected String dGm() {
        return "QualifiedResourceFetchProducer";
    }
}
