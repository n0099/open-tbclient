package com.bytedance.sdk.openadsdk.preload.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Class<? extends d> f32286a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.preload.b.b.a f32287b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f32288c;

    /* renamed from: com.bytedance.sdk.openadsdk.preload.b.h$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Class<? extends d> f32289a;

        /* renamed from: b  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.preload.b.b.a f32290b;

        /* renamed from: c  reason: collision with root package name */
        public Object[] f32291c;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new a() : (a) invokeV.objValue;
        }

        public h b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new h(this, null) : (h) invokeV.objValue;
        }

        public a a(Class<? extends d> cls) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls)) == null) {
                if (cls != null) {
                    this.f32289a = cls;
                    return this;
                }
                throw new IllegalArgumentException("interceptor class == null");
            }
            return (a) invokeL.objValue;
        }

        public a a(com.bytedance.sdk.openadsdk.preload.b.b.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                this.f32290b = aVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, objArr)) == null) {
                if (objArr != null) {
                    this.f32291c = objArr;
                    return this;
                }
                throw new IllegalArgumentException("args == null");
            }
            return (a) invokeL.objValue;
        }
    }

    public /* synthetic */ h(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    public Class<? extends d> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f32286a : (Class) invokeV.objValue;
    }

    public com.bytedance.sdk.openadsdk.preload.b.b.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f32287b : (com.bytedance.sdk.openadsdk.preload.b.b.a) invokeV.objValue;
    }

    public Object[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32288c : (Object[]) invokeV.objValue;
    }

    public h(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32286a = aVar.f32289a;
        this.f32287b = aVar.f32290b;
        this.f32288c = aVar.f32291c;
        if (this.f32286a == null) {
            throw new IllegalArgumentException("Interceptor class == null");
        }
    }
}
