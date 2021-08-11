package com.bytedance.sdk.openadsdk.preload.geckox.statistic.model;

import androidx.annotation.Keep;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.a.a.c;
import com.bytedance.sdk.openadsdk.preload.geckox.model.Common;
import java.util.ArrayList;
import java.util.List;
@Keep
/* loaded from: classes9.dex */
public class StatisticModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @c(a = "common")

    /* renamed from: common  reason: collision with root package name */
    public Common f68415common;
    @c(a = "packages")
    public List<PackageStatisticModel> packages;

    @Keep
    /* loaded from: classes9.dex */
    public static class PackageStatisticModel {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @c(a = "ac")
        public String ac;
        @c(a = "access_key")
        public String accessKey;
        @c(a = "active_check_duration")
        public Long activeCheckDuration;
        @c(a = "apply_duration")
        public Long applyDuration;
        @c(a = "channel")
        public String channel;
        @c(a = "clean_duration")
        public Long cleanDuration;
        @c(a = "clean_strategy")
        public Integer cleanStrategy;
        @c(a = "clean_type")
        public Integer cleanType;
        @c(a = "download_duration")
        public Long downloadDuration;
        @c(a = "download_fail_records")
        public List<DownloadFailRecords> downloadFailRecords;
        @c(a = "download_retry_times")
        public Integer downloadRetryTimes;
        @c(a = "download_url")
        public String downloadUrl;
        @c(a = PmsConstant.Statistic.STATISTIC_ERRCODE)
        public String errCode;
        @c(a = PmsConstant.Statistic.STATISTIC_ERRMSG)
        public String errMsg;
        @c(a = "group_name")
        public String groupName;
        @c(a = "id")
        public Long id;
        @c(a = TiebaStatic.Params.LOGID)
        public String logId;
        @c(a = "patch_id")
        public Long patchId;
        @c(a = "stats_type")
        public Integer statsType;

        @Keep
        /* loaded from: classes9.dex */
        public static class DownloadFailRecords {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            @c(a = "domain")
            public String domain;
            @c(a = "reason")
            public String reason;

            public DownloadFailRecords(String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, str2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.domain = str;
                this.reason = str2;
            }
        }

        public PackageStatisticModel() {
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

    public StatisticModel() {
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
        this.packages = new ArrayList();
    }
}
