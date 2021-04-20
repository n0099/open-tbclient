package com.googlecode.mp4parser.boxes.apple;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import g.a.a.a;
import g.a.b.b.b;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class TrackEncodedPixelsDimensionsAtom extends AbstractFullBox {
    public static final String TYPE = "enof";
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_0 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_1 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_2 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_3 = null;
    public double height;
    public double width;

    static {
        ajc$preClinit();
    }

    public TrackEncodedPixelsDimensionsAtom() {
        super(TYPE);
    }

    public static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("TrackEncodedPixelsDimensionsAtom.java", TrackEncodedPixelsDimensionsAtom.class);
        ajc$tjp_0 = bVar.g("method-execution", bVar.f("1", "getWidth", "com.googlecode.mp4parser.boxes.apple.TrackEncodedPixelsDimensionsAtom", "", "", "", "double"), 44);
        ajc$tjp_1 = bVar.g("method-execution", bVar.f("1", "setWidth", "com.googlecode.mp4parser.boxes.apple.TrackEncodedPixelsDimensionsAtom", "double", "width", "", "void"), 48);
        ajc$tjp_2 = bVar.g("method-execution", bVar.f("1", "getHeight", "com.googlecode.mp4parser.boxes.apple.TrackEncodedPixelsDimensionsAtom", "", "", "", "double"), 52);
        ajc$tjp_3 = bVar.g("method-execution", bVar.f("1", "setHeight", "com.googlecode.mp4parser.boxes.apple.TrackEncodedPixelsDimensionsAtom", "double", "height", "", "void"), 56);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.width = IsoTypeReader.readFixedPoint1616(byteBuffer);
        this.height = IsoTypeReader.readFixedPoint1616(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.width);
        IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.height);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        return 12L;
    }

    public double getHeight() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return this.height;
    }

    public double getWidth() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.width;
    }

    public void setHeight(double d2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_3, this, this, g.a.b.a.a.c(d2)));
        this.height = d2;
    }

    public void setWidth(double d2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, g.a.b.a.a.c(d2)));
        this.width = d2;
    }
}
