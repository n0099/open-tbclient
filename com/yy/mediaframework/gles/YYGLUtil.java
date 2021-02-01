package com.yy.mediaframework.gles;

import android.opengl.GLES20;
import com.yy.mediaframework.utils.YMFLog;
/* loaded from: classes4.dex */
public class YYGLUtil {
    public static final String TAG = "YYMediaFw";

    public static void checkGlError(String str) {
        int glGetError;
        if (GLES20.glGetError() != 0) {
            String str2 = str + ": glError 0x" + Integer.toHexString(glGetError);
            YMFLog.error((Object) null, "[Util    ]", str2);
            throw new RuntimeException(str2);
        }
    }
}
