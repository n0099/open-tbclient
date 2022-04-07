package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class c4 implements Iterable<b4>, Comparator<b4>, Comparable<c4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public final y6<b4> b;
    public boolean c;

    public c4() {
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
        this.b = new y6<>();
        this.c = true;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            j();
            int i = this.b.b;
            long j = this.a + 71;
            int i2 = 1;
            for (int i3 = 0; i3 < i; i3++) {
                i2 = (i2 * 7) & 65535;
                j += this.a * this.b.get(i3).hashCode() * i2;
            }
            return (int) (j ^ (j >> 32));
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: c */
    public final int compare(b4 b4Var, b4 b4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b4Var, b4Var2)) == null) ? (int) (b4Var.a - b4Var2.a) : invokeLL.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: d */
    public int compareTo(c4 c4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048580, this, c4Var)) != null) {
            return invokeL.intValue;
        }
        if (c4Var == this) {
            return 0;
        }
        long j = this.a;
        long j2 = c4Var.a;
        if (j != j2) {
            return j < j2 ? -1 : 1;
        }
        j();
        c4Var.j();
        int i = 0;
        while (true) {
            y6<b4> y6Var = this.b;
            if (i >= y6Var.b) {
                return 0;
            }
            int compareTo = y6Var.get(i).compareTo(c4Var.b.get(i));
            if (compareTo != 0) {
                if (compareTo < 0) {
                    return -1;
                }
                return compareTo > 0 ? 1 : 0;
            }
            i++;
        }
    }

    public final void e(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.a = j | this.a;
        }
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (obj instanceof c4) {
                if (obj == this) {
                    return true;
                }
                return h((c4) obj, true);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean f(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) ? j != 0 && (this.a & j) == j : invokeJ.booleanValue;
    }

    public int g(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j)) != null) {
            return invokeJ.intValue;
        }
        if (!f(j)) {
            return -1;
        }
        int i = 0;
        while (true) {
            y6<b4> y6Var = this.b;
            if (i >= y6Var.b) {
                return -1;
            }
            if (y6Var.get(i).a == j) {
                return i;
            }
            i++;
        }
    }

    public final boolean h(c4 c4Var, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLZ = interceptable.invokeLZ(1048585, this, c4Var, z)) != null) {
            return invokeLZ.booleanValue;
        }
        if (c4Var == this) {
            return true;
        }
        if (c4Var == null || this.a != c4Var.a) {
            return false;
        }
        if (!z) {
            return true;
        }
        j();
        c4Var.j();
        int i = 0;
        while (true) {
            y6<b4> y6Var = this.b;
            if (i >= y6Var.b) {
                return true;
            }
            if (!y6Var.get(i).a(c4Var.b.get(i))) {
                return false;
            }
            i++;
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? b() : invokeV.intValue;
    }

    public final void i(b4 b4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, b4Var) == null) {
            int g = g(b4Var.a);
            if (g < 0) {
                e(b4Var.a);
                this.b.a(b4Var);
                this.c = false;
            } else {
                this.b.l(g, b4Var);
            }
            j();
        }
    }

    @Override // java.lang.Iterable
    public final Iterator<b4> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.b.iterator() : (Iterator) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.c) {
            return;
        }
        this.b.sort(this);
        this.c = true;
    }
}
