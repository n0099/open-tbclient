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
    private boolean frU = false;
    @GuardedBy("this")
    private final List<al> mCallbacks = new ArrayList();
    private final String mId;
    private final am pEb;
    private final ImageRequest.RequestLevel pEc;
    @GuardedBy("this")
    private Priority pEd;
    @GuardedBy("this")
    private boolean pEe;
    private final Object puT;
    private final ImageRequest puU;
    @GuardedBy("this")
    private boolean pve;

    public d(ImageRequest imageRequest, String str, am amVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.puU = imageRequest;
        this.mId = str;
        this.pEb = amVar;
        this.puT = obj;
        this.pEc = requestLevel;
        this.pve = z;
        this.pEd = priority;
        this.pEe = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest eAd() {
        return this.puU;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public am eAe() {
        return this.pEb;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public Object evp() {
        return this.puT;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest.RequestLevel eAf() {
        return this.pEc;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean eAg() {
        return this.pve;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized Priority eAh() {
        return this.pEd;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean eAi() {
        return this.pEe;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public void a(al alVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(alVar);
            if (this.frU) {
                z = true;
            }
        }
        if (z) {
            alVar.eAk();
        }
    }

    public void cancel() {
        gM(eAj());
    }

    @Nullable
    public synchronized List<al> Bf(boolean z) {
        ArrayList arrayList;
        if (z == this.pve) {
            arrayList = null;
        } else {
            this.pve = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.pEd) {
            arrayList = null;
        } else {
            this.pEd = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> Bg(boolean z) {
        ArrayList arrayList;
        if (z == this.pEe) {
            arrayList = null;
        } else {
            this.pEe = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> eAj() {
        ArrayList arrayList;
        if (this.frU) {
            arrayList = null;
        } else {
            this.frU = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void gM(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.eAk();
            }
        }
    }

    public static void gN(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.eAl();
            }
        }
    }

    public static void gO(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.eAm();
            }
        }
    }

    public static void gP(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.eAn();
            }
        }
    }
}
