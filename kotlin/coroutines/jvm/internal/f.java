package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.h;
import kotlin.jvm.internal.q;
/* JADX INFO: Access modifiers changed from: package-private */
@h
/* loaded from: classes7.dex */
public final class f {
    public static a nDX;
    public static final f nDY = new f();
    private static final a nDW = new a(null, null, null);

    /* JADX INFO: Access modifiers changed from: private */
    @h
    /* loaded from: classes7.dex */
    public static final class a {
        public final Method nDZ;
        public final Method nEa;
        public final Method nEb;

        public a(Method method, Method method2, Method method3) {
            this.nDZ = method;
            this.nEa = method2;
            this.nEb = method3;
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
        a aVar = nDX;
        if (aVar == null) {
            aVar = e(baseContinuationImpl);
        }
        if (aVar == nDW || (method = aVar.nDZ) == null || (invoke = method.invoke(baseContinuationImpl.getClass(), new Object[0])) == null || (method2 = aVar.nEa) == null || (invoke2 = method2.invoke(invoke, new Object[0])) == null) {
            return null;
        }
        Method method3 = aVar.nEb;
        Object invoke3 = method3 != null ? method3.invoke(invoke2, new Object[0]) : null;
        if (!(invoke3 instanceof String)) {
            invoke3 = null;
        }
        return (String) invoke3;
    }

    private final a e(BaseContinuationImpl baseContinuationImpl) {
        try {
            a aVar = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            nDX = aVar;
            return aVar;
        } catch (Exception e) {
            a aVar2 = nDW;
            nDX = aVar2;
            return aVar2;
        }
    }
}
