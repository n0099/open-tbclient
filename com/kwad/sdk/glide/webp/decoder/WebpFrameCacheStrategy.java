package com.kwad.sdk.glide.webp.decoder;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class WebpFrameCacheStrategy {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final WebpFrameCacheStrategy f38378a;

    /* renamed from: b  reason: collision with root package name */
    public static final WebpFrameCacheStrategy f38379b;

    /* renamed from: c  reason: collision with root package name */
    public static final WebpFrameCacheStrategy f38380c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public CacheControl f38381d;

    /* renamed from: e  reason: collision with root package name */
    public int f38382e;

    /* renamed from: com.kwad.sdk.glide.webp.decoder.WebpFrameCacheStrategy$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class CacheControl {
        public static final /* synthetic */ CacheControl[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final CacheControl CACHE_ALL;
        public static final CacheControl CACHE_AUTO;
        public static final CacheControl CACHE_LIMITED;
        public static final CacheControl CACHE_NONE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(278106681, "Lcom/kwad/sdk/glide/webp/decoder/WebpFrameCacheStrategy$CacheControl;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(278106681, "Lcom/kwad/sdk/glide/webp/decoder/WebpFrameCacheStrategy$CacheControl;");
                    return;
                }
            }
            CACHE_NONE = new CacheControl("CACHE_NONE", 0);
            CACHE_LIMITED = new CacheControl("CACHE_LIMITED", 1);
            CACHE_AUTO = new CacheControl("CACHE_AUTO", 2);
            CacheControl cacheControl = new CacheControl("CACHE_ALL", 3);
            CACHE_ALL = cacheControl;
            $VALUES = new CacheControl[]{CACHE_NONE, CACHE_LIMITED, CACHE_AUTO, cacheControl};
        }

        public CacheControl(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static CacheControl valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (CacheControl) Enum.valueOf(CacheControl.class, str) : (CacheControl) invokeL.objValue;
        }

        public static CacheControl[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (CacheControl[]) $VALUES.clone() : (CacheControl[]) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public CacheControl f38383a;

        /* renamed from: b  reason: collision with root package name */
        public int f38384b;

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

        public a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f38383a = CacheControl.CACHE_NONE;
                return this;
            }
            return (a) invokeV.objValue;
        }

        public a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                this.f38383a = CacheControl.CACHE_ALL;
                return this;
            }
            return (a) invokeV.objValue;
        }

        public a c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                this.f38383a = CacheControl.CACHE_AUTO;
                return this;
            }
            return (a) invokeV.objValue;
        }

        public WebpFrameCacheStrategy d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new WebpFrameCacheStrategy(this, null) : (WebpFrameCacheStrategy) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1248318146, "Lcom/kwad/sdk/glide/webp/decoder/WebpFrameCacheStrategy;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1248318146, "Lcom/kwad/sdk/glide/webp/decoder/WebpFrameCacheStrategy;");
                return;
            }
        }
        f38378a = new a().a().d();
        f38379b = new a().c().d();
        f38380c = new a().b().d();
    }

    public WebpFrameCacheStrategy(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38381d = aVar.f38383a;
        this.f38382e = aVar.f38384b;
    }

    public /* synthetic */ WebpFrameCacheStrategy(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f38381d == CacheControl.CACHE_NONE : invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f38381d == CacheControl.CACHE_ALL : invokeV.booleanValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f38382e : invokeV.intValue;
    }
}
