package com.yy.mediaframework.filters;

import android.view.SurfaceView;
import com.yy.mediaframework.Constant;
import com.yy.mediaframework.base.VideoEncoderType;
import com.yy.mediaframework.gpuimage.custom.IGPUProcess;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.opengles.YMFPreviewCanvasView;
import com.yy.mediaframework.opengles.YMFPreviewView;
import com.yy.mediaframework.utils.YMFLog;
/* loaded from: classes4.dex */
public class YMFProcessGroupFilter extends AbstractYYMediaFilter {
    private static final String TAG = "YMFProcessGroupFilter";
    private VideoLiveFilterContext mFilterContext;
    private YMFI420ScaleFilter mI420ScaleFilter;
    private YMFNV21ToABGRFilter mNV21ToABGRFilter;
    private YMFNV21ToI420Filter mNv21ToI420Filter;
    private YMFNV21ToTextureFilter mNv21ToTextureFilter;
    private YMFPaletteFilter mPaletteFilter;
    private YMFPreEncodedFormatConvertFilter mPreEncodedFormatConvertFilter;
    private YMFPreviewCanvasView mPreviewCanvasView;
    private YMFPreviewView mPreviewGLFilter;
    private AbstractYYMediaFilter mStartFilter;
    private YMFTextureCallbackFilter mTextureCallbackFilter;
    private YMFTextureReaderFilter mTextureReaderPreviewFilter;
    private YMFABGRScaleFilter mYMFABGRScaleFilter;
    private YMFBitmapWaterMarkFilter mYMFBitmapWaterMarkFilter;
    private boolean mHasTextureProcess = false;
    private boolean mHasWaterMark = false;
    private Constant.ScaleMode mScaleMode = Constant.ScaleMode.AspectFit;
    public VideoEncoderType mEncodeType = VideoEncoderType.HARD_ENCODER_H264;

    public YMFProcessGroupFilter(VideoLiveFilterContext videoLiveFilterContext) {
        this.mStartFilter = new YMFEmptyFilter(videoLiveFilterContext);
        this.mPaletteFilter = new YMFPaletteFilter(videoLiveFilterContext);
        this.mNv21ToI420Filter = new YMFNV21ToI420Filter(videoLiveFilterContext);
        this.mI420ScaleFilter = new YMFI420ScaleFilter(videoLiveFilterContext);
        this.mPreEncodedFormatConvertFilter = new YMFPreEncodedFormatConvertFilter(videoLiveFilterContext);
        this.mYMFBitmapWaterMarkFilter = new YMFBitmapWaterMarkFilter(videoLiveFilterContext);
        this.mNv21ToTextureFilter = new YMFNV21ToTextureFilter(videoLiveFilterContext);
        this.mTextureCallbackFilter = new YMFTextureCallbackFilter(videoLiveFilterContext);
        this.mTextureReaderPreviewFilter = new YMFTextureReaderFilter(videoLiveFilterContext);
        this.mYMFABGRScaleFilter = new YMFABGRScaleFilter(videoLiveFilterContext);
        this.mNV21ToABGRFilter = new YMFNV21ToABGRFilter(videoLiveFilterContext);
        this.mFilterContext = videoLiveFilterContext;
        initFilters(this.mHasTextureProcess);
    }

    public void setPreviewView(SurfaceView surfaceView) {
        if (this.mFilterContext.isUseGLSurfaceView()) {
            if (surfaceView instanceof YMFPreviewView) {
                this.mPreviewGLFilter = (YMFPreviewView) surfaceView;
            } else {
                YMFLog.error(this, "[Preview ]", "need YMFPreviewView. ");
            }
            if (this.mPreviewGLFilter != null) {
                this.mPreviewGLFilter.setVideoFilterContext(this.mFilterContext);
                this.mFilterContext.setWaterMarkUpdateCB(this.mPreviewGLFilter);
                this.mPreviewGLFilter.setScaleMode(this.mScaleMode);
            }
        } else if (this.mFilterContext.isUseCanvasSurfaceView()) {
            if (surfaceView instanceof YMFPreviewCanvasView) {
                this.mPreviewCanvasView = (YMFPreviewCanvasView) surfaceView;
            } else {
                YMFLog.error(this, "[Preview ]", "need mPreviewCanvasView. ");
            }
            if (this.mPreviewCanvasView != null) {
                this.mPreviewCanvasView.setVideoLiveFilterContext(this.mFilterContext);
                this.mPreviewCanvasView.setScaleMode(this.mScaleMode);
            }
        }
        if (this.mPreviewGLFilter != null || this.mPreviewCanvasView != null) {
            this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.filters.YMFProcessGroupFilter.1
                @Override // java.lang.Runnable
                public void run() {
                    YMFProcessGroupFilter.this.initFilters(YMFProcessGroupFilter.this.mHasTextureProcess);
                }
            });
        }
        YMFLog.info(this, "[Preview ]", "setPreviewView finish.");
    }

    public void reSetPreviewState() {
        if (this.mPreviewCanvasView != null) {
            this.mPreviewCanvasView.reSetPreviewState();
        }
        if (this.mPreviewGLFilter != null) {
            this.mPreviewGLFilter.reSetPreviewState();
        }
    }

    public void setGpuProcess(IGPUProcess iGPUProcess) {
        if (this.mFilterContext != null) {
            this.mFilterContext.mHasBeautyProcess = iGPUProcess != null;
            YMFLog.info(this, "[Preview ]", "setGpuProcess " + this.mFilterContext.mHasBeautyProcess);
        }
        if (this.mTextureCallbackFilter != null) {
            this.mTextureCallbackFilter.setGpuProcess(iGPUProcess);
        }
    }

    public void drawBlackScreen(boolean z) {
        YMFLog.info(this, "[Preview ]", "drawBlackScreen " + z);
        if (this.mPreviewGLFilter != null) {
            this.mPreviewGLFilter.drawBlackScreen(z);
        }
        if (this.mPreviewCanvasView != null) {
            this.mPreviewCanvasView.drawBlackScreen(z);
        }
    }

    public void setScaleMode(Constant.ScaleMode scaleMode) {
        this.mScaleMode = scaleMode;
        if (this.mPreviewGLFilter != null) {
            this.mPreviewGLFilter.setScaleMode(this.mScaleMode);
        }
        if (this.mPreviewCanvasView != null) {
            this.mPreviewCanvasView.setScaleMode(this.mScaleMode);
        }
    }

    private void resetFilters() {
        this.mStartFilter.removeAllDownStream();
        this.mPaletteFilter.removeAllDownStream();
        this.mNv21ToI420Filter.removeAllDownStream();
        this.mI420ScaleFilter.removeAllDownStream();
        this.mPreEncodedFormatConvertFilter.removeAllDownStream();
        this.mTextureReaderPreviewFilter.removeAllDownStream();
        this.mTextureCallbackFilter.removeAllDownStream();
        this.mYMFBitmapWaterMarkFilter.removeAllDownStream();
        this.mNv21ToTextureFilter.removeAllDownStream();
        this.mYMFABGRScaleFilter.removeAllDownStream();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initFilters(boolean z) {
        resetFilters();
        if (this.mHasTextureProcess) {
            this.mStartFilter.addDownStream(this.mNv21ToTextureFilter);
            this.mNv21ToTextureFilter.addDownStream(this.mTextureCallbackFilter);
            this.mTextureCallbackFilter.addDownStream(this.mTextureReaderPreviewFilter);
            this.mTextureReaderPreviewFilter.addDownStream(this.mYMFABGRScaleFilter);
            if (this.mPreviewGLFilter != null) {
                this.mYMFABGRScaleFilter.addDownStream(this.mPreviewGLFilter);
            } else if (this.mPreviewCanvasView != null) {
                this.mYMFABGRScaleFilter.addDownStream(this.mPreviewCanvasView);
            }
            this.mYMFABGRScaleFilter.addDownStream(this.mYMFBitmapWaterMarkFilter);
            this.mYMFBitmapWaterMarkFilter.addDownStream(this.mPreEncodedFormatConvertFilter);
        } else {
            this.mStartFilter.addDownStream(this.mNv21ToI420Filter);
            this.mNv21ToI420Filter.addDownStream(this.mI420ScaleFilter);
            if (this.mPreviewGLFilter != null) {
                this.mI420ScaleFilter.addDownStream(this.mPreviewGLFilter);
            } else if (this.mPreviewCanvasView != null) {
                this.mI420ScaleFilter.addDownStream(this.mPreviewCanvasView);
            }
            this.mI420ScaleFilter.addDownStream(this.mYMFBitmapWaterMarkFilter);
            this.mYMFBitmapWaterMarkFilter.addDownStream(this.mPreEncodedFormatConvertFilter);
        }
        this.mEncodeType = this.mFilterContext.getVideoEncoderConfig().mEncodeType;
        YMFLog.info(this, "[Procedur]", "initFilters finish. useGpu:" + z + " waterMark:" + this.mHasWaterMark);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
        if (r4.mHasWaterMark != (r4.mFilterContext.getWatermark() != null)) goto L13;
     */
    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter, com.yy.mediaframework.IMediaFilter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean processMediaSample(YYMediaSample yYMediaSample, Object obj) {
        yYMediaSample.addRef();
        if (this.mHasTextureProcess == yYMediaSample.mUseGPUBeauty && this.mFilterContext.getVideoEncoderConfig().mEncodeType == this.mEncodeType) {
        }
        this.mHasTextureProcess = yYMediaSample.mUseGPUBeauty;
        this.mHasWaterMark = this.mFilterContext.getWatermark() != null;
        initFilters(this.mHasTextureProcess);
        this.mStartFilter.processMediaSample(yYMediaSample, this);
        deliverToDownStream(yYMediaSample);
        yYMediaSample.decRef();
        return false;
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter
    public void deInit() {
        super.deInit();
    }
}
