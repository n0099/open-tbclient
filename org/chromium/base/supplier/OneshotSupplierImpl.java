package org.chromium.base.supplier;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.chromium.base.Callback;
import org.chromium.base.Promise;
import org.chromium.base.ThreadUtils;
/* loaded from: classes2.dex */
public class OneshotSupplierImpl<T> implements OneshotSupplier<T> {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public final Promise<T> mPromise = new Promise<>();
    public final ThreadUtils.ThreadChecker mThreadChecker = new ThreadUtils.ThreadChecker();

    @Override // org.chromium.base.supplier.Supplier
    @Nullable
    public T get() {
        this.mThreadChecker.assertOnValidThread();
        if (this.mPromise.isFulfilled()) {
            return this.mPromise.getResult();
        }
        return null;
    }

    @Override // org.chromium.base.supplier.OneshotSupplier
    public T onAvailable(Callback<T> callback) {
        this.mThreadChecker.assertOnValidThread();
        this.mPromise.then(callback);
        return get();
    }

    public void set(@NonNull T t) {
        this.mThreadChecker.assertOnValidThread();
        this.mPromise.fulfill(t);
    }
}
