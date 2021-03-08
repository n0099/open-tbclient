package com.yy.mediaframework.base;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.mobstat.Config;
import com.xiaomi.mipush.sdk.Constants;
import com.yy.mediaframework.UploadStreamStateParams;
import com.yy.mediaframework.inteligence.common.ResolutionModifyConfig;
import com.yy.mediaframework.stat.YMFLiveStatisticManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class VideoPublisheParam {
    public int captureFrameRate;
    public int captureResolutionHeight;
    public int captureResolutionWidth;
    @Deprecated
    public int codecid;
    public int encodeBitrate;
    public int encodeFrameRate;
    @Deprecated
    public int encodeMaxBitrate;
    @Deprecated
    public int encodeMinBitrate;
    public int encodeResolutionHeight;
    public int encodeResolutionWidth;
    public VideoEncoderType encodeType;
    public String encoderParam;
    public int weakNetConfigsIntervalSecs;
    public List<YMFLowStreamEncoderConfig> lowStreamConfigs = new ArrayList();
    public List<ResolutionModifyConfig> weakNetConfigs = new ArrayList();
    public boolean bLowLatency = false;
    public boolean bWebSdkCompatibility = false;
    public boolean bEnableLocalDualStreamMode = false;
    public int screenOrientation = 0;

    public void assign(VideoPublisheParam videoPublisheParam) {
        this.captureFrameRate = videoPublisheParam.captureFrameRate;
        this.captureResolutionWidth = videoPublisheParam.captureResolutionWidth;
        this.captureResolutionHeight = videoPublisheParam.captureResolutionHeight;
        this.encodeFrameRate = videoPublisheParam.encodeFrameRate;
        this.encodeBitrate = videoPublisheParam.encodeBitrate;
        this.encodeResolutionWidth = videoPublisheParam.encodeResolutionWidth;
        this.encodeResolutionHeight = videoPublisheParam.encodeResolutionHeight;
        this.encodeType = !UploadStreamStateParams.mDisableHardEncoder.get() ? videoPublisheParam.encodeType : VideoEncoderType.SOFT_ENCODER_X264;
        this.encoderParam = !UploadStreamStateParams.mDisableHardEncoder.get() ? videoPublisheParam.encoderParam : "";
        this.encodeMaxBitrate = videoPublisheParam.encodeMaxBitrate;
        this.encodeMinBitrate = videoPublisheParam.encodeMinBitrate;
        this.codecid = videoPublisheParam.codecid;
        this.weakNetConfigsIntervalSecs = videoPublisheParam.weakNetConfigsIntervalSecs;
        this.weakNetConfigs.clear();
        if (videoPublisheParam.weakNetConfigs != null && videoPublisheParam.weakNetConfigs.size() > 0) {
            for (int i = 0; i < videoPublisheParam.weakNetConfigs.size(); i++) {
                this.weakNetConfigs.add(new ResolutionModifyConfig(videoPublisheParam.weakNetConfigs.get(i)));
                if (UploadStreamStateParams.mDisableHardEncoder.get()) {
                    this.weakNetConfigs.get(i).videoEncoderType = VideoEncoderType.SOFT_ENCODER_X264;
                    this.weakNetConfigs.get(i).encoderParams = "";
                }
            }
        } else {
            this.weakNetConfigs = new ArrayList();
        }
        if (videoPublisheParam.lowStreamConfigs != null && videoPublisheParam.lowStreamConfigs.size() > 0) {
            this.lowStreamConfigs.clear();
            for (int i2 = 0; i2 < videoPublisheParam.lowStreamConfigs.size(); i2++) {
                this.lowStreamConfigs.add(new YMFLowStreamEncoderConfig(videoPublisheParam.lowStreamConfigs.get(i2)));
            }
            YMFLiveStatisticManager.getInstance().setDesiredParam(1, videoPublisheParam.lowStreamConfigs.get(0).mEncodeWidth, videoPublisheParam.lowStreamConfigs.get(0).mEncodeHeight, videoPublisheParam.lowStreamConfigs.get(0).mCodeRate / 1000, videoPublisheParam.lowStreamConfigs.get(0).mFrameRate);
        }
        this.bLowLatency = videoPublisheParam.bLowLatency;
        this.bWebSdkCompatibility = videoPublisheParam.bWebSdkCompatibility;
        this.bEnableLocalDualStreamMode = videoPublisheParam.bEnableLocalDualStreamMode;
        this.screenOrientation = videoPublisheParam.screenOrientation;
        YMFLiveStatisticManager.getInstance().setDesiredParam(0, videoPublisheParam.encodeResolutionWidth, videoPublisheParam.encodeResolutionHeight, videoPublisheParam.encodeBitrate / 1000, videoPublisheParam.encodeFrameRate);
    }

    public String toString() {
        String str;
        Iterator<YMFLowStreamEncoderConfig> it;
        String str2 = "previewCfg:" + this.captureResolutionWidth + Config.EVENT_HEAT_X + this.captureResolutionHeight + "@" + this.captureFrameRate + "fps,encodeCfg:" + this.encodeResolutionWidth + Config.EVENT_HEAT_X + this.encodeResolutionHeight + "@" + this.encodeFrameRate + "fps:" + this.encodeBitrate + "bps," + this.encodeType + ",param:" + this.encoderParam + ",lowDelatency:" + this.bLowLatency + ",web:" + this.bWebSdkCompatibility + ",orientation:" + this.screenOrientation + IStringUtil.TOP_PATH + this.bWebSdkCompatibility + ",orientation:" + this.screenOrientation + ",dualStreamMode:" + this.bEnableLocalDualStreamMode + " .. weaknetCfg:";
        if (this.weakNetConfigs == null || this.weakNetConfigs.size() == 0) {
            str = str2 + "null";
        } else {
            Iterator<ResolutionModifyConfig> it2 = this.weakNetConfigs.iterator();
            while (true) {
                str = str2;
                if (!it2.hasNext()) {
                    break;
                }
                ResolutionModifyConfig next = it2.next();
                str2 = str + "[" + next.width + Config.EVENT_HEAT_X + next.height + "@" + next.minFrameRate + Constants.ACCEPT_TIME_SEPARATOR_SERVER + next.maxFrameRate + "：" + next.minCodeRate + Constants.ACCEPT_TIME_SEPARATOR_SERVER + next.maxCodeRate + "]";
            }
        }
        String str3 = str + "lowStream:";
        if (this.lowStreamConfigs == null || this.lowStreamConfigs.size() == 0) {
            return str3 + "null";
        }
        while (true) {
            String str4 = str3;
            if (this.lowStreamConfigs.iterator().hasNext()) {
                str3 = str4 + "[" + it.next().toString() + "]";
            } else {
                return str4;
            }
        }
    }
}
