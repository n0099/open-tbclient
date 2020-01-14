package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes10.dex */
public class d implements ak {
    private final Object lJB;
    private final ImageRequest lJC;
    @GuardedBy("this")
    private boolean lJM;
    private final am lUu;
    private final ImageRequest.RequestLevel lUv;
    @GuardedBy("this")
    private Priority lUw;
    @GuardedBy("this")
    private boolean lUx;
    private final String mId;
    @GuardedBy("this")
    private boolean Tq = false;
    @GuardedBy("this")
    private final List<al> mCallbacks = new ArrayList();

    public d(ImageRequest imageRequest, String str, am amVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.lJC = imageRequest;
        this.mId = str;
        this.lUu = amVar;
        this.lJB = obj;
        this.lUv = requestLevel;
        this.lJM = z;
        this.lUw = priority;
        this.lUx = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest dqj() {
        return this.lJC;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public am dqk() {
        return this.lUu;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public Object dkQ() {
        return this.lJB;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest.RequestLevel dql() {
        return this.lUv;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean dqm() {
        return this.lJM;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized Priority dqn() {
        return this.lUw;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean dqo() {
        return this.lUx;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public void a(al alVar) {
        boolean z = false;
        synchronized (this) {
            this.mCallbacks.add(alVar);
            if (this.Tq) {
                z = true;
            }
        }
        if (z) {
            alVar.dmA();
        }
    }

    public void cancel() {
        fa(dqp());
    }

    @Nullable
    public synchronized List<al> vo(boolean z) {
        ArrayList arrayList;
        if (z == this.lJM) {
            arrayList = null;
        } else {
            this.lJM = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.lUw) {
            arrayList = null;
        } else {
            this.lUw = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> vp(boolean z) {
        ArrayList arrayList;
        if (z == this.lUx) {
            arrayList = null;
        } else {
            this.lUx = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> dqp() {
        ArrayList arrayList;
        if (this.Tq) {
            arrayList = null;
        } else {
            this.Tq = true;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    public static void fa(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dmA();
            }
        }
    }

    public static void fb(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dqq();
            }
        }
    }

    public static void fc(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dqr();
            }
        }
    }

    public static void fd(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dqs();
            }
        }
    }
}
