package com.kwad.sdk.live.mode;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static String a(@NonNull LiveInfo liveInfo) {
        return liveInfo.liveStreamId;
    }

    public static List<AdTemplate> a(LiveInfoResultData liveInfoResultData, SceneImpl sceneImpl) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        Iterator<LiveInfo> it = liveInfoResultData.liveInfoList.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return arrayList;
            }
            AdTemplate adTemplate = new AdTemplate();
            adTemplate.llsid = liveInfoResultData.llsid;
            adTemplate.extra = liveInfoResultData.extra;
            adTemplate.contentType = 4;
            adTemplate.realShowType = 4;
            adTemplate.mAdScene = sceneImpl;
            adTemplate.mLiveInfo = it.next();
            arrayList.add(adTemplate);
            i = i2 + 1;
        }
    }

    public static long b(@NonNull LiveInfo liveInfo) {
        return liveInfo.user.user_id;
    }

    public static String c(@NonNull LiveInfo liveInfo) {
        return liveInfo.exp_tag;
    }
}
