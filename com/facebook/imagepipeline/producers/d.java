package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes10.dex */
public class d implements ak {
    @GuardedBy("this")
    private boolean lJH;
    private final Object lJw;
    private final ImageRequest lJx;
    private final am lUp;
    private final ImageRequest.RequestLevel lUq;
    @GuardedBy("this")
    private Priority lUr;
    @GuardedBy("this")
    private boolean lUs;
    private final String mId;
    @GuardedBy("this")
    private boolean Tq = false;
    @GuardedBy("this")
    private final List<al> mCallbacks = new ArrayList();

    public d(ImageRequest imageRequest, String str, am amVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.lJx = imageRequest;
        this.mId = str;
        this.lUp = amVar;
        this.lJw = obj;
        this.lUq = requestLevel;
        this.lJH = z;
        this.lUr = priority;
        this.lUs = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest dqh() {
        return this.lJx;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public am dqi() {
        return this.lUp;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public Object dkO() {
        return this.lJw;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public ImageRequest.RequestLevel dqj() {
        return this.lUq;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean dqk() {
        return this.lJH;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized Priority dql() {
        return this.lUr;
    }

    @Override // com.facebook.imagepipeline.producers.ak
    public synchronized boolean dqm() {
        return this.lUs;
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
            alVar.dmy();
        }
    }

    public void cancel() {
        fa(dqn());
    }

    @Nullable
    public synchronized List<al> vo(boolean z) {
        ArrayList arrayList;
        if (z == this.lJH) {
            arrayList = null;
        } else {
            this.lJH = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> a(Priority priority) {
        ArrayList arrayList;
        if (priority == this.lUr) {
            arrayList = null;
        } else {
            this.lUr = priority;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> vp(boolean z) {
        ArrayList arrayList;
        if (z == this.lUs) {
            arrayList = null;
        } else {
            this.lUs = z;
            arrayList = new ArrayList(this.mCallbacks);
        }
        return arrayList;
    }

    @Nullable
    public synchronized List<al> dqn() {
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
                alVar.dmy();
            }
        }
    }

    public static void fb(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dqo();
            }
        }
    }

    public static void fc(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dqp();
            }
        }
    }

    public static void fd(@Nullable List<al> list) {
        if (list != null) {
            for (al alVar : list) {
                alVar.dqq();
            }
        }
    }
}
