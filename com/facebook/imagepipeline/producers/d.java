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
    private final Object mKB;
    private final ImageRequest mKC;
    @GuardedBy("this")
    private boolean mKM;
    private final am mVR;
    private final ImageRequest.RequestLevel mVS;
    @GuardedBy("this")
    private Priority mVT;
    @GuardedBy("this")
    private boolean mVU;

    public d(ImageRequest imageRequest, String str, am amVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.mKC = imageRequest;
        this.mId = str;
        this.mVR = amVar;
        this.mKB = obj;
        this.mVS = requestLevel;
        this.mKM = z;
        this.mVT = priority;
        this.mVU = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest dFY() {
        return this.mKC;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public am dFZ() {
        return this.mVR;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public Object dAD() {
        return this.mKB;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest.RequestLevel dGa() {
        return this.mVS;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean dGb() {
        return this.mKM;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized Priority dGc() {
        return this.mVT;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean dGd() {
        return this.mVU;
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
            alVar.dCq();
        }
    }

    public void cancel() {
        fr(dGe());
    }

    @Nullable
    public synchronized List<al> wI(boolean z) {
        ArrayList arrayList;
        if (z == this.mKM) {
            arrayList = null;
        } else {
            this.mKM = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.mVT) {
            arrayList = null;
        } else {
            this.mVT = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> wJ(boolean z) {
        ArrayList arrayList;
        if (z == this.mVU) {
            arrayList = null;
        } else {
            this.mVU = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> dGe() {
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
                alVar.dCq();
            }
        }
    }

    public static void fs(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dGf();
            }
        }
    }

    public static void ft(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dGg();
            }
        }
    }

    public static void fu(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dGh();
            }
        }
    }
}
