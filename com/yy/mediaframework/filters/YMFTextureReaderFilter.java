package com.yy.mediaframework.filters;

import com.yy.mediaframework.gpuimage.adapter.GlTextureImageReader;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.utils.YMFLog;
/* loaded from: classes6.dex */
public class YMFTextureReaderFilter extends AbstractYYMediaFilter {
    private static final String TAG = "YMFTextureReaderFilter";
    private VideoLiveFilterContext mFilterContext;
    private GlTextureImageReader mGlImageReader;
    private int mHeight;
    private int mWidth;

    public YMFTextureReaderFilter(VideoLiveFilterContext videoLiveFilterContext) {
        this.mFilterContext = videoLiveFilterContext;
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter, com.yy.mediaframework.IMediaFilter
    public boolean processMediaSample(YYMediaSample yYMediaSample, Object obj) {
        if (yYMediaSample.mMasterTextureId < 0 || yYMediaSample.mTextureTarget != 3553) {
            return false;
        }
        yYMediaSample.addRef();
        if (this.mGlImageReader == null || this.mWidth != yYMediaSample.mWidth || this.mHeight != yYMediaSample.mHeight) {
            if (this.mGlImageReader != null) {
                this.mGlImageReader.destroy();
            }
            this.mGlImageReader = new GlTextureImageReader(this.mFilterContext.getAndroidContext(), yYMediaSample.mWidth, yYMediaSample.mHeight);
            this.mWidth = yYMediaSample.mWidth;
            this.mHeight = yYMediaSample.mHeight;
        }
        byte[] read = this.mGlImageReader.read(yYMediaSample.mMasterTextureId, yYMediaSample.mWidth, yYMediaSample.mHeight);
        if (read == null) {
            YMFLog.error(this, "[Util    ]", " GlImageReader read failed .");
            yYMediaSample.decRef();
            return false;
        }
        yYMediaSample.mRGBABytes = read;
        yYMediaSample.mImageFormat = 36;
        deliverToDownStream(yYMediaSample);
        yYMediaSample.decRef();
        return true;
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter
    public void deInit() {
        super.deInit();
        if (this.mGlImageReader != null) {
            this.mGlImageReader.destroy();
            this.mGlImageReader = null;
        }
    }
}
