package com.facebook.imagepipeline.h;

import com.facebook.imagepipeline.g.e;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class b implements c {
    private final List<c> lPz;

    public b(Set<c> set) {
        this.lPz = new ArrayList(set.size());
        for (c cVar : set) {
            if (cVar != null) {
                this.lPz.add(cVar);
            }
        }
    }

    public b(c... cVarArr) {
        this.lPz = new ArrayList(cVarArr.length);
        for (c cVar : cVarArr) {
            if (cVar != null) {
                this.lPz.add(cVar);
            }
        }
    }

    public void a(c cVar) {
        this.lPz.add(cVar);
    }

    @Override // com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        int size = this.lPz.size();
        for (int i = 0; i < size; i++) {
            try {
                this.lPz.get(i).a(imageRequest, obj, str, z);
            } catch (Exception e) {
                j("InternalListener exception in onRequestStart", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.am
    public void fc(String str, String str2) {
        int size = this.lPz.size();
        for (int i = 0; i < size; i++) {
            try {
                this.lPz.get(i).fc(str, str2);
            } catch (Exception e) {
                j("InternalListener exception in onProducerStart", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.am
    public void a(String str, String str2, @Nullable Map<String, String> map) {
        int size = this.lPz.size();
        for (int i = 0; i < size; i++) {
            try {
                this.lPz.get(i).a(str, str2, map);
            } catch (Exception e) {
                j("InternalListener exception in onProducerFinishWithSuccess", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.am
    public void a(String str, String str2, Throwable th, @Nullable Map<String, String> map) {
        int size = this.lPz.size();
        for (int i = 0; i < size; i++) {
            try {
                this.lPz.get(i).a(str, str2, th, map);
            } catch (Exception e) {
                j("InternalListener exception in onProducerFinishWithFailure", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.am
    public void a(ImageRequest imageRequest, e eVar, Throwable th, @Nullable Map<String, String> map) {
        int size = this.lPz.size();
        for (int i = 0; i < size; i++) {
            try {
                this.lPz.get(i).a(imageRequest, eVar, th, map);
            } catch (Exception e) {
                j("InternalListener exception in onProducerFinishWithFailure", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.am
    public void b(String str, String str2, @Nullable Map<String, String> map) {
        int size = this.lPz.size();
        for (int i = 0; i < size; i++) {
            try {
                this.lPz.get(i).b(str, str2, map);
            } catch (Exception e) {
                j("InternalListener exception in onProducerFinishWithCancellation", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.am
    public void ay(String str, String str2, String str3) {
        int size = this.lPz.size();
        for (int i = 0; i < size; i++) {
            try {
                this.lPz.get(i).ay(str, str2, str3);
            } catch (Exception e) {
                j("InternalListener exception in onIntermediateChunkStart", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.am
    public void C(String str, String str2, boolean z) {
        int size = this.lPz.size();
        for (int i = 0; i < size; i++) {
            try {
                this.lPz.get(i).C(str, str2, z);
            } catch (Exception e) {
                j("InternalListener exception in onProducerFinishWithSuccess", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, boolean z) {
        int size = this.lPz.size();
        for (int i = 0; i < size; i++) {
            try {
                this.lPz.get(i).a(imageRequest, str, z);
            } catch (Exception e) {
                j("InternalListener exception in onRequestSuccess", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        int size = this.lPz.size();
        for (int i = 0; i < size; i++) {
            try {
                this.lPz.get(i).a(imageRequest, str, th, z);
            } catch (Exception e) {
                j("InternalListener exception in onRequestFailure", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.h.c
    public void OB(String str) {
        int size = this.lPz.size();
        for (int i = 0; i < size; i++) {
            try {
                this.lPz.get(i).OB(str);
            } catch (Exception e) {
                j("InternalListener exception in onRequestCancellation", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.am
    public boolean OF(String str) {
        int size = this.lPz.size();
        for (int i = 0; i < size; i++) {
            if (this.lPz.get(i).OF(str)) {
                return true;
            }
        }
        return false;
    }

    private void j(String str, Throwable th) {
        com.facebook.common.c.a.e("ForwardingRequestListener", str, th);
    }
}
