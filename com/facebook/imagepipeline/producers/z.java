package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
/* loaded from: classes25.dex */
public abstract class z implements aj<com.facebook.imagepipeline.g.e> {
    private final Executor mExecutor;
    private final com.facebook.common.memory.g nDr;

    protected abstract String dZF();

    protected abstract com.facebook.imagepipeline.g.e g(ImageRequest imageRequest) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public z(Executor executor, com.facebook.common.memory.g gVar) {
        this.mExecutor = executor;
        this.nDr = gVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        final am dZw = akVar.dZw();
        final String id = akVar.getId();
        final ImageRequest dZv = akVar.dZv();
        final aq<com.facebook.imagepipeline.g.e> aqVar = new aq<com.facebook.imagepipeline.g.e>(kVar, dZw, dZF(), id) { // from class: com.facebook.imagepipeline.producers.z.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.h
            /* renamed from: dZU */
            public com.facebook.imagepipeline.g.e getResult() throws Exception {
                com.facebook.imagepipeline.g.e g = z.this.g(dZv);
                if (g == null) {
                    dZw.F(id, z.this.dZF(), false);
                    return null;
                }
                g.dYA();
                dZw.F(id, z.this.dZF(), true);
                return g;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            /* renamed from: h */
            public void aR(com.facebook.imagepipeline.g.e eVar) {
                com.facebook.imagepipeline.g.e.e(eVar);
            }
        };
        akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.z.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
            public void dVN() {
                aqVar.cancel();
            }
        });
        this.mExecutor.execute(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.facebook.imagepipeline.g.e d(InputStream inputStream, int i) throws IOException {
        com.facebook.common.references.a aVar = null;
        try {
            if (i <= 0) {
                aVar = com.facebook.common.references.a.e(this.nDr.q(inputStream));
            } else {
                aVar = com.facebook.common.references.a.e(this.nDr.b(inputStream, i));
            }
            return new com.facebook.imagepipeline.g.e(aVar);
        } finally {
            com.facebook.common.internal.b.p(inputStream);
            com.facebook.common.references.a.c(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.facebook.imagepipeline.g.e e(InputStream inputStream, int i) throws IOException {
        return d(inputStream, i);
    }
}
