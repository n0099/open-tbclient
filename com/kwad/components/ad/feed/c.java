package com.kwad.components.ad.feed;

import android.content.Context;
import com.kwad.components.ad.feed.a.g;
import com.kwad.components.ad.feed.a.h;
import com.kwad.components.ad.feed.a.i;
import com.kwad.components.ad.feed.a.j;
import com.kwad.components.ad.feed.a.k;
import com.kwad.components.model.FeedType;
/* loaded from: classes9.dex */
public final class c {

    /* renamed from: com.kwad.components.ad.feed.c$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] cI;

        static {
            int[] iArr = new int[FeedType.values().length];
            cI = iArr;
            try {
                iArr[FeedType.FEED_TYPE_TEXT_IMMERSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                cI[FeedType.FEED_TYPE_TEXT_ABOVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                cI[FeedType.FEED_TYPE_TEXT_BELOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                cI[FeedType.FEED_TYPE_TEXT_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                cI[FeedType.FEED_TYPE_TEXT_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                cI[FeedType.FEED_TYPE_TEXT_ABOVE_GROUP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                cI[FeedType.FEED_TYPE_UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static com.kwad.components.core.widget.b a(Context context, FeedType feedType) {
        switch (AnonymousClass1.cI[feedType.ordinal()]) {
            case 1:
                return new i(context);
            case 2:
                return new com.kwad.components.ad.feed.a.e(context);
            case 3:
                return new g(context);
            case 4:
                return new j(context);
            case 5:
                return new k(context);
            case 6:
            case 7:
                com.kwad.sdk.core.e.b.e("KSFeedFactory", "getSingleImageView type is unknown:" + feedType);
                return null;
            default:
                return null;
        }
    }

    public static com.kwad.components.core.widget.b a(Context context, FeedType feedType, int i) {
        if (feedType == FeedType.FEED_TYPE_TEXT_NEW) {
            return i == 1 ? new h(context) : new g(context);
        } else if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    com.kwad.sdk.core.e.b.e("KSFeedFactory", "getNewFeedView materialType is unknown");
                    return null;
                }
                return b(context, feedType);
            }
            return a(context, feedType);
        } else {
            return c(context, feedType);
        }
    }

    public static com.kwad.components.core.widget.b b(Context context, FeedType feedType) {
        switch (AnonymousClass1.cI[feedType.ordinal()]) {
            case 1:
                return new i(context);
            case 2:
                return new com.kwad.components.ad.feed.a.e(context);
            case 3:
                return new g(context);
            case 4:
                return new j(context);
            case 5:
                return new k(context);
            case 6:
                return new g(context);
            case 7:
                com.kwad.sdk.core.e.b.e("KSFeedFactory", "getVideoView type is unknown" + feedType);
                return null;
            default:
                return null;
        }
    }

    public static com.kwad.components.core.widget.b c(Context context, FeedType feedType) {
        int i = AnonymousClass1.cI[feedType.ordinal()];
        if (i != 2) {
            if (i != 3) {
                com.kwad.sdk.core.e.b.e("KSFeedFactory", "getVideoView type is unknown:" + feedType);
                return null;
            }
            return new h(context);
        }
        return new com.kwad.components.ad.feed.a.f(context);
    }
}
