package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class d implements aj {
    private final Object keW;
    private final ImageRequest kmO;
    private final al kmP;
    private final ImageRequest.RequestLevel kmQ;
    @GuardedBy("this")
    private boolean kmR;
    @GuardedBy("this")
    private Priority kmS;
    @GuardedBy("this")
    private boolean kmT;
    private final String mId;
    @GuardedBy("this")
    private boolean cfF = false;
    @GuardedBy("this")
    private final List<ak> mCallbacks = new ArrayList();

    public d(ImageRequest imageRequest, String str, al alVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.kmO = imageRequest;
        this.mId = str;
        this.kmP = alVar;
        this.keW = obj;
        this.kmQ = requestLevel;
        this.kmR = z;
        this.kmS = priority;
        this.kmT = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest cLK() {
        return this.kmO;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public al cLL() {
        return this.kmP;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public Object cHd() {
        return this.keW;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public ImageRequest.RequestLevel cLM() {
        return this.kmQ;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean cLN() {
        return this.kmR;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized Priority cLO() {
        return this.kmS;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public synchronized boolean cLP() {
        return this.kmT;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(ak akVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(akVar);
            if (this.cfF) {
                z = true;
            }
        }
        if (z) {
            akVar.cLR();
        }
    }

    public void cancel() {
        eG(cLQ());
    }

    @Nullable
    public synchronized List<ak> sE(boolean z) {
        ArrayList arrayList;
        if (z == this.kmR) {
            arrayList = null;
        } else {
            this.kmR = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.kmS) {
            arrayList = null;
        } else {
            this.kmS = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> sF(boolean z) {
        ArrayList arrayList;
        if (z == this.kmT) {
            arrayList = null;
        } else {
            this.kmT = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<ak> cLQ() {
        ArrayList arrayList;
        if (this.cfF) {
            arrayList = null;
        } else {
            this.cfF = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void eG(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.cLR();
            }
        }
    }

    public static void eH(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.cLS();
            }
        }
    }

    public static void eI(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.cLT();
            }
        }
    }

    public static void eJ(@Nullable List<ak> list) {
        if (list != null) {
            for (ak akVar : list) {
                akVar.cLU();
            }
        }
    }
}
