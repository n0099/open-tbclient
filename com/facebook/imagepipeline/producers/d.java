package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class d implements ak {
    @GuardedBy("this")
    private boolean lTG;
    private final Object lTv;
    private final ImageRequest lTw;
    private final String mId;
    private final am meF;
    private final ImageRequest.RequestLevel meG;
    @GuardedBy("this")
    private Priority meH;
    @GuardedBy("this")
    private boolean meI;
    @GuardedBy("this")
    private boolean dLA = false;
    @GuardedBy("this")
    private final List<al> mCallbacks = new ArrayList();

    public d(ImageRequest imageRequest, String str, am amVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.lTw = imageRequest;
        this.mId = str;
        this.meF = amVar;
        this.lTv = obj;
        this.meG = requestLevel;
        this.lTG = z;
        this.meH = priority;
        this.meI = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest dtT() {
        return this.lTw;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public am dtU() {
        return this.meF;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public Object dow() {
        return this.lTv;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest.RequestLevel dtV() {
        return this.meG;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean dtW() {
        return this.lTG;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized Priority dtX() {
        return this.meH;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean dtY() {
        return this.meI;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public void a(al alVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(alVar);
            if (this.dLA) {
                z = true;
            }
        }
        if (z) {
            alVar.dqk();
        }
    }

    public void cancel() {
        eW(dtZ());
    }

    @Nullable
    public synchronized List<al> vM(boolean z) {
        ArrayList arrayList;
        if (z == this.lTG) {
            arrayList = null;
        } else {
            this.lTG = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.meH) {
            arrayList = null;
        } else {
            this.meH = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> vN(boolean z) {
        ArrayList arrayList;
        if (z == this.meI) {
            arrayList = null;
        } else {
            this.meI = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> dtZ() {
        ArrayList arrayList;
        if (this.dLA) {
            arrayList = null;
        } else {
            this.dLA = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void eW(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dqk();
            }
        }
    }

    public static void eX(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dua();
            }
        }
    }

    public static void eY(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dub();
            }
        }
    }

    public static void eZ(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.duc();
            }
        }
    }
}
