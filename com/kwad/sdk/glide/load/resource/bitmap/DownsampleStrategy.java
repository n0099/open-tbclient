package com.kwad.sdk.glide.load.resource.bitmap;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class DownsampleStrategy {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final DownsampleStrategy f38190a;

    /* renamed from: b  reason: collision with root package name */
    public static final DownsampleStrategy f38191b;

    /* renamed from: c  reason: collision with root package name */
    public static final DownsampleStrategy f38192c;

    /* renamed from: d  reason: collision with root package name */
    public static final DownsampleStrategy f38193d;

    /* renamed from: e  reason: collision with root package name */
    public static final DownsampleStrategy f38194e;

    /* renamed from: f  reason: collision with root package name */
    public static final DownsampleStrategy f38195f;

    /* renamed from: g  reason: collision with root package name */
    public static final DownsampleStrategy f38196g;

    /* renamed from: h  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<DownsampleStrategy> f38197h;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class SampleSizeRounding {
        public static final /* synthetic */ SampleSizeRounding[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SampleSizeRounding MEMORY;
        public static final SampleSizeRounding QUALITY;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(27595738, "Lcom/kwad/sdk/glide/load/resource/bitmap/DownsampleStrategy$SampleSizeRounding;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(27595738, "Lcom/kwad/sdk/glide/load/resource/bitmap/DownsampleStrategy$SampleSizeRounding;");
                    return;
                }
            }
            MEMORY = new SampleSizeRounding("MEMORY", 0);
            SampleSizeRounding sampleSizeRounding = new SampleSizeRounding("QUALITY", 1);
            QUALITY = sampleSizeRounding;
            $VALUES = new SampleSizeRounding[]{MEMORY, sampleSizeRounding};
        }

        public SampleSizeRounding(String str, int i2) {
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

        public static SampleSizeRounding valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SampleSizeRounding) Enum.valueOf(SampleSizeRounding.class, str) : (SampleSizeRounding) invokeL.objValue;
        }

        public static SampleSizeRounding[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SampleSizeRounding[]) $VALUES.clone() : (SampleSizeRounding[]) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class a extends DownsampleStrategy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public float a(int i2, int i3, int i4, int i5) {
            InterceptResult invokeIIII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048576, this, i2, i3, i4, i5)) == null) {
                int min = Math.min(i3 / i5, i2 / i4);
                if (min == 0) {
                    return 1.0f;
                }
                return 1.0f / Integer.highestOneBit(min);
            }
            return invokeIIII.floatValue;
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding b(int i2, int i3, int i4, int i5) {
            InterceptResult invokeIIII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIIII = interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4, i5)) == null) ? SampleSizeRounding.QUALITY : (SampleSizeRounding) invokeIIII.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends DownsampleStrategy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public float a(int i2, int i3, int i4, int i5) {
            InterceptResult invokeIIII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048576, this, i2, i3, i4, i5)) == null) {
                int ceil = (int) Math.ceil(Math.max(i3 / i5, i2 / i4));
                int max = Math.max(1, Integer.highestOneBit(ceil));
                return 1.0f / (max << (max >= ceil ? 0 : 1));
            }
            return invokeIIII.floatValue;
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding b(int i2, int i3, int i4, int i5) {
            InterceptResult invokeIIII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIIII = interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4, i5)) == null) ? SampleSizeRounding.MEMORY : (SampleSizeRounding) invokeIIII.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends DownsampleStrategy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public float a(int i2, int i3, int i4, int i5) {
            InterceptResult invokeIIII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048576, this, i2, i3, i4, i5)) == null) ? Math.min(1.0f, DownsampleStrategy.f38190a.a(i2, i3, i4, i5)) : invokeIIII.floatValue;
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding b(int i2, int i3, int i4, int i5) {
            InterceptResult invokeIIII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIIII = interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4, i5)) == null) ? SampleSizeRounding.QUALITY : (SampleSizeRounding) invokeIIII.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class d extends DownsampleStrategy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
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

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public float a(int i2, int i3, int i4, int i5) {
            InterceptResult invokeIIII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048576, this, i2, i3, i4, i5)) == null) ? Math.max(i4 / i2, i5 / i3) : invokeIIII.floatValue;
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding b(int i2, int i3, int i4, int i5) {
            InterceptResult invokeIIII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIIII = interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4, i5)) == null) ? SampleSizeRounding.QUALITY : (SampleSizeRounding) invokeIIII.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class e extends DownsampleStrategy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
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

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public float a(int i2, int i3, int i4, int i5) {
            InterceptResult invokeIIII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048576, this, i2, i3, i4, i5)) == null) ? Math.min(i4 / i2, i5 / i3) : invokeIIII.floatValue;
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding b(int i2, int i3, int i4, int i5) {
            InterceptResult invokeIIII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIIII = interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4, i5)) == null) ? SampleSizeRounding.QUALITY : (SampleSizeRounding) invokeIIII.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class f extends DownsampleStrategy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
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

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public float a(int i2, int i3, int i4, int i5) {
            InterceptResult invokeIIII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048576, this, i2, i3, i4, i5)) == null) {
                return 1.0f;
            }
            return invokeIIII.floatValue;
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding b(int i2, int i3, int i4, int i5) {
            InterceptResult invokeIIII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIIII = interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4, i5)) == null) ? SampleSizeRounding.QUALITY : (SampleSizeRounding) invokeIIII.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(405009273, "Lcom/kwad/sdk/glide/load/resource/bitmap/DownsampleStrategy;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(405009273, "Lcom/kwad/sdk/glide/load/resource/bitmap/DownsampleStrategy;");
                return;
            }
        }
        f38190a = new e();
        f38191b = new d();
        f38192c = new a();
        f38193d = new b();
        f38194e = new c();
        f38195f = new f();
        DownsampleStrategy downsampleStrategy = f38191b;
        f38196g = downsampleStrategy;
        f38197h = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", downsampleStrategy);
    }

    public DownsampleStrategy() {
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

    public abstract float a(int i2, int i3, int i4, int i5);

    public abstract SampleSizeRounding b(int i2, int i3, int i4, int i5);
}
