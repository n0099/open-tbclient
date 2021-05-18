package com.kwad.sdk.feed;

import android.content.Context;
import com.kwad.sdk.feed.widget.c;
import com.kwad.sdk.feed.widget.d;
import com.kwad.sdk.feed.widget.e;
import com.kwad.sdk.feed.widget.f;
import com.kwad.sdk.feed.widget.g;
import com.kwad.sdk.feed.widget.h;
import com.kwad.sdk.feed.widget.i;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: com.kwad.sdk.feed.a$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f33241a;

        static {
            int[] iArr = new int[FeedType.values().length];
            f33241a = iArr;
            try {
                iArr[FeedType.FEED_TYPE_TEXT_IMMERSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33241a[FeedType.FEED_TYPE_TEXT_ABOVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33241a[FeedType.FEED_TYPE_TEXT_BELOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33241a[FeedType.FEED_TYPE_TEXT_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33241a[FeedType.FEED_TYPE_TEXT_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f33241a[FeedType.FEED_TYPE_TEXT_ABOVE_GROUP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f33241a[FeedType.FEED_TYPE_UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static com.kwad.sdk.feed.widget.base.a a(Context context, FeedType feedType) {
        switch (AnonymousClass1.f33241a[feedType.ordinal()]) {
            case 1:
                return new g(context);
            case 2:
                return new c(context);
            case 3:
                return new e(context);
            case 4:
                return new h(context);
            case 5:
                return new i(context);
            case 6:
            case 7:
                com.kwad.sdk.core.d.a.e("KSFeedFactory", "getSingleImageView type is unknown:" + feedType);
                return null;
            default:
                return null;
        }
    }

    public static com.kwad.sdk.feed.widget.base.a a(Context context, FeedType feedType, int i2) {
        if (feedType == FeedType.FEED_TYPE_TEXT_NEW) {
            return new e(context);
        }
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    com.kwad.sdk.core.d.a.e("KSFeedFactory", "getNewFeedView materialType is unknown");
                    return null;
                }
                return b(context, feedType);
            }
            return a(context, feedType);
        }
        return c(context, feedType);
    }

    public static com.kwad.sdk.feed.widget.base.a b(Context context, FeedType feedType) {
        switch (AnonymousClass1.f33241a[feedType.ordinal()]) {
            case 1:
                return new g(context);
            case 2:
                return new c(context);
            case 3:
                return new e(context);
            case 4:
                return new h(context);
            case 5:
                return new i(context);
            case 6:
                return new com.kwad.sdk.feed.widget.b(context);
            case 7:
                com.kwad.sdk.core.d.a.e("KSFeedFactory", "getVideoView type is unknown" + feedType);
                return null;
            default:
                return null;
        }
    }

    public static com.kwad.sdk.feed.widget.base.a c(Context context, FeedType feedType) {
        int i2 = AnonymousClass1.f33241a[feedType.ordinal()];
        if (i2 != 2) {
            if (i2 != 3) {
                com.kwad.sdk.core.d.a.e("KSFeedFactory", "getVideoView type is unknown:" + feedType);
                return null;
            }
            return new f(context);
        }
        return new d(context);
    }
}
