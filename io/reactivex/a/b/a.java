package io.reactivex.a.b;

import android.os.Handler;
import android.os.Looper;
import io.reactivex.v;
import java.util.concurrent.Callable;
/* loaded from: classes5.dex */
public final class a {
    private static final v nvm = io.reactivex.a.a.a.d(new Callable<v>() { // from class: io.reactivex.a.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: dIa */
        public v call() throws Exception {
            return C0750a.nvn;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: io.reactivex.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0750a {
        static final v nvn = new b(new Handler(Looper.getMainLooper()));
    }

    public static v dHZ() {
        return io.reactivex.a.a.a.e(nvm);
    }

    public static v a(Looper looper) {
        if (looper == null) {
            throw new NullPointerException("looper == null");
        }
        return new b(new Handler(looper));
    }
}
