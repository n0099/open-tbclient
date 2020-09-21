package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes25.dex */
public class d implements ak {
    @GuardedBy("this")
    private boolean eBl = false;
    @GuardedBy("this")
    private final List<al> mCallbacks = new ArrayList();
    private final String mId;
    private final am nIc;
    private final ImageRequest.RequestLevel nId;
    @GuardedBy("this")
    private Priority nIe;
    @GuardedBy("this")
    private boolean nIf;
    private final Object nwV;
    private final ImageRequest nwW;
    @GuardedBy("this")
    private boolean nxg;

    public d(ImageRequest imageRequest, String str, am amVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.nwW = imageRequest;
        this.mId = str;
        this.nIc = amVar;
        this.nwV = obj;
        this.nId = requestLevel;
        this.nxg = z;
        this.nIe = priority;
        this.nIf = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest dZv() {
        return this.nwW;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public am dZw() {
        return this.nIc;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public Object dUb() {
        return this.nwV;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest.RequestLevel dZx() {
        return this.nId;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean dZy() {
        return this.nxg;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized Priority dZz() {
        return this.nIe;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean dZA() {
        return this.nIf;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public void a(al alVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(alVar);
            if (this.eBl) {
                z = true;
            }
        }
        if (z) {
            alVar.dVN();
        }
    }

    public void cancel() {
        fT(dZB());
    }

    @Nullable
    public synchronized List<al> yp(boolean z) {
        ArrayList arrayList;
        if (z == this.nxg) {
            arrayList = null;
        } else {
            this.nxg = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.nIe) {
            arrayList = null;
        } else {
            this.nIe = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> yq(boolean z) {
        ArrayList arrayList;
        if (z == this.nIf) {
            arrayList = null;
        } else {
            this.nIf = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> dZB() {
        ArrayList arrayList;
        if (this.eBl) {
            arrayList = null;
        } else {
            this.eBl = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void fT(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dVN();
            }
        }
    }

    public static void fU(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dZC();
            }
        }
    }

    public static void fV(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dZD();
            }
        }
    }

    public static void fW(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dZE();
            }
        }
    }
}
