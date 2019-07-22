package com.coremedia.iso.boxes.apple;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes5.dex */
public final class AppleLosslessSpecificBox extends AbstractFullBox {
    public static final String TYPE = "alac";
    private static final /* synthetic */ a.InterfaceC0495a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0495a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0495a ajc$tjp_10 = null;
    private static final /* synthetic */ a.InterfaceC0495a ajc$tjp_11 = null;
    private static final /* synthetic */ a.InterfaceC0495a ajc$tjp_12 = null;
    private static final /* synthetic */ a.InterfaceC0495a ajc$tjp_13 = null;
    private static final /* synthetic */ a.InterfaceC0495a ajc$tjp_14 = null;
    private static final /* synthetic */ a.InterfaceC0495a ajc$tjp_15 = null;
    private static final /* synthetic */ a.InterfaceC0495a ajc$tjp_16 = null;
    private static final /* synthetic */ a.InterfaceC0495a ajc$tjp_17 = null;
    private static final /* synthetic */ a.InterfaceC0495a ajc$tjp_18 = null;
    private static final /* synthetic */ a.InterfaceC0495a ajc$tjp_19 = null;
    private static final /* synthetic */ a.InterfaceC0495a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0495a ajc$tjp_20 = null;
    private static final /* synthetic */ a.InterfaceC0495a ajc$tjp_21 = null;
    private static final /* synthetic */ a.InterfaceC0495a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0495a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0495a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC0495a ajc$tjp_6 = null;
    private static final /* synthetic */ a.InterfaceC0495a ajc$tjp_7 = null;
    private static final /* synthetic */ a.InterfaceC0495a ajc$tjp_8 = null;
    private static final /* synthetic */ a.InterfaceC0495a ajc$tjp_9 = null;
    private long bitRate;
    private int channels;
    private int historyMult;
    private int initialHistory;
    private int kModifier;
    private long maxCodedFrameSize;
    private long maxSamplePerFrame;
    private long sampleRate;
    private int sampleSize;
    private int unknown1;
    private int unknown2;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("AppleLosslessSpecificBox.java", AppleLosslessSpecificBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.b("1", "getMaxSamplePerFrame", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "long"), 34);
        ajc$tjp_1 = bVar.a("method-execution", bVar.b("1", "setMaxSamplePerFrame", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "maxSamplePerFrame", "", "void"), 38);
        ajc$tjp_10 = bVar.a("method-execution", bVar.b("1", "getKModifier", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "int"), 74);
        ajc$tjp_11 = bVar.a("method-execution", bVar.b("1", "setKModifier", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "kModifier", "", "void"), 78);
        ajc$tjp_12 = bVar.a("method-execution", bVar.b("1", "getChannels", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "int"), 82);
        ajc$tjp_13 = bVar.a("method-execution", bVar.b("1", "setChannels", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "channels", "", "void"), 86);
        ajc$tjp_14 = bVar.a("method-execution", bVar.b("1", "getUnknown2", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "int"), 90);
        ajc$tjp_15 = bVar.a("method-execution", bVar.b("1", "setUnknown2", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "unknown2", "", "void"), 94);
        ajc$tjp_16 = bVar.a("method-execution", bVar.b("1", "getMaxCodedFrameSize", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "long"), 98);
        ajc$tjp_17 = bVar.a("method-execution", bVar.b("1", "setMaxCodedFrameSize", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "maxCodedFrameSize", "", "void"), 102);
        ajc$tjp_18 = bVar.a("method-execution", bVar.b("1", "getBitRate", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "long"), 106);
        ajc$tjp_19 = bVar.a("method-execution", bVar.b("1", "setBitRate", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "bitRate", "", "void"), 110);
        ajc$tjp_2 = bVar.a("method-execution", bVar.b("1", "getUnknown1", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "int"), 42);
        ajc$tjp_20 = bVar.a("method-execution", bVar.b("1", "getSampleRate", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "long"), 114);
        ajc$tjp_21 = bVar.a("method-execution", bVar.b("1", "setSampleRate", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "sampleRate", "", "void"), 118);
        ajc$tjp_3 = bVar.a("method-execution", bVar.b("1", "setUnknown1", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "unknown1", "", "void"), 46);
        ajc$tjp_4 = bVar.a("method-execution", bVar.b("1", "getSampleSize", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "int"), 50);
        ajc$tjp_5 = bVar.a("method-execution", bVar.b("1", "setSampleSize", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "sampleSize", "", "void"), 54);
        ajc$tjp_6 = bVar.a("method-execution", bVar.b("1", "getHistoryMult", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "int"), 58);
        ajc$tjp_7 = bVar.a("method-execution", bVar.b("1", "setHistoryMult", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "historyMult", "", "void"), 62);
        ajc$tjp_8 = bVar.a("method-execution", bVar.b("1", "getInitialHistory", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "int"), 66);
        ajc$tjp_9 = bVar.a("method-execution", bVar.b("1", "setInitialHistory", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "initialHistory", "", "void"), 70);
    }

    public long getMaxSamplePerFrame() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.maxSamplePerFrame;
    }

    public void setMaxSamplePerFrame(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this, org.aspectj.a.a.a.EI(i)));
        this.maxSamplePerFrame = i;
    }

    public int getUnknown1() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this));
        return this.unknown1;
    }

    public void setUnknown1(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this, org.aspectj.a.a.a.EI(i)));
        this.unknown1 = i;
    }

    public int getSampleSize() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_4, this, this));
        return this.sampleSize;
    }

    public void setSampleSize(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_5, this, this, org.aspectj.a.a.a.EI(i)));
        this.sampleSize = i;
    }

    public int getHistoryMult() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_6, this, this));
        return this.historyMult;
    }

    public void setHistoryMult(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_7, this, this, org.aspectj.a.a.a.EI(i)));
        this.historyMult = i;
    }

    public int getInitialHistory() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_8, this, this));
        return this.initialHistory;
    }

    public void setInitialHistory(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_9, this, this, org.aspectj.a.a.a.EI(i)));
        this.initialHistory = i;
    }

    public int getKModifier() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_10, this, this));
        return this.kModifier;
    }

    public void setKModifier(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_11, this, this, org.aspectj.a.a.a.EI(i)));
        this.kModifier = i;
    }

    public int getChannels() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_12, this, this));
        return this.channels;
    }

    public void setChannels(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_13, this, this, org.aspectj.a.a.a.EI(i)));
        this.channels = i;
    }

    public int getUnknown2() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_14, this, this));
        return this.unknown2;
    }

    public void setUnknown2(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_15, this, this, org.aspectj.a.a.a.EI(i)));
        this.unknown2 = i;
    }

    public long getMaxCodedFrameSize() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_16, this, this));
        return this.maxCodedFrameSize;
    }

    public void setMaxCodedFrameSize(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_17, this, this, org.aspectj.a.a.a.EI(i)));
        this.maxCodedFrameSize = i;
    }

    public long getBitRate() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_18, this, this));
        return this.bitRate;
    }

    public void setBitRate(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_19, this, this, org.aspectj.a.a.a.EI(i)));
        this.bitRate = i;
    }

    public long getSampleRate() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_20, this, this));
        return this.sampleRate;
    }

    public void setSampleRate(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_21, this, this, org.aspectj.a.a.a.EI(i)));
        this.sampleRate = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.maxSamplePerFrame = IsoTypeReader.readUInt32(byteBuffer);
        this.unknown1 = IsoTypeReader.readUInt8(byteBuffer);
        this.sampleSize = IsoTypeReader.readUInt8(byteBuffer);
        this.historyMult = IsoTypeReader.readUInt8(byteBuffer);
        this.initialHistory = IsoTypeReader.readUInt8(byteBuffer);
        this.kModifier = IsoTypeReader.readUInt8(byteBuffer);
        this.channels = IsoTypeReader.readUInt8(byteBuffer);
        this.unknown2 = IsoTypeReader.readUInt16(byteBuffer);
        this.maxCodedFrameSize = IsoTypeReader.readUInt32(byteBuffer);
        this.bitRate = IsoTypeReader.readUInt32(byteBuffer);
        this.sampleRate = IsoTypeReader.readUInt32(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeUInt32(byteBuffer, this.maxSamplePerFrame);
        IsoTypeWriter.writeUInt8(byteBuffer, this.unknown1);
        IsoTypeWriter.writeUInt8(byteBuffer, this.sampleSize);
        IsoTypeWriter.writeUInt8(byteBuffer, this.historyMult);
        IsoTypeWriter.writeUInt8(byteBuffer, this.initialHistory);
        IsoTypeWriter.writeUInt8(byteBuffer, this.kModifier);
        IsoTypeWriter.writeUInt8(byteBuffer, this.channels);
        IsoTypeWriter.writeUInt16(byteBuffer, this.unknown2);
        IsoTypeWriter.writeUInt32(byteBuffer, this.maxCodedFrameSize);
        IsoTypeWriter.writeUInt32(byteBuffer, this.bitRate);
        IsoTypeWriter.writeUInt32(byteBuffer, this.sampleRate);
    }

    public AppleLosslessSpecificBox() {
        super("alac");
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 28L;
    }
}
