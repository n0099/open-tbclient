package com.googlecode.mp4parser.boxes;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.lbspay.channelpay.IChannelPay;
import com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitWriterBuffer;
import g.a.a.a;
import g.a.b.b.b;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class DTSSpecificBox extends AbstractBox {
    public static final String TYPE = "ddts";
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_0 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_1 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_10 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_11 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_12 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_13 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_14 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_15 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_16 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_17 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_18 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_19 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_2 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_20 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_21 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_22 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_23 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_24 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_25 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_26 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_27 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_28 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_29 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_3 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_30 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_31 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_4 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_5 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_6 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_7 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_8 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_9 = null;
    public long DTSSamplingFrequency;
    public int LBRDurationMod;
    public long avgBitRate;
    public int channelLayout;
    public int coreLFEPresent;
    public int coreLayout;
    public int coreSize;
    public int frameDuration;
    public long maxBitRate;
    public int multiAssetFlag;
    public int pcmSampleDepth;
    public int representationType;
    public int reserved;
    public int reservedBoxPresent;
    public int stereoDownmix;
    public int streamConstruction;

    static {
        ajc$preClinit();
    }

    public DTSSpecificBox() {
        super(TYPE);
    }

    public static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("DTSSpecificBox.java", DTSSpecificBox.class);
        ajc$tjp_0 = bVar.g("method-execution", bVar.f("1", "getAvgBitRate", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "long"), 88);
        ajc$tjp_1 = bVar.g("method-execution", bVar.f("1", "setAvgBitRate", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "long", "avgBitRate", "", "void"), 92);
        ajc$tjp_10 = bVar.g("method-execution", bVar.f("1", "getStreamConstruction", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 128);
        ajc$tjp_11 = bVar.g("method-execution", bVar.f("1", "setStreamConstruction", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "streamConstruction", "", "void"), 132);
        ajc$tjp_12 = bVar.g("method-execution", bVar.f("1", "getCoreLFEPresent", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 136);
        ajc$tjp_13 = bVar.g("method-execution", bVar.f("1", "setCoreLFEPresent", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "coreLFEPresent", "", "void"), PbFullScreenEditorActivity.REPLY_MAX_SIZE);
        ajc$tjp_14 = bVar.g("method-execution", bVar.f("1", "getCoreLayout", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 144);
        ajc$tjp_15 = bVar.g("method-execution", bVar.f("1", "setCoreLayout", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "coreLayout", "", "void"), Opcodes.LCMP);
        ajc$tjp_16 = bVar.g("method-execution", bVar.f("1", "getCoreSize", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 152);
        ajc$tjp_17 = bVar.g("method-execution", bVar.f("1", "setCoreSize", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "coreSize", "", "void"), 156);
        ajc$tjp_18 = bVar.g("method-execution", bVar.f("1", "getStereoDownmix", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 160);
        ajc$tjp_19 = bVar.g("method-execution", bVar.f("1", "setStereoDownmix", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "stereoDownmix", "", "void"), IChannelPay.ID_IPAY_PAY_GAME);
        ajc$tjp_2 = bVar.g("method-execution", bVar.f("1", "getDTSSamplingFrequency", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "long"), 96);
        ajc$tjp_20 = bVar.g("method-execution", bVar.f("1", "getRepresentationType", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 168);
        ajc$tjp_21 = bVar.g("method-execution", bVar.f("1", "setRepresentationType", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "representationType", "", "void"), 172);
        ajc$tjp_22 = bVar.g("method-execution", bVar.f("1", "getChannelLayout", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), Opcodes.ARETURN);
        ajc$tjp_23 = bVar.g("method-execution", bVar.f("1", "setChannelLayout", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "channelLayout", "", "void"), 180);
        ajc$tjp_24 = bVar.g("method-execution", bVar.f("1", "getMultiAssetFlag", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), Opcodes.INVOKESTATIC);
        ajc$tjp_25 = bVar.g("method-execution", bVar.f("1", "setMultiAssetFlag", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "multiAssetFlag", "", "void"), Opcodes.NEWARRAY);
        ajc$tjp_26 = bVar.g("method-execution", bVar.f("1", "getLBRDurationMod", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 192);
        ajc$tjp_27 = bVar.g("method-execution", bVar.f("1", "setLBRDurationMod", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "LBRDurationMod", "", "void"), 196);
        ajc$tjp_28 = bVar.g("method-execution", bVar.f("1", "getReserved", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 200);
        ajc$tjp_29 = bVar.g("method-execution", bVar.f("1", "setReserved", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "reserved", "", "void"), 204);
        ajc$tjp_3 = bVar.g("method-execution", bVar.f("1", "setDTSSamplingFrequency", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "long", "DTSSamplingFrequency", "", "void"), 100);
        ajc$tjp_30 = bVar.g("method-execution", bVar.f("1", "getReservedBoxPresent", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 208);
        ajc$tjp_31 = bVar.g("method-execution", bVar.f("1", "setReservedBoxPresent", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "reservedBoxPresent", "", "void"), 212);
        ajc$tjp_4 = bVar.g("method-execution", bVar.f("1", "getMaxBitRate", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "long"), 104);
        ajc$tjp_5 = bVar.g("method-execution", bVar.f("1", "setMaxBitRate", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "long", "maxBitRate", "", "void"), 108);
        ajc$tjp_6 = bVar.g("method-execution", bVar.f("1", "getPcmSampleDepth", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 112);
        ajc$tjp_7 = bVar.g("method-execution", bVar.f("1", "setPcmSampleDepth", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "pcmSampleDepth", "", "void"), 116);
        ajc$tjp_8 = bVar.g("method-execution", bVar.f("1", "getFrameDuration", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 120);
        ajc$tjp_9 = bVar.g("method-execution", bVar.f("1", "setFrameDuration", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "frameDuration", "", "void"), 124);
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

    public long getAvgBitRate() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.avgBitRate;
    }

    public int getChannelLayout() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_22, this, this));
        return this.channelLayout;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
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

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        return 20L;
    }

    public int getCoreLFEPresent() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_12, this, this));
        return this.coreLFEPresent;
    }

    public int getCoreLayout() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_14, this, this));
        return this.coreLayout;
    }

    public int getCoreSize() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_16, this, this));
        return this.coreSize;
    }

    public long getDTSSamplingFrequency() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return this.DTSSamplingFrequency;
    }

    public int getFrameDuration() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_8, this, this));
        return this.frameDuration;
    }

    public int getLBRDurationMod() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_26, this, this));
        return this.LBRDurationMod;
    }

    public long getMaxBitRate() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        return this.maxBitRate;
    }

    public int getMultiAssetFlag() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_24, this, this));
        return this.multiAssetFlag;
    }

    public int getPcmSampleDepth() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_6, this, this));
        return this.pcmSampleDepth;
    }

    public int getRepresentationType() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_20, this, this));
        return this.representationType;
    }

    public int getReserved() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_28, this, this));
        return this.reserved;
    }

    public int getReservedBoxPresent() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_30, this, this));
        return this.reservedBoxPresent;
    }

    public int getStereoDownmix() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_18, this, this));
        return this.stereoDownmix;
    }

    public int getStreamConstruction() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_10, this, this));
        return this.streamConstruction;
    }

    public void setAvgBitRate(long j) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, g.a.b.a.a.f(j)));
        this.avgBitRate = j;
    }

    public void setChannelLayout(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_23, this, this, g.a.b.a.a.e(i2)));
        this.channelLayout = i2;
    }

    public void setCoreLFEPresent(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_13, this, this, g.a.b.a.a.e(i2)));
        this.coreLFEPresent = i2;
    }

    public void setCoreLayout(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_15, this, this, g.a.b.a.a.e(i2)));
        this.coreLayout = i2;
    }

    public void setCoreSize(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_17, this, this, g.a.b.a.a.e(i2)));
        this.coreSize = i2;
    }

    public void setDTSSamplingFrequency(long j) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_3, this, this, g.a.b.a.a.f(j)));
        this.DTSSamplingFrequency = j;
    }

    public void setFrameDuration(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_9, this, this, g.a.b.a.a.e(i2)));
        this.frameDuration = i2;
    }

    public void setLBRDurationMod(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_27, this, this, g.a.b.a.a.e(i2)));
        this.LBRDurationMod = i2;
    }

    public void setMaxBitRate(long j) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_5, this, this, g.a.b.a.a.f(j)));
        this.maxBitRate = j;
    }

    public void setMultiAssetFlag(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_25, this, this, g.a.b.a.a.e(i2)));
        this.multiAssetFlag = i2;
    }

    public void setPcmSampleDepth(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_7, this, this, g.a.b.a.a.e(i2)));
        this.pcmSampleDepth = i2;
    }

    public void setRepresentationType(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_21, this, this, g.a.b.a.a.e(i2)));
        this.representationType = i2;
    }

    public void setReserved(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_29, this, this, g.a.b.a.a.e(i2)));
        this.reserved = i2;
    }

    public void setReservedBoxPresent(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_31, this, this, g.a.b.a.a.e(i2)));
        this.reservedBoxPresent = i2;
    }

    public void setStereoDownmix(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_19, this, this, g.a.b.a.a.e(i2)));
        this.stereoDownmix = i2;
    }

    public void setStreamConstruction(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_11, this, this, g.a.b.a.a.e(i2)));
        this.streamConstruction = i2;
    }
}
