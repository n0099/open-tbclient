package com.googlecode.mp4parser.util;

import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes6.dex */
public class CastUtils {
    public static int l2i(long j) {
        if (j > 2147483647L || j < -2147483648L) {
            throw new RuntimeException("A cast to int has gone wrong. Please contact the mp4parser discussion group (" + j + SmallTailInfo.EMOTION_SUFFIX);
        }
        return (int) j;
    }
}
