package com.kwad.sdk.feed;

import android.content.Context;
import com.kwad.sdk.feed.widget.c;
import com.kwad.sdk.feed.widget.d;
import com.kwad.sdk.feed.widget.e;
import com.kwad.sdk.feed.widget.f;
import com.kwad.sdk.feed.widget.g;
import com.kwad.sdk.feed.widget.h;
import com.kwad.sdk.feed.widget.i;
/* loaded from: classes3.dex */
public class a {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static com.kwad.sdk.feed.widget.base.a a(Context context, FeedType feedType) {
        switch (feedType) {
            case FEED_TYPE_TEXT_IMMERSE:
                return new g(context);
            case FEED_TYPE_TEXT_ABOVE:
                return new c(context);
            case FEED_TYPE_TEXT_BELOW:
                return new e(context);
            case FEED_TYPE_TEXT_LEFT:
                return new h(context);
            case FEED_TYPE_TEXT_RIGHT:
                return new i(context);
            case FEED_TYPE_TEXT_ABOVE_GROUP:
            case FEED_TYPE_UNKNOWN:
                com.kwad.sdk.core.d.a.d("KSFeedFactory", "getSingleImageView type is unknown:" + feedType);
                break;
        }
        return null;
    }

    public static com.kwad.sdk.feed.widget.base.a a(Context context, FeedType feedType, int i) {
        if (feedType == FeedType.FEED_TYPE_TEXT_NEW) {
            return new e(context);
        }
        switch (i) {
            case 1:
                return c(context, feedType);
            case 2:
                return a(context, feedType);
            case 3:
                return b(context, feedType);
            default:
                com.kwad.sdk.core.d.a.d("KSFeedFactory", "getNewFeedView materialType is unknown");
                return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static com.kwad.sdk.feed.widget.base.a b(Context context, FeedType feedType) {
        switch (feedType) {
            case FEED_TYPE_TEXT_IMMERSE:
                return new g(context);
            case FEED_TYPE_TEXT_ABOVE:
                return new c(context);
            case FEED_TYPE_TEXT_BELOW:
                return new e(context);
            case FEED_TYPE_TEXT_LEFT:
                return new h(context);
            case FEED_TYPE_TEXT_RIGHT:
                return new i(context);
            case FEED_TYPE_TEXT_ABOVE_GROUP:
                return new com.kwad.sdk.feed.widget.b(context);
            case FEED_TYPE_UNKNOWN:
                com.kwad.sdk.core.d.a.d("KSFeedFactory", "getVideoView type is unknown" + feedType);
                break;
        }
        return null;
    }

    private static com.kwad.sdk.feed.widget.base.a c(Context context, FeedType feedType) {
        switch (feedType) {
            case FEED_TYPE_TEXT_ABOVE:
                return new d(context);
            case FEED_TYPE_TEXT_BELOW:
                return new f(context);
            default:
                com.kwad.sdk.core.d.a.d("KSFeedFactory", "getVideoView type is unknown:" + feedType);
                return null;
        }
    }
}
