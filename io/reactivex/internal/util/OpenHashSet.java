package io.reactivex.internal.util;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class OpenHashSet<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INT_PHI = -1640531527;
    public transient /* synthetic */ FieldHolder $fh;
    public T[] keys;
    public final float loadFactor;
    public int mask;
    public int maxSize;
    public int size;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OpenHashSet() {
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

    public static int mix(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            int i3 = i2 * (-1640531527);
            return i3 ^ (i3 >>> 16);
        }
        return invokeI.intValue;
    }

    public boolean add(T t) {
        InterceptResult invokeL;
        T t2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) {
            T[] tArr = this.keys;
            int i2 = this.mask;
            int mix = mix(t.hashCode()) & i2;
            T t3 = tArr[mix];
            if (t3 != null) {
                if (t3.equals(t)) {
                    return false;
                }
                do {
                    mix = (mix + 1) & i2;
                    t2 = tArr[mix];
                    if (t2 == null) {
                    }
                } while (!t2.equals(t));
                return false;
            }
            tArr[mix] = t;
            int i3 = this.size + 1;
            this.size = i3;
            if (i3 >= this.maxSize) {
                rehash();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public Object[] keys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.keys : (Object[]) invokeV.objValue;
    }

    public void rehash() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
            return;
        }
        T[] tArr = this.keys;
        int length = tArr.length;
        int i2 = length << 1;
        int i3 = i2 - 1;
        T[] tArr2 = (T[]) new Object[i2];
        int i4 = this.size;
        while (true) {
            int i5 = i4 - 1;
            if (i4 != 0) {
                do {
                    length--;
                } while (tArr[length] == null);
                int mix = mix(tArr[length].hashCode()) & i3;
                if (tArr2[mix] != null) {
                    do {
                        mix = (mix + 1) & i3;
                    } while (tArr2[mix] != null);
                }
                tArr2[mix] = tArr[length];
                i4 = i5;
            } else {
                this.mask = i3;
                this.maxSize = (int) (i2 * this.loadFactor);
                this.keys = tArr2;
                return;
            }
        }
    }

    public boolean remove(T t) {
        InterceptResult invokeL;
        T t2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, t)) == null) {
            T[] tArr = this.keys;
            int i2 = this.mask;
            int mix = mix(t.hashCode()) & i2;
            T t3 = tArr[mix];
            if (t3 == null) {
                return false;
            }
            if (t3.equals(t)) {
                return removeEntry(mix, tArr, i2);
            }
            do {
                mix = (mix + 1) & i2;
                t2 = tArr[mix];
                if (t2 == null) {
                    return false;
                }
            } while (!t2.equals(t));
            return removeEntry(mix, tArr, i2);
        }
        return invokeL.booleanValue;
    }

    public boolean removeEntry(int i2, T[] tArr, int i3) {
        InterceptResult invokeCommon;
        int i4;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), tArr, Integer.valueOf(i3)})) != null) {
            return invokeCommon.booleanValue;
        }
        this.size--;
        while (true) {
            int i5 = i2 + 1;
            while (true) {
                i4 = i5 & i3;
                t = tArr[i4];
                if (t == null) {
                    tArr[i2] = null;
                    return true;
                }
                int mix = mix(t.hashCode()) & i3;
                if (i2 > i4) {
                    if (i2 >= mix && mix > i4) {
                        break;
                    }
                    i5 = i4 + 1;
                } else if (i2 < mix && mix <= i4) {
                    i5 = i4 + 1;
                }
            }
            tArr[i2] = t;
            i2 = i4;
        }
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.size : invokeV.intValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OpenHashSet(int i2) {
        this(i2, 0.75f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Float) objArr2[1]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public OpenHashSet(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Float.valueOf(f2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.loadFactor = f2;
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i2);
        this.mask = roundToPowerOfTwo - 1;
        this.maxSize = (int) (f2 * roundToPowerOfTwo);
        this.keys = (T[]) new Object[roundToPowerOfTwo];
    }
}
