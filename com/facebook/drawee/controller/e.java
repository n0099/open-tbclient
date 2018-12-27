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

    public synchronized void bVv() {
        this.mListeners.clear();
    }

    private synchronized void g(String str, Throwable th) {
        Log.e("FdingControllerListener", str, th);
    }

    @Override // com.facebook.drawee.controller.c
    public synchronized void onSubmit(String str, Object obj) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mListeners.get(i).onSubmit(str, obj);
            } catch (Exception e) {
                g("InternalListener exception in onSubmit", e);
            }
        }
    }

    @Override // com.facebook.drawee.controller.c
    public synchronized void onFinalImageSet(String str, @Nullable INFO info, @Nullable Animatable animatable) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mListeners.get(i).onFinalImageSet(str, info, animatable);
            } catch (Exception e) {
                g("InternalListener exception in onFinalImageSet", e);
            }
        }
    }

    @Override // com.facebook.drawee.controller.c
    public void onIntermediateImageSet(String str, @Nullable INFO info) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mListeners.get(i).onIntermediateImageSet(str, info);
            } catch (Exception e) {
                g("InternalListener exception in onIntermediateImageSet", e);
            }
        }
    }

    @Override // com.facebook.drawee.controller.c
    public void onIntermediateImageFailed(String str, Throwable th) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mListeners.get(i).onIntermediateImageFailed(str, th);
            } catch (Exception e) {
                g("InternalListener exception in onIntermediateImageFailed", e);
            }
        }
    }

    @Override // com.facebook.drawee.controller.c
    public synchronized void onFailure(String str, Throwable th) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mListeners.get(i).onFailure(str, th);
            } catch (Exception e) {
                g("InternalListener exception in onFailure", e);
            }
        }
    }

    @Override // com.facebook.drawee.controller.c
    public synchronized void onRelease(String str) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mListeners.get(i).onRelease(str);
            } catch (Exception e) {
                g("InternalListener exception in onRelease", e);
            }
        }
    }
}
