package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class d implements ak {
    private final ImageRequest lTA;
    @GuardedBy("this")
    private boolean lTK;
    private final Object lTz;
    private final String mId;
    private final am meJ;
    private final ImageRequest.RequestLevel meK;
    @GuardedBy("this")
    private Priority meL;
    @GuardedBy("this")
    private boolean meM;
    @GuardedBy("this")
    private boolean dLE = false;
    @GuardedBy("this")
    private final List<al> mCallbacks = new ArrayList();

    public d(ImageRequest imageRequest, String str, am amVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.lTA = imageRequest;
        this.mId = str;
        this.meJ = amVar;
        this.lTz = obj;
        this.meK = requestLevel;
        this.lTK = z;
        this.meL = priority;
        this.meM = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest dtR() {
        return this.lTA;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public am dtS() {
        return this.meJ;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public Object dou() {
        return this.lTz;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest.RequestLevel dtT() {
        return this.meK;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean dtU() {
        return this.lTK;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized Priority dtV() {
        return this.meL;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean dtW() {
        return this.meM;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public void a(al alVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(alVar);
            if (this.dLE) {
                z = true;
            }
        }
        if (z) {
            alVar.dqi();
        }
    }

    public void cancel() {
        eW(dtX());
    }

    @Nullable
    public synchronized List<al> vM(boolean z) {
        ArrayList arrayList;
        if (z == this.lTK) {
            arrayList = null;
        } else {
            this.lTK = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.meL) {
            arrayList = null;
        } else {
            this.meL = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> vN(boolean z) {
        ArrayList arrayList;
        if (z == this.meM) {
            arrayList = null;
        } else {
            this.meM = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> dtX() {
        ArrayList arrayList;
        if (this.dLE) {
            arrayList = null;
        } else {
            this.dLE = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void eW(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dqi();
            }
        }
    }

    public static void eX(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dtY();
            }
        }
    }

    public static void eY(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dtZ();
            }
        }
    }

    public static void eZ(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dua();
            }
        }
    }
}
