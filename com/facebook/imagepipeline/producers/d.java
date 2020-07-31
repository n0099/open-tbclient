package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes4.dex */
public class d implements ak {
    @GuardedBy("this")
    private boolean eoR = false;
    @GuardedBy("this")
    private final List<al> mCallbacks = new ArrayList();
    private final String mId;
    private final Object mSJ;
    private final ImageRequest mSK;
    @GuardedBy("this")
    private boolean mSV;
    private final am ndV;
    private final ImageRequest.RequestLevel ndW;
    @GuardedBy("this")
    private Priority ndX;
    @GuardedBy("this")
    private boolean ndY;

    public d(ImageRequest imageRequest, String str, am amVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.mSK = imageRequest;
        this.mId = str;
        this.ndV = amVar;
        this.mSJ = obj;
        this.ndW = requestLevel;
        this.mSV = z;
        this.ndX = priority;
        this.ndY = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest dJo() {
        return this.mSK;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public am dJp() {
        return this.ndV;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public Object dDT() {
        return this.mSJ;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest.RequestLevel dJq() {
        return this.ndW;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean dJr() {
        return this.mSV;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized Priority dJs() {
        return this.ndX;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean dJt() {
        return this.ndY;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public void a(al alVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(alVar);
            if (this.eoR) {
                z = true;
            }
        }
        if (z) {
            alVar.dFG();
        }
    }

    public void cancel() {
        fA(dJu());
    }

    @Nullable
    public synchronized List<al> xn(boolean z) {
        ArrayList arrayList;
        if (z == this.mSV) {
            arrayList = null;
        } else {
            this.mSV = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.ndX) {
            arrayList = null;
        } else {
            this.ndX = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> xo(boolean z) {
        ArrayList arrayList;
        if (z == this.ndY) {
            arrayList = null;
        } else {
            this.ndY = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> dJu() {
        ArrayList arrayList;
        if (this.eoR) {
            arrayList = null;
        } else {
            this.eoR = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void fA(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dFG();
            }
        }
    }

    public static void fB(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dJv();
            }
        }
    }

    public static void fC(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dJw();
            }
        }
    }

    public static void fD(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dJx();
            }
        }
    }
}
