package com.win.opensdk;
/* loaded from: classes3.dex */
public final class bk {
    public static boolean java() {
        try {
            Class.forName("com.bun.miitmdid.core.MdidSdkHelper");
            Class.forName("com.bun.miitmdid.core.MainMdidSdk");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
