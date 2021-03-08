package com.thunder.livesdk.video;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.thunder.livesdk.ThunderMultiVideoViewParam;
import com.thunder.livesdk.ThunderRtcConstant;
import com.thunder.livesdk.helper.ThunderNative;
import com.thunder.livesdk.log.ThunderLog;
import com.yy.videoplayer.VideoDecodeEventNotify;
import com.yy.videoplayer.VideoPlayer;
import com.yy.videoplayer.VideoRenderNotify;
import com.yy.videoplayer.decoder.YYVideoLibMgr;
import com.yy.videoplayer.stat.IYMFBehaviorEventListener;
import com.yy.videoplayer.stat.YMFPlayerStatisticManager;
import com.yy.videoplayer.stat.YMFPlayerUsrBehaviorStat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes6.dex */
public class ThunderVideoPlayEngineImp implements IThunderVideoPlay, IYMFBehaviorEventListener {
    private static final String TAG = "ThunderVideoPlayEngineImp";
    private static final int VIDEO_STATE_DECODER_TYPE = 3;
    private static final int VIDEO_STATE_RESOLUTION = 2;
    private static final int VIDEO_STAT_BITRATE = 1;
    private static final int VIDEO_STAT_FPS = 0;
    private static long mCallBackPtr = 0;
    private static ReentrantReadWriteLock s_observerLock = null;
    private ConcurrentHashMap<String, Long> mMultiStreamKeyIdMap;
    private ConcurrentHashMap<String, Integer> mMultiVideoMirrorModeMap;
    private ConcurrentHashMap<String, Integer> mMultiVideoScaleModeMap;
    private ConcurrentHashMap<Long, Long> mUidToVideoIdCallBackInDualStreamMap;
    private ConcurrentHashMap<Long, StrUidVideoDecodeObserver> mVideoDecodeObserverMap;
    private ThunderVideoHiidoUtil mVideoPlayHiidoUtil;
    private ConcurrentHashMap<String, VideoStreamInfo> mVideoStreamInfoMap;
    public final int INVALID_VALUE = -1;
    private HandlerThread mThunderVideoHandlerThread = null;
    private Handler mThunderVideoHandler = null;
    private ConcurrentHashMap<String, String> mStreamKeyStrUidMap = new ConcurrentHashMap<>();
    private Map<Long, Long> mC2JavaUidMap = new HashMap();
    private AtomicBoolean mThunderPlayerMultiViewMode = new AtomicBoolean(false);
    private ThunderVideoPlayListener mThunderVideoPlayListener = null;
    private HashMap<Integer, ThunderPlayerMultiViewProxy> mThunderPlayerMultiViewProxyMap = new HashMap<>(10);
    private HashMap<String, ThunderPlayerMultiViewProxy> mVideoMultiViewMap = new HashMap<>();
    private HashMap<String, ThunderPlayerMultiViewProxy> mVideoMultiViewRecoverMap = new HashMap<>();

    private native void onFirstFrameDecodeNotify(long j, long j2, long j3, long j4);

    private native void onFirstFrameRender(long j, long j2, int i, int i2, long j3);

    private native void onHardwareDecodeError(long j, long j2, long j3, int i);

    private native void onMultiViewSeatInfoNotify(long j, long j2, int i);

    private native void onVideoDecodedFrames(long j, VideoDecodeEventNotify videoDecodeEventNotify);

    private native void onVideoRenderedFrames(long j, ArrayList<VideoRenderNotify> arrayList);

    private native void onViewStateNotify(long j, long j2, int i);

    @Override // com.thunder.livesdk.video.IThunderVideoPlay
    public void onViewStateNotify(long j, int i) {
        if (mCallBackPtr != 0) {
            onViewStateNotify(mCallBackPtr, j, i);
        }
    }

    @Override // com.thunder.livesdk.video.IThunderVideoPlay
    public void onVideoRenderNotify(ArrayList<VideoRenderNotify> arrayList) {
        if (mCallBackPtr != 0) {
            onVideoRenderedFrames(mCallBackPtr, arrayList);
        }
    }

    @Override // com.thunder.livesdk.video.IThunderVideoPlay
    public void onVideoDecodeNotify(VideoDecodeEventNotify videoDecodeEventNotify) {
        if (mCallBackPtr != 0) {
            onVideoDecodedFrames(mCallBackPtr, videoDecodeEventNotify);
        }
    }

    @Override // com.thunder.livesdk.video.IThunderVideoPlay
    public void onFirstFrameRenderNotify(long j, int i, int i2, long j2) {
        if (mCallBackPtr != 0) {
            onFirstFrameRender(mCallBackPtr, j, i, i2, j2);
        }
    }

    public void onMultiViewSeatInfoChangedNotify(long j, int i) {
    }

    @Override // com.thunder.livesdk.video.IThunderVideoPlay
    public void onHardwareDecodeErrorNotify(long j, long j2, int i) {
        if (mCallBackPtr != 0) {
            onHardwareDecodeError(mCallBackPtr, j, j2, i);
        }
    }

    @Override // com.thunder.livesdk.video.IThunderVideoPlay
    public void onDecodedFrameData(long j, int i, int i2, byte[] bArr, int i3, long j2) {
        boolean z;
        try {
            s_observerLock.readLock().lock();
            long j3 = j >> 32;
            long longValue = this.mC2JavaUidMap.get(Long.valueOf(j3)) == null ? (int) j3 : this.mC2JavaUidMap.get(Long.valueOf(j3)).longValue();
            if (this.mVideoDecodeObserverMap == null || this.mVideoDecodeObserverMap.isEmpty()) {
                if (ThunderLog.isInfoValid()) {
                    ThunderLog.info(TAG, "onDecodedFrameData empty observer map");
                }
            } else {
                StrUidVideoDecodeObserver strUidVideoDecodeObserver = this.mVideoDecodeObserverMap.get(Long.valueOf(longValue));
                if (strUidVideoDecodeObserver == null) {
                    if (ThunderLog.isInfoValid()) {
                        ThunderLog.info(TAG, "onVideoDecodedFrame not found decoder uid %d", Long.valueOf(longValue));
                    }
                } else {
                    IVideoDecodeObserver observer = strUidVideoDecodeObserver.getObserver();
                    if (observer == null) {
                        if (ThunderLog.isInfoValid()) {
                            ThunderLog.info(TAG, "onVideoDecodedFrame not found observer uid %d:", Long.valueOf(longValue));
                        }
                    } else {
                        if (this.mUidToVideoIdCallBackInDualStreamMap.get(Long.valueOf(longValue)) == null || this.mUidToVideoIdCallBackInDualStreamMap.get(Long.valueOf(longValue)).longValue() == j) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            observer.onVideoDecodeFrame(strUidVideoDecodeObserver.getStrUid(), i, i2, bArr, i3, j2);
                        }
                    }
                }
            }
        } catch (Exception e) {
            ThunderLog.error(TAG, "onDecodedFrameData err=%s", e.toString());
        } finally {
            s_observerLock.readLock().unlock();
        }
    }

    @Override // com.thunder.livesdk.video.IThunderVideoPlay
    public void onFirstFrameDecodeNotify(long j, long j2, long j3) {
        if (mCallBackPtr != 0) {
            onFirstFrameDecodeNotify(mCallBackPtr, j, j2, j3);
        }
    }

    @Override // com.yy.videoplayer.stat.IYMFBehaviorEventListener
    public void onBehaviorEvent(String str, String str2, String str3, int i) {
        ThunderNative.makeBehaviorEvent(str, str2, str3, i);
    }

    public void playInit() {
        this.mThunderVideoPlayListener = new ThunderVideoPlayListener(YYVideoLibMgr.instance().getAppContext(), this);
        YYVideoLibMgr.instance().setVideoInfoListener("Thunder", this.mThunderVideoPlayListener);
        this.mVideoPlayHiidoUtil = new ThunderVideoHiidoUtil(YYVideoLibMgr.instance().getAppContext());
        this.mVideoPlayHiidoUtil.register();
        if (s_observerLock == null) {
            s_observerLock = new ReentrantReadWriteLock();
        }
        this.mVideoDecodeObserverMap = new ConcurrentHashMap<>();
        this.mThunderVideoHandlerThread = new HandlerThread("ThunderPlayEngine");
        this.mThunderVideoHandlerThread.setPriority(10);
        this.mThunderVideoHandlerThread.start();
        this.mThunderVideoHandler = new Handler(this.mThunderVideoHandlerThread.getLooper());
        this.mVideoStreamInfoMap = new ConcurrentHashMap<>();
        this.mMultiVideoScaleModeMap = new ConcurrentHashMap<>();
        this.mMultiVideoMirrorModeMap = new ConcurrentHashMap<>();
        this.mMultiStreamKeyIdMap = new ConcurrentHashMap<>();
        this.mUidToVideoIdCallBackInDualStreamMap = new ConcurrentHashMap<>();
        YMFPlayerUsrBehaviorStat.getInstance().setYMFBehaviorEventListener(this);
        setRemotePlayType(1);
        new ThunderVideoConfig().AsyncLoad();
    }

    public int startPlayVideoStream(final String str, final Object obj, final int i, final int i2, final int i3, final boolean z) {
        if (str == null || str.isEmpty()) {
            ThunderLog.error(TAG, "ERROR startPlayVideoStream without right key:%s, scaleMode:%d, mirrorMode:%d, bSupportHdwDecode:%b", str, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z));
            return -1;
        }
        ThunderLog.release(TAG, "startPlayVideoStream streamKey:" + str + " toView:" + obj + " scaleMode:" + i + " mirrorMode:" + i2 + " encodeType:" + i3 + " bSupportHdwDecode:" + z);
        if (this.mThunderVideoHandler != null) {
            if (Thread.currentThread().getId() == this.mThunderVideoHandler.getLooper().getThread().getId()) {
                if (!this.mThunderPlayerMultiViewMode.get()) {
                    startPlayNormalVideoStream(str, obj, i, i2);
                } else {
                    startPlayMultiVideoStream(str, obj, i, i2, i3, z);
                }
            } else {
                this.mThunderVideoHandler.post(new Runnable() { // from class: com.thunder.livesdk.video.ThunderVideoPlayEngineImp.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!ThunderVideoPlayEngineImp.this.mThunderPlayerMultiViewMode.get()) {
                            ThunderVideoPlayEngineImp.this.startPlayNormalVideoStream(str, obj, i, i2);
                        } else {
                            ThunderVideoPlayEngineImp.this.startPlayMultiVideoStream(str, obj, i, i2, i3, z);
                        }
                    }
                });
            }
        }
        return 0;
    }

    public boolean switchDualVideoView(final String str, final String str2, final int i) {
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty()) {
            ThunderLog.error(TAG, "ERROR switchDualVideoView without right dstkey:%s, srcKey:%s", str, str2);
            return false;
        }
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(TAG, "switchDualVideoView dstStreamKey:%s srcStreamKey:%s dstEncodeType:%d", str, str2, Integer.valueOf(i));
        }
        if (this.mThunderVideoHandler != null) {
            if (Thread.currentThread().getId() == this.mThunderVideoHandler.getLooper().getThread().getId()) {
                switchDualVideoViewUI(str, str2, i);
                return true;
            }
            this.mThunderVideoHandler.post(new Runnable() { // from class: com.thunder.livesdk.video.ThunderVideoPlayEngineImp.2
                @Override // java.lang.Runnable
                public void run() {
                    ThunderVideoPlayEngineImp.this.switchDualVideoViewUI(str, str2, i);
                }
            });
            return true;
        }
        return true;
    }

    public int stopPlayVideoStream(final String str) {
        ThunderLog.release(TAG, "stopPlayVideoStream streamKey:" + str);
        if (this.mThunderVideoHandler != null) {
            if (Thread.currentThread().getId() == this.mThunderVideoHandler.getLooper().getThread().getId()) {
                if (!this.mThunderPlayerMultiViewMode.get()) {
                    stopPlayNormalVideoStream(str);
                    return 0;
                }
                ThunderPlayerMultiViewProxy thunderPlayerMultiViewProxy = this.mVideoMultiViewMap.get(str);
                if (thunderPlayerMultiViewProxy != null) {
                    thunderPlayerMultiViewProxy.unlink(str);
                    this.mVideoMultiViewMap.remove(str);
                    return 0;
                }
                return 0;
            }
            this.mThunderVideoHandler.post(new Runnable() { // from class: com.thunder.livesdk.video.ThunderVideoPlayEngineImp.3
                @Override // java.lang.Runnable
                public void run() {
                    if (!ThunderVideoPlayEngineImp.this.mThunderPlayerMultiViewMode.get()) {
                        ThunderVideoPlayEngineImp.this.stopPlayNormalVideoStream(str);
                        return;
                    }
                    ThunderPlayerMultiViewProxy thunderPlayerMultiViewProxy2 = (ThunderPlayerMultiViewProxy) ThunderVideoPlayEngineImp.this.mVideoMultiViewMap.get(str);
                    if (thunderPlayerMultiViewProxy2 != null) {
                        thunderPlayerMultiViewProxy2.unlink(str);
                        ThunderVideoPlayEngineImp.this.mVideoMultiViewMap.remove(str);
                    }
                }
            });
            return 0;
        }
        return 0;
    }

    public Object getPlayVideoScreenshot(String str) {
        if (this.mThunderVideoHandler != null) {
            if (!this.mThunderPlayerMultiViewMode.get()) {
                return this.mVideoStreamInfoMap.get(str).getThunderPlayerView().getVideoScreenshot(-1);
            }
            return this.mVideoMultiViewMap.get(str).getVideoScreenshot(str);
        }
        return null;
    }

    public void addVideoFrameObserver(long j, String str, Object obj) {
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(TAG, "addVideoFrameObserver uid: %d, strUid: %s, observer %s", Long.valueOf(j), str, obj.toString());
        }
        try {
            s_observerLock.writeLock().lock();
            if (this.mVideoDecodeObserverMap.get(Long.valueOf(j)) == null) {
                this.mVideoDecodeObserverMap.put(Long.valueOf(j), new StrUidVideoDecodeObserver());
            }
            this.mVideoDecodeObserverMap.get(Long.valueOf(j)).setStrUid(str);
            this.mVideoDecodeObserverMap.get(Long.valueOf(j)).setObserver((IVideoDecodeObserver) obj);
        } catch (Exception e) {
            ThunderLog.error(TAG, "addVideoFrameObserver err=%s", e.toString());
        } finally {
            s_observerLock.writeLock().unlock();
        }
    }

    public void removeVideoFrameObserver(long j, String str) {
        ThunderLog.release(TAG, "removeVideoFrameObserver uid: %d, strUid %s", Long.valueOf(j), str);
        try {
            s_observerLock.writeLock().lock();
            if (this.mVideoDecodeObserverMap.get(Long.valueOf(j)) != null) {
                this.mVideoDecodeObserverMap.get(Long.valueOf(j)).removeObserver();
            }
            if (this.mC2JavaUidMap.containsValue(Long.valueOf(j))) {
                Iterator<Long> it = this.mC2JavaUidMap.keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Long next = it.next();
                    if (this.mC2JavaUidMap.get(next).longValue() == j) {
                        this.mC2JavaUidMap.remove(next);
                        break;
                    }
                }
            }
            if (this.mUidToVideoIdCallBackInDualStreamMap.get(Long.valueOf(j)) != null) {
                this.mUidToVideoIdCallBackInDualStreamMap.remove(Long.valueOf(j));
            }
        } catch (Exception e) {
            ThunderLog.error(TAG, "removeVideoFrameObserver err=%s", e.toString());
        } finally {
            s_observerLock.writeLock().unlock();
        }
    }

    public void addVideoFrameObserverInDualStream(long j, long j2, Object obj) {
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(TAG, "addVideoFrameObserverInDualStream uid: %d, streamId: %d", Long.valueOf(j), Long.valueOf(j2));
        }
        try {
            s_observerLock.writeLock().lock();
            this.mUidToVideoIdCallBackInDualStreamMap.put(Long.valueOf(j), Long.valueOf(j2));
        } catch (Exception e) {
            ThunderLog.error(TAG, "addVideoFrameObserverInDualStream err=%s", e.toString());
        } finally {
            s_observerLock.writeLock().unlock();
        }
    }

    public boolean updatePlayVideoView(final String str, final Object obj, final int i, final int i2) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(TAG, "updatePlayVideoView streamKey:" + str + " toView:" + obj + " scaleMode:" + i + " mirrorMode:" + i2);
        }
        if (this.mThunderVideoHandler != null) {
            if (Thread.currentThread().getId() == this.mThunderVideoHandler.getLooper().getThread().getId()) {
                if (!this.mThunderPlayerMultiViewMode.get()) {
                    updateNormalPlayVideoView(str, obj, i, i2);
                } else {
                    if (obj != null && this.mVideoMultiViewMap.get(str) != null) {
                        if (this.mVideoMultiViewMap.get(str).getVideoPlayerView() != null && !this.mVideoMultiViewMap.get(str).getVideoPlayerView().equals(obj)) {
                            ThunderLog.warn(TAG, "may toView is change!");
                            return false;
                        }
                        this.mMultiVideoMirrorModeMap.put(str, Integer.valueOf(i2));
                        this.mMultiVideoScaleModeMap.put(str, Integer.valueOf(i));
                        this.mVideoMultiViewMap.get(str).setMirrorMode(str, i2);
                        this.mVideoMultiViewMap.get(str).setScaleMode(str, i);
                    }
                    return false;
                }
            } else {
                this.mThunderVideoHandler.post(new Runnable() { // from class: com.thunder.livesdk.video.ThunderVideoPlayEngineImp.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!ThunderVideoPlayEngineImp.this.mThunderPlayerMultiViewMode.get()) {
                            ThunderVideoPlayEngineImp.this.updateNormalPlayVideoView(str, obj, i, i2);
                        } else if (obj != null && ThunderVideoPlayEngineImp.this.mVideoMultiViewMap.get(str) != null) {
                            if (((ThunderPlayerMultiViewProxy) ThunderVideoPlayEngineImp.this.mVideoMultiViewMap.get(str)).getVideoPlayerView() == null || ((ThunderPlayerMultiViewProxy) ThunderVideoPlayEngineImp.this.mVideoMultiViewMap.get(str)).getVideoPlayerView().equals(obj)) {
                                ThunderVideoPlayEngineImp.this.mMultiVideoMirrorModeMap.put(str, Integer.valueOf(i2));
                                ThunderVideoPlayEngineImp.this.mMultiVideoScaleModeMap.put(str, Integer.valueOf(i));
                                ((ThunderPlayerMultiViewProxy) ThunderVideoPlayEngineImp.this.mVideoMultiViewMap.get(str)).setMirrorMode(str, i2);
                                ((ThunderPlayerMultiViewProxy) ThunderVideoPlayEngineImp.this.mVideoMultiViewMap.get(str)).setScaleMode(str, i);
                                return;
                            }
                            ThunderLog.warn(ThunderVideoPlayEngineImp.TAG, "may toView is change!");
                        }
                    }
                });
            }
        }
        return true;
    }

    public int onVideoStreamArrive(final String str, final long j, final String str2) {
        VideoDecodeRuntimeInfo.instance().addVideoStream(j, str2);
        ThunderLog.release(TAG, "onVideoStreamArrive:%s-%d strUid:%s", str, Long.valueOf(j), str2);
        if (this.mThunderVideoHandler != null) {
            if (Thread.currentThread().getId() == this.mThunderVideoHandler.getLooper().getThread().getId()) {
                if (!this.mThunderPlayerMultiViewMode.get()) {
                    this.mStreamKeyStrUidMap.put(str, str2);
                    updatePlayNormalVideoStream(str, j);
                } else {
                    this.mMultiStreamKeyIdMap.put(str, Long.valueOf(j));
                    this.mStreamKeyStrUidMap.put(str, str2);
                    startPlayVideoStreamArrive(str, j);
                }
            } else {
                this.mThunderVideoHandler.post(new Runnable() { // from class: com.thunder.livesdk.video.ThunderVideoPlayEngineImp.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!ThunderVideoPlayEngineImp.this.mThunderPlayerMultiViewMode.get()) {
                            ThunderVideoPlayEngineImp.this.mStreamKeyStrUidMap.put(str, str2);
                            ThunderVideoPlayEngineImp.this.updatePlayNormalVideoStream(str, j);
                            return;
                        }
                        ThunderVideoPlayEngineImp.this.mMultiStreamKeyIdMap.put(str, Long.valueOf(j));
                        ThunderVideoPlayEngineImp.this.mStreamKeyStrUidMap.put(str, str2);
                        ThunderVideoPlayEngineImp.this.startPlayVideoStreamArrive(str, j);
                    }
                });
            }
        }
        try {
            s_observerLock.writeLock().lock();
            if (this.mC2JavaUidMap.get(Long.valueOf(j >> 32)) != null) {
                long longValue = this.mC2JavaUidMap.get(Long.valueOf(j >> 32)).longValue();
                if (this.mVideoDecodeObserverMap.get(Long.valueOf(longValue)) == null) {
                    this.mVideoDecodeObserverMap.put(Long.valueOf(longValue), new StrUidVideoDecodeObserver());
                }
                this.mVideoDecodeObserverMap.get(Long.valueOf(longValue)).setbObserverEnable(true);
            }
        } catch (Exception e) {
            ThunderLog.error(TAG, "onVideoStreamArrive err=%s", e.toString());
        } finally {
            s_observerLock.writeLock().unlock();
        }
        return 0;
    }

    public int onVideoStreamStop(final String str, final long j) {
        ThunderLog.release(TAG, "onVideoStreamStop streamKey:" + str + " streamId:" + j);
        if (this.mThunderVideoHandler != null) {
            if (Thread.currentThread().getId() == this.mThunderVideoHandler.getLooper().getThread().getId()) {
                if (!this.mThunderPlayerMultiViewMode.get()) {
                    onNormalVideoStreamStop(str, j);
                } else if (this.mVideoMultiViewMap.get(str) == null) {
                    ThunderLog.warn(TAG, "onVideoStreamStop: cann't find video view for stream:%s", str);
                    return -1;
                } else {
                    ThunderLog.release(TAG, "onVideoStreamStop unlink stream:%s-%d", str, Long.valueOf(j));
                    this.mVideoMultiViewMap.get(str).unlink(str);
                }
            } else {
                this.mThunderVideoHandler.post(new Runnable() { // from class: com.thunder.livesdk.video.ThunderVideoPlayEngineImp.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!ThunderVideoPlayEngineImp.this.mThunderPlayerMultiViewMode.get()) {
                            ThunderVideoPlayEngineImp.this.onNormalVideoStreamStop(str, j);
                        } else if (ThunderVideoPlayEngineImp.this.mVideoMultiViewMap.get(str) == null) {
                            ThunderLog.warn(ThunderVideoPlayEngineImp.TAG, "onVideoStreamStop: cann't find video view for stream:%s", str);
                        } else {
                            ThunderLog.release(ThunderVideoPlayEngineImp.TAG, "onVideoStreamStop unlink stream:%s-%d", str, Long.valueOf(j));
                            ((ThunderPlayerMultiViewProxy) ThunderVideoPlayEngineImp.this.mVideoMultiViewMap.get(str)).unlink(str);
                        }
                    }
                });
            }
        }
        try {
            s_observerLock.readLock().lock();
            if (this.mC2JavaUidMap.get(Long.valueOf(j >> 32)) != null) {
                long longValue = this.mC2JavaUidMap.get(Long.valueOf(j >> 32)).longValue();
                StrUidVideoDecodeObserver strUidVideoDecodeObserver = this.mVideoDecodeObserverMap.get(Long.valueOf(longValue));
                if (strUidVideoDecodeObserver != null) {
                    strUidVideoDecodeObserver.setbObserverEnable(false);
                }
                if (this.mUidToVideoIdCallBackInDualStreamMap.get(Long.valueOf(longValue)) != null) {
                    this.mUidToVideoIdCallBackInDualStreamMap.remove(Long.valueOf(longValue));
                }
            }
        } catch (Exception e) {
            ThunderLog.error(TAG, "onVideoStreamStop err=%s", e.toString());
        } finally {
            s_observerLock.readLock().unlock();
        }
        VideoDecodeRuntimeInfo.instance().removeVideoStream(j);
        return 0;
    }

    public void setVideoPlayEngineCallBack(long j) {
        mCallBackPtr = j;
    }

    public static String getVideoPlayLibVersion() {
        return "200.3.3.101";
    }

    public String getAudienceHiidoStatInfo(long j) {
        if (this.mVideoPlayHiidoUtil == null) {
            return "";
        }
        ThunderVideoHiidoUtil thunderVideoHiidoUtil = this.mVideoPlayHiidoUtil;
        return ThunderVideoHiidoUtil.getAudienceStatInfo();
    }

    public long getPlayRuntimeInfo(long j, int i) {
        switch (i) {
            case 0:
                return VideoPlayer.getInstance().getPlayerInfo(j, VideoPlayer.VideoPlayerInfoEnum.FRAME);
            case 1:
                return VideoPlayer.getInstance().getPlayerInfo(j, VideoPlayer.VideoPlayerInfoEnum.BITRATE);
            case 2:
                return VideoPlayer.getInstance().getPlayerInfo(j, VideoPlayer.VideoPlayerInfoEnum.RESOLUTION);
            case 3:
                return VideoPlayer.getInstance().getPlayerInfo(j, VideoPlayer.VideoPlayerInfoEnum.DECODERTYPE);
            default:
                return 0L;
        }
    }

    public boolean queryOnlyDecoded(long j, long j2) {
        IVideoDecodeObserver iVideoDecodeObserver;
        StrUidVideoDecodeObserver strUidVideoDecodeObserver;
        try {
            s_observerLock.readLock().lock();
            this.mC2JavaUidMap.put(Long.valueOf(j >> 32), Long.valueOf(j2));
            if (this.mVideoDecodeObserverMap == null || this.mVideoDecodeObserverMap.isEmpty()) {
                iVideoDecodeObserver = null;
                strUidVideoDecodeObserver = null;
            } else {
                strUidVideoDecodeObserver = this.mVideoDecodeObserverMap.get(Long.valueOf(j2));
                iVideoDecodeObserver = strUidVideoDecodeObserver != null ? strUidVideoDecodeObserver.getObserver() : null;
            }
            return (strUidVideoDecodeObserver == null || iVideoDecodeObserver == null) ? false : true;
        } catch (Exception e) {
            ThunderLog.error(TAG, "queryOnlyDecoded err=%s", e.toString());
            return false;
        } finally {
            s_observerLock.readLock().unlock();
        }
    }

    public void initMultiPlayerViewLayout(Object obj) {
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(TAG, "initMultiPlayerViewLayout params:" + obj);
        }
        if (this.mThunderVideoHandler != null && obj != null) {
            final ThunderMultiVideoViewParam thunderMultiVideoViewParam = (ThunderMultiVideoViewParam) obj;
            if (Thread.currentThread().getId() == this.mThunderVideoHandler.getLooper().getThread().getId()) {
                initMultiLayout(thunderMultiVideoViewParam, this);
            } else {
                this.mThunderVideoHandler.post(new Runnable() { // from class: com.thunder.livesdk.video.ThunderVideoPlayEngineImp.7
                    @Override // java.lang.Runnable
                    public void run() {
                        ThunderVideoPlayEngineImp.this.initMultiLayout(thunderMultiVideoViewParam, this);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initMultiLayout(ThunderMultiVideoViewParam thunderMultiVideoViewParam, ThunderVideoPlayEngineImp thunderVideoPlayEngineImp) {
        if (thunderMultiVideoViewParam == null) {
            ThunderLog.error(TAG, "initMultiPlayerViewLayout params null");
        } else if (this.mThunderPlayerMultiViewMode.get()) {
            int i = thunderMultiVideoViewParam.mViewId;
            Object obj = thunderMultiVideoViewParam.mView;
            ThunderLog.error(TAG, "initMultiPlayerViewLayout params:" + thunderMultiVideoViewParam + "  mView:" + obj + " viewId:" + i);
            if (i >= 0) {
                if (obj != null && checkMultiViewExist(obj, i)) {
                    ThunderLog.error(TAG, "repeated view, already exist，" + obj);
                    int multiViewId = getMultiViewId(obj);
                    if (multiViewId < 0 && multiViewId != -4001) {
                        this.mThunderPlayerMultiViewProxyMap.put(Integer.valueOf(i), this.mThunderPlayerMultiViewProxyMap.remove(Integer.valueOf(multiViewId)));
                    }
                    if (this.mThunderPlayerMultiViewProxyMap.containsKey(Integer.valueOf(i))) {
                        this.mThunderPlayerMultiViewProxyMap.get(Integer.valueOf(i)).initMultiPlayerViewLayout(thunderMultiVideoViewParam);
                        return;
                    }
                    return;
                }
                if (this.mThunderPlayerMultiViewProxyMap.get(Integer.valueOf(i)) == null) {
                    this.mThunderPlayerMultiViewProxyMap.put(Integer.valueOf(i), new ThunderPlayerMultiViewProxy(YYVideoLibMgr.instance().getAppContext(), thunderVideoPlayEngineImp));
                }
                this.mThunderPlayerMultiViewProxyMap.get(Integer.valueOf(i)).initMultiPlayerViewLayout(thunderMultiVideoViewParam);
                this.mThunderPlayerMultiViewProxyMap.get(Integer.valueOf(i)).updateMultiPlayerView(obj);
            }
            if (i < 0) {
                if (this.mThunderPlayerMultiViewProxyMap.get(Integer.valueOf(i)) == null) {
                    this.mThunderPlayerMultiViewProxyMap.put(Integer.valueOf(i), new ThunderPlayerMultiViewProxy(YYVideoLibMgr.instance().getAppContext(), thunderVideoPlayEngineImp));
                }
                this.mThunderPlayerMultiViewProxyMap.get(Integer.valueOf(i)).initMultiPlayerViewLayout(thunderMultiVideoViewParam);
            }
            if (obj == null && i >= 0 && this.mThunderPlayerMultiViewProxyMap.containsKey(Integer.valueOf(i))) {
                this.mThunderPlayerMultiViewProxyMap.remove(Integer.valueOf(i));
            }
        }
    }

    public void onPlayEngineLeaveRoom() {
        if (Thread.currentThread().getId() == this.mThunderVideoHandler.getLooper().getThread().getId()) {
            for (Map.Entry<Integer, ThunderPlayerMultiViewProxy> entry : this.mThunderPlayerMultiViewProxyMap.entrySet()) {
                ThunderPlayerMultiViewProxy value = entry.getValue();
                if (value != null) {
                    value.quitRoom();
                }
            }
            this.mVideoMultiViewMap.clear();
            this.mVideoMultiViewRecoverMap.clear();
            this.mStreamKeyStrUidMap.clear();
            return;
        }
        this.mThunderVideoHandler.post(new Runnable() { // from class: com.thunder.livesdk.video.ThunderVideoPlayEngineImp.8
            @Override // java.lang.Runnable
            public void run() {
                for (Map.Entry entry2 : ThunderVideoPlayEngineImp.this.mThunderPlayerMultiViewProxyMap.entrySet()) {
                    ThunderPlayerMultiViewProxy thunderPlayerMultiViewProxy = (ThunderPlayerMultiViewProxy) entry2.getValue();
                    if (thunderPlayerMultiViewProxy != null) {
                        thunderPlayerMultiViewProxy.quitRoom();
                    }
                }
                ThunderVideoPlayEngineImp.this.mVideoMultiViewMap.clear();
                ThunderVideoPlayEngineImp.this.mVideoMultiViewRecoverMap.clear();
                ThunderVideoPlayEngineImp.this.mStreamKeyStrUidMap.clear();
            }
        });
    }

    public void setVideoPlayType(final int i) {
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(TAG, "setVideoPlayType playType:" + i);
        }
        if (this.mThunderVideoHandler != null) {
            if (Thread.currentThread().getId() == this.mThunderVideoHandler.getLooper().getThread().getId()) {
                setRemotePlayType(i);
            } else {
                this.mThunderVideoHandler.post(new Runnable() { // from class: com.thunder.livesdk.video.ThunderVideoPlayEngineImp.9
                    @Override // java.lang.Runnable
                    public void run() {
                        ThunderVideoPlayEngineImp.this.setRemotePlayType(i);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRemotePlayType(int i) {
        if (i == 1) {
            if (ThunderLog.isInfoValid()) {
                ThunderLog.info(TAG, "multiLianMai mode " + i);
            }
            this.mThunderPlayerMultiViewMode.set(true);
            return;
        }
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(TAG, "non-multiLianMai mode " + i);
        }
        clearMultiView();
        this.mThunderPlayerMultiViewProxyMap.clear();
        this.mVideoMultiViewMap.clear();
        this.mVideoMultiViewRecoverMap.clear();
        this.mStreamKeyStrUidMap.clear();
        this.mThunderPlayerMultiViewMode.set(false);
    }

    private void initDefaultMultiViewParam(int i) {
        ThunderMultiVideoViewParam thunderMultiVideoViewParam = new ThunderMultiVideoViewParam();
        ThunderMultiVideoViewCoordinate thunderMultiVideoViewCoordinate = new ThunderMultiVideoViewCoordinate();
        thunderMultiVideoViewCoordinate.mIndex = 0;
        thunderMultiVideoViewCoordinate.mHeight = -2;
        thunderMultiVideoViewCoordinate.mWidth = -2;
        thunderMultiVideoViewCoordinate.mX = 0;
        thunderMultiVideoViewCoordinate.mY = 0;
        thunderMultiVideoViewParam.mVideoViewPositions = new ArrayList<>(1);
        thunderMultiVideoViewParam.mVideoViewPositions.add(thunderMultiVideoViewCoordinate);
        thunderMultiVideoViewParam.mViewId = i;
        initMultiPlayerViewLayout(thunderMultiVideoViewParam);
    }

    public boolean updateUserSeat(final String str, final Object obj, final int i) {
        ThunderLog.release(TAG, "updateUserSeat streamKey:" + str + " toView:" + obj + " seat:" + i);
        if (this.mThunderVideoHandler != null) {
            if (Thread.currentThread().getId() == this.mThunderVideoHandler.getLooper().getThread().getId()) {
                if (this.mThunderPlayerMultiViewMode.get()) {
                    if (obj == null) {
                        ThunderLog.error(TAG, "updateUserSeat toView null");
                        return false;
                    } else if (this.mVideoMultiViewMap.get(str) != null && findMultiViewProxy(obj) != null) {
                        if (!(this.mVideoMultiViewMap.get(str).updateSeat(str, i) >= 0)) {
                            return false;
                        }
                        int intValue = this.mMultiVideoScaleModeMap.get(str) == null ? -1 : this.mMultiVideoScaleModeMap.get(str).intValue();
                        if (intValue != -1) {
                            this.mVideoMultiViewMap.get(str).setScaleMode(str, intValue);
                        }
                        int intValue2 = this.mMultiVideoMirrorModeMap.get(str) == null ? -1 : this.mMultiVideoMirrorModeMap.get(str).intValue();
                        if (intValue2 != -1) {
                            this.mVideoMultiViewMap.get(str).setMirrorMode(str, intValue2);
                        }
                    }
                }
            } else {
                this.mThunderVideoHandler.post(new Runnable() { // from class: com.thunder.livesdk.video.ThunderVideoPlayEngineImp.10
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ThunderVideoPlayEngineImp.this.mThunderPlayerMultiViewMode.get()) {
                            Object obj2 = obj;
                            if (obj2 != null) {
                                if (ThunderVideoPlayEngineImp.this.mVideoMultiViewMap.get(str) != null && ThunderVideoPlayEngineImp.this.findMultiViewProxy(obj2) != null) {
                                    if (((ThunderPlayerMultiViewProxy) ThunderVideoPlayEngineImp.this.mVideoMultiViewMap.get(str)).updateSeat(str, i) >= 0) {
                                        int intValue3 = ThunderVideoPlayEngineImp.this.mMultiVideoScaleModeMap.get(str) == null ? -1 : ((Integer) ThunderVideoPlayEngineImp.this.mMultiVideoScaleModeMap.get(str)).intValue();
                                        if (intValue3 != -1) {
                                            ((ThunderPlayerMultiViewProxy) ThunderVideoPlayEngineImp.this.mVideoMultiViewMap.get(str)).setScaleMode(str, intValue3);
                                        }
                                        int intValue4 = ThunderVideoPlayEngineImp.this.mMultiVideoMirrorModeMap.get(str) == null ? -1 : ((Integer) ThunderVideoPlayEngineImp.this.mMultiVideoMirrorModeMap.get(str)).intValue();
                                        if (intValue4 != -1) {
                                            ((ThunderPlayerMultiViewProxy) ThunderVideoPlayEngineImp.this.mVideoMultiViewMap.get(str)).setMirrorMode(str, intValue4);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            ThunderLog.error(ThunderVideoPlayEngineImp.TAG, "updateUserSeat toView null");
                        }
                    }
                });
            }
        }
        return true;
    }

    public ThunderPlayerMultiViewProxy findMultiViewProxy(Object obj) {
        for (Map.Entry<Integer, ThunderPlayerMultiViewProxy> entry : this.mThunderPlayerMultiViewProxyMap.entrySet()) {
            ThunderPlayerMultiViewProxy value = entry.getValue();
            if (value.getVideoPlayerView() == obj) {
                return value;
            }
        }
        return null;
    }

    public boolean checkMultiViewExist(Object obj, int i) {
        if (obj == null || i < 0) {
            return false;
        }
        for (Map.Entry<Integer, ThunderPlayerMultiViewProxy> entry : this.mThunderPlayerMultiViewProxyMap.entrySet()) {
            if (entry.getValue().getVideoPlayerView() == obj && entry.getKey().intValue() != i) {
                ThunderLog.error(TAG, "view " + obj + "already locate in viewId:" + entry.getKey());
                return true;
            }
        }
        return false;
    }

    private int getMultiViewId(Object obj) {
        if (obj == null) {
            return ThunderRtcConstant.ThunderRet.THUNDER_RET_VIDEO_ENGINE_ERROR;
        }
        for (Map.Entry<Integer, ThunderPlayerMultiViewProxy> entry : this.mThunderPlayerMultiViewProxyMap.entrySet()) {
            if (entry.getValue().getVideoPlayerView() == obj) {
                return entry.getKey().intValue();
            }
        }
        return ThunderRtcConstant.ThunderRet.THUNDER_RET_VIDEO_ENGINE_ERROR;
    }

    public void clearMultiView() {
        for (Map.Entry<Integer, ThunderPlayerMultiViewProxy> entry : this.mThunderPlayerMultiViewProxyMap.entrySet()) {
            ThunderPlayerMultiViewProxy value = entry.getValue();
            if (value != null) {
                value.destroyVideoPlayerView();
            }
        }
    }

    public void destroyPlayEngine() {
        YMFPlayerUsrBehaviorStat.getInstance().setYMFBehaviorEventListener(null);
        if (this.mVideoPlayHiidoUtil != null) {
            this.mVideoPlayHiidoUtil.unRegister();
        }
        try {
            if (this.mThunderVideoHandler != null) {
                if (Build.VERSION.SDK_INT >= 18) {
                    this.mThunderVideoHandlerThread.quitSafely();
                } else {
                    this.mThunderVideoHandlerThread.quit();
                }
                this.mThunderVideoHandler = null;
                this.mThunderVideoHandlerThread = null;
            }
            s_observerLock.writeLock().lock();
            this.mVideoDecodeObserverMap.clear();
            this.mUidToVideoIdCallBackInDualStreamMap.clear();
        } catch (Exception e) {
            ThunderLog.error(TAG, "destroyPlayEngine err=%s", e.toString());
        } finally {
            s_observerLock.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean updateNormalPlayVideoView(String str, Object obj, int i, int i2) {
        VideoStreamInfo videoStreamInfo = this.mVideoStreamInfoMap.get(str);
        if (videoStreamInfo == null) {
            ThunderLog.error(TAG, "updatePlayVideoView unexist info key:" + str);
            return false;
        } else if (obj != null && !(obj instanceof ThunderPlayerView)) {
            ThunderLog.error(TAG, "updateNormalPlayVideoView toView error:" + obj);
            return false;
        } else {
            long streamId = videoStreamInfo.getStreamId();
            ThunderPlayerView thunderPlayerView = (ThunderPlayerView) obj;
            ThunderPlayerView thunderPlayerView2 = videoStreamInfo.getThunderPlayerView();
            ThunderLog.release(TAG, "updateNormalPlayVideoView key " + str + " toView " + obj + " oldView " + thunderPlayerView2 + " scaleMode " + i + " mirrorMode " + i2);
            if (thunderPlayerView2 == null && thunderPlayerView == null) {
                return false;
            }
            if (thunderPlayerView2 == null && thunderPlayerView != null) {
                videoStreamInfo.setThunderPlayerView(thunderPlayerView);
                thunderPlayerView.unLinkFromStream();
                if (-1 != streamId) {
                    thunderPlayerView.linkToStream(streamId);
                    thunderPlayerView.setScaleMode(i);
                    thunderPlayerView.setMirrorMode(-1, i2);
                    videoStreamInfo.setScaleMode(i);
                    videoStreamInfo.setMirrorMode(i2);
                }
                return true;
            } else if (thunderPlayerView2 != null && thunderPlayerView == null) {
                if (-1 != streamId) {
                    thunderPlayerView2.unLinkFromStream();
                    thunderPlayerView2.drawBlackScreen(true);
                }
                videoStreamInfo.setThunderPlayerView(null);
                return true;
            } else if ((obj instanceof ThunderPlayerView) && !thunderPlayerView2.equals(obj)) {
                ThunderLog.warn(TAG, "may toView is change!");
                return false;
            } else {
                videoStreamInfo.setScaleMode(i);
                videoStreamInfo.setMirrorMode(i2);
                thunderPlayerView2.setScaleMode(i);
                thunderPlayerView2.setMirrorMode(-1, i2);
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int startPlayNormalVideoStream(String str, Object obj, int i, int i2) {
        ThunderLog.release(TAG, "startPlayNormalVideoStream key:%s, scaleMode:%d, mirrorMode:%d", str, Integer.valueOf(i), Integer.valueOf(i2));
        checkStartPlayDualStream(str);
        VideoStreamInfo streamInfo = getStreamInfo(str);
        ThunderPlayerView thunderPlayerView = streamInfo.getThunderPlayerView();
        if (obj != null && (obj instanceof ThunderPlayerView)) {
            ThunderPlayerView thunderPlayerView2 = (ThunderPlayerView) obj;
            if (thunderPlayerView != null) {
                if (!thunderPlayerView2.equals(thunderPlayerView)) {
                    thunderPlayerView.unLinkFromStream();
                    thunderPlayerView.drawBlackScreen(true);
                    ThunderLog.release(TAG, "startPlayNormalVideoStream changed view old:" + thunderPlayerView + " new:" + thunderPlayerView2);
                } else if (ThunderLog.isInfoValid()) {
                    ThunderLog.info(TAG, "startPlayNormalVideoStream the same view old:" + thunderPlayerView + " new:" + thunderPlayerView2);
                }
            }
            thunderPlayerView2.setScaleMode(i);
            thunderPlayerView2.setMirrorMode(-1, i2);
            streamInfo.setThunderPlayerView(thunderPlayerView2);
        }
        ThunderPlayerView thunderPlayerView3 = streamInfo.getThunderPlayerView();
        if (thunderPlayerView3 != null) {
            if (!streamInfo.isViewPrepared()) {
                thunderPlayerView3.unLinkFromStream();
                if (streamInfo.getStreamId() != -1) {
                    thunderPlayerView3.linkToStream(streamInfo.getStreamId());
                }
            }
            if (!streamInfo.isLinkedToStream()) {
                if (streamInfo.getStreamId() != -1) {
                    thunderPlayerView3.linkToStream(streamInfo.getStreamId());
                    ThunderLog.release(TAG, "startPlayNormalVideoStream linkToStream %d", Long.valueOf(streamInfo.getStreamId()));
                }
            } else {
                ThunderLog.warn(TAG, "startPlayNormalVideoStream has linkedToStream %d", Long.valueOf(streamInfo.getStreamId()));
            }
        } else {
            ThunderLog.warn(TAG, "ERROR startPlayNormalVideoStream view is null");
        }
        streamInfo.setScaleMode(i);
        streamInfo.setMirrorMode(i2);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int stopPlayNormalVideoStream(String str) {
        VideoStreamInfo videoStreamInfo = this.mVideoStreamInfoMap.get(str);
        if (videoStreamInfo == null) {
            ThunderLog.release(TAG, "ERROR stopPlayNormalVideoStream unexsited key:%s", str);
            return -1;
        }
        ThunderLog.release(TAG, "stopPlayNormalVideoStream %s", str);
        ThunderPlayerView thunderPlayerView = videoStreamInfo.getThunderPlayerView();
        if (thunderPlayerView != null) {
            thunderPlayerView.unLinkFromStream();
            thunderPlayerView.drawBlackScreen(true);
        } else {
            ThunderLog.release(TAG, "ERROR stopPlayNormalVideoStream unexsited view");
        }
        this.mVideoStreamInfoMap.remove(str);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int onNormalVideoStreamStop(String str, long j) {
        VideoStreamInfo videoStreamInfo = this.mVideoStreamInfoMap.get(str);
        if (videoStreamInfo == null) {
            ThunderLog.release(TAG, "onVideoStreamStop key:%s unexisted", str);
            return -1;
        }
        ThunderPlayerView thunderPlayerView = videoStreamInfo.getThunderPlayerView();
        if (thunderPlayerView == null) {
            ThunderLog.warn(TAG, "onVideoStreamStop: cann't find video view for stream:%s", str);
            return -1;
        }
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(TAG, "unlink stream:%s-%d", str, Long.valueOf(j));
        }
        thunderPlayerView.unLinkFromStream(j);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int startPlayMultiVideoStream(String str, Object obj, int i, int i2, int i3, boolean z) {
        if (obj != null) {
            ThunderPlayerMultiViewProxy findMultiViewProxy = findMultiViewProxy(obj);
            if (findMultiViewProxy != null) {
                if (this.mVideoMultiViewMap.get(str) != null) {
                    ThunderPlayerMultiViewProxy thunderPlayerMultiViewProxy = this.mVideoMultiViewMap.get(str);
                    if (thunderPlayerMultiViewProxy != null && thunderPlayerMultiViewProxy != findMultiViewProxy) {
                        thunderPlayerMultiViewProxy.unlink(str);
                    }
                    this.mVideoMultiViewRecoverMap.put(str, thunderPlayerMultiViewProxy);
                }
                this.mVideoMultiViewMap.put(str, findMultiViewProxy);
                checkStartPlayDualStream(str);
            } else {
                ThunderLog.warn(TAG, "initMultiPlayerViewLayout not called " + obj);
                ThunderPlayerMultiViewProxy thunderPlayerMultiViewProxy2 = this.mVideoMultiViewMap.get(str);
                if (thunderPlayerMultiViewProxy2 != null) {
                    thunderPlayerMultiViewProxy2.unlink(str);
                }
                int defaultViewId = getDefaultViewId();
                initDefaultMultiViewParam(defaultViewId);
                ThunderPlayerMultiViewProxy thunderPlayerMultiViewProxy3 = this.mThunderPlayerMultiViewProxyMap.get(Integer.valueOf(defaultViewId));
                if (thunderPlayerMultiViewProxy3 != null) {
                    thunderPlayerMultiViewProxy3.updateMultiPlayerView(obj);
                }
                this.mVideoMultiViewMap.put(str, thunderPlayerMultiViewProxy3);
                checkStartPlayDualStream(str);
            }
        }
        if (this.mVideoMultiViewMap.get(str) != null && this.mVideoMultiViewMap.get(str).getVideoPlayerView() != null && obj == null) {
            this.mVideoMultiViewMap.get(str).unlink(str);
            ThunderLog.release(TAG, "startPlayMultiVideoStream unlink key" + str + " view " + obj);
        } else {
            this.mMultiVideoScaleModeMap.put(str, Integer.valueOf(i));
            this.mMultiVideoMirrorModeMap.put(str, Integer.valueOf(i2));
            updatePlayMultiVideoStream(str, this.mMultiStreamKeyIdMap.get(str) == null ? -1L : this.mMultiStreamKeyIdMap.get(str).longValue());
            ThunderLog.release(TAG, "startPlayMultiVideoStream key:%s, streamType:%d, scaleMode:%d, mirrorMode:%d, bSupportHdwDecode:%b", str, Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z));
        }
        return 0;
    }

    private int getDefaultViewId() {
        int i = -1;
        while (i > Integer.MIN_VALUE && this.mThunderPlayerMultiViewProxyMap.containsKey(Integer.valueOf(i))) {
            i--;
        }
        return i;
    }

    private VideoStreamInfo getStreamInfo(String str) {
        if (!this.mVideoStreamInfoMap.containsKey(str)) {
            VideoStreamInfo videoStreamInfo = new VideoStreamInfo();
            this.mVideoStreamInfoMap.put(str, videoStreamInfo);
            return videoStreamInfo;
        }
        return this.mVideoStreamInfoMap.get(str);
    }

    private int updatePlayMultiVideoStream(String str, long j) {
        ThunderLog.release(TAG, "updatePlayVideoStream streamKey:" + str + " streamId " + j);
        if (str == null) {
            ThunderLog.error(TAG, "updatePlayMultiVideoStream, streamKey null");
            return ThunderRtcConstant.ThunderRet.THUNDER_RET_VIDEO_ENGINE_ERROR;
        }
        if (this.mVideoMultiViewMap.get(str) != null) {
            ThunderLog.release(TAG, "updatePlayVideoStream, bindStreamToSeat streamKey " + str + " streamId " + j);
            this.mVideoMultiViewMap.get(str).prepareStreamSeat(str, j);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int startPlayVideoStreamArrive(String str, long j) {
        ThunderLog.release(TAG, "startPlayVideoStreamArrive streamKey:" + str + " streamId " + j);
        if (str == null) {
            ThunderLog.error(TAG, "updatePlayMultiVideoStream, streamKey null");
            return ThunderRtcConstant.ThunderRet.THUNDER_RET_VIDEO_ENGINE_ERROR;
        }
        if (this.mVideoMultiViewMap.get(str) != null) {
            ThunderLog.release(TAG, "startPlayVideoStreamArrive, bindStreamToSeat streamKey " + str + " streamId " + j);
            this.mVideoMultiViewMap.get(str).bindStreamToSeat(str, j);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int updatePlayNormalVideoStream(String str, long j) {
        VideoStreamInfo streamInfo = getStreamInfo(str);
        ThunderPlayerView thunderPlayerView = streamInfo.getThunderPlayerView();
        if (thunderPlayerView != null) {
            long streamId = streamInfo.getStreamId();
            if (streamId != -1 && streamId != j && streamInfo.isLinkedToStream()) {
                thunderPlayerView.unLinkFromStream(streamId);
            }
            if (!streamInfo.isViewPrepared()) {
                thunderPlayerView.unLinkFromStream();
            }
            if (!streamInfo.isLinkedToStream()) {
                thunderPlayerView.linkToStream(j);
            }
            thunderPlayerView.setScaleMode(streamInfo.getScaleMode());
            thunderPlayerView.setMirrorMode(-1, streamInfo.getMirrorMode());
            thunderPlayerView.drawBlackScreen(false);
        } else {
            ThunderLog.warn(TAG, "updatePlayNormalVideoStream: cannot find video view for stream:%s", str);
        }
        streamInfo.setStreamId(j);
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(TAG, "updatePlayNormalVideoStream key:%s,id:%d,isPrepared:%b,isLinked:%b", str, Long.valueOf(j), Boolean.valueOf(streamInfo.isViewPrepared()), Boolean.valueOf(streamInfo.isLinkedToStream()));
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean switchDualVideoViewUI(String str, String str2, int i) {
        if (!this.mThunderPlayerMultiViewMode.get()) {
            VideoStreamInfo streamInfo = getStreamInfo(str2);
            VideoStreamInfo streamInfo2 = getStreamInfo(str);
            streamInfo2.setEncodeType(i);
            streamInfo2.setScaleMode(streamInfo.getScaleMode());
            streamInfo2.setMirrorMode(streamInfo.getMirrorMode());
            ThunderPlayerView thunderPlayerView = streamInfo.getThunderPlayerView();
            if (thunderPlayerView != null) {
                thunderPlayerView.unLinkFromStream();
                streamInfo2.setThunderPlayerView(thunderPlayerView);
            }
            ThunderPlayerView thunderPlayerView2 = streamInfo2.getThunderPlayerView();
            if (thunderPlayerView2 != null) {
                if (!thunderPlayerView2.isViewPrepared()) {
                    thunderPlayerView2.unLinkFromStream();
                    if (streamInfo2.getStreamId() != -1) {
                        thunderPlayerView2.linkToStream(streamInfo2.getStreamId());
                    }
                    ThunderLog.release(TAG, "switchDualVideoViewUI dstStreamView unPrepared, dstkey:%s, streamId %d", str, Long.valueOf(streamInfo2.getStreamId()));
                }
                if (!streamInfo2.isLinkedToStream()) {
                    if (streamInfo2.getStreamId() != -1) {
                        thunderPlayerView2.linkToStream(streamInfo2.getStreamId());
                        ThunderLog.release(TAG, "switchDualVideoViewUI linkToStream dstkey:%s, streamId %d", str, Long.valueOf(streamInfo2.getStreamId()));
                    }
                } else {
                    ThunderLog.release(TAG, "switchDualVideoViewUI has linkToStream dstkey:%s, streamId %d", str, Long.valueOf(streamInfo2.getStreamId()));
                }
                this.mVideoStreamInfoMap.remove(str2);
                return true;
            }
            ThunderLog.release(TAG, "switchDualVideoViewUI normal view is null dstKey:%s, srcKey:%s", str, str2);
            return true;
        }
        ThunderPlayerMultiViewProxy thunderPlayerMultiViewProxy = this.mVideoMultiViewMap.get(str2);
        int intValue = this.mMultiVideoScaleModeMap.get(str2) == null ? -1 : this.mMultiVideoScaleModeMap.get(str2).intValue();
        if (intValue != -1) {
            this.mMultiVideoScaleModeMap.put(str, Integer.valueOf(intValue));
        }
        int intValue2 = this.mMultiVideoMirrorModeMap.get(str2) == null ? -1 : this.mMultiVideoMirrorModeMap.get(str2).intValue();
        if (intValue2 != -1) {
            this.mMultiVideoMirrorModeMap.put(str, Integer.valueOf(intValue2));
        }
        long longValue = this.mMultiStreamKeyIdMap.get(str) == null ? -1L : this.mMultiStreamKeyIdMap.get(str).longValue();
        if (thunderPlayerMultiViewProxy != null && thunderPlayerMultiViewProxy.switchDualVideoView(str2, str, longValue) >= 0) {
            this.mVideoMultiViewMap.remove(str2);
            this.mVideoMultiViewMap.put(str, thunderPlayerMultiViewProxy);
        }
        ThunderLog.release(TAG, "switchDualVideoViewUI multiView linkToStream dstkey:%s, srcKey:%s dstStreamId %d", str, str2, Long.valueOf(longValue));
        return true;
    }

    private void checkStartPlayDualStream(String str) {
        String str2;
        if (str != null && this.mStreamKeyStrUidMap.containsKey(str)) {
            String str3 = null;
            String str4 = this.mStreamKeyStrUidMap.get(str);
            if (str4 != null && this.mStreamKeyStrUidMap != null && this.mStreamKeyStrUidMap.size() > 0) {
                for (Map.Entry<String, String> entry : this.mStreamKeyStrUidMap.entrySet()) {
                    String value = entry.getValue();
                    if (!str4.equals(value) || str.equals(entry.getKey())) {
                        str2 = str3;
                    } else {
                        str2 = entry.getKey();
                        ThunderLog.warn(TAG, "find dualStream duplicate streamKey:" + str2 + " cur:" + str + " uid:" + value);
                    }
                    str3 = str2;
                }
            }
            if (str3 != null && !str3.isEmpty()) {
                if (this.mThunderPlayerMultiViewMode.get() && this.mVideoMultiViewMap.containsKey(str3)) {
                    this.mVideoMultiViewMap.get(str3).unlink(str3);
                    this.mVideoMultiViewMap.remove(str3);
                    ThunderLog.warn(TAG, "remove dup streamKey:" + str3);
                }
                if (!this.mThunderPlayerMultiViewMode.get() && this.mVideoStreamInfoMap.containsKey(str3)) {
                    if (this.mVideoStreamInfoMap.get(str3).getThunderPlayerView() != null && this.mVideoStreamInfoMap.get(str3).isLinkedToStream()) {
                        this.mVideoStreamInfoMap.get(str3).getThunderPlayerView().unLinkFromStream();
                    }
                    this.mVideoStreamInfoMap.remove(str3);
                    ThunderLog.warn(TAG, "remove dup streamKey:" + str3);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class StrUidVideoDecodeObserver {
        private boolean bObserverEnable = false;
        private IVideoDecodeObserver observer;
        private String strUid;

        public StrUidVideoDecodeObserver() {
        }

        public void setStrUid(String str) {
            this.strUid = str;
        }

        public String getStrUid() {
            return this.strUid;
        }

        public void setObserver(IVideoDecodeObserver iVideoDecodeObserver) {
            this.observer = iVideoDecodeObserver;
        }

        public IVideoDecodeObserver getObserver() {
            return this.observer;
        }

        public void removeObserver() {
            this.observer = null;
        }

        public void setbObserverEnable(boolean z) {
            this.bObserverEnable = z;
        }

        public boolean isbObserverEnable() {
            return this.bObserverEnable;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class VideoStreamInfo {
        private int mMirrorMode;
        private long mStreamId = -1;
        private ThunderPlayerView mThunderPlayerView = null;
        private int mIsSoftDecodeFlag = -1;
        private int mEncodeType = 1;
        private int mScaleMode = -1;

        public VideoStreamInfo() {
            ThunderLog.release(ThunderVideoPlayEngineImp.TAG, "VideoStreamInfo: " + this + " construct streamId:%d", Long.valueOf(this.mStreamId));
        }

        public long getStreamId() {
            return this.mStreamId;
        }

        public void setStreamId(long j) {
            this.mStreamId = j;
            ThunderLog.release(ThunderVideoPlayEngineImp.TAG, "VideoStreamInfo setStreamId " + j);
        }

        public ThunderPlayerView getThunderPlayerView() {
            return this.mThunderPlayerView;
        }

        public void setThunderPlayerView(ThunderPlayerView thunderPlayerView) {
            this.mThunderPlayerView = thunderPlayerView;
            if (thunderPlayerView != null) {
                ThunderLog.release(ThunderVideoPlayEngineImp.TAG, "VideoStreamInfo setThunderPlayerView streamId:" + this.mStreamId + " view:" + thunderPlayerView);
            } else {
                ThunderLog.error(ThunderVideoPlayEngineImp.TAG, "VideoStreamInfo setThunderPlayerView null");
            }
        }

        public int getIsSoftDecodeFlag() {
            return this.mIsSoftDecodeFlag;
        }

        public void setIsSoftDecodeFlag(int i) {
            this.mIsSoftDecodeFlag = i;
            ThunderLog.release(ThunderVideoPlayEngineImp.TAG, "VideoStreamInfo streamId:" + this.mStreamId + " setIsSoftDecodeFlag " + i);
        }

        public int getEncodeType() {
            return this.mEncodeType;
        }

        public void setEncodeType(int i) {
            this.mEncodeType = i;
            ThunderLog.release(ThunderVideoPlayEngineImp.TAG, "VideoStreamInfo streamId:" + this.mStreamId + " setEncodeType " + this.mEncodeType);
        }

        public int getScaleMode() {
            return this.mScaleMode;
        }

        public void setScaleMode(int i) {
            this.mScaleMode = i;
            ThunderLog.release(ThunderVideoPlayEngineImp.TAG, "VideoStreamInfo streamId:" + this.mStreamId + " setScaleMode " + i);
        }

        public void setMirrorMode(int i) {
            this.mMirrorMode = i;
            ThunderLog.release(ThunderVideoPlayEngineImp.TAG, "VideoStreamInfo streamId:" + this.mStreamId + " setMirrorMode " + i);
        }

        public int getMirrorMode() {
            return this.mMirrorMode;
        }

        public boolean isLinkedToStream() {
            boolean z = false;
            if (this.mThunderPlayerView != null) {
                z = this.mThunderPlayerView.isViewLinkedToStream();
            }
            ThunderLog.release(ThunderVideoPlayEngineImp.TAG, "VideoStreamInfo streamId:" + this.mStreamId + " isLinkedToStream " + z);
            return z;
        }

        public boolean isViewPrepared() {
            boolean z = false;
            if (this.mThunderPlayerView != null) {
                z = this.mThunderPlayerView.isViewPrepared();
            }
            ThunderLog.release(ThunderVideoPlayEngineImp.TAG, "VideoStreamInfo: " + this + "  streamId:" + this.mStreamId + " isViewPrepared " + z);
            return z;
        }
    }

    public String getVideoDecodeBaseStatics(int i) {
        return YMFPlayerStatisticManager.getInstance().getVideoDecodeBaseStatistics(i);
    }

    public String getVideoDecodeStatics(boolean z, long j) {
        String str = "";
        if (this.mVideoPlayHiidoUtil != null) {
            ThunderVideoHiidoUtil thunderVideoHiidoUtil = this.mVideoPlayHiidoUtil;
            str = ThunderVideoHiidoUtil.getAudienceStatInfo();
        }
        return YMFPlayerStatisticManager.getInstance().getVideoDecodeStatistics(z, j) + str;
    }
}
