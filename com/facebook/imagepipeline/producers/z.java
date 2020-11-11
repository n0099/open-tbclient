package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
/* loaded from: classes18.dex */
public abstract class z implements aj<com.facebook.imagepipeline.g.e> {
    private final Executor mExecutor;
    private final com.facebook.common.memory.g oTv;

    protected abstract String erf();

    protected abstract com.facebook.imagepipeline.g.e g(ImageRequest imageRequest) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public z(Executor executor, com.facebook.common.memory.g gVar) {
        this.mExecutor = executor;
        this.oTv = gVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        final am eqW = akVar.eqW();
        final String id = akVar.getId();
        final ImageRequest eqV = akVar.eqV();
        final aq<com.facebook.imagepipeline.g.e> aqVar = new aq<com.facebook.imagepipeline.g.e>(kVar, eqW, erf(), id) { // from class: com.facebook.imagepipeline.producers.z.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.h
            /* renamed from: eru */
            public com.facebook.imagepipeline.g.e getResult() throws Exception {
                com.facebook.imagepipeline.g.e g = z.this.g(eqV);
                if (g == null) {
                    eqW.H(id, z.this.erf(), false);
                    return null;
                }
                g.eqa();
                eqW.H(id, z.this.erf(), true);
                return g;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            /* renamed from: h */
            public void aY(com.facebook.imagepipeline.g.e eVar) {
                com.facebook.imagepipeline.g.e.e(eVar);
            }
        };
        akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.z.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
            public void enm() {
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
                aVar = com.facebook.common.references.a.e(this.oTv.r(inputStream));
            } else {
                aVar = com.facebook.common.references.a.e(this.oTv.b(inputStream, i));
            }
            return new com.facebook.imagepipeline.g.e(aVar);
        } finally {
            com.facebook.common.internal.b.q(inputStream);
            com.facebook.common.references.a.c(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.facebook.imagepipeline.g.e e(InputStream inputStream, int i) throws IOException {
        return d(inputStream, i);
    }
}
