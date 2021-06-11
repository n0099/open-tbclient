package com.bytedance.sdk.openadsdk.preload.geckox.statistic.model;

import androidx.annotation.Keep;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.bytedance.sdk.openadsdk.preload.a.a.c;
import com.bytedance.sdk.openadsdk.preload.geckox.model.Common;
import java.util.ArrayList;
import java.util.List;
@Keep
/* loaded from: classes6.dex */
public class StatisticModel {
    @c(a = "common")

    /* renamed from: common  reason: collision with root package name */
    public Common f30211common;
    @c(a = "packages")
    public List<PackageStatisticModel> packages = new ArrayList();

    @Keep
    /* loaded from: classes6.dex */
    public static class PackageStatisticModel {
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
        @c(a = "log_id")
        public String logId;
        @c(a = "patch_id")
        public Long patchId;
        @c(a = "stats_type")
        public Integer statsType;

        @Keep
        /* loaded from: classes6.dex */
        public static class DownloadFailRecords {
            @c(a = "domain")
            public String domain;
            @c(a = "reason")
            public String reason;

            public DownloadFailRecords(String str, String str2) {
                this.domain = str;
                this.reason = str2;
            }
        }
    }
}
