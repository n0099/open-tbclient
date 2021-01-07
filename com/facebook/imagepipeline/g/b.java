package com.facebook.imagepipeline.g;

import com.facebook.imagepipeline.f.e;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class b implements c {
    private final List<c> pEE;

    public b(Set<c> set) {
        this.pEE = new ArrayList(set.size());
        for (c cVar : set) {
            if (cVar != null) {
                this.pEE.add(cVar);
            }
        }
    }

    public b(c... cVarArr) {
        this.pEE = new ArrayList(cVarArr.length);
        for (c cVar : cVarArr) {
            if (cVar != null) {
                this.pEE.add(cVar);
            }
        }
    }

    public void a(c cVar) {
        this.pEE.add(cVar);
    }

    @Override // com.facebook.imagepipeline.g.c
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        int size = this.pEE.size();
        for (int i = 0; i < size; i++) {
            try {
                this.pEE.get(i).a(imageRequest, obj, str, z);
            } catch (Exception e) {
                l("InternalListener exception in onRequestStart", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.am
    public void hn(String str, String str2) {
        int size = this.pEE.size();
        for (int i = 0; i < size; i++) {
            try {
                this.pEE.get(i).hn(str, str2);
            } catch (Exception e) {
                l("InternalListener exception in onProducerStart", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.am
    public void b(String str, String str2, @Nullable Map<String, String> map) {
        int size = this.pEE.size();
        for (int i = 0; i < size; i++) {
            try {
                this.pEE.get(i).b(str, str2, map);
            } catch (Exception e) {
                l("InternalListener exception in onProducerFinishWithSuccess", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.am
    public void a(String str, String str2, Throwable th, @Nullable Map<String, String> map) {
        int size = this.pEE.size();
        for (int i = 0; i < size; i++) {
            try {
                this.pEE.get(i).a(str, str2, th, map);
            } catch (Exception e) {
                l("InternalListener exception in onProducerFinishWithFailure", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.am
    public void a(ImageRequest imageRequest, e eVar, Throwable th, @Nullable Map<String, String> map) {
        int size = this.pEE.size();
        for (int i = 0; i < size; i++) {
            try {
                this.pEE.get(i).a(imageRequest, eVar, th, map);
            } catch (Exception e) {
                l("InternalListener exception in onProducerFinishWithFailure", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.am
    public void c(String str, String str2, @Nullable Map<String, String> map) {
        int size = this.pEE.size();
        for (int i = 0; i < size; i++) {
            try {
                this.pEE.get(i).c(str, str2, map);
            } catch (Exception e) {
                l("InternalListener exception in onProducerFinishWithCancellation", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.am
    public void aW(String str, String str2, String str3) {
        int size = this.pEE.size();
        for (int i = 0; i < size; i++) {
            try {
                this.pEE.get(i).aW(str, str2, str3);
            } catch (Exception e) {
                l("InternalListener exception in onIntermediateChunkStart", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.am
    public void M(String str, String str2, boolean z) {
        int size = this.pEE.size();
        for (int i = 0; i < size; i++) {
            try {
                this.pEE.get(i).M(str, str2, z);
            } catch (Exception e) {
                l("InternalListener exception in onProducerFinishWithSuccess", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.g.c
    public void a(ImageRequest imageRequest, String str, boolean z) {
        int size = this.pEE.size();
        for (int i = 0; i < size; i++) {
            try {
                this.pEE.get(i).a(imageRequest, str, z);
            } catch (Exception e) {
                l("InternalListener exception in onRequestSuccess", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.g.c
    public void a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        int size = this.pEE.size();
        for (int i = 0; i < size; i++) {
            try {
                this.pEE.get(i).a(imageRequest, str, th, z);
            } catch (Exception e) {
                l("InternalListener exception in onRequestFailure", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.g.c
    public void Zx(String str) {
        int size = this.pEE.size();
        for (int i = 0; i < size; i++) {
            try {
                this.pEE.get(i).Zx(str);
            } catch (Exception e) {
                l("InternalListener exception in onRequestCancellation", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.am
    public boolean ZA(String str) {
        int size = this.pEE.size();
        for (int i = 0; i < size; i++) {
            if (this.pEE.get(i).ZA(str)) {
                return true;
            }
        }
        return false;
    }

    private void l(String str, Throwable th) {
        com.facebook.common.c.a.e("ForwardingRequestListener", str, th);
    }
}
