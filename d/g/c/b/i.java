package d.g.c.b;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
/* loaded from: classes6.dex */
public abstract class i {

    /* loaded from: classes6.dex */
    public static class a extends i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Method f66107a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f66108b;

        public a(Method method, Object obj) {
            this.f66107a = method;
            this.f66108b = obj;
        }

        @Override // d.g.c.b.i
        public <T> T c(Class<T> cls) throws Exception {
            i.a(cls);
            return (T) this.f66107a.invoke(this.f66108b, cls);
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Method f66109a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f66110b;

        public b(Method method, int i) {
            this.f66109a = method;
            this.f66110b = i;
        }

        @Override // d.g.c.b.i
        public <T> T c(Class<T> cls) throws Exception {
            i.a(cls);
            return (T) this.f66109a.invoke(null, cls, Integer.valueOf(this.f66110b));
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Method f66111a;

        public c(Method method) {
            this.f66111a = method;
        }

        @Override // d.g.c.b.i
        public <T> T c(Class<T> cls) throws Exception {
            i.a(cls);
            return (T) this.f66111a.invoke(null, cls, Object.class);
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends i {
        @Override // d.g.c.b.i
        public <T> T c(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls);
        }
    }

    public static void a(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (!Modifier.isInterface(modifiers)) {
            if (Modifier.isAbstract(modifiers)) {
                throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + cls.getName());
            }
            return;
        }
        throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + cls.getName());
    }

    public static i b() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    int intValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    return new b(declaredMethod2, intValue);
                } catch (Exception unused2) {
                    return new d();
                }
            } catch (Exception unused3) {
                Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                declaredMethod3.setAccessible(true);
                return new c(declaredMethod3);
            }
        }
    }

    public abstract <T> T c(Class<T> cls) throws Exception;
}
