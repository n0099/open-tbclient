package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class d implements aj {
    private final Object hYY;
    private final ImageRequest igK;
    private final al igL;
    private final ImageRequest.RequestLevel igM;
    @GuardedBy("this")
    private boolean igN;
    @GuardedBy("this")
    private Priority igO;
    @GuardedBy("this")
    private boolean igP;
    private final String mId;
    @GuardedBy("this")
    private boolean aIi = false;
    @GuardedBy("this")
    private final List<ak> mCallbacks = new ArrayList();

    public d(ImageRequest imageRequest, String str, al alVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.igK = imageRequest;
        this.mId = str;
        this.igL = alVar;
        this.hYY = obj;
        this.igM = requestLevel;
        this.igN = z;
        this.igO = priority;
        this.igP = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest bXq() {
        return this.igK;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public al bXr() {
        return this.igL;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public Object bST() {
        return this.hYY;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest.RequestLevel bXs() {
        return this.igM;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean bXt() {
        return this.igN;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized Priority bXu() {
        return this.igO;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean bXv() {
        return this.igP;
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
        if (z == this.igN) {
            arrayList = null;
        } else {
            this.igN = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.igO) {
            arrayList = null;
        } else {
            this.igO = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> oI(boolean z) {
        ArrayList arrayList;
        if (z == this.igP) {
            arrayList = null;
        } else {
            this.igP = z;
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
