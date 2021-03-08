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
    private boolean frb = false;
    @GuardedBy("this")
    private final List<al> mCallbacks = new ArrayList();
    private final String mId;
    private final Object pDn;
    private final ImageRequest pDo;
    @GuardedBy("this")
    private boolean pDy;
    private final am pNV;
    private final ImageRequest.RequestLevel pNW;
    @GuardedBy("this")
    private Priority pNX;
    @GuardedBy("this")
    private boolean pNY;

    public d(ImageRequest imageRequest, String str, am amVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.pDo = imageRequest;
        this.mId = str;
        this.pNV = amVar;
        this.pDn = obj;
        this.pNW = requestLevel;
        this.pDy = z;
        this.pNX = priority;
        this.pNY = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest ezy() {
        return this.pDo;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public am ezz() {
        return this.pNV;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public Object eum() {
        return this.pDn;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest.RequestLevel ezA() {
        return this.pNW;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean ezB() {
        return this.pDy;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized Priority ezC() {
        return this.pNX;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean ezD() {
        return this.pNY;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public void a(al alVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(alVar);
            if (this.frb) {
                z = true;
            }
        }
        if (z) {
            alVar.ezF();
        }
    }

    public void cancel() {
        gL(ezE());
    }

    @Nullable
    public synchronized List<al> Bs(boolean z) {
        ArrayList arrayList;
        if (z == this.pDy) {
            arrayList = null;
        } else {
            this.pDy = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.pNX) {
            arrayList = null;
        } else {
            this.pNX = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> Bt(boolean z) {
        ArrayList arrayList;
        if (z == this.pNY) {
            arrayList = null;
        } else {
            this.pNY = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> ezE() {
        ArrayList arrayList;
        if (this.frb) {
            arrayList = null;
        } else {
            this.frb = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void gL(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.ezF();
            }
        }
    }

    public static void gM(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.ezG();
            }
        }
    }

    public static void gN(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.ezH();
            }
        }
    }

    public static void gO(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.ezI();
            }
        }
    }
}
