package okhttp3.internal.http2;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes8.dex */
public final class Settings {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int COUNT = 10;
    public static final int DEFAULT_INITIAL_WINDOW_SIZE = 65535;
    public static final int ENABLE_PUSH = 2;
    public static final int HEADER_TABLE_SIZE = 1;
    public static final int INITIAL_WINDOW_SIZE = 7;
    public static final int MAX_CONCURRENT_STREAMS = 4;
    public static final int MAX_FRAME_SIZE = 5;
    public static final int MAX_HEADER_LIST_SIZE = 6;
    public transient /* synthetic */ FieldHolder $fh;
    public int set;
    public final int[] values;

    public Settings() {
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
        this.values = new int[10];
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.set = 0;
            Arrays.fill(this.values, 0);
        }
    }

    public int get(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? this.values[i] : invokeI.intValue;
    }

    public boolean getEnablePush(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            return ((this.set & 4) != 0 ? this.values[2] : z ? 1 : 0) == 1;
        }
        return invokeZ.booleanValue;
    }

    public int getHeaderTableSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if ((this.set & 2) != 0) {
                return this.values[1];
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public int getInitialWindowSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if ((this.set & 128) != 0) {
                return this.values[7];
            }
            return 65535;
        }
        return invokeV.intValue;
    }

    public int getMaxConcurrentStreams(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? (this.set & 16) != 0 ? this.values[4] : i : invokeI.intValue;
    }

    public int getMaxFrameSize(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? (this.set & 32) != 0 ? this.values[5] : i : invokeI.intValue;
    }

    public int getMaxHeaderListSize(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) ? (this.set & 64) != 0 ? this.values[6] : i : invokeI.intValue;
    }

    public boolean isSet(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) ? ((1 << i) & this.set) != 0 : invokeI.booleanValue;
    }

    public void merge(Settings settings) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, settings) == null) {
            for (int i = 0; i < 10; i++) {
                if (settings.isSet(i)) {
                    set(i, settings.get(i));
                }
            }
        }
    }

    public Settings set(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048586, this, i, i2)) == null) {
            if (i >= 0) {
                int[] iArr = this.values;
                if (i < iArr.length) {
                    this.set = (1 << i) | this.set;
                    iArr[i] = i2;
                }
            }
            return this;
        }
        return (Settings) invokeII.objValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? Integer.bitCount(this.set) : invokeV.intValue;
    }
}
