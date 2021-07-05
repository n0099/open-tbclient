package com.kwad.sdk.glide.load.engine;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.EncodeStrategy;
/* loaded from: classes7.dex */
public abstract class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final h f38085a;

    /* renamed from: b  reason: collision with root package name */
    public static final h f38086b;

    /* renamed from: c  reason: collision with root package name */
    public static final h f38087c;

    /* renamed from: d  reason: collision with root package name */
    public static final h f38088d;

    /* renamed from: e  reason: collision with root package name */
    public static final h f38089e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-469693220, "Lcom/kwad/sdk/glide/load/engine/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-469693220, "Lcom/kwad/sdk/glide/load/engine/h;");
                return;
            }
        }
        f38085a = new h() { // from class: com.kwad.sdk.glide.load.engine.h.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.kwad.sdk.glide.load.engine.h
            public boolean a() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }

            @Override // com.kwad.sdk.glide.load.engine.h
            public boolean a(DataSource dataSource) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataSource)) == null) ? dataSource == DataSource.REMOTE : invokeL.booleanValue;
            }

            @Override // com.kwad.sdk.glide.load.engine.h
            public boolean a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), dataSource, encodeStrategy})) == null) ? (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true : invokeCommon.booleanValue;
            }

            @Override // com.kwad.sdk.glide.load.engine.h
            public boolean b() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }
        };
        f38086b = new h() { // from class: com.kwad.sdk.glide.load.engine.h.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.kwad.sdk.glide.load.engine.h
            public boolean a() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.kwad.sdk.glide.load.engine.h
            public boolean a(DataSource dataSource) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataSource)) == null) {
                    return false;
                }
                return invokeL.booleanValue;
            }

            @Override // com.kwad.sdk.glide.load.engine.h
            public boolean a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), dataSource, encodeStrategy})) == null) {
                    return false;
                }
                return invokeCommon.booleanValue;
            }

            @Override // com.kwad.sdk.glide.load.engine.h
            public boolean b() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }
        };
        f38087c = new h() { // from class: com.kwad.sdk.glide.load.engine.h.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.kwad.sdk.glide.load.engine.h
            public boolean a() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.kwad.sdk.glide.load.engine.h
            public boolean a(DataSource dataSource) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataSource)) == null) ? (dataSource == DataSource.DATA_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true : invokeL.booleanValue;
            }

            @Override // com.kwad.sdk.glide.load.engine.h
            public boolean a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), dataSource, encodeStrategy})) == null) {
                    return false;
                }
                return invokeCommon.booleanValue;
            }

            @Override // com.kwad.sdk.glide.load.engine.h
            public boolean b() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }
        };
        f38088d = new h() { // from class: com.kwad.sdk.glide.load.engine.h.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.kwad.sdk.glide.load.engine.h
            public boolean a() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }

            @Override // com.kwad.sdk.glide.load.engine.h
            public boolean a(DataSource dataSource) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataSource)) == null) {
                    return false;
                }
                return invokeL.booleanValue;
            }

            @Override // com.kwad.sdk.glide.load.engine.h
            public boolean a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), dataSource, encodeStrategy})) == null) ? (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true : invokeCommon.booleanValue;
            }

            @Override // com.kwad.sdk.glide.load.engine.h
            public boolean b() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }
        };
        f38089e = new h() { // from class: com.kwad.sdk.glide.load.engine.h.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.kwad.sdk.glide.load.engine.h
            public boolean a() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }

            @Override // com.kwad.sdk.glide.load.engine.h
            public boolean a(DataSource dataSource) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataSource)) == null) ? dataSource == DataSource.REMOTE : invokeL.booleanValue;
            }

            @Override // com.kwad.sdk.glide.load.engine.h
            public boolean a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), dataSource, encodeStrategy})) == null) ? ((z && dataSource == DataSource.DATA_DISK_CACHE) || dataSource == DataSource.LOCAL) && encodeStrategy == EncodeStrategy.TRANSFORMED : invokeCommon.booleanValue;
            }

            @Override // com.kwad.sdk.glide.load.engine.h
            public boolean b() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }
        };
    }

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public abstract boolean a();

    public abstract boolean a(DataSource dataSource);

    public abstract boolean a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy);

    public abstract boolean b();
}
