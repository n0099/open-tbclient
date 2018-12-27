package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class d implements aj {
    private final Object ilg;
    private final ImageRequest isR;
    private final al isS;
    private final ImageRequest.RequestLevel isT;
    @GuardedBy("this")
    private boolean isU;
    @GuardedBy("this")
    private Priority isV;
    @GuardedBy("this")
    private boolean isW;
    private final String mId;
    @GuardedBy("this")
    private boolean aMA = false;
    @GuardedBy("this")
    private final List<ak> mCallbacks = new ArrayList();

    public d(ImageRequest imageRequest, String str, al alVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.isR = imageRequest;
        this.mId = str;
        this.isS = alVar;
        this.ilg = obj;
        this.isT = requestLevel;
        this.isU = z;
        this.isV = priority;
        this.isW = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest bZH() {
        return this.isR;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public al bZI() {
        return this.isS;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public Object bVk() {
        return this.ilg;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest.RequestLevel bZJ() {
        return this.isT;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean bZK() {
        return this.isU;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized Priority bZL() {
        return this.isV;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean bZM() {
        return this.isW;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(ak akVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(akVar);
            if (this.aMA) {
                z = true;
            }
        }
        if (z) {
            akVar.bZO();
        }
    }

    public void cancel() {
        eu(bZN());
    }

    @Nullable
    public synchronized List<ak> pa(boolean z) {
        ArrayList arrayList;
        if (z == this.isU) {
            arrayList = null;
        } else {
            this.isU = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.isV) {
            arrayList = null;
        } else {
            this.isV = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> pb(boolean z) {
        ArrayList arrayList;
        if (z == this.isW) {
            arrayList = null;
        } else {
            this.isW = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> bZN() {
        ArrayList arrayList;
        if (this.aMA) {
            arrayList = null;
        } else {
            this.aMA = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void eu(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.bZO();
            }
        }
    }

    public static void ev(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.bZP();
            }
        }
    }

    public static void ew(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.bZQ();
            }
        }
    }

    public static void ex(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.bZR();
            }
        }
    }
}
