package i.o.d.j;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class j<E> extends n<E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? k() == h() : invokeV.booleanValue;
    }

    @Override // java.util.Queue
    public boolean offer(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2)) == null) {
            if (e2 != null) {
                E[] eArr = this.f64489f;
                long j2 = this.f64488e;
                long h2 = h();
                long a = a(h2);
                if (e(eArr, a) != null) {
                    if (h2 - k() > j2) {
                        return false;
                    }
                    do {
                    } while (e(eArr, a) != null);
                    g(eArr, a, e2);
                    i(h2 + 1);
                    return true;
                }
                g(eArr, a, e2);
                i(h2 + 1);
                return true;
            }
            throw new NullPointerException("Null is not a valid element");
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.Queue
    public E peek() {
        InterceptResult invokeV;
        E d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            long l = l();
            do {
                long k2 = k();
                if (k2 >= l) {
                    long h2 = h();
                    if (k2 >= h2) {
                        return null;
                    }
                    m(h2);
                }
                d2 = d(a(k2));
            } while (d2 == null);
            return d2;
        }
        return (E) invokeV.objValue;
    }

    @Override // java.util.Queue, i.o.d.j.h
    public E poll() {
        InterceptResult invokeV;
        long k2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            long l = l();
            do {
                k2 = k();
                if (k2 >= l) {
                    long h2 = h();
                    if (k2 >= h2) {
                        return null;
                    }
                    m(h2);
                }
            } while (!j(k2, 1 + k2));
            long a = a(k2);
            E[] eArr = this.f64489f;
            E c2 = c(eArr, a);
            f(eArr, a, null);
            return c2;
        }
        return (E) invokeV.objValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048580, this)) != null) {
            return invokeV.intValue;
        }
        long k2 = k();
        while (true) {
            long h2 = h();
            long k3 = k();
            if (k2 == k3) {
                return (int) (h2 - k3);
            }
            k2 = k3;
        }
    }
}
