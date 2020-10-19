package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes18.dex */
public class d implements ak {
    @GuardedBy("this")
    private boolean eNs = false;
    @GuardedBy("this")
    private final List<al> mCallbacks = new ArrayList();
    private final String mId;
    private final Object nMo;
    private final ImageRequest nMp;
    @GuardedBy("this")
    private boolean nMz;
    private final am nXt;
    private final ImageRequest.RequestLevel nXu;
    @GuardedBy("this")
    private Priority nXv;
    @GuardedBy("this")
    private boolean nXw;

    public d(ImageRequest imageRequest, String str, am amVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.nMp = imageRequest;
        this.mId = str;
        this.nXt = amVar;
        this.nMo = obj;
        this.nXu = requestLevel;
        this.nMz = z;
        this.nXv = priority;
        this.nXw = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest edg() {
        return this.nMp;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public am edh() {
        return this.nXt;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public Object dXM() {
        return this.nMo;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest.RequestLevel edi() {
        return this.nXu;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean edj() {
        return this.nMz;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized Priority edk() {
        return this.nXv;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean edl() {
        return this.nXw;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public void a(al alVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(alVar);
            if (this.eNs) {
                z = true;
            }
        }
        if (z) {
            alVar.dZy();
        }
    }

    public void cancel() {
        fW(edm());
    }

    @Nullable
    public synchronized List<al> yW(boolean z) {
        ArrayList arrayList;
        if (z == this.nMz) {
            arrayList = null;
        } else {
            this.nMz = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.nXv) {
            arrayList = null;
        } else {
            this.nXv = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> yX(boolean z) {
        ArrayList arrayList;
        if (z == this.nXw) {
            arrayList = null;
        } else {
            this.nXw = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> edm() {
        ArrayList arrayList;
        if (this.eNs) {
            arrayList = null;
        } else {
            this.eNs = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void fW(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dZy();
            }
        }
    }

    public static void fX(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.edn();
            }
        }
    }

    public static void fY(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.edo();
            }
        }
    }

    public static void fZ(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.edp();
            }
        }
    }
}
