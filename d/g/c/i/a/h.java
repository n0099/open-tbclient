package d.g.c.i.a;

import com.google.common.collect.Ordering;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes6.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final Ordering<Constructor<?>> f65627a = Ordering.natural().onResultOf(new a()).reverse();

    /* loaded from: classes6.dex */
    public static class a implements d.g.c.a.g<Constructor<?>, Boolean> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.g.c.a.g
        /* renamed from: a */
        public Boolean apply(Constructor<?> constructor) {
            return Boolean.valueOf(Arrays.asList(constructor.getParameterTypes()).contains(String.class));
        }
    }

    public static void a(Class<? extends Exception> cls) {
        d.g.c.a.n.k(c(cls), "Futures.getChecked exception type (%s) must not be a RuntimeException", cls);
        d.g.c.a.n.k(b(cls), "Futures.getChecked exception type (%s) must be an accessible class with an accessible constructor whose parameters (if any) must be of type String and/or Throwable", cls);
    }

    public static boolean b(Class<? extends Exception> cls) {
        try {
            e(cls, new Exception());
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean c(Class<? extends Exception> cls) {
        return !RuntimeException.class.isAssignableFrom(cls);
    }

    public static <X> X d(Constructor<X> constructor, Throwable th) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Object[] objArr = new Object[parameterTypes.length];
        for (int i2 = 0; i2 < parameterTypes.length; i2++) {
            Class<?> cls = parameterTypes[i2];
            if (cls.equals(String.class)) {
                objArr[i2] = th.toString();
            } else if (!cls.equals(Throwable.class)) {
                return null;
            } else {
                objArr[i2] = th;
            }
        }
        try {
            return constructor.newInstance(objArr);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public static <X extends Exception> X e(Class<X> cls, Throwable th) {
        for (Constructor constructor : f(Arrays.asList(cls.getConstructors()))) {
            X x = (X) d(constructor, th);
            if (x != null) {
                if (x.getCause() == null) {
                    x.initCause(th);
                }
                return x;
            }
        }
        throw new IllegalArgumentException("No appropriate constructor for exception of type " + cls + " in response to chained exception", th);
    }

    public static <X extends Exception> List<Constructor<X>> f(List<Constructor<X>> list) {
        return (List<Constructor<X>>) f65627a.sortedCopy(list);
    }
}
