package com.googlecode.mp4parser.h264.model;

import com.googlecode.mp4parser.h264.read.CAVLCReader;
import com.googlecode.mp4parser.h264.write.CAVLCWriter;
import java.io.IOException;
/* loaded from: classes9.dex */
public class ScalingList {
    public int[] scalingList;
    public boolean useDefaultScalingMatrixFlag;

    public String toString() {
        return "ScalingList{scalingList=" + this.scalingList + ", useDefaultScalingMatrixFlag=" + this.useDefaultScalingMatrixFlag + '}';
    }

    public static ScalingList read(CAVLCReader cAVLCReader, int i) throws IOException {
        boolean z;
        ScalingList scalingList = new ScalingList();
        scalingList.scalingList = new int[i];
        int i2 = 8;
        int i3 = 8;
        for (int i4 = 0; i4 < i; i4++) {
            if (i2 != 0) {
                i2 = ((cAVLCReader.readSE("deltaScale") + i3) + 256) % 256;
                if (i4 == 0 && i2 == 0) {
                    z = true;
                } else {
                    z = false;
                }
                scalingList.useDefaultScalingMatrixFlag = z;
            }
            int[] iArr = scalingList.scalingList;
            if (i2 != 0) {
                i3 = i2;
            }
            iArr[i4] = i3;
            i3 = scalingList.scalingList[i4];
        }
        return scalingList;
    }

    public void write(CAVLCWriter cAVLCWriter) throws IOException {
        int i = 0;
        if (this.useDefaultScalingMatrixFlag) {
            cAVLCWriter.writeSE(0, "SPS: ");
            return;
        }
        int i2 = 8;
        while (true) {
            int[] iArr = this.scalingList;
            if (i >= iArr.length) {
                return;
            }
            cAVLCWriter.writeSE((iArr[i] - i2) - 256, "SPS: ");
            i2 = this.scalingList[i];
            i++;
        }
    }
}
