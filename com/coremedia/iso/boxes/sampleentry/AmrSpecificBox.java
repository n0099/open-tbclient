package com.coremedia.iso.boxes.sampleentry;

import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import g.a.a.a;
import g.a.b.b.b;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class AmrSpecificBox extends AbstractBox {
    public static final String TYPE = "damr";
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_0 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_1 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_2 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_3 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_4 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_5 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_6 = null;
    public int decoderVersion;
    public int framesPerSample;
    public int modeChangePeriod;
    public int modeSet;
    public String vendor;

    static {
        ajc$preClinit();
    }

    public AmrSpecificBox() {
        super(TYPE);
    }

    public static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("AmrSpecificBox.java", AmrSpecificBox.class);
        ajc$tjp_0 = bVar.g("method-execution", bVar.f("1", "getVendor", "com.coremedia.iso.boxes.sampleentry.AmrSpecificBox", "", "", "", "java.lang.String"), 46);
        ajc$tjp_1 = bVar.g("method-execution", bVar.f("1", "getDecoderVersion", "com.coremedia.iso.boxes.sampleentry.AmrSpecificBox", "", "", "", "int"), 50);
        ajc$tjp_2 = bVar.g("method-execution", bVar.f("1", "getModeSet", "com.coremedia.iso.boxes.sampleentry.AmrSpecificBox", "", "", "", "int"), 54);
        ajc$tjp_3 = bVar.g("method-execution", bVar.f("1", "getModeChangePeriod", "com.coremedia.iso.boxes.sampleentry.AmrSpecificBox", "", "", "", "int"), 58);
        ajc$tjp_4 = bVar.g("method-execution", bVar.f("1", "getFramesPerSample", "com.coremedia.iso.boxes.sampleentry.AmrSpecificBox", "", "", "", "int"), 62);
        ajc$tjp_5 = bVar.g("method-execution", bVar.f("1", "getContent", "com.coremedia.iso.boxes.sampleentry.AmrSpecificBox", "java.nio.ByteBuffer", "byteBuffer", "", "void"), 84);
        ajc$tjp_6 = bVar.g("method-execution", bVar.f("1", "toString", "com.coremedia.iso.boxes.sampleentry.AmrSpecificBox", "", "", "", "java.lang.String"), 92);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        this.vendor = IsoFile.bytesToFourCC(bArr);
        this.decoderVersion = IsoTypeReader.readUInt8(byteBuffer);
        this.modeSet = IsoTypeReader.readUInt16(byteBuffer);
        this.modeChangePeriod = IsoTypeReader.readUInt8(byteBuffer);
        this.framesPerSample = IsoTypeReader.readUInt8(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_5, this, this, byteBuffer));
        byteBuffer.put(IsoFile.fourCCtoBytes(this.vendor));
        IsoTypeWriter.writeUInt8(byteBuffer, this.decoderVersion);
        IsoTypeWriter.writeUInt16(byteBuffer, this.modeSet);
        IsoTypeWriter.writeUInt8(byteBuffer, this.modeChangePeriod);
        IsoTypeWriter.writeUInt8(byteBuffer, this.framesPerSample);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        return 9L;
    }

    public int getDecoderVersion() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_1, this, this));
        return this.decoderVersion;
    }

    public int getFramesPerSample() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        return this.framesPerSample;
    }

    public int getModeChangePeriod() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_3, this, this));
        return this.modeChangePeriod;
    }

    public int getModeSet() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return this.modeSet;
    }

    public String getVendor() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.vendor;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_6, this, this));
        return "AmrSpecificBox[vendor=" + getVendor() + ";decoderVersion=" + getDecoderVersion() + ";modeSet=" + getModeSet() + ";modeChangePeriod=" + getModeChangePeriod() + ";framesPerSample=" + getFramesPerSample() + "]";
    }
}
