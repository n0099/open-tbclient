package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.util.concurrent.Executor;
/* loaded from: classes18.dex */
public class an extends z {
    private final ContentResolver mContentResolver;

    public an(Executor executor, com.facebook.common.memory.g gVar, ContentResolver contentResolver) {
        super(executor, gVar);
        this.mContentResolver = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.z
    protected com.facebook.imagepipeline.g.e g(ImageRequest imageRequest) throws IOException {
        return e(this.mContentResolver.openInputStream(imageRequest.enX()), -1);
    }

    @Override // com.facebook.imagepipeline.producers.z
    protected String enp() {
        return "QualifiedResourceFetchProducer";
    }
}
