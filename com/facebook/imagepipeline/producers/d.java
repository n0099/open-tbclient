package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class d implements aj {
    private final Object kcy;
    private final ImageRequest kkr;
    private final al kks;
    private final ImageRequest.RequestLevel kkt;
    @GuardedBy("this")
    private boolean kku;
    @GuardedBy("this")
    private Priority kkv;
    @GuardedBy("this")
    private boolean kkw;
    private final String mId;
    @GuardedBy("this")
    private boolean ceM = false;
    @GuardedBy("this")
    private final List<ak> mCallbacks = new ArrayList();

    public d(ImageRequest imageRequest, String str, al alVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.kkr = imageRequest;
        this.mId = str;
        this.kks = alVar;
        this.kcy = obj;
        this.kkt = requestLevel;
        this.kku = z;
        this.kkv = priority;
        this.kkw = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest cKW() {
        return this.kkr;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public al cKX() {
        return this.kks;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public Object cGp() {
        return this.kcy;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest.RequestLevel cKY() {
        return this.kkt;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean cKZ() {
        return this.kku;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized Priority cLa() {
        return this.kkv;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean cLb() {
        return this.kkw;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(ak akVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(akVar);
            if (this.ceM) {
                z = true;
            }
        }
        if (z) {
            akVar.cLd();
        }
    }

    public void cancel() {
        eG(cLc());
    }

    @Nullable
    public synchronized List<ak> sB(boolean z) {
        ArrayList arrayList;
        if (z == this.kku) {
            arrayList = null;
        } else {
            this.kku = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.kkv) {
            arrayList = null;
        } else {
            this.kkv = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> sC(boolean z) {
        ArrayList arrayList;
        if (z == this.kkw) {
            arrayList = null;
        } else {
            this.kkw = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> cLc() {
        ArrayList arrayList;
        if (this.ceM) {
            arrayList = null;
        } else {
            this.ceM = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void eG(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.cLd();
            }
        }
    }

    public static void eH(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.cLe();
            }
        }
    }

    public static void eI(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.cLf();
            }
        }
    }

    public static void eJ(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.cLg();
            }
        }
    }
}
