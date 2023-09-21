package org.chromium.base.supplier;

import androidx.annotation.NonNull;
import com.baidu.tieba.qac;
import java.lang.ref.WeakReference;
import org.chromium.base.Callback;
/* loaded from: classes2.dex */
public class OneShotCallback<E> {
    public final Callback<E> mCallback;
    public final Callback<E> mCallbackWrapper = new CallbackWrapper();
    public final WeakReference<ObservableSupplier<E>> mWeakSupplier;

    /* loaded from: classes2.dex */
    public class CallbackWrapper implements Callback<E> {
        public static final /* synthetic */ boolean $assertionsDisabled = false;

        @Override // org.chromium.base.Callback
        public /* synthetic */ Runnable bind(T t) {
            return qac.$default$bind(this, t);
        }

        public CallbackWrapper() {
        }

        @Override // org.chromium.base.Callback
        public void onResult(E e) {
            OneShotCallback.this.mCallback.onResult(e);
            ((ObservableSupplier) OneShotCallback.this.mWeakSupplier.get()).removeObserver(OneShotCallback.this.mCallbackWrapper);
        }
    }

    public OneShotCallback(@NonNull ObservableSupplier<E> observableSupplier, @NonNull Callback<E> callback) {
        this.mWeakSupplier = new WeakReference<>(observableSupplier);
        this.mCallback = callback;
        observableSupplier.addObserver(this.mCallbackWrapper);
    }
}
