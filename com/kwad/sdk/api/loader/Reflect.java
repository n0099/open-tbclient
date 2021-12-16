package com.kwad.sdk.api.loader;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class Reflect {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Class<?> a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f57553b;

    /* loaded from: classes3.dex */
    public static class ReflectException extends RuntimeException {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -6213149635297151442L;
        public transient /* synthetic */ FieldHolder $fh;

        public ReflectException() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReflectException(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReflectException(String str, Throwable th) {
            super(str, th);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, th};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Throwable) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReflectException(Throwable th) {
            super(th);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Throwable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final Method a;

        /* renamed from: b  reason: collision with root package name */
        public static final Method f57554b;

        /* renamed from: c  reason: collision with root package name */
        public static final Method f57555c;

        /* renamed from: d  reason: collision with root package name */
        public static final Method f57556d;

        /* renamed from: e  reason: collision with root package name */
        public static final Method f57557e;

        /* renamed from: f  reason: collision with root package name */
        public static final Method f57558f;

        /* renamed from: g  reason: collision with root package name */
        public static final Method f57559g;

        /* renamed from: h  reason: collision with root package name */
        public static final Method f57560h;

        /* renamed from: i  reason: collision with root package name */
        public static final Method f57561i;

        /* renamed from: j  reason: collision with root package name */
        public static final Method f57562j;

        /* renamed from: k  reason: collision with root package name */
        public static final Method f57563k;
        public static final Method l;
        public static final Method m;
        public static final Method n;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(979737133, "Lcom/kwad/sdk/api/loader/Reflect$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(979737133, "Lcom/kwad/sdk/api/loader/Reflect$a;");
                    return;
                }
            }
            try {
                a = Class.class.getDeclaredMethod("forName", String.class);
                f57554b = Class.class.getDeclaredMethod("forName", String.class, Boolean.TYPE, ClassLoader.class);
                f57555c = Class.class.getDeclaredMethod("getDeclaredField", String.class);
                f57556d = Class.class.getDeclaredMethod("getDeclaredFields", new Class[0]);
                f57557e = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
                f57558f = Class.class.getDeclaredMethod("getDeclaredMethods", new Class[0]);
                f57559g = Class.class.getDeclaredMethod("getDeclaredConstructor", Class[].class);
                f57560h = Class.class.getDeclaredMethod("getDeclaredConstructors", new Class[0]);
                f57561i = Class.class.getDeclaredMethod("getField", String.class);
                f57562j = Class.class.getDeclaredMethod("getFields", new Class[0]);
                f57563k = Class.class.getDeclaredMethod("getMethod", String.class, Class[].class);
                l = Class.class.getDeclaredMethod("getMethods", new Class[0]);
                m = Class.class.getDeclaredMethod("getConstructor", Class[].class);
                n = Class.class.getDeclaredMethod("getConstructors", new Class[0]);
            } catch (NoSuchMethodException e2) {
                throw new ReflectException(e2);
            }
        }

        public static Class a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                try {
                    return (Class) a.invoke(null, str);
                } catch (Exception e2) {
                    ClassNotFoundException classNotFoundException = new ClassNotFoundException();
                    classNotFoundException.initCause(e2);
                    throw classNotFoundException;
                }
            }
            return (Class) invokeL.objValue;
        }

        public static Constructor a(Class cls, Class<?>... clsArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, cls, clsArr)) == null) {
                try {
                    return (Constructor) f57559g.invoke(cls, clsArr);
                } catch (Exception e2) {
                    NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                    noSuchMethodException.initCause(e2);
                    throw noSuchMethodException;
                }
            }
            return (Constructor) invokeLL.objValue;
        }

        public static Field a(Class cls, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, cls, str)) == null) {
                try {
                    return (Field) f57555c.invoke(cls, str);
                } catch (Exception e2) {
                    NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
                    noSuchFieldException.initCause(e2);
                    throw noSuchFieldException;
                }
            }
            return (Field) invokeLL.objValue;
        }

        public static Method a(Class cls, String str, Class<?>... clsArr) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cls, str, clsArr)) == null) {
                try {
                    return (Method) f57557e.invoke(cls, str, clsArr);
                } catch (Exception e2) {
                    NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                    noSuchMethodException.initCause(e2);
                    throw noSuchMethodException;
                }
            }
            return (Method) invokeLLL.objValue;
        }

        public static Method[] a(Class cls) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, cls)) == null) {
                try {
                    return (Method[]) f57558f.invoke(cls, new Object[0]);
                } catch (Exception e2) {
                    throw new ReflectException(e2);
                }
            }
            return (Method[]) invokeL.objValue;
        }

        public static Field b(Class cls, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, cls, str)) == null) {
                try {
                    return (Field) f57561i.invoke(cls, str);
                } catch (Exception e2) {
                    NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
                    noSuchFieldException.initCause(e2);
                    throw noSuchFieldException;
                }
            }
            return (Field) invokeLL.objValue;
        }

        public static Method b(Class cls, String str, Class<?>... clsArr) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, cls, str, clsArr)) == null) {
                try {
                    return (Method) f57563k.invoke(cls, str, clsArr);
                } catch (Exception e2) {
                    NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                    noSuchMethodException.initCause(e2);
                    throw noSuchMethodException;
                }
            }
            return (Method) invokeLLL.objValue;
        }

        public static Method[] b(Class cls) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, cls)) == null) {
                try {
                    return (Method[]) l.invoke(cls, new Object[0]);
                } catch (Exception e2) {
                    throw new ReflectException(e2);
                }
            }
            return (Method[]) invokeL.objValue;
        }

        public static Constructor[] c(Class cls) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cls)) == null) {
                try {
                    return (Constructor[]) f57560h.invoke(cls, new Object[0]);
                } catch (Exception e2) {
                    throw new ReflectException(e2);
                }
            }
            return (Constructor[]) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Reflect(Class<?> cls) {
        this(cls, cls);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Class) objArr2[0], objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public Reflect(Class<?> cls, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, obj};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = cls;
        this.f57553b = obj;
    }

    public static Reflect a(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cls)) == null) ? new Reflect(cls) : (Reflect) invokeL.objValue;
    }

    public static Reflect a(Class<?> cls, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, cls, obj)) == null) ? new Reflect(cls, obj) : (Reflect) invokeLL.objValue;
    }

    public static Reflect a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj)) == null) {
            return new Reflect(obj == null ? Object.class : obj.getClass(), obj);
        }
        return (Reflect) invokeL.objValue;
    }

    public static Reflect a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) ? a(f(str)) : (Reflect) invokeL.objValue;
    }

    public static Reflect a(Constructor<?> constructor, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, constructor, objArr)) == null) {
            try {
                return a(constructor.getDeclaringClass(), ((Constructor) a(constructor)).newInstance(objArr));
            } catch (Exception e2) {
                throw new ReflectException(e2);
            }
        }
        return (Reflect) invokeLL.objValue;
    }

    public static Reflect a(Method method, Object obj, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, method, obj, objArr)) == null) {
            try {
                a(method);
                if (method.getReturnType() == Void.TYPE) {
                    method.invoke(obj, objArr);
                    return a(obj);
                }
                return a(method.invoke(obj, objArr));
            } catch (Exception e2) {
                throw new ReflectException(e2);
            }
        }
        return (Reflect) invokeLLL.objValue;
    }

    public static <T extends AccessibleObject> T a(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, t)) == null) {
            if (t == null) {
                return null;
            }
            if (t instanceof Member) {
                Member member = (Member) t;
                if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                    return t;
                }
            }
            if (!t.isAccessible()) {
                t.setAccessible(true);
            }
            return t;
        }
        return (T) invokeL.objValue;
    }

    private Method a(String str, Class<?>[] clsArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, str, clsArr)) == null) {
            Class<?> c2 = c();
            try {
                return a.b(c2, str, clsArr);
            } catch (NoSuchMethodException unused) {
                do {
                    try {
                        return a.a(c2, str, clsArr);
                    } catch (NoSuchMethodException unused2) {
                        c2 = c2.getSuperclass();
                        if (c2 == null) {
                            throw new NoSuchMethodException();
                        }
                    }
                } while (c2 == null);
                throw new NoSuchMethodException();
            }
        }
        return (Method) invokeLL.objValue;
    }

    private boolean a(Method method, String str, Class<?>[] clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, this, method, str, clsArr)) == null) ? method.getName().equals(str) && a(method.getParameterTypes(), clsArr) : invokeLLL.booleanValue;
    }

    private boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, this, clsArr, clsArr2)) == null) {
            if (clsArr.length == clsArr2.length) {
                for (int i2 = 0; i2 < clsArr2.length; i2++) {
                    if (clsArr2[i2] != b.class && !b(clsArr[i2]).isAssignableFrom(b(clsArr2[i2]))) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static Class<?> b(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, cls)) == null) {
            if (cls == null) {
                return null;
            }
            return cls.isPrimitive() ? Boolean.TYPE == cls ? Boolean.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : Byte.TYPE == cls ? Byte.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Character.TYPE == cls ? Character.class : Void.TYPE == cls ? Void.class : cls : cls;
        }
        return (Class) invokeL.objValue;
    }

    public static Object b(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, obj)) == null) ? obj instanceof Reflect ? ((Reflect) obj).a() : obj : invokeL.objValue;
    }

    private Method b(String str, Class<?>[] clsArr) {
        InterceptResult invokeLL;
        Method[] b2;
        Method[] a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, this, str, clsArr)) == null) {
            Class<?> c2 = c();
            for (Method method : a.b(c2)) {
                if (a(method, str, clsArr)) {
                    return method;
                }
            }
            do {
                for (Method method2 : a.a(c2)) {
                    if (a(method2, str, clsArr)) {
                        return method2;
                    }
                }
                c2 = c2.getSuperclass();
            } while (c2 != null);
            throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + c() + ".");
        }
        return (Method) invokeLL.objValue;
    }

    public static Class<?>[] b(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, objArr)) == null) {
            if (objArr == null) {
                return new Class[0];
            }
            Class<?>[] clsArr = new Class[objArr.length];
            for (int i2 = 0; i2 < objArr.length; i2++) {
                Object obj = objArr[i2];
                clsArr[i2] = obj == null ? b.class : obj.getClass();
            }
            return clsArr;
        }
        return (Class[]) invokeL.objValue;
    }

    private Field e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, this, str)) == null) {
            Class<?> c2 = c();
            try {
                return (Field) a(a.b(c2, str));
            } catch (NoSuchFieldException e2) {
                do {
                    try {
                        return (Field) a(a.a(c2, str));
                    } catch (NoSuchFieldException unused) {
                        c2 = c2.getSuperclass();
                        if (c2 != null) {
                            throw new ReflectException(e2);
                        }
                    }
                } while (c2 != null);
                throw new ReflectException(e2);
            }
        }
        return (Field) invokeL.objValue;
    }

    public static Class<?> f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            try {
                return a.a(str);
            } catch (Exception e2) {
                throw new ReflectException(e2);
            }
        }
        return (Class) invokeL.objValue;
    }

    public Reflect a(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, obj)) == null) {
            try {
                Field e2 = e(str);
                if ((e2.getModifiers() & 16) == 16) {
                    try {
                        Field a2 = a.a(Field.class, "modifiers");
                        a2.setAccessible(true);
                        a2.setInt(e2, e2.getModifiers() & (-17));
                    } catch (NoSuchFieldException unused) {
                    }
                }
                e2.set(this.f57553b, b(obj));
                return this;
            } catch (Exception e3) {
                throw new ReflectException(e3);
            }
        }
        return (Reflect) invokeLL.objValue;
    }

    public Reflect a(String str, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, clsArr, objArr)) == null) {
            try {
                try {
                    return a(a(str, clsArr), this.f57553b, objArr);
                } catch (NoSuchMethodException e2) {
                    throw new ReflectException(e2);
                }
            } catch (NoSuchMethodException unused) {
                return a(b(str, clsArr), this.f57553b, objArr);
            }
        }
        return (Reflect) invokeLLL.objValue;
    }

    public Reflect a(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, objArr)) == null) ? a(str, b(objArr), objArr) : (Reflect) invokeLL.objValue;
    }

    public Reflect a(Class<?>[] clsArr, Object... objArr) {
        Constructor[] c2;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, clsArr, objArr)) == null) {
            try {
                return a(a.a(c(), clsArr), objArr);
            } catch (NoSuchMethodException e2) {
                for (Constructor constructor : a.c(c())) {
                    if (a(constructor.getParameterTypes(), clsArr)) {
                        return a(constructor, objArr);
                    }
                }
                throw new ReflectException(e2);
            }
        }
        return (Reflect) invokeLL.objValue;
    }

    public Reflect a(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, objArr)) == null) ? a(b(objArr), objArr) : (Reflect) invokeL.objValue;
    }

    public <T> T a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (T) this.f57553b : (T) invokeV.objValue;
    }

    public Reflect b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? a(new Object[0]) : (Reflect) invokeV.objValue;
    }

    public <T> T b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? (T) c(str).a() : (T) invokeL.objValue;
    }

    public Reflect c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            try {
                Field e2 = e(str);
                return a(e2.getType(), e2.get(this.f57553b));
            } catch (Exception e3) {
                throw new ReflectException(e3);
            }
        }
        return (Reflect) invokeL.objValue;
    }

    public Class<?> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.a : (Class) invokeV.objValue;
    }

    public Reflect d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) ? a(str, new Object[0]) : (Reflect) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, obj)) == null) {
            if (obj instanceof Reflect) {
                return this.f57553b.equals(((Reflect) obj).a());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f57553b.hashCode() : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? String.valueOf(this.f57553b) : (String) invokeV.objValue;
    }
}
