package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes13.dex */
public class e<INFO> implements c<INFO> {
    private final List<c<? super INFO>> mListeners = new ArrayList(2);

    public synchronized void d(c<? super INFO> cVar) {
        this.mListeners.add(cVar);
    }

    public synchronized void e(c<? super INFO> cVar) {
        int indexOf = this.mListeners.indexOf(cVar);
        if (indexOf != -1) {
            this.mListeners.set(indexOf, null);
        }
    }

    public synchronized void doG() {
        this.mListeners.clear();
    }

    private synchronized void k(String str, Throwable th) {
        Log.e("FdingControllerListener", str, th);
    }

    @Override // com.facebook.drawee.controller.c
    public synchronized void g(String str, Object obj) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                c<? super INFO> cVar = this.mListeners.get(i);
                if (cVar != null) {
                    cVar.g(str, obj);
                }
            } catch (Exception e) {
                k("InternalListener exception in onSubmit", e);
            }
        }
    }

    @Override // com.facebook.drawee.controller.c
    public synchronized void a(String str, @Nullable INFO info, @Nullable Animatable animatable) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                c<? super INFO> cVar = this.mListeners.get(i);
                if (cVar != null) {
                    cVar.a(str, info, animatable);
                }
            } catch (Exception e) {
                k("InternalListener exception in onFinalImageSet", e);
            }
        }
    }

    @Override // com.facebook.drawee.controller.c
    public void h(String str, @Nullable INFO info) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                c<? super INFO> cVar = this.mListeners.get(i);
                if (cVar != null) {
                    cVar.h(str, info);
                }
            } catch (Exception e) {
                k("InternalListener exception in onIntermediateImageSet", e);
            }
        }
    }

    @Override // com.facebook.drawee.controller.c
    public void f(String str, Throwable th) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                c<? super INFO> cVar = this.mListeners.get(i);
                if (cVar != null) {
                    cVar.f(str, th);
                }
            } catch (Exception e) {
                k("InternalListener exception in onIntermediateImageFailed", e);
            }
        }
    }

    @Override // com.facebook.drawee.controller.c
    public synchronized void g(String str, Throwable th) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                c<? super INFO> cVar = this.mListeners.get(i);
                if (cVar != null) {
                    cVar.g(str, th);
                }
            } catch (Exception e) {
                k("InternalListener exception in onFailure", e);
            }
        }
    }

    @Override // com.facebook.drawee.controller.c
    public synchronized void el(String str) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                c<? super INFO> cVar = this.mListeners.get(i);
                if (cVar != null) {
                    cVar.el(str);
                }
            } catch (Exception e) {
                k("InternalListener exception in onRelease", e);
            }
        }
    }
}
