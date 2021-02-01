package io.reactivex.disposables;

import io.reactivex.internal.util.ExceptionHelper;
/* loaded from: classes5.dex */
final class ActionDisposable extends ReferenceDisposable<io.reactivex.b.a> {
    private static final long serialVersionUID = -8219729196779211169L;

    ActionDisposable(io.reactivex.b.a aVar) {
        super(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.reactivex.disposables.ReferenceDisposable
    public void onDisposed(io.reactivex.b.a aVar) {
        try {
            aVar.run();
        } catch (Throwable th) {
            throw ExceptionHelper.P(th);
        }
    }
}
