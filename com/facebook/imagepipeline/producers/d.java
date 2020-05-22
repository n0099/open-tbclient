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
    @GuardedBy("this")
    private boolean mnC;
    private final Object mnr;
    private final ImageRequest mns;
    private final am myA;
    private final ImageRequest.RequestLevel myB;
    @GuardedBy("this")
    private Priority myC;
    @GuardedBy("this")
    private boolean myD;

    public d(ImageRequest imageRequest, String str, am amVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.mns = imageRequest;
        this.mId = str;
        this.myA = amVar;
        this.mnr = obj;
        this.myB = requestLevel;
        this.mnC = z;
        this.myC = priority;
        this.myD = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest dBi() {
        return this.mns;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public am dBj() {
        return this.myA;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public Object dvM() {
        return this.mnr;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest.RequestLevel dBk() {
        return this.myB;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean dBl() {
        return this.mnC;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized Priority dBm() {
        return this.myC;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean dBn() {
        return this.myD;
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
            alVar.dxA();
        }
    }

    public void cancel() {
        fd(dBo());
    }

    @Nullable
    public synchronized List<al> wk(boolean z) {
        ArrayList arrayList;
        if (z == this.mnC) {
            arrayList = null;
        } else {
            this.mnC = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.myC) {
            arrayList = null;
        } else {
            this.myC = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> wl(boolean z) {
        ArrayList arrayList;
        if (z == this.myD) {
            arrayList = null;
        } else {
            this.myD = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> dBo() {
        ArrayList arrayList;
        if (this.dZV) {
            arrayList = null;
        } else {
            this.dZV = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void fd(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dxA();
            }
        }
    }

    public static void fe(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dBp();
            }
        }
    }

    public static void ff(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dBq();
            }
        }
    }

    public static void fg(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dBr();
            }
        }
    }
}
