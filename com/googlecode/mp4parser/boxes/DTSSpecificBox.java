package com.googlecode.mp4parser.boxes;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitWriterBuffer;
import java.nio.ByteBuffer;
import org.apache.http.HttpStatus;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes2.dex */
public class DTSSpecificBox extends AbstractBox {
    public static final String TYPE = "ddts";
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_10 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_11 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_12 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_13 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_14 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_15 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_16 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_17 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_18 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_19 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_20 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_21 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_22 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_23 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_24 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_25 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_26 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_27 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_28 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_29 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_30 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_31 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_6 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_7 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_8 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_9 = null;
    long DTSSamplingFrequency;
    int LBRDurationMod;
    long avgBitRate;
    int channelLayout;
    int coreLFEPresent;
    int coreLayout;
    int coreSize;
    int frameDuration;
    long maxBitRate;
    int multiAssetFlag;
    int pcmSampleDepth;
    int representationType;
    int reserved;
    int reservedBoxPresent;
    int stereoDownmix;
    int streamConstruction;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("DTSSpecificBox.java", DTSSpecificBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.b("1", "getAvgBitRate", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "long"), 88);
        ajc$tjp_1 = bVar.a("method-execution", bVar.b("1", "setAvgBitRate", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "long", "avgBitRate", "", "void"), 92);
        ajc$tjp_10 = bVar.a("method-execution", bVar.b("1", "getStreamConstruction", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 128);
        ajc$tjp_11 = bVar.a("method-execution", bVar.b("1", "setStreamConstruction", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "streamConstruction", "", "void"), 132);
        ajc$tjp_12 = bVar.a("method-execution", bVar.b("1", "getCoreLFEPresent", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 136);
        ajc$tjp_13 = bVar.a("method-execution", bVar.b("1", "setCoreLFEPresent", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "coreLFEPresent", "", "void"), 140);
        ajc$tjp_14 = bVar.a("method-execution", bVar.b("1", "getCoreLayout", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 144);
        ajc$tjp_15 = bVar.a("method-execution", bVar.b("1", "setCoreLayout", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "coreLayout", "", "void"), 148);
        ajc$tjp_16 = bVar.a("method-execution", bVar.b("1", "getCoreSize", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 152);
        ajc$tjp_17 = bVar.a("method-execution", bVar.b("1", "setCoreSize", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "coreSize", "", "void"), 156);
        ajc$tjp_18 = bVar.a("method-execution", bVar.b("1", "getStereoDownmix", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 160);
        ajc$tjp_19 = bVar.a("method-execution", bVar.b("1", "setStereoDownmix", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "stereoDownmix", "", "void"), 164);
        ajc$tjp_2 = bVar.a("method-execution", bVar.b("1", "getDTSSamplingFrequency", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "long"), 96);
        ajc$tjp_20 = bVar.a("method-execution", bVar.b("1", "getRepresentationType", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 168);
        ajc$tjp_21 = bVar.a("method-execution", bVar.b("1", "setRepresentationType", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "representationType", "", "void"), 172);
        ajc$tjp_22 = bVar.a("method-execution", bVar.b("1", "getChannelLayout", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 176);
        ajc$tjp_23 = bVar.a("method-execution", bVar.b("1", "setChannelLayout", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "channelLayout", "", "void"), SubsamplingScaleImageView.ORIENTATION_180);
        ajc$tjp_24 = bVar.a("method-execution", bVar.b("1", "getMultiAssetFlag", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 184);
        ajc$tjp_25 = bVar.a("method-execution", bVar.b("1", "setMultiAssetFlag", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "multiAssetFlag", "", "void"), 188);
        ajc$tjp_26 = bVar.a("method-execution", bVar.b("1", "getLBRDurationMod", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 192);
        ajc$tjp_27 = bVar.a("method-execution", bVar.b("1", "setLBRDurationMod", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "LBRDurationMod", "", "void"), 196);
        ajc$tjp_28 = bVar.a("method-execution", bVar.b("1", "getReserved", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 200);
        ajc$tjp_29 = bVar.a("method-execution", bVar.b("1", "setReserved", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "reserved", "", "void"), HttpStatus.SC_NO_CONTENT);
        ajc$tjp_3 = bVar.a("method-execution", bVar.b("1", "setDTSSamplingFrequency", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "long", "DTSSamplingFrequency", "", "void"), 100);
        ajc$tjp_30 = bVar.a("method-execution", bVar.b("1", "getReservedBoxPresent", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 208);
        ajc$tjp_31 = bVar.a("method-execution", bVar.b("1", "setReservedBoxPresent", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "reservedBoxPresent", "", "void"), 212);
        ajc$tjp_4 = bVar.a("method-execution", bVar.b("1", "getMaxBitRate", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "long"), 104);
        ajc$tjp_5 = bVar.a("method-execution", bVar.b("1", "setMaxBitRate", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "long", "maxBitRate", "", "void"), 108);
        ajc$tjp_6 = bVar.a("method-execution", bVar.b("1", "getPcmSampleDepth", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 112);
        ajc$tjp_7 = bVar.a("method-execution", bVar.b("1", "setPcmSampleDepth", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "pcmSampleDepth", "", "void"), 116);
        ajc$tjp_8 = bVar.a("method-execution", bVar.b("1", "getFrameDuration", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 120);
        ajc$tjp_9 = bVar.a("method-execution", bVar.b("1", "setFrameDuration", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "frameDuration", "", "void"), 124);
    }

    public DTSSpecificBox() {
        super(TYPE);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 20L;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        this.DTSSamplingFrequency = IsoTypeReader.readUInt32(byteBuffer);
        this.maxBitRate = IsoTypeReader.readUInt32(byteBuffer);
        this.avgBitRate = IsoTypeReader.readUInt32(byteBuffer);
        this.pcmSampleDepth = IsoTypeReader.readUInt8(byteBuffer);
        BitReaderBuffer bitReaderBuffer = new BitReaderBuffer(byteBuffer);
        this.frameDuration = bitReaderBuffer.readBits(2);
        this.streamConstruction = bitReaderBuffer.readBits(5);
        this.coreLFEPresent = bitReaderBuffer.readBits(1);
        this.coreLayout = bitReaderBuffer.readBits(6);
        this.coreSize = bitReaderBuffer.readBits(14);
        this.stereoDownmix = bitReaderBuffer.readBits(1);
        this.representationType = bitReaderBuffer.readBits(3);
        this.channelLayout = bitReaderBuffer.readBits(16);
        this.multiAssetFlag = bitReaderBuffer.readBits(1);
        this.LBRDurationMod = bitReaderBuffer.readBits(1);
        this.reservedBoxPresent = bitReaderBuffer.readBits(1);
        this.reserved = bitReaderBuffer.readBits(5);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        IsoTypeWriter.writeUInt32(byteBuffer, this.DTSSamplingFrequency);
        IsoTypeWriter.writeUInt32(byteBuffer, this.maxBitRate);
        IsoTypeWriter.writeUInt32(byteBuffer, this.avgBitRate);
        IsoTypeWriter.writeUInt8(byteBuffer, this.pcmSampleDepth);
        BitWriterBuffer bitWriterBuffer = new BitWriterBuffer(byteBuffer);
        bitWriterBuffer.writeBits(this.frameDuration, 2);
        bitWriterBuffer.writeBits(this.streamConstruction, 5);
        bitWriterBuffer.writeBits(this.coreLFEPresent, 1);
        bitWriterBuffer.writeBits(this.coreLayout, 6);
        bitWriterBuffer.writeBits(this.coreSize, 14);
        bitWriterBuffer.writeBits(this.stereoDownmix, 1);
        bitWriterBuffer.writeBits(this.representationType, 3);
        bitWriterBuffer.writeBits(this.channelLayout, 16);
        bitWriterBuffer.writeBits(this.multiAssetFlag, 1);
        bitWriterBuffer.writeBits(this.LBRDurationMod, 1);
        bitWriterBuffer.writeBits(this.reservedBoxPresent, 1);
        bitWriterBuffer.writeBits(this.reserved, 5);
    }

    public long getAvgBitRate() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.avgBitRate;
    }

    public void setAvgBitRate(long j) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this, org.aspectj.a.a.a.dE(j)));
        this.avgBitRate = j;
    }

    public long getDTSSamplingFrequency() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this));
        return this.DTSSamplingFrequency;
    }

    public void setDTSSamplingFrequency(long j) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this, org.aspectj.a.a.a.dE(j)));
        this.DTSSamplingFrequency = j;
    }

    public long getMaxBitRate() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_4, this, this));
        return this.maxBitRate;
    }

    public void setMaxBitRate(long j) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_5, this, this, org.aspectj.a.a.a.dE(j)));
        this.maxBitRate = j;
    }

    public int getPcmSampleDepth() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_6, this, this));
        return this.pcmSampleDepth;
    }

    public void setPcmSampleDepth(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_7, this, this, org.aspectj.a.a.a.wl(i)));
        this.pcmSampleDepth = i;
    }

    public int getFrameDuration() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_8, this, this));
        return this.frameDuration;
    }

    public void setFrameDuration(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_9, this, this, org.aspectj.a.a.a.wl(i)));
        this.frameDuration = i;
    }

    public int getStreamConstruction() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_10, this, this));
        return this.streamConstruction;
    }

    public void setStreamConstruction(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_11, this, this, org.aspectj.a.a.a.wl(i)));
        this.streamConstruction = i;
    }

    public int getCoreLFEPresent() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_12, this, this));
        return this.coreLFEPresent;
    }

    public void setCoreLFEPresent(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_13, this, this, org.aspectj.a.a.a.wl(i)));
        this.coreLFEPresent = i;
    }

    public int getCoreLayout() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_14, this, this));
        return this.coreLayout;
    }

    public void setCoreLayout(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_15, this, this, org.aspectj.a.a.a.wl(i)));
        this.coreLayout = i;
    }

    public int getCoreSize() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_16, this, this));
        return this.coreSize;
    }

    public void setCoreSize(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_17, this, this, org.aspectj.a.a.a.wl(i)));
        this.coreSize = i;
    }

    public int getStereoDownmix() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_18, this, this));
        return this.stereoDownmix;
    }

    public void setStereoDownmix(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_19, this, this, org.aspectj.a.a.a.wl(i)));
        this.stereoDownmix = i;
    }

    public int getRepresentationType() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_20, this, this));
        return this.representationType;
    }

    public void setRepresentationType(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_21, this, this, org.aspectj.a.a.a.wl(i)));
        this.representationType = i;
    }

    public int getChannelLayout() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_22, this, this));
        return this.channelLayout;
    }

    public void setChannelLayout(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_23, this, this, org.aspectj.a.a.a.wl(i)));
        this.channelLayout = i;
    }

    public int getMultiAssetFlag() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_24, this, this));
        return this.multiAssetFlag;
    }

    public void setMultiAssetFlag(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_25, this, this, org.aspectj.a.a.a.wl(i)));
        this.multiAssetFlag = i;
    }

    public int getLBRDurationMod() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_26, this, this));
        return this.LBRDurationMod;
    }

    public void setLBRDurationMod(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_27, this, this, org.aspectj.a.a.a.wl(i)));
        this.LBRDurationMod = i;
    }

    public int getReserved() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_28, this, this));
        return this.reserved;
    }

    public void setReserved(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_29, this, this, org.aspectj.a.a.a.wl(i)));
        this.reserved = i;
    }

    public int getReservedBoxPresent() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_30, this, this));
        return this.reservedBoxPresent;
    }

    public void setReservedBoxPresent(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_31, this, this, org.aspectj.a.a.a.wl(i)));
        this.reservedBoxPresent = i;
    }
}
