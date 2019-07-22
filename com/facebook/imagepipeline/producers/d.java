package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class d implements aj {
    private final Object kbs;
    private final ImageRequest kjl;
    private final al kjm;
    private final ImageRequest.RequestLevel kjn;
    @GuardedBy("this")
    private boolean kjo;
    @GuardedBy("this")
    private Priority kjp;
    @GuardedBy("this")
    private boolean kjq;
    private final String mId;
    @GuardedBy("this")
    private boolean ceF = false;
    @GuardedBy("this")
    private final List<ak> mCallbacks = new ArrayList();

    public d(ImageRequest imageRequest, String str, al alVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.kjl = imageRequest;
        this.mId = str;
        this.kjm = alVar;
        this.kbs = obj;
        this.kjn = requestLevel;
        this.kjo = z;
        this.kjp = priority;
        this.kjq = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest cKB() {
        return this.kjl;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public al cKC() {
        return this.kjm;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public Object cFU() {
        return this.kbs;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest.RequestLevel cKD() {
        return this.kjn;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean cKE() {
        return this.kjo;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized Priority cKF() {
        return this.kjp;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean cKG() {
        return this.kjq;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(ak akVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(akVar);
            if (this.ceF) {
                z = true;
            }
        }
        if (z) {
            akVar.cKI();
        }
    }

    public void cancel() {
        eH(cKH());
    }

    @Nullable
    public synchronized List<ak> sA(boolean z) {
        ArrayList arrayList;
        if (z == this.kjo) {
            arrayList = null;
        } else {
            this.kjo = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.kjp) {
            arrayList = null;
        } else {
            this.kjp = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> sB(boolean z) {
        ArrayList arrayList;
        if (z == this.kjq) {
            arrayList = null;
        } else {
            this.kjq = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> cKH() {
        ArrayList arrayList;
        if (this.ceF) {
            arrayList = null;
        } else {
            this.ceF = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void eH(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.cKI();
            }
        }
    }

    public static void eI(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.cKJ();
            }
        }
    }

    public static void eJ(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.cKK();
            }
        }
    }

    public static void eK(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.cKL();
            }
        }
    }
}
