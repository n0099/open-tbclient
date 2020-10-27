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
    private boolean eVO = false;
    @GuardedBy("this")
    private final List<al> mCallbacks = new ArrayList();
    private final String mId;
    private final Object oDH;
    private final ImageRequest oDI;
    @GuardedBy("this")
    private boolean oDS;
    private final am oOL;
    private final ImageRequest.RequestLevel oOM;
    @GuardedBy("this")
    private Priority oON;
    @GuardedBy("this")
    private boolean oOO;

    public d(ImageRequest imageRequest, String str, am amVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.oDI = imageRequest;
        this.mId = str;
        this.oOL = amVar;
        this.oDH = obj;
        this.oOM = requestLevel;
        this.oDS = z;
        this.oON = priority;
        this.oOO = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest enf() {
        return this.oDI;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public am eng() {
        return this.oOL;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public Object ehK() {
        return this.oDH;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest.RequestLevel enh() {
        return this.oOM;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean eni() {
        return this.oDS;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized Priority enj() {
        return this.oON;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean enk() {
        return this.oOO;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public void a(al alVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(alVar);
            if (this.eVO) {
                z = true;
            }
        }
        if (z) {
            alVar.ejw();
        }
    }

    public void cancel() {
        gs(enl());
    }

    @Nullable
    public synchronized List<al> Ae(boolean z) {
        ArrayList arrayList;
        if (z == this.oDS) {
            arrayList = null;
        } else {
            this.oDS = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.oON) {
            arrayList = null;
        } else {
            this.oON = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> Af(boolean z) {
        ArrayList arrayList;
        if (z == this.oOO) {
            arrayList = null;
        } else {
            this.oOO = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> enl() {
        ArrayList arrayList;
        if (this.eVO) {
            arrayList = null;
        } else {
            this.eVO = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void gs(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.ejw();
            }
        }
    }

    public static void gt(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.enm();
            }
        }
    }

    public static void gu(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.enn();
            }
        }
    }

    public static void gv(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.eno();
            }
        }
    }
}
