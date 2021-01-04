package com.bytedance.sdk.openadsdk.preload.falconx.statistic;

import androidx.annotation.Keep;
import com.bytedance.sdk.openadsdk.d.a.c;
import java.util.List;
@Keep
/* loaded from: classes4.dex */
public class StatisticData {
    public static final String ERROR_CODE_IO_ERROR = "101";
    public static final String ERROR_CODE_NOT_FOUND = "100";
    @c(a = "common")
    public Common mCommon;
    @c(a = "offline")
    public List<InterceptorModel> offline;
}
