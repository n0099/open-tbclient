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
import com.repackage.b4;
import com.repackage.o7;
import com.repackage.u3;
import com.repackage.w7;
/* loaded from: classes6.dex */
public class l6 implements h7 {
    public static /* synthetic */ Interceptable $ic;
    public static final Class[] e;
    public transient /* synthetic */ FieldHolder $fh;
    public w7<Class, w7<String, Object>> a;
    public b4 b;
    public float c;
    public final w7<String, Class> d;

    /* loaded from: classes6.dex */
    public class a extends o7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l6 n;

        public a(l6 l6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.n = l6Var;
        }

        @Override // com.repackage.o7
        public boolean g(Class cls, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cls, str)) == null) ? str.equals("parent") : invokeLL.booleanValue;
        }

        @Override // com.repackage.o7
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

        @Override // com.repackage.o7
        public <T> T k(Class<T> cls, Class cls2, JsonValue jsonValue) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, cls, cls2, jsonValue)) == null) {
                if (jsonValue != null && jsonValue.E() && !t8.f(CharSequence.class, cls)) {
                    return (T) this.n.h(jsonValue.k(), cls);
                }
                return (T) super.k(cls, cls2, jsonValue);
            }
            return (T) invokeLLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends o7.b<l6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l6 a;
        public final /* synthetic */ l6 b;

        public b(l6 l6Var, l6 l6Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l6Var, l6Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l6Var;
            this.a = l6Var2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.o7.d
        /* renamed from: b */
        public l6 a(o7 o7Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o7Var, jsonValue, cls)) == null) {
                for (JsonValue jsonValue2 = jsonValue.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                    try {
                        Class e = o7Var.e(jsonValue2.H());
                        if (e == null) {
                            e = t8.a(jsonValue2.H());
                        }
                        c(o7Var, e, jsonValue2);
                    } catch (ReflectionException e2) {
                        throw new SerializationException(e2);
                    }
                }
                return this.a;
            }
            return (l6) invokeLLL.objValue;
        }

        public final void c(o7 o7Var, Class cls, JsonValue jsonValue) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, o7Var, cls, jsonValue) == null) {
                Class cls2 = cls == f.class ? v6.class : cls;
                for (JsonValue jsonValue2 = jsonValue.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                    Object j = o7Var.j(cls, jsonValue2);
                    if (j != null) {
                        try {
                            this.b.f(jsonValue2.e, j, cls2);
                            if (cls2 != v6.class && t8.f(v6.class, cls2)) {
                                this.b.f(jsonValue2.e, j, v6.class);
                            }
                        } catch (Exception e) {
                            throw new SerializationException("Error reading " + t8.e(cls) + ": " + jsonValue2.e, e);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends o7.b<u3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j3 a;
        public final /* synthetic */ l6 b;

        public c(l6 l6Var, j3 j3Var, l6 l6Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l6Var, j3Var, l6Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j3Var;
            this.b = l6Var2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.o7.d
        /* renamed from: b */
        public u3 a(o7 o7Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            u3 u3Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o7Var, jsonValue, cls)) == null) {
                String str = (String) o7Var.l("file", String.class, jsonValue);
                int intValue = ((Integer) o7Var.n("scaledSize", Integer.TYPE, -1, jsonValue)).intValue();
                Boolean bool = (Boolean) o7Var.n("flip", Boolean.class, Boolean.FALSE, jsonValue);
                Boolean bool2 = (Boolean) o7Var.n("markupEnabled", Boolean.class, Boolean.FALSE, jsonValue);
                j3 a = this.a.i().a(str);
                if (!a.c()) {
                    a = e1.d.a(str);
                }
                if (a.c()) {
                    String h = a.h();
                    try {
                        a7<c4> m = this.b.m(h);
                        if (m != null) {
                            u3Var = new u3(new u3.a(a, bool.booleanValue()), m, true);
                        } else {
                            c4 c4Var = (c4) this.b.r(h, c4.class);
                            if (c4Var != null) {
                                u3Var = new u3(a, c4Var, bool.booleanValue());
                            } else {
                                j3 i = a.i();
                                j3 a2 = i.a(h + EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX);
                                if (a2.c()) {
                                    u3Var = new u3(a, a2, bool.booleanValue());
                                } else {
                                    u3Var = new u3(a, bool.booleanValue());
                                }
                            }
                        }
                        u3Var.f().p = bool2.booleanValue();
                        if (intValue != -1) {
                            u3Var.f().h(intValue / u3Var.a());
                        }
                        return u3Var;
                    } catch (RuntimeException e) {
                        throw new SerializationException("Error loading bitmap font: " + a, e);
                    }
                }
                throw new SerializationException("Font file not found: " + a);
            }
            return (u3) invokeLLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d extends o7.b<k3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l6 a;

        public d(l6 l6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.o7.d
        /* renamed from: b */
        public k3 a(o7 o7Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o7Var, jsonValue, cls)) == null) {
                if (jsonValue.E()) {
                    return (k3) this.a.h(jsonValue.k(), k3.class);
                }
                String str = (String) o7Var.n("hex", String.class, null, jsonValue);
                if (str != null) {
                    return k3.h(str);
                }
                return new k3(((Float) o7Var.n("r", Float.TYPE, Float.valueOf(0.0f), jsonValue)).floatValue(), ((Float) o7Var.n("g", Float.TYPE, Float.valueOf(0.0f), jsonValue)).floatValue(), ((Float) o7Var.n("b", Float.TYPE, Float.valueOf(0.0f), jsonValue)).floatValue(), ((Float) o7Var.n("a", Float.TYPE, Float.valueOf(1.0f), jsonValue)).floatValue());
            }
            return (k3) invokeLLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class e extends o7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l6 a;

        public e(l6 l6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l6Var;
        }

        @Override // com.repackage.o7.d
        public Object a(o7 o7Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, o7Var, jsonValue, cls)) == null) {
                String str = (String) o7Var.l("name", String.class, jsonValue);
                k3 k3Var = (k3) o7Var.l("color", k3.class, jsonValue);
                if (k3Var != null) {
                    v6 q = this.a.q(str, k3Var);
                    if (q instanceof u6) {
                        ((u6) q).n(jsonValue.e + " (" + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + k3Var + SmallTailInfo.EMOTION_SUFFIX);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964036101, "Lcom/repackage/l6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964036101, "Lcom/repackage/l6;");
                return;
            }
        }
        e = new Class[]{u3.class, k3.class, f.class, w6.class, x6.class, y6.class, z6.class, c6.class, d6.class, e6.class, f6.class, g6.class, h6.class, i6.class, j6.class, k6.class, m6.class, n6.class, o6.class, p6.class, q6.class, r6.class, s6.class, t6.class};
    }

    public l6() {
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
        this.a = new w7<>();
        this.c = 1.0f;
        this.d = new w7<>(e.length);
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

    @Override // com.repackage.h7
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b4 b4Var = this.b;
            if (b4Var != null) {
                b4Var.dispose();
            }
            w7.e<w7<String, Object>> n = this.a.n();
            n.d();
            while (n.hasNext()) {
                w7.e<Object> n2 = n.next().n();
                n2.d();
                while (n2.hasNext()) {
                    Object next = n2.next();
                    if (next instanceof h7) {
                        ((h7) next).dispose();
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
                w7<String, Object> c2 = this.a.c(cls);
                if (c2 == null) {
                    c2 = new w7<>((cls == c4.class || cls == v6.class || cls == a4.class) ? 256 : 64);
                    this.a.i(cls, c2);
                }
                c2.i(str, obj);
                return;
            }
            throw new IllegalArgumentException("resource cannot be null.");
        }
    }

    public void g(b4 b4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, b4Var) == null) {
            a7<b4.a> g = b4Var.g();
            int i = g.b;
            for (int i2 = 0; i2 < i; i2++) {
                b4.a aVar = g.get(i2);
                String str = aVar.i;
                if (aVar.h != -1) {
                    str = str + "_" + aVar.h;
                }
                f(str, aVar, c4.class);
            }
        }
    }

    public <T> T h(String str, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, cls)) == null) {
            if (str != null) {
                if (cls != null) {
                    if (cls == v6.class) {
                        return (T) i(str);
                    }
                    if (cls == c4.class) {
                        return (T) l(str);
                    }
                    if (cls == w3.class) {
                        return (T) k(str);
                    }
                    if (cls == a4.class) {
                        return (T) n(str);
                    }
                    w7<String, Object> c2 = this.a.c(cls);
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

    public v6 i(String str) {
        InterceptResult invokeL;
        v6 x6Var;
        v6 x6Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            v6 v6Var = (v6) r(str, v6.class);
            if (v6Var != null) {
                return v6Var;
            }
            try {
                c4 l = l(str);
                if (l instanceof b4.a) {
                    b4.a aVar = (b4.a) l;
                    if (aVar.k("split") != null) {
                        x6Var2 = new w6(k(str));
                    } else if (aVar.p || aVar.l != aVar.n || aVar.m != aVar.o) {
                        x6Var2 = new x6(n(str));
                    }
                    v6Var = x6Var2;
                }
                if (v6Var == null) {
                    v6 y6Var = new y6(l);
                    try {
                        if (this.c != 1.0f) {
                            s(y6Var);
                        }
                    } catch (GdxRuntimeException unused) {
                    }
                    v6Var = y6Var;
                }
            } catch (GdxRuntimeException unused2) {
            }
            if (v6Var == null) {
                w3 w3Var = (w3) r(str, w3.class);
                if (w3Var != null) {
                    x6Var = new w6(w3Var);
                } else {
                    a4 a4Var = (a4) r(str, a4.class);
                    if (a4Var != null) {
                        x6Var = new x6(a4Var);
                    } else {
                        throw new GdxRuntimeException("No Drawable, NinePatch, TextureRegion, Texture, or Sprite registered with name: " + str);
                    }
                }
                v6Var = x6Var;
            }
            if (v6Var instanceof u6) {
                ((u6) v6Var).n(str);
            }
            f(str, v6Var, v6.class);
            return v6Var;
        }
        return (v6) invokeL.objValue;
    }

    public o7 j(j3 j3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, j3Var)) == null) {
            a aVar = new a(this);
            aVar.p(null);
            aVar.q(false);
            aVar.o(l6.class, new b(this, this));
            aVar.o(u3.class, new c(this, j3Var, this));
            aVar.o(k3.class, new d(this));
            aVar.o(f.class, new e(this));
            w7.a<String, Class> it = this.d.iterator();
            while (it.hasNext()) {
                w7.b next = it.next();
                aVar.a((String) next.a, (Class) next.b);
            }
            return aVar;
        }
        return (o7) invokeL.objValue;
    }

    public w3 k(String str) {
        InterceptResult invokeL;
        int[] k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            w3 w3Var = (w3) r(str, w3.class);
            if (w3Var != null) {
                return w3Var;
            }
            try {
                c4 l = l(str);
                if ((l instanceof b4.a) && (k = ((b4.a) l).k("split")) != null) {
                    w3Var = new w3(l, k[0], k[1], k[2], k[3]);
                    int[] k2 = ((b4.a) l).k("pad");
                    if (k2 != null) {
                        w3Var.n(k2[0], k2[1], k2[2], k2[3]);
                    }
                }
                if (w3Var == null) {
                    w3Var = new w3(l);
                }
                if (this.c != 1.0f) {
                    w3Var.m(this.c, this.c);
                }
                f(str, w3Var, w3.class);
                return w3Var;
            } catch (GdxRuntimeException unused) {
                throw new GdxRuntimeException("No NinePatch, TextureRegion, or Texture registered with name: " + str);
            }
        }
        return (w3) invokeL.objValue;
    }

    public c4 l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            c4 c4Var = (c4) r(str, c4.class);
            if (c4Var != null) {
                return c4Var;
            }
            Texture texture = (Texture) r(str, Texture.class);
            if (texture != null) {
                c4 c4Var2 = new c4(texture);
                f(str, c4Var2, c4.class);
                return c4Var2;
            }
            throw new GdxRuntimeException("No TextureRegion or Texture registered with name: " + str);
        }
        return (c4) invokeL.objValue;
    }

    public a7<c4> m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            c4 c4Var = (c4) r(str + "_0", c4.class);
            if (c4Var != null) {
                a7<c4> a7Var = new a7<>();
                int i = 1;
                while (c4Var != null) {
                    a7Var.a(c4Var);
                    c4Var = (c4) r(str + "_" + i, c4.class);
                    i++;
                }
                return a7Var;
            }
            return null;
        }
        return (a7) invokeL.objValue;
    }

    public a4 n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            a4 a4Var = (a4) r(str, a4.class);
            if (a4Var != null) {
                return a4Var;
            }
            try {
                c4 l = l(str);
                if (l instanceof b4.a) {
                    b4.a aVar = (b4.a) l;
                    if (aVar.p || aVar.l != aVar.n || aVar.m != aVar.o) {
                        a4Var = new b4.b(aVar);
                    }
                }
                if (a4Var == null) {
                    a4Var = new a4(l);
                }
                if (this.c != 1.0f) {
                    a4Var.z(a4Var.n() * this.c, a4Var.k() * this.c);
                }
                f(str, a4Var, a4.class);
                return a4Var;
            } catch (GdxRuntimeException unused) {
                throw new GdxRuntimeException("No NinePatch, TextureRegion, or Texture registered with name: " + str);
            }
        }
        return (a4) invokeL.objValue;
    }

    public void o(j3 j3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, j3Var) == null) {
            try {
                j(j3Var).d(l6.class, j3Var);
            } catch (SerializationException e2) {
                throw new SerializationException("Error reading file: " + j3Var, e2);
            }
        }
    }

    public v6 p(v6 v6Var, k3 k3Var) {
        InterceptResult invokeLL;
        v6 p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, v6Var, k3Var)) == null) {
            if (v6Var instanceof y6) {
                p = ((y6) v6Var).p(k3Var);
            } else if (v6Var instanceof w6) {
                p = ((w6) v6Var).q(k3Var);
            } else if (v6Var instanceof x6) {
                p = ((x6) v6Var).p(k3Var);
            } else {
                throw new GdxRuntimeException("Unable to copy, unknown drawable type: " + v6Var.getClass());
            }
            if (p instanceof u6) {
                u6 u6Var = (u6) p;
                if (v6Var instanceof u6) {
                    u6Var.n(((u6) v6Var).m() + " (" + k3Var + SmallTailInfo.EMOTION_SUFFIX);
                } else {
                    u6Var.n(" (" + k3Var + SmallTailInfo.EMOTION_SUFFIX);
                }
            }
            return p;
        }
        return (v6) invokeLL.objValue;
    }

    public v6 q(String str, k3 k3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, k3Var)) == null) ? p(i(str), k3Var) : (v6) invokeLL.objValue;
    }

    public <T> T r(String str, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, cls)) == null) {
            if (str != null) {
                if (cls != null) {
                    w7<String, Object> c2 = this.a.c(cls);
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

    public void s(v6 v6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, v6Var) == null) {
            v6Var.b(v6Var.l() * this.c);
            v6Var.c(v6Var.g() * this.c);
            v6Var.d(v6Var.e() * this.c);
            v6Var.f(v6Var.i() * this.c);
            v6Var.j(v6Var.a() * this.c);
            v6Var.h(v6Var.k() * this.c);
        }
    }

    public l6(b4 b4Var) {
        Class[] clsArr;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b4Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = new w7<>();
        this.c = 1.0f;
        this.d = new w7<>(e.length);
        for (Class cls : e) {
            this.d.i(cls.getSimpleName(), cls);
        }
        this.b = b4Var;
        g(b4Var);
    }
}
