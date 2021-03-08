package com.yy.videoplayer.decoder;

import android.app.ActivityManager;
import android.content.Context;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.yy.videoplayer.utils.YMFLog;
/* loaded from: classes6.dex */
public class GLVersionUtils {
    static int glVersion = 0;

    public static void holdGLVersion(Context context) {
        glVersion = ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getDeviceConfigurationInfo().reqGlEsVersion;
        YMFLog.info(null, "[Util    ]", "GLVersionUtils holdGLVersion:" + glVersion);
    }

    public static int getGlVersion() {
        return glVersion;
    }

    public static boolean isGLES20Supported() {
        return glVersion >= 131072;
    }
}
