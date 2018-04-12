package com.googlecode.mp4parser.boxes.apple;

import android.support.v4.media.TransportMediator;
import com.baidu.tbadk.BaseActivity;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.boxes.sampleentry.SampleEntry;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes2.dex */
public class TimeCodeBox extends AbstractBox implements SampleEntry {
    public static final String TYPE = "tmcd";
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_10 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_11 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_12 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_13 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_14 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_15 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_16 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_6 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_7 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_8 = null;
    private static final /* synthetic */ a.InterfaceC0278a ajc$tjp_9 = null;
    int dataReferenceIndex;
    long flags;
    int frameDuration;
    int numberOfFrames;
    int reserved1;
    int reserved2;
    byte[] rest;
    int timeScale;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("TimeCodeBox.java", TimeCodeBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.b("1", "getDataReferenceIndex", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 81);
        ajc$tjp_1 = bVar.a("method-execution", bVar.b("1", "setDataReferenceIndex", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "int", "dataReferenceIndex", "", "void"), 85);
        ajc$tjp_10 = bVar.a("method-execution", bVar.b("1", "setReserved1", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "int", "reserved1", "", "void"), TransportMediator.KEYCODE_MEDIA_RECORD);
        ajc$tjp_11 = bVar.a("method-execution", bVar.b("1", "getReserved2", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 134);
        ajc$tjp_12 = bVar.a("method-execution", bVar.b("1", "setReserved2", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "int", "reserved2", "", "void"), 138);
        ajc$tjp_13 = bVar.a("method-execution", bVar.b("1", "getFlags", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "long"), 142);
        ajc$tjp_14 = bVar.a("method-execution", bVar.b("1", "setFlags", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "long", "flags", "", "void"), 146);
        ajc$tjp_15 = bVar.a("method-execution", bVar.b("1", "getRest", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "[B"), BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        ajc$tjp_16 = bVar.a("method-execution", bVar.b("1", "setRest", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "[B", "rest", "", "void"), 154);
        ajc$tjp_2 = bVar.a("method-execution", bVar.b("1", "toString", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "java.lang.String"), 91);
        ajc$tjp_3 = bVar.a("method-execution", bVar.b("1", "getTimeScale", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 102);
        ajc$tjp_4 = bVar.a("method-execution", bVar.b("1", "setTimeScale", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "int", "timeScale", "", "void"), 106);
        ajc$tjp_5 = bVar.a("method-execution", bVar.b("1", "getFrameDuration", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 110);
        ajc$tjp_6 = bVar.a("method-execution", bVar.b("1", "setFrameDuration", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "int", "frameDuration", "", "void"), 114);
        ajc$tjp_7 = bVar.a("method-execution", bVar.b("1", "getNumberOfFrames", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 118);
        ajc$tjp_8 = bVar.a("method-execution", bVar.b("1", "setNumberOfFrames", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "int", "numberOfFrames", "", "void"), 122);
        ajc$tjp_9 = bVar.a("method-execution", bVar.b("1", "getReserved1", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), TransportMediator.KEYCODE_MEDIA_PLAY);
    }

    public TimeCodeBox() {
        super(TYPE);
        this.rest = new byte[0];
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return this.rest.length + 28;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
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
    protected void _parseDetails(ByteBuffer byteBuffer) {
        byteBuffer.position(6);
        this.dataReferenceIndex = IsoTypeReader.readUInt16(byteBuffer);
        this.reserved1 = byteBuffer.getInt();
        this.flags = IsoTypeReader.readUInt32(byteBuffer);
        this.timeScale = byteBuffer.getInt();
        this.frameDuration = byteBuffer.getInt();
        this.numberOfFrames = IsoTypeReader.readUInt8(byteBuffer);
        this.reserved2 = IsoTypeReader.readUInt24(byteBuffer);
        this.rest = new byte[byteBuffer.remaining()];
        byteBuffer.get(this.rest);
    }

    @Override // com.coremedia.iso.boxes.sampleentry.SampleEntry
    public int getDataReferenceIndex() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.dataReferenceIndex;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.SampleEntry
    public void setDataReferenceIndex(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this, org.aspectj.a.a.a.wl(i)));
        this.dataReferenceIndex = i;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this));
        return "TimeCodeBox{timeScale=" + this.timeScale + ", frameDuration=" + this.frameDuration + ", numberOfFrames=" + this.numberOfFrames + ", reserved1=" + this.reserved1 + ", reserved2=" + this.reserved2 + ", flags=" + this.flags + '}';
    }

    public int getTimeScale() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this));
        return this.timeScale;
    }

    public void setTimeScale(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_4, this, this, org.aspectj.a.a.a.wl(i)));
        this.timeScale = i;
    }

    public int getFrameDuration() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_5, this, this));
        return this.frameDuration;
    }

    public void setFrameDuration(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_6, this, this, org.aspectj.a.a.a.wl(i)));
        this.frameDuration = i;
    }

    public int getNumberOfFrames() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_7, this, this));
        return this.numberOfFrames;
    }

    public void setNumberOfFrames(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_8, this, this, org.aspectj.a.a.a.wl(i)));
        this.numberOfFrames = i;
    }

    public int getReserved1() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_9, this, this));
        return this.reserved1;
    }

    public void setReserved1(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_10, this, this, org.aspectj.a.a.a.wl(i)));
        this.reserved1 = i;
    }

    public int getReserved2() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_11, this, this));
        return this.reserved2;
    }

    public void setReserved2(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_12, this, this, org.aspectj.a.a.a.wl(i)));
        this.reserved2 = i;
    }

    public long getFlags() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_13, this, this));
        return this.flags;
    }

    public void setFlags(long j) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_14, this, this, org.aspectj.a.a.a.dE(j)));
        this.flags = j;
    }

    public byte[] getRest() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_15, this, this));
        return this.rest;
    }

    public void setRest(byte[] bArr) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_16, this, this, bArr));
        this.rest = bArr;
    }
}
