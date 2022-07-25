package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes7.dex */
public class s7<V> implements Iterable<b<V>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public long[] b;
    public V[] c;
    public V d;
    public boolean e;
    public final float f;
    public int g;
    public int h;
    public int i;
    public transient a j;
    public transient a k;

    /* loaded from: classes7.dex */
    public static class a<V> extends c<V> implements Iterable<b<V>>, Iterator<b<V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final b<V> f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(s7 s7Var) {
            super(s7Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((s7) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = new b<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: c */
        public b<V> next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a) {
                    if (this.e) {
                        s7<V> s7Var = this.b;
                        long[] jArr = s7Var.b;
                        int i = this.c;
                        if (i == -1) {
                            b<V> bVar = this.f;
                            bVar.a = 0L;
                            bVar.b = s7Var.d;
                        } else {
                            b<V> bVar2 = this.f;
                            bVar2.a = jArr[i];
                            bVar2.b = s7Var.c[i];
                        }
                        this.d = this.c;
                        a();
                        return this.f;
                    }
                    throw new GdxRuntimeException("#iterator() cannot be used nested.");
                }
                throw new NoSuchElementException();
            }
            return (b) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.e) {
                    return this.a;
                }
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return invokeV.booleanValue;
        }

        @Override // java.lang.Iterable
        public Iterator<b<V>> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this : (Iterator) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public V b;

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

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a + "=" + this.b;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final s7<V> b;
        public int c;
        public int d;
        public boolean e;

        public c(s7<V> s7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = true;
            this.b = s7Var;
            b();
        }

        public void a() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long[] jArr = this.b.b;
                int length = jArr.length;
                do {
                    i = this.c + 1;
                    this.c = i;
                    if (i >= length) {
                        this.a = false;
                        return;
                    }
                } while (jArr[i] == 0);
                this.a = true;
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.d = -2;
                this.c = -1;
                if (this.b.e) {
                    this.a = true;
                } else {
                    a();
                }
            }
        }

        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                int i = this.d;
                if (i == -1) {
                    s7<V> s7Var = this.b;
                    if (s7Var.e) {
                        s7Var.e = false;
                        s7Var.d = null;
                        this.d = -2;
                        s7<V> s7Var2 = this.b;
                        s7Var2.a--;
                        return;
                    }
                }
                if (i >= 0) {
                    s7<V> s7Var3 = this.b;
                    long[] jArr = s7Var3.b;
                    V[] vArr = s7Var3.c;
                    int i2 = s7Var3.i;
                    int i3 = i + 1;
                    while (true) {
                        int i4 = i3 & i2;
                        long j = jArr[i4];
                        if (j == 0) {
                            break;
                        }
                        int e = this.b.e(j);
                        if (((i4 - e) & i2) > ((i - e) & i2)) {
                            jArr[i] = j;
                            vArr[i] = vArr[i4];
                            i = i4;
                        }
                        i3 = i4 + 1;
                    }
                    jArr[i] = 0;
                    vArr[i] = null;
                    if (i != this.d) {
                        this.c--;
                    }
                    this.d = -2;
                    s7<V> s7Var22 = this.b;
                    s7Var22.a--;
                    return;
                }
                throw new IllegalStateException("next must be called before remove.");
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public s7() {
        this(51, 0.8f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Integer) objArr[0]).intValue(), ((Float) objArr[1]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public a<V> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (f7.a) {
                return new a<>(this);
            }
            if (this.j == null) {
                this.j = new a(this);
                this.k = new a(this);
            }
            a aVar = this.j;
            if (!aVar.e) {
                aVar.b();
                a<V> aVar2 = this.j;
                aVar2.e = true;
                this.k.e = false;
                return aVar2;
            }
            this.k.b();
            a<V> aVar3 = this.k;
            aVar3.e = true;
            this.j.e = false;
            return aVar3;
        }
        return (a) invokeV.objValue;
    }

    public V b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            if (j == 0) {
                if (this.e) {
                    return this.d;
                }
                return null;
            }
            int d = d(j);
            if (d >= 0) {
                return this.c[d];
            }
            return null;
        }
        return (V) invokeJ.objValue;
    }

    public V c(long j, V v) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j, v)) == null) {
            if (j == 0) {
                return this.e ? this.d : v;
            }
            int d = d(j);
            return d >= 0 ? this.c[d] : v;
        }
        return (V) invokeJL.objValue;
    }

    public final int d(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeJ = interceptable.invokeJ(1048579, this, j)) != null) {
            return invokeJ.intValue;
        }
        long[] jArr = this.b;
        int e = e(j);
        while (true) {
            long j2 = jArr[e];
            if (j2 == 0) {
                return -(e + 1);
            }
            if (j2 == j) {
                return e;
            }
            e = (e + 1) & this.i;
        }
    }

    public int e(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) ? (int) (((j ^ (j >>> 32)) * (-7046029254386353131L)) >>> this.h) : invokeJ.intValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v1, resolved type: com.repackage.s7 */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof s7) {
                s7 s7Var = (s7) obj;
                if (s7Var.a != this.a) {
                    return false;
                }
                boolean z = s7Var.e;
                boolean z2 = this.e;
                if (z != z2) {
                    return false;
                }
                if (z2) {
                    V v = s7Var.d;
                    if (v == null) {
                        if (this.d != null) {
                            return false;
                        }
                    } else if (!v.equals(this.d)) {
                        return false;
                    }
                }
                long[] jArr = this.b;
                V[] vArr = this.c;
                int length = jArr.length;
                for (int i = 0; i < length; i++) {
                    long j = jArr[i];
                    if (j != 0) {
                        V v2 = vArr[i];
                        if (v2 == null) {
                            if (s7Var.c(j, w7.n) != null) {
                                return false;
                            }
                        } else if (!v2.equals(s7Var.b(j))) {
                            return false;
                        }
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public V f(long j, V v) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048582, this, j, v)) == null) {
            if (j == 0) {
                V v2 = this.d;
                this.d = v;
                if (!this.e) {
                    this.e = true;
                    this.a++;
                }
                return v2;
            }
            int d = d(j);
            if (d >= 0) {
                V[] vArr = this.c;
                V v3 = vArr[d];
                vArr[d] = v;
                return v3;
            }
            int i = -(d + 1);
            long[] jArr = this.b;
            jArr[i] = j;
            this.c[i] = v;
            int i2 = this.a + 1;
            this.a = i2;
            if (i2 >= this.g) {
                h(jArr.length << 1);
                return null;
            }
            return null;
        }
        return (V) invokeJL.objValue;
    }

    public final void g(long j, V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048583, this, j, v) == null) {
            long[] jArr = this.b;
            int e = e(j);
            while (jArr[e] != 0) {
                e = (e + 1) & this.i;
            }
            jArr[e] = j;
            this.c[e] = v;
        }
    }

    public final void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            int length = this.b.length;
            this.g = (int) (i * this.f);
            int i2 = i - 1;
            this.i = i2;
            this.h = Long.numberOfLeadingZeros(i2);
            long[] jArr = this.b;
            V[] vArr = this.c;
            this.b = new long[i];
            this.c = (V[]) new Object[i];
            if (this.a > 0) {
                for (int i3 = 0; i3 < length; i3++) {
                    long j = jArr[i3];
                    if (j != 0) {
                        g(j, vArr[i3]);
                    }
                }
            }
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        V v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i = this.a;
            if (this.e && (v = this.d) != null) {
                i += v.hashCode();
            }
            long[] jArr = this.b;
            V[] vArr = this.c;
            int length = jArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                long j = jArr[i2];
                if (j != 0) {
                    i = (int) (i + (j * 31));
                    V v2 = vArr[i2];
                    if (v2 != null) {
                        i += v2.hashCode();
                    }
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    @Override // java.lang.Iterable
    public Iterator<b<V>> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? a() : (Iterator) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0063  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0046 -> B:18:0x0047). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toString() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048587, this)) != null) {
            return (String) invokeV.objValue;
        }
        if (this.a == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(32);
        sb.append('[');
        long[] jArr = this.b;
        V[] vArr = this.c;
        int length = jArr.length;
        if (this.e) {
            sb.append("0=");
            sb.append(this.d);
            i = length - 1;
            if (length > 0) {
                long j = jArr[i];
                if (j != 0) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append(j);
                    sb.append('=');
                    sb.append(vArr[i]);
                }
                length = i;
                i = length - 1;
                if (length > 0) {
                    sb.append(']');
                    return sb.toString();
                }
            }
        } else {
            while (true) {
                i = length - 1;
                if (length <= 0) {
                    break;
                }
                long j2 = jArr[i];
                if (j2 != 0) {
                    sb.append(j2);
                    sb.append('=');
                    sb.append(vArr[i]);
                    break;
                }
                length = i;
            }
            length = i;
            i = length - 1;
            if (length > 0) {
            }
        }
    }

    public s7(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Float.valueOf(f)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (f > 0.0f && f < 1.0f) {
            this.f = f;
            int h = x7.h(i, f);
            this.g = (int) (h * f);
            int i4 = h - 1;
            this.i = i4;
            this.h = Long.numberOfLeadingZeros(i4);
            this.b = new long[h];
            this.c = (V[]) new Object[h];
            return;
        }
        throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + f);
    }
}
