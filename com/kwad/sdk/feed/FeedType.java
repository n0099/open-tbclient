package com.kwad.sdk.feed;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes3.dex */
public enum FeedType {
    FEED_TYPE_UNKNOWN(0),
    FEED_TYPE_TEXT_IMMERSE(1),
    FEED_TYPE_TEXT_LEFT(2),
    FEED_TYPE_TEXT_RIGHT(3),
    FEED_TYPE_TEXT_ABOVE(4),
    FEED_TYPE_TEXT_BELOW(5),
    FEED_TYPE_TEXT_ABOVE_GROUP(6),
    FEED_TYPE_TEXT_NEW(7),
    FEED_TYPE_CONTENT_11(11),
    FEED_TYPE_CONTENT_12(12),
    FEED_TYPE_CONTENT_13(13);
    
    public int type;

    FeedType(int i2) {
        this.type = i2;
    }

    public static boolean checkTypeValid(@NonNull AdTemplate adTemplate) {
        int R = com.kwad.sdk.core.response.a.a.R(d.j(adTemplate));
        int i2 = adTemplate.type;
        if (i2 > FEED_TYPE_TEXT_ABOVE_GROUP.type) {
            return true;
        }
        FeedType fromInt = fromInt(i2);
        return R != 1 ? R != 2 ? R == 3 && fromInt != FEED_TYPE_UNKNOWN : (fromInt == FEED_TYPE_UNKNOWN || fromInt == FEED_TYPE_TEXT_ABOVE_GROUP) ? false : true : fromInt == FEED_TYPE_TEXT_ABOVE || fromInt == FEED_TYPE_TEXT_BELOW;
    }

    @NonNull
    public static FeedType fromInt(int i2) {
        FeedType[] values;
        for (FeedType feedType : values()) {
            if (feedType.type == i2) {
                return feedType;
            }
        }
        return isH5Type(i2) ? FEED_TYPE_TEXT_NEW : FEED_TYPE_UNKNOWN;
    }

    public static boolean isH5Type(int i2) {
        return i2 == 7 || i2 == 8 || i2 >= 2000;
    }

    public int getType() {
        return this.type;
    }
}
