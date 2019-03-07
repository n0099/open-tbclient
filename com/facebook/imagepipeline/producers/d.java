package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class d implements aj {
    private final Object jBP;
    private final ImageRequest jJH;
    private final al jJI;
    private final ImageRequest.RequestLevel jJJ;
    @GuardedBy("this")
    private boolean jJK;
    @GuardedBy("this")
    private Priority jJL;
    @GuardedBy("this")
    private boolean jJM;
    private final String mId;
    @GuardedBy("this")
    private boolean bVC = false;
    @GuardedBy("this")
    private final List<ak> mCallbacks = new ArrayList();

    public d(ImageRequest imageRequest, String str, al alVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.jJH = imageRequest;
        this.mId = str;
        this.jJI = alVar;
        this.jBP = obj;
        this.jJJ = requestLevel;
        this.jJK = z;
        this.jJL = priority;
        this.jJM = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest czu() {
        return this.jJH;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public al czv() {
        return this.jJI;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public Object cuQ() {
        return this.jBP;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest.RequestLevel czw() {
        return this.jJJ;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean czx() {
        return this.jJK;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized Priority czy() {
        return this.jJL;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean czz() {
        return this.jJM;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(ak akVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(akVar);
            if (this.bVC) {
                z = true;
            }
        }
        if (z) {
            akVar.czB();
        }
    }

    public void cancel() {
        ez(czA());
    }

    @Nullable
    public synchronized List<ak> rv(boolean z) {
        ArrayList arrayList;
        if (z == this.jJK) {
            arrayList = null;
        } else {
            this.jJK = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.jJL) {
            arrayList = null;
        } else {
            this.jJL = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> rw(boolean z) {
        ArrayList arrayList;
        if (z == this.jJM) {
            arrayList = null;
        } else {
            this.jJM = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> czA() {
        ArrayList arrayList;
        if (this.bVC) {
            arrayList = null;
        } else {
            this.bVC = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void ez(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.czB();
            }
        }
    }

    public static void eA(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.czC();
            }
        }
    }

    public static void eB(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.czD();
            }
        }
    }

    public static void eC(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.czE();
            }
        }
    }
}
