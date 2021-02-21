package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
/* loaded from: classes5.dex */
public abstract class z implements aj<com.facebook.imagepipeline.f.e> {
    private final Executor mExecutor;
    private final com.facebook.common.memory.g pHk;

    protected abstract String ezA();

    protected abstract com.facebook.imagepipeline.f.e g(ImageRequest imageRequest) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public z(Executor executor, com.facebook.common.memory.g gVar) {
        this.mExecutor = executor;
        this.pHk = gVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        final am ezq = akVar.ezq();
        final String id = akVar.getId();
        final ImageRequest ezp = akVar.ezp();
        final aq<com.facebook.imagepipeline.f.e> aqVar = new aq<com.facebook.imagepipeline.f.e>(kVar, ezq, ezA(), id) { // from class: com.facebook.imagepipeline.producers.z.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.h
            /* renamed from: ezO */
            public com.facebook.imagepipeline.f.e getResult() throws Exception {
                com.facebook.imagepipeline.f.e g = z.this.g(ezp);
                if (g == null) {
                    ezq.M(id, z.this.ezA(), false);
                    return null;
                }
                g.eyy();
                ezq.M(id, z.this.ezA(), true);
                return g;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            /* renamed from: h */
            public void ba(com.facebook.imagepipeline.f.e eVar) {
                com.facebook.imagepipeline.f.e.e(eVar);
            }
        };
        akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.z.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
            public void ezw() {
                aqVar.cancel();
            }
        });
        this.mExecutor.execute(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.facebook.imagepipeline.f.e d(InputStream inputStream, int i) throws IOException {
        com.facebook.common.references.a aVar = null;
        try {
            if (i <= 0) {
                aVar = com.facebook.common.references.a.e(this.pHk.s(inputStream));
            } else {
                aVar = com.facebook.common.references.a.e(this.pHk.b(inputStream, i));
            }
            return new com.facebook.imagepipeline.f.e(aVar);
        } finally {
            com.facebook.common.internal.b.r(inputStream);
            com.facebook.common.references.a.c(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.facebook.imagepipeline.f.e e(InputStream inputStream, int i) throws IOException {
        return d(inputStream, i);
    }
}
