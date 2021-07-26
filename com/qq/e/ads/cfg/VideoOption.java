package com.qq.e.ads.cfg;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class VideoOption {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f37910a;

    /* renamed from: b  reason: collision with root package name */
    public final int f37911b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f37912c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f37913d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f37914e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f37915f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f37916g;

    /* renamed from: com.qq.e.ads.cfg.VideoOption$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f37917a;

        /* renamed from: b  reason: collision with root package name */
        public int f37918b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f37919c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f37920d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f37921e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f37922f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f37923g;

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
            this.f37917a = true;
            this.f37918b = 1;
            this.f37919c = true;
            this.f37920d = true;
            this.f37921e = true;
            this.f37922f = false;
            this.f37923g = false;
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
                this.f37917a = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public final Builder setAutoPlayPolicy(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                if (i2 < 0 || i2 > 2) {
                    GDTLogger.e("invalid value of autoPlayPolicy, can only be [0, 2], reset to : 1");
                    i2 = 1;
                }
                this.f37918b = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public final Builder setDetailPageMuted(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.f37923g = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public final Builder setEnableDetailPage(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.f37921e = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public final Builder setEnableUserControl(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.f37922f = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public final Builder setNeedCoverImage(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.f37920d = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public final Builder setNeedProgressBar(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
                this.f37919c = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }
    }

    @Deprecated
    /* loaded from: classes6.dex */
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
    /* loaded from: classes6.dex */
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
        this.f37910a = builder.f37917a;
        this.f37911b = builder.f37918b;
        this.f37912c = builder.f37919c;
        this.f37913d = builder.f37920d;
        this.f37914e = builder.f37921e;
        this.f37915f = builder.f37922f;
        this.f37916g = builder.f37923g;
    }

    public /* synthetic */ VideoOption(Builder builder, byte b2) {
        this(builder);
    }

    public boolean getAutoPlayMuted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f37910a : invokeV.booleanValue;
    }

    public int getAutoPlayPolicy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f37911b : invokeV.intValue;
    }

    public JSONObject getOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("autoPlayMuted", Boolean.valueOf(this.f37910a));
                jSONObject.putOpt("autoPlayPolicy", Integer.valueOf(this.f37911b));
                jSONObject.putOpt("detailPageMuted", Boolean.valueOf(this.f37916g));
            } catch (Exception e2) {
                GDTLogger.e("Get video options error: " + e2.getMessage());
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public boolean isDetailPageMuted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f37916g : invokeV.booleanValue;
    }

    public boolean isEnableDetailPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f37914e : invokeV.booleanValue;
    }

    public boolean isEnableUserControl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f37915f : invokeV.booleanValue;
    }

    public boolean isNeedCoverImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f37913d : invokeV.booleanValue;
    }

    public boolean isNeedProgressBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f37912c : invokeV.booleanValue;
    }
}
