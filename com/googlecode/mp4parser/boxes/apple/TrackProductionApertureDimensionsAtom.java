package com.googlecode.mp4parser.boxes.apple;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes3.dex */
public class TrackProductionApertureDimensionsAtom extends AbstractFullBox {
    public static final String TYPE = "prof";
    private static final /* synthetic */ a.InterfaceC1298a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC1298a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC1298a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC1298a ajc$tjp_3 = null;
    double height;
    double width;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("TrackProductionApertureDimensionsAtom.java", TrackProductionApertureDimensionsAtom.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.d("1", "getWidth", "com.googlecode.mp4parser.boxes.apple.TrackProductionApertureDimensionsAtom", "", "", "", "double"), 44);
        ajc$tjp_1 = bVar.a("method-execution", bVar.d("1", "setWidth", "com.googlecode.mp4parser.boxes.apple.TrackProductionApertureDimensionsAtom", "double", "width", "", "void"), 48);
        ajc$tjp_2 = bVar.a("method-execution", bVar.d("1", "getHeight", "com.googlecode.mp4parser.boxes.apple.TrackProductionApertureDimensionsAtom", "", "", "", "double"), 52);
        ajc$tjp_3 = bVar.a("method-execution", bVar.d("1", "setHeight", "com.googlecode.mp4parser.boxes.apple.TrackProductionApertureDimensionsAtom", "double", "height", "", "void"), 56);
    }

    public TrackProductionApertureDimensionsAtom() {
        super(TYPE);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 12L;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.width);
        IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.height);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.width = IsoTypeReader.readFixedPoint1616(byteBuffer);
        this.height = IsoTypeReader.readFixedPoint1616(byteBuffer);
    }

    public double getWidth() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.width;
    }

    public void setWidth(double d) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this, org.aspectj.a.a.a.M(d)));
        this.width = d;
    }

    public double getHeight() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this));
        return this.height;
    }

    public void setHeight(double d) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this, org.aspectj.a.a.a.M(d)));
        this.height = d;
    }
}
