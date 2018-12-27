package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
public class ab implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final Executor mExecutor;

    public ab(Executor executor) {
        this.mExecutor = executor;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        al bZI = ajVar.bZI();
        String id = ajVar.getId();
        final ImageRequest bZH = ajVar.bZH();
        final ao<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aoVar = new ao<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>(jVar, bZI, "VideoThumbnailProducer", id) { // from class: com.facebook.imagepipeline.producers.ab.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.e
            /* renamed from: bYD */
            public com.facebook.common.references.a<com.facebook.imagepipeline.f.b> getResult() throws Exception {
                Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(bZH.caD().getPath(), ab.i(bZH));
                if (createVideoThumbnail == null) {
                    return null;
                }
                return com.facebook.common.references.a.c(new com.facebook.imagepipeline.f.c(createVideoThumbnail, com.facebook.imagepipeline.b.g.bWt(), com.facebook.imagepipeline.f.f.irP, 0));
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.ao
            /* renamed from: i */
            public Map<String, String> aM(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar) {
                return ImmutableMap.of("createdThumbnail", String.valueOf(aVar != null));
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.ao, com.facebook.common.b.e
            /* renamed from: j */
            public void an(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar) {
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar);
            }
        };
        ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ab.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
            public void bZO() {
                aoVar.cancel();
            }
        });
        this.mExecutor.execute(aoVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int i(ImageRequest imageRequest) {
        return (imageRequest.getPreferredWidth() > 96 || imageRequest.getPreferredHeight() > 96) ? 1 : 3;
    }
}
