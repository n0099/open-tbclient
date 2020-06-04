package com.googlecode.mp4parser.boxes;

import com.baidu.ar.gesture.GestureAR;
import com.baidu.live.adp.lib.util.FieldUtil;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitWriterBuffer;
import java.nio.ByteBuffer;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes7.dex */
public class AC3SpecificBox extends AbstractBox {
    public static final String TYPE = "dac3";
    private static final /* synthetic */ a.InterfaceC0889a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0889a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0889a ajc$tjp_10 = null;
    private static final /* synthetic */ a.InterfaceC0889a ajc$tjp_11 = null;
    private static final /* synthetic */ a.InterfaceC0889a ajc$tjp_12 = null;
    private static final /* synthetic */ a.InterfaceC0889a ajc$tjp_13 = null;
    private static final /* synthetic */ a.InterfaceC0889a ajc$tjp_14 = null;
    private static final /* synthetic */ a.InterfaceC0889a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0889a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0889a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0889a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC0889a ajc$tjp_6 = null;
    private static final /* synthetic */ a.InterfaceC0889a ajc$tjp_7 = null;
    private static final /* synthetic */ a.InterfaceC0889a ajc$tjp_8 = null;
    private static final /* synthetic */ a.InterfaceC0889a ajc$tjp_9 = null;
    int acmod;
    int bitRateCode;
    int bsid;
    int bsmod;
    int fscod;
    int lfeon;
    int reserved;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("AC3SpecificBox.java", AC3SpecificBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.b("1", "getFscod", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "", "", "", "int"), 55);
        ajc$tjp_1 = bVar.a("method-execution", bVar.b("1", "setFscod", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "int", "fscod", "", "void"), 59);
        ajc$tjp_10 = bVar.a("method-execution", bVar.b("1", "getBitRateCode", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "", "", "", "int"), 95);
        ajc$tjp_11 = bVar.a("method-execution", bVar.b("1", "setBitRateCode", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "int", "bitRateCode", "", "void"), 99);
        ajc$tjp_12 = bVar.a("method-execution", bVar.b("1", "getReserved", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "", "", "", "int"), 103);
        ajc$tjp_13 = bVar.a("method-execution", bVar.b("1", "setReserved", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "int", GestureAR.SDK_TO_LUA_GESTURE_RESULT_RESERVED, "", "void"), 107);
        ajc$tjp_14 = bVar.a("method-execution", bVar.b("1", "toString", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "", "", "", FieldUtil.TYPE_STRING), 112);
        ajc$tjp_2 = bVar.a("method-execution", bVar.b("1", "getBsid", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "", "", "", "int"), 63);
        ajc$tjp_3 = bVar.a("method-execution", bVar.b("1", "setBsid", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "int", "bsid", "", "void"), 67);
        ajc$tjp_4 = bVar.a("method-execution", bVar.b("1", "getBsmod", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "", "", "", "int"), 71);
        ajc$tjp_5 = bVar.a("method-execution", bVar.b("1", "setBsmod", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "int", "bsmod", "", "void"), 75);
        ajc$tjp_6 = bVar.a("method-execution", bVar.b("1", "getAcmod", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "", "", "", "int"), 79);
        ajc$tjp_7 = bVar.a("method-execution", bVar.b("1", "setAcmod", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "int", "acmod", "", "void"), 83);
        ajc$tjp_8 = bVar.a("method-execution", bVar.b("1", "getLfeon", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "", "", "", "int"), 87);
        ajc$tjp_9 = bVar.a("method-execution", bVar.b("1", "setLfeon", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "int", "lfeon", "", "void"), 91);
    }

    public AC3SpecificBox() {
        super(TYPE);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 3L;
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

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        BitWriterBuffer bitWriterBuffer = new BitWriterBuffer(byteBuffer);
        bitWriterBuffer.writeBits(this.fscod, 2);
        bitWriterBuffer.writeBits(this.bsid, 5);
        bitWriterBuffer.writeBits(this.bsmod, 3);
        bitWriterBuffer.writeBits(this.acmod, 3);
        bitWriterBuffer.writeBits(this.lfeon, 1);
        bitWriterBuffer.writeBits(this.bitRateCode, 5);
        bitWriterBuffer.writeBits(this.reserved, 5);
    }

    public int getFscod() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.fscod;
    }

    public void setFscod(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this, org.aspectj.a.a.a.Kc(i)));
        this.fscod = i;
    }

    public int getBsid() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this));
        return this.bsid;
    }

    public void setBsid(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this, org.aspectj.a.a.a.Kc(i)));
        this.bsid = i;
    }

    public int getBsmod() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_4, this, this));
        return this.bsmod;
    }

    public void setBsmod(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_5, this, this, org.aspectj.a.a.a.Kc(i)));
        this.bsmod = i;
    }

    public int getAcmod() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_6, this, this));
        return this.acmod;
    }

    public void setAcmod(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_7, this, this, org.aspectj.a.a.a.Kc(i)));
        this.acmod = i;
    }

    public int getLfeon() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_8, this, this));
        return this.lfeon;
    }

    public void setLfeon(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_9, this, this, org.aspectj.a.a.a.Kc(i)));
        this.lfeon = i;
    }

    public int getBitRateCode() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_10, this, this));
        return this.bitRateCode;
    }

    public void setBitRateCode(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_11, this, this, org.aspectj.a.a.a.Kc(i)));
        this.bitRateCode = i;
    }

    public int getReserved() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_12, this, this));
        return this.reserved;
    }

    public void setReserved(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_13, this, this, org.aspectj.a.a.a.Kc(i)));
        this.reserved = i;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_14, this, this));
        return "AC3SpecificBox{fscod=" + this.fscod + ", bsid=" + this.bsid + ", bsmod=" + this.bsmod + ", acmod=" + this.acmod + ", lfeon=" + this.lfeon + ", bitRateCode=" + this.bitRateCode + ", reserved=" + this.reserved + '}';
    }
}
