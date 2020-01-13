package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;
/* loaded from: classes10.dex */
public class aa extends z {
    public aa(Executor executor, com.facebook.common.memory.g gVar) {
        super(executor, gVar);
    }

    @Override // com.facebook.imagepipeline.producers.z
    protected com.facebook.imagepipeline.g.e h(ImageRequest imageRequest) throws IOException {
        return f(new FileInputStream(imageRequest.dri().toString()), (int) imageRequest.dri().length());
    }

    @Override // com.facebook.imagepipeline.producers.z
    protected String dqr() {
        return "LocalFileFetchProducer";
    }
}
