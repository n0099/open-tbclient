package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class d implements aj {
    private final Object jUl;
    private final ImageRequest kcb;
    private final al kcc;
    private final ImageRequest.RequestLevel kcd;
    @GuardedBy("this")
    private boolean kce;
    @GuardedBy("this")
    private Priority kcf;
    @GuardedBy("this")
    private boolean kcg;
    private final String mId;
    @GuardedBy("this")
    private boolean cdB = false;
    @GuardedBy("this")
    private final List<ak> mCallbacks = new ArrayList();

    public d(ImageRequest imageRequest, String str, al alVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.kcb = imageRequest;
        this.mId = str;
        this.kcc = alVar;
        this.jUl = obj;
        this.kcd = requestLevel;
        this.kce = z;
        this.kcf = priority;
        this.kcg = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest cHy() {
        return this.kcb;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public al cHz() {
        return this.kcc;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public Object cCU() {
        return this.jUl;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest.RequestLevel cHA() {
        return this.kcd;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean cHB() {
        return this.kce;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized Priority cHC() {
        return this.kcf;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean cHD() {
        return this.kcg;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(ak akVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(akVar);
            if (this.cdB) {
                z = true;
            }
        }
        if (z) {
            akVar.cHF();
        }
    }

    public void cancel() {
        eE(cHE());
    }

    @Nullable
    public synchronized List<ak> sk(boolean z) {
        ArrayList arrayList;
        if (z == this.kce) {
            arrayList = null;
        } else {
            this.kce = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.kcf) {
            arrayList = null;
        } else {
            this.kcf = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> sl(boolean z) {
        ArrayList arrayList;
        if (z == this.kcg) {
            arrayList = null;
        } else {
            this.kcg = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> cHE() {
        ArrayList arrayList;
        if (this.cdB) {
            arrayList = null;
        } else {
            this.cdB = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void eE(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.cHF();
            }
        }
    }

    public static void eF(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.cHG();
            }
        }
    }

    public static void eG(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.cHH();
            }
        }
    }

    public static void eH(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.cHI();
            }
        }
    }
}
