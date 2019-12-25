package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes9.dex */
public class d implements ak {
    private final Object lFY;
    private final ImageRequest lFZ;
    @GuardedBy("this")
    private boolean lGj;
    private final am lQB;
    private final ImageRequest.RequestLevel lQC;
    @GuardedBy("this")
    private Priority lQD;
    @GuardedBy("this")
    private boolean lQE;
    private final String mId;
    @GuardedBy("this")
    private boolean Tn = false;
    @GuardedBy("this")
    private final List<al> mCallbacks = new ArrayList();

    public d(ImageRequest imageRequest, String str, am amVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.lFZ = imageRequest;
        this.mId = str;
        this.lQB = amVar;
        this.lFY = obj;
        this.lQC = requestLevel;
        this.lGj = z;
        this.lQD = priority;
        this.lQE = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest doX() {
        return this.lFZ;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public am doY() {
        return this.lQB;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public Object djN() {
        return this.lFY;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest.RequestLevel doZ() {
        return this.lQC;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean dpa() {
        return this.lGj;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized Priority dpb() {
        return this.lQD;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean dpc() {
        return this.lQE;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public void a(al alVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(alVar);
            if (this.Tn) {
                z = true;
            }
        }
        if (z) {
            alVar.dlt();
        }
    }

    public void cancel() {
        fa(dpd());
    }

    @Nullable
    public synchronized List<al> vc(boolean z) {
        ArrayList arrayList;
        if (z == this.lGj) {
            arrayList = null;
        } else {
            this.lGj = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.lQD) {
            arrayList = null;
        } else {
            this.lQD = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> vd(boolean z) {
        ArrayList arrayList;
        if (z == this.lQE) {
            arrayList = null;
        } else {
            this.lQE = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> dpd() {
        ArrayList arrayList;
        if (this.Tn) {
            arrayList = null;
        } else {
            this.Tn = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void fa(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dlt();
            }
        }
    }

    public static void fb(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dpe();
            }
        }
    }

    public static void fc(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dpf();
            }
        }
    }

    public static void fd(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dpg();
            }
        }
    }
}
