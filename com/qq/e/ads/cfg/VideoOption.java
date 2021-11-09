package com.qq.e.ads.cfg;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class VideoOption {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f67831a;

    /* renamed from: b  reason: collision with root package name */
    public final int f67832b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f67833c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f67834d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f67835e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f67836f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f67837g;

    /* renamed from: com.qq.e.ads.cfg.VideoOption$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f67838a;

        /* renamed from: b  reason: collision with root package name */
        public int f67839b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f67840c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f67841d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f67842e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f67843f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f67844g;

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
            this.f67838a = true;
            this.f67839b = 1;
            this.f67840c = true;
            this.f67841d = true;
            this.f67842e = true;
            this.f67843f = false;
            this.f67844g = false;
        }

        public VideoOption build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new VideoOption(this, null) : (VideoOption) invokeV.objValue;
        }

        public Builder setAutoPlayMuted(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.f67838a = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setAutoPlayPolicy(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                if (i2 < 0 || i2 > 2) {
                    i2 = 1;
                    GDTLogger.e("setAutoPlayPolicy 设置失败，值只能为0到2之间的数值, 重置为 : 1");
                }
                this.f67839b = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setDetailPageMuted(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.f67844g = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setEnableDetailPage(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.f67842e = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setEnableUserControl(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.f67843f = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setNeedCoverImage(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.f67841d = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setNeedProgressBar(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
                this.f67840c = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }
    }

    @Deprecated
    /* loaded from: classes2.dex */
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
    /* loaded from: classes2.dex */
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
        this.f67831a = builder.f67838a;
        this.f67832b = builder.f67839b;
        this.f67833c = builder.f67840c;
        this.f67834d = builder.f67841d;
        this.f67835e = builder.f67842e;
        this.f67836f = builder.f67843f;
        this.f67837g = builder.f67844g;
    }

    public /* synthetic */ VideoOption(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public boolean getAutoPlayMuted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67831a : invokeV.booleanValue;
    }

    public int getAutoPlayPolicy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f67832b : invokeV.intValue;
    }

    public JSONObject getOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("autoPlayMuted", Boolean.valueOf(this.f67831a));
                jSONObject.putOpt("autoPlayPolicy", Integer.valueOf(this.f67832b));
                jSONObject.putOpt("detailPageMuted", Boolean.valueOf(this.f67837g));
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f67837g : invokeV.booleanValue;
    }

    public boolean isEnableDetailPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f67835e : invokeV.booleanValue;
    }

    public boolean isEnableUserControl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f67836f : invokeV.booleanValue;
    }

    public boolean isNeedCoverImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f67834d : invokeV.booleanValue;
    }

    public boolean isNeedProgressBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f67833c : invokeV.booleanValue;
    }
}
