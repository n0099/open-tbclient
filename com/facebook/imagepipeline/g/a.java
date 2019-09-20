package com.facebook.imagepipeline.g;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements b {
    private final List<b> klQ;

    public a(Set<b> set) {
        this.klQ = new ArrayList(set.size());
        for (b bVar : set) {
            if (bVar != null) {
                this.klQ.add(bVar);
            }
        }
    }

    public a(b... bVarArr) {
        this.klQ = new ArrayList(bVarArr.length);
        for (b bVar : bVarArr) {
            if (bVar != null) {
                this.klQ.add(bVar);
            }
        }
    }

    @Override // com.facebook.imagepipeline.g.b
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        int size = this.klQ.size();
        for (int i = 0; i < size; i++) {
            try {
                this.klQ.get(i).a(imageRequest, obj, str, z);
            } catch (Exception e) {
                l("InternalListener exception in onRequestStart", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.al
    public void eB(String str, String str2) {
        int size = this.klQ.size();
        for (int i = 0; i < size; i++) {
            try {
                this.klQ.get(i).eB(str, str2);
            } catch (Exception e) {
                l("InternalListener exception in onProducerStart", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.al
    public void a(String str, String str2, @Nullable Map<String, String> map) {
        int size = this.klQ.size();
        for (int i = 0; i < size; i++) {
            try {
                this.klQ.get(i).a(str, str2, map);
            } catch (Exception e) {
                l("InternalListener exception in onProducerFinishWithSuccess", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.al
    public void a(String str, String str2, Throwable th, @Nullable Map<String, String> map) {
        int size = this.klQ.size();
        for (int i = 0; i < size; i++) {
            try {
                this.klQ.get(i).a(str, str2, th, map);
            } catch (Exception e) {
                l("InternalListener exception in onProducerFinishWithFailure", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.al
    public void b(String str, String str2, @Nullable Map<String, String> map) {
        int size = this.klQ.size();
        for (int i = 0; i < size; i++) {
            try {
                this.klQ.get(i).b(str, str2, map);
            } catch (Exception e) {
                l("InternalListener exception in onProducerFinishWithCancellation", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.al
    public void ag(String str, String str2, String str3) {
        int size = this.klQ.size();
        for (int i = 0; i < size; i++) {
            try {
                this.klQ.get(i).ag(str, str2, str3);
            } catch (Exception e) {
                l("InternalListener exception in onIntermediateChunkStart", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.g.b
    public void a(ImageRequest imageRequest, String str, boolean z) {
        int size = this.klQ.size();
        for (int i = 0; i < size; i++) {
            try {
                this.klQ.get(i).a(imageRequest, str, z);
            } catch (Exception e) {
                l("InternalListener exception in onRequestSuccess", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.g.b
    public void a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        int size = this.klQ.size();
        for (int i = 0; i < size; i++) {
            try {
                this.klQ.get(i).a(imageRequest, str, th, z);
            } catch (Exception e) {
                l("InternalListener exception in onRequestFailure", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.g.b
    public void Ip(String str) {
        int size = this.klQ.size();
        for (int i = 0; i < size; i++) {
            try {
                this.klQ.get(i).Ip(str);
            } catch (Exception e) {
                l("InternalListener exception in onRequestCancellation", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.al
    public boolean Iq(String str) {
        int size = this.klQ.size();
        for (int i = 0; i < size; i++) {
            if (this.klQ.get(i).Iq(str)) {
                return true;
            }
        }
        return false;
    }

    private void l(String str, Throwable th) {
        com.facebook.common.c.a.e("ForwardingRequestListener", str, th);
    }
}
