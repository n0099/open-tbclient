package com.bytedance.sdk.openadsdk.preload.falconx.statistic;

import android.os.SystemClock;
import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.a.a.c;
@Keep
/* loaded from: classes5.dex */
public class InterceptorModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @c(a = "ac")
    public String ac;
    @c(a = "access_key")
    public String accessKey;
    @c(a = "channel")
    public String channel;
    @c(a = PmsConstant.Statistic.STATISTIC_ERRCODE)
    public String errCode;
    @c(a = PmsConstant.Statistic.STATISTIC_ERRMSG)
    public String errMsg;
    @c(a = TiebaStatic.Params.LOGID)
    public String logId;
    @c(a = "mime_type")
    public String mimeType;
    @c(a = "offline_duration")
    public Long offlineDuration;
    @c(a = "offline_rule")
    public String offlineRule;
    @c(a = "offline_status")
    public Integer offlineStatus;
    @c(a = "online_duration")
    public Long onlineDuration;
    @c(a = "page_url")
    public String pageUrl;
    @c(a = "pkg_version")
    public Long pkgVersion;
    @c(a = "res_root_dir")
    public String resRootDir;
    public Long startTime;
    @c(a = "resource_url")
    public String url;

    public InterceptorModel() {
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
        this.startTime = Long.valueOf(SystemClock.uptimeMillis());
    }

    public void loadFinish(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                this.offlineDuration = Long.valueOf(SystemClock.uptimeMillis() - this.startTime.longValue());
                this.offlineStatus = 1;
                return;
            }
            this.offlineStatus = 0;
        }
    }

    public void setErrorCode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.errCode = str;
        }
    }

    public void setErrorMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.errMsg = str;
        }
    }
}
