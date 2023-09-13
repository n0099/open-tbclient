package org.chromium.base.supplier;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
import org.chromium.base.Callback;
import org.chromium.base.ObserverList;
import org.chromium.base.supplier.ObservableSupplierImpl;
/* loaded from: classes2.dex */
public class ObservableSupplierImpl<E> implements ObservableSupplier<E> {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public E mObject;
    public final Thread mThread = Thread.currentThread();
    public final Handler mHandler = new Handler();
    public final ObserverList<Callback<E>> mObservers = new ObserverList<>();

    private void checkThread() {
    }

    @Override // org.chromium.base.supplier.Supplier
    @Nullable
    public E get() {
        checkThread();
        return this.mObject;
    }

    public /* synthetic */ void a(Object obj, Callback callback) {
        if (this.mObject == obj && this.mObservers.hasObserver(callback)) {
            callback.onResult(this.mObject);
        }
    }

    @Override // org.chromium.base.supplier.ObservableSupplier
    public E addObserver(final Callback<E> callback) {
        checkThread();
        this.mObservers.addObserver(callback);
        final E e = this.mObject;
        if (e != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.b9c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        ObservableSupplierImpl.this.a(e, callback);
                    }
                }
            });
        }
        return this.mObject;
    }

    @Override // org.chromium.base.supplier.ObservableSupplier
    public void removeObserver(Callback<E> callback) {
        checkThread();
        this.mObservers.removeObserver(callback);
    }

    public void set(E e) {
        checkThread();
        if (e == this.mObject) {
            return;
        }
        this.mObject = e;
        Iterator<Callback<E>> it = this.mObservers.iterator();
        while (it.hasNext()) {
            it.next().onResult(this.mObject);
        }
    }
}
