package d.f.b.a;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.b.a.d0.l;
import d.f.b.a.w;
/* loaded from: classes8.dex */
public final class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final w.b f71050a;

    /* renamed from: b  reason: collision with root package name */
    public final w.c f71051b;

    /* renamed from: c  reason: collision with root package name */
    public w f71052c;

    /* renamed from: d  reason: collision with root package name */
    public int f71053d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f71054e;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final l.b f71055a;

        /* renamed from: b  reason: collision with root package name */
        public final long f71056b;

        /* renamed from: c  reason: collision with root package name */
        public final long f71057c;

        /* renamed from: d  reason: collision with root package name */
        public final long f71058d;

        /* renamed from: e  reason: collision with root package name */
        public final long f71059e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f71060f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f71061g;

        public /* synthetic */ b(l.b bVar, long j, long j2, long j3, long j4, boolean z, boolean z2, a aVar) {
            this(bVar, j, j2, j3, j4, z, z2);
        }

        public b a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? new b(this.f71055a.a(i2), this.f71056b, this.f71057c, this.f71058d, this.f71059e, this.f71060f, this.f71061g) : (b) invokeI.objValue;
        }

        public b b(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) ? new b(this.f71055a, j, this.f71057c, this.f71058d, this.f71059e, this.f71060f, this.f71061g) : (b) invokeJ.objValue;
        }

        public b(l.b bVar, long j, long j2, long j3, long j4, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {bVar, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71055a = bVar;
            this.f71056b = j;
            this.f71057c = j2;
            this.f71058d = j3;
            this.f71059e = j4;
            this.f71060f = z;
            this.f71061g = z2;
        }
    }

    public n() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71050a = new w.b();
        this.f71051b = new w.c();
    }

    public b a(o oVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, oVar)) == null) ? b(oVar.f71064c, oVar.f71066e, oVar.f71065d) : (b) invokeL.objValue;
    }

    public final b b(l.b bVar, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bVar, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            this.f71052c.f(bVar.f70266a, this.f71050a);
            if (bVar.b()) {
                if (this.f71050a.m(bVar.f70267b, bVar.f70268c)) {
                    return c(bVar.f70266a, bVar.f70267b, bVar.f70268c, j);
                }
                return null;
            }
            int d2 = this.f71050a.d(j2);
            return d(bVar.f70266a, j2, d2 == -1 ? Long.MIN_VALUE : this.f71050a.f(d2));
        }
        return (b) invokeCommon.objValue;
    }

    public final b c(int i2, int i3, int i4, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j)})) == null) {
            l.b bVar = new l.b(i2, i3, i4);
            boolean i5 = i(bVar, Long.MIN_VALUE);
            boolean j2 = j(bVar, i5);
            return new b(bVar, i4 == this.f71050a.i(i3) ? this.f71050a.g() : 0L, Long.MIN_VALUE, j, this.f71052c.f(bVar.f70266a, this.f71050a).b(bVar.f70267b, bVar.f70268c), i5, j2, null);
        }
        return (b) invokeCommon.objValue;
    }

    public final b d(int i2, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)})) == null) {
            l.b bVar = new l.b(i2);
            boolean i3 = i(bVar, j2);
            boolean j3 = j(bVar, i3);
            this.f71052c.f(bVar.f70266a, this.f71050a);
            return new b(bVar, j, j2, -9223372036854775807L, j2 == Long.MIN_VALUE ? this.f71050a.h() : j2, i3, j3, null);
        }
        return (b) invokeCommon.objValue;
    }

    public b e(b bVar, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{bVar, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (bVar.f71060f) {
                int d2 = this.f71052c.d(bVar.f71055a.f70266a, this.f71050a, this.f71051b, this.f71053d, this.f71054e);
                if (d2 == -1) {
                    return null;
                }
                int i2 = this.f71052c.f(d2, this.f71050a).f71088c;
                long j3 = 0;
                if (this.f71052c.l(i2, this.f71051b).f71100f == d2) {
                    Pair<Integer, Long> j4 = this.f71052c.j(this.f71051b, this.f71050a, i2, -9223372036854775807L, Math.max(0L, (j + bVar.f71059e) - j2));
                    if (j4 == null) {
                        return null;
                    }
                    d2 = ((Integer) j4.first).intValue();
                    j3 = ((Long) j4.second).longValue();
                }
                return b(k(d2, j3), j3, j3);
            }
            l.b bVar2 = bVar.f71055a;
            if (bVar2.b()) {
                int i3 = bVar2.f70267b;
                this.f71052c.f(bVar2.f70266a, this.f71050a);
                int a2 = this.f71050a.a(i3);
                if (a2 == -1) {
                    return null;
                }
                int i4 = bVar2.f70268c + 1;
                if (i4 < a2) {
                    if (this.f71050a.m(i3, i4)) {
                        return c(bVar2.f70266a, i3, i4, bVar.f71058d);
                    }
                    return null;
                }
                int d3 = this.f71050a.d(bVar.f71058d);
                return d(bVar2.f70266a, bVar.f71058d, d3 == -1 ? Long.MIN_VALUE : this.f71050a.f(d3));
            }
            long j5 = bVar.f71057c;
            if (j5 != Long.MIN_VALUE) {
                int e2 = this.f71050a.e(j5);
                if (this.f71050a.m(e2, 0)) {
                    return c(bVar2.f70266a, e2, 0, bVar.f71057c);
                }
                return null;
            }
            int c2 = this.f71050a.c();
            if (c2 != 0) {
                int i5 = c2 - 1;
                if (this.f71050a.f(i5) == Long.MIN_VALUE && !this.f71050a.l(i5) && this.f71050a.m(i5, 0)) {
                    return c(bVar2.f70266a, i5, 0, this.f71050a.h());
                }
            }
            return null;
        }
        return (b) invokeCommon.objValue;
    }

    public b f(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bVar)) == null) ? h(bVar, bVar.f71055a) : (b) invokeL.objValue;
    }

    public b g(b bVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, bVar, i2)) == null) ? h(bVar, bVar.f71055a.a(i2)) : (b) invokeLI.objValue;
    }

    public final b h(b bVar, l.b bVar2) {
        InterceptResult invokeLL;
        long j;
        long h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bVar, bVar2)) == null) {
            long j2 = bVar.f71056b;
            long j3 = bVar.f71057c;
            boolean i2 = i(bVar2, j3);
            boolean j4 = j(bVar2, i2);
            this.f71052c.f(bVar2.f70266a, this.f71050a);
            if (bVar2.b()) {
                h2 = this.f71050a.b(bVar2.f70267b, bVar2.f70268c);
            } else if (j3 == Long.MIN_VALUE) {
                h2 = this.f71050a.h();
            } else {
                j = j3;
                return new b(bVar2, j2, j3, bVar.f71058d, j, i2, j4, null);
            }
            j = h2;
            return new b(bVar2, j2, j3, bVar.f71058d, j, i2, j4, null);
        }
        return (b) invokeLL.objValue;
    }

    public final boolean i(l.b bVar, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, j)) == null) {
            int c2 = this.f71052c.f(bVar.f70266a, this.f71050a).c();
            if (c2 == 0) {
                return true;
            }
            int i2 = c2 - 1;
            boolean b2 = bVar.b();
            if (this.f71050a.f(i2) != Long.MIN_VALUE) {
                return !b2 && j == Long.MIN_VALUE;
            }
            int a2 = this.f71050a.a(i2);
            if (a2 == -1) {
                return false;
            }
            if (b2 && bVar.f70267b == i2 && bVar.f70268c == a2 + (-1)) {
                return true;
            }
            return !b2 && this.f71050a.i(i2) == a2;
        }
        return invokeLJ.booleanValue;
    }

    public final boolean j(l.b bVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048585, this, bVar, z)) == null) ? !this.f71052c.l(this.f71052c.f(bVar.f70266a, this.f71050a).f71088c, this.f71051b).f71099e && this.f71052c.q(bVar.f70266a, this.f71050a, this.f71051b, this.f71053d, this.f71054e) && z : invokeLZ.booleanValue;
    }

    public l.b k(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            this.f71052c.f(i2, this.f71050a);
            int e2 = this.f71050a.e(j);
            if (e2 == -1) {
                return new l.b(i2);
            }
            return new l.b(i2, e2, this.f71050a.i(e2));
        }
        return (l.b) invokeCommon.objValue;
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f71053d = i2;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f71054e = z;
        }
    }

    public void n(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, wVar) == null) {
            this.f71052c = wVar;
        }
    }
}
