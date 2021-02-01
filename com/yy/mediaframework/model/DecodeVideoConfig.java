package com.yy.mediaframework.model;

import android.view.Surface;
import com.yy.mediaframework.utils.YMFLog;
import java.util.Arrays;
import java.util.Locale;
/* loaded from: classes4.dex */
public class DecodeVideoConfig {
    private static final String TAG = "DecodeVideoConfig";
    public static final byte[] header = {0, 0, 0, 1};
    public int height;
    public Surface mRenderSurface;
    public byte[] pps;
    public byte[] sps;
    public byte[] spspps;
    public int width;
    public long streamId = 1;
    public String mCodecName = "";
    public String mCodecType = "";

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public boolean equals(DecodeVideoConfig decodeVideoConfig) {
        return decodeVideoConfig.streamId == this.streamId && Arrays.equals(this.spspps, decodeVideoConfig.spspps);
    }

    public void parseSpsPps() {
        if (this.spspps == null || this.spspps.length <= 0) {
            YMFLog.info(this, "[Decoder ]", "got invalid spspps data.");
            return;
        }
        byte[] bArr = new byte[2];
        System.arraycopy(this.spspps, 6, bArr, 0, 2);
        int spsLenght = getSpsLenght(bArr);
        this.sps = new byte[spsLenght + 4];
        System.arraycopy(header, 0, this.sps, 0, 4);
        System.arraycopy(this.spspps, 8, this.sps, 4, spsLenght);
        byte[] bArr2 = new byte[2];
        System.arraycopy(this.spspps, spsLenght + 8 + 1, bArr2, 0, 2);
        int spsLenght2 = getSpsLenght(bArr2);
        this.pps = new byte[spsLenght2 + 4];
        System.arraycopy(header, 0, this.pps, 0, 4);
        System.arraycopy(this.spspps, spsLenght + 8 + 3, this.pps, 4, spsLenght2);
    }

    public void parseOutdoorSpsPps() {
        if (this.sps != null && this.pps != null) {
            byte[] bArr = new byte[this.sps.length + 4];
            System.arraycopy(header, 0, bArr, 0, 4);
            System.arraycopy(this.sps, 0, bArr, 4, this.sps.length);
            this.sps = bArr;
            byte[] bArr2 = new byte[this.pps.length + 4];
            System.arraycopy(header, 0, bArr2, 0, 4);
            System.arraycopy(this.pps, 0, bArr2, 4, this.pps.length);
            this.pps = bArr2;
        }
    }

    public void assign(DecodeVideoConfig decodeVideoConfig) {
        this.width = decodeVideoConfig.width;
        this.height = decodeVideoConfig.height;
        this.streamId = decodeVideoConfig.streamId;
        this.sps = decodeVideoConfig.sps;
        this.pps = decodeVideoConfig.pps;
        this.spspps = decodeVideoConfig.spspps;
        this.mCodecName = decodeVideoConfig.mCodecName;
        this.mCodecType = decodeVideoConfig.mCodecType;
        this.mRenderSurface = decodeVideoConfig.mRenderSurface;
    }

    private static String byte2hex(byte[] bArr) {
        String str = "";
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            str = str + " " + hexString;
        }
        return str;
    }

    public int getSpsLenght(byte[] bArr) {
        return (bArr[1] & 255) | ((bArr[0] & 255) << 8);
    }

    public int byteArrayToInt(byte[] bArr) {
        return (bArr[1] & 255) | ((bArr[0] & 255) << 8);
    }

    public String toString() {
        return String.format(Locale.getDefault(), "DecodeVideoConfig: width = %d, height = %d\nsps= %s, \npps = %s", Integer.valueOf(this.width), Integer.valueOf(this.height), byte2hex(this.sps), byte2hex(this.pps));
    }
}
