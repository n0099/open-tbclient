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
    private boolean lKG;
    private final Object lKv;
    private final ImageRequest lKw;
    private final am lVo;
    private final ImageRequest.RequestLevel lVp;
    @GuardedBy("this")
    private Priority lVq;
    @GuardedBy("this")
    private boolean lVr;
    private final String mId;
    @GuardedBy("this")
    private boolean UW = false;
    @GuardedBy("this")
    private final List<al> mCallbacks = new ArrayList();

    public d(ImageRequest imageRequest, String str, am amVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.lKw = imageRequest;
        this.mId = str;
        this.lVo = amVar;
        this.lKv = obj;
        this.lVp = requestLevel;
        this.lKG = z;
        this.lVq = priority;
        this.lVr = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest dry() {
        return this.lKw;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public am drz() {
        return this.lVo;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public Object dmg() {
        return this.lKv;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest.RequestLevel drA() {
        return this.lVp;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean drB() {
        return this.lKG;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized Priority drC() {
        return this.lVq;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean drD() {
        return this.lVr;
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
            alVar.dnQ();
        }
    }

    public void cancel() {
        eV(drE());
    }

    @Nullable
    public synchronized List<al> vs(boolean z) {
        ArrayList arrayList;
        if (z == this.lKG) {
            arrayList = null;
        } else {
            this.lKG = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.lVq) {
            arrayList = null;
        } else {
            this.lVq = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> vt(boolean z) {
        ArrayList arrayList;
        if (z == this.lVr) {
            arrayList = null;
        } else {
            this.lVr = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> drE() {
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
                alVar.dnQ();
            }
        }
    }

    public static void eW(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.drF();
            }
        }
    }

    public static void eX(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.drG();
            }
        }
    }

    public static void eY(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.drH();
            }
        }
    }
}
