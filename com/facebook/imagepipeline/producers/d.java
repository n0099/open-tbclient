package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class d implements aj {
    private final Object jCa;
    private final ImageRequest jJS;
    private final al jJT;
    private final ImageRequest.RequestLevel jJU;
    @GuardedBy("this")
    private boolean jJV;
    @GuardedBy("this")
    private Priority jJW;
    @GuardedBy("this")
    private boolean jJX;
    private final String mId;
    @GuardedBy("this")
    private boolean bVD = false;
    @GuardedBy("this")
    private final List<ak> mCallbacks = new ArrayList();

    public d(ImageRequest imageRequest, String str, al alVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.jJS = imageRequest;
        this.mId = str;
        this.jJT = alVar;
        this.jCa = obj;
        this.jJU = requestLevel;
        this.jJV = z;
        this.jJW = priority;
        this.jJX = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest czH() {
        return this.jJS;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public al czI() {
        return this.jJT;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public Object cvd() {
        return this.jCa;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest.RequestLevel czJ() {
        return this.jJU;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean czK() {
        return this.jJV;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized Priority czL() {
        return this.jJW;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean czM() {
        return this.jJX;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(ak akVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(akVar);
            if (this.bVD) {
                z = true;
            }
        }
        if (z) {
            akVar.czO();
        }
    }

    public void cancel() {
        ez(czN());
    }

    @Nullable
    public synchronized List<ak> rv(boolean z) {
        ArrayList arrayList;
        if (z == this.jJV) {
            arrayList = null;
        } else {
            this.jJV = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.jJW) {
            arrayList = null;
        } else {
            this.jJW = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> rw(boolean z) {
        ArrayList arrayList;
        if (z == this.jJX) {
            arrayList = null;
        } else {
            this.jJX = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> czN() {
        ArrayList arrayList;
        if (this.bVD) {
            arrayList = null;
        } else {
            this.bVD = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void ez(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.czO();
            }
        }
    }

    public static void eA(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.czP();
            }
        }
    }

    public static void eB(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.czQ();
            }
        }
    }

    public static void eC(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.czR();
            }
        }
    }
}
