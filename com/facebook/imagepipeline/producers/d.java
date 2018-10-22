package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class d implements aj {
    private final Object hYZ;
    private final ImageRequest igL;
    private final al igM;
    private final ImageRequest.RequestLevel igN;
    @GuardedBy("this")
    private boolean igO;
    @GuardedBy("this")
    private Priority igP;
    @GuardedBy("this")
    private boolean igQ;
    private final String mId;
    @GuardedBy("this")
    private boolean aIi = false;
    @GuardedBy("this")
    private final List<ak> mCallbacks = new ArrayList();

    public d(ImageRequest imageRequest, String str, al alVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.igL = imageRequest;
        this.mId = str;
        this.igM = alVar;
        this.hYZ = obj;
        this.igN = requestLevel;
        this.igO = z;
        this.igP = priority;
        this.igQ = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest bXq() {
        return this.igL;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public al bXr() {
        return this.igM;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public Object bST() {
        return this.hYZ;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest.RequestLevel bXs() {
        return this.igN;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean bXt() {
        return this.igO;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized Priority bXu() {
        return this.igP;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean bXv() {
        return this.igQ;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(ak akVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(akVar);
            if (this.aIi) {
                z = true;
            }
        }
        if (z) {
            akVar.bXx();
        }
    }

    public void cancel() {
        er(bXw());
    }

    @Nullable
    public synchronized List<ak> oH(boolean z) {
        ArrayList arrayList;
        if (z == this.igO) {
            arrayList = null;
        } else {
            this.igO = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.igP) {
            arrayList = null;
        } else {
            this.igP = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> oI(boolean z) {
        ArrayList arrayList;
        if (z == this.igQ) {
            arrayList = null;
        } else {
            this.igQ = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> bXw() {
        ArrayList arrayList;
        if (this.aIi) {
            arrayList = null;
        } else {
            this.aIi = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void er(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.bXx();
            }
        }
    }

    public static void es(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.bXy();
            }
        }
    }

    public static void et(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.bXz();
            }
        }
    }

    public static void eu(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.bXA();
            }
        }
    }
}
