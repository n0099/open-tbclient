package io.reactivex.internal.functions;

import f.b.w.g;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
/* loaded from: classes7.dex */
public final class Functions {

    /* renamed from: a  reason: collision with root package name */
    public static final Runnable f69179a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final g<Throwable> f69180b = new b();

    /* loaded from: classes7.dex */
    public enum HashSetCallable implements Callable<Set<Object>> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public Set<Object> call() throws Exception {
            return new HashSet();
        }
    }

    /* loaded from: classes7.dex */
    public enum NaturalComparator implements Comparator<Object> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* loaded from: classes7.dex */
    public static final class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements g<Throwable> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // f.b.w.g
        /* renamed from: a */
        public void accept(Throwable th) {
            f.b.a0.a.f(new OnErrorNotImplementedException(th));
        }
    }
}
