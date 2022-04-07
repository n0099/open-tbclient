package com.repackage;

import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.SavedStateHandle;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.JsonWriter$OutputType;
import com.badlogic.gdx.utils.SerializationException;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.u7;
import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
/* loaded from: classes6.dex */
public class m7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public d g;
    public final u7<Class, w7<String, a>> h;
    public final u7<String, Class> i;
    public final u7<Class, String> j;
    public final u7<Class, d> k;
    public final Object[] l;
    public final Object[] m;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final t8 a;
        public Class b;
        public boolean c;

        public a(t8 t8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t8Var;
            this.b = t8Var.c((r8.f(u7.class, t8Var.getType()) || r8.f(Map.class, t8Var.getType())) ? 1 : 0);
            this.c = t8Var.f(Deprecated.class);
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class b<T> implements d<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(m7 m7Var, JsonValue jsonValue);
    }

    /* loaded from: classes6.dex */
    public interface d<T> {
        T a(m7 m7Var, JsonValue jsonValue, Class cls);
    }

    public m7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = DealIntentService.KEY_CLASS;
        this.e = true;
        this.h = new u7<>();
        this.i = new u7<>();
        this.j = new u7<>();
        this.k = new u7<>();
        new u7();
        this.l = new Object[]{null};
        this.m = new Object[]{null};
        JsonWriter$OutputType jsonWriter$OutputType = JsonWriter$OutputType.minimal;
    }

    public void a(String str, Class cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, cls) == null) {
            this.i.i(str, cls);
            this.j.i(cls, str);
        }
    }

    public final String b(Enum r5) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r5)) == null) ? this.e ? r5.name() : r5.toString() : (String) invokeL.objValue;
    }

    public void c(Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, obj, obj2) == null) {
            w7<String, a> f = f(obj2.getClass());
            u7.a<String, a> it = f(obj.getClass()).iterator();
            while (it.hasNext()) {
                u7.b next = it.next();
                a c2 = f.c(next.a);
                t8 t8Var = ((a) next.b).a;
                if (c2 != null) {
                    try {
                        c2.a.j(obj2, t8Var.a(obj));
                    } catch (ReflectionException e) {
                        throw new SerializationException("Error copying field: " + t8Var.d(), e);
                    }
                } else {
                    throw new SerializationException("To object is missing field: " + ((String) next.a));
                }
            }
        }
    }

    public <T> T d(Class<T> cls, h3 h3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, cls, h3Var)) == null) {
            try {
                return (T) k(cls, null, new n7().a(h3Var));
            } catch (Exception e) {
                throw new SerializationException("Error reading file: " + h3Var, e);
            }
        }
        return (T) invokeLL.objValue;
    }

    public Class e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? this.i.c(str) : (Class) invokeL.objValue;
    }

    public final w7<String, a> f(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cls)) == null) {
            w7<String, a> c2 = this.h.c(cls);
            if (c2 != null) {
                return c2;
            }
            y6 y6Var = new y6();
            for (Class cls2 = cls; cls2 != Object.class; cls2 = cls2.getSuperclass()) {
                y6Var.a(cls2);
            }
            ArrayList arrayList = new ArrayList();
            for (int i = y6Var.b - 1; i >= 0; i--) {
                Collections.addAll(arrayList, r8.d((Class) y6Var.get(i)));
            }
            w7<String, a> w7Var = new w7<>(arrayList.size());
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                t8 t8Var = (t8) arrayList.get(i2);
                if (!t8Var.i() && !t8Var.g() && !t8Var.h()) {
                    if (!t8Var.e()) {
                        try {
                            t8Var.k(true);
                        } catch (AccessControlException unused) {
                        }
                    }
                    w7Var.i(t8Var.d(), new a(t8Var));
                }
            }
            if (this.f) {
                w7Var.o.m();
            }
            this.h.i(cls, w7Var);
            return w7Var;
        }
        return (w7) invokeL.objValue;
    }

    public boolean g(Class cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, cls, str)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    public Object h(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cls)) == null) {
            try {
                return r8.i(cls);
            } catch (Exception e) {
                e = e;
                try {
                    s8 c2 = r8.c(cls, new Class[0]);
                    c2.c(true);
                    return c2.b(new Object[0]);
                } catch (ReflectionException unused) {
                    if (r8.f(Enum.class, cls)) {
                        if (cls.getEnumConstants() == null) {
                            cls = cls.getSuperclass();
                        }
                        return cls.getEnumConstants()[0];
                    } else if (!cls.isArray()) {
                        if (r8.g(cls) && !r8.h(cls)) {
                            throw new SerializationException("Class cannot be created (non-static member class): " + cls.getName(), e);
                        }
                        throw new SerializationException("Class cannot be created (missing no-arg constructor): " + cls.getName(), e);
                    } else {
                        throw new SerializationException("Encountered JSON object when expected array of type: " + cls.getName(), e);
                    }
                } catch (SecurityException unused2) {
                    throw new SerializationException("Error constructing instance of class: " + cls.getName(), e);
                } catch (Exception e2) {
                    e = e2;
                    throw new SerializationException("Error constructing instance of class: " + cls.getName(), e);
                }
            }
        }
        return invokeL.objValue;
    }

    public void i(Object obj, JsonValue jsonValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj, jsonValue) == null) {
            Class<?> cls = obj.getClass();
            w7<String, a> f = f(cls);
            for (JsonValue jsonValue2 = jsonValue.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                a c2 = f.c(jsonValue2.H().replace(" ", "_"));
                if (c2 == null) {
                    if (!jsonValue2.e.equals(this.a) && !this.b && !g(cls, jsonValue2.e)) {
                        SerializationException serializationException = new SerializationException("Field not found: " + jsonValue2.e + " (" + cls.getName() + SmallTailInfo.EMOTION_SUFFIX);
                        serializationException.addTrace(jsonValue2.R());
                        throw serializationException;
                    }
                } else if (!this.c || this.d || !c2.c) {
                    t8 t8Var = c2.a;
                    try {
                        t8Var.j(obj, k(t8Var.getType(), c2.b, jsonValue2));
                    } catch (SerializationException e) {
                        e.addTrace(t8Var.d() + " (" + cls.getName() + SmallTailInfo.EMOTION_SUFFIX);
                        throw e;
                    } catch (ReflectionException e2) {
                        throw new SerializationException("Error accessing field: " + t8Var.d() + " (" + cls.getName() + SmallTailInfo.EMOTION_SUFFIX, e2);
                    } catch (RuntimeException e3) {
                        SerializationException serializationException2 = new SerializationException(e3);
                        serializationException2.addTrace(jsonValue2.R());
                        serializationException2.addTrace(t8Var.d() + " (" + cls.getName() + SmallTailInfo.EMOTION_SUFFIX);
                        throw serializationException2;
                    }
                }
            }
        }
    }

    public <T> T j(Class<T> cls, JsonValue jsonValue) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, cls, jsonValue)) == null) ? (T) k(cls, null, jsonValue) : (T) invokeLL.objValue;
    }

    /* JADX DEBUG: Type inference failed for r13v3. Raw type applied. Possible types: java.lang.Class<com.repackage.y6> */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0208, code lost:
        if (r13 == java.lang.Object.class) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x0354, code lost:
        if (r13 == r0) goto L138;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0431 A[RETURN] */
    /* JADX WARN: Type inference failed for: r0v68, types: [com.repackage.m7$c] */
    /* JADX WARN: Type inference failed for: r0v71, types: [com.repackage.m7$d] */
    /* JADX WARN: Type inference failed for: r12v14, types: [com.repackage.m7$d] */
    /* JADX WARN: Type inference failed for: r12v3, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r21v0, types: [com.repackage.m7, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.badlogic.gdx.utils.JsonValue, T] */
    /* JADX WARN: Type inference failed for: r2v45, types: [com.badlogic.gdx.utils.JsonValue, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v24, types: [T, java.util.Map] */
    /* JADX WARN: Type inference failed for: r3v25, types: [T, com.repackage.z6] */
    /* JADX WARN: Type inference failed for: r3v26, types: [T, com.repackage.l7] */
    /* JADX WARN: Type inference failed for: r3v27, types: [com.repackage.q7, T] */
    /* JADX WARN: Type inference failed for: r3v28, types: [T, com.repackage.k7] */
    /* JADX WARN: Type inference failed for: r3v29, types: [com.repackage.v7, T] */
    /* JADX WARN: Type inference failed for: r3v30, types: [T, com.repackage.s7] */
    /* JADX WARN: Type inference failed for: r3v31, types: [com.repackage.t7, T] */
    /* JADX WARN: Type inference failed for: r3v32, types: [com.repackage.u7, T] */
    /* JADX WARN: Type inference failed for: r3v33, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v41, types: [com.repackage.a8] */
    /* JADX WARN: Type inference failed for: r3v45, types: [com.repackage.y6] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, T] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T k(Class<T> cls, Class cls2, JsonValue jsonValue) {
        InterceptResult invokeLLL;
        Class cls3;
        JsonValue jsonValue2;
        Class cls4;
        JsonValue jsonValue3;
        Class cls5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, cls, cls2, jsonValue)) == null) {
            Class cls6 = cls2;
            ?? r2 = (T) jsonValue;
            if (r2 == 0) {
                return null;
            }
            if (jsonValue.D()) {
                String str = this.a;
                String s = str == null ? null : r2.s(str, null);
                if (s != null) {
                    Class e = e(s);
                    if (e == null) {
                        try {
                            cls5 = r8.a(s);
                        } catch (ReflectionException e2) {
                            throw new SerializationException(e2);
                        }
                    } else {
                        cls5 = e;
                    }
                } else {
                    cls5 = cls;
                }
                if (cls5 == null) {
                    ?? r0 = this.g;
                    return r0 != 0 ? (T) r0.a(this, r2, cls5) : r2;
                } else if (this.a != null && r8.f(Collection.class, cls5)) {
                    ?? r22 = (T) r2.m("items");
                    jsonValue2 = r22;
                    cls3 = cls5;
                    if (r22 == 0) {
                        throw new SerializationException("Unable to convert object to collection: " + r22 + " (" + cls5.getName() + SmallTailInfo.EMOTION_SUFFIX);
                    }
                } else {
                    d c2 = this.k.c(cls5);
                    if (c2 == 0) {
                        if (cls5 != String.class && cls5 != Integer.class && cls5 != Boolean.class && cls5 != Float.class && cls5 != Long.class && cls5 != Double.class && cls5 != Short.class && cls5 != Byte.class && cls5 != Character.class && !r8.f(Enum.class, cls5)) {
                            T t = (T) h(cls5);
                            if (t instanceof c) {
                                ((c) t).a(this, r2);
                                return t;
                            } else if (t instanceof u7) {
                                ?? r3 = (T) ((u7) t);
                                for (JsonValue jsonValue4 = r2.f; jsonValue4 != null; jsonValue4 = jsonValue4.h) {
                                    r3.i(jsonValue4.e, k(cls6, null, jsonValue4));
                                }
                                return r3;
                            } else if (t instanceof t7) {
                                ?? r32 = (T) ((t7) t);
                                for (JsonValue jsonValue5 = r2.f; jsonValue5 != null; jsonValue5 = jsonValue5.h) {
                                    r32.h(jsonValue5.e, ((Integer) k(Integer.class, null, jsonValue5)).intValue());
                                }
                                return r32;
                            } else if (t instanceof s7) {
                                ?? r33 = (T) ((s7) t);
                                for (JsonValue jsonValue6 = r2.f; jsonValue6 != null; jsonValue6 = jsonValue6.h) {
                                    r33.g(jsonValue6.e, ((Float) k(Float.class, null, jsonValue6)).floatValue());
                                }
                                return r33;
                            } else if (t instanceof v7) {
                                ?? r34 = (T) ((v7) t);
                                for (JsonValue n = r2.n(SavedStateHandle.VALUES); n != null; n = n.h) {
                                    r34.add(k(cls6, null, n));
                                }
                                return r34;
                            } else if (t instanceof k7) {
                                ?? r35 = (T) ((k7) t);
                                for (JsonValue jsonValue7 = r2.f; jsonValue7 != null; jsonValue7 = jsonValue7.h) {
                                    r35.f(Integer.parseInt(jsonValue7.e), k(cls6, null, jsonValue7));
                                }
                                return r35;
                            } else if (t instanceof q7) {
                                ?? r36 = (T) ((q7) t);
                                for (JsonValue jsonValue8 = r2.f; jsonValue8 != null; jsonValue8 = jsonValue8.h) {
                                    r36.g(Long.parseLong(jsonValue8.e), k(cls6, null, jsonValue8));
                                }
                                return r36;
                            } else if (t instanceof l7) {
                                ?? r37 = (T) ((l7) t);
                                for (JsonValue n2 = r2.n(SavedStateHandle.VALUES); n2 != null; n2 = n2.h) {
                                    r37.a(n2.g());
                                }
                                return r37;
                            } else if (t instanceof z6) {
                                ?? r38 = (T) ((z6) t);
                                for (JsonValue jsonValue9 = r2.f; jsonValue9 != null; jsonValue9 = jsonValue9.h) {
                                    r38.f(jsonValue9.e, k(cls6, null, jsonValue9));
                                }
                                return r38;
                            } else if (t instanceof Map) {
                                ?? r39 = (T) ((Map) t);
                                for (JsonValue jsonValue10 = r2.f; jsonValue10 != null; jsonValue10 = jsonValue10.h) {
                                    if (!jsonValue10.e.equals(this.a)) {
                                        r39.put(jsonValue10.e, k(cls6, null, jsonValue10));
                                    }
                                }
                                return r39;
                            } else {
                                i(t, r2);
                                return t;
                            }
                        }
                        return (T) l("value", cls5, r2);
                    }
                    return (T) c2.a(this, r2, cls5);
                }
            } else {
                cls3 = cls;
                jsonValue2 = r2;
            }
            if (cls3 != null) {
                d c3 = this.k.c(cls3);
                if (c3 != null) {
                    return (T) c3.a(this, jsonValue2, cls3);
                }
                if (r8.f(c.class, cls3)) {
                    T t2 = (T) h(cls3);
                    ((c) t2).a(this, jsonValue2);
                    return t2;
                }
            }
            int i = 0;
            if (jsonValue2.v()) {
                Class cls7 = cls3 != null ? cls3 : y6.class;
                if (r8.f(y6.class, cls7)) {
                    T t3 = cls7 == y6.class ? (T) new y6() : (T) ((y6) h(cls7));
                    for (JsonValue jsonValue11 = jsonValue2.f; jsonValue11 != null; jsonValue11 = jsonValue11.h) {
                        ((y6) t3).a(k(cls6, null, jsonValue11));
                    }
                    return t3;
                } else if (r8.f(a8.class, cls7)) {
                    T t4 = cls7 == a8.class ? (T) new a8() : (T) ((a8) h(cls7));
                    for (JsonValue jsonValue12 = jsonValue2.f; jsonValue12 != null; jsonValue12 = jsonValue12.h) {
                        ((a8) t4).addLast(k(cls6, null, jsonValue12));
                    }
                    return t4;
                } else if (r8.f(Collection.class, cls7)) {
                    T t5 = cls7.isInterface() ? (T) new ArrayList() : (T) ((Collection) h(cls7));
                    for (JsonValue jsonValue13 = jsonValue2.f; jsonValue13 != null; jsonValue13 = jsonValue13.h) {
                        ((Collection) t5).add(k(cls6, null, jsonValue13));
                    }
                    return t5;
                } else if (cls7.isArray()) {
                    Class<?> componentType = cls7.getComponentType();
                    Class<?> cls8 = cls6;
                    if (cls6 == null) {
                        cls8 = componentType;
                    }
                    T t6 = (T) q8.a(componentType, jsonValue2.j);
                    JsonValue jsonValue14 = jsonValue2.f;
                    while (jsonValue14 != null) {
                        q8.b(t6, i, k(cls8, null, jsonValue14));
                        jsonValue14 = jsonValue14.h;
                        i++;
                    }
                    return t6;
                } else {
                    throw new SerializationException("Unable to convert value to required type: " + jsonValue2 + " (" + cls7.getName() + SmallTailInfo.EMOTION_SUFFIX);
                }
            }
            boolean B = jsonValue2.B();
            JsonValue jsonValue15 = jsonValue2;
            if (B) {
                if (cls3 != null) {
                    if (cls3 != Float.TYPE && cls3 != Float.class) {
                        if (cls3 != Integer.TYPE && cls3 != Integer.class) {
                            if (cls3 != Long.TYPE && cls3 != Long.class) {
                                if (cls3 != Double.TYPE && cls3 != Double.class) {
                                    if (cls3 == String.class) {
                                        return (T) jsonValue2.k();
                                    }
                                    if (cls3 != Short.TYPE && cls3 != Short.class) {
                                        if (cls3 == Byte.TYPE || cls3 == Byte.class) {
                                            return (T) Byte.valueOf(jsonValue2.c());
                                        }
                                        jsonValue15 = new JsonValue(jsonValue2.k());
                                    }
                                    return (T) Short.valueOf(jsonValue2.i());
                                }
                                return (T) Double.valueOf(jsonValue2.d());
                            }
                            return (T) Long.valueOf(jsonValue2.h());
                        }
                        return (T) Integer.valueOf(jsonValue2.g());
                    }
                }
                return (T) Float.valueOf(jsonValue2.e());
            }
            if (jsonValue15.w()) {
                if (cls3 != null) {
                    try {
                        if (cls3 != Boolean.TYPE) {
                            cls4 = Boolean.class;
                        }
                    } catch (NumberFormatException unused) {
                        cls4 = Boolean.class;
                    }
                }
                cls4 = Boolean.class;
                try {
                    return (T) Boolean.valueOf(jsonValue15.b());
                } catch (NumberFormatException unused2) {
                    jsonValue3 = new JsonValue(jsonValue15.k());
                    if (jsonValue3.E()) {
                    }
                }
            } else {
                cls4 = Boolean.class;
                jsonValue3 = jsonValue15;
            }
            if (jsonValue3.E()) {
                return null;
            }
            ?? r12 = (T) jsonValue3.k();
            if (cls3 == null || cls3 == String.class) {
                return r12;
            }
            if (cls3 != Integer.TYPE && cls3 != Integer.class) {
                if (cls3 != Float.TYPE && cls3 != Float.class) {
                    if (cls3 != Long.TYPE && cls3 != Long.class) {
                        if (cls3 != Double.TYPE && cls3 != Double.class) {
                            if (cls3 != Short.TYPE && cls3 != Short.class) {
                                if (cls3 == Byte.TYPE || cls3 == Byte.class) {
                                    return (T) Byte.valueOf((String) r12);
                                }
                                if (cls3 != Boolean.TYPE && cls3 != cls4) {
                                    if (cls3 != Character.TYPE && cls3 != Character.class) {
                                        if (r8.f(Enum.class, cls3)) {
                                            Enum[] enumArr = (Enum[]) cls3.getEnumConstants();
                                            int length = enumArr.length;
                                            while (i < length) {
                                                ?? r5 = (T) enumArr[i];
                                                if (r12.equals(b(r5))) {
                                                    return r5;
                                                }
                                                i++;
                                            }
                                        }
                                        if (cls3 == CharSequence.class) {
                                            return r12;
                                        }
                                        throw new SerializationException("Unable to convert value to required type: " + jsonValue3 + " (" + cls3.getName() + SmallTailInfo.EMOTION_SUFFIX);
                                    }
                                    return (T) Character.valueOf(r12.charAt(0));
                                }
                                return (T) Boolean.valueOf((String) r12);
                            }
                            return (T) Short.valueOf((String) r12);
                        }
                        return (T) Double.valueOf((String) r12);
                    }
                    return (T) Long.valueOf((String) r12);
                }
                return (T) Float.valueOf((String) r12);
            }
            return (T) Integer.valueOf((String) r12);
        }
        return (T) invokeLLL.objValue;
    }

    public <T> T l(String str, Class<T> cls, JsonValue jsonValue) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, str, cls, jsonValue)) == null) ? (T) k(cls, null, jsonValue.m(str)) : (T) invokeLLL.objValue;
    }

    public <T> T m(String str, Class<T> cls, Class cls2, JsonValue jsonValue) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, str, cls, cls2, jsonValue)) == null) ? (T) k(cls, cls2, jsonValue.m(str)) : (T) invokeLLLL.objValue;
    }

    public <T> T n(String str, Class<T> cls, T t, JsonValue jsonValue) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, str, cls, t, jsonValue)) == null) {
            JsonValue m = jsonValue.m(str);
            return m == null ? t : (T) k(cls, null, m);
        }
        return (T) invokeLLLL.objValue;
    }

    public <T> void o(Class<T> cls, d<T> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, cls, dVar) == null) {
            this.k.i(cls, dVar);
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.a = str;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
        }
    }
}
