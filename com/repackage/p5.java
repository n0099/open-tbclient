package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.m3;
import com.repackage.y6;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public abstract class p5<T extends m3> implements f7 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<Application, y6<p5>> i;
    public static int j;
    public static boolean k;
    public transient /* synthetic */ FieldHolder $fh;
    public y6<T> a;
    public int b;
    public int c;
    public int d;
    public int e;
    public boolean f;
    public boolean g;
    public c<? extends p5<T>> h;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public boolean b;
        public boolean c;

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.b || this.c) ? false : true : invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class c<U extends p5<? extends m3>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public y6<b> c;
        public a d;
        public a e;
        public a f;
        public boolean g;
        public boolean h;
        public boolean i;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964032288, "Lcom/repackage/p5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964032288, "Lcom/repackage/p5;");
                return;
            }
        }
        i = new HashMap();
        k = false;
    }

    public p5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new y6<>();
    }

    public static void a(Application application, p5 p5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, application, p5Var) == null) {
            y6<p5> y6Var = i.get(application);
            if (y6Var == null) {
                y6Var = new y6<>();
            }
            y6Var.a(p5Var);
            i.put(application, y6Var);
        }
    }

    public static void i(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, application) == null) {
            i.remove(application);
        }
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            StringBuilder sb = new StringBuilder();
            m(sb);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static StringBuilder m(StringBuilder sb) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, sb)) == null) {
            sb.append("Managed buffers/app: { ");
            for (Application application : i.keySet()) {
                sb.append(i.get(application).b);
                sb.append(" ");
            }
            sb.append("}");
            return sb;
        }
        return (StringBuilder) invokeL.objValue;
    }

    public static void n(Application application) {
        y6<p5> y6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, application) == null) || b1.f == null || (y6Var = i.get(application)) == null) {
            return;
        }
        for (int i2 = 0; i2 < y6Var.b; i2++) {
            y6Var.get(i2).g();
        }
    }

    @Override // com.repackage.f7
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            k3 k3Var = b1.f;
            y6.b<T> it = this.a.iterator();
            while (it.hasNext()) {
                k(it.next());
            }
            if (this.f) {
                k3Var.p(this.e);
            } else {
                if (this.h.h) {
                    k3Var.p(this.c);
                }
                if (this.h.g) {
                    k3Var.p(this.d);
                }
            }
            k3Var.r(this.b);
            if (i.get(b1.a) != null) {
                i.get(b1.a).j(this, true);
            }
        }
    }

    public abstract void f(T t);

    public void g() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            k3 k3Var = b1.f;
            h();
            if (!k) {
                k = true;
                if (b1.a.getType() == Application.ApplicationType.iOS) {
                    IntBuffer asIntBuffer = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asIntBuffer();
                    k3Var.C(36006, asIntBuffer);
                    j = asIntBuffer.get(0);
                } else {
                    j = 0;
                }
            }
            int Q = k3Var.Q();
            this.b = Q;
            k3Var.f(36160, Q);
            c<? extends p5<T>> cVar = this.h;
            int i3 = cVar.a;
            int i4 = cVar.b;
            if (cVar.h) {
                int P = k3Var.P();
                this.c = P;
                k3Var.m(36161, P);
                k3Var.e(36161, this.h.e.a, i3, i4);
            }
            if (this.h.g) {
                int P2 = k3Var.P();
                this.d = P2;
                k3Var.m(36161, P2);
                k3Var.e(36161, this.h.d.a, i3, i4);
            }
            if (this.h.i) {
                int P3 = k3Var.P();
                this.e = P3;
                k3Var.m(36161, P3);
                k3Var.e(36161, this.h.f.a, i3, i4);
            }
            boolean z = this.h.c.b > 1;
            this.g = z;
            if (z) {
                y6.b<b> it = this.h.c.iterator();
                int i5 = 0;
                while (it.hasNext()) {
                    b next = it.next();
                    T j2 = j(next);
                    this.a.a(j2);
                    if (next.a()) {
                        k3Var.B(36160, i5 + 36064, 3553, j2.i(), 0);
                        i5++;
                    } else if (next.b) {
                        k3Var.B(36160, 36096, 3553, j2.i(), 0);
                    } else if (next.c) {
                        k3Var.B(36160, 36128, 3553, j2.i(), 0);
                    }
                }
                i2 = i5;
            } else {
                T j3 = j(this.h.c.f());
                this.a.a(j3);
                k3Var.N(j3.a, j3.i());
                i2 = 0;
            }
            if (this.g) {
                IntBuffer d = BufferUtils.d(i2);
                for (int i6 = 0; i6 < i2; i6++) {
                    d.put(i6 + 36064);
                }
                d.position(0);
                b1.g.c(i2, d);
            } else {
                f(this.a.f());
            }
            if (this.h.h) {
                k3Var.k(36160, 36096, 36161, this.c);
            }
            if (this.h.g) {
                k3Var.k(36160, 36128, 36161, this.d);
            }
            if (this.h.i) {
                k3Var.k(36160, 33306, 36161, this.e);
            }
            k3Var.m(36161, 0);
            y6.b<T> it2 = this.a.iterator();
            while (it2.hasNext()) {
                k3Var.N(it2.next().a, 0);
            }
            int t = k3Var.t(36160);
            if (t == 36061) {
                c<? extends p5<T>> cVar2 = this.h;
                if (cVar2.h && cVar2.g && (b1.b.a("GL_OES_packed_depth_stencil") || b1.b.a("GL_EXT_packed_depth_stencil"))) {
                    if (this.h.h) {
                        k3Var.p(this.c);
                        this.c = 0;
                    }
                    if (this.h.g) {
                        k3Var.p(this.d);
                        this.d = 0;
                    }
                    if (this.h.i) {
                        k3Var.p(this.e);
                        this.e = 0;
                    }
                    int P4 = k3Var.P();
                    this.e = P4;
                    this.f = true;
                    k3Var.m(36161, P4);
                    k3Var.e(36161, 35056, i3, i4);
                    k3Var.m(36161, 0);
                    k3Var.k(36160, 36096, 36161, this.e);
                    k3Var.k(36160, 36128, 36161, this.e);
                    t = k3Var.t(36160);
                }
            }
            k3Var.f(36160, j);
            if (t != 36053) {
                y6.b<T> it3 = this.a.iterator();
                while (it3.hasNext()) {
                    k(it3.next());
                }
                if (this.f) {
                    k3Var.b(this.e);
                } else {
                    if (this.h.h) {
                        k3Var.p(this.c);
                    }
                    if (this.h.g) {
                        k3Var.p(this.d);
                    }
                }
                k3Var.r(this.b);
                if (t == 36054) {
                    throw new IllegalStateException("Frame buffer couldn't be constructed: incomplete attachment");
                }
                if (t == 36057) {
                    throw new IllegalStateException("Frame buffer couldn't be constructed: incomplete dimensions");
                }
                if (t == 36055) {
                    throw new IllegalStateException("Frame buffer couldn't be constructed: missing attachment");
                }
                if (t == 36061) {
                    throw new IllegalStateException("Frame buffer couldn't be constructed: unsupported combination of formats");
                }
                throw new IllegalStateException("Frame buffer couldn't be constructed: unknown error " + t);
            }
            a(b1.a, this);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || b1.b.b()) {
            return;
        }
        c<? extends p5<T>> cVar = this.h;
        if (!cVar.i) {
            y6<b> y6Var = cVar.c;
            if (y6Var.b <= 1) {
                y6.b<b> it = y6Var.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (!next.b) {
                        if (!next.c) {
                            if (next.a && !b1.b.a("OES_texture_float")) {
                                throw new GdxRuntimeException("Float texture FrameBuffer Attachment not available on GLES 2.0");
                            }
                        } else {
                            throw new GdxRuntimeException("Stencil texture FrameBuffer Attachment not available on GLES 2.0");
                        }
                    } else {
                        throw new GdxRuntimeException("Depth texture FrameBuffer Attachment not available on GLES 2.0");
                    }
                }
                return;
            }
            throw new GdxRuntimeException("Multiple render targets not available on GLES 2.0");
        }
        throw new GdxRuntimeException("Packed Stencil/Render render buffers are not available on GLES 2.0");
    }

    public abstract T j(b bVar);

    public abstract void k(T t);
}
