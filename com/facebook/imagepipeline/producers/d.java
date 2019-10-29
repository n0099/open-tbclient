package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class d implements aj {
    private final Object kde;
    private final ImageRequest kla;
    private final al klb;
    private final ImageRequest.RequestLevel klc;
    @GuardedBy("this")
    private boolean kld;
    @GuardedBy("this")
    private Priority kle;
    @GuardedBy("this")
    private boolean klf;
    private final String mId;
    @GuardedBy("this")
    private boolean ctR = false;
    @GuardedBy("this")
    private final List<ak> mCallbacks = new ArrayList();

    public d(ImageRequest imageRequest, String str, al alVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.kla = imageRequest;
        this.mId = str;
        this.klb = alVar;
        this.kde = obj;
        this.klc = requestLevel;
        this.kld = z;
        this.kle = priority;
        this.klf = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest cIH() {
        return this.kla;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public al cII() {
        return this.klb;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public Object cEb() {
        return this.kde;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest.RequestLevel cIJ() {
        return this.klc;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean cIK() {
        return this.kld;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized Priority cIL() {
        return this.kle;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean cIM() {
        return this.klf;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(ak akVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(akVar);
            if (this.ctR) {
                z = true;
            }
        }
        if (z) {
            akVar.cIO();
        }
    }

    public void cancel() {
        eT(cIN());
    }

    @Nullable
    public synchronized List<ak> sj(boolean z) {
        ArrayList arrayList;
        if (z == this.kld) {
            arrayList = null;
        } else {
            this.kld = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.kle) {
            arrayList = null;
        } else {
            this.kle = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> sk(boolean z) {
        ArrayList arrayList;
        if (z == this.klf) {
            arrayList = null;
        } else {
            this.klf = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> cIN() {
        ArrayList arrayList;
        if (this.ctR) {
            arrayList = null;
        } else {
            this.ctR = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void eT(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.cIO();
            }
        }
    }

    public static void eU(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.cIP();
            }
        }
    }

    public static void eV(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.cIQ();
            }
        }
    }

    public static void eW(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.cIR();
            }
        }
    }
}
