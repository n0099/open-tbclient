package top.kikt.ijkplayer.entity;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class Info {
    private final double currentPosition;
    private final int degree;
    private final double duration;
    private final int height;
    private final boolean isPlaying;
    private final float outputFps;
    private final int playCount;
    private final long tcpSpeed;
    private final int width;

    public Info(double d, int i, double d2, int i2, int i3, boolean z, int i4, long j, float f) {
        this.duration = d;
        this.playCount = i;
        this.currentPosition = d2;
        this.width = i2;
        this.height = i3;
        this.isPlaying = z;
        this.degree = i4;
        this.tcpSpeed = j;
        this.outputFps = f;
    }

    public final Map toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("duration", Double.valueOf(this.duration));
        hashMap.put("playCount", Integer.valueOf(this.playCount));
        hashMap.put("currentPosition", Double.valueOf(this.currentPosition));
        hashMap.put("width", Integer.valueOf(this.width));
        hashMap.put("height", Integer.valueOf(this.height));
        hashMap.put("isPlaying", Boolean.valueOf(this.isPlaying));
        hashMap.put("degree", Integer.valueOf(this.degree));
        hashMap.put("tcpSpeed", Long.valueOf(this.tcpSpeed));
        hashMap.put("outputFps", Float.valueOf(this.outputFps));
        return hashMap;
    }
}
