package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class d implements aj {
    private final Object imo;
    private final ImageRequest itY;
    private final al itZ;
    private final ImageRequest.RequestLevel iua;
    @GuardedBy("this")
    private boolean iub;
    @GuardedBy("this")
    private Priority iuc;
    @GuardedBy("this")
    private boolean iud;
    private final String mId;
    @GuardedBy("this")
    private boolean aNc = false;
    @GuardedBy("this")
    private final List<ak> mCallbacks = new ArrayList();

    public d(ImageRequest imageRequest, String str, al alVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.itY = imageRequest;
        this.mId = str;
        this.itZ = alVar;
        this.imo = obj;
        this.iua = requestLevel;
        this.iub = z;
        this.iuc = priority;
        this.iud = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest cap() {
        return this.itY;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public al caq() {
        return this.itZ;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public Object bVS() {
        return this.imo;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest.RequestLevel car() {
        return this.iua;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean cas() {
        return this.iub;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized Priority cat() {
        return this.iuc;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean cau() {
        return this.iud;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(ak akVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(akVar);
            if (this.aNc) {
                z = true;
            }
        }
        if (z) {
            akVar.caw();
        }
    }

    public void cancel() {
        ev(cav());
    }

    @Nullable
    public synchronized List<ak> pb(boolean z) {
        ArrayList arrayList;
        if (z == this.iub) {
            arrayList = null;
        } else {
            this.iub = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.iuc) {
            arrayList = null;
        } else {
            this.iuc = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> pc(boolean z) {
        ArrayList arrayList;
        if (z == this.iud) {
            arrayList = null;
        } else {
            this.iud = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> cav() {
        ArrayList arrayList;
        if (this.aNc) {
            arrayList = null;
        } else {
            this.aNc = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void ev(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.caw();
            }
        }
    }

    public static void ew(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.cax();
            }
        }
    }

    public static void ex(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.cay();
            }
        }
    }

    public static void ey(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.caz();
            }
        }
    }
}
