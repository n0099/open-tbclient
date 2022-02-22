package com.kwad.sdk.core.response.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.NewsInfo;
import java.util.List;
/* loaded from: classes4.dex */
public class e {
    public static long a(@NonNull NewsInfo newsInfo) {
        return newsInfo.photoId;
    }

    public static int b(@NonNull NewsInfo newsInfo) {
        return newsInfo.contentSourceType;
    }

    public static int c(@NonNull NewsInfo newsInfo) {
        if (d(newsInfo)) {
            return 1;
        }
        if (e(newsInfo)) {
            return 3;
        }
        return f(newsInfo) ? 2 : 0;
    }

    public static boolean d(@NonNull NewsInfo newsInfo) {
        List<NewsInfo.ImageInfo> list = newsInfo.thumbnailInfo;
        return list == null || list.isEmpty();
    }

    public static boolean e(@NonNull NewsInfo newsInfo) {
        List<NewsInfo.ImageInfo> list = newsInfo.thumbnailInfo;
        return list != null && list.size() > 0 && newsInfo.thumbnailInfo.size() < 3;
    }

    public static boolean f(@NonNull NewsInfo newsInfo) {
        List<NewsInfo.ImageInfo> list = newsInfo.thumbnailInfo;
        return list != null && list.size() >= 3;
    }

    public static String g(@NonNull NewsInfo newsInfo) {
        return newsInfo.authorInfo.authorIcon;
    }
}
