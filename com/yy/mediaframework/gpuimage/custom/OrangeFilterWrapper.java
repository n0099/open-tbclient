package com.yy.mediaframework.gpuimage.custom;

import com.yy.mediaframework.VideoLiveSessionYCloud;
import com.yy.mediaframework.gpuimage.FilterType;
import com.yy.mediaframework.gpuimage.util.GLTexture;
import com.yy.mediaframework.utils.YMFLog;
/* loaded from: classes6.dex */
public class OrangeFilterWrapper {
    public static final String TAG = "OrangeFilterWrapper";
    private VideoLiveSessionYCloud mVideoLiveSessionYCloud;

    public void setVideoLiveSessionYCloud(VideoLiveSessionYCloud videoLiveSessionYCloud) {
        YMFLog.info(this, "[Beauty  ]", "setVideoLiveSessionYCloud:" + videoLiveSessionYCloud);
        this.mVideoLiveSessionYCloud = videoLiveSessionYCloud;
    }

    public static void checkTextureId(GLTexture gLTexture, GLTexture gLTexture2) {
        if (((gLTexture2 != null) & (gLTexture != null)) && gLTexture.getTextureId() == gLTexture2.getTextureId()) {
            YMFLog.error((Object) null, "[Beauty  ]", "error, orangefilter need diff..");
        }
    }

    public static void swap(GLTexture gLTexture, GLTexture gLTexture2) {
        int textureId = gLTexture.getTextureId();
        gLTexture.setTextureId(gLTexture2.getTextureId());
        gLTexture2.setTextureId(textureId);
    }

    public void setFilterType(FilterType filterType) {
        if (this.mVideoLiveSessionYCloud != null) {
            this.mVideoLiveSessionYCloud.setFilterType(filterType);
        }
    }
}
