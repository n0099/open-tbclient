package com.kwad.sdk.internal.api;

import java.io.Serializable;
/* loaded from: classes7.dex */
public class EcAttribute implements Serializable {
    public static final long serialVersionUID = 5648759570127504312L;
    public String comment;
    public String promoteId;
    public long userCommRateBuying = 0;
    public long userCommRateSharing = 0;

    public String getComment() {
        return this.comment;
    }

    public String getPromoteId() {
        return this.promoteId;
    }

    public long getUserCommRateBuying() {
        return this.userCommRateBuying;
    }

    public long getUserCommRateSharing() {
        return this.userCommRateSharing;
    }

    public void setComment(String str) {
        if (str == null) {
            str = "";
        }
        this.comment = str;
    }

    public void setPromoteId(String str) {
        if (str == null) {
            str = "";
        }
        this.promoteId = str;
    }

    public void setUserCommRateBuying(long j) {
        this.userCommRateBuying = j;
    }

    public void setUserCommRateSharing(long j) {
        this.userCommRateSharing = j;
    }
}
