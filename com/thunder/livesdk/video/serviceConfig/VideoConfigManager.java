package com.thunder.livesdk.video.serviceConfig;

import com.baidu.ar.auth.FeatureCodes;
import com.baidu.searchbox.perfframe.basic.PerfFrameTrackUIUtil;
import com.thunder.livesdk.ThunderPublishInfo;
import com.thunder.livesdk.ThunderPublishVideoConfig;
import com.thunder.livesdk.helper.ThunderNative;
import com.thunder.livesdk.log.ThunderLog;
import com.thunder.livesdk.video.serviceConfig.VideoLiveConfig;
import com.yy.mediaframework.CameraPreviewConfig;
import com.yy.mediaframework.YYVideoCodec;
import com.yy.mediaframework.base.VideoEncoderConfig;
import com.yy.mediaframework.base.VideoEncoderType;
import com.yy.mediaframework.inteligence.common.ResolutionModifyConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class VideoConfigManager {
    private static final String TAG = "cfg_VideoConfigManage";
    private int mCurMultiLianMaiUsers;
    private VideoLiveConfig mCurrentConfig;
    private int mCurrentVideoLevel;
    public boolean mDisableHardDecode;
    public boolean mDisableHardEncode;
    private boolean mPreviewShareCtx;
    private boolean mUseClear;
    private HashMap<Integer, VideoLiveConfig> mVideoConfigsList;

    public void updateCurLianMaiUsers(int i) {
        this.mCurMultiLianMaiUsers = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class SingletonHolder {
        private static final VideoConfigManager INSTANCE = new VideoConfigManager();

        private SingletonHolder() {
        }
    }

    public static VideoConfigManager instance() {
        return SingletonHolder.INSTANCE;
    }

    private VideoConfigManager() {
        this.mCurrentConfig = null;
        this.mCurrentVideoLevel = -1;
        this.mDisableHardEncode = false;
        this.mDisableHardDecode = false;
        this.mPreviewShareCtx = true;
        this.mUseClear = false;
        this.mVideoConfigsList = new HashMap<>();
        this.mCurMultiLianMaiUsers = 0;
    }

    private VideoLiveConfig getVideoLiveConfigByPlayType(int i) {
        VideoLiveConfig videoLiveConfig;
        synchronized (this) {
            videoLiveConfig = this.mVideoConfigsList.get(Integer.valueOf(i));
        }
        return videoLiveConfig;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0036, code lost:
        if (r0.previewFrameRate <= 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0038, code lost:
        r1 = r0.previewFrameRate;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003a, code lost:
        r2.mCaptureFrameRate = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003e, code lost:
        if (r0.previewWidth <= 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0040, code lost:
        r1 = r0.previewWidth;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0042, code lost:
        r2.mCaptureResolutionWidth = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0046, code lost:
        if (r0.previewHeight <= 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0048, code lost:
        r1 = r0.previewHeight;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004a, code lost:
        r2.mCaptureResolutionHeight = r1;
        r6.mCurrentConfig = r3;
        r6.mCurrentVideoLevel = r0.key;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008e, code lost:
        r1 = r2.mCaptureFrameRate;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0091, code lost:
        r1 = r2.mCaptureResolutionWidth;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0094, code lost:
        r1 = r2.mCaptureResolutionHeight;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CameraPreviewConfig getCameraPreviewConfigByType(int i, int i2) {
        CameraPreviewConfig cameraPreviewConfig = new CameraPreviewConfig();
        VideoLiveConfig videoLiveConfigByPlayType = getVideoLiveConfigByPlayType(i);
        if (videoLiveConfigByPlayType == null) {
            ThunderLog.error(TAG, " getCameraPreviewConfigByType failed, return default!");
            return cameraPreviewConfig;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= videoLiveConfigByPlayType.resolutions.size()) {
                break;
            }
            VideoLiveConfig.ResolutionInfo resolutionInfo = videoLiveConfigByPlayType.resolutions.get(i4);
            if (resolutionInfo.key == i2 || (i2 == -1 && resolutionInfo.isDefault == 1)) {
                break;
            }
            i3 = i4 + 1;
        }
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(TAG, "getCameraPreviewConfigByType playtype:" + i + " mode:" + i2 + PerfFrameTrackUIUtil.SEPERATOR_ARROR + cameraPreviewConfig.toString());
        }
        return cameraPreviewConfig;
    }

    private int convertPlayType(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 5;
            case 3:
                return 7;
            default:
                return i;
        }
    }

    public VideoEncoderConfig getVideoEncodeConfigByType(int i, int i2) {
        VideoLiveConfig.ResolutionInfo resolutionInfo;
        int i3 = 0;
        VideoEncoderConfig videoEncoderConfig = new VideoEncoderConfig();
        VideoLiveConfig videoLiveConfigByPlayType = getVideoLiveConfigByPlayType(i);
        if (videoLiveConfigByPlayType == null) {
            ThunderLog.warn(TAG, " getVideoEncodeConfigByType failed, return default!");
            return videoEncoderConfig;
        }
        if (i == 7 && this.mCurMultiLianMaiUsers != 0) {
            while (true) {
                int i4 = i3;
                if (i4 >= videoLiveConfigByPlayType.resolutions.size()) {
                    break;
                }
                VideoLiveConfig.ResolutionInfo resolutionInfo2 = videoLiveConfigByPlayType.resolutions.get(i4);
                if (this.mCurMultiLianMaiUsers < resolutionInfo2.minUsers || this.mCurMultiLianMaiUsers > resolutionInfo2.maxUsers) {
                    i3 = i4 + 1;
                } else {
                    videoEncoderConfig.mEncodeWidth = resolutionInfo2.width > 0 ? resolutionInfo2.width : videoEncoderConfig.mEncodeWidth;
                    videoEncoderConfig.mEncodeHeight = resolutionInfo2.height > 0 ? resolutionInfo2.height : videoEncoderConfig.mEncodeHeight;
                    videoEncoderConfig.mBitRate = resolutionInfo2.currate > 0 ? resolutionInfo2.currate * 1000 : videoEncoderConfig.mBitRate;
                    videoEncoderConfig.mEncodeType = convertEncodeIdToType(resolutionInfo2.encode_id);
                    videoEncoderConfig.mEncodeParameter = resolutionInfo2.encode_param;
                    videoEncoderConfig.mMaxBitRate = resolutionInfo2.maxrate * 1000;
                    videoEncoderConfig.mFrameRate = resolutionInfo2.frameRate > 0 ? resolutionInfo2.frameRate : videoEncoderConfig.mFrameRate;
                    this.mCurrentConfig = videoLiveConfigByPlayType;
                    this.mCurrentVideoLevel = resolutionInfo2.key;
                }
            }
        } else {
            while (true) {
                int i5 = i3;
                if (i5 >= videoLiveConfigByPlayType.resolutions.size()) {
                    break;
                }
                resolutionInfo = videoLiveConfigByPlayType.resolutions.get(i5);
                if (resolutionInfo.key == i2 || (i2 == -1 && resolutionInfo.isDefault == 1)) {
                    break;
                }
                i3 = i5 + 1;
            }
            videoEncoderConfig.mEncodeWidth = resolutionInfo.width > 0 ? resolutionInfo.width : videoEncoderConfig.mEncodeWidth;
            videoEncoderConfig.mEncodeHeight = resolutionInfo.height > 0 ? resolutionInfo.height : videoEncoderConfig.mEncodeHeight;
            videoEncoderConfig.mBitRate = resolutionInfo.currate > 0 ? resolutionInfo.currate * 1000 : videoEncoderConfig.mBitRate;
            videoEncoderConfig.mEncodeType = convertEncodeIdToType(resolutionInfo.encode_id);
            videoEncoderConfig.mEncodeParameter = resolutionInfo.encode_param;
            videoEncoderConfig.mMaxBitRate = resolutionInfo.maxrate * 1000;
            videoEncoderConfig.mFrameRate = resolutionInfo.frameRate > 0 ? resolutionInfo.frameRate : videoEncoderConfig.mFrameRate;
            this.mCurrentConfig = videoLiveConfigByPlayType;
            this.mCurrentVideoLevel = resolutionInfo.key;
        }
        if (this.mDisableHardEncode) {
            if (videoEncoderConfig.mEncodeType == VideoEncoderType.HARD_ENCODER_H264) {
                videoEncoderConfig.mEncodeType = VideoEncoderType.SOFT_ENCODER_X264;
                videoEncoderConfig.mEncodeParameter = "";
            } else if (videoEncoderConfig.mEncodeType == VideoEncoderType.HARD_ENCODER_H265) {
                videoEncoderConfig.mEncodeType = VideoEncoderType.SOFT_ENCODER_X264;
                videoEncoderConfig.mEncodeParameter = "";
            }
        }
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(TAG, "getVideoEncodeConfigByType :" + i + " mode:" + i2 + PerfFrameTrackUIUtil.SEPERATOR_ARROR + videoEncoderConfig.toString());
        }
        return videoEncoderConfig;
    }

    public void notifyVideoConfig(HashMap<Integer, VideoLiveConfig> hashMap) {
        if (!hashMap.isEmpty()) {
            synchronized (this) {
                this.mVideoConfigsList.clear();
                this.mVideoConfigsList.putAll(hashMap);
            }
        }
    }

    public void notifyBlackCodecConfig(String str) {
        if (!str.isEmpty()) {
            String[] split = str.split(",");
            for (int i = 0; i < split.length; i++) {
                if (split[i].equalsIgnoreCase(YYVideoCodec.getH264EncodeName())) {
                    this.mDisableHardEncode = true;
                } else if (split[i].equalsIgnoreCase(YYVideoCodec.getH265EncodeName())) {
                    this.mDisableHardEncode = true;
                }
            }
        }
    }

    public List<ResolutionModifyConfig> getCurrentModifyConfig() {
        ArrayList arrayList;
        ArrayList arrayList2 = null;
        if (this.mCurrentConfig != null) {
            int i = 0;
            while (i < this.mCurrentConfig.resolutions.size()) {
                VideoLiveConfig.ResolutionInfo resolutionInfo = this.mCurrentConfig.resolutions.get(i);
                if (resolutionInfo.key == this.mCurrentVideoLevel) {
                    ArrayList arrayList3 = new ArrayList(resolutionInfo.modifyConfig.size());
                    for (int i2 = 0; i2 < resolutionInfo.modifyConfig.size(); i2++) {
                        VideoLiveConfig.ModifyInfo modifyInfo = resolutionInfo.modifyConfig.get(i2);
                        arrayList3.add(new ResolutionModifyConfig(modifyInfo.width, modifyInfo.height, modifyInfo.minCodeRate * 1000, modifyInfo.maxCodeRate * 1000, modifyInfo.minFrameRate, modifyInfo.maxFrameRate, convertEncodeIdToType(modifyInfo.encode_id), modifyInfo.encode_param));
                    }
                    arrayList = arrayList3;
                } else {
                    arrayList = arrayList2;
                }
                i++;
                arrayList2 = arrayList;
            }
        }
        return arrayList2;
    }

    public VideoLiveConfig getCurrentVideoLiveConfig() {
        return this.mCurrentConfig;
    }

    public int getCurrentVideoLevel() {
        return this.mCurrentVideoLevel;
    }

    public int getCurrentIntervalSecs() {
        if (this.mCurrentConfig == null) {
            return 10;
        }
        return this.mCurrentConfig.intervalSecs;
    }

    public boolean checkLowDelayByType(int i) {
        return i == 1 || i == 3 || i == 7;
    }

    public boolean checkMultiLianMaiModeByType(int i) {
        return i == 7;
    }

    public void resetCurrentVideoLiveConfig() {
        this.mCurrentConfig = null;
    }

    public int getCurrentBeautifyLevel() {
        return ThunderNative.getBeautifyLevel();
    }

    public boolean getAbroadNetWorkStrategy() {
        return ThunderNative.getAbroadNetWorkStrategy() != 0;
    }

    public boolean getPreviewShareCtxSupport() {
        return this.mPreviewShareCtx;
    }

    public boolean getUseClear() {
        return this.mUseClear;
    }

    public static int getAppCpuSupportMode() {
        return ThunderNative.getAppCpuSupportMode();
    }

    public void disableHardDecode(Boolean bool) {
        this.mDisableHardDecode = bool.booleanValue();
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(TAG, "disableHardDecode " + this.mDisableHardEncode);
        }
    }

    public void disableHardEncode(Boolean bool) {
        this.mDisableHardEncode = bool.booleanValue();
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(TAG, "disableHardEncode " + this.mDisableHardEncode);
        }
    }

    public int getDefaultPublishVideoMode(int i) {
        int i2;
        VideoLiveConfig videoLiveConfigByPlayType = getVideoLiveConfigByPlayType(i);
        if (videoLiveConfigByPlayType == null) {
            ThunderLog.warn(TAG, " getDefaultPublishVideoMode configs == null ");
            return -1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= videoLiveConfigByPlayType.resolutions.size()) {
                i2 = -1;
                break;
            }
            VideoLiveConfig.ResolutionInfo resolutionInfo = videoLiveConfigByPlayType.resolutions.get(i4);
            if (resolutionInfo.isDefault != 1) {
                i3 = i4 + 1;
            } else {
                i2 = resolutionInfo.key;
                break;
            }
        }
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(TAG, " getDefaultPublishVideoMode mode " + i2);
        }
        return i2;
    }

    public int getPlayViewTypeFromStream(int i) {
        int i2 = 1;
        int i3 = 0;
        if (this.mDisableHardDecode) {
            if (ThunderLog.isInfoValid()) {
                ThunderLog.info(TAG, " getPlayViewTypeFromStream soft decoder ");
            }
        } else {
            if (i == 2) {
                int h265SupportMode = ThunderNative.getH265SupportMode();
                if (h265SupportMode != 2) {
                    if (ThunderLog.isInfoValid()) {
                        ThunderLog.info(TAG, " getPlayViewTypeFromStream  h265 mode " + h265SupportMode);
                    }
                    i2 = 0;
                }
                i3 = i2;
            } else if (i == 1) {
                int h264SupportMode = ThunderNative.getH264SupportMode();
                if (h264SupportMode == 1) {
                    i3 = 1;
                } else if (ThunderLog.isInfoValid()) {
                    ThunderLog.info(TAG, " getPlayViewTypeFromStream  h264 mode " + h264SupportMode);
                }
            }
            if (ThunderLog.isInfoValid()) {
                ThunderLog.info(TAG, " getPlayViewTypeFromStream decodeType :" + i3 + " streamType " + i);
            }
        }
        return i3;
    }

    public ThunderPublishVideoConfig getCurrentVideoConfig() {
        ThunderPublishVideoConfig thunderPublishVideoConfig = new ThunderPublishVideoConfig();
        if (this.mCurrentConfig == null) {
            return thunderPublishVideoConfig;
        }
        thunderPublishVideoConfig.playType = this.mCurrentConfig.playType;
        thunderPublishVideoConfig.mode = this.mCurrentVideoLevel;
        int i = 0;
        while (true) {
            if (i >= this.mCurrentConfig.resolutions.size()) {
                break;
            }
            VideoLiveConfig.ResolutionInfo resolutionInfo = this.mCurrentConfig.resolutions.get(i);
            if (resolutionInfo.key != this.mCurrentVideoLevel) {
                i++;
            } else {
                if (resolutionInfo.encode_id == 200 && !this.mDisableHardEncode) {
                    thunderPublishVideoConfig.hardwareEncoder = true;
                    thunderPublishVideoConfig.encodeType = 1;
                } else if (resolutionInfo.encode_id == 220 && !this.mDisableHardEncode) {
                    thunderPublishVideoConfig.hardwareEncoder = true;
                    thunderPublishVideoConfig.encodeType = 2;
                } else {
                    thunderPublishVideoConfig.hardwareEncoder = false;
                    thunderPublishVideoConfig.encodeType = 1;
                }
                thunderPublishVideoConfig.encodeBitrate = resolutionInfo.currate;
                thunderPublishVideoConfig.encodeFrameRate = resolutionInfo.frameRate;
                thunderPublishVideoConfig.encodeResolutionHeight = resolutionInfo.height;
                thunderPublishVideoConfig.encodeResolutionWidth = resolutionInfo.width;
            }
        }
        return thunderPublishVideoConfig;
    }

    public ThunderPublishInfo getCurrentPublishInfo() {
        ThunderPublishInfo thunderPublishInfo = new ThunderPublishInfo();
        if (this.mCurrentConfig == null) {
            return thunderPublishInfo;
        }
        thunderPublishInfo.playType = this.mCurrentConfig.playType;
        thunderPublishInfo.publishMode = this.mCurrentVideoLevel;
        int i = 0;
        while (true) {
            if (i >= this.mCurrentConfig.resolutions.size()) {
                break;
            }
            VideoLiveConfig.ResolutionInfo resolutionInfo = this.mCurrentConfig.resolutions.get(i);
            if (resolutionInfo.key != this.mCurrentVideoLevel) {
                i++;
            } else {
                if (resolutionInfo.encode_id == 200 && !this.mDisableHardEncode) {
                    thunderPublishInfo.hardwareEncoder = true;
                    thunderPublishInfo.encodeType = 1;
                } else if (resolutionInfo.encode_id == 220 && !this.mDisableHardEncode) {
                    thunderPublishInfo.hardwareEncoder = true;
                    thunderPublishInfo.encodeType = 2;
                } else {
                    thunderPublishInfo.hardwareEncoder = false;
                    thunderPublishInfo.encodeType = 1;
                }
                thunderPublishInfo.bitrate = resolutionInfo.currate;
                thunderPublishInfo.frameRate = resolutionInfo.frameRate;
                thunderPublishInfo.encodeHeight = resolutionInfo.height;
                thunderPublishInfo.encodeWidth = resolutionInfo.width;
            }
        }
        return thunderPublishInfo;
    }

    public ThunderPublishVideoConfig getRemoteVideoConfig(int i, int i2) {
        ThunderPublishVideoConfig thunderPublishVideoConfig = new ThunderPublishVideoConfig();
        thunderPublishVideoConfig.playType = i;
        thunderPublishVideoConfig.mode = i2;
        thunderPublishVideoConfig.encodeBitrate = FeatureCodes.FACE;
        thunderPublishVideoConfig.encodeFrameRate = 24;
        thunderPublishVideoConfig.encodeResolutionWidth = VideoEncoderConfig.DEFAULT_ENCODE_HIGH_WIDTH;
        thunderPublishVideoConfig.encodeResolutionHeight = 960;
        VideoLiveConfig videoLiveConfigByPlayType = getVideoLiveConfigByPlayType(i);
        if (videoLiveConfigByPlayType == null) {
            return thunderPublishVideoConfig;
        }
        if (i == 7 && this.mCurMultiLianMaiUsers != 0) {
            int i3 = 0;
            while (true) {
                if (i3 >= videoLiveConfigByPlayType.resolutions.size()) {
                    break;
                }
                VideoLiveConfig.ResolutionInfo resolutionInfo = videoLiveConfigByPlayType.resolutions.get(i3);
                if (resolutionInfo.minUsers > this.mCurMultiLianMaiUsers || resolutionInfo.maxUsers < this.mCurMultiLianMaiUsers) {
                    i3++;
                } else {
                    if (resolutionInfo.encode_id == 200 && !this.mDisableHardEncode) {
                        thunderPublishVideoConfig.hardwareEncoder = true;
                        thunderPublishVideoConfig.encodeType = 1;
                    } else if (resolutionInfo.encode_id == 220 && !this.mDisableHardEncode) {
                        thunderPublishVideoConfig.hardwareEncoder = true;
                        thunderPublishVideoConfig.encodeType = 2;
                    } else {
                        thunderPublishVideoConfig.hardwareEncoder = false;
                        thunderPublishVideoConfig.encodeType = 1;
                    }
                    thunderPublishVideoConfig.encodeBitrate = resolutionInfo.currate;
                    thunderPublishVideoConfig.encodeMaxBitrate = resolutionInfo.maxrate;
                    thunderPublishVideoConfig.encodeFrameRate = resolutionInfo.frameRate;
                    thunderPublishVideoConfig.encodeResolutionHeight = resolutionInfo.height;
                    thunderPublishVideoConfig.encodeResolutionWidth = resolutionInfo.width;
                }
            }
        } else {
            for (int i4 = 0; i4 < videoLiveConfigByPlayType.resolutions.size(); i4++) {
                VideoLiveConfig.ResolutionInfo resolutionInfo2 = videoLiveConfigByPlayType.resolutions.get(i4);
                if (resolutionInfo2.key == i2 || (i2 == -1 && resolutionInfo2.isDefault == 1)) {
                    if (resolutionInfo2.encode_id == 200 && !this.mDisableHardEncode) {
                        thunderPublishVideoConfig.hardwareEncoder = true;
                        thunderPublishVideoConfig.encodeType = 1;
                    } else if (resolutionInfo2.encode_id == 220 && !this.mDisableHardEncode) {
                        thunderPublishVideoConfig.hardwareEncoder = true;
                        thunderPublishVideoConfig.encodeType = 2;
                    } else {
                        thunderPublishVideoConfig.hardwareEncoder = false;
                        thunderPublishVideoConfig.encodeType = 1;
                    }
                    thunderPublishVideoConfig.encodeBitrate = resolutionInfo2.currate;
                    thunderPublishVideoConfig.encodeMaxBitrate = resolutionInfo2.maxrate;
                    thunderPublishVideoConfig.encodeFrameRate = resolutionInfo2.frameRate;
                    thunderPublishVideoConfig.encodeResolutionHeight = resolutionInfo2.height;
                    thunderPublishVideoConfig.encodeResolutionWidth = resolutionInfo2.width;
                }
            }
        }
        return thunderPublishVideoConfig;
    }

    public HashMap<Integer, String> getModeListByPlayType(int i) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        VideoLiveConfig videoLiveConfigByPlayType = getVideoLiveConfigByPlayType(i);
        if (videoLiveConfigByPlayType == null) {
            ThunderLog.error(TAG, "getModeListByPlayType  config null");
            hashMap.put(Integer.valueOf(i), String.valueOf(2));
            return hashMap;
        }
        String str = "";
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= videoLiveConfigByPlayType.resolutions.size()) {
                break;
            }
            VideoLiveConfig.ResolutionInfo resolutionInfo = videoLiveConfigByPlayType.resolutions.get(i3);
            hashMap.put(Integer.valueOf(resolutionInfo.key), resolutionInfo.description);
            str = str + resolutionInfo.key + ":" + resolutionInfo.description;
            i2 = i3 + 1;
        }
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(TAG, "getModeListByPlayType " + i + " :" + str);
        }
        return hashMap;
    }

    private VideoEncoderType convertEncodeIdToType(int i) {
        if (i == 200) {
            return VideoEncoderType.HARD_ENCODER_H264;
        }
        if (i == 201) {
            return VideoEncoderType.SOFT_ENCODER_X264;
        }
        if (i == 220) {
            return VideoEncoderType.HARD_ENCODER_H265;
        }
        if (i == 221) {
            return VideoEncoderType.SOFT_ENCODER_H265;
        }
        return VideoEncoderType.SOFT_ENCODER_X264;
    }
}
