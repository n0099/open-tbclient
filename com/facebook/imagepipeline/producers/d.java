package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class d implements aj {
    private final Object ihW;
    private final ImageRequest ipH;
    private final al ipI;
    private final ImageRequest.RequestLevel ipJ;
    @GuardedBy("this")
    private boolean ipK;
    @GuardedBy("this")
    private Priority ipL;
    @GuardedBy("this")
    private boolean ipM;
    private final String mId;
    @GuardedBy("this")
    private boolean aMy = false;
    @GuardedBy("this")
    private final List<ak> mCallbacks = new ArrayList();

    public d(ImageRequest imageRequest, String str, al alVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.ipH = imageRequest;
        this.mId = str;
        this.ipI = alVar;
        this.ihW = obj;
        this.ipJ = requestLevel;
        this.ipK = z;
        this.ipL = priority;
        this.ipM = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest bYQ() {
        return this.ipH;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public al bYR() {
        return this.ipI;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public Object bUt() {
        return this.ihW;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest.RequestLevel bYS() {
        return this.ipJ;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean bYT() {
        return this.ipK;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized Priority bYU() {
        return this.ipL;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean bYV() {
        return this.ipM;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(ak akVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(akVar);
            if (this.aMy) {
                z = true;
            }
        }
        if (z) {
            akVar.bYX();
        }
    }

    public void cancel() {
        et(bYW());
    }

    @Nullable
    public synchronized List<ak> oX(boolean z) {
        ArrayList arrayList;
        if (z == this.ipK) {
            arrayList = null;
        } else {
            this.ipK = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.ipL) {
            arrayList = null;
        } else {
            this.ipL = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> oY(boolean z) {
        ArrayList arrayList;
        if (z == this.ipM) {
            arrayList = null;
        } else {
            this.ipM = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> bYW() {
        ArrayList arrayList;
        if (this.aMy) {
            arrayList = null;
        } else {
            this.aMy = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void et(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.bYX();
            }
        }
    }

    public static void eu(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.bYY();
            }
        }
    }

    public static void ev(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.bYZ();
            }
        }
    }

    public static void ew(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.bZa();
            }
        }
    }
}
