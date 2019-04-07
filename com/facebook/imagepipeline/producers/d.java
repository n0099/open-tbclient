package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class d implements aj {
    private final Object jBu;
    private final ImageRequest jJm;
    private final al jJn;
    private final ImageRequest.RequestLevel jJo;
    @GuardedBy("this")
    private boolean jJp;
    @GuardedBy("this")
    private Priority jJq;
    @GuardedBy("this")
    private boolean jJr;
    private final String mId;
    @GuardedBy("this")
    private boolean bVF = false;
    @GuardedBy("this")
    private final List<ak> mCallbacks = new ArrayList();

    public d(ImageRequest imageRequest, String str, al alVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.jJm = imageRequest;
        this.mId = str;
        this.jJn = alVar;
        this.jBu = obj;
        this.jJo = requestLevel;
        this.jJp = z;
        this.jJq = priority;
        this.jJr = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest czA() {
        return this.jJm;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public al czB() {
        return this.jJn;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public Object cuW() {
        return this.jBu;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest.RequestLevel czC() {
        return this.jJo;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean czD() {
        return this.jJp;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized Priority czE() {
        return this.jJq;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean czF() {
        return this.jJr;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(ak akVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(akVar);
            if (this.bVF) {
                z = true;
            }
        }
        if (z) {
            akVar.czH();
        }
    }

    public void cancel() {
        ew(czG());
    }

    @Nullable
    public synchronized List<ak> rv(boolean z) {
        ArrayList arrayList;
        if (z == this.jJp) {
            arrayList = null;
        } else {
            this.jJp = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.jJq) {
            arrayList = null;
        } else {
            this.jJq = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> rw(boolean z) {
        ArrayList arrayList;
        if (z == this.jJr) {
            arrayList = null;
        } else {
            this.jJr = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> czG() {
        ArrayList arrayList;
        if (this.bVF) {
            arrayList = null;
        } else {
            this.bVF = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void ew(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.czH();
            }
        }
    }

    public static void ex(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.czI();
            }
        }
    }

    public static void ey(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.czJ();
            }
        }
    }

    public static void ez(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.czK();
            }
        }
    }
}
