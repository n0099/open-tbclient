package com.qq.e.ads.nativ.express2;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Deprecated
/* loaded from: classes7.dex */
public class VideoOption2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AutoPlayPolicy a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f42371b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f42372c;

    /* renamed from: d  reason: collision with root package name */
    public int f42373d;

    /* renamed from: e  reason: collision with root package name */
    public int f42374e;

    /* renamed from: com.qq.e.ads.nativ.express2.VideoOption2$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class AutoPlayPolicy {
        public static /* synthetic */ Interceptable $ic;
        public static final AutoPlayPolicy ALWAYS;
        public static final AutoPlayPolicy NEVER;
        public static final AutoPlayPolicy WIFI;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ AutoPlayPolicy[] f42375b;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(291810642, "Lcom/qq/e/ads/nativ/express2/VideoOption2$AutoPlayPolicy;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(291810642, "Lcom/qq/e/ads/nativ/express2/VideoOption2$AutoPlayPolicy;");
                    return;
                }
            }
            WIFI = new AutoPlayPolicy(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, 0, 0);
            ALWAYS = new AutoPlayPolicy("ALWAYS", 1, 1);
            AutoPlayPolicy autoPlayPolicy = new AutoPlayPolicy("NEVER", 2, 2);
            NEVER = autoPlayPolicy;
            f42375b = new AutoPlayPolicy[]{WIFI, ALWAYS, autoPlayPolicy};
        }

        public AutoPlayPolicy(String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = i2;
        }

        public static AutoPlayPolicy valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (AutoPlayPolicy) Enum.valueOf(AutoPlayPolicy.class, str) : (AutoPlayPolicy) invokeL.objValue;
        }

        public static AutoPlayPolicy[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (AutoPlayPolicy[]) f42375b.clone() : (AutoPlayPolicy[]) invokeV.objValue;
        }

        public int getPolicy() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AutoPlayPolicy a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f42376b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f42377c;

        /* renamed from: d  reason: collision with root package name */
        public int f42378d;

        /* renamed from: e  reason: collision with root package name */
        public int f42379e;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = AutoPlayPolicy.WIFI;
            this.f42376b = true;
            this.f42377c = false;
        }

        public VideoOption2 build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new VideoOption2(this, null) : (VideoOption2) invokeV.objValue;
        }

        public Builder setAutoPlayMuted(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.f42376b = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setAutoPlayPolicy(AutoPlayPolicy autoPlayPolicy) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, autoPlayPolicy)) == null) {
                if (autoPlayPolicy != null) {
                    this.a = autoPlayPolicy;
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setDetailPageMuted(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.f42377c = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setMaxVideoDuration(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                this.f42378d = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setMinVideoDuration(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                this.f42379e = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }
    }

    public VideoOption2(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = builder.a;
        this.f42371b = builder.f42376b;
        this.f42372c = builder.f42377c;
        this.f42373d = builder.f42378d;
        this.f42374e = builder.f42379e;
    }

    public /* synthetic */ VideoOption2(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public AutoPlayPolicy getAutoPlayPolicy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (AutoPlayPolicy) invokeV.objValue;
    }

    public int getMaxVideoDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f42373d : invokeV.intValue;
    }

    public int getMinVideoDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f42374e : invokeV.intValue;
    }

    public boolean isAutoPlayMuted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f42371b : invokeV.booleanValue;
    }

    public boolean isDetailPageMuted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f42372c : invokeV.booleanValue;
    }
}
