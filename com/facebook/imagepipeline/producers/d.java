package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class d implements aj {
    private final Object jBv;
    private final ImageRequest jJn;
    private final al jJo;
    private final ImageRequest.RequestLevel jJp;
    @GuardedBy("this")
    private boolean jJq;
    @GuardedBy("this")
    private Priority jJr;
    @GuardedBy("this")
    private boolean jJs;
    private final String mId;
    @GuardedBy("this")
    private boolean bVG = false;
    @GuardedBy("this")
    private final List<ak> mCallbacks = new ArrayList();

    public d(ImageRequest imageRequest, String str, al alVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.jJn = imageRequest;
        this.mId = str;
        this.jJo = alVar;
        this.jBv = obj;
        this.jJp = requestLevel;
        this.jJq = z;
        this.jJr = priority;
        this.jJs = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest czA() {
        return this.jJn;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public al czB() {
        return this.jJo;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public Object cuW() {
        return this.jBv;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest.RequestLevel czC() {
        return this.jJp;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean czD() {
        return this.jJq;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized Priority czE() {
        return this.jJr;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean czF() {
        return this.jJs;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(ak akVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(akVar);
            if (this.bVG) {
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
        if (z == this.jJq) {
            arrayList = null;
        } else {
            this.jJq = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.jJr) {
            arrayList = null;
        } else {
            this.jJr = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> rw(boolean z) {
        ArrayList arrayList;
        if (z == this.jJs) {
            arrayList = null;
        } else {
            this.jJs = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> czG() {
        ArrayList arrayList;
        if (this.bVG) {
            arrayList = null;
        } else {
            this.bVG = true;
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
