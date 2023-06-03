package org.chromium.base.supplier;

import androidx.annotation.Nullable;
import org.chromium.base.Callback;
/* loaded from: classes2.dex */
public interface OneshotSupplier<T> extends Supplier<T> {
    @Nullable
    T onAvailable(Callback<T> callback);
}
