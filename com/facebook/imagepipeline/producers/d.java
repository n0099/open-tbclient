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
    private boolean fpC = false;
    @GuardedBy("this")
    private final List<al> mCallbacks = new ArrayList();
    private final String mId;
    private final Object pAI;
    private final ImageRequest pAJ;
    @GuardedBy("this")
    private boolean pAT;
    private final am pLq;
    private final ImageRequest.RequestLevel pLr;
    @GuardedBy("this")
    private Priority pLs;
    @GuardedBy("this")
    private boolean pLt;

    public d(ImageRequest imageRequest, String str, am amVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.pAJ = imageRequest;
        this.mId = str;
        this.pLq = amVar;
        this.pAI = obj;
        this.pLr = requestLevel;
        this.pAT = z;
        this.pLs = priority;
        this.pLt = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest ezh() {
        return this.pAJ;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public am ezi() {
        return this.pLq;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public Object etV() {
        return this.pAI;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest.RequestLevel ezj() {
        return this.pLr;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean ezk() {
        return this.pAT;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized Priority ezl() {
        return this.pLs;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean ezm() {
        return this.pLt;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public void a(al alVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(alVar);
            if (this.fpC) {
                z = true;
            }
        }
        if (z) {
            alVar.ezo();
        }
    }

    public void cancel() {
        gL(ezn());
    }

    @Nullable
    public synchronized List<al> Bu(boolean z) {
        ArrayList arrayList;
        if (z == this.pAT) {
            arrayList = null;
        } else {
            this.pAT = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.pLs) {
            arrayList = null;
        } else {
            this.pLs = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> Bv(boolean z) {
        ArrayList arrayList;
        if (z == this.pLt) {
            arrayList = null;
        } else {
            this.pLt = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> ezn() {
        ArrayList arrayList;
        if (this.fpC) {
            arrayList = null;
        } else {
            this.fpC = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void gL(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.ezo();
            }
        }
    }

    public static void gM(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.ezp();
            }
        }
    }

    public static void gN(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.ezq();
            }
        }
    }

    public static void gO(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.ezr();
            }
        }
    }
}
