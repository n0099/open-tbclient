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
/* loaded from: classes6.dex */
public class m7<V> implements Iterable<b<V>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public V[] c;
    public V d;
    public boolean e;
    public final float f;
    public int g;
    public int h;
    public int i;
    public transient a j;
    public transient a k;

    /* loaded from: classes6.dex */
    public static class a<V> extends c<V> implements Iterable<b<V>>, Iterator<b<V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final b<V> f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(m7 m7Var) {
            super(m7Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((m7) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = new b<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: d */
        public b<V> next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a) {
                    if (this.e) {
                        m7<V> m7Var = this.b;
                        int[] iArr = m7Var.b;
                        int i = this.c;
                        if (i == -1) {
                            b<V> bVar = this.f;
                            bVar.a = 0;
                            bVar.b = m7Var.d;
                        } else {
                            b<V> bVar2 = this.f;
                            bVar2.a = iArr[i];
                            bVar2.b = m7Var.c[i];
                        }
                        this.d = this.c;
                        b();
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

    /* loaded from: classes6.dex */
    public static class b<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
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

    /* loaded from: classes6.dex */
    public static class c<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final m7<V> b;
        public int c;
        public int d;
        public boolean e;

        public c(m7<V> m7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m7Var};
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
            this.b = m7Var;
            c();
        }

        public void b() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int[] iArr = this.b.b;
                int length = iArr.length;
                do {
                    i = this.c + 1;
                    this.c = i;
                    if (i >= length) {
                        this.a = false;
                        return;
                    }
                } while (iArr[i] == 0);
                this.a = true;
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.d = -2;
                this.c = -1;
                if (this.b.e) {
                    this.a = true;
                } else {
                    b();
                }
            }
        }

        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                int i = this.d;
                if (i == -1) {
                    m7<V> m7Var = this.b;
                    if (m7Var.e) {
                        m7Var.e = false;
                        m7Var.d = null;
                        this.d = -2;
                        m7<V> m7Var2 = this.b;
                        m7Var2.a--;
                        return;
                    }
                }
                if (i >= 0) {
                    m7<V> m7Var3 = this.b;
                    int[] iArr = m7Var3.b;
                    V[] vArr = m7Var3.c;
                    int i2 = m7Var3.i;
                    int i3 = i + 1;
                    while (true) {
                        int i4 = i3 & i2;
                        int i5 = iArr[i4];
                        if (i5 == 0) {
                            break;
                        }
                        int e = this.b.e(i5);
                        if (((i4 - e) & i2) > ((i - e) & i2)) {
                            iArr[i] = i5;
                            vArr[i] = vArr[i4];
                            i = i4;
                        }
                        i3 = i4 + 1;
                    }
                    iArr[i] = 0;
                    vArr[i] = null;
                    if (i != this.d) {
                        this.c--;
                    }
                    this.d = -2;
                    m7<V> m7Var22 = this.b;
                    m7Var22.a--;
                    return;
                }
                throw new IllegalStateException("next must be called before remove.");
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public m7() {
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

    public a<V> b() {
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
                aVar.c();
                a<V> aVar2 = this.j;
                aVar2.e = true;
                this.k.e = false;
                return aVar2;
            }
            this.k.c();
            a<V> aVar3 = this.k;
            aVar3.e = true;
            this.j.e = false;
            return aVar3;
        }
        return (a) invokeV.objValue;
    }

    public V c(int i, V v) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, v)) == null) {
            if (i == 0) {
                return this.e ? this.d : v;
            }
            int d = d(i);
            return d >= 0 ? this.c[d] : v;
        }
        return (V) invokeIL.objValue;
    }

    public final int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) != null) {
            return invokeI.intValue;
        }
        int[] iArr = this.b;
        int e = e(i);
        while (true) {
            int i2 = iArr[e];
            if (i2 == 0) {
                return -(e + 1);
            }
            if (i2 == i) {
                return e;
            }
            e = (e + 1) & this.i;
        }
    }

    public int e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? (int) ((i * (-7046029254386353131L)) >>> this.h) : invokeI.intValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v1, resolved type: com.repackage.m7 */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof m7) {
                m7 m7Var = (m7) obj;
                if (m7Var.a != this.a) {
                    return false;
                }
                boolean z = m7Var.e;
                boolean z2 = this.e;
                if (z != z2) {
                    return false;
                }
                if (z2) {
                    V v = m7Var.d;
                    if (v == null) {
                        if (this.d != null) {
                            return false;
                        }
                    } else if (!v.equals(this.d)) {
                        return false;
                    }
                }
                int[] iArr = this.b;
                V[] vArr = this.c;
                int length = iArr.length;
                for (int i = 0; i < length; i++) {
                    int i2 = iArr[i];
                    if (i2 != 0) {
                        V v2 = vArr[i];
                        if (v2 == null) {
                            if (m7Var.c(i2, w7.n) != null) {
                                return false;
                            }
                        } else if (!v2.equals(m7Var.get(i2))) {
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

    public V f(int i, V v) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i, v)) == null) {
            if (i == 0) {
                V v2 = this.d;
                this.d = v;
                if (!this.e) {
                    this.e = true;
                    this.a++;
                }
                return v2;
            }
            int d = d(i);
            if (d >= 0) {
                V[] vArr = this.c;
                V v3 = vArr[d];
                vArr[d] = v;
                return v3;
            }
            int i2 = -(d + 1);
            int[] iArr = this.b;
            iArr[i2] = i;
            this.c[i2] = v;
            int i3 = this.a + 1;
            this.a = i3;
            if (i3 >= this.g) {
                h(iArr.length << 1);
                return null;
            }
            return null;
        }
        return (V) invokeIL.objValue;
    }

    public final void g(int i, V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, v) == null) {
            int[] iArr = this.b;
            int e = e(i);
            while (iArr[e] != 0) {
                e = (e + 1) & this.i;
            }
            iArr[e] = i;
            this.c[e] = v;
        }
    }

    public V get(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            if (i == 0) {
                if (this.e) {
                    return this.d;
                }
                return null;
            }
            int d = d(i);
            if (d >= 0) {
                return this.c[d];
            }
            return null;
        }
        return (V) invokeI.objValue;
    }

    public final void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            int length = this.b.length;
            this.g = (int) (i * this.f);
            int i2 = i - 1;
            this.i = i2;
            this.h = Long.numberOfLeadingZeros(i2);
            int[] iArr = this.b;
            V[] vArr = this.c;
            this.b = new int[i];
            this.c = (V[]) new Object[i];
            if (this.a > 0) {
                for (int i3 = 0; i3 < length; i3++) {
                    int i4 = iArr[i3];
                    if (i4 != 0) {
                        g(i4, vArr[i3]);
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
            int[] iArr = this.b;
            V[] vArr = this.c;
            int length = iArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = iArr[i2];
                if (i3 != 0) {
                    i += i3 * 31;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? b() : (Iterator) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0042 -> B:18:0x0043). Please submit an issue!!! */
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
        int[] iArr = this.b;
        V[] vArr = this.c;
        int length = iArr.length;
        if (this.e) {
            sb.append("0=");
            sb.append(this.d);
            i = length - 1;
            if (length > 0) {
                int i2 = iArr[i];
                if (i2 != 0) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append(i2);
                    sb.append('=');
                    sb.append(vArr[i]);
                }
                length = i;
                i = length - 1;
                if (length > 0) {
                }
            } else {
                sb.append(']');
                return sb.toString();
            }
        } else {
            while (true) {
                i = length - 1;
                if (length > 0) {
                    int i3 = iArr[i];
                    if (i3 != 0) {
                        sb.append(i3);
                        sb.append('=');
                        sb.append(vArr[i]);
                        break;
                    }
                    length = i;
                } else {
                    break;
                }
            }
            length = i;
            i = length - 1;
            if (length > 0) {
            }
        }
    }

    public m7(int i, float f) {
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
            this.b = new int[h];
            this.c = (V[]) new Object[h];
            return;
        }
        throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + f);
    }
}
