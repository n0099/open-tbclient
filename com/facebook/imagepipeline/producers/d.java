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
    private final Object pdL;
    private final ImageRequest pdM;
    @GuardedBy("this")
    private boolean pdW;
    private final ImageRequest.RequestLevel poA;
    @GuardedBy("this")
    private Priority poB;
    @GuardedBy("this")
    private boolean poC;
    private final am poz;

    public d(ImageRequest imageRequest, String str, am amVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.pdM = imageRequest;
        this.mId = str;
        this.poz = amVar;
        this.pdL = obj;
        this.poA = requestLevel;
        this.pdW = z;
        this.poB = priority;
        this.poC = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest ewv() {
        return this.pdM;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public am eww() {
        return this.poz;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public Object erm() {
        return this.pdL;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest.RequestLevel ewx() {
        return this.poA;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean ewy() {
        return this.pdW;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized Priority ewz() {
        return this.poB;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean ewA() {
        return this.poC;
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
            alVar.ewC();
        }
    }

    public void cancel() {
        gQ(ewB());
    }

    @Nullable
    public synchronized List<al> AX(boolean z) {
        ArrayList arrayList;
        if (z == this.pdW) {
            arrayList = null;
        } else {
            this.pdW = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.poB) {
            arrayList = null;
        } else {
            this.poB = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> AY(boolean z) {
        ArrayList arrayList;
        if (z == this.poC) {
            arrayList = null;
        } else {
            this.poC = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> ewB() {
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
                alVar.ewC();
            }
        }
    }

    public static void gR(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.ewD();
            }
        }
    }

    public static void gS(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.ewE();
            }
        }
    }

    public static void gT(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.ewF();
            }
        }
    }
}
