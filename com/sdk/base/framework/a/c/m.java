package com.sdk.base.framework.a.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes7.dex */
public final class m implements Iterator<E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a<E> a;
    public a<E> b;
    public E c;
    public /* synthetic */ l d;

    /* JADX WARN: Type inference failed for: r0v4, types: [E, java.lang.Object] */
    public m(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = lVar;
        lVar.a();
        try {
            a aVar = lVar.a.a;
            this.a = aVar;
            if (aVar != null) {
                this.c = aVar.b();
            }
        } finally {
            lVar.b();
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x0004 */
    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: com.sdk.base.framework.a.c.a<T>, com.sdk.base.framework.a.c.a<E>, com.sdk.base.framework.a.c.a */
    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: com.sdk.base.framework.a.c.a, com.sdk.base.framework.a.c.a<E> */
    /* JADX DEBUG: Type inference failed for r5v3. Raw type applied. Possible types: com.sdk.base.framework.a.c.a<E>, com.sdk.base.framework.a.c.a */
    /* JADX DEBUG: Type inference failed for r5v4. Raw type applied. Possible types: com.sdk.base.framework.a.c.a<T>, com.sdk.base.framework.a.c.a<E> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.sdk.base.framework.a.c.a<E>, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.sdk.base.framework.a.c.a] */
    private a<E> a(a<E> aVar) {
        a aVar2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, aVar)) == null) {
            while (true) {
                aVar2 = aVar.a;
                if (aVar2 == aVar) {
                    return this.d.a.a;
                }
                if (aVar2 == null || aVar2.b() != null) {
                    break;
                }
                aVar = aVar2;
            }
            return aVar2;
        }
        return (a) invokeL.objValue;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a != null : invokeV.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: E */
    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: E */
    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: E */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [E, java.lang.Object] */
    @Override // java.util.Iterator
    public final E next() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.d.a();
            try {
                if (this.a != null) {
                    E e = this.c;
                    this.b = this.a;
                    a<E> a = a(this.a);
                    this.a = a;
                    this.c = a == 0 ? 0 : a.b();
                    return e;
                }
                throw new NoSuchElementException();
            } finally {
                this.d.b();
            }
        }
        return invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
        r4.d.a(r1, r2);
     */
    @Override // java.util.Iterator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void remove() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.b == null) {
                throw new IllegalStateException();
            }
            this.d.a();
            try {
                a aVar = this.b;
                this.b = null;
                a aVar2 = this.d.a;
                while (true) {
                    a aVar3 = aVar2;
                    aVar2 = aVar2.a;
                    if (aVar2 == null) {
                        break;
                    } else if (aVar2 == aVar) {
                        break;
                    }
                }
            } finally {
                this.d.b();
            }
        }
    }
}
