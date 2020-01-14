package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.jvm.internal.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class f {
    public static a nBv;
    public static final f nBw = new f();
    private static final a nBu = new a(null, null, null);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a {
        public final Method nBx;
        public final Method nBy;
        public final Method nBz;

        public a(Method method, Method method2, Method method3) {
            this.nBx = method;
            this.nBy = method2;
            this.nBz = method3;
        }
    }

    private f() {
    }

    public final String d(BaseContinuationImpl baseContinuationImpl) {
        Method method;
        Object invoke;
        Method method2;
        Object invoke2;
        q.j(baseContinuationImpl, "continuation");
        a aVar = nBv;
        if (aVar == null) {
            aVar = e(baseContinuationImpl);
        }
        if (aVar == nBu || (method = aVar.nBx) == null || (invoke = method.invoke(baseContinuationImpl.getClass(), new Object[0])) == null || (method2 = aVar.nBy) == null || (invoke2 = method2.invoke(invoke, new Object[0])) == null) {
            return null;
        }
        Method method3 = aVar.nBz;
        Object invoke3 = method3 != null ? method3.invoke(invoke2, new Object[0]) : null;
        if (!(invoke3 instanceof String)) {
            invoke3 = null;
        }
        return (String) invoke3;
    }

    private final a e(BaseContinuationImpl baseContinuationImpl) {
        try {
            a aVar = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            nBv = aVar;
            return aVar;
        } catch (Exception e) {
            a aVar2 = nBu;
            nBv = aVar2;
            return aVar2;
        }
    }
}
