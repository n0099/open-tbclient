package rx.functions;

import java.util.concurrent.Callable;
/* loaded from: classes2.dex */
public interface e<R> extends Callable<R> {
    @Override // java.util.concurrent.Callable
    R call();
}
