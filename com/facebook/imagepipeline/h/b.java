package com.facebook.imagepipeline.h;

import com.facebook.imagepipeline.g.e;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class b implements c {
    private final List<c> mdF;

    public b(Set<c> set) {
        this.mdF = new ArrayList(set.size());
        for (c cVar : set) {
            if (cVar != null) {
                this.mdF.add(cVar);
            }
        }
    }

    public b(c... cVarArr) {
        this.mdF = new ArrayList(cVarArr.length);
        for (c cVar : cVarArr) {
            if (cVar != null) {
                this.mdF.add(cVar);
            }
        }
    }

    public void a(c cVar) {
        this.mdF.add(cVar);
    }

    @Override // com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        int size = this.mdF.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mdF.get(i).a(imageRequest, obj, str, z);
            } catch (Exception e) {
                k("InternalListener exception in onRequestStart", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.am
    public void fi(String str, String str2) {
        int size = this.mdF.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mdF.get(i).fi(str, str2);
            } catch (Exception e) {
                k("InternalListener exception in onProducerStart", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.am
    public void a(String str, String str2, @Nullable Map<String, String> map) {
        int size = this.mdF.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mdF.get(i).a(str, str2, map);
            } catch (Exception e) {
                k("InternalListener exception in onProducerFinishWithSuccess", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.am
    public void a(String str, String str2, Throwable th, @Nullable Map<String, String> map) {
        int size = this.mdF.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mdF.get(i).a(str, str2, th, map);
            } catch (Exception e) {
                k("InternalListener exception in onProducerFinishWithFailure", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.am
    public void a(ImageRequest imageRequest, e eVar, Throwable th, @Nullable Map<String, String> map) {
        int size = this.mdF.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mdF.get(i).a(imageRequest, eVar, th, map);
            } catch (Exception e) {
                k("InternalListener exception in onProducerFinishWithFailure", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.am
    public void b(String str, String str2, @Nullable Map<String, String> map) {
        int size = this.mdF.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mdF.get(i).b(str, str2, map);
            } catch (Exception e) {
                k("InternalListener exception in onProducerFinishWithCancellation", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.am
    public void aw(String str, String str2, String str3) {
        int size = this.mdF.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mdF.get(i).aw(str, str2, str3);
            } catch (Exception e) {
                k("InternalListener exception in onIntermediateChunkStart", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.am
    public void D(String str, String str2, boolean z) {
        int size = this.mdF.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mdF.get(i).D(str, str2, z);
            } catch (Exception e) {
                k("InternalListener exception in onProducerFinishWithSuccess", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, boolean z) {
        int size = this.mdF.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mdF.get(i).a(imageRequest, str, z);
            } catch (Exception e) {
                k("InternalListener exception in onRequestSuccess", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        int size = this.mdF.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mdF.get(i).a(imageRequest, str, th, z);
            } catch (Exception e) {
                k("InternalListener exception in onRequestFailure", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.h.c
    public void Oj(String str) {
        int size = this.mdF.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mdF.get(i).Oj(str);
            } catch (Exception e) {
                k("InternalListener exception in onRequestCancellation", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.am
    public boolean Oo(String str) {
        int size = this.mdF.size();
        for (int i = 0; i < size; i++) {
            if (this.mdF.get(i).Oo(str)) {
                return true;
            }
        }
        return false;
    }

    private void k(String str, Throwable th) {
        com.facebook.common.c.a.e("ForwardingRequestListener", str, th);
    }
}
