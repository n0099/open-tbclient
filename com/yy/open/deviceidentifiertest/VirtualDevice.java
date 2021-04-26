package com.yy.open.deviceidentifiertest;

import android.content.Context;
/* loaded from: classes7.dex */
public class VirtualDevice {
    public VirtualDevice() {
        try {
            System.loadLibrary("yyopensdk");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }

    public native String getDeviceID(Context context);
}
