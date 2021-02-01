package com.yy.mediaframework.utils;

import com.yy.mediaframework.model.YYMediaSample;
/* loaded from: classes4.dex */
public class DumpUtil {
    public static String toString(float[] fArr) {
        StringBuilder sb = new StringBuilder();
        if (fArr != null && fArr.length > 0) {
            sb.append("\n");
            int sqrt = (int) Math.sqrt(fArr.length);
            for (int i = 0; i < fArr.length; i++) {
                sb.append(fArr[i]).append(", ");
                if ((i + 1) % sqrt == 0) {
                    sb.append("\n");
                } else {
                    sb.append(", ");
                }
            }
        }
        return sb.toString();
    }

    public static String toString(YYMediaSample yYMediaSample) {
        return new StringBuilder().toString();
    }
}
