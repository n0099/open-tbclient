package com.googlecode.mp4parser.h264.model;

import android.support.v4.view.InputDeviceCompat;
import com.googlecode.mp4parser.h264.read.CAVLCReader;
import com.googlecode.mp4parser.h264.write.CAVLCWriter;
import java.io.IOException;
/* loaded from: classes4.dex */
public class ScalingList {
    public int[] scalingList;
    public boolean useDefaultScalingMatrixFlag;

    public void write(CAVLCWriter cAVLCWriter) throws IOException {
        if (this.useDefaultScalingMatrixFlag) {
            cAVLCWriter.writeSE(0, "SPS: ");
            return;
        }
        int i = 8;
        for (int i2 = 0; i2 < this.scalingList.length; i2++) {
            cAVLCWriter.writeSE((this.scalingList[i2] - i) + InputDeviceCompat.SOURCE_ANY, "SPS: ");
            i = this.scalingList[i2];
        }
    }

    public static ScalingList read(CAVLCReader cAVLCReader, int i) throws IOException {
        int i2 = 8;
        ScalingList scalingList = new ScalingList();
        scalingList.scalingList = new int[i];
        int i3 = 0;
        int i4 = 8;
        while (i3 < i) {
            if (i2 != 0) {
                int readSE = ((cAVLCReader.readSE("deltaScale") + i4) + 256) % 256;
                scalingList.useDefaultScalingMatrixFlag = i3 == 0 && readSE == 0;
                i2 = readSE;
            }
            scalingList.scalingList[i3] = i2 == 0 ? i4 : i2;
            i4 = scalingList.scalingList[i3];
            i3++;
        }
        return scalingList;
    }

    public String toString() {
        return "ScalingList{scalingList=" + this.scalingList + ", useDefaultScalingMatrixFlag=" + this.useDefaultScalingMatrixFlag + '}';
    }
}
