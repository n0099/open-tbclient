package com.yy.videoplayer;

import java.util.HashMap;
/* loaded from: classes4.dex */
public class VideoPlayer implements IVideoPlayerInfo {
    private static VideoPlayer mInstance;
    private HashMap<Long, VideoPlayerInfo> mHashMap = new HashMap<>();

    /* loaded from: classes4.dex */
    public enum VideoPlayerInfoEnum {
        RESOLUTION,
        FRAME,
        BITRATE,
        DECODERTYPE
    }

    public static VideoPlayer getInstance() {
        if (mInstance == null) {
            mInstance = new VideoPlayer();
        }
        return mInstance;
    }

    private VideoPlayer() {
    }

    public long getPlayerInfo(long j, VideoPlayerInfoEnum videoPlayerInfoEnum) {
        long j2;
        VideoPlayerInfo videoPlayerInfo = this.mHashMap.get(Long.valueOf(j));
        if (videoPlayerInfo == null) {
            return -1L;
        }
        if (VideoPlayerInfoEnum.FRAME.ordinal() == videoPlayerInfoEnum.ordinal()) {
            j2 = videoPlayerInfo.mFramerate;
        } else if (VideoPlayerInfoEnum.RESOLUTION.ordinal() == videoPlayerInfoEnum.ordinal()) {
            j2 = videoPlayerInfo.mHeight | (videoPlayerInfo.mWidth << 16);
        } else if (VideoPlayerInfoEnum.BITRATE.ordinal() == videoPlayerInfoEnum.ordinal()) {
            j2 = videoPlayerInfo.mBitrate;
        } else if (VideoPlayerInfoEnum.DECODERTYPE.ordinal() != videoPlayerInfoEnum.ordinal()) {
            j2 = -1;
        } else {
            j2 = videoPlayerInfo.mType;
        }
        return j2;
    }

    @Override // com.yy.videoplayer.IVideoPlayerInfo
    public void pushVideoPlayerInfo(long j, int i, int i2, int i3, int i4, int i5) {
        VideoPlayerInfo videoPlayerInfo = this.mHashMap.get(Long.valueOf(j));
        if (videoPlayerInfo == null) {
            videoPlayerInfo = new VideoPlayerInfo(i, i2, i3, i4, i5);
        }
        if (i2 != -1) {
            videoPlayerInfo.mHeight = i2;
        }
        if (i != -1) {
            videoPlayerInfo.mWidth = i;
        }
        if (i3 != -1) {
            videoPlayerInfo.mFramerate = i3;
        }
        if (i4 != -1) {
            videoPlayerInfo.mBitrate = i4;
        }
        if (i5 != -1) {
            videoPlayerInfo.mType = i5;
        }
        this.mHashMap.put(Long.valueOf(j), videoPlayerInfo);
    }

    @Override // com.yy.videoplayer.IVideoPlayerInfo
    public void deleteVideoPlayerInfo(long j) {
        this.mHashMap.remove(Long.valueOf(j));
    }
}
