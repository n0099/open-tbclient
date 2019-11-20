package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
public class z extends y {
    public z(Executor executor, com.facebook.common.memory.g gVar) {
        super(executor, gVar);
    }

    @Override // com.facebook.imagepipeline.producers.y
    protected com.facebook.imagepipeline.f.d h(ImageRequest imageRequest) throws IOException {
        return e(new FileInputStream(imageRequest.cJB().toString()), (int) imageRequest.cJB().length());
    }

    @Override // com.facebook.imagepipeline.producers.y
    protected String cIQ() {
        return "LocalFileFetchProducer";
    }
}
