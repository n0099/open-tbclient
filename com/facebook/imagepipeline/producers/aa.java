package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;
/* loaded from: classes15.dex */
public class aa extends z {
    public aa(Executor executor, com.facebook.common.memory.g gVar) {
        super(executor, gVar);
    }

    @Override // com.facebook.imagepipeline.producers.z
    protected com.facebook.imagepipeline.f.e g(ImageRequest imageRequest) throws IOException {
        return e(new FileInputStream(imageRequest.acr().toString()), (int) imageRequest.acr().length());
    }

    @Override // com.facebook.imagepipeline.producers.z
    protected String ewH() {
        return "LocalFileFetchProducer";
    }
}
