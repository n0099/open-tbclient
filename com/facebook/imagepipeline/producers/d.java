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
    private final Object mSL;
    private final ImageRequest mSM;
    @GuardedBy("this")
    private boolean mSX;
    private final am ndX;
    private final ImageRequest.RequestLevel ndY;
    @GuardedBy("this")
    private Priority ndZ;
    @GuardedBy("this")
    private boolean nea;

    public d(ImageRequest imageRequest, String str, am amVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.mSM = imageRequest;
        this.mId = str;
        this.ndX = amVar;
        this.mSL = obj;
        this.ndY = requestLevel;
        this.mSX = z;
        this.ndZ = priority;
        this.nea = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest dJp() {
        return this.mSM;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public am dJq() {
        return this.ndX;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public Object dDU() {
        return this.mSL;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest.RequestLevel dJr() {
        return this.ndY;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean dJs() {
        return this.mSX;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized Priority dJt() {
        return this.ndZ;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean dJu() {
        return this.nea;
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
            alVar.dFH();
        }
    }

    public void cancel() {
        fA(dJv());
    }

    @Nullable
    public synchronized List<al> xn(boolean z) {
        ArrayList arrayList;
        if (z == this.mSX) {
            arrayList = null;
        } else {
            this.mSX = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.ndZ) {
            arrayList = null;
        } else {
            this.ndZ = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> xo(boolean z) {
        ArrayList arrayList;
        if (z == this.nea) {
            arrayList = null;
        } else {
            this.nea = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> dJv() {
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
                alVar.dFH();
            }
        }
    }

    public static void fB(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dJw();
            }
        }
    }

    public static void fC(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dJx();
            }
        }
    }

    public static void fD(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dJy();
            }
        }
    }
}
