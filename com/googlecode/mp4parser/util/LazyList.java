package com.googlecode.mp4parser.util;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
/* loaded from: classes7.dex */
public class LazyList<E> extends AbstractList<E> {
    public static /* synthetic */ Interceptable $ic;
    public static final Logger LOG;
    public transient /* synthetic */ FieldHolder $fh;
    public Iterator<E> elementSource;
    public List<E> underlying;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(728474346, "Lcom/googlecode/mp4parser/util/LazyList;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(728474346, "Lcom/googlecode/mp4parser/util/LazyList;");
                return;
            }
        }
        LOG = Logger.getLogger(LazyList.class);
    }

    public LazyList(List<E> list, Iterator<E> it) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, it};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.underlying = list;
        this.elementSource = it;
    }

    private void blowup() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            LOG.logDebug("blowup running");
            while (this.elementSource.hasNext()) {
                this.underlying.add(this.elementSource.next());
            }
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (this.underlying.size() > i) {
                return this.underlying.get(i);
            }
            if (this.elementSource.hasNext()) {
                this.underlying.add(this.elementSource.next());
                return get(i);
            }
            throw new NoSuchElementException();
        }
        return (E) invokeI.objValue;
    }

    public List<E> getUnderlying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.underlying : (List) invokeV.objValue;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new Iterator<E>(this) { // from class: com.googlecode.mp4parser.util.LazyList.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int pos;
            public final /* synthetic */ LazyList this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.pos = 0;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) ? this.pos < this.this$0.underlying.size() || this.this$0.elementSource.hasNext() : invokeV2.booleanValue;
            }

            @Override // java.util.Iterator
            public E next() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    if (this.pos < this.this$0.underlying.size()) {
                        List<E> list = this.this$0.underlying;
                        int i = this.pos;
                        this.pos = i + 1;
                        return list.get(i);
                    }
                    LazyList lazyList = this.this$0;
                    lazyList.underlying.add(lazyList.elementSource.next());
                    return (E) next();
                }
                return (E) invokeV2.objValue;
            }

            @Override // java.util.Iterator
            public void remove() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    throw new UnsupportedOperationException();
                }
            }
        } : (Iterator) invokeV.objValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            LOG.logDebug("potentially expensive size() call");
            blowup();
            return this.underlying.size();
        }
        return invokeV.intValue;
    }
}
