package com.coremedia.iso.boxes.h264;

import com.coremedia.iso.Hex;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitWriterBuffer;
import com.googlecode.mp4parser.h264.model.PictureParameterSet;
import com.googlecode.mp4parser.h264.model.SeqParameterSet;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes5.dex */
public final class AvcConfigurationBox extends AbstractBox {
    public static final String TYPE = "avcC";
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_10 = null;
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_11 = null;
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_12 = null;
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_13 = null;
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_14 = null;
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_15 = null;
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_16 = null;
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_17 = null;
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_18 = null;
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_19 = null;
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_20 = null;
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_21 = null;
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_22 = null;
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_23 = null;
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_24 = null;
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_25 = null;
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_26 = null;
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_27 = null;
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_28 = null;
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_6 = null;
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_7 = null;
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_8 = null;
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_9 = null;
    public AVCDecoderConfigurationRecord avcDecoderConfigurationRecord;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("AvcConfigurationBox.java", AvcConfigurationBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.b("1", "getConfigurationVersion", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "int"), 54);
        ajc$tjp_1 = bVar.a("method-execution", bVar.b("1", "getAvcProfileIndication", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "int"), 58);
        ajc$tjp_10 = bVar.a("method-execution", bVar.b("1", "setAvcLevelIndication", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "int", "avcLevelIndication", "", "void"), 94);
        ajc$tjp_11 = bVar.a("method-execution", bVar.b("1", "setLengthSizeMinusOne", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "int", "lengthSizeMinusOne", "", "void"), 98);
        ajc$tjp_12 = bVar.a("method-execution", bVar.b("1", "setSequenceParameterSets", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "java.util.List", "sequenceParameterSets", "", "void"), 102);
        ajc$tjp_13 = bVar.a("method-execution", bVar.b("1", "setPictureParameterSets", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "java.util.List", "pictureParameterSets", "", "void"), 106);
        ajc$tjp_14 = bVar.a("method-execution", bVar.b("1", "getChromaFormat", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "int"), 110);
        ajc$tjp_15 = bVar.a("method-execution", bVar.b("1", "setChromaFormat", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "int", "chromaFormat", "", "void"), 114);
        ajc$tjp_16 = bVar.a("method-execution", bVar.b("1", "getBitDepthLumaMinus8", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "int"), 118);
        ajc$tjp_17 = bVar.a("method-execution", bVar.b("1", "setBitDepthLumaMinus8", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "int", "bitDepthLumaMinus8", "", "void"), 122);
        ajc$tjp_18 = bVar.a("method-execution", bVar.b("1", "getBitDepthChromaMinus8", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "int"), 126);
        ajc$tjp_19 = bVar.a("method-execution", bVar.b("1", "setBitDepthChromaMinus8", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "int", "bitDepthChromaMinus8", "", "void"), 130);
        ajc$tjp_2 = bVar.a("method-execution", bVar.b("1", "getProfileCompatibility", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "int"), 62);
        ajc$tjp_20 = bVar.a("method-execution", bVar.b("1", "getSequenceParameterSetExts", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "java.util.List"), 134);
        ajc$tjp_21 = bVar.a("method-execution", bVar.b("1", "setSequenceParameterSetExts", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "java.util.List", "sequenceParameterSetExts", "", "void"), 138);
        ajc$tjp_22 = bVar.a("method-execution", bVar.b("1", "hasExts", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "boolean"), 142);
        ajc$tjp_23 = bVar.a("method-execution", bVar.b("1", "setHasExts", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "boolean", "hasExts", "", "void"), 146);
        ajc$tjp_24 = bVar.a("method-execution", bVar.b("1", "getContentSize", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "long"), 157);
        ajc$tjp_25 = bVar.a("method-execution", bVar.b("1", "getContent", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "java.nio.ByteBuffer", "byteBuffer", "", "void"), 163);
        ajc$tjp_26 = bVar.a("method-execution", bVar.b("1", "getSPS", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "[Ljava.lang.String;"), 168);
        ajc$tjp_27 = bVar.a("method-execution", bVar.b("1", "getPPS", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "[Ljava.lang.String;"), 172);
        ajc$tjp_28 = bVar.a("method-execution", bVar.b("1", "getavcDecoderConfigurationRecord", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "com.coremedia.iso.boxes.h264.AvcConfigurationBox$AVCDecoderConfigurationRecord"), 177);
        ajc$tjp_3 = bVar.a("method-execution", bVar.b("1", "getAvcLevelIndication", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "int"), 66);
        ajc$tjp_4 = bVar.a("method-execution", bVar.b("1", "getLengthSizeMinusOne", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "int"), 70);
        ajc$tjp_5 = bVar.a("method-execution", bVar.b("1", "getSequenceParameterSets", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "java.util.List"), 74);
        ajc$tjp_6 = bVar.a("method-execution", bVar.b("1", "getPictureParameterSets", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "java.util.List"), 78);
        ajc$tjp_7 = bVar.a("method-execution", bVar.b("1", "setConfigurationVersion", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "int", "configurationVersion", "", "void"), 82);
        ajc$tjp_8 = bVar.a("method-execution", bVar.b("1", "setAvcProfileIndication", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "int", "avcProfileIndication", "", "void"), 86);
        ajc$tjp_9 = bVar.a("method-execution", bVar.b("1", "setProfileCompatibility", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "int", "profileCompatibility", "", "void"), 90);
    }

    public AvcConfigurationBox() {
        super(TYPE);
        this.avcDecoderConfigurationRecord = new AVCDecoderConfigurationRecord();
    }

    public int getConfigurationVersion() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.avcDecoderConfigurationRecord.configurationVersion;
    }

    public int getAvcProfileIndication() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this));
        return this.avcDecoderConfigurationRecord.avcProfileIndication;
    }

    public int getProfileCompatibility() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this));
        return this.avcDecoderConfigurationRecord.profileCompatibility;
    }

    public int getAvcLevelIndication() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this));
        return this.avcDecoderConfigurationRecord.avcLevelIndication;
    }

    public int getLengthSizeMinusOne() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_4, this, this));
        return this.avcDecoderConfigurationRecord.lengthSizeMinusOne;
    }

    public List<byte[]> getSequenceParameterSets() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_5, this, this));
        return Collections.unmodifiableList(this.avcDecoderConfigurationRecord.sequenceParameterSets);
    }

    public List<byte[]> getPictureParameterSets() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_6, this, this));
        return Collections.unmodifiableList(this.avcDecoderConfigurationRecord.pictureParameterSets);
    }

    public void setConfigurationVersion(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_7, this, this, org.aspectj.a.a.a.zr(i)));
        this.avcDecoderConfigurationRecord.configurationVersion = i;
    }

    public void setAvcProfileIndication(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_8, this, this, org.aspectj.a.a.a.zr(i)));
        this.avcDecoderConfigurationRecord.avcProfileIndication = i;
    }

    public void setProfileCompatibility(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_9, this, this, org.aspectj.a.a.a.zr(i)));
        this.avcDecoderConfigurationRecord.profileCompatibility = i;
    }

    public void setAvcLevelIndication(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_10, this, this, org.aspectj.a.a.a.zr(i)));
        this.avcDecoderConfigurationRecord.avcLevelIndication = i;
    }

    public void setLengthSizeMinusOne(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_11, this, this, org.aspectj.a.a.a.zr(i)));
        this.avcDecoderConfigurationRecord.lengthSizeMinusOne = i;
    }

    public void setSequenceParameterSets(List<byte[]> list) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_12, this, this, list));
        this.avcDecoderConfigurationRecord.sequenceParameterSets = list;
    }

    public void setPictureParameterSets(List<byte[]> list) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_13, this, this, list));
        this.avcDecoderConfigurationRecord.pictureParameterSets = list;
    }

    public int getChromaFormat() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_14, this, this));
        return this.avcDecoderConfigurationRecord.chromaFormat;
    }

    public void setChromaFormat(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_15, this, this, org.aspectj.a.a.a.zr(i)));
        this.avcDecoderConfigurationRecord.chromaFormat = i;
    }

    public int getBitDepthLumaMinus8() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_16, this, this));
        return this.avcDecoderConfigurationRecord.bitDepthLumaMinus8;
    }

    public void setBitDepthLumaMinus8(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_17, this, this, org.aspectj.a.a.a.zr(i)));
        this.avcDecoderConfigurationRecord.bitDepthLumaMinus8 = i;
    }

    public int getBitDepthChromaMinus8() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_18, this, this));
        return this.avcDecoderConfigurationRecord.bitDepthChromaMinus8;
    }

    public void setBitDepthChromaMinus8(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_19, this, this, org.aspectj.a.a.a.zr(i)));
        this.avcDecoderConfigurationRecord.bitDepthChromaMinus8 = i;
    }

    public List<byte[]> getSequenceParameterSetExts() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_20, this, this));
        return this.avcDecoderConfigurationRecord.sequenceParameterSetExts;
    }

    public void setSequenceParameterSetExts(List<byte[]> list) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_21, this, this, list));
        this.avcDecoderConfigurationRecord.sequenceParameterSetExts = list;
    }

    public boolean hasExts() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_22, this, this));
        return this.avcDecoderConfigurationRecord.hasExts;
    }

    public void setHasExts(boolean z) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_23, this, this, org.aspectj.a.a.a.pk(z)));
        this.avcDecoderConfigurationRecord.hasExts = z;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        this.avcDecoderConfigurationRecord = new AVCDecoderConfigurationRecord(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_24, this, this));
        return this.avcDecoderConfigurationRecord.getContentSize();
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_25, this, this, byteBuffer));
        this.avcDecoderConfigurationRecord.getContent(byteBuffer);
    }

    public String[] getSPS() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_26, this, this));
        return this.avcDecoderConfigurationRecord.getSPS();
    }

    public String[] getPPS() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_27, this, this));
        return this.avcDecoderConfigurationRecord.getPPS();
    }

    public AVCDecoderConfigurationRecord getavcDecoderConfigurationRecord() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_28, this, this));
        return this.avcDecoderConfigurationRecord;
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

        public AVCDecoderConfigurationRecord(ByteBuffer byteBuffer) {
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
            for (int i = 0; i < readBits; i++) {
                byte[] bArr = new byte[IsoTypeReader.readUInt16(byteBuffer)];
                byteBuffer.get(bArr);
                this.sequenceParameterSets.add(bArr);
            }
            long readUInt8 = IsoTypeReader.readUInt8(byteBuffer);
            for (int i2 = 0; i2 < readUInt8; i2++) {
                byte[] bArr2 = new byte[IsoTypeReader.readUInt16(byteBuffer)];
                byteBuffer.get(bArr2);
                this.pictureParameterSets.add(bArr2);
            }
            if (byteBuffer.remaining() < 4) {
                this.hasExts = false;
            }
            if (this.hasExts && (this.avcProfileIndication == 100 || this.avcProfileIndication == 110 || this.avcProfileIndication == 122 || this.avcProfileIndication == 144)) {
                BitReaderBuffer bitReaderBuffer2 = new BitReaderBuffer(byteBuffer);
                this.chromaFormatPaddingBits = bitReaderBuffer2.readBits(6);
                this.chromaFormat = bitReaderBuffer2.readBits(2);
                this.bitDepthLumaMinus8PaddingBits = bitReaderBuffer2.readBits(5);
                this.bitDepthLumaMinus8 = bitReaderBuffer2.readBits(3);
                this.bitDepthChromaMinus8PaddingBits = bitReaderBuffer2.readBits(5);
                this.bitDepthChromaMinus8 = bitReaderBuffer2.readBits(3);
                long readUInt82 = IsoTypeReader.readUInt8(byteBuffer);
                for (int i3 = 0; i3 < readUInt82; i3++) {
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
                if (this.avcProfileIndication == 100 || this.avcProfileIndication == 110 || this.avcProfileIndication == 122 || this.avcProfileIndication == 144) {
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
            long j;
            long j2;
            long j3 = 5 + 1;
            Iterator<byte[]> it = this.sequenceParameterSets.iterator();
            while (true) {
                j = j3;
                if (!it.hasNext()) {
                    break;
                }
                j3 = it.next().length + j + 2;
            }
            long j4 = j + 1;
            Iterator<byte[]> it2 = this.pictureParameterSets.iterator();
            while (true) {
                j2 = j4;
                if (!it2.hasNext()) {
                    break;
                }
                j4 = it2.next().length + j2 + 2;
            }
            if (this.hasExts && (this.avcProfileIndication == 100 || this.avcProfileIndication == 110 || this.avcProfileIndication == 122 || this.avcProfileIndication == 144)) {
                long j5 = 4 + j2;
                Iterator<byte[]> it3 = this.sequenceParameterSetExts.iterator();
                while (true) {
                    j2 = j5;
                    if (!it3.hasNext()) {
                        break;
                    }
                    j5 = it3.next().length + j2 + 2;
                }
            }
            return j2;
        }

        public String[] getPPS() {
            ArrayList arrayList = new ArrayList();
            for (byte[] bArr : this.pictureParameterSets) {
                try {
                    arrayList.add(PictureParameterSet.read(new ByteArrayInputStream(bArr, 1, bArr.length - 1)).toString());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }

        public String[] getSPS() {
            String str;
            ArrayList arrayList = new ArrayList();
            for (byte[] bArr : this.sequenceParameterSets) {
                try {
                    str = SeqParameterSet.read(new ByteArrayInputStream(bArr, 1, bArr.length - 1)).toString();
                } catch (IOException e) {
                    str = "not parsable";
                }
                arrayList.add(str);
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }

        public List<String> getSequenceParameterSetsAsStrings() {
            ArrayList arrayList = new ArrayList(this.sequenceParameterSets.size());
            for (byte[] bArr : this.sequenceParameterSets) {
                arrayList.add(Hex.encodeHex(bArr));
            }
            return arrayList;
        }

        public List<String> getSequenceParameterSetExtsAsStrings() {
            ArrayList arrayList = new ArrayList(this.sequenceParameterSetExts.size());
            for (byte[] bArr : this.sequenceParameterSetExts) {
                arrayList.add(Hex.encodeHex(bArr));
            }
            return arrayList;
        }

        public List<String> getPictureParameterSetsAsStrings() {
            ArrayList arrayList = new ArrayList(this.pictureParameterSets.size());
            for (byte[] bArr : this.pictureParameterSets) {
                arrayList.add(Hex.encodeHex(bArr));
            }
            return arrayList;
        }
    }
}
