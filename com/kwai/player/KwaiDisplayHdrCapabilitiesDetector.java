package com.kwai.player;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import androidx.annotation.RequiresApi;
/* loaded from: classes4.dex */
public class KwaiDisplayHdrCapabilitiesDetector {
    private static KwaiDisplayHdrCapabilitiesDetector sHdrCapabilitiesUtil = null;
    private Context mContext;
    private float mDesiredMaxAverageLuminance;
    private float mDesiredMaxLuminance;
    private float mDesiredMinLuminance;
    private DisplayManager mDisplayManager;
    private Display.HdrCapabilities mHdrCapabilities;
    private String mHdrTypes = "";
    private boolean misInited = false;

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
        if (!this.misInited) {
            this.mContext = context;
            this.mDisplayManager = (DisplayManager) this.mContext.getSystemService("display");
            this.mHdrCapabilities = this.mDisplayManager.getDisplay(0).getHdrCapabilities();
            for (int i : this.mHdrCapabilities.getSupportedHdrTypes()) {
                switch (i) {
                    case 1:
                        this.mHdrTypes += "HDR_TYPE_DOLBY_VISION,";
                        break;
                    case 2:
                        this.mHdrTypes += "HDR_TYPE_HDR10,";
                        break;
                    case 3:
                        this.mHdrTypes += "HDR_TYPE_HLG";
                        break;
                }
            }
            this.mDesiredMaxAverageLuminance = this.mHdrCapabilities.getDesiredMaxAverageLuminance();
            this.mDesiredMaxLuminance = this.mHdrCapabilities.getDesiredMaxLuminance();
            this.mDesiredMinLuminance = this.mHdrCapabilities.getDesiredMinLuminance();
            this.misInited = true;
        }
    }
}
