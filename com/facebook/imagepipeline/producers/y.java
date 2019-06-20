package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
public abstract class y implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.common.memory.g jXB;
    private final Executor mExecutor;

    protected abstract String cHI();

    protected abstract com.facebook.imagepipeline.f.d h(ImageRequest imageRequest) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public y(Executor executor, com.facebook.common.memory.g gVar) {
        this.mExecutor = executor;
        this.jXB = gVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        al cHy = ajVar.cHy();
        String id = ajVar.getId();
        final ImageRequest cHx = ajVar.cHx();
        final ao<com.facebook.imagepipeline.f.d> aoVar = new ao<com.facebook.imagepipeline.f.d>(jVar, cHy, cHI(), id) { // from class: com.facebook.imagepipeline.producers.y.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.e
            /* renamed from: cHU */
            public com.facebook.imagepipeline.f.d getResult() throws Exception {
                com.facebook.imagepipeline.f.d h = y.this.h(cHx);
                if (h == null) {
                    return null;
                }
                h.cGI();
                return h;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.ao, com.facebook.common.b.e
            /* renamed from: h */
            public void aB(com.facebook.imagepipeline.f.d dVar) {
                com.facebook.imagepipeline.f.d.e(dVar);
            }
        };
        ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.y.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
            public void cHE() {
                aoVar.cancel();
            }
        });
        this.mExecutor.execute(aoVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.facebook.imagepipeline.f.d d(InputStream inputStream, int i) throws IOException {
        com.facebook.common.references.a aVar = null;
        try {
            if (i <= 0) {
                aVar = com.facebook.common.references.a.d(this.jXB.r(inputStream));
            } else {
                aVar = com.facebook.common.references.a.d(this.jXB.b(inputStream, i));
            }
            return new com.facebook.imagepipeline.f.d(aVar);
        } finally {
            com.facebook.common.internal.b.q(inputStream);
            com.facebook.common.references.a.c(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.facebook.imagepipeline.f.d e(InputStream inputStream, int i) throws IOException {
        return d(inputStream, i);
    }
}
