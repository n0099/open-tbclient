package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes5.dex */
public class d implements ak {
    @GuardedBy("this")
    private boolean fpC = false;
    @GuardedBy("this")
    private final List<al> mCallbacks = new ArrayList();
    private final String mId;
    private final Object pBi;
    private final ImageRequest pBj;
    @GuardedBy("this")
    private boolean pBt;
    private final am pLQ;
    private final ImageRequest.RequestLevel pLR;
    @GuardedBy("this")
    private Priority pLS;
    @GuardedBy("this")
    private boolean pLT;

    public d(ImageRequest imageRequest, String str, am amVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.pBj = imageRequest;
        this.mId = str;
        this.pLQ = amVar;
        this.pBi = obj;
        this.pLR = requestLevel;
        this.pBt = z;
        this.pLS = priority;
        this.pLT = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest ezp() {
        return this.pBj;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public am ezq() {
        return this.pLQ;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public Object eud() {
        return this.pBi;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest.RequestLevel ezr() {
        return this.pLR;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean ezs() {
        return this.pBt;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized Priority ezt() {
        return this.pLS;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean ezu() {
        return this.pLT;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public void a(al alVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(alVar);
            if (this.fpC) {
                z = true;
            }
        }
        if (z) {
            alVar.ezw();
        }
    }

    public void cancel() {
        gL(ezv());
    }

    @Nullable
    public synchronized List<al> Bu(boolean z) {
        ArrayList arrayList;
        if (z == this.pBt) {
            arrayList = null;
        } else {
            this.pBt = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.pLS) {
            arrayList = null;
        } else {
            this.pLS = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> Bv(boolean z) {
        ArrayList arrayList;
        if (z == this.pLT) {
            arrayList = null;
        } else {
            this.pLT = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> ezv() {
        ArrayList arrayList;
        if (this.fpC) {
            arrayList = null;
        } else {
            this.fpC = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void gL(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.ezw();
            }
        }
    }

    public static void gM(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.ezx();
            }
        }
    }

    public static void gN(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.ezy();
            }
        }
    }

    public static void gO(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.ezz();
            }
        }
    }
}
