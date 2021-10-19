package com.bytedance.sdk.openadsdk.preload.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes9.dex */
public final class i implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public e f68977a;

    /* renamed from: b  reason: collision with root package name */
    public int f68978b;

    /* renamed from: c  reason: collision with root package name */
    public List<h> f68979c;

    /* renamed from: d  reason: collision with root package name */
    public d f68980d;

    /* loaded from: classes9.dex */
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
        this.f68979c = list;
        this.f68978b = i2;
        this.f68977a = eVar;
        this.f68980d = dVar;
    }

    private d c(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, cls)) == null) {
            d dVar = this.f68980d;
            while (dVar != null && dVar.getClass() != cls) {
                dVar = dVar.f68958a;
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
            d dVar = this.f68980d;
            if (dVar != null) {
                dVar.f68960c = obj;
                dVar.f();
            }
            if (this.f68978b >= this.f68979c.size()) {
                return obj;
            }
            h hVar = this.f68979c.get(this.f68978b);
            Class<? extends d> a2 = hVar.a();
            d dVar2 = (d) this.f68977a.a(a2);
            if (dVar2 != null) {
                com.bytedance.sdk.openadsdk.preload.b.b.a b2 = hVar.b();
                i iVar = new i(this.f68979c, this.f68978b + 1, this.f68977a, dVar2);
                dVar2.a(iVar, this.f68980d, obj, b2, hVar.c());
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
                return c2.f68960c;
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
                return c2.f68959b;
            }
            throw new IllegalArgumentException("can not find pre Interceptor , class:" + cls);
        }
        return invokeL.objValue;
    }
}
