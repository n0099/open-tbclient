package com.meizu.flyme.openidsdk;

import android.content.Context;
import androidx.annotation.Keep;
import java.lang.reflect.Method;
@Keep
/* loaded from: classes8.dex */
public class OpenIdHelper {
    @Keep
    public static final String TAG = "OpenIdHelper";
    @Keep
    public static Method sContextMethod;

    @Keep
    public static native String getAAID(Context context);

    @Keep
    public static native String getOAID(Context context);

    @Keep
    public static native String getUDID(Context context);

    @Keep
    public static native String getVAID(Context context);

    @Keep
    public static final native boolean isSupported();

    @Keep
    public static native void setLogEnable(boolean z);
}
