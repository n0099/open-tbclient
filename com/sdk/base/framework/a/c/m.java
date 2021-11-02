package com.sdk.base.framework.a.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
public final class m implements Iterator<E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a<E> f68137a;

    /* renamed from: b  reason: collision with root package name */
    public a<E> f68138b;

    /* renamed from: c  reason: collision with root package name */
    public E f68139c;

    /* renamed from: d  reason: collision with root package name */
    public /* synthetic */ l f68140d;

    /* JADX WARN: Type inference failed for: r0v4, types: [E, java.lang.Object] */
    public m(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68140d = lVar;
        lVar.a();
        try {
            a aVar = lVar.f68129a.f68100a;
            this.f68137a = aVar;
            if (aVar != null) {
                this.f68139c = aVar.b();
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
                aVar2 = aVar.f68100a;
                if (aVar2 == aVar) {
                    return this.f68140d.f68129a.f68100a;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f68137a != null : invokeV.booleanValue;
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
            this.f68140d.a();
            try {
                if (this.f68137a != null) {
                    E e2 = this.f68139c;
                    this.f68138b = this.f68137a;
                    a<E> a2 = a(this.f68137a);
                    this.f68137a = a2;
                    this.f68139c = a2 == 0 ? 0 : a2.b();
                    return e2;
                }
                throw new NoSuchElementException();
            } finally {
                this.f68140d.b();
            }
        }
        return invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
        r4.f68140d.a(r1, r2);
     */
    @Override // java.util.Iterator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void remove() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f68138b == null) {
                throw new IllegalStateException();
            }
            this.f68140d.a();
            try {
                a aVar = this.f68138b;
                this.f68138b = null;
                a aVar2 = this.f68140d.f68129a;
                while (true) {
                    a aVar3 = aVar2;
                    aVar2 = aVar2.f68100a;
                    if (aVar2 == null) {
                        break;
                    } else if (aVar2 == aVar) {
                        break;
                    }
                }
            } finally {
                this.f68140d.b();
            }
        }
    }
}
