package com.xiaomi.clientreport.data;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.bq;
/* loaded from: classes7.dex */
public class Config {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEFAULT_EVENT_ENCRYPTED = true;
    public static final long DEFAULT_EVENT_UPLOAD_FREQUENCY = 86400;
    public static final boolean DEFAULT_EVENT_UPLOAD_SWITCH_OPEN = false;
    public static final long DEFAULT_MAX_FILE_LENGTH = 1048576;
    public static final long DEFAULT_PERF_UPLOAD_FREQUENCY = 86400;
    public static final boolean DEFAULT_PERF_UPLOAD_SWITCH_OPEN = false;
    public transient /* synthetic */ FieldHolder $fh;
    public String mAESKey;
    public boolean mEventEncrypted;
    public long mEventUploadFrequency;
    public boolean mEventUploadSwitchOpen;
    public long mMaxFileLength;
    public long mPerfUploadFrequency;
    public boolean mPerfUploadSwitchOpen;

    /* loaded from: classes7.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String mAESKey;
        public int mEventEncrypted;
        public long mEventUploadFrequency;
        public int mEventUploadSwitchOpen;
        public long mMaxFileLength;
        public long mPerfUploadFrequency;
        public int mPerfUploadSwitchOpen;

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
            this.mEventEncrypted = -1;
            this.mEventUploadSwitchOpen = -1;
            this.mPerfUploadSwitchOpen = -1;
            this.mAESKey = null;
            this.mMaxFileLength = -1L;
            this.mEventUploadFrequency = -1L;
            this.mPerfUploadFrequency = -1L;
        }

        public Config build(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? new Config(context, this, null) : (Config) invokeL.objValue;
        }

        public Builder setAESKey(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.mAESKey = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setEventEncrypted(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.mEventEncrypted = z ? 1 : 0;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setEventUploadFrequency(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
                this.mEventUploadFrequency = j;
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        public Builder setEventUploadSwitchOpen(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.mEventUploadSwitchOpen = z ? 1 : 0;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setMaxFileLength(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
                this.mMaxFileLength = j;
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        public Builder setPerfUploadFrequency(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
                this.mPerfUploadFrequency = j;
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        public Builder setPerfUploadSwitchOpen(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
                this.mPerfUploadSwitchOpen = z ? 1 : 0;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }
    }

    public Config() {
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
        this.mEventEncrypted = true;
        this.mEventUploadSwitchOpen = false;
        this.mPerfUploadSwitchOpen = false;
        this.mMaxFileLength = 1048576L;
        this.mEventUploadFrequency = 86400L;
        this.mPerfUploadFrequency = 86400L;
    }

    public Config(Context context, Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, builder};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mEventEncrypted = true;
        this.mEventUploadSwitchOpen = false;
        this.mPerfUploadSwitchOpen = false;
        this.mMaxFileLength = 1048576L;
        this.mEventUploadFrequency = 86400L;
        this.mPerfUploadFrequency = 86400L;
        if (builder.mEventEncrypted == 0) {
            this.mEventEncrypted = false;
        } else {
            int unused = builder.mEventEncrypted;
            this.mEventEncrypted = true;
        }
        this.mAESKey = !TextUtils.isEmpty(builder.mAESKey) ? builder.mAESKey : bq.a(context);
        this.mMaxFileLength = builder.mMaxFileLength > -1 ? builder.mMaxFileLength : 1048576L;
        if (builder.mEventUploadFrequency > -1) {
            this.mEventUploadFrequency = builder.mEventUploadFrequency;
        } else {
            this.mEventUploadFrequency = 86400L;
        }
        if (builder.mPerfUploadFrequency > -1) {
            this.mPerfUploadFrequency = builder.mPerfUploadFrequency;
        } else {
            this.mPerfUploadFrequency = 86400L;
        }
        if (builder.mEventUploadSwitchOpen != 0 && builder.mEventUploadSwitchOpen == 1) {
            this.mEventUploadSwitchOpen = true;
        } else {
            this.mEventUploadSwitchOpen = false;
        }
        if (builder.mPerfUploadSwitchOpen != 0 && builder.mPerfUploadSwitchOpen == 1) {
            this.mPerfUploadSwitchOpen = true;
        } else {
            this.mPerfUploadSwitchOpen = false;
        }
    }

    public /* synthetic */ Config(Context context, Builder builder, b bVar) {
        this(context, builder);
    }

    public static Config defaultConfig(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? getBuilder().setEventEncrypted(true).setAESKey(bq.a(context)).setMaxFileLength(1048576L).setEventUploadSwitchOpen(false).setEventUploadFrequency(86400L).setPerfUploadSwitchOpen(false).setPerfUploadFrequency(86400L).build(context) : (Config) invokeL.objValue;
    }

    public static Builder getBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? new Builder() : (Builder) invokeV.objValue;
    }

    public long getEventUploadFrequency() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mEventUploadFrequency : invokeV.longValue;
    }

    public long getMaxFileLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mMaxFileLength : invokeV.longValue;
    }

    public long getPerfUploadFrequency() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mPerfUploadFrequency : invokeV.longValue;
    }

    public boolean isEventEncrypted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mEventEncrypted : invokeV.booleanValue;
    }

    public boolean isEventUploadSwitchOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mEventUploadSwitchOpen : invokeV.booleanValue;
    }

    public boolean isPerfUploadSwitchOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mPerfUploadSwitchOpen : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return "Config{mEventEncrypted=" + this.mEventEncrypted + ", mAESKey='" + this.mAESKey + "', mMaxFileLength=" + this.mMaxFileLength + ", mEventUploadSwitchOpen=" + this.mEventUploadSwitchOpen + ", mPerfUploadSwitchOpen=" + this.mPerfUploadSwitchOpen + ", mEventUploadFrequency=" + this.mEventUploadFrequency + ", mPerfUploadFrequency=" + this.mPerfUploadFrequency + '}';
        }
        return (String) invokeV.objValue;
    }
}
