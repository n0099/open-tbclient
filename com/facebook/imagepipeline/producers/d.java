package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes15.dex */
public class d implements ak {
    @GuardedBy("this")
    private boolean faL = false;
    @GuardedBy("this")
    private final List<al> mCallbacks = new ArrayList();
    private final String mId;
    private final Object oOE;
    private final ImageRequest oOF;
    @GuardedBy("this")
    private boolean oOP;
    private final am oZH;
    private final ImageRequest.RequestLevel oZI;
    @GuardedBy("this")
    private Priority oZJ;
    @GuardedBy("this")
    private boolean oZK;

    public d(ImageRequest imageRequest, String str, am amVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.oOF = imageRequest;
        this.mId = str;
        this.oZH = amVar;
        this.oOE = obj;
        this.oZI = requestLevel;
        this.oOP = z;
        this.oZJ = priority;
        this.oZK = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest eqT() {
        return this.oOF;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public am eqU() {
        return this.oZH;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public Object elx() {
        return this.oOE;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest.RequestLevel eqV() {
        return this.oZI;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean eqW() {
        return this.oOP;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized Priority eqX() {
        return this.oZJ;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean eqY() {
        return this.oZK;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public void a(al alVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(alVar);
            if (this.faL) {
                z = true;
            }
        }
        if (z) {
            alVar.enk();
        }
    }

    public void cancel() {
        gB(eqZ());
    }

    @Nullable
    public synchronized List<al> Aw(boolean z) {
        ArrayList arrayList;
        if (z == this.oOP) {
            arrayList = null;
        } else {
            this.oOP = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.oZJ) {
            arrayList = null;
        } else {
            this.oZJ = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> Ax(boolean z) {
        ArrayList arrayList;
        if (z == this.oZK) {
            arrayList = null;
        } else {
            this.oZK = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> eqZ() {
        ArrayList arrayList;
        if (this.faL) {
            arrayList = null;
        } else {
            this.faL = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void gB(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.enk();
            }
        }
    }

    public static void gC(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.era();
            }
        }
    }

    public static void gD(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.erb();
            }
        }
    }

    public static void gE(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.erc();
            }
        }
    }
}
