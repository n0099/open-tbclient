package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class d implements aj {
    private final Object jUo;
    private final ImageRequest kce;
    private final al kcf;
    private final ImageRequest.RequestLevel kcg;
    @GuardedBy("this")
    private boolean kch;
    @GuardedBy("this")
    private Priority kci;
    @GuardedBy("this")
    private boolean kcj;
    private final String mId;
    @GuardedBy("this")
    private boolean cdC = false;
    @GuardedBy("this")
    private final List<ak> mCallbacks = new ArrayList();

    public d(ImageRequest imageRequest, String str, al alVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.kce = imageRequest;
        this.mId = str;
        this.kcf = alVar;
        this.jUo = obj;
        this.kcg = requestLevel;
        this.kch = z;
        this.kci = priority;
        this.kcj = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest cHx() {
        return this.kce;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public al cHy() {
        return this.kcf;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public Object cCT() {
        return this.jUo;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest.RequestLevel cHz() {
        return this.kcg;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean cHA() {
        return this.kch;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized Priority cHB() {
        return this.kci;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean cHC() {
        return this.kcj;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(ak akVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(akVar);
            if (this.cdC) {
                z = true;
            }
        }
        if (z) {
            akVar.cHE();
        }
    }

    public void cancel() {
        eE(cHD());
    }

    @Nullable
    public synchronized List<ak> sl(boolean z) {
        ArrayList arrayList;
        if (z == this.kch) {
            arrayList = null;
        } else {
            this.kch = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.kci) {
            arrayList = null;
        } else {
            this.kci = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> sm(boolean z) {
        ArrayList arrayList;
        if (z == this.kcj) {
            arrayList = null;
        } else {
            this.kcj = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> cHD() {
        ArrayList arrayList;
        if (this.cdC) {
            arrayList = null;
        } else {
            this.cdC = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void eE(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.cHE();
            }
        }
    }

    public static void eF(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.cHF();
            }
        }
    }

    public static void eG(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.cHG();
            }
        }
    }

    public static void eH(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.cHH();
            }
        }
    }
}
