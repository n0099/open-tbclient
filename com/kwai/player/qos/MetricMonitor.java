package com.kwai.player.qos;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class MetricMonitor {
    public static /* synthetic */ Interceptable $ic = null;
    public static String[] AUDIO_BUFFER_LEN_FIELDS = null;
    public static int[] AUDIO_BUFFER_LEN_SCALE = null;
    public static final String TAG = "MetricMonitor";
    public static final boolean VERBOSE = false;
    public static String[] VIDEO_BUFFER_LEN_FIELDS;
    public static int[] VIDEO_BUFFER_LEN_SCALE;
    public transient /* synthetic */ FieldHolder $fh;
    public long[] audioBufferLenMetric;
    public AppLiveReatimeInfoProvider mRealtimeInfoProvider;
    public long[] videoBufferLenMetric;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1156954856, "Lcom/kwai/player/qos/MetricMonitor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1156954856, "Lcom/kwai/player/qos/MetricMonitor;");
                return;
            }
        }
        AUDIO_BUFFER_LEN_FIELDS = new String[]{"0~2", "2~4", "4~5", "5+"};
        AUDIO_BUFFER_LEN_SCALE = new int[]{0, 2000, 4000, 5000};
        VIDEO_BUFFER_LEN_FIELDS = new String[]{"0~2", "2~4", "4~5", "5+"};
        VIDEO_BUFFER_LEN_SCALE = new int[]{0, 2000, 4000, 5000};
    }

    public MetricMonitor(AppLiveReatimeInfoProvider appLiveReatimeInfoProvider) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {appLiveReatimeInfoProvider};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.audioBufferLenMetric = new long[AUDIO_BUFFER_LEN_FIELDS.length];
        this.videoBufferLenMetric = new long[VIDEO_BUFFER_LEN_FIELDS.length];
        this.mRealtimeInfoProvider = appLiveReatimeInfoProvider;
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (int i2 = 0; i2 < VIDEO_BUFFER_LEN_SCALE.length; i2++) {
                this.videoBufferLenMetric[i2] = 0;
            }
            for (int i3 = 0; i3 < AUDIO_BUFFER_LEN_SCALE.length; i3++) {
                this.audioBufferLenMetric[i3] = 0;
            }
        }
    }

    public JSONObject getAudioBufferLenMetric() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            for (int i2 = 0; i2 < this.audioBufferLenMetric.length; i2++) {
                try {
                    jSONObject.put(AUDIO_BUFFER_LEN_FIELDS[i2], (int) this.audioBufferLenMetric[i2]);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public JSONObject getVideoBufferLenMetric() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            for (int i2 = 0; i2 < this.videoBufferLenMetric.length; i2++) {
                try {
                    jSONObject.put(VIDEO_BUFFER_LEN_FIELDS[i2], (int) this.videoBufferLenMetric[i2]);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public void recordAudioBufferLenStat(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeJ(1048579, this, j) != null) {
            return;
        }
        long audioCachedDuration = this.mRealtimeInfoProvider.getAudioCachedDuration();
        int i2 = 0;
        while (true) {
            int[] iArr = AUDIO_BUFFER_LEN_SCALE;
            if (i2 >= iArr.length) {
                return;
            }
            if (audioCachedDuration >= iArr[i2]) {
                if (i2 == iArr.length - 1) {
                    long[] jArr = this.audioBufferLenMetric;
                    jArr[i2] = jArr[i2] + j;
                    return;
                } else if (audioCachedDuration < iArr[i2 + 1]) {
                    long[] jArr2 = this.audioBufferLenMetric;
                    jArr2[i2] = jArr2[i2] + j;
                    return;
                }
            }
            i2++;
        }
    }

    public void recordVideoBufferLenStat(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeJ(1048580, this, j) != null) {
            return;
        }
        long videoCachedDuration = this.mRealtimeInfoProvider.getVideoCachedDuration();
        int i2 = 0;
        while (true) {
            int[] iArr = VIDEO_BUFFER_LEN_SCALE;
            if (i2 >= iArr.length) {
                return;
            }
            if (videoCachedDuration >= iArr[i2]) {
                if (i2 == iArr.length - 1) {
                    long[] jArr = this.videoBufferLenMetric;
                    jArr[i2] = jArr[i2] + j;
                    return;
                } else if (videoCachedDuration < iArr[i2 + 1]) {
                    long[] jArr2 = this.videoBufferLenMetric;
                    jArr2[i2] = jArr2[i2] + j;
                    return;
                }
            }
            i2++;
        }
    }

    public void sample(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            recordAudioBufferLenStat(j);
            recordVideoBufferLenStat(j);
        }
    }
}
