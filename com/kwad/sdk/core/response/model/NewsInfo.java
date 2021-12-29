package com.kwad.sdk.core.response.model;

import com.kwad.sdk.core.response.model.PhotoInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class NewsInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    public static final long serialVersionUID = 2846473099852025182L;
    public String content;
    public int contentSourceType;
    public long photoId;
    public long publishTimestamp;
    public String templateUrl;
    public String title;
    public PhotoInfo.AuthorInfo authorInfo = new PhotoInfo.AuthorInfo();
    public List<ImageInfo> imageInfo = new ArrayList();
    public List<ImageInfo> thumbnailInfo = new ArrayList();

    /* loaded from: classes3.dex */
    public static class ImageInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = 4257305450674055184L;
        public int height;
        public String origin;
        public String url;
        public int width;
    }
}
