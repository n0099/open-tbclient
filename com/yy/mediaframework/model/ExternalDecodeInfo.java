package com.yy.mediaframework.model;
/* loaded from: classes6.dex */
public class ExternalDecodeInfo {
    public final long m_dts;
    public final int m_frameType;
    public final int m_heigth;
    public final long m_pts;
    public final long m_streamId;
    public final byte[] m_video;
    public final int m_width;
    public final byte[] pps;
    public final byte[] sps;

    public ExternalDecodeInfo(int i, int i2, int i3, long j, long j2, long j3, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.m_frameType = i;
        this.m_width = i2;
        this.m_heigth = i3;
        this.m_dts = j;
        this.m_pts = j2;
        this.m_streamId = j3;
        this.m_video = bArr3;
        this.pps = bArr2;
        this.sps = bArr;
    }

    public DecodeVideoConfig convertToConfig() {
        DecodeVideoConfig decodeVideoConfig = new DecodeVideoConfig();
        decodeVideoConfig.height = this.m_heigth;
        decodeVideoConfig.width = this.m_width;
        decodeVideoConfig.pps = this.pps;
        decodeVideoConfig.sps = this.sps;
        decodeVideoConfig.streamId = this.m_streamId;
        return decodeVideoConfig;
    }

    public DecodeVideoSample convertToStreamInfo() {
        DecodeVideoSample decodeVideoSample = new DecodeVideoSample();
        decodeVideoSample.data = this.m_video;
        decodeVideoSample.dts = this.m_dts;
        decodeVideoSample.pts = this.m_pts;
        decodeVideoSample.height = this.m_heigth;
        decodeVideoSample.width = this.m_width;
        decodeVideoSample.frameType = this.m_frameType;
        decodeVideoSample.streamId = this.m_streamId;
        if (this.m_video != null) {
            decodeVideoSample.dataLenght = this.m_video.length;
        }
        return decodeVideoSample;
    }
}
