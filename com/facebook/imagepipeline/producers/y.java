package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
public abstract class y implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.common.memory.g kfD;
    private final Executor mExecutor;

    protected abstract String cIQ();

    protected abstract com.facebook.imagepipeline.f.d h(ImageRequest imageRequest) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public y(Executor executor, com.facebook.common.memory.g gVar) {
        this.mExecutor = executor;
        this.kfD = gVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        al cIG = ajVar.cIG();
        String id = ajVar.getId();
        final ImageRequest cIF = ajVar.cIF();
        final ao<com.facebook.imagepipeline.f.d> aoVar = new ao<com.facebook.imagepipeline.f.d>(jVar, cIG, cIQ(), id) { // from class: com.facebook.imagepipeline.producers.y.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.e
            /* renamed from: cJc */
            public com.facebook.imagepipeline.f.d getResult() throws Exception {
                com.facebook.imagepipeline.f.d h = y.this.h(cIF);
                if (h == null) {
                    return null;
                }
                h.cHP();
                return h;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.ao, com.facebook.common.b.e
            /* renamed from: h */
            public void aw(com.facebook.imagepipeline.f.d dVar) {
                com.facebook.imagepipeline.f.d.e(dVar);
            }
        };
        ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.y.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
            public void cIM() {
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
                aVar = com.facebook.common.references.a.c(this.kfD.o(inputStream));
            } else {
                aVar = com.facebook.common.references.a.c(this.kfD.b(inputStream, i));
            }
            return new com.facebook.imagepipeline.f.d(aVar);
        } finally {
            com.facebook.common.internal.b.n(inputStream);
            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.facebook.imagepipeline.f.d e(InputStream inputStream, int i) throws IOException {
        return d(inputStream, i);
    }
}
