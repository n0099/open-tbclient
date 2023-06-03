package org.chromium.base.supplier;

import org.chromium.base.Callback;
/* loaded from: classes2.dex */
public interface ObservableSupplier<E> extends Supplier<E> {
    E addObserver(Callback<E> callback);

    void removeObserver(Callback<E> callback);
}
