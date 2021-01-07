package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;
/* loaded from: classes3.dex */
public class aa extends z {
    public aa(Executor executor, com.facebook.common.memory.g gVar) {
        super(executor, gVar);
    }

    @Override // com.facebook.imagepipeline.producers.z
    protected com.facebook.imagepipeline.f.e g(ImageRequest imageRequest) throws IOException {
        return e(new FileInputStream(imageRequest.aeh().toString()), (int) imageRequest.aeh().length());
    }

    @Override // com.facebook.imagepipeline.producers.z
    protected String eAS() {
        return "LocalFileFetchProducer";
    }
}
