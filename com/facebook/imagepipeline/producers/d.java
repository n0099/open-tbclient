package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class d implements aj {
    private final Object imp;
    private final ImageRequest itZ;
    private final al iua;
    private final ImageRequest.RequestLevel iub;
    @GuardedBy("this")
    private boolean iuc;
    @GuardedBy("this")
    private Priority iud;
    @GuardedBy("this")
    private boolean iue;
    private final String mId;
    @GuardedBy("this")
    private boolean aNd = false;
    @GuardedBy("this")
    private final List<ak> mCallbacks = new ArrayList();

    public d(ImageRequest imageRequest, String str, al alVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.itZ = imageRequest;
        this.mId = str;
        this.iua = alVar;
        this.imp = obj;
        this.iub = requestLevel;
        this.iuc = z;
        this.iud = priority;
        this.iue = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest cap() {
        return this.itZ;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public al caq() {
        return this.iua;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public Object bVS() {
        return this.imp;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest.RequestLevel car() {
        return this.iub;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean cas() {
        return this.iuc;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized Priority cat() {
        return this.iud;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean cau() {
        return this.iue;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(ak akVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(akVar);
            if (this.aNd) {
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
        if (z == this.iuc) {
            arrayList = null;
        } else {
            this.iuc = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.iud) {
            arrayList = null;
        } else {
            this.iud = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> pc(boolean z) {
        ArrayList arrayList;
        if (z == this.iue) {
            arrayList = null;
        } else {
            this.iue = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> cav() {
        ArrayList arrayList;
        if (this.aNd) {
            arrayList = null;
        } else {
            this.aNd = true;
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
