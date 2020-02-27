package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class d implements ak {
    private final Object lKi;
    private final ImageRequest lKj;
    @GuardedBy("this")
    private boolean lKt;
    private final am lVb;
    private final ImageRequest.RequestLevel lVc;
    @GuardedBy("this")
    private Priority lVd;
    @GuardedBy("this")
    private boolean lVe;
    private final String mId;
    @GuardedBy("this")
    private boolean UW = false;
    @GuardedBy("this")
    private final List<al> mCallbacks = new ArrayList();

    public d(ImageRequest imageRequest, String str, am amVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.lKj = imageRequest;
        this.mId = str;
        this.lVb = amVar;
        this.lKi = obj;
        this.lVc = requestLevel;
        this.lKt = z;
        this.lVd = priority;
        this.lVe = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest drv() {
        return this.lKj;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public am drw() {
        return this.lVb;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public Object dmd() {
        return this.lKi;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest.RequestLevel drx() {
        return this.lVc;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean dry() {
        return this.lKt;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized Priority drz() {
        return this.lVd;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean drA() {
        return this.lVe;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public void a(al alVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(alVar);
            if (this.UW) {
                z = true;
            }
        }
        if (z) {
            alVar.dnN();
        }
    }

    public void cancel() {
        eV(drB());
    }

    @Nullable
    public synchronized List<al> vs(boolean z) {
        ArrayList arrayList;
        if (z == this.lKt) {
            arrayList = null;
        } else {
            this.lKt = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.lVd) {
            arrayList = null;
        } else {
            this.lVd = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> vt(boolean z) {
        ArrayList arrayList;
        if (z == this.lVe) {
            arrayList = null;
        } else {
            this.lVe = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> drB() {
        ArrayList arrayList;
        if (this.UW) {
            arrayList = null;
        } else {
            this.UW = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void eV(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dnN();
            }
        }
    }

    public static void eW(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.drC();
            }
        }
    }

    public static void eX(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.drD();
            }
        }
    }

    public static void eY(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.drE();
            }
        }
    }
}
