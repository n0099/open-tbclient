package com.yy.videoplayer.render;

import com.yy.videoplayer.utils.YMFLog;
/* loaded from: classes4.dex */
public class YMFProgramFactory {
    private static final String TAG = "YMFProgramFactory";

    public static IProgram createProgram(int i) {
        switch (i) {
            case 0:
                return new YMFProgram2D();
            case 1:
                return new YMFProgramNV21();
            case 2:
                return new YMFProgramNV12();
            case 3:
                return new YMFProgramI420();
            default:
                YMFLog.error((Object) null, "[Util    ]", "Unknown program type.");
                return null;
        }
    }
}
