package h.o.d.i;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.o.d.j.i;
import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes3.dex */
public abstract class a<E> extends AbstractQueue<E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReferenceArray<E> f72090e;

    /* renamed from: f  reason: collision with root package name */
    public final int f72091f;

    public a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        int b2 = i.b(i2);
        this.f72091f = b2 - 1;
        this.f72090e = new AtomicReferenceArray<>(b2);
    }

    public final int a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) ? this.f72091f & ((int) j) : invokeJ.intValue;
    }

    public final int b(long j, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)})) == null) ? ((int) j) & i2 : invokeCommon.intValue;
    }

    public final E c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? d(this.f72090e, i2) : (E) invokeI.objValue;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048579, this) != null) {
            return;
        }
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public final E d(AtomicReferenceArray<E> atomicReferenceArray, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, atomicReferenceArray, i2)) == null) ? atomicReferenceArray.get(i2) : (E) invokeLI.objValue;
    }

    public final void e(AtomicReferenceArray<E> atomicReferenceArray, int i2, E e2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048581, this, atomicReferenceArray, i2, e2) == null) {
            atomicReferenceArray.lazySet(i2, e2);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (Iterator) invokeV.objValue;
    }
}
