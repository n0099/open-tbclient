package io.reactivex.a.b;

import android.os.Handler;
import android.os.Looper;
import io.reactivex.v;
import java.util.concurrent.Callable;
/* loaded from: classes17.dex */
public final class a {
    private static final v pNK = io.reactivex.a.a.a.d(new Callable<v>() { // from class: io.reactivex.a.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: eAD */
        public v call() throws Exception {
            return C1069a.pNL;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: io.reactivex.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static final class C1069a {
        static final v pNL = new b(new Handler(Looper.getMainLooper()));
    }

    public static v eAC() {
        return io.reactivex.a.a.a.e(pNK);
    }

    public static v c(Looper looper) {
        if (looper == null) {
            throw new NullPointerException("looper == null");
        }
        return new b(new Handler(looper));
    }
}
