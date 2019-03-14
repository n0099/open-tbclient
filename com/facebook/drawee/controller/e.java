package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class e<INFO> implements c<INFO> {
    private final List<c<? super INFO>> mListeners = new ArrayList(2);

    public synchronized void c(c<? super INFO> cVar) {
        this.mListeners.add(cVar);
    }

    public synchronized void cvp() {
        this.mListeners.clear();
    }

    private synchronized void l(String str, Throwable th) {
        Log.e("FdingControllerListener", str, th);
    }

    @Override // com.facebook.drawee.controller.c
    public synchronized void u(String str, Object obj) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mListeners.get(i).u(str, obj);
            } catch (Exception e) {
                l("InternalListener exception in onSubmit", e);
            }
        }
    }

    @Override // com.facebook.drawee.controller.c
    public synchronized void a(String str, @Nullable INFO info, @Nullable Animatable animatable) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mListeners.get(i).a(str, info, animatable);
            } catch (Exception e) {
                l("InternalListener exception in onFinalImageSet", e);
            }
        }
    }

    @Override // com.facebook.drawee.controller.c
    public void v(String str, @Nullable INFO info) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mListeners.get(i).v(str, info);
            } catch (Exception e) {
                l("InternalListener exception in onIntermediateImageSet", e);
            }
        }
    }

    @Override // com.facebook.drawee.controller.c
    public void k(String str, Throwable th) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mListeners.get(i).k(str, th);
            } catch (Exception e) {
                l("InternalListener exception in onIntermediateImageFailed", e);
            }
        }
    }

    @Override // com.facebook.drawee.controller.c
    public synchronized void g(String str, Throwable th) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mListeners.get(i).g(str, th);
            } catch (Exception e) {
                l("InternalListener exception in onFailure", e);
            }
        }
    }

    @Override // com.facebook.drawee.controller.c
    public synchronized void FF(String str) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mListeners.get(i).FF(str);
            } catch (Exception e) {
                l("InternalListener exception in onRelease", e);
            }
        }
    }
}
