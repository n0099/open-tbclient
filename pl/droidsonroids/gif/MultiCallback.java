package pl.droidsonroids.gif;

import android.graphics.drawable.Drawable;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes12.dex */
public class MultiCallback implements Drawable.Callback {
    private final CopyOnWriteArrayList<CallbackWeakReference> mCallbacks;
    private final boolean mUseViewInvalidate;

    public MultiCallback() {
        this(false);
    }

    public MultiCallback(boolean z) {
        this.mCallbacks = new CopyOnWriteArrayList<>();
        this.mUseViewInvalidate = z;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mCallbacks.size()) {
                CallbackWeakReference callbackWeakReference = this.mCallbacks.get(i2);
                Drawable.Callback callback = (Drawable.Callback) callbackWeakReference.get();
                if (callback != null) {
                    if (this.mUseViewInvalidate && (callback instanceof View)) {
                        ((View) callback).invalidate();
                    } else {
                        callback.invalidateDrawable(drawable);
                    }
                } else {
                    this.mCallbacks.remove(callbackWeakReference);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mCallbacks.size()) {
                CallbackWeakReference callbackWeakReference = this.mCallbacks.get(i2);
                Drawable.Callback callback = (Drawable.Callback) callbackWeakReference.get();
                if (callback != null) {
                    callback.scheduleDrawable(drawable, runnable, j);
                } else {
                    this.mCallbacks.remove(callbackWeakReference);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mCallbacks.size()) {
                CallbackWeakReference callbackWeakReference = this.mCallbacks.get(i2);
                Drawable.Callback callback = (Drawable.Callback) callbackWeakReference.get();
                if (callback != null) {
                    callback.unscheduleDrawable(drawable, runnable);
                } else {
                    this.mCallbacks.remove(callbackWeakReference);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void addView(Drawable.Callback callback) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mCallbacks.size()) {
                CallbackWeakReference callbackWeakReference = this.mCallbacks.get(i2);
                if (((Drawable.Callback) callbackWeakReference.get()) == null) {
                    this.mCallbacks.remove(callbackWeakReference);
                }
                i = i2 + 1;
            } else {
                this.mCallbacks.addIfAbsent(new CallbackWeakReference(callback));
                return;
            }
        }
    }

    public void removeView(Drawable.Callback callback) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mCallbacks.size()) {
                CallbackWeakReference callbackWeakReference = this.mCallbacks.get(i2);
                Drawable.Callback callback2 = (Drawable.Callback) callbackWeakReference.get();
                if (callback2 == null || callback2 == callback) {
                    this.mCallbacks.remove(callbackWeakReference);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* loaded from: classes12.dex */
    static final class CallbackWeakReference extends WeakReference<Drawable.Callback> {
        CallbackWeakReference(Drawable.Callback callback) {
            super(callback);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return get() == ((CallbackWeakReference) obj).get();
        }

        public int hashCode() {
            Drawable.Callback callback = (Drawable.Callback) get();
            if (callback != null) {
                return callback.hashCode();
            }
            return 0;
        }
    }
}
