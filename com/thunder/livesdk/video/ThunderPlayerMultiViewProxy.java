package com.thunder.livesdk.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import com.thunder.livesdk.ThunderMultiVideoViewParam;
import com.thunder.livesdk.log.ThunderLog;
import com.yy.mediaframework.Constant;
import com.yy.videoplayer.videoview.VideoPosition;
import com.yy.videoplayer.view.YMFLayoutParams;
import com.yy.videoplayer.view.YMFVideoPosition;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class ThunderPlayerMultiViewProxy {
    private static final String TAG = "ThunderPlayerView";
    private WeakReference<ThunderVideoPlayEngineImp> engineImp;
    private Constant.MultiLianmaiMode lianMaiMode;
    private YMFVideoPosition mBgVideoPosition;
    private Context mContext;
    private VideoPlayerView mPlayerView;
    private int mVideoCount;
    private YMFVideoPosition[] mVideoPositions;
    private YMFLayoutParams mYMFLayoutParams;
    private Object syncLock = new Object();
    private ConcurrentHashMap<String, Seat> mStreamKeyToSeatMap = new ConcurrentHashMap<>();

    public ThunderPlayerMultiViewProxy(Context context) {
        this.mContext = context;
    }

    public ThunderPlayerMultiViewProxy(Context context, ThunderVideoPlayEngineImp thunderVideoPlayEngineImp) {
        this.mContext = context;
        this.engineImp = new WeakReference<>(thunderVideoPlayEngineImp);
    }

    /* JADX WARN: Type inference failed for: r0v23, types: [com.thunder.livesdk.video.ThunderPlayerMultiViewProxy$1] */
    public void initMultiPlayerViewLayout(ThunderMultiVideoViewParam thunderMultiVideoViewParam) {
        int i = 0;
        if (thunderMultiVideoViewParam != null) {
            if (thunderMultiVideoViewParam.mVideoPositions != null || thunderMultiVideoViewParam.mVideoViewPositions != null) {
                if (thunderMultiVideoViewParam.mVideoViewPositions != null) {
                    int size = thunderMultiVideoViewParam.mVideoViewPositions.size();
                    this.mVideoPositions = new YMFVideoPosition[size];
                    for (int i2 = 0; i2 < size; i2++) {
                        if (thunderMultiVideoViewParam.mVideoViewPositions.get(i2).mIndex < size) {
                            this.mVideoPositions[thunderMultiVideoViewParam.mVideoViewPositions.get(i2).mIndex] = convertToVideoPosition(thunderMultiVideoViewParam.mVideoViewPositions.get(i2));
                        }
                    }
                    this.mBgVideoPosition = convertToVideoPosition(thunderMultiVideoViewParam.mBgViewPosition);
                } else if (thunderMultiVideoViewParam.mVideoPositions != null) {
                    this.mVideoPositions = new YMFVideoPosition[thunderMultiVideoViewParam.mVideoPositions.size()];
                    while (true) {
                        int i3 = i;
                        if (i3 >= thunderMultiVideoViewParam.mVideoPositions.size()) {
                            break;
                        }
                        if (thunderMultiVideoViewParam.mVideoPositions.get(i3).mIndex < thunderMultiVideoViewParam.mVideoPositions.size()) {
                            this.mVideoPositions[thunderMultiVideoViewParam.mVideoPositions.get(i3).mIndex] = convertToVideoPosition(thunderMultiVideoViewParam.mVideoPositions.get(i3));
                        }
                        i = i3 + 1;
                    }
                    this.mBgVideoPosition = convertToVideoPosition(thunderMultiVideoViewParam.mBgPosition);
                }
                int arraySize = arraySize(this.mVideoPositions);
                this.mYMFLayoutParams = new YMFLayoutParams(arraySize);
                this.mYMFLayoutParams.mDrawPosition = this.mVideoPositions;
                this.mYMFLayoutParams.backgroudPosition = this.mBgVideoPosition;
                this.mYMFLayoutParams.background = thunderMultiVideoViewParam.mBgBitmap;
                this.lianMaiMode = (Constant.MultiLianmaiMode) new SparseArray<Constant.MultiLianmaiMode>(10) { // from class: com.thunder.livesdk.video.ThunderPlayerMultiViewProxy.1
                    {
                        put(0, Constant.MultiLianmaiMode.NormalMode);
                        put(1, Constant.MultiLianmaiMode.NormalMode);
                        put(2, Constant.MultiLianmaiMode.TwoPersonMode);
                        put(3, Constant.MultiLianmaiMode.ThreePersonMode);
                        put(4, Constant.MultiLianmaiMode.FourPersonMode);
                        put(5, Constant.MultiLianmaiMode.FivePersonMode);
                        put(6, Constant.MultiLianmaiMode.SixPersonMode);
                        put(7, Constant.MultiLianmaiMode.SevenPersonMode);
                        put(8, Constant.MultiLianmaiMode.EightPersonMode);
                        put(9, Constant.MultiLianmaiMode.NinePersonMode);
                    }
                }.get(arraySize(this.mVideoPositions));
                updateLayout(arraySize);
                if (ThunderLog.isInfoValid()) {
                    ThunderLog.info(TAG, "initMultiPlayerViewLayout:" + this.mVideoCount + " " + thunderMultiVideoViewParam.toString());
                }
            }
        }
    }

    private void updateLayout(int i) {
        if (this.mPlayerView != null) {
            if (this.mVideoCount != 0 && this.mVideoCount != i) {
                resetAll();
                this.mPlayerView.updateMultiViewLayout(this.mYMFLayoutParams);
                ThunderLog.release(TAG, "need redraw, update MultiPlayerViewLayout:" + this.mVideoCount);
            } else if ((this.mVideoCount != 0 && this.mVideoCount == i) || (this.mVideoCount == 0 && this.mVideoCount < i)) {
                this.mPlayerView.updateMultiViewLayout(this.mYMFLayoutParams);
                ThunderLog.release(TAG, "just update MultiPlayerViewLayout:" + this.mVideoCount);
            }
            this.mPlayerView.enterMultiVideoViewMode(this.mYMFLayoutParams, this.lianMaiMode);
        }
        this.mVideoCount = i;
    }

    private YMFVideoPosition convertToVideoPosition(VideoPosition videoPosition) {
        if (videoPosition == null) {
            return null;
        }
        YMFVideoPosition yMFVideoPosition = new YMFVideoPosition();
        yMFVideoPosition.mX = videoPosition.mX;
        yMFVideoPosition.mY = videoPosition.mY;
        yMFVideoPosition.mHeight = videoPosition.mHeight;
        yMFVideoPosition.mWidth = videoPosition.mWidth;
        yMFVideoPosition.mIndex = videoPosition.mIndex;
        return yMFVideoPosition;
    }

    private YMFVideoPosition convertToVideoPosition(ThunderMultiVideoViewCoordinate thunderMultiVideoViewCoordinate) {
        if (thunderMultiVideoViewCoordinate == null) {
            return null;
        }
        YMFVideoPosition yMFVideoPosition = new YMFVideoPosition();
        yMFVideoPosition.mX = thunderMultiVideoViewCoordinate.mX;
        yMFVideoPosition.mY = thunderMultiVideoViewCoordinate.mY;
        yMFVideoPosition.mHeight = thunderMultiVideoViewCoordinate.mHeight;
        yMFVideoPosition.mWidth = thunderMultiVideoViewCoordinate.mWidth;
        yMFVideoPosition.mIndex = thunderMultiVideoViewCoordinate.mIndex;
        return yMFVideoPosition;
    }

    public VideoPlayerView getPlayerView() {
        return this.mPlayerView;
    }

    public void updateMultiPlayerView(Object obj) {
        ThunderLog.release(TAG, "updateMultiPlayerView enter, mPlayerView: " + this.mPlayerView + " targetView " + obj);
        if (obj == null) {
            unlink();
            synchronized (this.syncLock) {
                this.mPlayerView = null;
            }
        }
        if (this.mPlayerView == obj) {
            if (ThunderLog.isInfoValid()) {
                ThunderLog.info(TAG, "updateMultiPlayerView already exist");
                return;
            }
            return;
        }
        if (this.mPlayerView != null && this.mPlayerView != obj) {
            unlink();
            this.mPlayerView = null;
        }
        if (obj instanceof ThunderPlayerMultiView) {
            this.mPlayerView = (ThunderPlayerMultiView) obj;
        }
        if (obj instanceof ThunderPlayerView) {
            this.mPlayerView = (ThunderPlayerView) obj;
        }
        if (obj instanceof ThunderPlayerTextureView) {
            this.mPlayerView = (ThunderPlayerTextureView) obj;
        }
        if (obj instanceof ThunderPlayerSurfaceView) {
            this.mPlayerView = (ThunderPlayerSurfaceView) obj;
        }
        if (this.mPlayerView != null) {
            this.mPlayerView.enterMultiVideoViewMode(this.mYMFLayoutParams, this.lianMaiMode);
        }
        ThunderLog.release(TAG, "updateMultiPlayerView exit");
    }

    public void destroyVideoPlayerView() {
        ThunderLog.release(TAG, "destroyVideoPlayerView");
        if (this.mStreamKeyToSeatMap != null) {
            unlink();
            this.mStreamKeyToSeatMap.clear();
        }
        if (this.mPlayerView != null) {
            if (this.mYMFLayoutParams != null) {
                this.mYMFLayoutParams.background = null;
                this.mPlayerView.updateMultiViewLayout(this.mYMFLayoutParams);
            }
            this.mPlayerView.leaveMultiVideoViewMode();
        }
        this.mPlayerView = null;
        this.mYMFLayoutParams = null;
    }

    public VideoPlayerView getVideoPlayerView() {
        return this.mPlayerView;
    }

    public int switchDualVideoView(String str, String str2, long j) {
        int i = 0;
        if (str == null || str == null || j == 0 || j == -1) {
            ThunderLog.release(TAG, "switchDualVideoView  old " + str + " new:" + str2 + "streamId:" + j);
            return -1;
        }
        synchronized (this.mStreamKeyToSeatMap) {
            Seat removeSeatByStreamKey = removeSeatByStreamKey(str);
            if (removeSeatByStreamKey != null) {
                if (this.mPlayerView != null) {
                    i = this.mPlayerView.switchDualVideoView(removeSeatByStreamKey.streamId, j, removeSeatByStreamKey.seatIdx);
                }
                removeSeatByStreamKey.streamId = j;
                this.mStreamKeyToSeatMap.put(str2, removeSeatByStreamKey);
            }
        }
        return i;
    }

    public int updateSeat(String str, int i) {
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(TAG, "innerUpdateSeat() called with: uid = [" + str + "], seat = [" + i + "]");
        }
        if (i >= this.mVideoCount || str == null) {
            ThunderLog.error(TAG, "updateSeat:" + i + "maxSeats:" + this.mVideoCount + "streamKey:" + str);
            return -1;
        }
        if (this.mVideoPositions != null && this.mVideoPositions.length == 1 && this.mVideoPositions[0].mHeight == -2 && this.mVideoPositions[0].mWidth == -2 && i == -1) {
            i = 0;
        }
        return bindSeat(str, i);
    }

    private int bindSeat(String str, final int i) {
        Seat seat;
        ThunderLog.release(TAG, "bindSeat called with: uid = [" + str + "], seatNo = [" + i + "]");
        synchronized (this.mStreamKeyToSeatMap) {
            Seat findSeatByStreamKey = findSeatByStreamKey(str);
            if (findSeatByStreamKey != null && findSeatByStreamKey.seatIdx >= 0 && findSeatByStreamKey.streamId != -1 && i < 0) {
                ThunderLog.release(TAG, "bindSeat unlink:" + str + " seatId: " + i + " streamId:" + findSeatByStreamKey.streamId);
                unlink(findSeatByStreamKey);
                findSeatByStreamKey.seatIdx = -1;
                return 0;
            } else if (i < 0) {
                ThunderLog.error(TAG, "updateSeat invalid, seat " + i + " invalid!");
                return -1;
            } else {
                if (findSeatByStreamKey == null) {
                    seat = new Seat() { // from class: com.thunder.livesdk.video.ThunderPlayerMultiViewProxy.2
                        {
                            this.seatIdx = i;
                        }
                    };
                } else {
                    if (findSeatByStreamKey.seatIdx != i && findSeatByStreamKey.status == 1) {
                        if (ThunderLog.isInfoValid()) {
                            ThunderLog.info(TAG, "bindSeat updateseat had linked:" + str + ", will unlink!!");
                        }
                        unlink(findSeatByStreamKey);
                    }
                    findSeatByStreamKey.seatIdx = i;
                    if (processBusySeatIfExist(str, i) > 0) {
                        ThunderLog.error(TAG, "bindSeat busy!!");
                    }
                    seat = findSeatByStreamKey;
                }
                if (seat.seatIdx >= 0 && seat.status == 0 && seat.streamId != -1) {
                    link(seat);
                }
                this.mStreamKeyToSeatMap.put(str, seat);
                ThunderLog.release(TAG, "bindSeat updateseat streamKey:" + str + ",seat:" + i + " >> " + seat + "  streamId " + seat.streamId);
                return 0;
            }
        }
    }

    public void prepareStreamSeat(String str, long j) {
        if (str == null) {
            ThunderLog.error(TAG, "prepareStreamSeat streamKey null");
        } else if (this.mStreamKeyToSeatMap == null) {
            ThunderLog.error(TAG, "prepareStreamSeat mStreamKeyToSeatMap null");
        } else if (j == 0 || j == -1) {
            ThunderLog.error(TAG, "prepareStreamSeat streamId," + j);
        } else {
            synchronized (this.mStreamKeyToSeatMap) {
                Seat findSeatByStreamKey = findSeatByStreamKey(str);
                if (findSeatByStreamKey == null) {
                    Seat seat = new Seat();
                    seat.streamId = j;
                    this.mStreamKeyToSeatMap.put(str, seat);
                    return;
                }
                if (findSeatByStreamKey != null && findSeatByStreamKey.seatIdx >= 0 && findSeatByStreamKey.streamId != j && findSeatByStreamKey.status == 1) {
                    ThunderLog.release(TAG, "prepareStreamSeat replace and link: seatItem.streamId" + findSeatByStreamKey.streamId + " streamId:" + j);
                    unlink(findSeatByStreamKey);
                    findSeatByStreamKey.streamId = j;
                    link(findSeatByStreamKey);
                } else if (findSeatByStreamKey != null && findSeatByStreamKey.status == 0) {
                    findSeatByStreamKey.streamId = j;
                    ThunderLog.release(TAG, "prepareStreamSeat update: seatItem.streamId:" + j + " seatId:" + findSeatByStreamKey.seatIdx);
                }
            }
        }
    }

    public void bindStreamToSeat(String str, long j) {
        if (str == null) {
            ThunderLog.error(TAG, "bindStreamToSeat streamKey null");
        } else if (this.mStreamKeyToSeatMap == null) {
            ThunderLog.error(TAG, "bindStreamToSeat mStreamKeyToSeatMap null");
        } else if (j == 0 || j == -1) {
            ThunderLog.error(TAG, "bindStreamToSeat streamId," + j);
        } else {
            synchronized (this.mStreamKeyToSeatMap) {
                Seat findSeatByStreamKey = findSeatByStreamKey(str);
                if (findSeatByStreamKey == null) {
                    Seat seat = new Seat();
                    seat.streamId = j;
                    this.mStreamKeyToSeatMap.put(str, seat);
                    return;
                }
                if (findSeatByStreamKey != null && findSeatByStreamKey.seatIdx >= 0 && findSeatByStreamKey.status == 1) {
                    if (ThunderLog.isInfoValid()) {
                        ThunderLog.info(TAG, "bindStreamToSeat replace and link: seatItem.streamId" + findSeatByStreamKey.streamId + " streamId:" + j);
                    }
                    unlink(findSeatByStreamKey);
                    findSeatByStreamKey.streamId = j;
                    link(findSeatByStreamKey);
                } else if (findSeatByStreamKey != null && findSeatByStreamKey.status == 0) {
                    findSeatByStreamKey.streamId = j;
                    link(findSeatByStreamKey);
                    ThunderLog.release(TAG, "bindStreamToSeat update: seatItem.streamId:" + j + " seatId:" + findSeatByStreamKey.seatIdx);
                }
            }
        }
    }

    private int processBusySeatIfExist(String str, int i) {
        if (i >= 0) {
            Seat findSeatByStreamKey = findSeatByStreamKey(str);
            ArrayList<Seat> findSeatBySeatId = findSeatBySeatId(i);
            if (findSeatBySeatId != null && findSeatBySeatId.size() > 0) {
                Iterator<Seat> it = findSeatBySeatId.iterator();
                while (it.hasNext()) {
                    Seat next = it.next();
                    if (next != null && next != findSeatByStreamKey && next.streamId != 0 && findSeatByStreamKey.streamId != 0 && (next.streamId >> 32) != (findSeatByStreamKey.streamId >> 32)) {
                        ThunderLog.error(TAG, "processBusySeat, process streamKey" + str + " busyStreamId " + next.streamId + " seat " + i + " busy!");
                        unlink(next);
                        next.seatIdx = -1;
                        if (this.engineImp != null && this.engineImp.get() != null) {
                            this.engineImp.get().onMultiViewSeatInfoChangedNotify(next.streamId, next.seatIdx);
                        }
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    public Seat findSeatByStreamKey(String str) {
        if (this.mStreamKeyToSeatMap == null) {
            ThunderLog.error(TAG, "mStreamKeyToSeatMap null");
            return null;
        }
        Seat seat = this.mStreamKeyToSeatMap.get(str);
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(TAG, "findSeatByStreamKey:" + str + ",caches:" + this.mStreamKeyToSeatMap);
            return seat;
        }
        return seat;
    }

    public Seat removeSeatByStreamKey(String str) {
        return this.mStreamKeyToSeatMap.remove(str);
    }

    public ArrayList<Seat> findSeatBySeatId(int i) {
        ArrayList<Seat> arrayList = new ArrayList<>(0);
        if (this.mStreamKeyToSeatMap != null && i >= 0) {
            for (Map.Entry<String, Seat> entry : this.mStreamKeyToSeatMap.entrySet()) {
                Seat value = entry.getValue();
                if (value.seatIdx == i) {
                    arrayList.add(value);
                }
            }
        }
        return arrayList;
    }

    public ArrayList<String> findStreamKeyBySeatId(int i) {
        ArrayList<String> arrayList = new ArrayList<>(0);
        if (this.mStreamKeyToSeatMap != null && i >= 0) {
            for (Map.Entry<String, Seat> entry : this.mStreamKeyToSeatMap.entrySet()) {
                if (entry.getValue().seatIdx == i) {
                    arrayList.add(entry.getKey());
                }
            }
        }
        return arrayList;
    }

    public Seat findSeatByStreamId(long j) {
        if (this.mStreamKeyToSeatMap != null) {
            for (Map.Entry<String, Seat> entry : this.mStreamKeyToSeatMap.entrySet()) {
                Seat value = entry.getValue();
                if (value.streamId == j) {
                    return value;
                }
            }
        }
        return null;
    }

    private int link(Seat seat) {
        int i = -1;
        if (seat != null) {
            if (this.mPlayerView != null && seat.seatIdx >= 0 && seat.streamId != 0 && seat.status == 0) {
                i = this.mPlayerView.linkToStream(seat.streamId, seat.seatIdx);
            }
            if (i >= 0) {
                seat.status = 1;
            }
            ThunderLog.release(TAG, "link- Seat: streamId " + seat.streamId + " seatIdx " + seat.seatIdx + " mPlayerView " + this.mPlayerView + ",ret:" + i);
        } else {
            ThunderLog.error(TAG, "link- Seat:" + seat + ",ret:-1");
        }
        return i;
    }

    private int unlink(Seat seat) {
        int i = -1;
        if (seat != null) {
            if (this.mPlayerView != null && seat.seatIdx >= 0 && seat.streamId != 0 && seat.status == 1) {
                i = this.mPlayerView.unLinkFromStream(seat.streamId, seat.seatIdx);
            }
            if (i >= 0) {
                seat.status = 0;
            }
            ThunderLog.release(TAG, "unlink- Seat: streamId " + seat.streamId + " seatIdx " + seat.seatIdx + " mPlayerView " + this.mPlayerView + ",ret:" + i);
        }
        return i;
    }

    public int link(String str) {
        return link(findSeatByStreamKey(str));
    }

    public int unlink(String str) {
        return unlink(findSeatByStreamKey(str));
    }

    public void releaseSeatByStreamKey(String str) {
        synchronized (this.mStreamKeyToSeatMap) {
            this.mStreamKeyToSeatMap.remove(str);
            if (ThunderLog.isInfoValid()) {
                ThunderLog.info(TAG, "releaseSeatByStreamKey- Seat:" + str);
            }
        }
    }

    public int unlink() {
        if (this.mStreamKeyToSeatMap != null) {
            for (Map.Entry<String, Seat> entry : this.mStreamKeyToSeatMap.entrySet()) {
                Seat value = entry.getValue();
                if (value != null) {
                    unlink(value);
                }
            }
            return 0;
        }
        return 0;
    }

    public int link() {
        if (this.mStreamKeyToSeatMap != null) {
            for (Map.Entry<String, Seat> entry : this.mStreamKeyToSeatMap.entrySet()) {
                Seat value = entry.getValue();
                if (value != null) {
                    link(value);
                }
            }
            return 0;
        }
        return 0;
    }

    public void resetAll() {
        if (this.mStreamKeyToSeatMap != null) {
            unlinkAndReset();
            ThunderLog.release(TAG, "resetAll");
        }
    }

    public void quitRoom() {
        ThunderLog.release(TAG, "quitRoom");
        resetAll();
        this.mStreamKeyToSeatMap.clear();
    }

    public int unlinkAndReset() {
        if (this.mStreamKeyToSeatMap != null) {
            for (Map.Entry<String, Seat> entry : this.mStreamKeyToSeatMap.entrySet()) {
                Seat value = entry.getValue();
                if (value != null) {
                    unlink(value);
                    value.seatIdx = -1;
                    if (this.engineImp != null && this.engineImp.get() != null) {
                        this.engineImp.get().onMultiViewSeatInfoChangedNotify(value.streamId, value.seatIdx);
                    }
                }
            }
            return 0;
        }
        return 0;
    }

    public boolean setScaleMode(int i) {
        ThunderLog.release(TAG, "setScaleMode:" + i);
        boolean z = true;
        if (this.mStreamKeyToSeatMap == null || this.mPlayerView == null) {
            return true;
        }
        Iterator<Map.Entry<String, Seat>> it = this.mStreamKeyToSeatMap.entrySet().iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return z2;
            }
            Seat value = it.next().getValue();
            if (value != null && value.seatIdx >= 0) {
                z2 &= this.mPlayerView.setScaleMode(value.seatIdx, i);
            }
            z = z2;
        }
    }

    public boolean setScaleMode(String str, int i) {
        Seat findSeatByStreamKey;
        ThunderLog.release(TAG, "setScaleMode: " + str + " " + i);
        if (this.mStreamKeyToSeatMap == null || this.mPlayerView == null || i < 0 || (findSeatByStreamKey = findSeatByStreamKey(str)) == null) {
            return true;
        }
        return this.mPlayerView.setScaleMode(findSeatByStreamKey.seatIdx, i);
    }

    public void setMirrorMode(String str, int i) {
        Seat findSeatByStreamKey;
        ThunderLog.release(TAG, "setMirrorMode: " + str + " " + i);
        if (this.mStreamKeyToSeatMap != null && this.mPlayerView != null && (findSeatByStreamKey = findSeatByStreamKey(str)) != null) {
            this.mPlayerView.setMirrorMode(findSeatByStreamKey.seatIdx, i);
        }
    }

    public Bitmap getVideoScreenshot(String str) {
        Seat findSeatByStreamKey;
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(TAG, "getVideoScreenshot: " + str);
        }
        if (this.mStreamKeyToSeatMap == null || this.mPlayerView == null || (findSeatByStreamKey = findSeatByStreamKey(str)) == null) {
            return null;
        }
        return this.mPlayerView.getVideoScreenshot(findSeatByStreamKey.seatIdx);
    }

    public static <T> int arraySize(T[] tArr) {
        if (tArr == null) {
            return 0;
        }
        return tArr.length;
    }

    /* loaded from: classes4.dex */
    public static class Seat {
        private static final int STATUS_IDEL = 0;
        private static final int STATUS_LINK = 1;
        public int seatIdx = -1;
        public long streamId = 0;
        public int status = 0;

        public String toString() {
            return "Seat{, seatIdx=" + this.seatIdx + ", status=" + this.status + '}';
        }
    }
}
