package com.yy.mediaframework.opengles;

import com.yy.mediaframework.utils.YMFLog;
/* loaded from: classes4.dex */
public class YMFProgramFactory {
    private static final String TAG = "YMFProgramFactory";

    public static IProgram craeteProgram(int i) {
        switch (i) {
            case 0:
                return new YMFProgram2D();
            case 1:
                return new YMFProgramNV21();
            case 2:
                return new YMFProgramNV12();
            case 3:
                return new YMFProgramI420();
            case 4:
                return new YMFProgramOES();
            default:
                YMFLog.error((Object) null, "[Util    ]", "Unknown program type.");
                return null;
        }
    }
}
