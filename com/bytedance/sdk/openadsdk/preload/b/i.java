package com.bytedance.sdk.openadsdk.preload.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public final class i implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public e f31981a;

    /* renamed from: b  reason: collision with root package name */
    public int f31982b;

    /* renamed from: c  reason: collision with root package name */
    public List<h> f31983c;

    /* renamed from: d  reason: collision with root package name */
    public d f31984d;

    /* loaded from: classes6.dex */
    public static final class a extends Exception {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Throwable th) {
            super(th);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Throwable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public i(List<h> list, int i2, e eVar, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, Integer.valueOf(i2), eVar, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31983c = list;
        this.f31982b = i2;
        this.f31981a = eVar;
        this.f31984d = dVar;
    }

    private d c(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, cls)) == null) {
            d dVar = this.f31984d;
            while (dVar != null && dVar.getClass() != cls) {
                dVar = dVar.f31962a;
            }
            return dVar;
        }
        return (d) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.openadsdk.preload.b.b
    public Object a(Object obj) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            d dVar = this.f31984d;
            if (dVar != null) {
                dVar.f31964c = obj;
                dVar.f();
            }
            if (this.f31982b >= this.f31983c.size()) {
                return obj;
            }
            h hVar = this.f31983c.get(this.f31982b);
            Class<? extends d> a2 = hVar.a();
            d dVar2 = (d) this.f31981a.a(a2);
            if (dVar2 != null) {
                com.bytedance.sdk.openadsdk.preload.b.b.a b2 = hVar.b();
                i iVar = new i(this.f31983c, this.f31982b + 1, this.f31981a, dVar2);
                dVar2.a(iVar, this.f31984d, obj, b2, hVar.c());
                dVar2.d();
                try {
                    Object a_ = dVar2.a_(iVar, obj);
                    dVar2.e();
                    return a_;
                } catch (a e2) {
                    dVar2.c(e2.getCause());
                    throw e2;
                } catch (Throwable th) {
                    dVar2.b(th);
                    throw new a(th);
                }
            }
            throw new IllegalArgumentException("interceptor == null , index = " + obj + " , class: " + a2);
        }
        return invokeL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.b
    public Object b(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cls)) == null) {
            d c2 = c(cls);
            if (c2 != null) {
                return c2.f31964c;
            }
            throw new IllegalArgumentException("can not find pre Interceptor , class:" + cls);
        }
        return invokeL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.b
    public Object a(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
            d c2 = c(cls);
            if (c2 != null) {
                return c2.f31963b;
            }
            throw new IllegalArgumentException("can not find pre Interceptor , class:" + cls);
        }
        return invokeL.objValue;
    }
}
