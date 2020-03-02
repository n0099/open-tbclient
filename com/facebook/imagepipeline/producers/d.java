package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class d implements ak {
    private final Object lKk;
    private final ImageRequest lKl;
    @GuardedBy("this")
    private boolean lKv;
    private final am lVd;
    private final ImageRequest.RequestLevel lVe;
    @GuardedBy("this")
    private Priority lVf;
    @GuardedBy("this")
    private boolean lVg;
    private final String mId;
    @GuardedBy("this")
    private boolean UW = false;
    @GuardedBy("this")
    private final List<al> mCallbacks = new ArrayList();

    public d(ImageRequest imageRequest, String str, am amVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.lKl = imageRequest;
        this.mId = str;
        this.lVd = amVar;
        this.lKk = obj;
        this.lVe = requestLevel;
        this.lKv = z;
        this.lVf = priority;
        this.lVg = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest drx() {
        return this.lKl;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public am dry() {
        return this.lVd;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public Object dmf() {
        return this.lKk;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest.RequestLevel drz() {
        return this.lVe;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean drA() {
        return this.lKv;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized Priority drB() {
        return this.lVf;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean drC() {
        return this.lVg;
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
            alVar.dnP();
        }
    }

    public void cancel() {
        eV(drD());
    }

    @Nullable
    public synchronized List<al> vs(boolean z) {
        ArrayList arrayList;
        if (z == this.lKv) {
            arrayList = null;
        } else {
            this.lKv = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.lVf) {
            arrayList = null;
        } else {
            this.lVf = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> vt(boolean z) {
        ArrayList arrayList;
        if (z == this.lVg) {
            arrayList = null;
        } else {
            this.lVg = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> drD() {
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
                alVar.dnP();
            }
        }
    }

    public static void eW(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.drE();
            }
        }
    }

    public static void eX(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.drF();
            }
        }
    }

    public static void eY(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.drG();
            }
        }
    }
}
