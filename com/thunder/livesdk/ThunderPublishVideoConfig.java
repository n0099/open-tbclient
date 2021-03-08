package com.thunder.livesdk;

import com.thunder.livesdk.video.ThunderPublishLowStreamVideoConfig;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class ThunderPublishVideoConfig {
    public static final int YYPUBLISH_PLAYTYPE_ACROSS = 3;
    public static final int YYPUBLISH_PLAYTYPE_ARENA_CROSS = 4;
    public static final int YYPUBLISH_PLAYTYPE_LIANMAI = 1;
    public static final int YYPUBLISH_PLAYTYPE_MULIT_LIVE = 6;
    public static final int YYPUBLISH_PLAYTYPE_MULIT_LIVE_LIANMAI = 7;
    public static final int YYPUBLISH_PLAYTYPE_ONE_TO_ONE = 8;
    public static final int YYPUBLISH_PLAYTYPE_SCREEN_CAPTURE = 5;
    public static final int YYPUBLISH_PLAYTYPE_SINGLE = 0;
    public int encodeMaxBitrate;
    public LinkedList<ThunderPublishLowStreamVideoConfig> lowStreamCfgs = new LinkedList<>();
    public int encodeFrameRate = 0;
    public int encodeBitrate = 0;
    public int encodeResolutionHeight = 0;
    public int encodeResolutionWidth = 0;
    public int encodeType = 1;
    public boolean hardwareEncoder = true;
    public boolean mirrorFrontCamera = false;
    public boolean pubToGroupAndName = false;
    public int mode = -1;
    public int playType = 0;
    public int screenOrientation = 0;

    public String toString() {
        return "{encW=" + this.encodeResolutionWidth + " encH=" + this.encodeResolutionHeight + " fps=" + this.encodeFrameRate + " bitrate=" + this.encodeBitrate + " encType=" + this.encodeType + " hard=" + this.hardwareEncoder + " mirror=" + this.mirrorFrontCamera + " pubToGroupAndName=" + this.pubToGroupAndName + " mdoe=" + this.mode + " playType=" + this.playType + "}";
    }
}
