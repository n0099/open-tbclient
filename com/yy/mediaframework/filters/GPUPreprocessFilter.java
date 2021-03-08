package com.yy.mediaframework.filters;

import android.opengl.GLES20;
import com.yy.mediaframework.Constant;
import com.yy.mediaframework.ITextureListener;
import com.yy.mediaframework.gles.EglFactory;
import com.yy.mediaframework.gpuimage.FilterType;
import com.yy.mediaframework.gpuimage.GPUImageFilter;
import com.yy.mediaframework.gpuimage.custom.GPUImageFiltersManager;
import com.yy.mediaframework.gpuimage.custom.IGPUProcess;
import com.yy.mediaframework.gpuimage.util.Rotation;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.model.YYMediaSampleAlloc;
import com.yy.mediaframework.sensor.RotationVectorSensor;
import com.yy.mediaframework.stat.YMFLiveStatisticManager;
import com.yy.mediaframework.utils.YMFLog;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class GPUPreprocessFilter extends AbstractYYMediaFilter {
    private VideoLiveFilterContext mFilterContext;
    private GPUImageFiltersManager mGPUImageFiltersManager;
    private RotationVectorSensor mRotationVectorSensor;
    private AtomicBoolean mInited = new AtomicBoolean(false);
    private long mCurrentFrameTimeStampNanos = 0;
    YYMediaSample mPeripheralsSample = null;
    private boolean onPeripheralsStarted = false;
    private ITextureListener mTextureListener = null;

    public GPUPreprocessFilter(VideoLiveFilterContext videoLiveFilterContext) {
        this.mFilterContext = null;
        this.mRotationVectorSensor = null;
        this.mFilterContext = videoLiveFilterContext;
        this.mRotationVectorSensor = this.mFilterContext.getRotationVectorSensor();
        this.mGPUImageFiltersManager = new GPUImageFiltersManager(this.mFilterContext.getAndroidContext(), this.mRotationVectorSensor, videoLiveFilterContext);
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter, com.yy.mediaframework.IMediaFilter
    public boolean processMediaSample(YYMediaSample yYMediaSample, Object obj) {
        if (this.mInited.get()) {
            if (yYMediaSample.mAndoridPtsNanos <= this.mCurrentFrameTimeStampNanos && this.mCurrentFrameTimeStampNanos != 0 && !(obj instanceof PeripheralsDecoderFilter) && !(obj instanceof ExternalDecoderFilter)) {
                YMFLog.info(this, "[Preproce]", "same timeStamp skipping:" + yYMediaSample.mAndoridPtsNanos + "," + this.mCurrentFrameTimeStampNanos);
            } else if ((obj instanceof PeripheralsDecoderFilter) && !((PeripheralsDecoderFilter) obj).isPeripheraHasEnd()) {
                if (this.mPeripheralsSample == null) {
                    this.mPeripheralsSample = new YYMediaSample();
                    this.mPeripheralsSample.reset();
                }
                if (yYMediaSample.mMasterTextureId != -1) {
                    this.mPeripheralsSample.assigne(yYMediaSample);
                }
                this.onPeripheralsStarted = true;
                this.mFilterContext.setLiveMode(LiveSessionType.LIVE_MODE_PERIPHERALS);
            } else {
                this.mCurrentFrameTimeStampNanos = yYMediaSample.mAndoridPtsNanos;
                yYMediaSample.addRef();
                long currentTimeMillis = System.currentTimeMillis();
                int i = yYMediaSample.mWidth;
                int i2 = yYMediaSample.mHeight;
                if (this.mFilterContext.getLiveMode() == LiveSessionType.LIVE_MODE_PERIPHERALS || this.mFilterContext.getLiveMode() == LiveSessionType.LIVE_MODE_EXTERNAL) {
                    i = yYMediaSample.mEncodeWidth;
                    i2 = yYMediaSample.mEncodeHeight;
                }
                if (this.mPeripheralsSample != null && this.mPeripheralsSample.mMasterTextureId != -1) {
                    if (yYMediaSample.mWidth < yYMediaSample.mHeight) {
                        this.mGPUImageFiltersManager.setImageSize(yYMediaSample.mHeight, yYMediaSample.mWidth);
                    }
                    this.mFilterContext.mPeripheralsPosition.srcWidth = this.mPeripheralsSample.mWidth;
                    this.mFilterContext.mPeripheralsPosition.srcHeight = this.mPeripheralsSample.mHeight;
                    if (yYMediaSample.mEncodeWidth < yYMediaSample.mEncodeHeight) {
                        i = yYMediaSample.mEncodeHeight;
                        i2 = yYMediaSample.mEncodeWidth;
                        yYMediaSample.mEncodeWidth = i;
                        yYMediaSample.mEncodeHeight = i2;
                        this.mFilterContext.getVideoEncoderConfig().setEncodeSize(yYMediaSample.mEncodeWidth, yYMediaSample.mEncodeHeight);
                    }
                } else {
                    this.mGPUImageFiltersManager.setImageSize(yYMediaSample.mWidth, yYMediaSample.mHeight);
                }
                this.mGPUImageFiltersManager.setOutputSize(i, i2);
                setOutputSize(i, i2);
                if (this.mFilterContext.getDynamicTexture() != null) {
                    this.mFilterContext.getDynamicTexture().onDoFrame();
                }
                GLES20.glViewport(0, 0, i, i2);
                this.mGPUImageFiltersManager.setTextureType(yYMediaSample.mTextureTarget);
                this.mGPUImageFiltersManager.onDraw(yYMediaSample.mMasterTextureId, yYMediaSample.mMainTransformer, yYMediaSample.mDataBytes, yYMediaSample.mIndex);
                if (this.mFilterContext.getLiveMode() == LiveSessionType.LIVE_MODE_PERIPHERALS) {
                    this.mFilterContext.mCameraPostion.srcWidth = yYMediaSample.mWidth;
                    this.mFilterContext.mCameraPostion.srcHeight = yYMediaSample.mHeight;
                    yYMediaSample.mSlaveTextureId = this.mPeripheralsSample.mMasterTextureId;
                    yYMediaSample.mSlaveTransformer = this.mPeripheralsSample.mMainTransformer;
                }
                yYMediaSample.mMasterTextureId = this.mGPUImageFiltersManager.getLastTextureID();
                yYMediaSample.mTextureTarget = 3553;
                yYMediaSample.mWidth = this.mOutputWidth;
                yYMediaSample.mHeight = this.mOutputHeight;
                if (this.mTextureListener != null) {
                    yYMediaSample.mMasterTextureId = this.mTextureListener.onTextureCallback(yYMediaSample.mMasterTextureId, yYMediaSample.mWidth, yYMediaSample.mHeight);
                }
                GLES20.glBindFramebuffer(36160, 0);
                System.arraycopy(Constant.mtxIdentity, 0, yYMediaSample.mMainTransformer, 0, yYMediaSample.mMainTransformer.length);
                YMFLiveStatisticManager.getInstance().calcPreProcessLatency(currentTimeMillis);
                deliverToDownStream(yYMediaSample);
                yYMediaSample.decRef();
            }
        }
        return false;
    }

    public void init(int i, int i2) {
        YMFLog.info(this, "[Preproce]", "GPUPreprocessFilter doInit");
        if (this.mInited.get()) {
            YMFLog.info(this, "[Preproce]", "init: intialized state now, so return");
            return;
        }
        setOutputSize(i, i2);
        this.mGPUImageFiltersManager.Init(i, i2);
        this.mGPUImageFiltersManager.setRotation(Rotation.NORMAL, false, false);
        this.mInited.set(true);
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter
    public void deInit() {
        if (!this.mInited.getAndSet(false)) {
            YMFLog.info(this, "[Preproce]", "deInit: no Initialied state now, so return");
            return;
        }
        YMFLog.info(this, "[Preproce]", "GPUPreprocessFilter deInit");
        this.mGPUImageFiltersManager.destroy();
    }

    public void setGPUImageFilter(GPUImageFilter gPUImageFilter) {
        if (this.mGPUImageFiltersManager != null) {
            this.mGPUImageFiltersManager.setGPUImageFilter(gPUImageFilter);
        }
    }

    public void clearGPUImageFilters() {
        if (this.mGPUImageFiltersManager != null) {
            this.mGPUImageFiltersManager.resetGPUImageFilter();
        }
    }

    public void setFilterType(FilterType filterType) {
        if (filterType == FilterType.BeautyFace && !EglFactory.android_opengl_egl_support()) {
            YMFLog.info(this, "[Beauty  ]", "STBeautyFilter as to BeautyFace type when android api below 17!!");
            filterType = FilterType.STBeauty;
        }
        if (this.mGPUImageFiltersManager != null) {
            this.mGPUImageFiltersManager.setFilterType(filterType);
        }
    }

    public void setFilterInfo(FilterType filterType, Map<String, String> map) {
        if (filterType == FilterType.BeautyFace && !EglFactory.android_opengl_egl_support()) {
            YMFLog.info(this, "[Beauty  ]", "STBeautyFilter as to BeautyFace type when android api below 17!!");
            setFilterType(FilterType.STBeauty);
        } else {
            setFilterType(filterType);
        }
        setFilterParams(map);
    }

    private void setFilterParams(Map<String, String> map) {
        if (this.mGPUImageFiltersManager != null) {
            this.mGPUImageFiltersManager.setFilterParams(map);
        }
    }

    public void onPeripheralsVideoEnd() {
        YMFLog.info(this, "[Decoder ]", "onPeripheralsVideoEnd");
        this.onPeripheralsStarted = false;
        this.mFilterContext.setLiveMode(LiveSessionType.LIVE_MODE_NORMAL);
        if (this.mPeripheralsSample != null) {
            this.mPeripheralsSample.reset();
            YYMediaSampleAlloc.instance().free(this.mPeripheralsSample);
            this.mPeripheralsSample = null;
        }
    }

    public void setGPUImageBeautyFilter(IGPUProcess iGPUProcess) {
        if (this.mGPUImageFiltersManager != null && this.mGPUImageFiltersManager.getGpuImageBeautyControl() != null) {
            YMFLog.info(this, "[Beauty  ]", "setGPUImageBeautyFilter:" + iGPUProcess);
            this.mGPUImageFiltersManager.getGpuImageBeautyControl().setGPUImageBeautyFilter(iGPUProcess);
            if (!this.mFilterContext.getGLManager().checkSameThread()) {
                this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.filters.GPUPreprocessFilter.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (GPUPreprocessFilter.this.mGPUImageFiltersManager != null) {
                            GPUPreprocessFilter.this.mGPUImageFiltersManager.checkFilterUpdate(true);
                        }
                    }
                });
            } else if (this.mGPUImageFiltersManager != null) {
                this.mGPUImageFiltersManager.checkFilterUpdate(true);
            }
        }
    }

    public void setTextureListener(ITextureListener iTextureListener) {
        this.mTextureListener = iTextureListener;
    }
}
