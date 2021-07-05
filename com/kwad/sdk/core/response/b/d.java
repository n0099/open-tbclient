package com.kwad.sdk.core.response.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.response.model.TrendInfo;
import com.kwad.sdk.utils.ag;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String A(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, photoInfo)) == null) ? photoInfo.tubeEpisode.tubeName : (String) invokeL.objValue;
    }

    public static String B(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, photoInfo)) == null) ? photoInfo.tubeEpisode.episodeName : (String) invokeL.objValue;
    }

    public static long C(PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, photoInfo)) == null) ? photoInfo.tubeEpisode.playCount : invokeL.longValue;
    }

    @NonNull
    public static com.kwad.sdk.core.response.model.c D(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        String g2;
        int i2;
        int j;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, photoInfo)) == null) {
            String d2 = d(photoInfo);
            int e2 = e(photoInfo);
            int f2 = f(photoInfo);
            if (ag.a(d2) || ag.b(d2) || e2 == 0 || f2 == 0) {
                g2 = g(photoInfo);
                i2 = i(photoInfo);
                j = j(photoInfo);
                z = true;
            } else {
                g2 = d2;
                i2 = e2;
                j = f2;
                z = false;
            }
            com.kwad.sdk.core.d.a.a("PhotoInfoHelper", "frameUrl=" + g2 + " useCover=" + z + " isAd=false");
            return new com.kwad.sdk.core.response.model.c(g2, i2, j, false, z);
        }
        return (com.kwad.sdk.core.response.model.c) invokeL.objValue;
    }

    @NonNull
    public static com.kwad.sdk.core.response.model.c E(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        String d2;
        int e2;
        int j;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, photoInfo)) == null) {
            String g2 = g(photoInfo);
            int i2 = i(photoInfo);
            int j2 = j(photoInfo);
            if (ag.a(g2) || i2 == 0 || j2 == 0) {
                d2 = d(photoInfo);
                e2 = e(photoInfo);
                j = j(photoInfo);
                z = false;
            } else {
                d2 = g2;
                e2 = i2;
                j = j2;
                z = true;
            }
            return new com.kwad.sdk.core.response.model.c(d2, e2, j, false, z);
        }
        return (com.kwad.sdk.core.response.model.c) invokeL.objValue;
    }

    public static boolean F(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, photoInfo)) == null) ? !TextUtils.isEmpty(photoInfo.trendInfo.name) : invokeL.booleanValue;
    }

    public static long G(PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, photoInfo)) == null) ? photoInfo.baseInfo.videoUrlCacheTime : invokeL.longValue;
    }

    public static boolean H(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, photoInfo)) == null) ? photoInfo.photoAd.requestPatchAd : invokeL.booleanValue;
    }

    public static long I(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, photoInfo)) == null) ? photoInfo.trendInfo.trendId : invokeL.longValue;
    }

    public static String J(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, photoInfo)) == null) ? photoInfo.trendInfo.name : (String) invokeL.objValue;
    }

    public static TrendInfo K(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, photoInfo)) == null) ? photoInfo.trendInfo : (TrendInfo) invokeL.objValue;
    }

    public static String L(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, photoInfo)) == null) ? photoInfo.coverInfo.webpCoverUrl : (String) invokeL.objValue;
    }

    public static String a(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, photoInfo)) == null) ? photoInfo.baseInfo.title : (String) invokeL.objValue;
    }

    public static String b(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, photoInfo)) == null) ? photoInfo.videoInfo.videoUrl : (String) invokeL.objValue;
    }

    public static Long c(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, photoInfo)) == null) ? Long.valueOf(photoInfo.videoInfo.duration) : (Long) invokeL.objValue;
    }

    public static String d(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, photoInfo)) == null) ? photoInfo.videoInfo.firstFrame : (String) invokeL.objValue;
    }

    public static int e(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, photoInfo)) == null) ? photoInfo.videoInfo.width : invokeL.intValue;
    }

    public static int f(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, photoInfo)) == null) ? photoInfo.videoInfo.height : invokeL.intValue;
    }

    public static String g(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, photoInfo)) == null) ? photoInfo.coverInfo.coverUrl : (String) invokeL.objValue;
    }

    public static String h(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, photoInfo)) == null) ? photoInfo.coverInfo.blurBackgroundUrl : (String) invokeL.objValue;
    }

    public static int i(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65556, null, photoInfo)) == null) ? photoInfo.coverInfo.width : invokeL.intValue;
    }

    public static int j(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, photoInfo)) == null) ? photoInfo.coverInfo.height : invokeL.intValue;
    }

    public static long k(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65558, null, photoInfo)) == null) ? photoInfo.baseInfo.photoId : invokeL.longValue;
    }

    public static String l(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, photoInfo)) == null) ? photoInfo.baseInfo.recoExt : (String) invokeL.objValue;
    }

    public static long m(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65560, null, photoInfo)) == null) ? photoInfo.baseInfo.likeCount : invokeL.longValue;
    }

    public static long n(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, photoInfo)) == null) ? photoInfo.baseInfo.commentCount : invokeL.longValue;
    }

    public static long o(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65562, null, photoInfo)) == null) ? photoInfo.authorInfo.authorId : invokeL.longValue;
    }

    public static String p(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65563, null, photoInfo)) == null) ? photoInfo.authorInfo.authorName : (String) invokeL.objValue;
    }

    public static String q(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65564, null, photoInfo)) == null) ? photoInfo.authorInfo.rawAuthorName : (String) invokeL.objValue;
    }

    public static String r(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65565, null, photoInfo)) == null) ? photoInfo.authorInfo.authorIcon : (String) invokeL.objValue;
    }

    public static String s(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65566, null, photoInfo)) == null) ? photoInfo.authorInfo.authorIconGuide : (String) invokeL.objValue;
    }

    public static String t(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65567, null, photoInfo)) == null) ? photoInfo.authorInfo.authorText : (String) invokeL.objValue;
    }

    public static String u(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65568, null, photoInfo)) == null) ? photoInfo.baseInfo.videoDesc : (String) invokeL.objValue;
    }

    public static boolean v(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65569, null, photoInfo)) == null) ? photoInfo.baseInfo.waterMarkPosition != 0 : invokeL.booleanValue;
    }

    public static int w(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65570, null, photoInfo)) == null) ? photoInfo.baseInfo.waterMarkPosition : invokeL.intValue;
    }

    public static boolean x(PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65571, null, photoInfo)) == null) ? photoInfo.tubeEpisode.hasTube : invokeL.booleanValue;
    }

    public static PhotoInfo.TubeEpisode y(PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65572, null, photoInfo)) == null) ? photoInfo.tubeEpisode : (PhotoInfo.TubeEpisode) invokeL.objValue;
    }

    public static long z(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65573, null, photoInfo)) == null) ? photoInfo.tubeEpisode.tubeId : invokeL.longValue;
    }
}
