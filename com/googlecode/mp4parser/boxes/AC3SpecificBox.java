package com.googlecode.mp4parser.boxes;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitWriterBuffer;
import g.a.a.a;
import g.a.b.b.b;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class AC3SpecificBox extends AbstractBox {
    public static final String TYPE = "dac3";
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_0 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_1 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_10 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_11 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_12 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_13 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_14 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_2 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_3 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_4 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_5 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_6 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_7 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_8 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_9 = null;
    public int acmod;
    public int bitRateCode;
    public int bsid;
    public int bsmod;
    public int fscod;
    public int lfeon;
    public int reserved;

    static {
        ajc$preClinit();
    }

    public AC3SpecificBox() {
        super(TYPE);
    }

    public static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("AC3SpecificBox.java", AC3SpecificBox.class);
        ajc$tjp_0 = bVar.g("method-execution", bVar.f("1", "getFscod", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "", "", "", "int"), 55);
        ajc$tjp_1 = bVar.g("method-execution", bVar.f("1", "setFscod", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "int", "fscod", "", "void"), 59);
        ajc$tjp_10 = bVar.g("method-execution", bVar.f("1", "getBitRateCode", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "", "", "", "int"), 95);
        ajc$tjp_11 = bVar.g("method-execution", bVar.f("1", "setBitRateCode", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "int", "bitRateCode", "", "void"), 99);
        ajc$tjp_12 = bVar.g("method-execution", bVar.f("1", "getReserved", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "", "", "", "int"), 103);
        ajc$tjp_13 = bVar.g("method-execution", bVar.f("1", "setReserved", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "int", "reserved", "", "void"), 107);
        ajc$tjp_14 = bVar.g("method-execution", bVar.f("1", "toString", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "", "", "", "java.lang.String"), 112);
        ajc$tjp_2 = bVar.g("method-execution", bVar.f("1", "getBsid", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "", "", "", "int"), 63);
        ajc$tjp_3 = bVar.g("method-execution", bVar.f("1", "setBsid", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "int", "bsid", "", "void"), 67);
        ajc$tjp_4 = bVar.g("method-execution", bVar.f("1", "getBsmod", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "", "", "", "int"), 71);
        ajc$tjp_5 = bVar.g("method-execution", bVar.f("1", "setBsmod", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "int", "bsmod", "", "void"), 75);
        ajc$tjp_6 = bVar.g("method-execution", bVar.f("1", "getAcmod", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "", "", "", "int"), 79);
        ajc$tjp_7 = bVar.g("method-execution", bVar.f("1", "setAcmod", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "int", "acmod", "", "void"), 83);
        ajc$tjp_8 = bVar.g("method-execution", bVar.f("1", "getLfeon", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "", "", "", "int"), 87);
        ajc$tjp_9 = bVar.g("method-execution", bVar.f("1", "setLfeon", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "int", "lfeon", "", "void"), 91);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        BitReaderBuffer bitReaderBuffer = new BitReaderBuffer(byteBuffer);
        this.fscod = bitReaderBuffer.readBits(2);
        this.bsid = bitReaderBuffer.readBits(5);
        this.bsmod = bitReaderBuffer.readBits(3);
        this.acmod = bitReaderBuffer.readBits(3);
        this.lfeon = bitReaderBuffer.readBits(1);
        this.bitRateCode = bitReaderBuffer.readBits(5);
        this.reserved = bitReaderBuffer.readBits(5);
    }

    public int getAcmod() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_6, this, this));
        return this.acmod;
    }

    public int getBitRateCode() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_10, this, this));
        return this.bitRateCode;
    }

    public int getBsid() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return this.bsid;
    }

    public int getBsmod() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        return this.bsmod;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        BitWriterBuffer bitWriterBuffer = new BitWriterBuffer(byteBuffer);
        bitWriterBuffer.writeBits(this.fscod, 2);
        bitWriterBuffer.writeBits(this.bsid, 5);
        bitWriterBuffer.writeBits(this.bsmod, 3);
        bitWriterBuffer.writeBits(this.acmod, 3);
        bitWriterBuffer.writeBits(this.lfeon, 1);
        bitWriterBuffer.writeBits(this.bitRateCode, 5);
        bitWriterBuffer.writeBits(this.reserved, 5);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        return 3L;
    }

    public int getFscod() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.fscod;
    }

    public int getLfeon() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_8, this, this));
        return this.lfeon;
    }

    public int getReserved() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_12, this, this));
        return this.reserved;
    }

    public void setAcmod(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_7, this, this, g.a.b.a.a.e(i)));
        this.acmod = i;
    }

    public void setBitRateCode(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_11, this, this, g.a.b.a.a.e(i)));
        this.bitRateCode = i;
    }

    public void setBsid(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_3, this, this, g.a.b.a.a.e(i)));
        this.bsid = i;
    }

    public void setBsmod(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_5, this, this, g.a.b.a.a.e(i)));
        this.bsmod = i;
    }

    public void setFscod(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, g.a.b.a.a.e(i)));
        this.fscod = i;
    }

    public void setLfeon(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_9, this, this, g.a.b.a.a.e(i)));
        this.lfeon = i;
    }

    public void setReserved(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_13, this, this, g.a.b.a.a.e(i)));
        this.reserved = i;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_14, this, this));
        return "AC3SpecificBox{fscod=" + this.fscod + ", bsid=" + this.bsid + ", bsmod=" + this.bsmod + ", acmod=" + this.acmod + ", lfeon=" + this.lfeon + ", bitRateCode=" + this.bitRateCode + ", reserved=" + this.reserved + '}';
    }
}
