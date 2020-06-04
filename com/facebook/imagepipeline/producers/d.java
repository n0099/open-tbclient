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
    private boolean dZV = false;
    @GuardedBy("this")
    private final List<al> mCallbacks = new ArrayList();
    private final String mId;
    private final Object moC;
    private final ImageRequest moD;
    @GuardedBy("this")
    private boolean moN;
    private final am mzK;
    private final ImageRequest.RequestLevel mzL;
    @GuardedBy("this")
    private Priority mzM;
    @GuardedBy("this")
    private boolean mzN;

    public d(ImageRequest imageRequest, String str, am amVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.moD = imageRequest;
        this.mId = str;
        this.mzK = amVar;
        this.moC = obj;
        this.mzL = requestLevel;
        this.moN = z;
        this.mzM = priority;
        this.mzN = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest dBw() {
        return this.moD;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public am dBx() {
        return this.mzK;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public Object dwa() {
        return this.moC;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest.RequestLevel dBy() {
        return this.mzL;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean dBz() {
        return this.moN;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized Priority dBA() {
        return this.mzM;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean dBB() {
        return this.mzN;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public void a(al alVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(alVar);
            if (this.dZV) {
                z = true;
            }
        }
        if (z) {
            alVar.dxO();
        }
    }

    public void cancel() {
        ff(dBC());
    }

    @Nullable
    public synchronized List<al> wm(boolean z) {
        ArrayList arrayList;
        if (z == this.moN) {
            arrayList = null;
        } else {
            this.moN = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.mzM) {
            arrayList = null;
        } else {
            this.mzM = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> wn(boolean z) {
        ArrayList arrayList;
        if (z == this.mzN) {
            arrayList = null;
        } else {
            this.mzN = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> dBC() {
        ArrayList arrayList;
        if (this.dZV) {
            arrayList = null;
        } else {
            this.dZV = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void ff(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dxO();
            }
        }
    }

    public static void fg(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dBD();
            }
        }
    }

    public static void fh(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dBE();
            }
        }
    }

    public static void fi(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dBF();
            }
        }
    }
}
