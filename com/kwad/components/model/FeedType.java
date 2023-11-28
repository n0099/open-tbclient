package com.kwad.components.model;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.b.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
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

    public static boolean isH5Type(int i) {
        return i == 7 || i == 8 || i == 14 || i == 15 || i == 16 || i == 17 || i == 18 || i == 19 || i >= 2000;
    }

    FeedType(int i) {
        this.type = i;
    }

    public static boolean checkTypeValid(@NonNull AdTemplate adTemplate) {
        int be = a.be(e.dP(adTemplate));
        int i = adTemplate.type;
        if (i > FEED_TYPE_TEXT_ABOVE_GROUP.type) {
            return true;
        }
        FeedType fromInt = fromInt(i);
        if (be != 1) {
            if (be != 2) {
                if (be != 3) {
                    if (be != 8) {
                        return false;
                    }
                } else if (fromInt != FEED_TYPE_UNKNOWN) {
                    return true;
                } else {
                    return false;
                }
            } else if (fromInt != FEED_TYPE_UNKNOWN && fromInt != FEED_TYPE_TEXT_ABOVE_GROUP) {
                return true;
            } else {
                return false;
            }
        }
        if (fromInt == FEED_TYPE_TEXT_ABOVE || fromInt == FEED_TYPE_TEXT_BELOW || fromInt == FEED_TYPE_TEXT_IMMERSE) {
            return true;
        }
        return false;
    }

    @NonNull
    public static FeedType fromInt(int i) {
        FeedType[] values;
        for (FeedType feedType : values()) {
            if (feedType.type == i) {
                return feedType;
            }
        }
        if (isH5Type(i)) {
            return FEED_TYPE_TEXT_NEW;
        }
        return FEED_TYPE_UNKNOWN;
    }

    public final int getType() {
        return this.type;
    }
}
