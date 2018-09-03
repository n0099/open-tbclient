package com.coremedia.iso.boxes;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes2.dex */
public final class OmaDrmAccessUnitFormatBox extends AbstractFullBox {
    public static final String TYPE = "odaf";
    private static final /* synthetic */ a.InterfaceC0298a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0298a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0298a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0298a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0298a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0298a ajc$tjp_5 = null;
    private byte allBits;
    private int initVectorLength;
    private int keyIndicatorLength;
    private boolean selectiveEncryption;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("OmaDrmAccessUnitFormatBox.java", OmaDrmAccessUnitFormatBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.b("1", "isSelectiveEncryption", "com.coremedia.iso.boxes.OmaDrmAccessUnitFormatBox", "", "", "", "boolean"), 46);
        ajc$tjp_1 = bVar.a("method-execution", bVar.b("1", "getKeyIndicatorLength", "com.coremedia.iso.boxes.OmaDrmAccessUnitFormatBox", "", "", "", "int"), 50);
        ajc$tjp_2 = bVar.a("method-execution", bVar.b("1", "getInitVectorLength", "com.coremedia.iso.boxes.OmaDrmAccessUnitFormatBox", "", "", "", "int"), 54);
        ajc$tjp_3 = bVar.a("method-execution", bVar.b("1", "setInitVectorLength", "com.coremedia.iso.boxes.OmaDrmAccessUnitFormatBox", "int", "initVectorLength", "", "void"), 58);
        ajc$tjp_4 = bVar.a("method-execution", bVar.b("1", "setKeyIndicatorLength", "com.coremedia.iso.boxes.OmaDrmAccessUnitFormatBox", "int", "keyIndicatorLength", "", "void"), 62);
        ajc$tjp_5 = bVar.a("method-execution", bVar.b("1", "setAllBits", "com.coremedia.iso.boxes.OmaDrmAccessUnitFormatBox", "byte", "allBits", "", "void"), 66);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 7L;
    }

    public OmaDrmAccessUnitFormatBox() {
        super(TYPE);
    }

    public boolean isSelectiveEncryption() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.selectiveEncryption;
    }

    public int getKeyIndicatorLength() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this));
        return this.keyIndicatorLength;
    }

    public int getInitVectorLength() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this));
        return this.initVectorLength;
    }

    public void setInitVectorLength(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this, org.aspectj.a.a.a.wa(i)));
        this.initVectorLength = i;
    }

    public void setKeyIndicatorLength(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_4, this, this, org.aspectj.a.a.a.wa(i)));
        this.keyIndicatorLength = i;
    }

    public void setAllBits(byte b) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_5, this, this, org.aspectj.a.a.a.c(b)));
        this.allBits = b;
        this.selectiveEncryption = (b & 128) == 128;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.allBits = (byte) IsoTypeReader.readUInt8(byteBuffer);
        this.selectiveEncryption = (this.allBits & 128) == 128;
        this.keyIndicatorLength = IsoTypeReader.readUInt8(byteBuffer);
        this.initVectorLength = IsoTypeReader.readUInt8(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeUInt8(byteBuffer, this.allBits);
        IsoTypeWriter.writeUInt8(byteBuffer, this.keyIndicatorLength);
        IsoTypeWriter.writeUInt8(byteBuffer, this.initVectorLength);
    }
}
