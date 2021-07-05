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
/* loaded from: classes7.dex */
public class VideoOption2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AutoPlayPolicy f40840a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f40841b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f40842c;

    /* renamed from: d  reason: collision with root package name */
    public int f40843d;

    /* renamed from: e  reason: collision with root package name */
    public int f40844e;

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
        public static final /* synthetic */ AutoPlayPolicy[] f40845b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f40846a;

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
            f40845b = new AutoPlayPolicy[]{WIFI, ALWAYS, autoPlayPolicy};
        }

        public AutoPlayPolicy(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f40846a = i3;
        }

        public static AutoPlayPolicy valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (AutoPlayPolicy) Enum.valueOf(AutoPlayPolicy.class, str) : (AutoPlayPolicy) invokeL.objValue;
        }

        public static AutoPlayPolicy[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (AutoPlayPolicy[]) f40845b.clone() : (AutoPlayPolicy[]) invokeV.objValue;
        }

        public final int getPolicy() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f40846a : invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public AutoPlayPolicy f40847a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f40848b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f40849c;

        /* renamed from: d  reason: collision with root package name */
        public int f40850d;

        /* renamed from: e  reason: collision with root package name */
        public int f40851e;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40847a = AutoPlayPolicy.WIFI;
            this.f40848b = true;
            this.f40849c = false;
        }

        public VideoOption2 build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new VideoOption2(this, (byte) 0) : (VideoOption2) invokeV.objValue;
        }

        public Builder setAutoPlayMuted(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.f40848b = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setAutoPlayPolicy(AutoPlayPolicy autoPlayPolicy) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, autoPlayPolicy)) == null) {
                if (autoPlayPolicy != null) {
                    this.f40847a = autoPlayPolicy;
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setDetailPageMuted(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.f40849c = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setMaxVideoDuration(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                this.f40850d = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setMinVideoDuration(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                this.f40851e = i2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f40840a = builder.f40847a;
        this.f40841b = builder.f40848b;
        this.f40842c = builder.f40849c;
        this.f40843d = builder.f40850d;
        this.f40844e = builder.f40851e;
    }

    public /* synthetic */ VideoOption2(Builder builder, byte b2) {
        this(builder);
    }

    public AutoPlayPolicy getAutoPlayPolicy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f40840a : (AutoPlayPolicy) invokeV.objValue;
    }

    public int getMaxVideoDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f40843d : invokeV.intValue;
    }

    public int getMinVideoDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f40844e : invokeV.intValue;
    }

    public boolean isAutoPlayMuted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f40841b : invokeV.booleanValue;
    }

    public boolean isDetailPageMuted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f40842c : invokeV.booleanValue;
    }
}
