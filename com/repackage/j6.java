package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.SerializationException;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.m7;
import com.repackage.s3;
import com.repackage.u7;
import com.repackage.z3;
/* loaded from: classes6.dex */
public class j6 implements f7 {
    public static /* synthetic */ Interceptable $ic;
    public static final Class[] e;
    public transient /* synthetic */ FieldHolder $fh;
    public u7<Class, u7<String, Object>> a;
    public z3 b;
    public float c;
    public final u7<String, Class> d;

    /* loaded from: classes6.dex */
    public class a extends m7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j6 n;

        public a(j6 j6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.n = j6Var;
        }

        @Override // com.repackage.m7
        public boolean g(Class cls, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cls, str)) == null) ? str.equals("parent") : invokeLL.booleanValue;
        }

        @Override // com.repackage.m7
        public void i(Object obj, JsonValue jsonValue) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, jsonValue) == null) {
                if (jsonValue.t("parent")) {
                    String str = (String) l("parent", String.class, jsonValue);
                    Class<?> cls = obj.getClass();
                    do {
                        try {
                            c(this.n.h(str, cls), obj);
                        } catch (GdxRuntimeException unused) {
                            cls = cls.getSuperclass();
                            if (cls == Object.class) {
                                SerializationException serializationException = new SerializationException("Unable to find parent resource with name: " + str);
                                serializationException.addTrace(jsonValue.f.R());
                                throw serializationException;
                            }
                        }
                    } while (cls == Object.class);
                    SerializationException serializationException2 = new SerializationException("Unable to find parent resource with name: " + str);
                    serializationException2.addTrace(jsonValue.f.R());
                    throw serializationException2;
                }
                super.i(obj, jsonValue);
            }
        }

        @Override // com.repackage.m7
        public <T> T k(Class<T> cls, Class cls2, JsonValue jsonValue) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, cls, cls2, jsonValue)) == null) {
                if (jsonValue != null && jsonValue.E() && !r8.f(CharSequence.class, cls)) {
                    return (T) this.n.h(jsonValue.k(), cls);
                }
                return (T) super.k(cls, cls2, jsonValue);
            }
            return (T) invokeLLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends m7.b<j6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j6 a;
        public final /* synthetic */ j6 b;

        public b(j6 j6Var, j6 j6Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j6Var, j6Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j6Var;
            this.a = j6Var2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.m7.d
        /* renamed from: b */
        public j6 a(m7 m7Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m7Var, jsonValue, cls)) == null) {
                for (JsonValue jsonValue2 = jsonValue.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                    try {
                        Class e = m7Var.e(jsonValue2.H());
                        if (e == null) {
                            e = r8.a(jsonValue2.H());
                        }
                        c(m7Var, e, jsonValue2);
                    } catch (ReflectionException e2) {
                        throw new SerializationException(e2);
                    }
                }
                return this.a;
            }
            return (j6) invokeLLL.objValue;
        }

        public final void c(m7 m7Var, Class cls, JsonValue jsonValue) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, m7Var, cls, jsonValue) == null) {
                Class cls2 = cls == f.class ? t6.class : cls;
                for (JsonValue jsonValue2 = jsonValue.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                    Object j = m7Var.j(cls, jsonValue2);
                    if (j != null) {
                        try {
                            this.b.f(jsonValue2.e, j, cls2);
                            if (cls2 != t6.class && r8.f(t6.class, cls2)) {
                                this.b.f(jsonValue2.e, j, t6.class);
                            }
                        } catch (Exception e) {
                            throw new SerializationException("Error reading " + r8.e(cls) + ": " + jsonValue2.e, e);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends m7.b<s3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h3 a;
        public final /* synthetic */ j6 b;

        public c(j6 j6Var, h3 h3Var, j6 j6Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j6Var, h3Var, j6Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h3Var;
            this.b = j6Var2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.m7.d
        /* renamed from: b */
        public s3 a(m7 m7Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            s3 s3Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m7Var, jsonValue, cls)) == null) {
                String str = (String) m7Var.l("file", String.class, jsonValue);
                int intValue = ((Integer) m7Var.n("scaledSize", Integer.TYPE, -1, jsonValue)).intValue();
                Boolean bool = (Boolean) m7Var.n("flip", Boolean.class, Boolean.FALSE, jsonValue);
                Boolean bool2 = (Boolean) m7Var.n("markupEnabled", Boolean.class, Boolean.FALSE, jsonValue);
                h3 a = this.a.i().a(str);
                if (!a.c()) {
                    a = b1.d.a(str);
                }
                if (a.c()) {
                    String h = a.h();
                    try {
                        y6<a4> m = this.b.m(h);
                        if (m != null) {
                            s3Var = new s3(new s3.a(a, bool.booleanValue()), m, true);
                        } else {
                            a4 a4Var = (a4) this.b.r(h, a4.class);
                            if (a4Var != null) {
                                s3Var = new s3(a, a4Var, bool.booleanValue());
                            } else {
                                h3 i = a.i();
                                h3 a2 = i.a(h + EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX);
                                if (a2.c()) {
                                    s3Var = new s3(a, a2, bool.booleanValue());
                                } else {
                                    s3Var = new s3(a, bool.booleanValue());
                                }
                            }
                        }
                        s3Var.f().p = bool2.booleanValue();
                        if (intValue != -1) {
                            s3Var.f().h(intValue / s3Var.a());
                        }
                        return s3Var;
                    } catch (RuntimeException e) {
                        throw new SerializationException("Error loading bitmap font: " + a, e);
                    }
                }
                throw new SerializationException("Font file not found: " + a);
            }
            return (s3) invokeLLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d extends m7.b<i3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j6 a;

        public d(j6 j6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.m7.d
        /* renamed from: b */
        public i3 a(m7 m7Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m7Var, jsonValue, cls)) == null) {
                if (jsonValue.E()) {
                    return (i3) this.a.h(jsonValue.k(), i3.class);
                }
                String str = (String) m7Var.n("hex", String.class, null, jsonValue);
                if (str != null) {
                    return i3.h(str);
                }
                return new i3(((Float) m7Var.n("r", Float.TYPE, Float.valueOf(0.0f), jsonValue)).floatValue(), ((Float) m7Var.n("g", Float.TYPE, Float.valueOf(0.0f), jsonValue)).floatValue(), ((Float) m7Var.n("b", Float.TYPE, Float.valueOf(0.0f), jsonValue)).floatValue(), ((Float) m7Var.n("a", Float.TYPE, Float.valueOf(1.0f), jsonValue)).floatValue());
            }
            return (i3) invokeLLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class e extends m7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j6 a;

        public e(j6 j6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j6Var;
        }

        @Override // com.repackage.m7.d
        public Object a(m7 m7Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, m7Var, jsonValue, cls)) == null) {
                String str = (String) m7Var.l("name", String.class, jsonValue);
                i3 i3Var = (i3) m7Var.l("color", i3.class, jsonValue);
                if (i3Var != null) {
                    t6 q = this.a.q(str, i3Var);
                    if (q instanceof s6) {
                        ((s6) q).n(jsonValue.e + " (" + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3Var + SmallTailInfo.EMOTION_SUFFIX);
                    }
                    return q;
                }
                throw new SerializationException("TintedDrawable missing color: " + jsonValue);
            }
            return invokeLLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964038023, "Lcom/repackage/j6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964038023, "Lcom/repackage/j6;");
                return;
            }
        }
        e = new Class[]{s3.class, i3.class, f.class, u6.class, v6.class, w6.class, x6.class, a6.class, b6.class, c6.class, d6.class, e6.class, f6.class, g6.class, h6.class, i6.class, k6.class, l6.class, m6.class, n6.class, o6.class, p6.class, q6.class, r6.class};
    }

    public j6() {
        Class[] clsArr;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new u7<>();
        this.c = 1.0f;
        this.d = new u7<>(e.length);
        for (Class cls : e) {
            this.d.i(cls.getSimpleName(), cls);
        }
    }

    public void a(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, obj) == null) {
            f(str, obj, obj.getClass());
        }
    }

    @Override // com.repackage.f7
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            z3 z3Var = this.b;
            if (z3Var != null) {
                z3Var.dispose();
            }
            u7.e<u7<String, Object>> n = this.a.n();
            n.d();
            while (n.hasNext()) {
                u7.e<Object> n2 = n.next().n();
                n2.d();
                while (n2.hasNext()) {
                    Object next = n2.next();
                    if (next instanceof f7) {
                        ((f7) next).dispose();
                    }
                }
            }
        }
    }

    public void f(String str, Object obj, Class cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, obj, cls) == null) {
            if (str == null) {
                throw new IllegalArgumentException("name cannot be null.");
            }
            if (obj != null) {
                u7<String, Object> c2 = this.a.c(cls);
                if (c2 == null) {
                    c2 = new u7<>((cls == a4.class || cls == t6.class || cls == y3.class) ? 256 : 64);
                    this.a.i(cls, c2);
                }
                c2.i(str, obj);
                return;
            }
            throw new IllegalArgumentException("resource cannot be null.");
        }
    }

    public void g(z3 z3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, z3Var) == null) {
            y6<z3.a> g = z3Var.g();
            int i = g.b;
            for (int i2 = 0; i2 < i; i2++) {
                z3.a aVar = g.get(i2);
                String str = aVar.i;
                if (aVar.h != -1) {
                    str = str + "_" + aVar.h;
                }
                f(str, aVar, a4.class);
            }
        }
    }

    public <T> T h(String str, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, cls)) == null) {
            if (str != null) {
                if (cls != null) {
                    if (cls == t6.class) {
                        return (T) i(str);
                    }
                    if (cls == a4.class) {
                        return (T) l(str);
                    }
                    if (cls == u3.class) {
                        return (T) k(str);
                    }
                    if (cls == y3.class) {
                        return (T) n(str);
                    }
                    u7<String, Object> c2 = this.a.c(cls);
                    if (c2 != null) {
                        T t = (T) c2.c(str);
                        if (t != null) {
                            return t;
                        }
                        throw new GdxRuntimeException("No " + cls.getName() + " registered with name: " + str);
                    }
                    throw new GdxRuntimeException("No " + cls.getName() + " registered with name: " + str);
                }
                throw new IllegalArgumentException("type cannot be null.");
            }
            throw new IllegalArgumentException("name cannot be null.");
        }
        return (T) invokeLL.objValue;
    }

    public t6 i(String str) {
        InterceptResult invokeL;
        t6 v6Var;
        t6 v6Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            t6 t6Var = (t6) r(str, t6.class);
            if (t6Var != null) {
                return t6Var;
            }
            try {
                a4 l = l(str);
                if (l instanceof z3.a) {
                    z3.a aVar = (z3.a) l;
                    if (aVar.k("split") != null) {
                        v6Var2 = new u6(k(str));
                    } else if (aVar.p || aVar.l != aVar.n || aVar.m != aVar.o) {
                        v6Var2 = new v6(n(str));
                    }
                    t6Var = v6Var2;
                }
                if (t6Var == null) {
                    t6 w6Var = new w6(l);
                    try {
                        if (this.c != 1.0f) {
                            s(w6Var);
                        }
                    } catch (GdxRuntimeException unused) {
                    }
                    t6Var = w6Var;
                }
            } catch (GdxRuntimeException unused2) {
            }
            if (t6Var == null) {
                u3 u3Var = (u3) r(str, u3.class);
                if (u3Var != null) {
                    v6Var = new u6(u3Var);
                } else {
                    y3 y3Var = (y3) r(str, y3.class);
                    if (y3Var != null) {
                        v6Var = new v6(y3Var);
                    } else {
                        throw new GdxRuntimeException("No Drawable, NinePatch, TextureRegion, Texture, or Sprite registered with name: " + str);
                    }
                }
                t6Var = v6Var;
            }
            if (t6Var instanceof s6) {
                ((s6) t6Var).n(str);
            }
            f(str, t6Var, t6.class);
            return t6Var;
        }
        return (t6) invokeL.objValue;
    }

    public m7 j(h3 h3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, h3Var)) == null) {
            a aVar = new a(this);
            aVar.p(null);
            aVar.q(false);
            aVar.o(j6.class, new b(this, this));
            aVar.o(s3.class, new c(this, h3Var, this));
            aVar.o(i3.class, new d(this));
            aVar.o(f.class, new e(this));
            u7.a<String, Class> it = this.d.iterator();
            while (it.hasNext()) {
                u7.b next = it.next();
                aVar.a((String) next.a, (Class) next.b);
            }
            return aVar;
        }
        return (m7) invokeL.objValue;
    }

    public u3 k(String str) {
        InterceptResult invokeL;
        int[] k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            u3 u3Var = (u3) r(str, u3.class);
            if (u3Var != null) {
                return u3Var;
            }
            try {
                a4 l = l(str);
                if ((l instanceof z3.a) && (k = ((z3.a) l).k("split")) != null) {
                    u3Var = new u3(l, k[0], k[1], k[2], k[3]);
                    int[] k2 = ((z3.a) l).k("pad");
                    if (k2 != null) {
                        u3Var.n(k2[0], k2[1], k2[2], k2[3]);
                    }
                }
                if (u3Var == null) {
                    u3Var = new u3(l);
                }
                if (this.c != 1.0f) {
                    u3Var.m(this.c, this.c);
                }
                f(str, u3Var, u3.class);
                return u3Var;
            } catch (GdxRuntimeException unused) {
                throw new GdxRuntimeException("No NinePatch, TextureRegion, or Texture registered with name: " + str);
            }
        }
        return (u3) invokeL.objValue;
    }

    public a4 l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            a4 a4Var = (a4) r(str, a4.class);
            if (a4Var != null) {
                return a4Var;
            }
            Texture texture = (Texture) r(str, Texture.class);
            if (texture != null) {
                a4 a4Var2 = new a4(texture);
                f(str, a4Var2, a4.class);
                return a4Var2;
            }
            throw new GdxRuntimeException("No TextureRegion or Texture registered with name: " + str);
        }
        return (a4) invokeL.objValue;
    }

    public y6<a4> m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            a4 a4Var = (a4) r(str + "_0", a4.class);
            if (a4Var != null) {
                y6<a4> y6Var = new y6<>();
                int i = 1;
                while (a4Var != null) {
                    y6Var.a(a4Var);
                    a4Var = (a4) r(str + "_" + i, a4.class);
                    i++;
                }
                return y6Var;
            }
            return null;
        }
        return (y6) invokeL.objValue;
    }

    public y3 n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            y3 y3Var = (y3) r(str, y3.class);
            if (y3Var != null) {
                return y3Var;
            }
            try {
                a4 l = l(str);
                if (l instanceof z3.a) {
                    z3.a aVar = (z3.a) l;
                    if (aVar.p || aVar.l != aVar.n || aVar.m != aVar.o) {
                        y3Var = new z3.b(aVar);
                    }
                }
                if (y3Var == null) {
                    y3Var = new y3(l);
                }
                if (this.c != 1.0f) {
                    y3Var.z(y3Var.n() * this.c, y3Var.k() * this.c);
                }
                f(str, y3Var, y3.class);
                return y3Var;
            } catch (GdxRuntimeException unused) {
                throw new GdxRuntimeException("No NinePatch, TextureRegion, or Texture registered with name: " + str);
            }
        }
        return (y3) invokeL.objValue;
    }

    public void o(h3 h3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, h3Var) == null) {
            try {
                j(h3Var).d(j6.class, h3Var);
            } catch (SerializationException e2) {
                throw new SerializationException("Error reading file: " + h3Var, e2);
            }
        }
    }

    public t6 p(t6 t6Var, i3 i3Var) {
        InterceptResult invokeLL;
        t6 p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, t6Var, i3Var)) == null) {
            if (t6Var instanceof w6) {
                p = ((w6) t6Var).p(i3Var);
            } else if (t6Var instanceof u6) {
                p = ((u6) t6Var).q(i3Var);
            } else if (t6Var instanceof v6) {
                p = ((v6) t6Var).p(i3Var);
            } else {
                throw new GdxRuntimeException("Unable to copy, unknown drawable type: " + t6Var.getClass());
            }
            if (p instanceof s6) {
                s6 s6Var = (s6) p;
                if (t6Var instanceof s6) {
                    s6Var.n(((s6) t6Var).m() + " (" + i3Var + SmallTailInfo.EMOTION_SUFFIX);
                } else {
                    s6Var.n(" (" + i3Var + SmallTailInfo.EMOTION_SUFFIX);
                }
            }
            return p;
        }
        return (t6) invokeLL.objValue;
    }

    public t6 q(String str, i3 i3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, i3Var)) == null) ? p(i(str), i3Var) : (t6) invokeLL.objValue;
    }

    public <T> T r(String str, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, cls)) == null) {
            if (str != null) {
                if (cls != null) {
                    u7<String, Object> c2 = this.a.c(cls);
                    if (c2 == null) {
                        return null;
                    }
                    return (T) c2.c(str);
                }
                throw new IllegalArgumentException("type cannot be null.");
            }
            throw new IllegalArgumentException("name cannot be null.");
        }
        return (T) invokeLL.objValue;
    }

    public void s(t6 t6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, t6Var) == null) {
            t6Var.b(t6Var.l() * this.c);
            t6Var.c(t6Var.g() * this.c);
            t6Var.d(t6Var.e() * this.c);
            t6Var.f(t6Var.i() * this.c);
            t6Var.j(t6Var.a() * this.c);
            t6Var.h(t6Var.k() * this.c);
        }
    }

    public j6(z3 z3Var) {
        Class[] clsArr;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {z3Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = new u7<>();
        this.c = 1.0f;
        this.d = new u7<>(e.length);
        for (Class cls : e) {
            this.d.i(cls.getSimpleName(), cls);
        }
        this.b = z3Var;
        g(z3Var);
    }
}
