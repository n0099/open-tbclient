package com.yy.open.deviceidentifiertest;

import android.content.Context;
/* loaded from: classes9.dex */
public class VirtualDevice {
    public native String getDeviceID(Context context);

    public VirtualDevice() {
        try {
            System.loadLibrary("yyopensdk");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
    }
}
