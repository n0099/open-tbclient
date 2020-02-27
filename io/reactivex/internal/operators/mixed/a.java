package io.reactivex.internal.operators.mixed;

import io.reactivex.aa;
import io.reactivex.c;
import io.reactivex.c.h;
import io.reactivex.e;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.maybe.MaybeToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.o;
import io.reactivex.u;
import java.util.concurrent.Callable;
/* loaded from: classes7.dex */
final class a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> boolean a(Object obj, h<? super T, ? extends e> hVar, c cVar) {
        if (obj instanceof Callable) {
            e eVar = null;
            try {
                Object obj2 = (Object) ((Callable) obj).call();
                if (obj2 != 0) {
                    eVar = (e) io.reactivex.internal.functions.a.h(hVar.apply(obj2), "The mapper returned a null CompletableSource");
                }
                if (eVar == null) {
                    EmptyDisposable.complete(cVar);
                } else {
                    eVar.a(cVar);
                }
                return true;
            } catch (Throwable th) {
                io.reactivex.exceptions.a.H(th);
                EmptyDisposable.error(th, cVar);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, R> boolean a(Object obj, h<? super T, ? extends o<? extends R>> hVar, u<? super R> uVar) {
        if (obj instanceof Callable) {
            o oVar = null;
            try {
                Object obj2 = (Object) ((Callable) obj).call();
                if (obj2 != 0) {
                    oVar = (o) io.reactivex.internal.functions.a.h(hVar.apply(obj2), "The mapper returned a null MaybeSource");
                }
                if (oVar == null) {
                    EmptyDisposable.complete(uVar);
                } else {
                    oVar.a(MaybeToObservable.b(uVar));
                }
                return true;
            } catch (Throwable th) {
                io.reactivex.exceptions.a.H(th);
                EmptyDisposable.error(th, uVar);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, R> boolean b(Object obj, h<? super T, ? extends aa<? extends R>> hVar, u<? super R> uVar) {
        if (obj instanceof Callable) {
            aa aaVar = null;
            try {
                Object obj2 = (Object) ((Callable) obj).call();
                if (obj2 != 0) {
                    aaVar = (aa) io.reactivex.internal.functions.a.h(hVar.apply(obj2), "The mapper returned a null SingleSource");
                }
                if (aaVar == null) {
                    EmptyDisposable.complete(uVar);
                } else {
                    aaVar.a(SingleToObservable.c(uVar));
                }
                return true;
            } catch (Throwable th) {
                io.reactivex.exceptions.a.H(th);
                EmptyDisposable.error(th, uVar);
                return true;
            }
        }
        return false;
    }
}
