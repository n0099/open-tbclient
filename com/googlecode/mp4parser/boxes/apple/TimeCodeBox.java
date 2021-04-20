package com.googlecode.mp4parser.boxes.apple;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.boxes.sampleentry.SampleEntry;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import g.a.a.a;
import g.a.b.b.b;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class TimeCodeBox extends AbstractBox implements SampleEntry {
    public static final String TYPE = "tmcd";
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_0 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_1 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_10 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_11 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_12 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_13 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_14 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_15 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_16 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_2 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_3 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_4 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_5 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_6 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_7 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_8 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_9 = null;
    public int dataReferenceIndex;
    public long flags;
    public int frameDuration;
    public int numberOfFrames;
    public int reserved1;
    public int reserved2;
    public byte[] rest;
    public int timeScale;

    static {
        ajc$preClinit();
    }

    public TimeCodeBox() {
        super(TYPE);
        this.rest = new byte[0];
    }

    public static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("TimeCodeBox.java", TimeCodeBox.class);
        ajc$tjp_0 = bVar.g("method-execution", bVar.f("1", "getDataReferenceIndex", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 81);
        ajc$tjp_1 = bVar.g("method-execution", bVar.f("1", "setDataReferenceIndex", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "int", "dataReferenceIndex", "", "void"), 85);
        ajc$tjp_10 = bVar.g("method-execution", bVar.f("1", "setReserved1", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "int", "reserved1", "", "void"), IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
        ajc$tjp_11 = bVar.g("method-execution", bVar.f("1", "getReserved2", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 134);
        ajc$tjp_12 = bVar.g("method-execution", bVar.f("1", "setReserved2", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "int", "reserved2", "", "void"), 138);
        ajc$tjp_13 = bVar.g("method-execution", bVar.f("1", "getFlags", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "long"), 142);
        ajc$tjp_14 = bVar.g("method-execution", bVar.f("1", "setFlags", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "long", "flags", "", "void"), 146);
        ajc$tjp_15 = bVar.g("method-execution", bVar.f("1", "getRest", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "[B"), 150);
        ajc$tjp_16 = bVar.g("method-execution", bVar.f("1", "setRest", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "[B", "rest", "", "void"), Opcodes.IFNE);
        ajc$tjp_2 = bVar.g("method-execution", bVar.f("1", "toString", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "java.lang.String"), 91);
        ajc$tjp_3 = bVar.g("method-execution", bVar.f("1", "getTimeScale", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 102);
        ajc$tjp_4 = bVar.g("method-execution", bVar.f("1", "setTimeScale", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "int", "timeScale", "", "void"), 106);
        ajc$tjp_5 = bVar.g("method-execution", bVar.f("1", "getFrameDuration", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 110);
        ajc$tjp_6 = bVar.g("method-execution", bVar.f("1", "setFrameDuration", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "int", "frameDuration", "", "void"), 114);
        ajc$tjp_7 = bVar.g("method-execution", bVar.f("1", "getNumberOfFrames", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 118);
        ajc$tjp_8 = bVar.g("method-execution", bVar.f("1", "setNumberOfFrames", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "int", "numberOfFrames", "", "void"), 122);
        ajc$tjp_9 = bVar.g("method-execution", bVar.f("1", "getReserved1", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 126);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        byteBuffer.position(6);
        this.dataReferenceIndex = IsoTypeReader.readUInt16(byteBuffer);
        this.reserved1 = byteBuffer.getInt();
        this.flags = IsoTypeReader.readUInt32(byteBuffer);
        this.timeScale = byteBuffer.getInt();
        this.frameDuration = byteBuffer.getInt();
        this.numberOfFrames = IsoTypeReader.readUInt8(byteBuffer);
        this.reserved2 = IsoTypeReader.readUInt24(byteBuffer);
        byte[] bArr = new byte[byteBuffer.remaining()];
        this.rest = bArr;
        byteBuffer.get(bArr);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        byteBuffer.put(new byte[6]);
        IsoTypeWriter.writeUInt16(byteBuffer, this.dataReferenceIndex);
        byteBuffer.putInt(this.reserved1);
        IsoTypeWriter.writeUInt32(byteBuffer, this.flags);
        byteBuffer.putInt(this.timeScale);
        byteBuffer.putInt(this.frameDuration);
        IsoTypeWriter.writeUInt8(byteBuffer, this.numberOfFrames);
        IsoTypeWriter.writeUInt24(byteBuffer, this.reserved2);
        byteBuffer.put(this.rest);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        return this.rest.length + 28;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.SampleEntry
    public int getDataReferenceIndex() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.dataReferenceIndex;
    }

    public long getFlags() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_13, this, this));
        return this.flags;
    }

    public int getFrameDuration() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_5, this, this));
        return this.frameDuration;
    }

    public int getNumberOfFrames() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_7, this, this));
        return this.numberOfFrames;
    }

    public int getReserved1() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_9, this, this));
        return this.reserved1;
    }

    public int getReserved2() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_11, this, this));
        return this.reserved2;
    }

    public byte[] getRest() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_15, this, this));
        return this.rest;
    }

    public int getTimeScale() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_3, this, this));
        return this.timeScale;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.SampleEntry
    public void setDataReferenceIndex(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, g.a.b.a.a.e(i)));
        this.dataReferenceIndex = i;
    }

    public void setFlags(long j) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_14, this, this, g.a.b.a.a.f(j)));
        this.flags = j;
    }

    public void setFrameDuration(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_6, this, this, g.a.b.a.a.e(i)));
        this.frameDuration = i;
    }

    public void setNumberOfFrames(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_8, this, this, g.a.b.a.a.e(i)));
        this.numberOfFrames = i;
    }

    public void setReserved1(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_10, this, this, g.a.b.a.a.e(i)));
        this.reserved1 = i;
    }

    public void setReserved2(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_12, this, this, g.a.b.a.a.e(i)));
        this.reserved2 = i;
    }

    public void setRest(byte[] bArr) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_16, this, this, bArr));
        this.rest = bArr;
    }

    public void setTimeScale(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_4, this, this, g.a.b.a.a.e(i)));
        this.timeScale = i;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return "TimeCodeBox{timeScale=" + this.timeScale + ", frameDuration=" + this.frameDuration + ", numberOfFrames=" + this.numberOfFrames + ", reserved1=" + this.reserved1 + ", reserved2=" + this.reserved2 + ", flags=" + this.flags + '}';
    }
}
