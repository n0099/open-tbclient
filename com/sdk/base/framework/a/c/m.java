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

    /* renamed from: a  reason: collision with root package name */
    public a<E> f41126a;

    /* renamed from: b  reason: collision with root package name */
    public a<E> f41127b;

    /* renamed from: c  reason: collision with root package name */
    public E f41128c;

    /* renamed from: d  reason: collision with root package name */
    public /* synthetic */ l f41129d;

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
        this.f41129d = lVar;
        lVar.a();
        try {
            a aVar = lVar.f41118a.f41089a;
            this.f41126a = aVar;
            if (aVar != null) {
                this.f41128c = aVar.b();
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
                aVar2 = aVar.f41089a;
                if (aVar2 == aVar) {
                    return this.f41129d.f41118a.f41089a;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f41126a != null : invokeV.booleanValue;
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
            this.f41129d.a();
            try {
                if (this.f41126a != null) {
                    E e2 = this.f41128c;
                    this.f41127b = this.f41126a;
                    a<E> a2 = a(this.f41126a);
                    this.f41126a = a2;
                    this.f41128c = a2 == 0 ? 0 : a2.b();
                    return e2;
                }
                throw new NoSuchElementException();
            } finally {
                this.f41129d.b();
            }
        }
        return invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
        r4.f41129d.a(r1, r2);
     */
    @Override // java.util.Iterator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void remove() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f41127b == null) {
                throw new IllegalStateException();
            }
            this.f41129d.a();
            try {
                a aVar = this.f41127b;
                this.f41127b = null;
                a aVar2 = this.f41129d.f41118a;
                while (true) {
                    a aVar3 = aVar2;
                    aVar2 = aVar2.f41089a;
                    if (aVar2 == null) {
                        break;
                    } else if (aVar2 == aVar) {
                        break;
                    }
                }
            } finally {
                this.f41129d.b();
            }
        }
    }
}
