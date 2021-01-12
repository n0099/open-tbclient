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
    private boolean fnj = false;
    @GuardedBy("this")
    private final List<al> mCallbacks = new ArrayList();
    private final String mId;
    private final am pBh;
    private final ImageRequest.RequestLevel pBi;
    @GuardedBy("this")
    private Priority pBj;
    @GuardedBy("this")
    private boolean pBk;
    @GuardedBy("this")
    private boolean pqJ;
    private final Object pqy;
    private final ImageRequest pqz;

    public d(ImageRequest imageRequest, String str, am amVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.pqz = imageRequest;
        this.mId = str;
        this.pBh = amVar;
        this.pqy = obj;
        this.pBi = requestLevel;
        this.pqJ = z;
        this.pBj = priority;
        this.pBk = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest ewP() {
        return this.pqz;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public am ewQ() {
        return this.pBh;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public Object erD() {
        return this.pqy;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest.RequestLevel ewR() {
        return this.pBi;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean ewS() {
        return this.pqJ;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized Priority ewT() {
        return this.pBj;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean ewU() {
        return this.pBk;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public void a(al alVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(alVar);
            if (this.fnj) {
                z = true;
            }
        }
        if (z) {
            alVar.ewW();
        }
    }

    public void cancel() {
        gN(ewV());
    }

    @Nullable
    public synchronized List<al> Bb(boolean z) {
        ArrayList arrayList;
        if (z == this.pqJ) {
            arrayList = null;
        } else {
            this.pqJ = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.pBj) {
            arrayList = null;
        } else {
            this.pBj = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> Bc(boolean z) {
        ArrayList arrayList;
        if (z == this.pBk) {
            arrayList = null;
        } else {
            this.pBk = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> ewV() {
        ArrayList arrayList;
        if (this.fnj) {
            arrayList = null;
        } else {
            this.fnj = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void gN(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.ewW();
            }
        }
    }

    public static void gO(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.ewX();
            }
        }
    }

    public static void gP(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.ewY();
            }
        }
    }

    public static void gQ(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.ewZ();
            }
        }
    }
}
