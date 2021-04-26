package com.googlecode.mp4parser.h264.model;

import com.googlecode.mp4parser.h264.read.CAVLCReader;
import com.googlecode.mp4parser.h264.write.CAVLCWriter;
import java.io.IOException;
/* loaded from: classes6.dex */
public class ScalingList {
    public int[] scalingList;
    public boolean useDefaultScalingMatrixFlag;

    public static ScalingList read(CAVLCReader cAVLCReader, int i2) throws IOException {
        ScalingList scalingList = new ScalingList();
        scalingList.scalingList = new int[i2];
        int i3 = 8;
        int i4 = 8;
        int i5 = 0;
        while (i5 < i2) {
            if (i3 != 0) {
                i3 = ((cAVLCReader.readSE("deltaScale") + i4) + 256) % 256;
                scalingList.useDefaultScalingMatrixFlag = i5 == 0 && i3 == 0;
            }
            int[] iArr = scalingList.scalingList;
            if (i3 != 0) {
                i4 = i3;
            }
            iArr[i5] = i4;
            i4 = scalingList.scalingList[i5];
            i5++;
        }
        return scalingList;
    }

    public String toString() {
        return "ScalingList{scalingList=" + this.scalingList + ", useDefaultScalingMatrixFlag=" + this.useDefaultScalingMatrixFlag + '}';
    }

    public void write(CAVLCWriter cAVLCWriter) throws IOException {
        int i2 = 0;
        if (this.useDefaultScalingMatrixFlag) {
            cAVLCWriter.writeSE(0, "SPS: ");
            return;
        }
        int i3 = 8;
        while (true) {
            int[] iArr = this.scalingList;
            if (i2 >= iArr.length) {
                return;
            }
            cAVLCWriter.writeSE((iArr[i2] - i3) - 256, "SPS: ");
            i3 = this.scalingList[i2];
            i2++;
        }
    }
}
