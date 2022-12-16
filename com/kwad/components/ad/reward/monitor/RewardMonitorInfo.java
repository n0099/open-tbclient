package com.kwad.components.ad.reward.monitor;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.r;
import java.io.Serializable;
import org.json.JSONObject;
@KsJson
/* loaded from: classes8.dex */
public class RewardMonitorInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DOWNLOAD_TYPE_ALL = 2;
    public static final int DOWNLOAD_TYPE_ONLINE = 1;
    public static final int DOWNLOAD_TYPE_PART = 3;
    public static final int LOAD_STATUS_DATA_FINISH = 2;
    public static final int LOAD_STATUS_FAIL = 4;
    public static final int LOAD_STATUS_LOAD_FINISH = 3;
    public static final int LOAD_STATUS_START = 1;
    public static final int LOAD_TYPE_LOCAL = 2;
    public static final int LOAD_TYPE_NET = 1;
    public static final int PAGE_STATUS_ENTRY = 1;
    public static final int PAGE_STATUS_SHOW = 2;
    public static final int PAGE_STATUS_SHOW_AD_CALL = 3;
    public static final int REWARD_TYPE_DEEP = 1;
    public static final int REWARD_TYPE_NORMAL = 0;
    public static final long serialVersionUID = 1080394611500009098L;
    public transient /* synthetic */ FieldHolder $fh;
    public int adCount;
    public long creativeId;
    public long currentDuration;
    public long dataDownloadInterval;
    public long dataLoadInterval;
    public long downloadDuration;
    public long downloadSize;
    public int downloadType;
    public int errorCode;
    public String errorMsg;
    public long loadDataDuration;
    public int loadStatus;
    public int loadType;
    public int pageStatus;
    public double ratioCount;
    public long renderDuration;
    public int rewardType;
    public int taskStep;
    public int taskType;
    public long totalDuration;
    public long videoDuration;
    public String videoUrl;

    public RewardMonitorInfo() {
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
        this.rewardType = -1;
        this.taskType = -1;
        this.taskStep = -1;
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterToJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            super.afterToJson(jSONObject);
            int i = this.rewardType;
            if (i != -1) {
                r.putValue(jSONObject, "reward_type", i);
            } else {
                jSONObject.remove("reward_type");
            }
            int i2 = this.taskType;
            if (i2 != -1) {
                r.putValue(jSONObject, "task_type", i2);
            } else {
                jSONObject.remove("task_type");
            }
            int i3 = this.taskStep;
            if (i3 != -1) {
                r.putValue(jSONObject, "task_step", i3);
            } else {
                jSONObject.remove("task_step");
            }
        }
    }

    public RewardMonitorInfo setAdCount(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            this.adCount = i;
            return this;
        }
        return (RewardMonitorInfo) invokeI.objValue;
    }

    public RewardMonitorInfo setCreativeId(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            this.creativeId = j;
            return this;
        }
        return (RewardMonitorInfo) invokeJ.objValue;
    }

    public RewardMonitorInfo setCurrentDuration(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
            this.currentDuration = j;
            return this;
        }
        return (RewardMonitorInfo) invokeJ.objValue;
    }

    public RewardMonitorInfo setDataDownloadInterval(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
            this.dataDownloadInterval = j;
            return this;
        }
        return (RewardMonitorInfo) invokeJ.objValue;
    }

    public RewardMonitorInfo setDataLoadInterval(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
            this.dataLoadInterval = j;
            return this;
        }
        return (RewardMonitorInfo) invokeJ.objValue;
    }

    public RewardMonitorInfo setDownloadDuration(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
            this.downloadDuration = j;
            return this;
        }
        return (RewardMonitorInfo) invokeJ.objValue;
    }

    public RewardMonitorInfo setDownloadSize(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
            this.downloadSize = j;
            return this;
        }
        return (RewardMonitorInfo) invokeJ.objValue;
    }

    public RewardMonitorInfo setDownloadType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            this.downloadType = i;
            return this;
        }
        return (RewardMonitorInfo) invokeI.objValue;
    }

    public RewardMonitorInfo setErrorCode(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            this.errorCode = i;
            return this;
        }
        return (RewardMonitorInfo) invokeI.objValue;
    }

    public RewardMonitorInfo setErrorMsg(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            this.errorMsg = str;
            return this;
        }
        return (RewardMonitorInfo) invokeL.objValue;
    }

    public RewardMonitorInfo setLoadDataDuration(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j)) == null) {
            this.loadDataDuration = j;
            return this;
        }
        return (RewardMonitorInfo) invokeJ.objValue;
    }

    public RewardMonitorInfo setLoadStatus(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            this.loadStatus = i;
            return this;
        }
        return (RewardMonitorInfo) invokeI.objValue;
    }

    public RewardMonitorInfo setLoadType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            this.loadType = i;
            return this;
        }
        return (RewardMonitorInfo) invokeI.objValue;
    }

    public RewardMonitorInfo setPageStatus(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            this.pageStatus = i;
            return this;
        }
        return (RewardMonitorInfo) invokeI.objValue;
    }

    public RewardMonitorInfo setRatioCount(double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Double.valueOf(d)})) == null) {
            this.ratioCount = d;
            return this;
        }
        return (RewardMonitorInfo) invokeCommon.objValue;
    }

    public RewardMonitorInfo setRenderDuration(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048592, this, j)) == null) {
            this.renderDuration = j;
            return this;
        }
        return (RewardMonitorInfo) invokeJ.objValue;
    }

    public RewardMonitorInfo setRewardType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            this.rewardType = i;
            return this;
        }
        return (RewardMonitorInfo) invokeI.objValue;
    }

    public RewardMonitorInfo setTaskStep(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            this.taskStep = i;
            return this;
        }
        return (RewardMonitorInfo) invokeI.objValue;
    }

    public RewardMonitorInfo setTaskType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            this.taskType = i;
            return this;
        }
        return (RewardMonitorInfo) invokeI.objValue;
    }

    public RewardMonitorInfo setTotalDuration(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048596, this, j)) == null) {
            this.totalDuration = j;
            return this;
        }
        return (RewardMonitorInfo) invokeJ.objValue;
    }

    public RewardMonitorInfo setVideoDuration(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048597, this, j)) == null) {
            this.videoDuration = j;
            return this;
        }
        return (RewardMonitorInfo) invokeJ.objValue;
    }

    public RewardMonitorInfo setVideoUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
            this.videoUrl = str;
            return this;
        }
        return (RewardMonitorInfo) invokeL.objValue;
    }
}
