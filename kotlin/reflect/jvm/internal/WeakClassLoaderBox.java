package kotlin.reflect.jvm.internal;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u0000B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0010¢\u0006\u0004\b\u001c\u0010\u001aJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\bR\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lkotlin/reflect/jvm/internal/WeakClassLoaderBox;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "identityHashCode", "I", "getIdentityHashCode", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ClassLoader;", "ref", "Ljava/lang/ref/WeakReference;", "getRef", "()Ljava/lang/ref/WeakReference;", "temporaryStrongRef", "Ljava/lang/ClassLoader;", "getTemporaryStrongRef", "()Ljava/lang/ClassLoader;", "setTemporaryStrongRef", "(Ljava/lang/ClassLoader;)V", "classLoader", "<init>", "kotlin-reflection"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class WeakClassLoaderBox {
    public final int identityHashCode;
    public final WeakReference<ClassLoader> ref;
    public ClassLoader temporaryStrongRef;

    public WeakClassLoaderBox(ClassLoader classLoader) {
        this.ref = new WeakReference<>(classLoader);
        this.identityHashCode = System.identityHashCode(classLoader);
        this.temporaryStrongRef = classLoader;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof WeakClassLoaderBox) && this.ref.get() == ((WeakClassLoaderBox) obj).ref.get()) {
            return true;
        }
        return false;
    }

    public final void setTemporaryStrongRef(ClassLoader classLoader) {
        this.temporaryStrongRef = classLoader;
    }

    public int hashCode() {
        return this.identityHashCode;
    }

    public String toString() {
        String classLoader;
        ClassLoader classLoader2 = this.ref.get();
        if (classLoader2 == null || (classLoader = classLoader2.toString()) == null) {
            return "<null>";
        }
        return classLoader;
    }
}
