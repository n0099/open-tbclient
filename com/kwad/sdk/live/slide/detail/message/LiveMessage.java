package com.kwad.sdk.live.slide.detail.message;

import com.kwad.sdk.utils.ag;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class LiveMessage implements Serializable {
    public static final long serialVersionUID = 2264410572624564928L;
    public String content;
    public long mSortRank;
    public String userName;

    public boolean isInValid() {
        return ag.a(this.userName) || ag.a(this.content);
    }
}
