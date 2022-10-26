package org.webrtc;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class Metrics {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "Metrics";
    public transient /* synthetic */ FieldHolder $fh;
    public final Map map;

    public static native void nativeEnable();

    public static native Metrics nativeGetAndReset();

    /* loaded from: classes8.dex */
    public class HistogramInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int bucketCount;
        public final int max;
        public final int min;
        public final Map samples;

        public HistogramInfo(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.samples = new HashMap();
            this.min = i;
            this.max = i2;
            this.bucketCount = i3;
        }

        public void addSample(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                this.samples.put(Integer.valueOf(i), Integer.valueOf(i2));
            }
        }
    }

    public Metrics() {
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
        this.map = new HashMap();
    }

    public static void enable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            nativeEnable();
        }
    }

    public static Metrics getAndReset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return nativeGetAndReset();
        }
        return (Metrics) invokeV.objValue;
    }

    private void add(String str, HistogramInfo histogramInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, str, histogramInfo) == null) {
            this.map.put(str, histogramInfo);
        }
    }
}
