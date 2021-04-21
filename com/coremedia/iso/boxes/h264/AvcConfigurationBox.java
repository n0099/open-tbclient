package com.coremedia.iso.boxes.h264;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.coremedia.iso.Hex;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitWriterBuffer;
import com.googlecode.mp4parser.h264.model.PictureParameterSet;
import com.googlecode.mp4parser.h264.model.SeqParameterSet;
import g.a.a.a;
import g.a.b.b.b;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public final class AvcConfigurationBox extends AbstractBox {
    public static final String TYPE = "avcC";
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_0 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_1 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_10 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_11 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_12 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_13 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_14 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_15 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_16 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_17 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_18 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_19 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_2 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_20 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_21 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_22 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_23 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_24 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_25 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_26 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_27 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_28 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_3 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_4 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_5 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_6 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_7 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_8 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_9 = null;
    public AVCDecoderConfigurationRecord avcDecoderConfigurationRecord;

    static {
        ajc$preClinit();
    }

    public AvcConfigurationBox() {
        super(TYPE);
        this.avcDecoderConfigurationRecord = new AVCDecoderConfigurationRecord();
    }

    public static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("AvcConfigurationBox.java", AvcConfigurationBox.class);
        ajc$tjp_0 = bVar.g("method-execution", bVar.f("1", "getConfigurationVersion", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "int"), 54);
        ajc$tjp_1 = bVar.g("method-execution", bVar.f("1", "getAvcProfileIndication", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "int"), 58);
        ajc$tjp_10 = bVar.g("method-execution", bVar.f("1", "setAvcLevelIndication", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "int", "avcLevelIndication", "", "void"), 94);
        ajc$tjp_11 = bVar.g("method-execution", bVar.f("1", "setLengthSizeMinusOne", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "int", "lengthSizeMinusOne", "", "void"), 98);
        ajc$tjp_12 = bVar.g("method-execution", bVar.f("1", "setSequenceParameterSets", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "java.util.List", "sequenceParameterSets", "", "void"), 102);
        ajc$tjp_13 = bVar.g("method-execution", bVar.f("1", "setPictureParameterSets", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "java.util.List", "pictureParameterSets", "", "void"), 106);
        ajc$tjp_14 = bVar.g("method-execution", bVar.f("1", "getChromaFormat", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "int"), 110);
        ajc$tjp_15 = bVar.g("method-execution", bVar.f("1", "setChromaFormat", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "int", "chromaFormat", "", "void"), 114);
        ajc$tjp_16 = bVar.g("method-execution", bVar.f("1", "getBitDepthLumaMinus8", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "int"), 118);
        ajc$tjp_17 = bVar.g("method-execution", bVar.f("1", "setBitDepthLumaMinus8", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "int", "bitDepthLumaMinus8", "", "void"), 122);
        ajc$tjp_18 = bVar.g("method-execution", bVar.f("1", "getBitDepthChromaMinus8", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "int"), 126);
        ajc$tjp_19 = bVar.g("method-execution", bVar.f("1", "setBitDepthChromaMinus8", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "int", "bitDepthChromaMinus8", "", "void"), IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
        ajc$tjp_2 = bVar.g("method-execution", bVar.f("1", "getProfileCompatibility", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "int"), 62);
        ajc$tjp_20 = bVar.g("method-execution", bVar.f("1", "getSequenceParameterSetExts", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "java.util.List"), 134);
        ajc$tjp_21 = bVar.g("method-execution", bVar.f("1", "setSequenceParameterSetExts", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "java.util.List", "sequenceParameterSetExts", "", "void"), 138);
        ajc$tjp_22 = bVar.g("method-execution", bVar.f("1", "hasExts", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "boolean"), 142);
        ajc$tjp_23 = bVar.g("method-execution", bVar.f("1", "setHasExts", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "boolean", "hasExts", "", "void"), 146);
        ajc$tjp_24 = bVar.g("method-execution", bVar.f("1", "getContentSize", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "long"), 157);
        ajc$tjp_25 = bVar.g("method-execution", bVar.f("1", "getContent", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "java.nio.ByteBuffer", "byteBuffer", "", "void"), 163);
        ajc$tjp_26 = bVar.g("method-execution", bVar.f("1", "getSPS", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "[Ljava.lang.String;"), 168);
        ajc$tjp_27 = bVar.g("method-execution", bVar.f("1", "getPPS", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "[Ljava.lang.String;"), 172);
        ajc$tjp_28 = bVar.g("method-execution", bVar.f("1", "getavcDecoderConfigurationRecord", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "com.coremedia.iso.boxes.h264.AvcConfigurationBox$AVCDecoderConfigurationRecord"), Opcodes.RETURN);
        ajc$tjp_3 = bVar.g("method-execution", bVar.f("1", "getAvcLevelIndication", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "int"), 66);
        ajc$tjp_4 = bVar.g("method-execution", bVar.f("1", "getLengthSizeMinusOne", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "int"), 70);
        ajc$tjp_5 = bVar.g("method-execution", bVar.f("1", "getSequenceParameterSets", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "java.util.List"), 74);
        ajc$tjp_6 = bVar.g("method-execution", bVar.f("1", "getPictureParameterSets", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "java.util.List"), 78);
        ajc$tjp_7 = bVar.g("method-execution", bVar.f("1", "setConfigurationVersion", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "int", "configurationVersion", "", "void"), 82);
        ajc$tjp_8 = bVar.g("method-execution", bVar.f("1", "setAvcProfileIndication", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "int", "avcProfileIndication", "", "void"), 86);
        ajc$tjp_9 = bVar.g("method-execution", bVar.f("1", "setProfileCompatibility", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "int", "profileCompatibility", "", "void"), 90);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        this.avcDecoderConfigurationRecord = new AVCDecoderConfigurationRecord(byteBuffer);
    }

    public int getAvcLevelIndication() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_3, this, this));
        return this.avcDecoderConfigurationRecord.avcLevelIndication;
    }

    public int getAvcProfileIndication() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_1, this, this));
        return this.avcDecoderConfigurationRecord.avcProfileIndication;
    }

    public int getBitDepthChromaMinus8() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_18, this, this));
        return this.avcDecoderConfigurationRecord.bitDepthChromaMinus8;
    }

    public int getBitDepthLumaMinus8() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_16, this, this));
        return this.avcDecoderConfigurationRecord.bitDepthLumaMinus8;
    }

    public int getChromaFormat() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_14, this, this));
        return this.avcDecoderConfigurationRecord.chromaFormat;
    }

    public int getConfigurationVersion() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.avcDecoderConfigurationRecord.configurationVersion;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_25, this, this, byteBuffer));
        this.avcDecoderConfigurationRecord.getContent(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_24, this, this));
        return this.avcDecoderConfigurationRecord.getContentSize();
    }

    public int getLengthSizeMinusOne() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        return this.avcDecoderConfigurationRecord.lengthSizeMinusOne;
    }

    public String[] getPPS() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_27, this, this));
        return this.avcDecoderConfigurationRecord.getPPS();
    }

    public List<byte[]> getPictureParameterSets() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_6, this, this));
        return Collections.unmodifiableList(this.avcDecoderConfigurationRecord.pictureParameterSets);
    }

    public int getProfileCompatibility() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return this.avcDecoderConfigurationRecord.profileCompatibility;
    }

    public String[] getSPS() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_26, this, this));
        return this.avcDecoderConfigurationRecord.getSPS();
    }

    public List<byte[]> getSequenceParameterSetExts() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_20, this, this));
        return this.avcDecoderConfigurationRecord.sequenceParameterSetExts;
    }

    public List<byte[]> getSequenceParameterSets() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_5, this, this));
        return Collections.unmodifiableList(this.avcDecoderConfigurationRecord.sequenceParameterSets);
    }

    public AVCDecoderConfigurationRecord getavcDecoderConfigurationRecord() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_28, this, this));
        return this.avcDecoderConfigurationRecord;
    }

    public boolean hasExts() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_22, this, this));
        return this.avcDecoderConfigurationRecord.hasExts;
    }

    public void setAvcLevelIndication(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_10, this, this, g.a.b.a.a.e(i)));
        this.avcDecoderConfigurationRecord.avcLevelIndication = i;
    }

    public void setAvcProfileIndication(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_8, this, this, g.a.b.a.a.e(i)));
        this.avcDecoderConfigurationRecord.avcProfileIndication = i;
    }

    public void setBitDepthChromaMinus8(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_19, this, this, g.a.b.a.a.e(i)));
        this.avcDecoderConfigurationRecord.bitDepthChromaMinus8 = i;
    }

    public void setBitDepthLumaMinus8(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_17, this, this, g.a.b.a.a.e(i)));
        this.avcDecoderConfigurationRecord.bitDepthLumaMinus8 = i;
    }

    public void setChromaFormat(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_15, this, this, g.a.b.a.a.e(i)));
        this.avcDecoderConfigurationRecord.chromaFormat = i;
    }

    public void setConfigurationVersion(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_7, this, this, g.a.b.a.a.e(i)));
        this.avcDecoderConfigurationRecord.configurationVersion = i;
    }

    public void setHasExts(boolean z) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_23, this, this, g.a.b.a.a.a(z)));
        this.avcDecoderConfigurationRecord.hasExts = z;
    }

    public void setLengthSizeMinusOne(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_11, this, this, g.a.b.a.a.e(i)));
        this.avcDecoderConfigurationRecord.lengthSizeMinusOne = i;
    }

    public void setPictureParameterSets(List<byte[]> list) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_13, this, this, list));
        this.avcDecoderConfigurationRecord.pictureParameterSets = list;
    }

    public void setProfileCompatibility(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_9, this, this, g.a.b.a.a.e(i)));
        this.avcDecoderConfigurationRecord.profileCompatibility = i;
    }

    public void setSequenceParameterSetExts(List<byte[]> list) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_21, this, this, list));
        this.avcDecoderConfigurationRecord.sequenceParameterSetExts = list;
    }

    public void setSequenceParameterSets(List<byte[]> list) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_12, this, this, list));
        this.avcDecoderConfigurationRecord.sequenceParameterSets = list;
    }

    /* loaded from: classes5.dex */
    public static class AVCDecoderConfigurationRecord {
        public int avcLevelIndication;
        public int avcProfileIndication;
        public int bitDepthChromaMinus8;
        public int bitDepthChromaMinus8PaddingBits;
        public int bitDepthLumaMinus8;
        public int bitDepthLumaMinus8PaddingBits;
        public int chromaFormat;
        public int chromaFormatPaddingBits;
        public int configurationVersion;
        public boolean hasExts;
        public int lengthSizeMinusOne;
        public int lengthSizeMinusOnePaddingBits;
        public int numberOfSequenceParameterSetsPaddingBits;
        public List<byte[]> pictureParameterSets;
        public int profileCompatibility;
        public List<byte[]> sequenceParameterSetExts;
        public List<byte[]> sequenceParameterSets;

        public AVCDecoderConfigurationRecord() {
            this.sequenceParameterSets = new ArrayList();
            this.pictureParameterSets = new ArrayList();
            this.hasExts = true;
            this.chromaFormat = 1;
            this.bitDepthLumaMinus8 = 0;
            this.bitDepthChromaMinus8 = 0;
            this.sequenceParameterSetExts = new ArrayList();
            this.lengthSizeMinusOnePaddingBits = 63;
            this.numberOfSequenceParameterSetsPaddingBits = 7;
            this.chromaFormatPaddingBits = 31;
            this.bitDepthLumaMinus8PaddingBits = 31;
            this.bitDepthChromaMinus8PaddingBits = 31;
        }

        public void getContent(ByteBuffer byteBuffer) {
            IsoTypeWriter.writeUInt8(byteBuffer, this.configurationVersion);
            IsoTypeWriter.writeUInt8(byteBuffer, this.avcProfileIndication);
            IsoTypeWriter.writeUInt8(byteBuffer, this.profileCompatibility);
            IsoTypeWriter.writeUInt8(byteBuffer, this.avcLevelIndication);
            BitWriterBuffer bitWriterBuffer = new BitWriterBuffer(byteBuffer);
            bitWriterBuffer.writeBits(this.lengthSizeMinusOnePaddingBits, 6);
            bitWriterBuffer.writeBits(this.lengthSizeMinusOne, 2);
            bitWriterBuffer.writeBits(this.numberOfSequenceParameterSetsPaddingBits, 3);
            bitWriterBuffer.writeBits(this.pictureParameterSets.size(), 5);
            for (byte[] bArr : this.sequenceParameterSets) {
                IsoTypeWriter.writeUInt16(byteBuffer, bArr.length);
                byteBuffer.put(bArr);
            }
            IsoTypeWriter.writeUInt8(byteBuffer, this.pictureParameterSets.size());
            for (byte[] bArr2 : this.pictureParameterSets) {
                IsoTypeWriter.writeUInt16(byteBuffer, bArr2.length);
                byteBuffer.put(bArr2);
            }
            if (this.hasExts) {
                int i = this.avcProfileIndication;
                if (i == 100 || i == 110 || i == 122 || i == 144) {
                    BitWriterBuffer bitWriterBuffer2 = new BitWriterBuffer(byteBuffer);
                    bitWriterBuffer2.writeBits(this.chromaFormatPaddingBits, 6);
                    bitWriterBuffer2.writeBits(this.chromaFormat, 2);
                    bitWriterBuffer2.writeBits(this.bitDepthLumaMinus8PaddingBits, 5);
                    bitWriterBuffer2.writeBits(this.bitDepthLumaMinus8, 3);
                    bitWriterBuffer2.writeBits(this.bitDepthChromaMinus8PaddingBits, 5);
                    bitWriterBuffer2.writeBits(this.bitDepthChromaMinus8, 3);
                    for (byte[] bArr3 : this.sequenceParameterSetExts) {
                        IsoTypeWriter.writeUInt16(byteBuffer, bArr3.length);
                        byteBuffer.put(bArr3);
                    }
                }
            }
        }

        public long getContentSize() {
            int i;
            long j = 6;
            for (byte[] bArr : this.sequenceParameterSets) {
                j = j + 2 + bArr.length;
            }
            long j2 = j + 1;
            for (byte[] bArr2 : this.pictureParameterSets) {
                j2 = j2 + 2 + bArr2.length;
            }
            if (this.hasExts && ((i = this.avcProfileIndication) == 100 || i == 110 || i == 122 || i == 144)) {
                j2 += 4;
                for (byte[] bArr3 : this.sequenceParameterSetExts) {
                    j2 = j2 + 2 + bArr3.length;
                }
            }
            return j2;
        }

        public String[] getPPS() {
            ArrayList arrayList = new ArrayList();
            for (byte[] bArr : this.pictureParameterSets) {
                try {
                    arrayList.add(PictureParameterSet.read(new ByteArrayInputStream(bArr, 1, bArr.length - 1)).toString());
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }

        public List<String> getPictureParameterSetsAsStrings() {
            ArrayList arrayList = new ArrayList(this.pictureParameterSets.size());
            for (byte[] bArr : this.pictureParameterSets) {
                arrayList.add(Hex.encodeHex(bArr));
            }
            return arrayList;
        }

        public String[] getSPS() {
            String str;
            ArrayList arrayList = new ArrayList();
            for (byte[] bArr : this.sequenceParameterSets) {
                try {
                    str = SeqParameterSet.read(new ByteArrayInputStream(bArr, 1, bArr.length - 1)).toString();
                } catch (IOException unused) {
                    str = "not parsable";
                }
                arrayList.add(str);
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }

        public List<String> getSequenceParameterSetExtsAsStrings() {
            ArrayList arrayList = new ArrayList(this.sequenceParameterSetExts.size());
            for (byte[] bArr : this.sequenceParameterSetExts) {
                arrayList.add(Hex.encodeHex(bArr));
            }
            return arrayList;
        }

        public List<String> getSequenceParameterSetsAsStrings() {
            ArrayList arrayList = new ArrayList(this.sequenceParameterSets.size());
            for (byte[] bArr : this.sequenceParameterSets) {
                arrayList.add(Hex.encodeHex(bArr));
            }
            return arrayList;
        }

        public AVCDecoderConfigurationRecord(ByteBuffer byteBuffer) {
            int i;
            this.sequenceParameterSets = new ArrayList();
            this.pictureParameterSets = new ArrayList();
            this.hasExts = true;
            this.chromaFormat = 1;
            this.bitDepthLumaMinus8 = 0;
            this.bitDepthChromaMinus8 = 0;
            this.sequenceParameterSetExts = new ArrayList();
            this.lengthSizeMinusOnePaddingBits = 63;
            this.numberOfSequenceParameterSetsPaddingBits = 7;
            this.chromaFormatPaddingBits = 31;
            this.bitDepthLumaMinus8PaddingBits = 31;
            this.bitDepthChromaMinus8PaddingBits = 31;
            this.configurationVersion = IsoTypeReader.readUInt8(byteBuffer);
            this.avcProfileIndication = IsoTypeReader.readUInt8(byteBuffer);
            this.profileCompatibility = IsoTypeReader.readUInt8(byteBuffer);
            this.avcLevelIndication = IsoTypeReader.readUInt8(byteBuffer);
            BitReaderBuffer bitReaderBuffer = new BitReaderBuffer(byteBuffer);
            this.lengthSizeMinusOnePaddingBits = bitReaderBuffer.readBits(6);
            this.lengthSizeMinusOne = bitReaderBuffer.readBits(2);
            this.numberOfSequenceParameterSetsPaddingBits = bitReaderBuffer.readBits(3);
            int readBits = bitReaderBuffer.readBits(5);
            for (int i2 = 0; i2 < readBits; i2++) {
                byte[] bArr = new byte[IsoTypeReader.readUInt16(byteBuffer)];
                byteBuffer.get(bArr);
                this.sequenceParameterSets.add(bArr);
            }
            long readUInt8 = IsoTypeReader.readUInt8(byteBuffer);
            for (int i3 = 0; i3 < readUInt8; i3++) {
                byte[] bArr2 = new byte[IsoTypeReader.readUInt16(byteBuffer)];
                byteBuffer.get(bArr2);
                this.pictureParameterSets.add(bArr2);
            }
            if (byteBuffer.remaining() < 4) {
                this.hasExts = false;
            }
            if (this.hasExts && ((i = this.avcProfileIndication) == 100 || i == 110 || i == 122 || i == 144)) {
                BitReaderBuffer bitReaderBuffer2 = new BitReaderBuffer(byteBuffer);
                this.chromaFormatPaddingBits = bitReaderBuffer2.readBits(6);
                this.chromaFormat = bitReaderBuffer2.readBits(2);
                this.bitDepthLumaMinus8PaddingBits = bitReaderBuffer2.readBits(5);
                this.bitDepthLumaMinus8 = bitReaderBuffer2.readBits(3);
                this.bitDepthChromaMinus8PaddingBits = bitReaderBuffer2.readBits(5);
                this.bitDepthChromaMinus8 = bitReaderBuffer2.readBits(3);
                long readUInt82 = IsoTypeReader.readUInt8(byteBuffer);
                for (int i4 = 0; i4 < readUInt82; i4++) {
                    byte[] bArr3 = new byte[IsoTypeReader.readUInt16(byteBuffer)];
                    byteBuffer.get(bArr3);
                    this.sequenceParameterSetExts.add(bArr3);
                }
                return;
            }
            this.chromaFormat = -1;
            this.bitDepthLumaMinus8 = -1;
            this.bitDepthChromaMinus8 = -1;
        }
    }
}
