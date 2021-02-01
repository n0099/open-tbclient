package com.yy.mediaframework.filters;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.yy.mediaframework.ExternalInterface;
import com.yy.mediaframework.decoder.BaseHardwareDecoder;
import com.yy.mediaframework.decoder.H264HardwareDecoder;
import com.yy.mediaframework.gles.GlUtil;
import com.yy.mediaframework.model.DecodeVideoConfig;
import com.yy.mediaframework.model.DecodeVideoSample;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.model.YYMediaSampleAlloc;
import com.yy.mediaframework.utils.YMFLog;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class ExternalDecoderFilter extends AbstractYYMediaFilter implements SurfaceTexture.OnFrameAvailableListener, BaseHardwareDecoder.OnDecoderSizeChangeListener {
    private static final String FILE_PATH_AFTER = "/sdcard/stream_after.264";
    private static final String FILE_PATH_BEFORE = "/sdcard/stream_before.264";
    private static final String TAG = "ExternalDecoderFilter";
    H264HardwareDecoder mH264HardwareDecoder;
    private HandlerThread mHandlerThread;
    private ExternalInterface.IExternalDecode mIExternalDecode;
    private TimerTask mInitiativeTimeTask;
    private long mPts;
    private Surface mRenderSurface;
    private SurfaceTexture mRenderSurfaceTexture;
    VideoLiveFilterContext mVideoLiveFilterContext;
    private Handler mWorkerHandler;
    private static final byte[] header = {0, 0, 0, 1};
    private static final byte[] SYNC_FLAG = new byte[1];
    private int mRenderTextureId = -1;
    private boolean isInited = false;
    private boolean mGetFirstIDR = false;
    private AtomicBoolean onExternalEnd = new AtomicBoolean(true);
    FileOutputStream fos = null;
    private Timer mInitiativeTimer = null;
    private long mTime = 0;
    private boolean mIsDjiIDRFrame = false;
    private LinkedList<Long> mCachedPtsList = new LinkedList<>();
    int frameCount = 0;
    long lastTimestamp = 0;
    long time = 0;
    boolean writen = false;
    int feedFrameCounter = 0;
    long feedCurrentTime = 0;
    long lastPrintTime = 0;
    private DecodeVideoConfig mDecoderConfig = new DecodeVideoConfig();

    public ExternalDecoderFilter(VideoLiveFilterContext videoLiveFilterContext) {
        this.mVideoLiveFilterContext = videoLiveFilterContext;
    }

    private void initWorkerHandler() {
        if (this.mWorkerHandler != null) {
            YMFLog.info(this, "[Decoder ]", "workder handle has already been inited.");
            return;
        }
        this.mHandlerThread = new HandlerThread("YY_yyvideolib_ExternalDecoderFilter_Thread");
        this.mHandlerThread.start();
        this.mWorkerHandler = new Handler(this.mHandlerThread.getLooper());
    }

    private void initInitiativeTimer() {
        if (this.mInitiativeTimer != null) {
            uninitInitiativeTimer();
        }
        this.mInitiativeTimer = new Timer();
        this.mInitiativeTimeTask = new TimerTask() { // from class: com.yy.mediaframework.filters.ExternalDecoderFilter.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                ExternalDecoderFilter.this.mVideoLiveFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.filters.ExternalDecoderFilter.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ExternalDecoderFilter.this.handleFrameAvailable(ExternalDecoderFilter.this.mRenderSurfaceTexture);
                    }
                });
            }
        };
        this.mInitiativeTimer.schedule(this.mInitiativeTimeTask, 0L, 41L);
    }

    private void uninitInitiativeTimer() {
        if (this.mInitiativeTimer != null) {
            this.mInitiativeTimer.cancel();
            this.mInitiativeTimer = null;
        }
        if (this.mInitiativeTimeTask != null) {
            this.mInitiativeTimeTask.cancel();
            this.mInitiativeTimeTask = null;
        }
    }

    private void releaseWorkerHandler() {
        YMFLog.info(this, "[Decoder ]", "releaseWorkerHandler");
        if (this.mWorkerHandler != null) {
            this.mWorkerHandler.removeCallbacksAndMessages(null);
            this.mWorkerHandler = null;
        }
        if (this.mHandlerThread != null) {
            this.mHandlerThread.getLooper().quit();
            this.mHandlerThread = null;
        }
    }

    public void setRenderSurface(Surface surface) {
        this.mRenderSurface = surface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        synchronized (SYNC_FLAG) {
            if (this.mRenderSurface != null) {
                this.mRenderSurface.release();
                this.mRenderSurface = null;
            }
            if (this.mRenderSurfaceTexture != null) {
                this.mRenderSurfaceTexture.setOnFrameAvailableListener(null);
                this.mRenderSurfaceTexture.detachFromGLContext();
                this.mRenderSurfaceTexture.release();
                this.mRenderSurfaceTexture = null;
            }
            if (this.mRenderTextureId >= 0) {
                GLES20.glDeleteTextures(1, new int[]{this.mRenderTextureId}, 0);
            }
            this.isInited = false;
        }
        releaseWorkerHandler();
        uninitInitiativeTimer();
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter
    @TargetApi(16)
    public void deInit() {
        super.deInit();
        if (this.mWorkerHandler != null) {
            if (this.mVideoLiveFilterContext.getGlManager().checkSameThread()) {
                release();
            } else {
                this.mVideoLiveFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.filters.ExternalDecoderFilter.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ExternalDecoderFilter.this.release();
                    }
                });
            }
        }
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter, com.yy.mediaframework.IMediaFilter
    public boolean processMediaSample(YYMediaSample yYMediaSample, Object obj) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(16)
    public void initTextureSurface(int i, int i2) {
        synchronized (SYNC_FLAG) {
            this.mRenderTextureId = GlUtil.createOESTexture();
            this.mRenderSurfaceTexture = new SurfaceTexture(this.mRenderTextureId);
            this.mRenderSurfaceTexture.setOnFrameAvailableListener(this);
            this.mRenderSurface = new Surface(this.mRenderSurfaceTexture);
            this.isInited = true;
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        if (this.onExternalEnd.get()) {
            YMFLog.info(this, "[Decoder ]", "peripherals video end.");
        } else if (this.mInitiativeTimer == null) {
            initInitiativeTimer();
        }
    }

    private void printDecoderRenderFrameRate() {
        this.frameCount++;
        this.time = System.currentTimeMillis();
        if (this.time - this.lastTimestamp > 1000) {
            YMFLog.info(this, "[Decoder ]", "decoder render frame rate:" + this.frameCount);
            this.frameCount = 0;
            this.lastTimestamp = this.time;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFrameAvailable(SurfaceTexture surfaceTexture) {
        if (!this.isInited) {
            YMFLog.warn(this, "[Decoder ]", "not ready.");
            return;
        }
        printDecoderRenderFrameRate();
        surfaceTexture.updateTexImage();
        YYMediaSample alloc = YYMediaSampleAlloc.instance().alloc();
        alloc.mWidth = this.mDecoderConfig.width;
        alloc.mHeight = this.mDecoderConfig.height;
        alloc.mClipWidth = this.mDecoderConfig.width;
        alloc.mClipHeight = this.mDecoderConfig.height;
        alloc.mEncodeWidth = this.mVideoLiveFilterContext.getVideoEncoderConfig().getEncodeWidth();
        alloc.mEncodeHeight = this.mVideoLiveFilterContext.getVideoEncoderConfig().getEncodeHeight();
        alloc.mMasterTextureId = this.mRenderTextureId;
        surfaceTexture.getTransformMatrix(alloc.mMainTransformer);
        this.mVideoLiveFilterContext.mPeripheralsPosition.fillMode = 1;
        alloc.mOrientation = this.mDecoderConfig.width >= this.mDecoderConfig.height ? 2 : 1;
        this.mVideoLiveFilterContext.mPeripheralsOrientation = alloc.mOrientation;
        alloc.mTextureTarget = 36197;
        long j = 0;
        if (this.mCachedPtsList != null && this.mCachedPtsList.size() > 0) {
            j = this.mCachedPtsList.pop().longValue();
        }
        alloc.mYYPtsMillions = j;
        deliverToDownStream(alloc);
        alloc.decRef();
    }

    public void setExternalDecodeInterface(ExternalInterface.IExternalDecode iExternalDecode) {
        this.mIExternalDecode = iExternalDecode;
    }

    public String getFrameTypeStr(DecodeVideoSample decodeVideoSample) {
        switch (decodeVideoSample.frameType) {
            case 0:
                return " I frame";
            case 1:
                return " P frame";
            case 2:
                return " B frame";
            case 3:
                return " SEI ";
            case 4:
                return " IDR ";
            case 5:
                return " SPS ";
            case 6:
                return " PPS ";
            default:
                return "Unknown";
        }
    }

    public void handleOutdoorVideoData(final DecodeVideoSample decodeVideoSample) {
        if (this.mWorkerHandler == null) {
            initWorkerHandler();
        }
        printPeripheralsFeedFrameRate();
        this.mWorkerHandler.post(new Runnable() { // from class: com.yy.mediaframework.filters.ExternalDecoderFilter.3
            @Override // java.lang.Runnable
            public void run() {
                if (decodeVideoSample.width < 0 || decodeVideoSample.height < 0 || decodeVideoSample.data == null || decodeVideoSample.data.length < 0) {
                    YMFLog.info(this, "[Decoder ]", "invalid data params.");
                    decodeVideoSample.decRef();
                } else if (ExternalDecoderFilter.this.mH264HardwareDecoder == null || !ExternalDecoderFilter.this.mH264HardwareDecoder.isInited()) {
                    YMFLog.info(this, "[Decoder ]", "Decoder not ready yet.");
                    decodeVideoSample.decRef();
                } else {
                    if (decodeVideoSample.frameType == 4 || decodeVideoSample.frameType == 0) {
                        ExternalDecoderFilter.this.mVideoLiveFilterContext.setDoHaveReceiveIFrame(true);
                    }
                    if (ExternalDecoderFilter.this.mVideoLiveFilterContext.getDoHaveReceiveIFrame()) {
                        if (!ExternalDecoderFilter.this.mGetFirstIDR) {
                            if (decodeVideoSample.frameType == 0 || decodeVideoSample.frameType == 4) {
                                ExternalDecoderFilter.this.mGetFirstIDR = true;
                            } else {
                                decodeVideoSample.decRef();
                                return;
                            }
                        }
                        if (ExternalDecoderFilter.this.isInited) {
                            ExternalDecoderFilter.this.mPts = ExternalDecoderFilter.this.mH264HardwareDecoder.drainDecoder(decodeVideoSample);
                            ExternalDecoderFilter.this.mCachedPtsList.add(Long.valueOf(ExternalDecoderFilter.this.mPts));
                        }
                        ExternalDecoderFilter.this.onExternalEnd.set(false);
                        return;
                    }
                    YMFLog.info(this, "[Decoder ]", "getDoHaveReceiveIFrame false , continue wait ... ");
                    decodeVideoSample.decRef();
                }
            }
        });
    }

    private void replaceWithStandardStartCode(DecodeVideoSample decodeVideoSample) {
        if (decodeVideoSample.dataLenght > 8) {
            int i = 5;
            while (i > 0 && i <= decodeVideoSample.dataLenght - 4) {
                int i2 = ((decodeVideoSample.data[i + 0] << 24) & ViewCompat.MEASURED_STATE_MASK) | 0 | ((decodeVideoSample.data[i + 1] << 16) & 16711680) | ((decodeVideoSample.data[i + 2] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (decodeVideoSample.data[i + 3] & 255);
                System.arraycopy(header, 0, decodeVideoSample.data, i, 4);
                i = i + 4 + i2;
            }
            System.arraycopy(header, 0, decodeVideoSample.data, 0, 4);
            System.arraycopy(decodeVideoSample.data, 9, decodeVideoSample.data, 4, (decodeVideoSample.dataLenght - 5) - 4);
            decodeVideoSample.dataLenght -= 5;
        }
    }

    private void printPeripheralsFeedFrameRate() {
        this.feedFrameCounter++;
        this.feedCurrentTime = System.currentTimeMillis();
        if (this.feedCurrentTime - this.lastPrintTime > 1000) {
            YMFLog.info(this, "[Decoder ]", "peripherals feed data frame rate:" + this.feedFrameCounter);
            this.feedFrameCounter = 0;
            this.lastPrintTime = this.feedCurrentTime;
        }
    }

    private void saveStreamToFile(String str, byte[] bArr, int i) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(str, true);
            try {
                try {
                    fileOutputStream.write(bArr, 0, i);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        YMFLog.error(this, "[Decoder ]", "close 264 stream exception:" + e);
                    }
                } catch (IOException e2) {
                    e = e2;
                    YMFLog.error(this, "[Decoder ]", "save 264 stream exception:" + e);
                    try {
                        fileOutputStream.close();
                    } catch (IOException e3) {
                        YMFLog.error(this, "[Decoder ]", "close 264 stream exception:" + e3);
                    }
                }
            } catch (Throwable th) {
                th = th;
                try {
                    fileOutputStream.close();
                } catch (IOException e4) {
                    YMFLog.error(this, "[Decoder ]", "close 264 stream exception:" + e4);
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            fileOutputStream.close();
            throw th;
        }
    }

    public void handleExternalVideoEnd() {
        this.mCachedPtsList.clear();
        this.onExternalEnd.set(true);
        if (this.mWorkerHandler == null) {
            if (this.mH264HardwareDecoder != null) {
                this.mH264HardwareDecoder.release();
                this.mH264HardwareDecoder = null;
                return;
            }
            return;
        }
        this.mWorkerHandler.post(new Runnable() { // from class: com.yy.mediaframework.filters.ExternalDecoderFilter.4
            @Override // java.lang.Runnable
            public void run() {
                if (ExternalDecoderFilter.this.mWorkerHandler != null) {
                    ExternalDecoderFilter.this.mWorkerHandler.removeCallbacksAndMessages(null);
                }
                if (ExternalDecoderFilter.this.mH264HardwareDecoder != null) {
                    ExternalDecoderFilter.this.mH264HardwareDecoder.release();
                    ExternalDecoderFilter.this.mH264HardwareDecoder = null;
                }
            }
        });
    }

    public boolean isExternalHasEnd() {
        return this.onExternalEnd.get();
    }

    public void handleOutdoorVideoConfig(final DecodeVideoConfig decodeVideoConfig, final BaseHardwareDecoder.OnDecoderSizeChangeListener onDecoderSizeChangeListener) {
        if (this.mWorkerHandler == null) {
            initWorkerHandler();
        }
        this.mWorkerHandler.post(new Runnable() { // from class: com.yy.mediaframework.filters.ExternalDecoderFilter.5
            @Override // java.lang.Runnable
            public void run() {
                decodeVideoConfig.parseOutdoorSpsPps();
                if (ExternalDecoderFilter.this.mH264HardwareDecoder == null) {
                    ExternalDecoderFilter.this.mH264HardwareDecoder = new H264HardwareDecoder(decodeVideoConfig.width, decodeVideoConfig.height);
                    ExternalDecoderFilter.this.initTextureSurface(decodeVideoConfig.width, decodeVideoConfig.height);
                }
                decodeVideoConfig.mRenderSurface = ExternalDecoderFilter.this.mRenderSurface;
                if (ExternalDecoderFilter.this.mH264HardwareDecoder == null || ExternalDecoderFilter.this.mH264HardwareDecoder.isInited()) {
                    if (!decodeVideoConfig.equals(ExternalDecoderFilter.this.mDecoderConfig)) {
                        YMFLog.warn(this, "[Decoder ]", "stream video config changed, need to reset decoder, config:" + decodeVideoConfig.toString());
                        decodeVideoConfig.mRenderSurface = ExternalDecoderFilter.this.mRenderSurface;
                        ExternalDecoderFilter.this.mVideoLiveFilterContext.setDoHaveReceiveIFrame(false);
                        ExternalDecoderFilter.this.mH264HardwareDecoder.resetDecoder(decodeVideoConfig);
                        ExternalDecoderFilter.this.mDecoderConfig.assign(decodeVideoConfig);
                        ExternalDecoderFilter.this.mGetFirstIDR = false;
                        return;
                    }
                    return;
                }
                YMFLog.info(this, "[Decoder ]", "init external video stream decoder, config:" + decodeVideoConfig.toString());
                ExternalDecoderFilter.this.mH264HardwareDecoder.initDecoder(decodeVideoConfig);
                ExternalDecoderFilter.this.mH264HardwareDecoder.setOnDecoderSizeChangeListener(onDecoderSizeChangeListener);
                ExternalDecoderFilter.this.mDecoderConfig.assign(decodeVideoConfig);
                ExternalDecoderFilter.this.mGetFirstIDR = false;
            }
        });
    }

    @Override // com.yy.mediaframework.decoder.BaseHardwareDecoder.OnDecoderSizeChangeListener
    public void onDecoderSizeChanged(int i, int i2) {
        if (this.mDecoderConfig != null) {
            if (this.mDecoderConfig.width != i || this.mDecoderConfig.height != i2) {
                this.mDecoderConfig.width = i;
                this.mDecoderConfig.height = i2;
                YMFLog.info(this, "[Decoder ]", String.format(Locale.getDefault(), "onDecoderSizeChanged, width:%d height:%d", Integer.valueOf(i), Integer.valueOf(i2)));
            }
        }
    }
}
