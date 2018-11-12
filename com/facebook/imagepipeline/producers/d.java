package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class d implements aj {
    private final Object iaJ;
    @GuardedBy("this")
    private boolean iiA;
    private final ImageRequest iiv;
    private final al iiw;
    private final ImageRequest.RequestLevel iix;
    @GuardedBy("this")
    private boolean iiy;
    @GuardedBy("this")
    private Priority iiz;
    private final String mId;
    @GuardedBy("this")
    private boolean aIY = false;
    @GuardedBy("this")
    private final List<ak> mCallbacks = new ArrayList();

    public d(ImageRequest imageRequest, String str, al alVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.iiv = imageRequest;
        this.mId = str;
        this.iiw = alVar;
        this.iaJ = obj;
        this.iix = requestLevel;
        this.iiy = z;
        this.iiz = priority;
        this.iiA = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest bWL() {
        return this.iiv;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public al bWM() {
        return this.iiw;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public Object bSo() {
        return this.iaJ;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest.RequestLevel bWN() {
        return this.iix;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean bWO() {
        return this.iiy;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized Priority bWP() {
        return this.iiz;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean bWQ() {
        return this.iiA;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(ak akVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(akVar);
            if (this.aIY) {
                z = true;
            }
        }
        if (z) {
            akVar.bWS();
        }
    }

    public void cancel() {
        ep(bWR());
    }

    @Nullable
    public synchronized List<ak> oV(boolean z) {
        ArrayList arrayList;
        if (z == this.iiy) {
            arrayList = null;
        } else {
            this.iiy = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.iiz) {
            arrayList = null;
        } else {
            this.iiz = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> oW(boolean z) {
        ArrayList arrayList;
        if (z == this.iiA) {
            arrayList = null;
        } else {
            this.iiA = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> bWR() {
        ArrayList arrayList;
        if (this.aIY) {
            arrayList = null;
        } else {
            this.aIY = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void ep(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.bWS();
            }
        }
    }

    public static void eq(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.bWT();
            }
        }
    }

    public static void er(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.bWU();
            }
        }
    }

    public static void es(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.bWV();
            }
        }
    }
}
