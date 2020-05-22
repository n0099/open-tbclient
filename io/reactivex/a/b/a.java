package io.reactivex.a.b;

import android.os.Handler;
import android.os.Looper;
import io.reactivex.v;
import java.util.concurrent.Callable;
/* loaded from: classes6.dex */
public final class a {
    private static final v nmr = io.reactivex.a.a.a.d(new Callable<v>() { // from class: io.reactivex.a.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: dKz */
        public v call() throws Exception {
            return C0865a.nms;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: io.reactivex.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0865a {
        static final v nms = new b(new Handler(Looper.getMainLooper()));
    }

    public static v dKy() {
        return io.reactivex.a.a.a.e(nmr);
    }

    public static v a(Looper looper) {
        if (looper == null) {
            throw new NullPointerException("looper == null");
        }
        return new b(new Handler(looper));
    }
}
