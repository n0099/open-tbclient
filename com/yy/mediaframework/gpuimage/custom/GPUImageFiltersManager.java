package com.yy.mediaframework.gpuimage.custom;

import android.content.Context;
import com.baidu.searchbox.perfframe.basic.PerfFrameTrackUIUtil;
import com.yy.mediaframework.filters.VideoLiveFilterContext;
import com.yy.mediaframework.gles.GlUtil;
import com.yy.mediaframework.gpuimage.FilterType;
import com.yy.mediaframework.gpuimage.GPUImageBilateralFilter;
import com.yy.mediaframework.gpuimage.GPUImageFilter;
import com.yy.mediaframework.gpuimage.GPUImageFilterGroup;
import com.yy.mediaframework.gpuimage.GPUImageMagicBeautyFilter;
import com.yy.mediaframework.gpuimage.GPUImageMagicBeautyNewFilter;
import com.yy.mediaframework.gpuimage.GPUImageSingleFilter;
import com.yy.mediaframework.gpuimage.IFilterParams;
import com.yy.mediaframework.gpuimage.util.Rotation;
import com.yy.mediaframework.gpuimage.util.TextureRotationUtil;
import com.yy.mediaframework.sensor.RotationVectorSensor;
import com.yy.mediaframework.utils.YMFLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class GPUImageFiltersManager {
    private static final String TAG = "GPUImageFiltersManager";
    private Context mAppContext;
    private FloatBuffer mGLTextureBuffer;
    private Rotation mRotation;
    private RotationVectorSensor mRvSensor;
    private final FloatBuffer mSlaveVertexBuffer;
    private final FloatBuffer mSlaveVertexBuffer2;
    private VideoLiveFilterContext mVideoLiveFilterContext;
    static final float[] CUBE = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private static float factor = 1.0f;
    static final float[] SLAVE_VEX_RIGHT_BOTTOM2 = {-1.0f, factor, factor, factor, -1.0f, 1.0f, factor, 1.0f};
    static final float[] SLAVE_VEX_RIGHT_BOTTOM = {factor, -1.0f, 1.0f, -1.0f, factor, 1.0f, 1.0f, 1.0f};
    private int mOutputWidth = 64;
    private int mOutputHeight = 64;
    private int mImageWidth = 0;
    private int mImageHeight = 0;
    private boolean mImageScaleUpdate = true;
    private boolean mIsInitialized = false;
    GPUImageFilter mGPUImageFilter = null;
    GPUImageBeautyControl gpuImageBeautyControl = null;
    private FilterType mCurrentFilterType = FilterType.Normal;
    private FilterType mTargetFilterType = FilterType.Normal;
    private Map<String, String> mCurrentFilterParams = new HashMap();
    private Map<String, String> mTargetFilterParams = null;
    private boolean mFlipHorizontal = false;
    private boolean mFlipVertical = false;
    private int mTextureTarget = 36197;
    private GPUImageBeautyControl mGPUImageBeautyControl = new GPUImageBeautyControl();
    private final FloatBuffer mMasterVertexBuffer = ByteBuffer.allocateDirect(CUBE.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();

    public GPUImageFiltersManager(Context context, RotationVectorSensor rotationVectorSensor, VideoLiveFilterContext videoLiveFilterContext) {
        this.mRotation = Rotation.NORMAL;
        this.mAppContext = null;
        this.mMasterVertexBuffer.put(CUBE).position(0);
        this.mSlaveVertexBuffer = ByteBuffer.allocateDirect(SLAVE_VEX_RIGHT_BOTTOM.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mSlaveVertexBuffer.put(SLAVE_VEX_RIGHT_BOTTOM).position(0);
        this.mSlaveVertexBuffer2 = ByteBuffer.allocateDirect(SLAVE_VEX_RIGHT_BOTTOM2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mSlaveVertexBuffer2.put(SLAVE_VEX_RIGHT_BOTTOM2).position(0);
        this.mGLTextureBuffer = ByteBuffer.allocateDirect(TextureRotationUtil.FULL_RECTANGLE_TEX_COORDS.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mGLTextureBuffer.put(TextureRotationUtil.TEXTURE_NO_ROTATION).position(0);
        this.mRotation = Rotation.NORMAL;
        this.mVideoLiveFilterContext = videoLiveFilterContext;
        this.mAppContext = context;
        this.mRvSensor = rotationVectorSensor;
    }

    public FloatBuffer GetCubeBuffer() {
        return this.mMasterVertexBuffer;
    }

    public FloatBuffer GetTextureBuffer() {
        return this.mGLTextureBuffer;
    }

    public boolean Init(int i, int i2) {
        this.mIsInitialized = true;
        this.mOutputHeight = i2;
        this.mOutputWidth = i;
        resetGPUImageFilter();
        return true;
    }

    public void destroy() {
        if (this.mGPUImageFilter != null) {
            this.mGPUImageFilter.destroy();
            this.mGPUImageFilter = null;
        }
    }

    public void resetGPUImageFilter() {
        if (this.mGPUImageFilter != null) {
            this.mGPUImageFilter.destroy();
            this.mGPUImageFilter = null;
        }
        setGPUImageFilter(new GPUImageFilter());
    }

    public void setImageSize(int i, int i2) {
        this.mImageScaleUpdate = (this.mImageWidth == i && this.mImageHeight == i2) ? false : true;
        this.mImageWidth = i;
        this.mImageHeight = i2;
    }

    public void setRotation(Rotation rotation) {
        this.mRotation = rotation;
        fixImageCrop();
    }

    public void setRotation(Rotation rotation, boolean z, boolean z2) {
        this.mFlipHorizontal = z;
        this.mFlipVertical = z2;
        setRotation(rotation);
    }

    public Rotation getRotation() {
        return this.mRotation;
    }

    public boolean isFlippedHorizontally() {
        return this.mFlipHorizontal;
    }

    public boolean isFlippedVertically() {
        return this.mFlipVertical;
    }

    private void fixImageCrop() {
        float[] rotation = TextureRotationUtil.getRotation(this.mRotation, this.mFlipHorizontal, this.mFlipVertical);
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(TextureRotationUtil.FULL_RECTANGLE_TEX_COORDS.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        asFloatBuffer.put(rotation).position(0);
        YMFLog.info(this, "[Beauty  ]", "fixImageCrop mImageWidth:%d, mImageHeight:%d, mOutputWidth:%d, mOutputHeight:%d", Integer.valueOf(this.mImageWidth), Integer.valueOf(this.mImageHeight), Integer.valueOf(this.mOutputWidth), Integer.valueOf(this.mOutputHeight));
        this.mGLTextureBuffer = GlUtil.adjustTexture(asFloatBuffer, this.mImageWidth, this.mImageHeight, this.mOutputWidth, this.mOutputHeight);
    }

    public void checkTextureTypeUpdate(int i) {
        if (this.mGPUImageFilter != null && (this.mGPUImageFilter instanceof GPUImageSingleFilter)) {
            ((GPUImageSingleFilter) this.mGPUImageFilter).checkTextureTypeUpdate(i);
        }
    }

    public void setGPUImageFilter(GPUImageFilter gPUImageFilter) {
        if (gPUImageFilter != null) {
            if (this.mGPUImageFilter != null) {
                this.mGPUImageFilter.destroy();
            }
            if (gPUImageFilter instanceof GPUImageFilterGroup) {
                this.mGPUImageFilter = gPUImageFilter;
            } else {
                this.mGPUImageFilter = new GPUImageSingleFilter(gPUImageFilter);
            }
            this.mGPUImageFilter.enable2DTextureDraw(this.mVideoLiveFilterContext.isYuvTextureMode());
            this.mGPUImageFilter.init();
            this.mGPUImageFilter.onOutputSizeChanged(this.mOutputWidth, this.mOutputHeight);
        }
    }

    public GPUImageFilter getCurrentGPUImageFilter() {
        if (this.mGPUImageFilter != null && (this.mGPUImageFilter instanceof GPUImageFilterGroup)) {
            return this.mGPUImageFilter;
        }
        if (this.mGPUImageFilter != null) {
            return ((GPUImageSingleFilter) this.mGPUImageFilter).getGPUImageFilter();
        }
        return null;
    }

    public GPUImageBeautyControl getGpuImageBeautyControl() {
        return this.mGPUImageBeautyControl;
    }

    public void setOutputSize(int i, int i2) {
        if (this.mOutputWidth != i || this.mOutputHeight != i2) {
            if (this.mGPUImageFilter != null) {
                this.mGPUImageFilter.onOutputSizeChanged(i, i2);
            }
            this.mImageScaleUpdate = true;
            this.mOutputWidth = i;
            this.mOutputHeight = i2;
        }
    }

    public void setTextureType(int i) {
        this.mTextureTarget = i;
    }

    public void onDraw(int i, float[] fArr, byte[] bArr, long j) {
        onDraw(i, fArr, this.mMasterVertexBuffer, false, bArr, j);
    }

    public void onDraw(int i, float[] fArr, FloatBuffer floatBuffer, boolean z, byte[] bArr, long j) {
        if (!checkFloatBufferState(this.mGLTextureBuffer)) {
            this.mGLTextureBuffer.put(TextureRotationUtil.TEXTURE_NO_ROTATION).position(0);
        }
        onDraw(i, fArr, floatBuffer, this.mGLTextureBuffer, z, bArr, j);
    }

    public void onDraw(int i, float[] fArr, FloatBuffer floatBuffer, FloatBuffer floatBuffer2, boolean z, byte[] bArr, long j) {
        onDraw(i, fArr, floatBuffer, floatBuffer2, z, false, bArr, j);
    }

    public void onDraw(int i, float[] fArr, FloatBuffer floatBuffer, FloatBuffer floatBuffer2, boolean z, boolean z2, byte[] bArr, long j) {
        if (this.mImageScaleUpdate) {
            fixImageCrop();
            this.mImageScaleUpdate = false;
        }
        checkFilterUpdate(false);
        checkTextureTypeUpdate(this.mTextureTarget);
        if (this.mGPUImageFilter != null) {
            this.mGPUImageFilter.onDraw(i, z ? GlUtil.setFlipY(floatBuffer) : floatBuffer, floatBuffer2, 3553, fArr, z2, bArr, j);
        }
    }

    private boolean checkFloatBufferState(FloatBuffer floatBuffer) {
        if (floatBuffer == null) {
            return false;
        }
        for (int i = 0; i < floatBuffer.limit(); i++) {
            float f = floatBuffer.get(i);
            if (f == Float.NEGATIVE_INFINITY || f == Float.POSITIVE_INFINITY) {
                YMFLog.error(this, "[Beauty  ]", "checkFloatBuffer i:" + i + "temp:" + f + " FloatBuffer not Invalid !!! ");
                return false;
            }
        }
        floatBuffer.rewind();
        return true;
    }

    public int getLastTextureID() {
        return this.mGPUImageFilter.getLastTextureID();
    }

    public boolean isInitialized() {
        return this.mIsInitialized;
    }

    public void setFilterType(FilterType filterType) {
        YMFLog.info(this, "[Beauty  ]", "set FilterType:" + filterType);
        this.mTargetFilterType = filterType;
    }

    public void setFilterParams(Map<String, String> map) {
        if (map == null) {
            YMFLog.error(TAG, "[Beauty  ]", "invalid params");
        } else {
            this.mTargetFilterParams = new HashMap(map);
        }
    }

    public void checkFilterUpdate(boolean z) {
        if (z) {
            YMFLog.info(this, "[Beauty  ]", "check GPUImageFilter update:" + this.mCurrentFilterType + " -> " + this.mTargetFilterType);
            destroy();
            GPUImageFilter filter = getFilter(this.mTargetFilterType);
            setGPUImageFilter(filter);
            this.mCurrentFilterType = this.mTargetFilterType;
            if ((filter instanceof IFilterParams) && this.mCurrentFilterParams != null) {
                ((IFilterParams) filter).setFilterParams(this.mCurrentFilterParams);
            }
        } else if (this.mCurrentFilterType != this.mTargetFilterType) {
            YMFLog.info(this, "[Beauty  ]", "check GPUImageFilter update:" + this.mCurrentFilterType + " -> " + this.mTargetFilterType);
            destroy();
            GPUImageFilter filter2 = getFilter(this.mTargetFilterType);
            setGPUImageFilter(filter2);
            this.mCurrentFilterType = this.mTargetFilterType;
            if ((filter2 instanceof IFilterParams) && this.mCurrentFilterParams != null) {
                ((IFilterParams) filter2).setFilterParams(this.mCurrentFilterParams);
            }
        }
        GPUImageFilter currentGPUImageFilter = getCurrentGPUImageFilter();
        if (currentGPUImageFilter != null && (currentGPUImageFilter instanceof IFilterParams) && this.mCurrentFilterParams != this.mTargetFilterParams) {
            YMFLog.info(this, "[Beauty  ]", " STBeauty check GPUImageFilter params update:" + this.mCurrentFilterParams + PerfFrameTrackUIUtil.SEPERATOR_ARROR + this.mTargetFilterParams);
            if (this.mTargetFilterParams != null) {
                ((IFilterParams) currentGPUImageFilter).setFilterParams(this.mTargetFilterParams);
            }
            this.mCurrentFilterParams = this.mTargetFilterParams;
        }
        if (currentGPUImageFilter != null && (currentGPUImageFilter instanceof GPUImageBeautyFilter)) {
            currentGPUImageFilter.onBeautyParamChanged();
        }
    }

    public GPUImageFilter getFilter(FilterType filterType) {
        switch (filterType) {
            case SkinBeauty:
                return new GPUImageBilateralFilter();
            case MagicBeauty:
                return new GPUImageMagicBeautyFilter();
            case MagicBeautyLow:
                return new GPUImageMagicBeautyFilter(true);
            case MagicBeautyNew:
                return new GPUImageMagicBeautyNewFilter();
            case MagicBeautyNewLow:
                return new GPUImageMagicBeautyNewFilter(true);
            case BeautyFace:
                return new GPUImageBeautyFilter(this.mRvSensor, this.mGPUImageBeautyControl);
            default:
                return new GPUImageFilter();
        }
    }
}
