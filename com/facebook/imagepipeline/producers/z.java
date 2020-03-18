package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
/* loaded from: classes12.dex */
public abstract class z implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.common.memory.g lSj;
    private final Executor mExecutor;

    protected abstract String dsf();

    protected abstract com.facebook.imagepipeline.g.e h(ImageRequest imageRequest) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public z(Executor executor, com.facebook.common.memory.g gVar) {
        this.mExecutor = executor;
        this.lSj = gVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        final am drW = akVar.drW();
        final String id = akVar.getId();
        final ImageRequest drV = akVar.drV();
        final aq<com.facebook.imagepipeline.g.e> aqVar = new aq<com.facebook.imagepipeline.g.e>(kVar, drW, dsf(), id) { // from class: com.facebook.imagepipeline.producers.z.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.h
            /* renamed from: dsu */
            public com.facebook.imagepipeline.g.e getResult() throws Exception {
                com.facebook.imagepipeline.g.e h = z.this.h(drV);
                if (h == null) {
                    drW.D(id, z.this.dsf(), false);
                    return null;
                }
                h.dqZ();
                drW.D(id, z.this.dsf(), true);
                return h;
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
            public void don() {
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
                aVar = com.facebook.common.references.a.b(this.lSj.s(inputStream));
            } else {
                aVar = com.facebook.common.references.a.b(this.lSj.c(inputStream, i));
            }
            return new com.facebook.imagepipeline.g.e(aVar);
        } finally {
            com.facebook.common.internal.b.r(inputStream);
            com.facebook.common.references.a.c(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.facebook.imagepipeline.g.e f(InputStream inputStream, int i) throws IOException {
        return e(inputStream, i);
    }
}
