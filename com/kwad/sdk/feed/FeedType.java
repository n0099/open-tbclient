package com.kwad.sdk.feed;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes4.dex */
public enum FeedType {
    FEED_TYPE_UNKNOWN(0),
    FEED_TYPE_TEXT_IMMERSE(1),
    FEED_TYPE_TEXT_LEFT(2),
    FEED_TYPE_TEXT_RIGHT(3),
    FEED_TYPE_TEXT_ABOVE(4),
    FEED_TYPE_TEXT_BELOW(5),
    FEED_TYPE_TEXT_ABOVE_GROUP(6),
    FEED_TYPE_TEXT_NEW(7);
    
    private int type;

    FeedType(int i) {
        this.type = i;
    }

    public static boolean checkTypeValid(@NonNull AdTemplate adTemplate) {
        boolean z = false;
        int L = com.kwad.sdk.core.response.b.a.L(c.j(adTemplate));
        if (adTemplate.type > FEED_TYPE_TEXT_ABOVE_GROUP.type) {
            return true;
        }
        FeedType fromInt = fromInt(adTemplate.type);
        switch (L) {
            case 1:
                if (fromInt == FEED_TYPE_TEXT_ABOVE || fromInt == FEED_TYPE_TEXT_BELOW) {
                    z = true;
                }
                return z;
            case 2:
                return (fromInt == FEED_TYPE_UNKNOWN || fromInt == FEED_TYPE_TEXT_ABOVE_GROUP) ? false : true;
            case 3:
                return fromInt != FEED_TYPE_UNKNOWN;
            default:
                return false;
        }
    }

    @NonNull
    public static FeedType fromInt(int i) {
        FeedType[] values;
        for (FeedType feedType : values()) {
            if (feedType.type == i) {
                return feedType;
            }
        }
        return i >= FEED_TYPE_TEXT_NEW.getType() ? FEED_TYPE_TEXT_NEW : FEED_TYPE_UNKNOWN;
    }

    public int getType() {
        return this.type;
    }
}
