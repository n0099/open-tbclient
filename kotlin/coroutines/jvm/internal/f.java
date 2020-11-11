package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.h;
import kotlin.jvm.internal.q;
/* JADX INFO: Access modifiers changed from: package-private */
@h
/* loaded from: classes10.dex */
public final class f {
    public static a pSp;
    public static final f pSq = new f();
    private static final a pSo = new a(null, null, null);

    /* JADX INFO: Access modifiers changed from: private */
    @h
    /* loaded from: classes10.dex */
    public static final class a {
        public final Method pSr;
        public final Method pSs;
        public final Method pSt;

        public a(Method method, Method method2, Method method3) {
            this.pSr = method;
            this.pSs = method2;
            this.pSt = method3;
        }
    }

    private f() {
    }

    public final String d(BaseContinuationImpl baseContinuationImpl) {
        Method method;
        Object invoke;
        Method method2;
        Object invoke2;
        q.n(baseContinuationImpl, "continuation");
        a aVar = pSp;
        if (aVar == null) {
            aVar = e(baseContinuationImpl);
        }
        if (aVar == pSo || (method = aVar.pSr) == null || (invoke = method.invoke(baseContinuationImpl.getClass(), new Object[0])) == null || (method2 = aVar.pSs) == null || (invoke2 = method2.invoke(invoke, new Object[0])) == null) {
            return null;
        }
        Method method3 = aVar.pSt;
        Object invoke3 = method3 != null ? method3.invoke(invoke2, new Object[0]) : null;
        if (!(invoke3 instanceof String)) {
            invoke3 = null;
        }
        return (String) invoke3;
    }

    private final a e(BaseContinuationImpl baseContinuationImpl) {
        try {
            a aVar = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            pSp = aVar;
            return aVar;
        } catch (Exception e) {
            a aVar2 = pSo;
            pSp = aVar2;
            return aVar2;
        }
    }
}
