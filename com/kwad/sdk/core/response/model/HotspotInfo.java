package com.kwad.sdk.core.response.model;

import androidx.annotation.Nullable;
import java.io.Serializable;
/* loaded from: classes7.dex */
public class HotspotInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    public static final long serialVersionUID = 8690126962689904212L;
    public String coverUrl;
    public String iconUrl;
    public transient boolean mHotPhotoImpressionReported;
    public String name;
    public long offlineTime;
    public int photoCount;
    public int rank;
    public long trendId;
    public long viewCount;

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof HotspotInfo) && ((HotspotInfo) obj).trendId == this.trendId;
    }
}
