package com.kwai.player;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class KwaiPlayerConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_LIVE_ADAPTIVE_QOS_TICK_DURATION = 2000;
    public static final int DEFAULT_QOS_TICK_DURATION = 10000;
    public transient /* synthetic */ FieldHolder $fh;
    public int mBufferIncrementStep;
    public int mBufferSmoothTime;
    public EnumBufferStrategy mBufferStrategy;
    public boolean mEnableLiveAdaptiveAdditionalQos;
    public boolean mEnableLiveAdaptiveQos;
    public boolean mEnableQos;
    public int mFirstBufferTime;
    public long mLiveAdaptiveQosDuration;
    public int mMaxBufferDuration;
    public int mMaxBufferTime;
    public int mMinBufferTime;
    public long mQosDuration;

    /* loaded from: classes7.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mBufferIncrementStep;
        public int mBufferSmoothTime;
        public EnumBufferStrategy mBufferStrategy;
        public boolean mEnableLiveAdaptiveAdditionalQos;
        public boolean mEnableLiveAdaptiveQos;
        public boolean mEnableQos;
        public int mFirstBufferTime;
        public long mLiveAdaptiveQosDuration;
        public int mMaxBufferDurMs;
        public int mMaxBufferTime;
        public int mMinBufferTime;
        public long mQosDuration;

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
            this.mEnableQos = false;
            this.mQosDuration = 10000L;
            this.mEnableLiveAdaptiveQos = false;
            this.mEnableLiveAdaptiveAdditionalQos = false;
            this.mLiveAdaptiveQosDuration = 2000L;
            this.mFirstBufferTime = 100;
            this.mMinBufferTime = 100;
            this.mMaxBufferTime = 5000;
            this.mBufferIncrementStep = 100;
            this.mBufferSmoothTime = 20000;
            this.mMaxBufferDurMs = 120000;
            this.mBufferStrategy = EnumBufferStrategy.LINEAR_INCREASE_BUFFER_STRATEGY;
        }

        public KwaiPlayerConfig build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new KwaiPlayerConfig(this) : (KwaiPlayerConfig) invokeV.objValue;
        }

        public Builder setBufferIncrementStep(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                this.mBufferIncrementStep = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setBufferSmoothTime(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                this.mBufferSmoothTime = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setBufferStrategy(EnumBufferStrategy enumBufferStrategy) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, enumBufferStrategy)) == null) {
                this.mBufferStrategy = enumBufferStrategy;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setEnableLiveAdaptiveAdditionalQos(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.mEnableLiveAdaptiveAdditionalQos = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setEnableLiveAdaptiveQos(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.mEnableLiveAdaptiveQos = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setEnableQos(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.mEnableQos = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setFirstBufferTime(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                this.mFirstBufferTime = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setLiveAdaptiveQosDuration(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j)) == null) {
                this.mLiveAdaptiveQosDuration = j;
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        public Builder setMaxBufferDuration(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
                this.mMaxBufferDurMs = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setMaxBufferTime(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
                this.mMaxBufferTime = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setMinBufferTime(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
                this.mMinBufferTime = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setQosDuration(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048588, this, j)) == null) {
                this.mQosDuration = j;
                return this;
            }
            return (Builder) invokeJ.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class EnumBufferStrategy {
        public static final /* synthetic */ EnumBufferStrategy[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final EnumBufferStrategy LINEAR_INCREASE_BUFFER_STRATEGY;
        public static final EnumBufferStrategy LOG_INCREASE_BUFFER_STRATEGY;
        public transient /* synthetic */ FieldHolder $fh;
        public final int value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(529197607, "Lcom/kwai/player/KwaiPlayerConfig$EnumBufferStrategy;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(529197607, "Lcom/kwai/player/KwaiPlayerConfig$EnumBufferStrategy;");
                    return;
                }
            }
            LINEAR_INCREASE_BUFFER_STRATEGY = new EnumBufferStrategy("LINEAR_INCREASE_BUFFER_STRATEGY", 0, 1);
            EnumBufferStrategy enumBufferStrategy = new EnumBufferStrategy("LOG_INCREASE_BUFFER_STRATEGY", 1, 2);
            LOG_INCREASE_BUFFER_STRATEGY = enumBufferStrategy;
            $VALUES = new EnumBufferStrategy[]{LINEAR_INCREASE_BUFFER_STRATEGY, enumBufferStrategy};
        }

        public EnumBufferStrategy(String str, int i2, int i3) {
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
            this.value = i3;
        }

        public static EnumBufferStrategy valueOf(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        return null;
                    }
                    return LOG_INCREASE_BUFFER_STRATEGY;
                }
                return LINEAR_INCREASE_BUFFER_STRATEGY;
            }
            return (EnumBufferStrategy) invokeI.objValue;
        }

        public static EnumBufferStrategy valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (EnumBufferStrategy) Enum.valueOf(EnumBufferStrategy.class, str) : (EnumBufferStrategy) invokeL.objValue;
        }

        public static EnumBufferStrategy[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? (EnumBufferStrategy[]) $VALUES.clone() : (EnumBufferStrategy[]) invokeV.objValue;
        }

        public int getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : invokeV.intValue;
        }
    }

    public KwaiPlayerConfig(Builder builder) {
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
        this.mEnableQos = builder.mEnableQos;
        this.mQosDuration = builder.mQosDuration;
        this.mEnableLiveAdaptiveQos = builder.mEnableLiveAdaptiveQos;
        this.mEnableLiveAdaptiveAdditionalQos = builder.mEnableLiveAdaptiveAdditionalQos;
        this.mLiveAdaptiveQosDuration = builder.mLiveAdaptiveQosDuration;
        this.mBufferIncrementStep = builder.mBufferIncrementStep;
        this.mBufferSmoothTime = builder.mBufferSmoothTime;
        this.mFirstBufferTime = builder.mFirstBufferTime;
        this.mMinBufferTime = builder.mMinBufferTime;
        this.mMaxBufferTime = builder.mMaxBufferTime;
        this.mBufferStrategy = builder.mBufferStrategy;
        this.mMaxBufferDuration = builder.mMaxBufferDurMs;
    }

    public int getBufferIncrementStep() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mBufferIncrementStep : invokeV.intValue;
    }

    public int getBufferSmoothTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mBufferSmoothTime : invokeV.intValue;
    }

    public EnumBufferStrategy getBufferStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mBufferStrategy : (EnumBufferStrategy) invokeV.objValue;
    }

    public boolean getEnableLiveAdaptiveAdditionalQos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mEnableLiveAdaptiveAdditionalQos : invokeV.booleanValue;
    }

    public boolean getEnableLiveAdaptiveQos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mEnableLiveAdaptiveQos : invokeV.booleanValue;
    }

    public boolean getEnableQos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mEnableQos : invokeV.booleanValue;
    }

    public int getFirstBufferTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mFirstBufferTime : invokeV.intValue;
    }

    public long getLiveAdaptiveQosDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mLiveAdaptiveQosDuration : invokeV.longValue;
    }

    public int getMaxBufferDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mMaxBufferDuration : invokeV.intValue;
    }

    public int getMaxBufferTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mMaxBufferTime : invokeV.intValue;
    }

    public int getMinBufferTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mMinBufferTime : invokeV.intValue;
    }

    public long getQosDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mQosDuration : invokeV.longValue;
    }
}
