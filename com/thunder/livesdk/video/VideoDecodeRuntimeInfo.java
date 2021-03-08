package com.thunder.livesdk.video;

import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobstat.Config;
import com.yy.videoplayer.VideoPlayer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class VideoDecodeRuntimeInfo {
    private static VideoDecodeRuntimeInfo mInstance;
    private Map<Long, DecodeRuntimeInfo> mDecodeRuntimeInfoMap = new ConcurrentHashMap();

    public static VideoDecodeRuntimeInfo instance() {
        if (mInstance == null) {
            mInstance = new VideoDecodeRuntimeInfo();
        }
        return mInstance;
    }

    public void addVideoStream(long j, String str) {
        if (!this.mDecodeRuntimeInfoMap.containsKey(Long.valueOf(j))) {
            this.mDecodeRuntimeInfoMap.put(Long.valueOf(j), new DecodeRuntimeInfo(str));
        }
    }

    public void removeVideoStream(long j) {
        if (this.mDecodeRuntimeInfoMap.containsKey(Long.valueOf(j))) {
            this.mDecodeRuntimeInfoMap.remove(Long.valueOf(j));
        }
    }

    private String getDecodeTypeName(int i) {
        switch (i) {
            case 0:
                return "DEC_TYPE_H264_HW_OFFSCREEEN";
            case 1:
                return "DEC_TYPE_H265_HW_OFFSCREEEN";
            case 2:
                return "DEC_TYPE_H264_SW_FFMPEG";
            case 3:
                return "DEC_TYPE_H265_SW_ITTIAM";
            case 4:
                return "DEC_TYPE_VP8_SW_DECVP8";
            default:
                return RomUtils.UNKNOWN;
        }
    }

    public String getDecodeRuntimeInfoString() {
        String str;
        String str2 = "";
        for (Map.Entry<Long, DecodeRuntimeInfo> entry : this.mDecodeRuntimeInfoMap.entrySet()) {
            Long key = entry.getKey();
            DecodeRuntimeInfo value = entry.getValue();
            if (value != null) {
                value.fps = (int) VideoPlayer.getInstance().getPlayerInfo(key.longValue(), VideoPlayer.VideoPlayerInfoEnum.FRAME);
                value.bitrate = ((int) VideoPlayer.getInstance().getPlayerInfo(key.longValue(), VideoPlayer.VideoPlayerInfoEnum.BITRATE)) / 1000;
                value.decoderType = (int) VideoPlayer.getInstance().getPlayerInfo(key.longValue(), VideoPlayer.VideoPlayerInfoEnum.DECODERTYPE);
                value.resolution = (int) VideoPlayer.getInstance().getPlayerInfo(key.longValue(), VideoPlayer.VideoPlayerInfoEnum.RESOLUTION);
                if (value.fps != -1) {
                    str = str2 + "\r\nuid: " + value.strUid + "\r\nfps: " + value.fps + "\r\nbitrate: " + value.bitrate + "kb/s \r\ndecoderType: " + getDecodeTypeName(value.decoderType) + "\r\nresolution: " + (value.resolution >> 16) + Config.EVENT_HEAT_X + (value.resolution & 65535) + "\r\n";
                }
            } else {
                str = str2;
            }
            str2 = str;
        }
        return str2;
    }

    /* loaded from: classes6.dex */
    private class DecodeRuntimeInfo {
        public int bitrate;
        public int decoderType;
        public int fps;
        public int resolution;
        public String strUid;

        public DecodeRuntimeInfo(String str) {
            this.strUid = str;
        }
    }
}
