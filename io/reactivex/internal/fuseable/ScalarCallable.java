package io.reactivex.internal.fuseable;

import java.util.concurrent.Callable;
/* loaded from: classes8.dex */
public interface ScalarCallable extends Callable {
    @Override // java.util.concurrent.Callable
    Object call();
}
