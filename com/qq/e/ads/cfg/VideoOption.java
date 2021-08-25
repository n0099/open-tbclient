package com.qq.e.ads.cfg;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class VideoOption {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f74948a;

    /* renamed from: b  reason: collision with root package name */
    public final int f74949b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f74950c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f74951d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f74952e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f74953f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f74954g;

    /* renamed from: com.qq.e.ads.cfg.VideoOption$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public static final class AutoPlayPolicy {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ALWAYS = 1;
        public static final int NEVER = 2;
        public static final int WIFI = 0;
        public transient /* synthetic */ FieldHolder $fh;

        public AutoPlayPolicy() {
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
    }

    /* loaded from: classes10.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f74955a;

        /* renamed from: b  reason: collision with root package name */
        public int f74956b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f74957c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f74958d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f74959e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f74960f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f74961g;

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
            this.f74955a = true;
            this.f74956b = 1;
            this.f74957c = true;
            this.f74958d = true;
            this.f74959e = true;
            this.f74960f = false;
            this.f74961g = false;
        }

        public final VideoOption build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new VideoOption(this, (byte) 0) : (VideoOption) invokeV.objValue;
        }

        public final Builder setAutoPlayMuted(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.f74955a = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public final Builder setAutoPlayPolicy(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                if (i2 < 0 || i2 > 2) {
                    GDTLogger.e("setAutoPlayPolicy 设置失败，值只能为0到2之间的数值, 重置为 : 1");
                    i2 = 1;
                }
                this.f74956b = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public final Builder setDetailPageMuted(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.f74961g = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public final Builder setEnableDetailPage(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.f74959e = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public final Builder setEnableUserControl(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.f74960f = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public final Builder setNeedCoverImage(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.f74958d = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public final Builder setNeedProgressBar(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
                this.f74957c = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }
    }

    @Deprecated
    /* loaded from: classes10.dex */
    public static final class VideoADContainerRender {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int DEV = 2;
        public static final int SDK = 1;
        public static final int UNKNOWN = 0;
        public transient /* synthetic */ FieldHolder $fh;

        public VideoADContainerRender() {
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
    }

    @Deprecated
    /* loaded from: classes10.dex */
    public static final class VideoPlayPolicy {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int AUTO = 1;
        public static final int MANUAL = 2;
        public static final int UNKNOWN = 0;
        public transient /* synthetic */ FieldHolder $fh;

        public VideoPlayPolicy() {
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
    }

    public VideoOption(Builder builder) {
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
        this.f74948a = builder.f74955a;
        this.f74949b = builder.f74956b;
        this.f74950c = builder.f74957c;
        this.f74951d = builder.f74958d;
        this.f74952e = builder.f74959e;
        this.f74953f = builder.f74960f;
        this.f74954g = builder.f74961g;
    }

    public /* synthetic */ VideoOption(Builder builder, byte b2) {
        this(builder);
    }

    public boolean getAutoPlayMuted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f74948a : invokeV.booleanValue;
    }

    public int getAutoPlayPolicy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f74949b : invokeV.intValue;
    }

    public JSONObject getOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("autoPlayMuted", Boolean.valueOf(this.f74948a));
                jSONObject.putOpt("autoPlayPolicy", Integer.valueOf(this.f74949b));
                jSONObject.putOpt("detailPageMuted", Boolean.valueOf(this.f74954g));
            } catch (Exception e2) {
                GDTLogger.d("Get video options error: " + e2.getMessage());
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public boolean isDetailPageMuted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f74954g : invokeV.booleanValue;
    }

    public boolean isEnableDetailPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f74952e : invokeV.booleanValue;
    }

    public boolean isEnableUserControl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f74953f : invokeV.booleanValue;
    }

    public boolean isNeedCoverImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f74951d : invokeV.booleanValue;
    }

    public boolean isNeedProgressBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f74950c : invokeV.booleanValue;
    }
}
