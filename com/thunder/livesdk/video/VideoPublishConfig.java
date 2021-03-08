package com.thunder.livesdk.video;

import com.thunder.livesdk.video.ThunderVideoPublishEngineImp;
import java.util.List;
/* loaded from: classes6.dex */
public class VideoPublishConfig {
    public int codecid;
    public int encodeCodeRate;
    public int encodeFrameRate;
    public String encoderParam;
    public List<ThunderVideoPublishEngineImp.VideoPublishLowStreamConfig> lowStreamCfgs;
    public int maxCodeRate;
    public int minCodeRate;
    public int resolutionHeight;
    public int resolutionWidth;
    public int transcoding;
}
