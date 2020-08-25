package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes8.dex */
public class d implements ak {
    @GuardedBy("this")
    private boolean ezd = false;
    @GuardedBy("this")
    private final List<al> mCallbacks = new ArrayList();
    private final String mId;
    private final Object nmD;
    private final ImageRequest nmE;
    @GuardedBy("this")
    private boolean nmO;
    private final am nxN;
    private final ImageRequest.RequestLevel nxO;
    @GuardedBy("this")
    private Priority nxP;
    @GuardedBy("this")
    private boolean nxQ;

    public d(ImageRequest imageRequest, String str, am amVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.nmE = imageRequest;
        this.mId = str;
        this.nxN = amVar;
        this.nmD = obj;
        this.nxO = requestLevel;
        this.nmO = z;
        this.nxP = priority;
        this.nxQ = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest dVo() {
        return this.nmE;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public am dVp() {
        return this.nxN;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public Object dPU() {
        return this.nmD;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest.RequestLevel dVq() {
        return this.nxO;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean dVr() {
        return this.nmO;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized Priority dVs() {
        return this.nxP;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean dVt() {
        return this.nxQ;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public void a(al alVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(alVar);
            if (this.ezd) {
                z = true;
            }
        }
        if (z) {
            alVar.dRG();
        }
    }

    public void cancel() {
        fK(dVu());
    }

    @Nullable
    public synchronized List<al> ye(boolean z) {
        ArrayList arrayList;
        if (z == this.nmO) {
            arrayList = null;
        } else {
            this.nmO = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.nxP) {
            arrayList = null;
        } else {
            this.nxP = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> yf(boolean z) {
        ArrayList arrayList;
        if (z == this.nxQ) {
            arrayList = null;
        } else {
            this.nxQ = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> dVu() {
        ArrayList arrayList;
        if (this.ezd) {
            arrayList = null;
        } else {
            this.ezd = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void fK(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dRG();
            }
        }
    }

    public static void fL(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dVv();
            }
        }
    }

    public static void fM(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dVw();
            }
        }
    }

    public static void fN(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dVx();
            }
        }
    }
}
