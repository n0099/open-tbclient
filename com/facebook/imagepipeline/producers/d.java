package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes8.dex */
public class d implements ak {
    @GuardedBy("this")
    private boolean ezh = false;
    @GuardedBy("this")
    private final List<al> mCallbacks = new ArrayList();
    private final String mId;
    private final Object nmV;
    private final ImageRequest nmW;
    @GuardedBy("this")
    private boolean nng;
    private final am nyf;
    private final ImageRequest.RequestLevel nyg;
    @GuardedBy("this")
    private Priority nyh;
    @GuardedBy("this")
    private boolean nyi;

    public d(ImageRequest imageRequest, String str, am amVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.nmW = imageRequest;
        this.mId = str;
        this.nyf = amVar;
        this.nmV = obj;
        this.nyg = requestLevel;
        this.nng = z;
        this.nyh = priority;
        this.nyi = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest dVx() {
        return this.nmW;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public am dVy() {
        return this.nyf;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public Object dQd() {
        return this.nmV;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest.RequestLevel dVz() {
        return this.nyg;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean dVA() {
        return this.nng;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized Priority dVB() {
        return this.nyh;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean dVC() {
        return this.nyi;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public void a(al alVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(alVar);
            if (this.ezh) {
                z = true;
            }
        }
        if (z) {
            alVar.dRP();
        }
    }

    public void cancel() {
        fK(dVD());
    }

    @Nullable
    public synchronized List<al> yg(boolean z) {
        ArrayList arrayList;
        if (z == this.nng) {
            arrayList = null;
        } else {
            this.nng = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.nyh) {
            arrayList = null;
        } else {
            this.nyh = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> yh(boolean z) {
        ArrayList arrayList;
        if (z == this.nyi) {
            arrayList = null;
        } else {
            this.nyi = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> dVD() {
        ArrayList arrayList;
        if (this.ezh) {
            arrayList = null;
        } else {
            this.ezh = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void fK(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dRP();
            }
        }
    }

    public static void fL(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dVE();
            }
        }
    }

    public static void fM(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dVF();
            }
        }
    }

    public static void fN(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dVG();
            }
        }
    }
}
