package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class d implements aj {
    private final Object jCi;
    private final ImageRequest jKa;
    private final al jKb;
    private final ImageRequest.RequestLevel jKc;
    @GuardedBy("this")
    private boolean jKd;
    @GuardedBy("this")
    private Priority jKe;
    @GuardedBy("this")
    private boolean jKf;
    private final String mId;
    @GuardedBy("this")
    private boolean bVC = false;
    @GuardedBy("this")
    private final List<ak> mCallbacks = new ArrayList();

    public d(ImageRequest imageRequest, String str, al alVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.jKa = imageRequest;
        this.mId = str;
        this.jKb = alVar;
        this.jCi = obj;
        this.jKc = requestLevel;
        this.jKd = z;
        this.jKe = priority;
        this.jKf = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest czE() {
        return this.jKa;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public al czF() {
        return this.jKb;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public Object cva() {
        return this.jCi;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest.RequestLevel czG() {
        return this.jKc;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean czH() {
        return this.jKd;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized Priority czI() {
        return this.jKe;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean czJ() {
        return this.jKf;
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
            akVar.czL();
        }
    }

    public void cancel() {
        ez(czK());
    }

    @Nullable
    public synchronized List<ak> rv(boolean z) {
        ArrayList arrayList;
        if (z == this.jKd) {
            arrayList = null;
        } else {
            this.jKd = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.jKe) {
            arrayList = null;
        } else {
            this.jKe = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> rw(boolean z) {
        ArrayList arrayList;
        if (z == this.jKf) {
            arrayList = null;
        } else {
            this.jKf = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> czK() {
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
                akVar.czL();
            }
        }
    }

    public static void eA(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.czM();
            }
        }
    }

    public static void eB(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.czN();
            }
        }
    }

    public static void eC(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.czO();
            }
        }
    }
}
