package io.reactivex.exceptions;

import io.reactivex.annotations.Beta;
import io.reactivex.annotations.NonNull;
@Beta
/* loaded from: classes7.dex */
public final class OnErrorNotImplementedException extends RuntimeException {
    public static final long serialVersionUID = -6298857009889503852L;

    public OnErrorNotImplementedException(String str, @NonNull Throwable th) {
        super(str, th == null ? new NullPointerException() : th);
    }

    public OnErrorNotImplementedException(@NonNull Throwable th) {
        super(th != null ? th.getMessage() : null, th == null ? new NullPointerException() : th);
    }
}
