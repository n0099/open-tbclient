package com.kwad.sdk.core.response.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoAd;
import com.kwad.sdk.core.response.model.PhotoInfo;
/* loaded from: classes7.dex */
public class f {
    public static String a(@NonNull PhotoInfo photoInfo) {
        return photoInfo.videoInfo.videoUrl;
    }

    public static boolean a(@NonNull AdTemplate adTemplate) {
        PhotoAd photoAd = adTemplate.photoAd;
        return photoAd != null && photoAd.requestPatchEc;
    }

    public static String b(@NonNull PhotoInfo photoInfo) {
        return photoInfo.videoInfo.manifest;
    }

    public static Long c(@NonNull PhotoInfo photoInfo) {
        return Long.valueOf(photoInfo.videoInfo.duration);
    }

    public static String d(@NonNull PhotoInfo photoInfo) {
        return photoInfo.coverInfo.blurBackgroundUrl;
    }

    public static long e(@NonNull PhotoInfo photoInfo) {
        return photoInfo.baseInfo.photoId;
    }

    public static int f(@NonNull PhotoInfo photoInfo) {
        return photoInfo.baseInfo.contentSourceType;
    }

    public static String g(@NonNull PhotoInfo photoInfo) {
        return photoInfo.baseInfo.recoExt;
    }

    public static long h(@NonNull PhotoInfo photoInfo) {
        return photoInfo.authorInfo.authorId;
    }

    public static String i(@NonNull PhotoInfo photoInfo) {
        return photoInfo.authorInfo.authorIcon;
    }

    public static long j(@NonNull PhotoInfo photoInfo) {
        return photoInfo.tubeEpisode.tubeId;
    }

    public static String k(@NonNull PhotoInfo photoInfo) {
        return photoInfo.tubeEpisode.tubeName;
    }

    public static String l(@NonNull PhotoInfo photoInfo) {
        return photoInfo.tubeEpisode.episodeName;
    }

    public static long m(@NonNull PhotoInfo photoInfo) {
        return photoInfo.mHotspotInfo.trendId;
    }

    public static String n(@NonNull PhotoInfo photoInfo) {
        return photoInfo.mHotspotInfo.name;
    }

    public static String o(PhotoInfo photoInfo) {
        return photoInfo.baseInfo.sdkExtraData;
    }
}
