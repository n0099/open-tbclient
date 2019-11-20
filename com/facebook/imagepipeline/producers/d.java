package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class d implements aj {
    private final Object kcn;
    private final ImageRequest kkj;
    private final al kkk;
    private final ImageRequest.RequestLevel kkl;
    @GuardedBy("this")
    private boolean kkm;
    @GuardedBy("this")
    private Priority kkn;
    @GuardedBy("this")
    private boolean kko;
    private final String mId;
    @GuardedBy("this")
    private boolean cta = false;
    @GuardedBy("this")
    private final List<ak> mCallbacks = new ArrayList();

    public d(ImageRequest imageRequest, String str, al alVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.kkj = imageRequest;
        this.mId = str;
        this.kkk = alVar;
        this.kcn = obj;
        this.kkl = requestLevel;
        this.kkm = z;
        this.kkn = priority;
        this.kko = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest cIF() {
        return this.kkj;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public al cIG() {
        return this.kkk;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public Object cDZ() {
        return this.kcn;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest.RequestLevel cIH() {
        return this.kkl;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean cII() {
        return this.kkm;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized Priority cIJ() {
        return this.kkn;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean cIK() {
        return this.kko;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(ak akVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(akVar);
            if (this.cta) {
                z = true;
            }
        }
        if (z) {
            akVar.cIM();
        }
    }

    public void cancel() {
        eT(cIL());
    }

    @Nullable
    public synchronized List<ak> sj(boolean z) {
        ArrayList arrayList;
        if (z == this.kkm) {
            arrayList = null;
        } else {
            this.kkm = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.kkn) {
            arrayList = null;
        } else {
            this.kkn = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> sk(boolean z) {
        ArrayList arrayList;
        if (z == this.kko) {
            arrayList = null;
        } else {
            this.kko = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> cIL() {
        ArrayList arrayList;
        if (this.cta) {
            arrayList = null;
        } else {
            this.cta = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void eT(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.cIM();
            }
        }
    }

    public static void eU(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.cIN();
            }
        }
    }

    public static void eV(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.cIO();
            }
        }
    }

    public static void eW(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.cIP();
            }
        }
    }
}
