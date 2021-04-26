package io.reactivex.disposables;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.internal.util.ExceptionHelper;
/* loaded from: classes7.dex */
public final class ActionDisposable extends ReferenceDisposable<Action> {
    public static final long serialVersionUID = -8219729196779211169L;

    public ActionDisposable(Action action) {
        super(action);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // io.reactivex.disposables.ReferenceDisposable
    public void onDisposed(@NonNull Action action) {
        try {
            action.run();
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }
}
