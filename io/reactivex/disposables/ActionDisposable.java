package io.reactivex.disposables;

import io.reactivex.internal.util.ExceptionHelper;
/* loaded from: classes7.dex */
final class ActionDisposable extends ReferenceDisposable<io.reactivex.c.a> {
    private static final long serialVersionUID = -8219729196779211169L;

    ActionDisposable(io.reactivex.c.a aVar) {
        super(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.reactivex.disposables.ReferenceDisposable
    public void onDisposed(io.reactivex.c.a aVar) {
        try {
            aVar.run();
        } catch (Throwable th) {
            throw ExceptionHelper.L(th);
        }
    }
}
