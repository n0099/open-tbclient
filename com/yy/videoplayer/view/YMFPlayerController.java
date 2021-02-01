package com.yy.videoplayer.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import com.baidu.mobstat.Config;
import com.yy.videoplayer.Constant;
import com.yy.videoplayer.IYMFDecoderListener;
import com.yy.videoplayer.YMFStreamManager;
import com.yy.videoplayer.decoder.StateMonitor;
import com.yy.videoplayer.decoder.VideoConstant;
import com.yy.videoplayer.decoder.VideoSizeUtils;
import com.yy.videoplayer.decoder.YYVideoLibMgr;
import com.yy.videoplayer.render.YMFImageBuffer;
import com.yy.videoplayer.stat.YMFPlayerUsrBehaviorStat;
import com.yy.videoplayer.utils.ImageUtil;
import com.yy.videoplayer.utils.YMFLog;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes4.dex */
public class YMFPlayerController implements IYMFDecoderListener {
    private static final int DEFAULT_FULL_VIEW_HEIGHT = -2;
    private static final int DEFAULT_FULL_VIEW_WIDTH = -2;
    private static final String TAG = "YMFPlayerController";
    private Context mContext;
    private YMFRenderImage mYMFRenderImage;
    private YMFPlayerControlProxy playerControlProxy;
    private Handler mUiHandler = new Handler(Looper.getMainLooper());
    private ConcurrentHashMap<Integer, YMFRenderImage> mSeatId2RenderImageMap = new ConcurrentHashMap<>();
    private View mVideoView = null;
    private VideoConstant.ScaleMode mScaleMode = null;
    private VideoConstant.MirrorMode mMirrorMode = null;
    private Bitmap mBackGroundBitmap = null;
    private YMFVideoPosition mBackGroundPosition = new YMFVideoPosition();
    private YMFVideoPosition mOriginBackGroundPosition = new YMFVideoPosition();
    private byte[] mTmpBuffer = null;
    private AtomicBoolean mDataArrive = new AtomicBoolean(false);
    private ReentrantLock mRenderLock = new ReentrantLock(true);
    private YMFLayoutParams mYMFLayoutParams = null;
    private IViewNotify mViewNotify = null;
    private int mTotalVideoCnt = 0;
    private AtomicBoolean mHardDirectRenderMode = new AtomicBoolean(false);
    private HashMap<Long, Integer> mViewStateMap = new HashMap<>();
    private HashMap<Long, Long> mDecodeLastTimeStampMap = new HashMap<>();
    private AtomicInteger mLinkedCnt = new AtomicInteger(0);
    private int mSurfaceWidth = 0;
    private int mSurfaceHeight = 0;
    private boolean mUseTextureView = false;

    /* loaded from: classes4.dex */
    public interface IViewNotify {
        void onViewChangedNotify(Object obj, View view);
    }

    public YMFPlayerController(Context context) {
        this.mContext = null;
        this.mYMFRenderImage = null;
        this.playerControlProxy = null;
        this.mContext = context;
        this.mYMFRenderImage = new YMFRenderImage();
        this.mYMFRenderImage.mDecodeImage = new YMFImageBuffer(32, 32, 2, false);
        this.mYMFRenderImage.mVideoMode = VideoConstant.VideoViewMode.SingeMode;
        this.mSeatId2RenderImageMap.put(0, this.mYMFRenderImage);
        this.playerControlProxy = new YMFPlayerControlProxy(this);
        setViewNotify(new ViewChangedNotify());
    }

    public void setUseTextureView(boolean z) {
        YMFLog.info(this, "[Api     ]", "setUseTextureView," + z);
        this.mUseTextureView = z;
    }

    private void initParams(YMFLayoutParams yMFLayoutParams) {
        int i = 0;
        if (yMFLayoutParams != null) {
            this.mYMFLayoutParams = yMFLayoutParams;
            if (this.mTotalVideoCnt == 0 || this.mSeatId2RenderImageMap.size() == 0) {
                for (int i2 = 0; i2 < yMFLayoutParams.mTotalVideoCnt; i2++) {
                    YMFRenderImage yMFRenderImage = new YMFRenderImage();
                    yMFRenderImage.mDecodeImage = new YMFImageBuffer(32, 32, 2, false);
                    yMFRenderImage.mVideoMode = VideoConstant.VideoViewMode.MultiMode;
                    YMFLog.info(this, "[Render  ]", "initParams MultiMode");
                    YMFLayoutParams.clonePosition(yMFLayoutParams.mDrawPosition[i2], yMFRenderImage.mDrawPosition);
                    YMFLayoutParams.clonePosition(yMFLayoutParams.mDrawPosition[i2], yMFRenderImage.mOriginPosition);
                    yMFRenderImage.mSurfaceHeight = this.mSurfaceHeight;
                    yMFRenderImage.mSurfaceWidth = this.mSurfaceWidth;
                    this.mSeatId2RenderImageMap.put(Integer.valueOf(i2), yMFRenderImage);
                }
                this.mTotalVideoCnt = yMFLayoutParams.mTotalVideoCnt;
                YMFLog.info(this, "[Render  ]", "initParams " + this.mTotalVideoCnt);
            } else if (this.mTotalVideoCnt < yMFLayoutParams.mTotalVideoCnt) {
                for (int i3 = this.mTotalVideoCnt; i3 < yMFLayoutParams.mTotalVideoCnt; i3++) {
                    YMFRenderImage yMFRenderImage2 = new YMFRenderImage();
                    yMFRenderImage2.mDecodeImage = new YMFImageBuffer(32, 32, 2, false);
                    yMFRenderImage2.mRenderPrepared = false;
                    yMFRenderImage2.mStreamId = 0L;
                    yMFRenderImage2.mSurfaceHeight = this.mSurfaceHeight;
                    yMFRenderImage2.mSurfaceWidth = this.mSurfaceWidth;
                    this.mSeatId2RenderImageMap.put(Integer.valueOf(i3), yMFRenderImage2);
                }
                this.mTotalVideoCnt = yMFLayoutParams.mTotalVideoCnt;
                while (i < yMFLayoutParams.mTotalVideoCnt) {
                    YMFRenderImage yMFRenderImage3 = this.mSeatId2RenderImageMap.get(Integer.valueOf(i));
                    yMFRenderImage3.mVideoMode = VideoConstant.VideoViewMode.MultiMode;
                    YMFLayoutParams.clonePosition(yMFLayoutParams.mDrawPosition[i], yMFRenderImage3.mDrawPosition);
                    YMFLayoutParams.clonePosition(yMFLayoutParams.mDrawPosition[i], yMFRenderImage3.mOriginPosition);
                    i++;
                }
            } else if (this.mTotalVideoCnt > yMFLayoutParams.mTotalVideoCnt) {
                int i4 = yMFLayoutParams.mTotalVideoCnt;
                while (true) {
                    int i5 = i4;
                    if (i5 >= this.mTotalVideoCnt) {
                        break;
                    }
                    if (this.mSeatId2RenderImageMap.get(Integer.valueOf(i5)) != null) {
                        if (this.mSeatId2RenderImageMap.get(Integer.valueOf(i5)).mDecodeImage != null) {
                            this.mSeatId2RenderImageMap.get(Integer.valueOf(i5)).mDecodeImage.mData = null;
                        }
                        this.mSeatId2RenderImageMap.get(Integer.valueOf(i5)).mDecodeImage = null;
                    }
                    this.mSeatId2RenderImageMap.remove(Integer.valueOf(i5));
                    i4 = i5 + 1;
                }
                this.mTotalVideoCnt = yMFLayoutParams.mTotalVideoCnt;
                for (int i6 = 0; i6 < yMFLayoutParams.mTotalVideoCnt; i6++) {
                    YMFRenderImage yMFRenderImage4 = this.mSeatId2RenderImageMap.get(Integer.valueOf(i6));
                    YMFLayoutParams.clonePosition(yMFLayoutParams.mDrawPosition[i6], yMFRenderImage4.mDrawPosition);
                    YMFLayoutParams.clonePosition(yMFLayoutParams.mDrawPosition[i6], yMFRenderImage4.mOriginPosition);
                    yMFRenderImage4.mStreamId = 0L;
                    yMFRenderImage4.mRenderPrepared = false;
                }
            } else if (yMFLayoutParams.mTotalVideoCnt != 0 && this.mTotalVideoCnt == yMFLayoutParams.mTotalVideoCnt) {
                while (i < yMFLayoutParams.mTotalVideoCnt) {
                    YMFRenderImage yMFRenderImage5 = this.mSeatId2RenderImageMap.get(Integer.valueOf(i));
                    YMFLayoutParams.clonePosition(yMFLayoutParams.mDrawPosition[i], yMFRenderImage5.mDrawPosition);
                    YMFLayoutParams.clonePosition(yMFLayoutParams.mDrawPosition[i], yMFRenderImage5.mOriginPosition);
                    i++;
                }
            }
            this.mBackGroundBitmap = yMFLayoutParams.background;
            this.mBackGroundPosition = new YMFVideoPosition();
            this.mOriginBackGroundPosition = new YMFVideoPosition();
            if (this.mBackGroundBitmap != null) {
                YMFLayoutParams.clonePosition(yMFLayoutParams.backgroudPosition, this.mBackGroundPosition);
                YMFLayoutParams.clonePosition(yMFLayoutParams.backgroudPosition, this.mOriginBackGroundPosition);
            }
        }
    }

    private void updateViewRenderMode() {
        if (this.mSeatId2RenderImageMap != null) {
            if (this.mSeatId2RenderImageMap.size() == 1 && this.mSeatId2RenderImageMap.get(0).mVideoMode == VideoConstant.VideoViewMode.SingeMode) {
                if (this.mVideoView != null && (this.mVideoView instanceof YMFPlayerView)) {
                    ((YMFPlayerView) this.mVideoView).forceReDraw();
                }
                if (this.mVideoView != null && (this.mVideoView instanceof YMFPlayerTextureView)) {
                    ((YMFPlayerTextureView) this.mVideoView).forceReDraw();
                }
            }
            if (this.mSeatId2RenderImageMap.size() > 1) {
                for (Map.Entry<Integer, YMFRenderImage> entry : this.mSeatId2RenderImageMap.entrySet()) {
                    entry.getValue().mVideoMode = VideoConstant.VideoViewMode.MultiMode;
                }
            }
        }
    }

    public int setViewLayout(YMFLayoutParams yMFLayoutParams) {
        int i;
        int i2;
        this.mRenderLock.lock();
        if (yMFLayoutParams != null) {
            initParams(yMFLayoutParams);
        }
        if (this.mSeatId2RenderImageMap == null || this.mSeatId2RenderImageMap.size() <= 0) {
            i = 0;
            i2 = 0;
        } else {
            i2 = this.mSeatId2RenderImageMap.get(0).mSurfaceWidth;
            i = this.mSeatId2RenderImageMap.get(0).mSurfaceHeight;
        }
        if (i2 != 0 && i != 0) {
            updateVideoLayout(i2, i);
        }
        if (this.mVideoView != null && (this.mVideoView instanceof YMFPlayerView)) {
            ((YMFPlayerView) this.mVideoView).forceReDraw();
            ((YMFPlayerView) this.mVideoView).setRenderControlByChoreographer();
        }
        if (this.mVideoView != null && (this.mVideoView instanceof YMFPlayerTextureView)) {
            ((YMFPlayerTextureView) this.mVideoView).forceReDraw();
            ((YMFPlayerTextureView) this.mVideoView).setRenderControlByChoreographer();
        }
        this.mRenderLock.unlock();
        return 0;
    }

    private void registerDecoderListener() {
        YMFStreamManager.instance().registerListener(this);
    }

    private void unRegisterDecoderListener() {
        YMFStreamManager.instance().unregisterListener(this);
    }

    public YMFRenderImage findRenderImageByStreamId(long j) {
        if (this.mSeatId2RenderImageMap != null) {
            for (Map.Entry<Integer, YMFRenderImage> entry : this.mSeatId2RenderImageMap.entrySet()) {
                YMFRenderImage value = entry.getValue();
                if (value.mStreamId == j) {
                    return value;
                }
            }
        }
        return null;
    }

    private YMFRenderImage findRenderImageBySeatIndex(int i) {
        YMFRenderImage yMFRenderImage;
        if (this.mSeatId2RenderImageMap == null || (yMFRenderImage = this.mSeatId2RenderImageMap.get(Integer.valueOf(i))) == null) {
            return null;
        }
        return yMFRenderImage;
    }

    private void createVideoViewUI() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.mUiHandler.post(new Runnable() { // from class: com.yy.videoplayer.view.YMFPlayerController.1
            @Override // java.lang.Runnable
            public void run() {
                YMFPlayerController.this.createVideoView();
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            YMFLog.error(this, "[Render  ]", "postToUiThread barrier.await" + e.toString());
        }
    }

    private void checkSwitchDirectRenderMode(long j, YMFImageBuffer yMFImageBuffer) {
        if (yMFImageBuffer.mHardware && yMFImageBuffer.mDirectHardRender && !this.mHardDirectRenderMode.get()) {
            if (this.mViewNotify != null) {
                this.mHardDirectRenderMode.set(true);
                ViewParent viewParent = null;
                YMFLog.info(this, "[Render  ]", "set hardDirectRenderMode:");
                if (this.mVideoView != null && (this.mVideoView instanceof YMFPlayerView)) {
                    YMFLog.info(this, "[Render  ]", "rePrepare view, src:" + this.mVideoView);
                    unLinkStream(j);
                    viewParent = this.mVideoView.getParent();
                    createVideoViewUI();
                } else if (this.mVideoView == null) {
                    return;
                }
                if (this.mViewNotify != null) {
                    YMFLog.info(this, "[Render  ]", "onViewChangedNotify, dst" + this.mVideoView);
                    try {
                        this.mViewNotify.onViewChangedNotify(viewParent, this.mVideoView);
                        linkStream(j);
                        setScaleMode(this.mScaleMode);
                    } catch (Exception e) {
                        YMFLog.error(this, "[Render  ]", "checkSwitchDirectRenderMode： " + e.toString());
                    }
                }
            }
        } else if (!yMFImageBuffer.mDirectHardRender && this.mHardDirectRenderMode.get()) {
            this.mHardDirectRenderMode.set(false);
        }
    }

    @Override // com.yy.videoplayer.IYMFDecoderListener
    public void onDecodeStreamStart(long j, YMFImageBuffer yMFImageBuffer) {
    }

    @Override // com.yy.videoplayer.IYMFDecoderListener
    public void onDecodeStreamEnd(long j, YMFImageBuffer yMFImageBuffer) {
        YMFRenderImage findRenderImageByStreamId = findRenderImageByStreamId(j);
        if (findRenderImageByStreamId != null && findRenderImageByStreamId.mDecodeImage != null) {
            findRenderImageByStreamId.mDecodeImage.assignWithoutBuffer(yMFImageBuffer);
        }
    }

    @Override // com.yy.videoplayer.IYMFDecoderListener
    public void onDecodedFrameAvailable(long j, YMFImageBuffer yMFImageBuffer) {
        YMFRenderImage findRenderImageByStreamId;
        checkSwitchDirectRenderMode(j, yMFImageBuffer);
        if (!this.mHardDirectRenderMode.get() && (findRenderImageByStreamId = findRenderImageByStreamId(j)) != null) {
            updateStreamDeltaPts(j, yMFImageBuffer);
            processMediaSample(findRenderImageByStreamId, yMFImageBuffer);
        }
    }

    public void setLastFrameRenderBlack(boolean z) {
        if (this.mVideoView != null && (this.mVideoView instanceof YMFPlayerView)) {
            ((YMFPlayerView) this.mVideoView).setLastFrameRenderBlack(z);
        }
        if (this.mVideoView != null && (this.mVideoView instanceof YMFPlayerTextureView)) {
            ((YMFPlayerTextureView) this.mVideoView).setLastFrameRenderBlack(z);
        }
    }

    private void updateStreamDeltaPts(long j, YMFImageBuffer yMFImageBuffer) {
        if (this.mDecodeLastTimeStampMap != null && yMFImageBuffer != null) {
            if (!this.mDecodeLastTimeStampMap.containsKey(Long.valueOf(j))) {
                this.mDecodeLastTimeStampMap.put(Long.valueOf(j), Long.valueOf(yMFImageBuffer.mPts));
            } else if (this.mDecodeLastTimeStampMap.containsKey(Long.valueOf(j))) {
                yMFImageBuffer.mDeltaPts = yMFImageBuffer.mPts - this.mDecodeLastTimeStampMap.get(Long.valueOf(j)).longValue();
                this.mDecodeLastTimeStampMap.put(Long.valueOf(j), Long.valueOf(yMFImageBuffer.mPts));
            }
        }
    }

    private boolean prepareView() {
        this.mRenderLock.lock();
        if (this.mUseTextureView) {
            this.mVideoView = new YMFPlayerTextureView(this.mContext, null, this.playerControlProxy);
            YMFLog.info(this, "[Render  ]", "createView YMFPlayerTextureView:" + this.mVideoView);
        } else if (this.mHardDirectRenderMode.get()) {
            this.mVideoView = new YMFSurfaceView(this.mContext);
            YMFLog.info(this, "[Render  ]", "createView YMFSurfaceView:" + this.mVideoView);
        } else {
            this.mVideoView = new YMFPlayerView(this.mContext, null, this.playerControlProxy);
            YMFLog.info(this, "[Render  ]", "createView YMFPlayerView:" + this.mVideoView);
        }
        this.mRenderLock.unlock();
        return true;
    }

    public View createVideoView() {
        destroyVideoView();
        prepareView();
        return this.mVideoView;
    }

    @Deprecated
    public void destroyVideoView() {
        this.mRenderLock.lock();
        YMFLog.info(this, "[Render  ]", "destroyVideoView." + this.mVideoView);
        if (this.mVideoView != null) {
            if (this.mVideoView instanceof YMFSurfaceView) {
                ((YMFSurfaceView) this.mVideoView).release();
            } else if (this.mVideoView instanceof YMFPlayerView) {
                ((YMFPlayerView) this.mVideoView).release();
            } else if (this.mVideoView instanceof YMFPlayerTextureView) {
                ((YMFPlayerTextureView) this.mVideoView).release();
            }
            this.mVideoView = null;
        }
        this.mRenderLock.unlock();
    }

    public int setScaleMode(VideoConstant.ScaleMode scaleMode) {
        if (!this.mHardDirectRenderMode.get()) {
            YMFRenderImage findRenderImageBySeatIndex = findRenderImageBySeatIndex(0);
            if (findRenderImageBySeatIndex != null && findRenderImageBySeatIndex.mScaleMode != scaleMode) {
                findRenderImageBySeatIndex.mScaleMode = scaleMode;
                this.mRenderLock.lock();
                updateVideoSize(findRenderImageBySeatIndex);
                this.mRenderLock.unlock();
                updateViewRenderMode();
            }
        } else if (this.mVideoView instanceof YMFSurfaceView) {
            ((YMFSurfaceView) this.mVideoView).setScaleMode(scaleMode);
        }
        this.mScaleMode = scaleMode;
        YMFLog.info(this, Constant.MEDIACODE_PLAYVIEW, "setScaleMode:" + scaleMode);
        return 0;
    }

    public VideoConstant.ScaleMode getScaleMode() {
        return this.mScaleMode;
    }

    public int setScaleMode(VideoConstant.ScaleMode scaleMode, int i) {
        YMFRenderImage findRenderImageBySeatIndex = findRenderImageBySeatIndex(i);
        if (findRenderImageBySeatIndex != null) {
            findRenderImageBySeatIndex.mScaleMode = scaleMode;
            this.mRenderLock.lock();
            updateVideoSize(findRenderImageBySeatIndex);
            this.mRenderLock.unlock();
        }
        YMFLog.info(this, Constant.MEDIACODE_PLAYVIEW, "setScaleMode  videoIndex" + i + " scaleMode " + scaleMode);
        return 0;
    }

    public VideoConstant.ScaleMode getScaleMode(int i) {
        YMFRenderImage findRenderImageBySeatIndex = findRenderImageBySeatIndex(i);
        return findRenderImageBySeatIndex != null ? findRenderImageBySeatIndex.mScaleMode : VideoConstant.ScaleMode.AspectFit;
    }

    public int setMirrorMode(VideoConstant.MirrorMode mirrorMode, int i) {
        YMFRenderImage findRenderImageBySeatIndex = findRenderImageBySeatIndex(i);
        if (findRenderImageBySeatIndex != null) {
            findRenderImageBySeatIndex.mMirrorMode = mirrorMode;
        }
        this.mMirrorMode = mirrorMode;
        YMFLog.info(this, Constant.MEDIACODE_PLAYVIEW, "setMirrorMode:" + mirrorMode + " videoIndex:" + i);
        return 0;
    }

    public VideoConstant.MirrorMode getMirrorMode(int i) {
        YMFRenderImage findRenderImageBySeatIndex = findRenderImageBySeatIndex(i);
        return findRenderImageBySeatIndex != null ? findRenderImageBySeatIndex.mMirrorMode : VideoConstant.MirrorMode.Disabled;
    }

    @Deprecated
    public void release() {
        this.mRenderLock.lock();
        for (Map.Entry<Integer, YMFRenderImage> entry : this.mSeatId2RenderImageMap.entrySet()) {
            YMFRenderImage value = entry.getValue();
            if (value != null) {
                if (value.mDecodeImage != null) {
                    value.mDecodeImage.mData = null;
                }
                value.mDecodeImage = null;
            }
        }
        this.mSeatId2RenderImageMap.clear();
        this.mViewStateMap.clear();
        this.mDecodeLastTimeStampMap.clear();
        this.mTotalVideoCnt = 0;
        if (this.mBackGroundBitmap != null) {
            this.mBackGroundBitmap = null;
        }
        this.mRenderLock.unlock();
    }

    public int switchDualVideoView(long j, long j2, int i) {
        YMFLog.info(this, "[Render  ]", "switchDualVideoView unLinkStream, streamId" + j + ",cnt:" + this.mLinkedCnt.get());
        this.mRenderLock.lock();
        if (this.mVideoView instanceof YMFSurfaceView) {
            ((YMFSurfaceView) this.mVideoView).unLinkFromStream(j);
        } else {
            YMFRenderImage findRenderImageByStreamId = findRenderImageByStreamId(j);
            if (findRenderImageByStreamId != null) {
                findRenderImageByStreamId.mStreamId = 0L;
                findRenderImageByStreamId.mRenderPrepared = false;
            }
        }
        YMFRenderImage findRenderImageBySeatIndex = findRenderImageBySeatIndex(i);
        if (findRenderImageBySeatIndex != null) {
            findRenderImageBySeatIndex.mStreamId = j2;
            findRenderImageBySeatIndex.mRenderPrepared = true;
        }
        this.mRenderLock.unlock();
        YMFLog.info(this, "[Render  ]", "switchDualVideoView LinkStream, streamId" + j2 + ",cnt:" + this.mLinkedCnt.get());
        notifyViewStateChange(j, 1);
        notifyRenderUnlinkEvent(j);
        notifyViewStateChange(j2, 0);
        notifyRenderLinkEvent(j2);
        return 0;
    }

    public int linkStream(long j, int i) {
        if (j != 0 && i >= 0) {
            this.mLinkedCnt.getAndIncrement();
            registerDecoderListener();
            YMFLog.info(this, "[Render  ]", "linkStream, streamId" + j + " videoIndex:" + i + ",cnt:" + this.mLinkedCnt.get());
            this.mRenderLock.lock();
            YMFRenderImage findRenderImageByStreamId = findRenderImageByStreamId(j);
            if (findRenderImageByStreamId != null) {
                findRenderImageByStreamId.mStreamId = 0L;
                findRenderImageByStreamId.mRenderPrepared = false;
            }
            YMFRenderImage findRenderImageBySeatIndex = findRenderImageBySeatIndex(i);
            if (findRenderImageBySeatIndex != null) {
                findRenderImageBySeatIndex.mStreamId = j;
                findRenderImageBySeatIndex.mRenderPrepared = true;
            }
            notifyViewStateChange(j, 0);
            this.mRenderLock.unlock();
            notifyRenderLinkEvent(j);
            return 0;
        }
        return -1;
    }

    public int unLinkStream(long j, int i) {
        if (j != 0 && i >= 0) {
            this.mLinkedCnt.getAndDecrement();
            YMFLog.info(this, "[Render  ]", "unLinkStream, streamId" + j + " videoIndex:" + i + ",cnt:" + this.mLinkedCnt.get());
            if (this.mLinkedCnt.get() == 0) {
                unRegisterDecoderListener();
            }
            this.mRenderLock.lock();
            YMFRenderImage findRenderImageBySeatIndex = findRenderImageBySeatIndex(i);
            if (findRenderImageBySeatIndex != null) {
                findRenderImageBySeatIndex.mStreamId = 0L;
                findRenderImageBySeatIndex.mRenderPrepared = false;
                if (findRenderImageBySeatIndex.mDecodeImage != null) {
                    findRenderImageBySeatIndex.mDecodeImage.mStreamStart = false;
                }
            }
            notifyViewStateChange(j, 1);
            this.mRenderLock.unlock();
            if (this.mVideoView != null && (this.mVideoView instanceof YMFPlayerView)) {
                ((YMFPlayerView) this.mVideoView).forceReDraw();
            }
            if (this.mVideoView != null && (this.mVideoView instanceof YMFPlayerTextureView)) {
                ((YMFPlayerTextureView) this.mVideoView).forceReDraw();
            }
            notifyRenderUnlinkEvent(j);
            return 0;
        }
        return -1;
    }

    public int linkStream(long j) {
        if (j == 0) {
            return -1;
        }
        this.mLinkedCnt.getAndIncrement();
        registerDecoderListener();
        YMFLog.info(this, "[Render  ]", "linkStream, streamId" + j + ",cnt:" + this.mLinkedCnt.get());
        this.mRenderLock.lock();
        if (this.mVideoView instanceof YMFSurfaceView) {
            ((YMFSurfaceView) this.mVideoView).linkToStream(j);
        } else {
            YMFRenderImage findRenderImageBySeatIndex = findRenderImageBySeatIndex(0);
            if (findRenderImageBySeatIndex != null) {
                findRenderImageBySeatIndex.mStreamId = j;
                findRenderImageBySeatIndex.mRenderPrepared = true;
            }
        }
        notifyViewStateChange(j, 0);
        this.mRenderLock.unlock();
        notifyRenderLinkEvent(j);
        return 0;
    }

    public int unLinkStream(long j) {
        if (j == 0) {
            return -1;
        }
        this.mLinkedCnt.getAndDecrement();
        unRegisterDecoderListener();
        YMFLog.info(this, "[Render  ]", "unLinkStream, streamId" + j + ",cnt:" + this.mLinkedCnt.get());
        if (this.mLinkedCnt.get() == 0) {
            unRegisterDecoderListener();
        }
        this.mRenderLock.lock();
        if (this.mVideoView instanceof YMFSurfaceView) {
            ((YMFSurfaceView) this.mVideoView).unLinkFromStream(j);
        } else {
            YMFRenderImage findRenderImageByStreamId = findRenderImageByStreamId(j);
            if (findRenderImageByStreamId != null) {
                findRenderImageByStreamId.mStreamId = 0L;
                findRenderImageByStreamId.mRenderPrepared = false;
            }
        }
        notifyViewStateChange(j, 1);
        this.mRenderLock.unlock();
        if (this.mVideoView != null && (this.mVideoView instanceof YMFPlayerView)) {
            ((YMFPlayerView) this.mVideoView).forceReDraw();
        }
        if (this.mVideoView != null && (this.mVideoView instanceof YMFPlayerTextureView)) {
            ((YMFPlayerTextureView) this.mVideoView).forceReDraw();
        }
        notifyRenderUnlinkEvent(j);
        return 0;
    }

    private void notifyViewStateChange(long j, int i) {
        if (this.mViewStateMap.get(Long.valueOf(j)) == null || this.mViewStateMap.get(Long.valueOf(j)).intValue() != i) {
            this.mViewStateMap.put(Long.valueOf(j), Integer.valueOf(i));
            if (i == 0) {
                if (this.mVideoView != null && (this.mVideoView instanceof YMFPlayerView)) {
                    ((YMFPlayerView) this.mVideoView).setIgnoreStatistic(j);
                }
                if (this.mVideoView != null && (this.mVideoView instanceof YMFPlayerTextureView)) {
                    ((YMFPlayerTextureView) this.mVideoView).setIgnoreStatistic(j);
                }
            }
            YYVideoLibMgr.instance().onViewStateNotify(j, i);
        }
    }

    private void notifyRenderUnlinkEvent(long j) {
        StateMonitor.NotifyClearPts(j);
        StateMonitor.instance().NotifyRemoveView(j);
        StateMonitor.NotifyReleaseRender(j);
        YMFPlayerUsrBehaviorStat.getInstance().notifyPlayerViewLinkStream(0, j, false);
    }

    private void notifyRenderLinkEvent(long j) {
        StateMonitor.NotifyCreateRender(j, 4);
        StateMonitor.instance().NotifyAddView(j, 0, VideoConstant.ViewType.GL_VIDEO_VIEW_GLSURFACE, TAG);
        YMFPlayerUsrBehaviorStat.getInstance().notifyPlayerViewLinkStream(0, j, true);
    }

    public Bitmap getVideoScreenshotByStreamID(long j) {
        try {
            YMFRenderImage findRenderImageByStreamId = findRenderImageByStreamId(j);
            if (findRenderImageByStreamId != null) {
                return getBitmap(findRenderImageByStreamId);
            }
        } catch (Exception e) {
            YMFLog.error(this, Constant.MEDIACODE_PLAYVIEW, "getScrennShotByStreamID exception:" + e.getMessage());
        }
        return null;
    }

    public Bitmap getVideoScreenshotExt(int i) {
        try {
            YMFRenderImage findRenderImageBySeatIndex = findRenderImageBySeatIndex(i);
            if (findRenderImageBySeatIndex != null) {
                return getBitmap(findRenderImageBySeatIndex);
            }
        } catch (Exception e) {
            YMFLog.error(this, Constant.MEDIACODE_PLAYVIEW, "getScrennShot exception:" + e.getMessage());
        }
        return null;
    }

    public Bitmap getVideoScreenshot() {
        try {
            YMFRenderImage findRenderImageBySeatIndex = findRenderImageBySeatIndex(0);
            if (findRenderImageBySeatIndex != null) {
                return getBitmap(findRenderImageBySeatIndex);
            }
        } catch (Exception e) {
            YMFLog.error(this, Constant.MEDIACODE_PLAYVIEW, "getScrennShot exception:" + e.getMessage());
        }
        return null;
    }

    private Bitmap getBitmap(YMFRenderImage yMFRenderImage) {
        Bitmap bitmap = null;
        YMFImageBuffer yMFImageBuffer = yMFRenderImage.mDecodeImage;
        if (yMFImageBuffer != null) {
            try {
                this.mRenderLock.lock();
                byte[] bArr = new byte[yMFImageBuffer.mBufSize];
                byte[] bArr2 = new byte[yMFImageBuffer.mWidth * yMFImageBuffer.mHeight * 4];
                yMFImageBuffer.mData.rewind();
                yMFImageBuffer.mData.get(bArr, 0, yMFImageBuffer.mBufSize);
                YMFLog.info(this, Constant.MEDIACODE_PLAYVIEW, "Format:" + yMFRenderImage.mDecodeImage.mFormat + "getBitmap renderImage.mVideoWidth:" + yMFRenderImage.mVideoWidth + " renderImage.mVideoWidth;" + yMFRenderImage.mVideoHeight + " imageBuffer.mWidth;" + yMFImageBuffer.mWidth + " imageBuffer.mHeight:" + yMFImageBuffer.mHeight);
                switch (yMFRenderImage.mDecodeImage.mFormat) {
                    case 0:
                        ImageUtil.NV21ToARGB(bArr, yMFImageBuffer.mWidth, yMFImageBuffer.mHeight, bArr2, false);
                        break;
                    case 1:
                        ImageUtil.NV12ToARGB(bArr, yMFImageBuffer.mWidth, yMFImageBuffer.mHeight, bArr2, false);
                        break;
                    case 2:
                        ImageUtil.I420ToARGB(bArr, yMFImageBuffer.mWidth, yMFImageBuffer.mHeight, bArr2, false);
                        break;
                    case 3:
                        ImageUtil.YV12ToARGB(bArr, yMFImageBuffer.mWidth, yMFImageBuffer.mHeight, bArr2, false);
                        break;
                    default:
                        return null;
                }
                bitmap = Bitmap.createBitmap(yMFRenderImage.mVideoWidth, yMFRenderImage.mVideoHeight, Bitmap.Config.ARGB_8888);
                bitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bArr2));
                this.mRenderLock.unlock();
                return bitmap;
            } catch (Exception e) {
                this.mRenderLock.unlock();
                YMFLog.error(this, "[Render  ]", " getBitmap failed,e:" + e.fillInStackTrace());
                return bitmap;
            }
        }
        return null;
    }

    private void updateVideoSize(YMFRenderImage yMFRenderImage) {
        if (yMFRenderImage != null) {
            if (yMFRenderImage.mVideoMode == VideoConstant.VideoViewMode.MultiMode) {
                yMFRenderImage.mVideoSize = VideoSizeUtils.calcVideoSize(yMFRenderImage.mDrawPosition.mX, yMFRenderImage.mDrawPosition.mY, yMFRenderImage.mDrawPosition.mWidth, yMFRenderImage.mDrawPosition.mHeight);
            } else {
                yMFRenderImage.mVideoSize = VideoSizeUtils.CalcFitSize(yMFRenderImage.mVideoWidth, yMFRenderImage.mVideoHeight, yMFRenderImage.mSurfaceWidth, yMFRenderImage.mSurfaceHeight, yMFRenderImage.mScaleMode);
            }
            if (this.mVideoView != null && (this.mVideoView instanceof YMFPlayerView)) {
                ((YMFPlayerView) this.mVideoView).forceReDraw();
            }
            if (this.mVideoView != null && (this.mVideoView instanceof YMFPlayerTextureView)) {
                ((YMFPlayerTextureView) this.mVideoView).forceReDraw();
            }
        }
    }

    private void checkSizeUpdate(YMFRenderImage yMFRenderImage, int i, int i2) {
        if (yMFRenderImage != null) {
            if (yMFRenderImage.mVideoWidth != i || yMFRenderImage.mVideoHeight != i2) {
                yMFRenderImage.mVideoWidth = i;
                yMFRenderImage.mVideoHeight = i2;
                updateVideoSize(yMFRenderImage);
                YMFLog.info(this, Constant.MEDIACODE_PLAYVIEW, "checkSizeUpdate video width:" + i + " height:" + i2);
            }
        }
    }

    private void copyDecodeBuffer(YMFRenderImage yMFRenderImage, YMFImageBuffer yMFImageBuffer) {
        if (yMFRenderImage.mDecodeImage == null || yMFRenderImage.mDecodeImage.mWidth != yMFImageBuffer.mWidth || yMFRenderImage.mDecodeImage.mHeight != yMFImageBuffer.mHeight || yMFRenderImage.mDecodeImage.mFormat != yMFImageBuffer.mFormat || yMFRenderImage.mDecodeImage.mData == null) {
            yMFRenderImage.mDecodeImage = new YMFImageBuffer(yMFImageBuffer.mWidth, yMFImageBuffer.mHeight, yMFImageBuffer.mFormat, true);
        }
        if (this.mTmpBuffer == null || this.mTmpBuffer.length != ((yMFImageBuffer.mWidth * yMFImageBuffer.mHeight) * 3) / 2) {
            this.mTmpBuffer = new byte[((yMFImageBuffer.mWidth * yMFImageBuffer.mHeight) * 3) / 2];
        }
        if (yMFImageBuffer.mData.hasArray() && yMFRenderImage.mDecodeImage.mData.hasArray()) {
            System.arraycopy(yMFImageBuffer.mData.array(), yMFImageBuffer.mData.arrayOffset(), yMFRenderImage.mDecodeImage.mData.array(), yMFRenderImage.mDecodeImage.mData.arrayOffset(), yMFImageBuffer.mBufSize);
        } else {
            yMFImageBuffer.mData.rewind();
            if (yMFImageBuffer.mData.remaining() < this.mTmpBuffer.length) {
                YMFLog.error(this, Constant.MEDIACODE_PLAYVIEW, "copyHardwareBuffer " + yMFImageBuffer.mData.remaining() + " != " + this.mTmpBuffer.length + "," + yMFImageBuffer.mWidth + Config.EVENT_HEAT_X + yMFImageBuffer.mHeight);
            }
            yMFImageBuffer.mData.get(this.mTmpBuffer);
            yMFRenderImage.mDecodeImage.mData.rewind();
            yMFRenderImage.mDecodeImage.mData.put(this.mTmpBuffer);
        }
        yMFRenderImage.mDecodeImage.mHardware = yMFImageBuffer.mHardware;
        yMFRenderImage.mDecodeImage.mStreamId = yMFImageBuffer.mStreamId;
        yMFRenderImage.mDecodeImage.mDts = yMFImageBuffer.mDts;
        yMFRenderImage.mDecodeImage.mPts = yMFImageBuffer.mPts;
        yMFRenderImage.mDecodeImage.mDeltaPts = yMFImageBuffer.mDeltaPts;
        yMFRenderImage.mDecodeImage.mCropRight = yMFImageBuffer.mCropRight;
        yMFRenderImage.mDecodeImage.mCropBottom = yMFImageBuffer.mCropBottom;
        yMFRenderImage.mDecodeImage.mCropTop = yMFImageBuffer.mCropTop;
        yMFRenderImage.mDecodeImage.mCropLeft = yMFImageBuffer.mCropLeft;
        yMFRenderImage.mDecodeImage.mStreamStart = yMFImageBuffer.mStreamStart;
        yMFRenderImage.mDecodeImage.mNeedRendered = yMFImageBuffer.mNeedRendered;
        yMFRenderImage.mDecodeImage.mSsrc = yMFImageBuffer.mSsrc;
        yMFRenderImage.mDecodeImage.mNotifyRenderInfo = yMFImageBuffer.mNotifyRenderInfo;
        yMFRenderImage.mDecodeImage.mIgnore = yMFImageBuffer.mIgnore;
        yMFRenderImage.mDecodeImage.mClipWindow = yMFImageBuffer.mClipWindow;
        yMFRenderImage.mDecodeImage.mChangeRenderMode = yMFImageBuffer.mChangeRenderMode;
    }

    @RequiresApi(api = 16)
    public boolean processMediaSample(YMFRenderImage yMFRenderImage, YMFImageBuffer yMFImageBuffer) {
        try {
            if (yMFRenderImage != null) {
                this.mRenderLock.lock();
                copyDecodeBuffer(yMFRenderImage, yMFImageBuffer);
                checkSizeUpdate(yMFRenderImage, (yMFImageBuffer.mCropRight - yMFImageBuffer.mCropLeft) + 1, (yMFImageBuffer.mCropBottom - yMFImageBuffer.mCropTop) + 1);
                if (yMFRenderImage.mVideoMode == VideoConstant.VideoViewMode.SingeMode) {
                    this.mDataArrive.set(true);
                    if (this.mVideoView != null && (this.mVideoView instanceof YMFPlayerView) && yMFRenderImage.mDecodeImage.mNeedRendered) {
                        ((YMFPlayerView) this.mVideoView).requestGlRender();
                    }
                    if (this.mVideoView != null && (this.mVideoView instanceof YMFPlayerTextureView) && yMFRenderImage.mDecodeImage.mNeedRendered) {
                        ((YMFPlayerTextureView) this.mVideoView).requestGlRender();
                    }
                } else {
                    if (this.mVideoView != null && (this.mVideoView instanceof YMFPlayerView)) {
                        if (this.mSeatId2RenderImageMap.size() > 1) {
                            ((YMFPlayerView) this.mVideoView).setRenderControlByChoreographer();
                        } else {
                            ((YMFPlayerView) this.mVideoView).requestGlRender();
                        }
                    }
                    if (this.mVideoView != null && (this.mVideoView instanceof YMFPlayerTextureView)) {
                        if (this.mSeatId2RenderImageMap.size() > 1) {
                            ((YMFPlayerTextureView) this.mVideoView).setRenderControlByChoreographer();
                        } else {
                            ((YMFPlayerTextureView) this.mVideoView).requestGlRender();
                        }
                    }
                }
            }
        } catch (Exception e) {
            YMFLog.error(this, Constant.MEDIACODE_PLAYVIEW, e.getMessage() + " processMediaSample " + e.toString());
        } finally {
            this.mRenderLock.unlock();
        }
        return true;
    }

    public void updateVideoLayout(int i, int i2) {
        YMFLog.info(this, TAG, " updateMultiDrawLayout surface:" + i + "," + i2);
        this.mRenderLock.lock();
        this.mSurfaceHeight = i2;
        this.mSurfaceWidth = i;
        if (this.mSeatId2RenderImageMap != null && this.mSeatId2RenderImageMap.size() > 0) {
            if (this.mSeatId2RenderImageMap.get(0).mVideoMode == VideoConstant.VideoViewMode.MultiMode) {
                updateMultiDrawBackgroundParam(i, i2);
            }
            for (Map.Entry<Integer, YMFRenderImage> entry : this.mSeatId2RenderImageMap.entrySet()) {
                YMFRenderImage value = entry.getValue();
                if (value != null) {
                    value.mSurfaceWidth = i;
                    value.mSurfaceHeight = i2;
                    if (value.mVideoMode == VideoConstant.VideoViewMode.MultiMode) {
                        updateMultiDrawLayout(value);
                    }
                    updateVideoSize(value);
                    YMFLog.info(this, TAG, " updateMultiDrawLayout :" + value.toString());
                }
            }
        }
        this.mRenderLock.unlock();
    }

    public View getVideoView() {
        return this.mVideoView;
    }

    private void updateMultiDrawLayout(YMFRenderImage yMFRenderImage) {
        if (yMFRenderImage != null) {
            if (yMFRenderImage.mOriginPosition.mWidth == -2 && yMFRenderImage.mOriginPosition.mHeight == -2) {
                yMFRenderImage.mDrawPosition.mX = 0;
                yMFRenderImage.mDrawPosition.mY = 0;
                yMFRenderImage.mDrawPosition.mWidth = yMFRenderImage.mSurfaceWidth;
                yMFRenderImage.mDrawPosition.mHeight = yMFRenderImage.mSurfaceHeight;
            } else {
                yMFRenderImage.mDrawPosition.mX = yMFRenderImage.mOriginPosition.mX;
                yMFRenderImage.mDrawPosition.mY = (yMFRenderImage.mSurfaceHeight - yMFRenderImage.mOriginPosition.mY) - yMFRenderImage.mOriginPosition.mHeight;
                yMFRenderImage.mDrawPosition.mWidth = yMFRenderImage.mOriginPosition.mWidth;
                yMFRenderImage.mDrawPosition.mHeight = yMFRenderImage.mOriginPosition.mHeight;
            }
            if (this.mBackGroundPosition != null) {
                YMFLayoutParams.clonePosition(this.mBackGroundPosition, yMFRenderImage.mBackGroundPosition);
            }
        }
    }

    private void updateMultiDrawBackgroundParam(int i, int i2) {
        this.mBackGroundPosition.mX = this.mOriginBackGroundPosition.mX;
        this.mBackGroundPosition.mY = (i2 - this.mOriginBackGroundPosition.mY) - this.mOriginBackGroundPosition.mHeight;
        this.mBackGroundPosition.mHeight = this.mOriginBackGroundPosition.mHeight;
        this.mBackGroundPosition.mWidth = this.mOriginBackGroundPosition.mWidth;
    }

    /* loaded from: classes4.dex */
    public class YMFPlayerControlProxy {
        private YMFPlayerController mPlayerController;

        YMFPlayerControlProxy(YMFPlayerController yMFPlayerController) {
            this.mPlayerController = null;
            this.mPlayerController = yMFPlayerController;
        }

        public ReentrantLock getRenderLock() {
            return this.mPlayerController.mRenderLock;
        }

        public AtomicBoolean getDataArriveFlag() {
            return this.mPlayerController.mDataArrive;
        }

        public void setDataArriveFlag() {
            this.mPlayerController.mDataArrive.set(true);
        }

        public ConcurrentHashMap<Integer, YMFRenderImage> getRenderImageMap() {
            return this.mPlayerController.mSeatId2RenderImageMap;
        }

        public Bitmap getBackgroundBitmap() {
            return YMFPlayerController.this.mBackGroundBitmap;
        }

        public void updateVideoLayout(int i, int i2) {
            this.mPlayerController.updateVideoLayout(i, i2);
        }
    }

    public void setViewNotify(IViewNotify iViewNotify) {
        this.mViewNotify = iViewNotify;
    }

    /* loaded from: classes4.dex */
    public class ViewChangedNotify implements IViewNotify {
        public ViewChangedNotify() {
        }

        @Override // com.yy.videoplayer.view.YMFPlayerController.IViewNotify
        public void onViewChangedNotify(Object obj, View view) {
            if (YMFPlayerController.this.mUiHandler != null && view != null && obj != null) {
                postToUiThread((FrameLayout) obj, view);
            }
        }

        void postToUiThread(final FrameLayout frameLayout, final View view) {
            if (Thread.currentThread().getId() == YMFPlayerController.this.mUiHandler.getLooper().getThread().getId()) {
                frameLayout.removeAllViews();
                frameLayout.addView(view);
                return;
            }
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            YMFPlayerController.this.mUiHandler.post(new Runnable() { // from class: com.yy.videoplayer.view.YMFPlayerController.ViewChangedNotify.1
                @Override // java.lang.Runnable
                public void run() {
                    frameLayout.removeAllViews();
                    frameLayout.addView(view);
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                YMFLog.error(this, "[Render  ]", "postToUiThread barrier.await" + e.toString());
            }
        }
    }
}
