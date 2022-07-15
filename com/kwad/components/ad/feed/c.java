package com.kwad.components.ad.feed;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.components.ad.feed.a.f;
import com.kwad.components.ad.feed.a.g;
import com.kwad.components.ad.feed.a.h;
import com.kwad.components.ad.feed.a.i;
import com.kwad.components.ad.feed.a.j;
import com.kwad.components.ad.feed.a.k;
import com.kwad.components.model.FeedType;
/* loaded from: classes5.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.components.ad.feed.c$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2052061667, "Lcom/kwad/components/ad/feed/c$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2052061667, "Lcom/kwad/components/ad/feed/c$1;");
                    return;
                }
            }
            int[] iArr = new int[FeedType.values().length];
            a = iArr;
            try {
                iArr[FeedType.FEED_TYPE_TEXT_IMMERSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[FeedType.FEED_TYPE_TEXT_ABOVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[FeedType.FEED_TYPE_TEXT_BELOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[FeedType.FEED_TYPE_TEXT_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[FeedType.FEED_TYPE_TEXT_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[FeedType.FEED_TYPE_TEXT_ABOVE_GROUP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[FeedType.FEED_TYPE_UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static com.kwad.components.core.widget.b a(Context context, FeedType feedType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, feedType)) == null) {
            switch (AnonymousClass1.a[feedType.ordinal()]) {
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
                    com.kwad.sdk.core.d.b.e("KSFeedFactory", "getSingleImageView type is unknown:" + feedType);
                    return null;
                default:
                    return null;
            }
        }
        return (com.kwad.components.core.widget.b) invokeLL.objValue;
    }

    public static com.kwad.components.core.widget.b a(Context context, FeedType feedType, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, context, feedType, i)) == null) {
            if (feedType == FeedType.FEED_TYPE_TEXT_NEW) {
                return i == 1 ? new h(context) : new g(context);
            } else if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        com.kwad.sdk.core.d.b.e("KSFeedFactory", "getNewFeedView materialType is unknown");
                        return null;
                    }
                    return b(context, feedType);
                }
                return a(context, feedType);
            } else {
                return c(context, feedType);
            }
        }
        return (com.kwad.components.core.widget.b) invokeLLI.objValue;
    }

    public static com.kwad.components.core.widget.b b(Context context, FeedType feedType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, feedType)) == null) {
            switch (AnonymousClass1.a[feedType.ordinal()]) {
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
                    com.kwad.sdk.core.d.b.e("KSFeedFactory", "getVideoView type is unknown" + feedType);
                    return null;
                default:
                    return null;
            }
        }
        return (com.kwad.components.core.widget.b) invokeLL.objValue;
    }

    public static com.kwad.components.core.widget.b c(Context context, FeedType feedType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, feedType)) == null) {
            int i = AnonymousClass1.a[feedType.ordinal()];
            if (i != 2) {
                if (i != 3) {
                    com.kwad.sdk.core.d.b.e("KSFeedFactory", "getVideoView type is unknown:" + feedType);
                    return null;
                }
                return new h(context);
            }
            return new f(context);
        }
        return (com.kwad.components.core.widget.b) invokeLL.objValue;
    }
}
