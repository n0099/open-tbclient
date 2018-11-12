package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
public abstract class y implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.common.memory.g idU;
    private final Executor mExecutor;

    protected abstract String bWW();

    protected abstract com.facebook.imagepipeline.f.d e(ImageRequest imageRequest) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public y(Executor executor, com.facebook.common.memory.g gVar) {
        this.mExecutor = executor;
        this.idU = gVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        al bWM = ajVar.bWM();
        String id = ajVar.getId();
        final ImageRequest bWL = ajVar.bWL();
        final ao<com.facebook.imagepipeline.f.d> aoVar = new ao<com.facebook.imagepipeline.f.d>(jVar, bWM, bWW(), id) { // from class: com.facebook.imagepipeline.producers.y.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.e
            /* renamed from: bXi */
            public com.facebook.imagepipeline.f.d getResult() throws Exception {
                com.facebook.imagepipeline.f.d e = y.this.e(bWL);
                if (e == null) {
                    return null;
                }
                e.bVW();
                return e;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.ao, com.facebook.common.b.e
            /* renamed from: h */
            public void am(com.facebook.imagepipeline.f.d dVar) {
                com.facebook.imagepipeline.f.d.e(dVar);
            }
        };
        ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.y.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
            public void bWS() {
                aoVar.cancel();
            }
        });
        this.mExecutor.execute(aoVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.facebook.imagepipeline.f.d c(InputStream inputStream, int i) throws IOException {
        com.facebook.common.references.a aVar = null;
        try {
            if (i <= 0) {
                aVar = com.facebook.common.references.a.c(this.idU.o(inputStream));
            } else {
                aVar = com.facebook.common.references.a.c(this.idU.a(inputStream, i));
            }
            return new com.facebook.imagepipeline.f.d(aVar);
        } finally {
            com.facebook.common.internal.b.n(inputStream);
            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.facebook.imagepipeline.f.d d(InputStream inputStream, int i) throws IOException {
        return c(inputStream, i);
    }
}
