package com.qq.e.comm.pi;

import java.util.Map;
/* loaded from: classes8.dex */
public interface AdData {

    /* loaded from: classes8.dex */
    public interface VideoPlayer {
        int getCurrentPosition();

        int getDuration();

        int getVideoState();
    }

    boolean equalsAdData(AdData adData);

    int getAdPatternType();

    String getDesc();

    int getECPM();

    String getECPMLevel();

    Map getExtraInfo();

    Object getProperty(Class cls);

    String getProperty(String str);

    String getTitle();

    int getVideoDuration();

    void setECPMLevel(String str);
}
