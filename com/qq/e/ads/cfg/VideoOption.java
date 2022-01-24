package com.qq.e.ads.cfg;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class VideoOption {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public final int f58997b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f58998c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f58999d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f59000e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f59001f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f59002g;

    /* renamed from: com.qq.e.ads.cfg.VideoOption$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public int f59003b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f59004c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f59005d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f59006e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f59007f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f59008g;

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
            this.a = true;
            this.f59003b = 1;
            this.f59004c = true;
            this.f59005d = true;
            this.f59006e = true;
            this.f59007f = false;
            this.f59008g = false;
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
                this.a = z;
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
                this.f59003b = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setDetailPageMuted(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.f59008g = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setEnableDetailPage(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.f59006e = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setEnableUserControl(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.f59007f = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setNeedCoverImage(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.f59005d = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setNeedProgressBar(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
                this.f59004c = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }
    }

    @Deprecated
    /* loaded from: classes4.dex */
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
    /* loaded from: classes4.dex */
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
        this.a = builder.a;
        this.f58997b = builder.f59003b;
        this.f58998c = builder.f59004c;
        this.f58999d = builder.f59005d;
        this.f59000e = builder.f59006e;
        this.f59001f = builder.f59007f;
        this.f59002g = builder.f59008g;
    }

    public /* synthetic */ VideoOption(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public boolean getAutoPlayMuted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.booleanValue;
    }

    public int getAutoPlayPolicy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f58997b : invokeV.intValue;
    }

    public JSONObject getOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("autoPlayMuted", Boolean.valueOf(this.a));
                jSONObject.putOpt("autoPlayPolicy", Integer.valueOf(this.f58997b));
                jSONObject.putOpt("detailPageMuted", Boolean.valueOf(this.f59002g));
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f59002g : invokeV.booleanValue;
    }

    public boolean isEnableDetailPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f59000e : invokeV.booleanValue;
    }

    public boolean isEnableUserControl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f59001f : invokeV.booleanValue;
    }

    public boolean isNeedCoverImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f58999d : invokeV.booleanValue;
    }

    public boolean isNeedProgressBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f58998c : invokeV.booleanValue;
    }
}
