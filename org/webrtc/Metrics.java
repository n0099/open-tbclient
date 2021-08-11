package org.webrtc;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class Metrics {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "Metrics";
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, HistogramInfo> map;

    /* loaded from: classes2.dex */
    public static class HistogramInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int bucketCount;
        public final int max;
        public final int min;
        public final Map<Integer, Integer> samples;

        @CalledByNative("HistogramInfo")
        public HistogramInfo(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.samples = new HashMap();
            this.min = i2;
            this.max = i3;
            this.bucketCount = i4;
        }

        @CalledByNative("HistogramInfo")
        public void addSample(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.samples.put(Integer.valueOf(i2), Integer.valueOf(i3));
            }
        }
    }

    @CalledByNative
    public Metrics() {
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
        this.map = new HashMap();
    }

    @CalledByNative
    private void add(String str, HistogramInfo histogramInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, str, histogramInfo) == null) {
            this.map.put(str, histogramInfo);
        }
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? nativeGetAndReset() : (Metrics) invokeV.objValue;
    }

    public static native void nativeEnable();

    public static native Metrics nativeGetAndReset();
}
