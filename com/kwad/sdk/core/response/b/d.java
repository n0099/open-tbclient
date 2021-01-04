package com.kwad.sdk.core.response.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.response.model.TrendInfo;
import com.kwad.sdk.utils.ag;
/* loaded from: classes5.dex */
public class d {
    public static String A(@NonNull PhotoInfo photoInfo) {
        return photoInfo.tubeEpisode.tubeName;
    }

    public static String B(@NonNull PhotoInfo photoInfo) {
        return photoInfo.tubeEpisode.episodeName;
    }

    public static long C(PhotoInfo photoInfo) {
        return photoInfo.tubeEpisode.playCount;
    }

    @NonNull
    public static com.kwad.sdk.core.response.model.c D(@NonNull PhotoInfo photoInfo) {
        boolean z;
        String d = d(photoInfo);
        int e = e(photoInfo);
        int f = f(photoInfo);
        if (ag.a(d) || ag.b(d) || e == 0 || f == 0) {
            d = g(photoInfo);
            e = i(photoInfo);
            f = j(photoInfo);
            z = true;
        } else {
            z = false;
        }
        com.kwad.sdk.core.d.a.a("PhotoInfoHelper", "frameUrl=" + d + " useCover=" + z + " isAd=false");
        return new com.kwad.sdk.core.response.model.c(d, e, f, false, z);
    }

    @NonNull
    public static com.kwad.sdk.core.response.model.c E(@NonNull PhotoInfo photoInfo) {
        boolean z;
        String g = g(photoInfo);
        int i = i(photoInfo);
        int j = j(photoInfo);
        if (ag.a(g) || i == 0 || j == 0) {
            g = d(photoInfo);
            i = e(photoInfo);
            j = j(photoInfo);
            z = false;
        } else {
            z = true;
        }
        return new com.kwad.sdk.core.response.model.c(g, i, j, false, z);
    }

    public static boolean F(@NonNull PhotoInfo photoInfo) {
        return !TextUtils.isEmpty(photoInfo.trendInfo.name);
    }

    public static long G(PhotoInfo photoInfo) {
        return photoInfo.baseInfo.videoUrlCacheTime;
    }

    public static boolean H(@NonNull PhotoInfo photoInfo) {
        return photoInfo.photoAd.requestPatchAd;
    }

    public static long I(@NonNull PhotoInfo photoInfo) {
        return photoInfo.trendInfo.trendId;
    }

    public static String J(@NonNull PhotoInfo photoInfo) {
        return photoInfo.trendInfo.name;
    }

    public static TrendInfo K(@NonNull PhotoInfo photoInfo) {
        return photoInfo.trendInfo;
    }

    public static String L(@NonNull PhotoInfo photoInfo) {
        return photoInfo.coverInfo.webpCoverUrl;
    }

    public static String a(@NonNull PhotoInfo photoInfo) {
        return photoInfo.baseInfo.title;
    }

    public static String b(@NonNull PhotoInfo photoInfo) {
        return photoInfo.videoInfo.videoUrl;
    }

    public static Long c(@NonNull PhotoInfo photoInfo) {
        return Long.valueOf(photoInfo.videoInfo.duration);
    }

    public static String d(@NonNull PhotoInfo photoInfo) {
        return photoInfo.videoInfo.firstFrame;
    }

    public static int e(@NonNull PhotoInfo photoInfo) {
        return photoInfo.videoInfo.width;
    }

    public static int f(@NonNull PhotoInfo photoInfo) {
        return photoInfo.videoInfo.height;
    }

    public static String g(@NonNull PhotoInfo photoInfo) {
        return photoInfo.coverInfo.coverUrl;
    }

    public static String h(@NonNull PhotoInfo photoInfo) {
        return photoInfo.coverInfo.blurBackgroundUrl;
    }

    public static int i(@NonNull PhotoInfo photoInfo) {
        return photoInfo.coverInfo.width;
    }

    public static int j(@NonNull PhotoInfo photoInfo) {
        return photoInfo.coverInfo.height;
    }

    public static long k(@NonNull PhotoInfo photoInfo) {
        return photoInfo.baseInfo.photoId;
    }

    public static String l(@NonNull PhotoInfo photoInfo) {
        return photoInfo.baseInfo.recoExt;
    }

    public static long m(@NonNull PhotoInfo photoInfo) {
        return photoInfo.baseInfo.likeCount;
    }

    public static long n(@NonNull PhotoInfo photoInfo) {
        return photoInfo.baseInfo.commentCount;
    }

    public static long o(@NonNull PhotoInfo photoInfo) {
        return photoInfo.authorInfo.authorId;
    }

    public static String p(@NonNull PhotoInfo photoInfo) {
        return photoInfo.authorInfo.authorName;
    }

    public static String q(@NonNull PhotoInfo photoInfo) {
        return photoInfo.authorInfo.rawAuthorName;
    }

    public static String r(@NonNull PhotoInfo photoInfo) {
        return photoInfo.authorInfo.authorIcon;
    }

    public static String s(@NonNull PhotoInfo photoInfo) {
        return photoInfo.authorInfo.authorIconGuide;
    }

    public static String t(@NonNull PhotoInfo photoInfo) {
        return photoInfo.authorInfo.authorText;
    }

    public static String u(@NonNull PhotoInfo photoInfo) {
        return photoInfo.baseInfo.videoDesc;
    }

    public static boolean v(@NonNull PhotoInfo photoInfo) {
        return photoInfo.baseInfo.waterMarkPosition != 0;
    }

    public static int w(@NonNull PhotoInfo photoInfo) {
        return photoInfo.baseInfo.waterMarkPosition;
    }

    public static boolean x(PhotoInfo photoInfo) {
        return photoInfo.tubeEpisode.hasTube;
    }

    public static PhotoInfo.TubeEpisode y(PhotoInfo photoInfo) {
        return photoInfo.tubeEpisode;
    }

    public static long z(@NonNull PhotoInfo photoInfo) {
        return photoInfo.tubeEpisode.tubeId;
    }
}
