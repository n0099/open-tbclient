package d.g.c.h;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
/* loaded from: classes6.dex */
public abstract class b<T, R> extends d.g.c.h.a implements GenericDeclaration {

    /* loaded from: classes6.dex */
    public static class a<T> extends b<T, T> {

        /* renamed from: g  reason: collision with root package name */
        public final Constructor<?> f66290g;

        public a(Constructor<?> constructor) {
            super(constructor);
            this.f66290g = constructor;
        }

        public Type[] b() {
            Type[] genericParameterTypes = this.f66290g.getGenericParameterTypes();
            if (genericParameterTypes.length <= 0 || !c()) {
                return genericParameterTypes;
            }
            Class<?>[] parameterTypes = this.f66290g.getParameterTypes();
            return (genericParameterTypes.length == parameterTypes.length && parameterTypes[0] == getDeclaringClass().getEnclosingClass()) ? (Type[]) Arrays.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length) : genericParameterTypes;
        }

        public final boolean c() {
            Class<?> declaringClass = this.f66290g.getDeclaringClass();
            if (declaringClass.getEnclosingConstructor() != null) {
                return true;
            }
            Method enclosingMethod = declaringClass.getEnclosingMethod();
            if (enclosingMethod != null) {
                return !Modifier.isStatic(enclosingMethod.getModifiers());
            }
            return (declaringClass.getEnclosingClass() == null || Modifier.isStatic(declaringClass.getModifiers())) ? false : true;
        }

        @Override // java.lang.reflect.GenericDeclaration
        public final TypeVariable<?>[] getTypeParameters() {
            TypeVariable<Class<? super T>>[] typeParameters = getDeclaringClass().getTypeParameters();
            TypeVariable<Constructor<?>>[] typeParameters2 = this.f66290g.getTypeParameters();
            TypeVariable<?>[] typeVariableArr = new TypeVariable[typeParameters.length + typeParameters2.length];
            System.arraycopy(typeParameters, 0, typeVariableArr, 0, typeParameters.length);
            System.arraycopy(typeParameters2, 0, typeVariableArr, typeParameters.length, typeParameters2.length);
            return typeVariableArr;
        }
    }

    /* renamed from: d.g.c.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1848b<T> extends b<T, Object> {

        /* renamed from: g  reason: collision with root package name */
        public final Method f66291g;

        public C1848b(Method method) {
            super(method);
            this.f66291g = method;
        }

        @Override // java.lang.reflect.GenericDeclaration
        public final TypeVariable<?>[] getTypeParameters() {
            return this.f66291g.getTypeParameters();
        }
    }

    public <M extends AccessibleObject & Member> b(M m) {
        super(m);
    }

    @Override // d.g.c.h.a, java.lang.reflect.Member
    public final Class<? super T> getDeclaringClass() {
        return (Class<? super T>) super.getDeclaringClass();
    }
}
