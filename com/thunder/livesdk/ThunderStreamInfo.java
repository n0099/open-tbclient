package com.thunder.livesdk;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class ThunderStreamInfo {
    public static final int STREAM_CONFIG_KEY_AUDIO_SAMPLERATE = 7;
    public static final int STREAM_CONFIG_KEY_CODE_RATE = 4;
    public static final int STREAM_CONFIG_KEY_ENCODE_TYPE = 5;
    public static final int STREAM_CONFIG_KEY_FRAME_RATE = 11;
    public static final int STREAM_CONFIG_KEY_PUBLISHER_MC_POS = 10;
    public static final int STREAM_CONFIG_KEY_PUBLISHID = 1;
    public static final int STREAM_CONFIG_KEY_PUBLISH_STREAM_PROVIDER = 8;
    public static final int STREAM_CONFIG_KEY_RESOLUTION_HEIGHT = 13;
    public static final int STREAM_CONFIG_KEY_RESOLUTION_WIDTH = 12;
    public static final int STREAM_CONFIG_KEY_SID_BROADCAST_AUDIO = 9;
    public static final int STREAM_CONFIG_KEY_SPEAKER_UID = 2;
    public static final int STREAM_CONFIG_KEY_STREAM_A_V_PAIR_ID = 16;
    public static final int STREAM_CONFIG_KEY_STREAM_LINE = 14;
    public static final int STREAM_CONFIG_KEY_STREAM_LINE_GROUP = 15;
    public static final int STREAM_CONFIG_KEY_STREAM_TYPE = 3;
    public static final int STREMA_CONFIG_KEY_AUDIO_CHANNELS = 6;
    public long appId;
    public long spkUid;
    public Map<Integer, Integer> streamConfig = new HashMap();
    public String streamName;
}
