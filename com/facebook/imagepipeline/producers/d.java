package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes3.dex */
public class d implements ak {
    @GuardedBy("this")
    private boolean frU = false;
    @GuardedBy("this")
    private final List<al> mCallbacks = new ArrayList();
    private final String mId;
    private final am pFI;
    private final ImageRequest.RequestLevel pFJ;
    @GuardedBy("this")
    private Priority pFK;
    @GuardedBy("this")
    private boolean pFL;
    private final Object pva;
    private final ImageRequest pvb;
    @GuardedBy("this")
    private boolean pvl;

    public d(ImageRequest imageRequest, String str, am amVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.pvb = imageRequest;
        this.mId = str;
        this.pFI = amVar;
        this.pva = obj;
        this.pFJ = requestLevel;
        this.pvl = z;
        this.pFK = priority;
        this.pFL = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest eAH() {
        return this.pvb;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public am eAI() {
        return this.pFI;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public Object evw() {
        return this.pva;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest.RequestLevel eAJ() {
        return this.pFJ;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean eAK() {
        return this.pvl;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized Priority eAL() {
        return this.pFK;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean eAM() {
        return this.pFL;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public void a(al alVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(alVar);
            if (this.frU) {
                z = true;
            }
        }
        if (z) {
            alVar.eAO();
        }
    }

    public void cancel() {
        gN(eAN());
    }

    @Nullable
    public synchronized List<al> Bf(boolean z) {
        ArrayList arrayList;
        if (z == this.pvl) {
            arrayList = null;
        } else {
            this.pvl = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.pFK) {
            arrayList = null;
        } else {
            this.pFK = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> Bg(boolean z) {
        ArrayList arrayList;
        if (z == this.pFL) {
            arrayList = null;
        } else {
            this.pFL = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> eAN() {
        ArrayList arrayList;
        if (this.frU) {
            arrayList = null;
        } else {
            this.frU = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void gN(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.eAO();
            }
        }
    }

    public static void gO(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.eAP();
            }
        }
    }

    public static void gP(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.eAQ();
            }
        }
    }

    public static void gQ(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.eAR();
            }
        }
    }
}
