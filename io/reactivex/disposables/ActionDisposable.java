package io.reactivex.disposables;

import f.b.w.a;
import io.reactivex.internal.util.ExceptionHelper;
/* loaded from: classes7.dex */
public final class ActionDisposable extends ReferenceDisposable<a> {
    public static final long serialVersionUID = -8219729196779211169L;

    public ActionDisposable(a aVar) {
        super(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // io.reactivex.disposables.ReferenceDisposable
    public void onDisposed(a aVar) {
        try {
            aVar.run();
        } catch (Throwable th) {
            throw ExceptionHelper.c(th);
        }
    }
}
