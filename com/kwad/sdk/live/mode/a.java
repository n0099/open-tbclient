package com.kwad.sdk.live.mode;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(@NonNull LiveInfo liveInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, liveInfo)) == null) ? liveInfo.liveStreamId : (String) invokeL.objValue;
    }

    public static List<AdTemplate> a(LiveInfoResultData liveInfoResultData, SceneImpl sceneImpl) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, liveInfoResultData, sceneImpl)) == null) {
            ArrayList arrayList = new ArrayList();
            for (LiveInfo liveInfo : liveInfoResultData.liveInfoList) {
                AdTemplate adTemplate = new AdTemplate();
                adTemplate.llsid = liveInfoResultData.llsid;
                adTemplate.extra = liveInfoResultData.extra;
                adTemplate.contentType = 4;
                adTemplate.realShowType = 4;
                adTemplate.mAdScene = sceneImpl;
                adTemplate.mLiveInfo = liveInfo;
                arrayList.add(adTemplate);
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static long b(@NonNull LiveInfo liveInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, liveInfo)) == null) ? liveInfo.user.user_id : invokeL.longValue;
    }

    public static String c(@NonNull LiveInfo liveInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, liveInfo)) == null) ? liveInfo.exp_tag : (String) invokeL.objValue;
    }
}
