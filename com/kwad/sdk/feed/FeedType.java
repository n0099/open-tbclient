package com.kwad.sdk.feed;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes7.dex */
public enum FeedType {
    FEED_TYPE_UNKNOWN(0),
    FEED_TYPE_TEXT_IMMERSE(1),
    FEED_TYPE_TEXT_LEFT(2),
    FEED_TYPE_TEXT_RIGHT(3),
    FEED_TYPE_TEXT_ABOVE(4),
    FEED_TYPE_TEXT_BELOW(5),
    FEED_TYPE_TEXT_ABOVE_GROUP(6),
    FEED_TYPE_TEXT_NEW(7);
    
    public int type;

    FeedType(int i2) {
        this.type = i2;
    }

    public static boolean checkTypeValid(@NonNull AdTemplate adTemplate) {
        int L = com.kwad.sdk.core.response.b.a.L(c.j(adTemplate));
        int i2 = adTemplate.type;
        if (i2 > FEED_TYPE_TEXT_ABOVE_GROUP.type) {
            return true;
        }
        FeedType fromInt = fromInt(i2);
        return L != 1 ? L != 2 ? L == 3 && fromInt != FEED_TYPE_UNKNOWN : (fromInt == FEED_TYPE_UNKNOWN || fromInt == FEED_TYPE_TEXT_ABOVE_GROUP) ? false : true : fromInt == FEED_TYPE_TEXT_ABOVE || fromInt == FEED_TYPE_TEXT_BELOW;
    }

    @NonNull
    public static FeedType fromInt(int i2) {
        FeedType[] values;
        for (FeedType feedType : values()) {
            if (feedType.type == i2) {
                return feedType;
            }
        }
        return i2 >= FEED_TYPE_TEXT_NEW.getType() ? FEED_TYPE_TEXT_NEW : FEED_TYPE_UNKNOWN;
    }

    public int getType() {
        return this.type;
    }
}
