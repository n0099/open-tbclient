package com.kwad.sdk.collector;

import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public interface a {
    List<com.kwad.sdk.collector.model.b> a(AppStatusRules.Strategy strategy, Map<String, InstalledAppInfoManager.AppPackageInfo> map);

    List<com.kwad.sdk.collector.model.e> a(List<com.kwad.sdk.collector.model.d> list, long j, String str);
}
