package com.facebook.imagepipeline.h;

import com.facebook.imagepipeline.g.e;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes25.dex */
public class b implements c {
    private final List<c> nGY;

    public b(Set<c> set) {
        this.nGY = new ArrayList(set.size());
        for (c cVar : set) {
            if (cVar != null) {
                this.nGY.add(cVar);
            }
        }
    }

    public b(c... cVarArr) {
        this.nGY = new ArrayList(cVarArr.length);
        for (c cVar : cVarArr) {
            if (cVar != null) {
                this.nGY.add(cVar);
            }
        }
    }

    public void a(c cVar) {
        this.nGY.add(cVar);
    }

    @Override // com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        int size = this.nGY.size();
        for (int i = 0; i < size; i++) {
            try {
                this.nGY.get(i).a(imageRequest, obj, str, z);
            } catch (Exception e) {
                l("InternalListener exception in onRequestStart", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.am
    public void gA(String str, String str2) {
        int size = this.nGY.size();
        for (int i = 0; i < size; i++) {
            try {
                this.nGY.get(i).gA(str, str2);
            } catch (Exception e) {
                l("InternalListener exception in onProducerStart", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.am
    public void a(String str, String str2, @Nullable Map<String, String> map) {
        int size = this.nGY.size();
        for (int i = 0; i < size; i++) {
            try {
                this.nGY.get(i).a(str, str2, map);
            } catch (Exception e) {
                l("InternalListener exception in onProducerFinishWithSuccess", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.am
    public void a(String str, String str2, Throwable th, @Nullable Map<String, String> map) {
        int size = this.nGY.size();
        for (int i = 0; i < size; i++) {
            try {
                this.nGY.get(i).a(str, str2, th, map);
            } catch (Exception e) {
                l("InternalListener exception in onProducerFinishWithFailure", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.am
    public void a(ImageRequest imageRequest, e eVar, Throwable th, @Nullable Map<String, String> map) {
        int size = this.nGY.size();
        for (int i = 0; i < size; i++) {
            try {
                this.nGY.get(i).a(imageRequest, eVar, th, map);
            } catch (Exception e) {
                l("InternalListener exception in onProducerFinishWithFailure", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.am
    public void b(String str, String str2, @Nullable Map<String, String> map) {
        int size = this.nGY.size();
        for (int i = 0; i < size; i++) {
            try {
                this.nGY.get(i).b(str, str2, map);
            } catch (Exception e) {
                l("InternalListener exception in onProducerFinishWithCancellation", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.am
    public void aA(String str, String str2, String str3) {
        int size = this.nGY.size();
        for (int i = 0; i < size; i++) {
            try {
                this.nGY.get(i).aA(str, str2, str3);
            } catch (Exception e) {
                l("InternalListener exception in onIntermediateChunkStart", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.am
    public void F(String str, String str2, boolean z) {
        int size = this.nGY.size();
        for (int i = 0; i < size; i++) {
            try {
                this.nGY.get(i).F(str, str2, z);
            } catch (Exception e) {
                l("InternalListener exception in onProducerFinishWithSuccess", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, boolean z) {
        int size = this.nGY.size();
        for (int i = 0; i < size; i++) {
            try {
                this.nGY.get(i).a(imageRequest, str, z);
            } catch (Exception e) {
                l("InternalListener exception in onRequestSuccess", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        int size = this.nGY.size();
        for (int i = 0; i < size; i++) {
            try {
                this.nGY.get(i).a(imageRequest, str, th, z);
            } catch (Exception e) {
                l("InternalListener exception in onRequestFailure", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.h.c
    public void Vc(String str) {
        int size = this.nGY.size();
        for (int i = 0; i < size; i++) {
            try {
                this.nGY.get(i).Vc(str);
            } catch (Exception e) {
                l("InternalListener exception in onRequestCancellation", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.am
    public boolean Vh(String str) {
        int size = this.nGY.size();
        for (int i = 0; i < size; i++) {
            if (this.nGY.get(i).Vh(str)) {
                return true;
            }
        }
        return false;
    }

    private void l(String str, Throwable th) {
        com.facebook.common.c.a.e("ForwardingRequestListener", str, th);
    }
}
