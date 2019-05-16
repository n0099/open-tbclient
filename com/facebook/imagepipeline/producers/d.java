package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class d implements aj {
    private final Object jUk;
    private final ImageRequest kca;
    private final al kcb;
    private final ImageRequest.RequestLevel kcc;
    @GuardedBy("this")
    private boolean kcd;
    @GuardedBy("this")
    private Priority kce;
    @GuardedBy("this")
    private boolean kcf;
    private final String mId;
    @GuardedBy("this")
    private boolean cdB = false;
    @GuardedBy("this")
    private final List<ak> mCallbacks = new ArrayList();

    public d(ImageRequest imageRequest, String str, al alVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.kca = imageRequest;
        this.mId = str;
        this.kcb = alVar;
        this.jUk = obj;
        this.kcc = requestLevel;
        this.kcd = z;
        this.kce = priority;
        this.kcf = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest cHw() {
        return this.kca;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public al cHx() {
        return this.kcb;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public Object cCS() {
        return this.jUk;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest.RequestLevel cHy() {
        return this.kcc;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean cHz() {
        return this.kcd;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized Priority cHA() {
        return this.kce;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean cHB() {
        return this.kcf;
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
            akVar.cHD();
        }
    }

    public void cancel() {
        eE(cHC());
    }

    @Nullable
    public synchronized List<ak> sk(boolean z) {
        ArrayList arrayList;
        if (z == this.kcd) {
            arrayList = null;
        } else {
            this.kcd = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.kce) {
            arrayList = null;
        } else {
            this.kce = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> sl(boolean z) {
        ArrayList arrayList;
        if (z == this.kcf) {
            arrayList = null;
        } else {
            this.kcf = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> cHC() {
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
                akVar.cHD();
            }
        }
    }

    public static void eF(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.cHE();
            }
        }
    }

    public static void eG(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.cHF();
            }
        }
    }

    public static void eH(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.cHG();
            }
        }
    }
}
