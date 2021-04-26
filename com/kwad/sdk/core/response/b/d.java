package com.kwad.sdk.core.response.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.PhotoInfo;
/* loaded from: classes6.dex */
public class d {
    public static String a(@NonNull PhotoInfo photoInfo) {
        return photoInfo.videoInfo.videoUrl;
    }

    public static String b(@NonNull PhotoInfo photoInfo) {
        return photoInfo.videoInfo.manifest;
    }

    public static Long c(@NonNull PhotoInfo photoInfo) {
        return Long.valueOf(photoInfo.videoInfo.duration);
    }

    public static long d(@NonNull PhotoInfo photoInfo) {
        return photoInfo.baseInfo.photoId;
    }

    public static String e(@NonNull PhotoInfo photoInfo) {
        return photoInfo.baseInfo.recoExt;
    }

    public static long f(@NonNull PhotoInfo photoInfo) {
        return photoInfo.authorInfo.authorId;
    }

    public static long g(@NonNull PhotoInfo photoInfo) {
        return photoInfo.tubeEpisode.tubeId;
    }

    public static String h(@NonNull PhotoInfo photoInfo) {
        return photoInfo.tubeEpisode.tubeName;
    }

    public static String i(@NonNull PhotoInfo photoInfo) {
        return photoInfo.tubeEpisode.episodeName;
    }

    public static long j(@NonNull PhotoInfo photoInfo) {
        return photoInfo.trendInfo.trendId;
    }

    public static String k(@NonNull PhotoInfo photoInfo) {
        return photoInfo.trendInfo.name;
    }
}
