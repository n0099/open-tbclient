package com.kwai.player;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import androidx.annotation.RequiresApi;
/* loaded from: classes6.dex */
public class KwaiDisplayHdrCapabilitiesDetector {
    public static KwaiDisplayHdrCapabilitiesDetector sHdrCapabilitiesUtil;
    public Context mContext;
    public float mDesiredMaxAverageLuminance;
    public float mDesiredMaxLuminance;
    public float mDesiredMinLuminance;
    public DisplayManager mDisplayManager;
    public Display.HdrCapabilities mHdrCapabilities;
    public String mHdrTypes = "";
    public boolean misInited = false;

    public static synchronized KwaiDisplayHdrCapabilitiesDetector getInstance() {
        KwaiDisplayHdrCapabilitiesDetector kwaiDisplayHdrCapabilitiesDetector;
        synchronized (KwaiDisplayHdrCapabilitiesDetector.class) {
            if (sHdrCapabilitiesUtil == null) {
                sHdrCapabilitiesUtil = new KwaiDisplayHdrCapabilitiesDetector();
            }
            kwaiDisplayHdrCapabilitiesDetector = sHdrCapabilitiesUtil;
        }
        return kwaiDisplayHdrCapabilitiesDetector;
    }

    public String getHdrCapabilitiesTypes() {
        return this.mHdrTypes;
    }

    public float getHdrMaxAverageLuminance() {
        return this.mDesiredMaxAverageLuminance;
    }

    public float getHdrMaxLuminance() {
        return this.mDesiredMaxLuminance;
    }

    public float getHdrMinLuminance() {
        return this.mDesiredMinLuminance;
    }

    @RequiresApi(api = 24)
    public synchronized void init(Context context) {
        int[] supportedHdrTypes;
        String str;
        if (this.misInited) {
            return;
        }
        this.mContext = context;
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        this.mDisplayManager = displayManager;
        Display.HdrCapabilities hdrCapabilities = displayManager.getDisplay(0).getHdrCapabilities();
        this.mHdrCapabilities = hdrCapabilities;
        for (int i : hdrCapabilities.getSupportedHdrTypes()) {
            if (i == 1) {
                str = this.mHdrTypes + "HDR_TYPE_DOLBY_VISION,";
            } else if (i == 2) {
                str = this.mHdrTypes + "HDR_TYPE_HDR10,";
            } else if (i == 3) {
                str = this.mHdrTypes + "HDR_TYPE_HLG";
            }
            this.mHdrTypes = str;
        }
        this.mDesiredMaxAverageLuminance = this.mHdrCapabilities.getDesiredMaxAverageLuminance();
        this.mDesiredMaxLuminance = this.mHdrCapabilities.getDesiredMaxLuminance();
        this.mDesiredMinLuminance = this.mHdrCapabilities.getDesiredMinLuminance();
        this.misInited = true;
    }
}
