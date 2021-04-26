package com.kwad.sdk.live.mode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class LiveInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
    public static final long serialVersionUID = -6382708726460249425L;
    public String audienceCount;
    public String caption;
    public String exp_tag;
    public String liveStreamId;
    public transient String pcursor;
    public String playInfo;
    public User user = new User();
    public List<CoverThumbnailUrl> cover_thumbnail_urls = new ArrayList();

    /* loaded from: classes6.dex */
    public static class CoverThumbnailUrl extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static final long serialVersionUID = -9411857293708312L;
        public String cdn;
        public String url;
        public String urlPattern;
    }

    /* loaded from: classes6.dex */
    public static class User extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static final long serialVersionUID = 8394855164198099170L;
        public List<HeadUrl> headurls = new ArrayList();
        public long user_id;
        public String user_name;

        /* loaded from: classes6.dex */
        public static class HeadUrl extends com.kwad.sdk.core.response.a.a implements Serializable {
            public static final long serialVersionUID = 7710129978455547652L;
            public String cdn;
            public String url;
        }
    }
}
