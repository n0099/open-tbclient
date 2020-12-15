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
    private boolean fij = false;
    @GuardedBy("this")
    private final List<al> mCallbacks = new ArrayList();
    private final String mId;
    private final Object pdN;
    private final ImageRequest pdO;
    @GuardedBy("this")
    private boolean pdY;
    private final am poB;
    private final ImageRequest.RequestLevel poC;
    @GuardedBy("this")
    private Priority poD;
    @GuardedBy("this")
    private boolean poE;

    public d(ImageRequest imageRequest, String str, am amVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.pdO = imageRequest;
        this.mId = str;
        this.poB = amVar;
        this.pdN = obj;
        this.poC = requestLevel;
        this.pdY = z;
        this.poD = priority;
        this.poE = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest eww() {
        return this.pdO;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public am ewx() {
        return this.poB;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public Object ern() {
        return this.pdN;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest.RequestLevel ewy() {
        return this.poC;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean ewz() {
        return this.pdY;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized Priority ewA() {
        return this.poD;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean ewB() {
        return this.poE;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public void a(al alVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(alVar);
            if (this.fij) {
                z = true;
            }
        }
        if (z) {
            alVar.ewD();
        }
    }

    public void cancel() {
        gQ(ewC());
    }

    @Nullable
    public synchronized List<al> AX(boolean z) {
        ArrayList arrayList;
        if (z == this.pdY) {
            arrayList = null;
        } else {
            this.pdY = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.poD) {
            arrayList = null;
        } else {
            this.poD = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> AY(boolean z) {
        ArrayList arrayList;
        if (z == this.poE) {
            arrayList = null;
        } else {
            this.poE = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> ewC() {
        ArrayList arrayList;
        if (this.fij) {
            arrayList = null;
        } else {
            this.fij = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void gQ(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.ewD();
            }
        }
    }

    public static void gR(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.ewE();
            }
        }
    }

    public static void gS(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.ewF();
            }
        }
    }

    public static void gT(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.ewG();
            }
        }
    }
}
