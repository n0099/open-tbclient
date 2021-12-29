package i.o.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.o.d.j.i;
/* loaded from: classes4.dex */
public final class d<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final float a;

    /* renamed from: b  reason: collision with root package name */
    public int f64431b;

    /* renamed from: c  reason: collision with root package name */
    public int f64432c;

    /* renamed from: d  reason: collision with root package name */
    public int f64433d;

    /* renamed from: e  reason: collision with root package name */
    public T[] f64434e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d() {
        this(16, 0.75f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Integer) objArr[0]).intValue(), ((Float) objArr[1]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static int c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            int i3 = i2 * (-1640531527);
            return i3 ^ (i3 >>> 16);
        }
        return invokeI.intValue;
    }

    public boolean a(T t) {
        InterceptResult invokeL;
        T t2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) {
            T[] tArr = this.f64434e;
            int i2 = this.f64431b;
            int c2 = c(t.hashCode()) & i2;
            T t3 = tArr[c2];
            if (t3 != null) {
                if (t3.equals(t)) {
                    return false;
                }
                do {
                    c2 = (c2 + 1) & i2;
                    t2 = tArr[c2];
                    if (t2 == null) {
                    }
                } while (!t2.equals(t));
                return false;
            }
            tArr[c2] = t;
            int i3 = this.f64432c + 1;
            this.f64432c = i3;
            if (i3 >= this.f64433d) {
                d();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64432c == 0 : invokeV.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
            return;
        }
        T[] tArr = this.f64434e;
        int length = tArr.length;
        int i2 = length << 1;
        int i3 = i2 - 1;
        T[] tArr2 = (T[]) new Object[i2];
        int i4 = this.f64432c;
        while (true) {
            int i5 = i4 - 1;
            if (i4 != 0) {
                do {
                    length--;
                } while (tArr[length] == null);
                int c2 = c(tArr[length].hashCode()) & i3;
                if (tArr2[c2] != null) {
                    do {
                        c2 = (c2 + 1) & i3;
                    } while (tArr2[c2] != null);
                }
                tArr2[c2] = tArr[length];
                i4 = i5;
            } else {
                this.f64431b = i3;
                this.f64433d = (int) (i2 * this.a);
                this.f64434e = tArr2;
                return;
            }
        }
    }

    public boolean e(T t) {
        InterceptResult invokeL;
        T t2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, t)) == null) {
            T[] tArr = this.f64434e;
            int i2 = this.f64431b;
            int c2 = c(t.hashCode()) & i2;
            T t3 = tArr[c2];
            if (t3 == null) {
                return false;
            }
            if (t3.equals(t)) {
                return f(c2, tArr, i2);
            }
            do {
                c2 = (c2 + 1) & i2;
                t2 = tArr[c2];
                if (t2 == null) {
                    return false;
                }
            } while (!t2.equals(t));
            return f(c2, tArr, i2);
        }
        return invokeL.booleanValue;
    }

    public boolean f(int i2, T[] tArr, int i3) {
        InterceptResult invokeCommon;
        int i4;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), tArr, Integer.valueOf(i3)})) != null) {
            return invokeCommon.booleanValue;
        }
        this.f64432c--;
        while (true) {
            int i5 = i2 + 1;
            while (true) {
                i4 = i5 & i3;
                t = tArr[i4];
                if (t == null) {
                    tArr[i2] = null;
                    return true;
                }
                int c2 = c(t.hashCode()) & i3;
                if (i2 > i4) {
                    if (i2 >= c2 && c2 > i4) {
                        break;
                    }
                    i5 = i4 + 1;
                } else if (i2 < c2 && c2 <= i4) {
                    i5 = i4 + 1;
                }
            }
            tArr[i2] = t;
            i2 = i4;
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f64432c = 0;
            this.f64434e = (T[]) new Object[0];
        }
    }

    public T[] h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f64434e : (T[]) ((Object[]) invokeV.objValue);
    }

    public d(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Float.valueOf(f2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = f2;
        int b2 = i.b(i2);
        this.f64431b = b2 - 1;
        this.f64433d = (int) (f2 * b2);
        this.f64434e = (T[]) new Object[b2];
    }
}
