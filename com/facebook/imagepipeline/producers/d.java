package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class d implements ak {
    private final Object lMb;
    private final ImageRequest lMc;
    @GuardedBy("this")
    private boolean lMm;
    private final am lWU;
    private final ImageRequest.RequestLevel lWV;
    @GuardedBy("this")
    private Priority lWW;
    @GuardedBy("this")
    private boolean lWX;
    private final String mId;
    @GuardedBy("this")
    private boolean Vh = false;
    @GuardedBy("this")
    private final List<al> mCallbacks = new ArrayList();

    public d(ImageRequest imageRequest, String str, am amVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.lMc = imageRequest;
        this.mId = str;
        this.lWU = amVar;
        this.lMb = obj;
        this.lWV = requestLevel;
        this.lMm = z;
        this.lWW = priority;
        this.lWX = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest drV() {
        return this.lMc;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public am drW() {
        return this.lWU;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public Object dmD() {
        return this.lMb;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest.RequestLevel drX() {
        return this.lWV;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean drY() {
        return this.lMm;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized Priority drZ() {
        return this.lWW;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean dsa() {
        return this.lWX;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public void a(al alVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(alVar);
            if (this.Vh) {
                z = true;
            }
        }
        if (z) {
            alVar.don();
        }
    }

    public void cancel() {
        eV(dsb());
    }

    @Nullable
    public synchronized List<al> vz(boolean z) {
        ArrayList arrayList;
        if (z == this.lMm) {
            arrayList = null;
        } else {
            this.lMm = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.lWW) {
            arrayList = null;
        } else {
            this.lWW = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> vA(boolean z) {
        ArrayList arrayList;
        if (z == this.lWX) {
            arrayList = null;
        } else {
            this.lWX = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> dsb() {
        ArrayList arrayList;
        if (this.Vh) {
            arrayList = null;
        } else {
            this.Vh = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void eV(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.don();
            }
        }
    }

    public static void eW(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dsc();
            }
        }
    }

    public static void eX(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dsd();
            }
        }
    }

    public static void eY(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dse();
            }
        }
    }
}
