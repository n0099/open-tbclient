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
    private boolean fbD = false;
    @GuardedBy("this")
    private final List<al> mCallbacks = new ArrayList();
    private final String mId;
    private final Object oNa;
    private final ImageRequest oNb;
    @GuardedBy("this")
    private boolean oNl;
    private final am oYe;
    private final ImageRequest.RequestLevel oYf;
    @GuardedBy("this")
    private Priority oYg;
    @GuardedBy("this")
    private boolean oYh;

    public d(ImageRequest imageRequest, String str, am amVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.oNb = imageRequest;
        this.mId = str;
        this.oYe = amVar;
        this.oNa = obj;
        this.oYf = requestLevel;
        this.oNl = z;
        this.oYg = priority;
        this.oYh = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest eqV() {
        return this.oNb;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public am eqW() {
        return this.oYe;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public Object elz() {
        return this.oNa;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest.RequestLevel eqX() {
        return this.oYf;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean eqY() {
        return this.oNl;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized Priority eqZ() {
        return this.oYg;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean era() {
        return this.oYh;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public void a(al alVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(alVar);
            if (this.fbD) {
                z = true;
            }
        }
        if (z) {
            alVar.enm();
        }
    }

    public void cancel() {
        gB(erb());
    }

    @Nullable
    public synchronized List<al> Ap(boolean z) {
        ArrayList arrayList;
        if (z == this.oNl) {
            arrayList = null;
        } else {
            this.oNl = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.oYg) {
            arrayList = null;
        } else {
            this.oYg = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> Aq(boolean z) {
        ArrayList arrayList;
        if (z == this.oYh) {
            arrayList = null;
        } else {
            this.oYh = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> erb() {
        ArrayList arrayList;
        if (this.fbD) {
            arrayList = null;
        } else {
            this.fbD = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void gB(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.enm();
            }
        }
    }

    public static void gC(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.erc();
            }
        }
    }

    public static void gD(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.erd();
            }
        }
    }

    public static void gE(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.ere();
            }
        }
    }
}
