package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.jvm.internal.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class f {
    public static a nBq;
    public static final f nBr = new f();
    private static final a nBp = new a(null, null, null);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a {
        public final Method nBs;
        public final Method nBt;
        public final Method nBu;

        public a(Method method, Method method2, Method method3) {
            this.nBs = method;
            this.nBt = method2;
            this.nBu = method3;
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
        a aVar = nBq;
        if (aVar == null) {
            aVar = e(baseContinuationImpl);
        }
        if (aVar == nBp || (method = aVar.nBs) == null || (invoke = method.invoke(baseContinuationImpl.getClass(), new Object[0])) == null || (method2 = aVar.nBt) == null || (invoke2 = method2.invoke(invoke, new Object[0])) == null) {
            return null;
        }
        Method method3 = aVar.nBu;
        Object invoke3 = method3 != null ? method3.invoke(invoke2, new Object[0]) : null;
        if (!(invoke3 instanceof String)) {
            invoke3 = null;
        }
        return (String) invoke3;
    }

    private final a e(BaseContinuationImpl baseContinuationImpl) {
        try {
            a aVar = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            nBq = aVar;
            return aVar;
        } catch (Exception e) {
            a aVar2 = nBp;
            nBq = aVar2;
            return aVar2;
        }
    }
}
