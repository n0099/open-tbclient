package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class d implements ak {
    @GuardedBy("this")
    private boolean eiF = false;
    @GuardedBy("this")
    private final List<al> mCallbacks = new ArrayList();
    private final String mId;
    private final Object mKE;
    private final ImageRequest mKF;
    @GuardedBy("this")
    private boolean mKP;
    private final am mVU;
    private final ImageRequest.RequestLevel mVV;
    @GuardedBy("this")
    private Priority mVW;
    @GuardedBy("this")
    private boolean mVX;

    public d(ImageRequest imageRequest, String str, am amVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.mKF = imageRequest;
        this.mId = str;
        this.mVU = amVar;
        this.mKE = obj;
        this.mVV = requestLevel;
        this.mKP = z;
        this.mVW = priority;
        this.mVX = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest dGc() {
        return this.mKF;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public am dGd() {
        return this.mVU;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public Object dAH() {
        return this.mKE;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest.RequestLevel dGe() {
        return this.mVV;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean dGf() {
        return this.mKP;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized Priority dGg() {
        return this.mVW;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean dGh() {
        return this.mVX;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public void a(al alVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(alVar);
            if (this.eiF) {
                z = true;
            }
        }
        if (z) {
            alVar.dCu();
        }
    }

    public void cancel() {
        fr(dGi());
    }

    @Nullable
    public synchronized List<al> wI(boolean z) {
        ArrayList arrayList;
        if (z == this.mKP) {
            arrayList = null;
        } else {
            this.mKP = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.mVW) {
            arrayList = null;
        } else {
            this.mVW = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> wJ(boolean z) {
        ArrayList arrayList;
        if (z == this.mVX) {
            arrayList = null;
        } else {
            this.mVX = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> dGi() {
        ArrayList arrayList;
        if (this.eiF) {
            arrayList = null;
        } else {
            this.eiF = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void fr(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dCu();
            }
        }
    }

    public static void fs(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dGj();
            }
        }
    }

    public static void ft(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dGk();
            }
        }
    }

    public static void fu(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dGl();
            }
        }
    }
}
