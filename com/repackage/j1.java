package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.Cubemap;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.repackage.h1;
import com.repackage.u7;
import com.repackage.y6;
import com.tachikoma.core.utility.FileUtil;
/* loaded from: classes6.dex */
public class j1 implements f7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final u7<Class, u7<String, a>> a;
    public final u7<String, Class> b;
    public final u7<String, y6<String>> c;
    public final v7<String> d;
    public final u7<Class, u7<String, k1>> e;
    public final y6<f1> f;
    public final m8 g;
    public final y6<i1> h;
    public g1 i;
    public int j;
    public int k;
    public int l;
    public p7 m;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Object a;
        public int b;

        public a() {
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
            this.b = 1;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j1() {
        this(new a2());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((o1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public synchronized void A(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
            synchronized (this) {
                Class c = this.b.c(str);
                if (c != null) {
                    this.a.c(c).c(str).b = i;
                } else {
                    throw new GdxRuntimeException("Asset not loaded: " + str);
                }
            }
        }
    }

    public void B(f1 f1Var, RuntimeException runtimeException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f1Var, runtimeException) == null) {
            throw runtimeException;
        }
    }

    public synchronized void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            synchronized (this) {
                String replace = str.replace(FileUtil.WINDOWS_SEPARATOR, WebvttCueParser.CHAR_SLASH);
                if (this.h.b > 0) {
                    i1 f = this.h.f();
                    if (f.b.a.equals(replace)) {
                        this.m.e("Unload (from tasks): " + replace);
                        f.l = true;
                        f.e();
                        return;
                    }
                }
                Class c = this.b.c(replace);
                int i = 0;
                while (true) {
                    if (i >= this.f.b) {
                        i = -1;
                        break;
                    } else if (this.f.get(i).a.equals(replace)) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i != -1) {
                    this.k--;
                    f1 i2 = this.f.i(i);
                    this.m.e("Unload (from queue): " + replace);
                    if (c != null && i2.c != null && i2.c.a != null) {
                        i2.c.a.a(this, i2.a, i2.b);
                    }
                } else if (c != null) {
                    a c2 = this.a.c(c).c(replace);
                    int i3 = c2.b - 1;
                    c2.b = i3;
                    if (i3 <= 0) {
                        this.m.e("Unload (dispose): " + replace);
                        if (c2.a instanceof f7) {
                            ((f7) c2.a).dispose();
                        }
                        this.b.k(replace);
                        this.a.c(c).k(replace);
                    } else {
                        this.m.e("Unload (decrement): " + replace);
                    }
                    y6<String> c3 = this.c.c(replace);
                    if (c3 != null) {
                        y6.b<String> it = c3.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (v(next)) {
                                C(next);
                            }
                        }
                    }
                    if (c2.b <= 0) {
                        this.c.k(replace);
                    }
                } else {
                    throw new GdxRuntimeException("Asset not loaded: " + replace);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean D() {
        InterceptResult invokeV;
        boolean z;
        h1.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048579, this)) != null) {
            return invokeV.booleanValue;
        }
        i1 peek = this.h.peek();
        try {
            if (!peek.l) {
                if (!peek.update()) {
                    z = false;
                    if (z) {
                        return false;
                    }
                    if (this.h.b == 1) {
                        this.j++;
                        this.l = 0;
                    }
                    this.h.pop();
                    if (peek.l) {
                        return true;
                    }
                    f1 f1Var = peek.b;
                    a(f1Var.a, f1Var.b, peek.k);
                    f1 f1Var2 = peek.b;
                    h1 h1Var = f1Var2.c;
                    if (h1Var != null && (aVar = h1Var.a) != null) {
                        aVar.a(this, f1Var2.a, f1Var2.b);
                    }
                    long b = k8.b();
                    this.m.a("Loaded: " + (((float) (b - peek.e)) / 1000000.0f) + "ms " + peek.b);
                    return true;
                }
            }
            z = true;
            if (z) {
            }
        } catch (RuntimeException e) {
            peek.l = true;
            B(peek.b, e);
            throw null;
        }
    }

    public <T> void a(String str, Class<T> cls, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, cls, t) == null) {
            this.b.i(str, cls);
            u7<String, a> c = this.a.c(cls);
            if (c == null) {
                c = new u7<>();
                this.a.i(cls, c);
            }
            a aVar = new a();
            aVar.a = t;
            c.i(str, aVar);
        }
    }

    @Override // com.repackage.f7
    public synchronized void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                this.m.a("Disposing.");
                g();
                this.g.dispose();
            }
        }
    }

    public final void f(f1 f1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, f1Var) == null) {
            k1 o = o(f1Var.b, f1Var.a);
            if (o != null) {
                this.h.a(new i1(this, f1Var, o, this.g));
                this.l++;
                return;
            }
            throw new GdxRuntimeException("No loader for type: " + r8.e(f1Var.b));
        }
    }

    public synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                this.f.clear();
                while (!update()) {
                }
                t7 t7Var = new t7();
                while (this.b.a > 0) {
                    t7Var.clear();
                    y6<String> e = this.b.f().e();
                    y6.b<String> it = e.iterator();
                    while (it.hasNext()) {
                        y6<String> c = this.c.c(it.next());
                        if (c != null) {
                            y6.b<String> it2 = c.iterator();
                            while (it2.hasNext()) {
                                t7Var.d(it2.next(), 0, 1);
                            }
                        }
                    }
                    y6.b<String> it3 = e.iterator();
                    while (it3.hasNext()) {
                        String next = it3.next();
                        if (t7Var.c(next, 0) == 0) {
                            C(next);
                        }
                    }
                }
                this.a.clear();
                this.b.clear();
                this.c.clear();
                this.j = 0;
                this.k = 0;
                this.l = 0;
                this.f.clear();
                this.h.clear();
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.m.a("Waiting for loading to complete...");
            while (!update()) {
                p8.a();
            }
            this.m.a("Loading complete.");
        }
    }

    public synchronized <T> T i(String str) {
        InterceptResult invokeL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            synchronized (this) {
                t = (T) l(str, true);
            }
            return t;
        }
        return (T) invokeL.objValue;
    }

    public synchronized <T> T j(String str, Class<T> cls) {
        InterceptResult invokeLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, cls)) == null) {
            synchronized (this) {
                t = (T) k(str, cls, true);
            }
            return t;
        }
        return (T) invokeLL.objValue;
    }

    public synchronized <T> T k(String str, Class<T> cls, boolean z) {
        InterceptResult invokeLLZ;
        a c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048587, this, str, cls, z)) == null) {
            synchronized (this) {
                u7<String, a> c2 = this.a.c(cls);
                if (c2 == null || (c = c2.c(str)) == null) {
                    if (z) {
                        throw new GdxRuntimeException("Asset not loaded: " + str);
                    }
                    return null;
                }
                return (T) c.a;
            }
        }
        return (T) invokeLLZ.objValue;
    }

    public synchronized <T> T l(String str, boolean z) {
        InterceptResult invokeLZ;
        u7<String, a> c;
        a c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048588, this, str, z)) == null) {
            synchronized (this) {
                Class c3 = this.b.c(str);
                if (c3 == null || (c = this.a.c(c3)) == null || (c2 = c.c(str)) == null) {
                    if (z) {
                        throw new GdxRuntimeException("Asset not loaded: " + str);
                    }
                    return null;
                }
                return (T) c2.a;
            }
        }
        return (T) invokeLZ.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c A[Catch: all -> 0x0049, TryCatch #0 {, blocks: (B:5:0x0005, B:6:0x000e, B:8:0x0014, B:9:0x0026, B:11:0x002c, B:13:0x003a, B:15:0x0040), top: B:28:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized <T> String m(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, t)) == null) {
            synchronized (this) {
                u7.c<Class> f = this.a.f();
                f.d();
                while (f.hasNext()) {
                    u7.a<String, a> it = this.a.c(f.next()).iterator();
                    while (it.hasNext()) {
                        u7.b next = it.next();
                        Object obj = ((a) next.b).a;
                        if (obj == t || t.equals(obj)) {
                            return (String) next.a;
                        }
                        while (it.hasNext()) {
                        }
                    }
                }
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public synchronized y6<String> n(String str) {
        InterceptResult invokeL;
        y6<String> c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            synchronized (this) {
                c = this.c.c(str);
            }
            return c;
        }
        return (y6) invokeL.objValue;
    }

    public <T> k1 o(Class<T> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, cls, str)) == null) {
            u7<String, k1> c = this.e.c(cls);
            k1 k1Var = null;
            if (c != null && c.a >= 1) {
                if (str == null) {
                    return c.c("");
                }
                int i = -1;
                u7.a<String, k1> b = c.b();
                b.d();
                while (b.hasNext()) {
                    u7.b next = b.next();
                    if (((String) next.a).length() > i && str.endsWith((String) next.a)) {
                        k1Var = (k1) next.b;
                        i = ((String) next.a).length();
                    }
                }
            }
            return k1Var;
        }
        return (k1) invokeLL.objValue;
    }

    public p7 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.m : (p7) invokeV.objValue;
    }

    public synchronized int q(String str) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            synchronized (this) {
                Class c = this.b.c(str);
                if (c != null) {
                    i = this.a.c(c).c(str).b;
                } else {
                    throw new GdxRuntimeException("Asset not loaded: " + str);
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public final void r(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, th) == null) {
            this.m.c("Error loading asset.", th);
            if (!this.h.isEmpty()) {
                i1 pop = this.h.pop();
                f1 f1Var = pop.b;
                if (pop.g && pop.h != null) {
                    y6.b<f1> it = pop.h.iterator();
                    while (it.hasNext()) {
                        C(it.next().a);
                    }
                }
                this.h.clear();
                g1 g1Var = this.i;
                if (g1Var != null) {
                    g1Var.a(f1Var, th);
                    return;
                }
                throw new GdxRuntimeException(th);
            }
            throw new GdxRuntimeException(th);
        }
    }

    public final void s(String str) {
        y6<String> c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, str) == null) || (c = this.c.c(str)) == null) {
            return;
        }
        y6.b<String> it = c.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.a.c(this.b.c(next)).c(next).b++;
            s(next);
        }
    }

    public synchronized void t(String str, y6<f1> y6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, str, y6Var) == null) {
            synchronized (this) {
                v7<String> v7Var = this.d;
                y6.b<f1> it = y6Var.iterator();
                while (it.hasNext()) {
                    f1 next = it.next();
                    if (!v7Var.contains(next.a)) {
                        v7Var.add(next.a);
                        u(str, next);
                    }
                }
                v7Var.b(32);
            }
        }
    }

    public final synchronized void u(String str, f1 f1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, str, f1Var) == null) {
            synchronized (this) {
                y6<String> c = this.c.c(str);
                if (c == null) {
                    c = new y6<>();
                    this.c.i(str, c);
                }
                c.a(f1Var.a);
                if (v(f1Var.a)) {
                    p7 p7Var = this.m;
                    p7Var.a("Dependency already loaded: " + f1Var);
                    a c2 = this.a.c(this.b.c(f1Var.a)).c(f1Var.a);
                    c2.b = c2.b + 1;
                    s(f1Var.a);
                } else {
                    p7 p7Var2 = this.m;
                    p7Var2.e("Loading dependency: " + f1Var);
                    f(f1Var);
                }
            }
        }
    }

    public synchronized boolean update() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            synchronized (this) {
                boolean z = false;
                try {
                    if (this.h.b == 0) {
                        while (this.f.b != 0 && this.h.b == 0) {
                            x();
                        }
                        if (this.h.b == 0) {
                            return true;
                        }
                    }
                    if (D() && this.f.b == 0) {
                        if (this.h.b == 0) {
                            z = true;
                        }
                    }
                    return z;
                } catch (Throwable th) {
                    r(th);
                    return this.f.b == 0;
                }
            }
        }
        return invokeV.booleanValue;
    }

    public synchronized boolean v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            synchronized (this) {
                if (str == null) {
                    return false;
                }
                return this.b.a(str);
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized <T> void w(String str, Class<T> cls, h1<T> h1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048601, this, str, cls, h1Var) == null) {
            synchronized (this) {
                if (o(cls, str) != null) {
                    if (this.f.b == 0) {
                        this.j = 0;
                        this.k = 0;
                        this.l = 0;
                    }
                    for (int i = 0; i < this.f.b; i++) {
                        f1 f1Var = this.f.get(i);
                        if (f1Var.a.equals(str) && !f1Var.b.equals(cls)) {
                            throw new GdxRuntimeException("Asset with name '" + str + "' already in preload queue, but has different type (expected: " + r8.e(cls) + ", found: " + r8.e(f1Var.b) + SmallTailInfo.EMOTION_SUFFIX);
                        }
                    }
                    for (int i2 = 0; i2 < this.h.b; i2++) {
                        f1 f1Var2 = this.h.get(i2).b;
                        if (f1Var2.a.equals(str) && !f1Var2.b.equals(cls)) {
                            throw new GdxRuntimeException("Asset with name '" + str + "' already in task list, but has different type (expected: " + r8.e(cls) + ", found: " + r8.e(f1Var2.b) + SmallTailInfo.EMOTION_SUFFIX);
                        }
                    }
                    Class c = this.b.c(str);
                    if (c != null && !c.equals(cls)) {
                        throw new GdxRuntimeException("Asset with name '" + str + "' already loaded, but has different type (expected: " + r8.e(cls) + ", found: " + r8.e(c) + SmallTailInfo.EMOTION_SUFFIX);
                    }
                    this.k++;
                    f1 f1Var3 = new f1(str, cls, h1Var);
                    this.f.a(f1Var3);
                    this.m.a("Queued: " + f1Var3);
                } else {
                    throw new GdxRuntimeException("No loader for type: " + r8.e(cls));
                }
            }
        }
    }

    public final void x() {
        h1.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            f1 i = this.f.i(0);
            if (v(i.a)) {
                this.m.a("Already loaded: " + i);
                a c = this.a.c(this.b.c(i.a)).c(i.a);
                c.b = c.b + 1;
                s(i.a);
                h1 h1Var = i.c;
                if (h1Var != null && (aVar = h1Var.a) != null) {
                    aVar.a(this, i.a, i.b);
                }
                this.j++;
                return;
            }
            this.m.e("Loading: " + i);
            f(i);
        }
    }

    public synchronized <T, P extends h1<T>> void y(Class<T> cls, k1<T, P> k1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, cls, k1Var) == null) {
            synchronized (this) {
                z(cls, null, k1Var);
            }
        }
    }

    public synchronized <T, P extends h1<T>> void z(Class<T> cls, String str, k1<T, P> k1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048604, this, cls, str, k1Var) == null) {
            synchronized (this) {
                if (cls == null) {
                    throw new IllegalArgumentException("type cannot be null.");
                }
                if (k1Var != null) {
                    p7 p7Var = this.m;
                    p7Var.a("Loader set: " + r8.e(cls) + LoadErrorCode.TOKEN_NEXT + r8.e(k1Var.getClass()));
                    u7<String, k1> c = this.e.c(cls);
                    if (c == null) {
                        u7<Class, u7<String, k1>> u7Var = this.e;
                        u7<String, k1> u7Var2 = new u7<>();
                        u7Var.i(cls, u7Var2);
                        c = u7Var2;
                    }
                    if (str == null) {
                        str = "";
                    }
                    c.i(str, k1Var);
                } else {
                    throw new IllegalArgumentException("loader cannot be null.");
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j1(o1 o1Var) {
        this(o1Var, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {o1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((o1) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public j1(o1 o1Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {o1Var, Boolean.valueOf(z)};
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
        this.b = new u7<>();
        this.c = new u7<>();
        this.d = new v7<>();
        this.e = new u7<>();
        this.f = new y6<>();
        this.h = new y6<>();
        this.m = new p7("AssetManager", 0);
        if (z) {
            y(s3.class, new m1(o1Var));
            y(b2.class, new r1(o1Var));
            y(Pixmap.class, new t1(o1Var));
            y(c2.class, new w1(o1Var));
            y(z3.class, new y1(o1Var));
            y(Texture.class, new z1(o1Var));
            y(j6.class, new v1(o1Var));
            y(v3.class, new s1(o1Var));
            y(d5.class, new e5(o1Var));
            y(w3.class, new x3(o1Var));
            y(i7.class, new p1(o1Var));
            z(e4.class, ".g3dj", new j4(new n7(), o1Var));
            z(e4.class, ".g3db", new j4(new l8(), o1Var));
            z(e4.class, ".obj", new l4(o1Var));
            y(v5.class, new u1(o1Var));
            y(Cubemap.class, new n1(o1Var));
        }
        this.g = new m8(1, "AssetManager");
    }

    public boolean update(int i) {
        InterceptResult invokeI;
        boolean update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i)) == null) {
            long a2 = k8.a() + i;
            while (true) {
                update = update();
                if (update || k8.a() > a2) {
                    break;
                }
                p8.a();
            }
            return update;
        }
        return invokeI.booleanValue;
    }
}
