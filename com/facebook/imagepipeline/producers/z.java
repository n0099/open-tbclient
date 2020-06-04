package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
/* loaded from: classes12.dex */
public abstract class z implements aj<com.facebook.imagepipeline.g.e> {
    private final Executor mExecutor;
    private final com.facebook.common.memory.g mvb;

    protected abstract String dBG();

    protected abstract com.facebook.imagepipeline.g.e g(ImageRequest imageRequest) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public z(Executor executor, com.facebook.common.memory.g gVar) {
        this.mExecutor = executor;
        this.mvb = gVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        final am dBx = akVar.dBx();
        final String id = akVar.getId();
        final ImageRequest dBw = akVar.dBw();
        final aq<com.facebook.imagepipeline.g.e> aqVar = new aq<com.facebook.imagepipeline.g.e>(kVar, dBx, dBG(), id) { // from class: com.facebook.imagepipeline.producers.z.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.h
            /* renamed from: dBV */
            public com.facebook.imagepipeline.g.e getResult() throws Exception {
                com.facebook.imagepipeline.g.e g = z.this.g(dBw);
                if (g == null) {
                    dBx.F(id, z.this.dBG(), false);
                    return null;
                }
                g.dAB();
                dBx.F(id, z.this.dBG(), true);
                return g;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            /* renamed from: h */
            public void aM(com.facebook.imagepipeline.g.e eVar) {
                com.facebook.imagepipeline.g.e.e(eVar);
            }
        };
        akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.z.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
            public void dxO() {
                aqVar.cancel();
            }
        });
        this.mExecutor.execute(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.facebook.imagepipeline.g.e e(InputStream inputStream, int i) throws IOException {
        com.facebook.common.references.a aVar = null;
        try {
            if (i <= 0) {
                aVar = com.facebook.common.references.a.e(this.mvb.q(inputStream));
            } else {
                aVar = com.facebook.common.references.a.e(this.mvb.c(inputStream, i));
            }
            return new com.facebook.imagepipeline.g.e(aVar);
        } finally {
            com.facebook.common.internal.b.p(inputStream);
            com.facebook.common.references.a.c(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.facebook.imagepipeline.g.e f(InputStream inputStream, int i) throws IOException {
        return e(inputStream, i);
    }
}
