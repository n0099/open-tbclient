package okhttp3.internal.connection;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes9.dex */
public class PreConnectParams {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mPreConnectDelayTimeMs;
    public List<String> mPreConnectDelayUrlsWithNum;
    public boolean mPreConnectEnabled;
    public List<String> mPreConnectNoDelayUrlsWithNum;
    public int mPreConnectPeriodTimeMs;
    public List<String> mPreConnectUrlsAllowlist;
    public int maxPreConnectNum;
    public int maxSingleHostPreConnectNum;

    /* loaded from: classes9.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mPreConnectDelayTimeMs;
        public boolean mPreConnectEnabled;
        public List<String> mPreConnectNoDelayUrlsWithNum;
        public int mPreConnectPeriodTimeMs;
        public List<String> mPreConnectUrlsAllowlist;
        public List<String> mPreConnectUrlsWithNum;
        public int maxPreConnectNum;
        public int maxSingleHostPreConnectNum;

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
            this.mPreConnectEnabled = false;
            this.maxPreConnectNum = -1;
            this.maxSingleHostPreConnectNum = -1;
            this.mPreConnectDelayTimeMs = -1;
            this.mPreConnectPeriodTimeMs = -1;
            this.mPreConnectUrlsAllowlist = null;
            this.mPreConnectUrlsWithNum = null;
            this.mPreConnectNoDelayUrlsWithNum = null;
        }

        public Builder setMaxPreConnectNum(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                this.maxPreConnectNum = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setMaxSingleHostPreConnectNum(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                this.maxSingleHostPreConnectNum = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setPreConnectDelayTimeMs(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                this.mPreConnectDelayTimeMs = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setPreConnectDelayUrlsWithNum(List<String> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
                this.mPreConnectUrlsWithNum = list;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setPreConnectEnabled(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.mPreConnectEnabled = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setPreConnectNoDelayUrlsWithNum(List<String> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
                this.mPreConnectNoDelayUrlsWithNum = list;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setPreConnectPeriodTimeMs(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
                this.mPreConnectPeriodTimeMs = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setPreConnectUrlsAllowlist(List<String> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list)) == null) {
                this.mPreConnectUrlsAllowlist = list;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public PreConnectParams build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new PreConnectParams(this);
            }
            return (PreConnectParams) invokeV.objValue;
        }
    }

    public PreConnectParams(Builder builder) {
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
        this.mPreConnectEnabled = false;
        this.maxPreConnectNum = -1;
        this.maxSingleHostPreConnectNum = -1;
        this.mPreConnectDelayTimeMs = -1;
        this.mPreConnectPeriodTimeMs = -1;
        this.mPreConnectUrlsAllowlist = null;
        this.mPreConnectDelayUrlsWithNum = null;
        this.mPreConnectNoDelayUrlsWithNum = null;
        this.mPreConnectEnabled = builder.mPreConnectEnabled;
        this.maxPreConnectNum = builder.maxPreConnectNum;
        this.maxSingleHostPreConnectNum = builder.maxSingleHostPreConnectNum;
        this.mPreConnectDelayTimeMs = builder.mPreConnectDelayTimeMs;
        this.mPreConnectPeriodTimeMs = builder.mPreConnectPeriodTimeMs;
        this.mPreConnectUrlsAllowlist = builder.mPreConnectUrlsAllowlist;
        this.mPreConnectDelayUrlsWithNum = builder.mPreConnectUrlsWithNum;
        this.mPreConnectNoDelayUrlsWithNum = builder.mPreConnectNoDelayUrlsWithNum;
    }

    public int getMaxPreConnectNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.maxPreConnectNum;
        }
        return invokeV.intValue;
    }

    public int getMaxSingleHostPreConnectNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.maxSingleHostPreConnectNum;
        }
        return invokeV.intValue;
    }

    public int getPreConnectDelayTimeMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mPreConnectDelayTimeMs;
        }
        return invokeV.intValue;
    }

    public List<String> getPreConnectDelayUrlsWithNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mPreConnectDelayUrlsWithNum;
        }
        return (List) invokeV.objValue;
    }

    public boolean getPreConnectEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mPreConnectEnabled;
        }
        return invokeV.booleanValue;
    }

    public List<String> getPreConnectNoDelayUrlsWithNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mPreConnectNoDelayUrlsWithNum;
        }
        return (List) invokeV.objValue;
    }

    public int getPreConnectPeriodTimeMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mPreConnectPeriodTimeMs;
        }
        return invokeV.intValue;
    }

    public List<String> getPreConnectUrlsAllowlist() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mPreConnectUrlsAllowlist;
        }
        return (List) invokeV.objValue;
    }
}
